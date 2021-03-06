/*
 * Copyright 2020 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents the metadata of a query stream response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResponseMetadata {

  public final String queryId;
  public final List<String> columnNames;
  public final List<String> columnTypes;

  public QueryResponseMetadata(
      final @JsonProperty(value = "queryId") String queryId,
      final @JsonProperty(value = "columnNames") List<String> columnNames,
      final @JsonProperty(value = "columnTypes") List<String> columnTypes) {
    this.queryId = queryId;
    this.columnNames = Collections.unmodifiableList(Objects.requireNonNull(columnNames));
    this.columnTypes = Collections.unmodifiableList(Objects.requireNonNull(columnTypes));
  }

  public QueryResponseMetadata(final List<String> columnNames, final List<String> columnTypes) {
    this(null, columnNames, columnTypes);
  }

}
