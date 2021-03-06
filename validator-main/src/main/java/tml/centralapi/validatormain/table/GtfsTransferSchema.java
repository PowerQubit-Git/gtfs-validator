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
import org.mobilitydata.gtfsvalidator.table.GtfsEntity;
import org.mobilitydata.gtfsvalidator.table.GtfsTransferType;

import java.time.ZoneId;
import java.util.Locale;

@GtfsTable("transfers.txt")
@ConditionallyRequired
public interface GtfsTransferSchema extends GtfsEntity {

  //OMITTED
  @FieldType(FieldTypeEnum.ID)
  @ForeignKey(table = "stops.txt", field = "stop_id")
  @ConditionallyRequired
  String fromStopId();

  //OMITTED
  @FieldType(FieldTypeEnum.ID)
  @ForeignKey(table = "stops.txt", field = "stop_id")
  @ConditionallyRequired
  String toStopId();

  //OMITTED
  @ConditionallyRequired
  GtfsTransferType transferType();

  //OMITTED
  @NonNegative
  @ConditionallyRequired
  int minTransferTime();

}
