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

package org.mobilitydata.gtfsvalidator.table;

import com.google.common.collect.ImmutableList;
import org.mobilitydata.gtfsvalidator.parsing.CsvHeader;

import java.util.List;
import java.util.Optional;

/**
 * Container for {@code GtfsEntity} instances for the whole GTFS table, e.g., stops.txt.
 *
 * <p>Its subclasses are generated by annotation processor based on GTFS schema annotations.
 * Instances of the subclasses are created by subclasses of {@code GtfsTableLoader} which are also
 * generated by the processor.
 *
 * @param <T> subclass of {@code GtfsEntity}
 */
public abstract class GtfsTableContainer<T extends GtfsEntity> {

  private final TableStatus tableStatus;

  private final CsvHeader header;

  public GtfsTableContainer(TableStatus tableStatus, CsvHeader header) {
    this.tableStatus = tableStatus;
    this.header = header;
  }

  public TableStatus getTableStatus() {
    return tableStatus;
  }

  public CsvHeader getHeader() {
    return header;
  }

  public abstract Class<T> getEntityClass();

  public int entityCount() {
    return getEntities().size();
  }

  public abstract List<T> getEntities();

  public abstract String gtfsFilename();

  public boolean hasColumn(String columnName) {
    return header.hasColumn(columnName);
  }

  /**
   * Returns names of the columns that are keys in that table.
   *
   * <p>A table may have one, two or no primary keys, so the returned list contains from 0 to 2
   * items.
   *
   * <p>The first returned key (if present) is annotated with {@link
   * org.mobilitydata.gtfsvalidator.annotation.PrimaryKey} or {@link
   * org.mobilitydata.gtfsvalidator.annotation.FirstKey}.
   *
   * <p>The second returned key (if present) is annotated with {@link
   * org.mobilitydata.gtfsvalidator.annotation.SequenceKey}.
   */
  public abstract ImmutableList<String> getKeyColumnNames();

  /**
   * Finds an entity with the given primary key.
   *
   * <p>Depending on table, a primary key may contain:
   *
   * <ul>
   *   <li>no items, e.g., {@code feed_info.txt} has a single entity;
   *   <li>one item, e.g., {@code stops.txt} has primary key {@code stop_id};
   *   <li>two items, e.g., {@code stop_times.txt} has composite key {@code trip_id, stop_sequence}.
   * </ul>
   *
   * Note that all keys must be passed as strings, so a key for {@code stop_times.txt} will look
   * like {"stop1", "0"}.
   *
   * @param id primary key or first part of the composite key, if needed
   * @param subId second part of the composite key, if needed
   * @return entity with the given primary key, if any
   */
  public abstract Optional<T> byPrimaryKey(String id, String subId);

  /**
   * Tells if the file is missing.
   *
   * @return true if the file is missing, false otherwise
   */
  public boolean isMissingFile() {
    return tableStatus == TableStatus.MISSING_FILE;
  }

  /**
   * Tells if the file is required according to GTFS.
   *
   * <p>Note that a required file may be empty.
   *
   * @return true if the file is required, false otherwise
   */
  public abstract boolean isRequired();

  /**
   * Tells if the file was successfully parsed.
   *
   * <p>If all files in the feed were successfully parsed, then file validators may be executed.
   *
   * <p>A successfully parsed file must meet the following conditions:
   *
   * <ul>
   *   <li>the file was successfully parsed as CSV;
   *   <li>all headers are valid, required headers are present;
   *   <li>all rows are successfully parsed;
   *   <li>if the file is required, it is present in the feed.
   * </ul>
   *
   * @return true if file was successfully parsed, false otherwise
   */
  public boolean isParsedSuccessfully() {
    switch (tableStatus) {
      case PARSABLE_HEADERS_AND_ROWS:
        return true;
      case MISSING_FILE:
        return !isRequired();
      default:
        return false;
    }
  }

  /**
   * Status of loading this table. This is includes parsing of the CSV file and validation of the
   * single file, but does not include any cross-file validations.
   */
  public enum TableStatus {
    /** The file is completely empty, i.e. it has no rows and even no headers. */
    EMPTY_FILE,

    /** The file is missing in the GTFS feed. */
    MISSING_FILE,

    /** The file was parsed successfully. It has headers and 0, 1 or many rows. */
    PARSABLE_HEADERS_AND_ROWS,

    /**
     * The file has invalid headers, e.g., they failed to parse or some required headers are
     * missing. The other rows were not scanned.
     *
     * <p>Note that unknown headers are not considered invalid.
     */
    INVALID_HEADERS,

    /**
     * Some of the rows failed to parse, e.g., they have missing required fields or invalid field
     * values.
     *
     * <p>However, the headers are valid.
     *
     * <p>This does not include cross-file or cross-row validation. This also does not include
     * single-entity validation.
     */
    UNPARSABLE_ROWS,
  }
}
