/*
 * Copyright 2020 Google LLC
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

package tml.centralapi.validatormain.table;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.GtfsBikesAllowed;
import org.mobilitydata.gtfsvalidator.table.GtfsEntity;
import org.mobilitydata.gtfsvalidator.table.GtfsTripDirectionId;
import org.mobilitydata.gtfsvalidator.table.GtfsWheelchairBoarding;

@GtfsTable("trips.txt")
@Required
public interface GtfsTripSchema extends GtfsEntity {
  @FieldType(FieldTypeEnum.ID)
  @Required
  @ForeignKey(table = "routes.txt", field = "route_id")
  String routeId();

  @FieldType(FieldTypeEnum.ID)
  @Required
  @ForeignKey(table = "calendar.txt", field = "service_id")
  String serviceId();


  @FieldType(FieldTypeEnum.ID)
  @Required
  @PrimaryKey
  String tripId();

  @ConditionallyRequired
  String tripHeadsign();

  @ConditionallyRequired
  GtfsTripDirectionId directionId();

  @FieldType(FieldTypeEnum.ID)
  @ForeignKey(table = "shapes.txt", field = "shape_id")
  @Index
  @Required
  String shapeId();

  @ConditionallyRequired
  GtfsWheelchairBoarding wheelchairAccessible();

  @ConditionallyRequired
  GtfsBikesAllowed bikesAllowed();
}
