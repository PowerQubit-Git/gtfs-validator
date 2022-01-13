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
import org.mobilitydata.gtfsvalidator.table.*;

import java.time.ZoneId;

@GtfsTable("stops.txt")
@Required
public interface GtfsStopSchema extends GtfsEntity {
  @FieldType(FieldTypeEnum.ID)
  @PrimaryKey
  @Required
  String stopId();

  @FieldType(FieldTypeEnum.ID)
  @ConditionallyRequired
  String stop_id_stepp();

  @ConditionallyRequired
  String stopCode();

  @Required
  String stopName();

  @ConditionallyRequired
  String stopDesc();

  @ConditionallyRequired
  String stop_remarks();

  @FieldType(FieldTypeEnum.LATITUDE)
  @Required
  double stopLat();

  @FieldType(FieldTypeEnum.LONGITUDE)
  @Required
  double stopLon();

  @ConditionallyRequired
  GtfsZoneShift zone_shift();

  @ConditionallyRequired
  GtfsLocationType locationType();

  @FieldType(FieldTypeEnum.ID)
  @Index
  @ConditionallyRequired
  @ForeignKey(table = "stops.txt", field = "stop_id")
  String parentStation();

  @ConditionallyRequired
  GtfsWheelchairBoarding wheelchairBoarding();

  @ConditionallyRequired
  String platformCode();


  @ConditionallyRequired
  GtfsEntranceRestriction entranceRestriction();

  @ConditionallyRequired
  GtfsExitRestriction exitRestriction();

  @ConditionallyRequired
  GtfsSlot slot();

  @ConditionallyRequired
  GtfsSignalling signalling();

  @ConditionallyRequired
  GtfsShelter shelter();

  @ConditionallyRequired
  GtfsBench bench();

  @ConditionallyRequired
  GtfsNetworkMap networkMap();

  @ConditionallyRequired
  GtfsSchedule schedule();

  @ConditionallyRequired
  GtfsRealTimeInformation realTimeInformation();

  @ConditionallyRequired
  GtfsTariff tariff();

  @ConditionallyRequired
  GtfsPreservationState preservationState();

  @ConditionallyRequired
  String equipment();

  @ConditionallyRequired
  String observations();

  @Required
  String region();

  @Required
  GtfsMunicipality municipality();

  @ConditionallyRequired
  GtfsMunicipalityFare1 municipalityFare1();

  @ConditionallyRequired
  GtfsMunicipalityFare2 municipalityFare2();

}
