package ca.infoway.messagebuilder.model;

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
