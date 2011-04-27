/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public class QueryResponseControlActEventBean<Q extends QueryCriteria, R> extends QueryControlActEventBean<Q> implements Serializable {

    private static final long serialVersionUID = 8777593913935425109L;

    private final List<RecordBean<R>> queryRecords = Collections.synchronizedList(new ArrayList<RecordBean<R>>());

    private QueryResultsSummaryBean queryResultsSummary = new QueryResultsSummaryBean();

    public QueryResponseControlActEventBean(Q criteria) {
        super(criteria);
    }

    @Hl7XmlMapping("subject")
    public List<RecordBean<R>> getQueryRecords() {
        return this.queryRecords;
    }

    public List<R> getRecords() {
        List<R> records = new ArrayList<R>();
        for (RecordBean<R> queryRecordBean : getQueryRecords()) {
            records.add(queryRecordBean.getRecord());
        }
        return Collections.unmodifiableList(records);
    }

    @Hl7XmlMapping("queryAck")
    public QueryResultsSummaryBean getQueryResultsSummary() {
        return queryResultsSummary;
    }

    public void setQueryResultsSummary(QueryResultsSummaryBean queryResultsSummary) {
        this.queryResultsSummary = queryResultsSummary;
    }
}
