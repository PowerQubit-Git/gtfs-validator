/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tml.centralapi.validatormain.util;

import com.google.common.geometry.S2LatLng;
import org.mobilitydata.gtfsvalidator.table.GtfsLocationType;
import org.mobilitydata.gtfsvalidator.table.GtfsStop;
import org.mobilitydata.gtfsvalidator.table.GtfsStopTableContainer;

import java.util.Optional;

/** Utility functions for {@code stops.txt} */
public class StopUtil {

  /**
   * Returns coordinates of the stop. If they are missing, coordinates of the parent are used.
   *
   * <p>Supports up to 3 levels of location hierarchy: station, stop, boarding area.
   *
   * <p>Returns (0, 0) if no coordinates are found in parent chain.
   */
  public static S2LatLng getStopOrParentLatLng(GtfsStopTableContainer stopTable, String stopId) {
    // Do not do an infinite loop since there may be a data bug and an infinite cycle of parents.
    for (int i = 0; i < 3; ++i) {
      Optional<GtfsStop> optionalLocation = stopTable.byStopId(stopId);
      if (optionalLocation.isEmpty()) {
        break;
      }
      GtfsStop location = optionalLocation.get();
      if (location.hasStopLatLon()) {
        return location.stopLatLon();
      }
      if (location.hasParentStation()) {
        stopId = location.parentStation();
      } else {
        break;
      }
    }
    return S2LatLng.CENTER;
  }

  /**
   * Finds station that the given location belongs to.
   *
   * <p>Returns {@code Optional.empty} if the location does not belong to a station.
   *
   * <p>If the given location is a station, then the function returns it.
   *
   * <p>Supports up to 3 levels of location hierarchy: station, stop, boarding area.
   *
   * @param stopTable stop table container
   * @param stopId {@code stop_id} of the location
   * @return parent or grandparent that is a station or {@code Optional.empty} if there is no such
   *     parent
   */
  public static Optional<GtfsStop> getIncludingStation(
      GtfsStopTableContainer stopTable, String stopId) {
    // Do not do an infinite loop since there may be a data bug and an infinite cycle of parents.
    for (int i = 0; i < 3; ++i) {
      Optional<GtfsStop> optionalLocation = stopTable.byStopId(stopId);
      if (optionalLocation.isEmpty()) {
        break;
      }
      GtfsStop location = optionalLocation.get();
      if (location.locationType().equals(GtfsLocationType.STATION)) {
        return Optional.of(location);
      }
      if (!location.hasParentStation()) {
        break;
      }
      stopId = location.parentStation();
    }
    return Optional.empty();
  }

  private StopUtil() {}
}
