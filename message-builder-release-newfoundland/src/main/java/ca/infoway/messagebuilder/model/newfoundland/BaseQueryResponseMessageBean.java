/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.model.newfoundland;

import java.util.List;

import ca.infoway.messagebuilder.datatype.lang.Identifier;

public interface BaseQueryResponseMessageBean<T extends QueryCriteria, R> extends ResponseMessageBean {

    public Identifier getQueryId();

    public void setQueryId(Identifier queryId);

    public T getCriteria();

    public QueryResultsSummaryBean getQuerySummary();

    public List<R> getRecords();

    public List<RecordBean<R>> getQueryRecords();
}
