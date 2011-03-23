package ca.infoway.messagebuilder.model;

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
