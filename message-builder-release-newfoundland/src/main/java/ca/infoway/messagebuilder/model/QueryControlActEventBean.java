package ca.infoway.messagebuilder.model;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

public class QueryControlActEventBean<Q extends QueryCriteria> extends ControlActEventBean implements Serializable {

    private static final long serialVersionUID = 7409413947816976194L;

    private ConsentEventBean consentEvent;
    private QueryByParameterBean<Q> queryByParameter = new QueryByParameterBean<Q>();

    public QueryControlActEventBean(Q criteria) {
        this.queryByParameter.setParameterList(criteria);
    }

    public Q getCriteria() {
        return this.queryByParameter.getParameterList();
    }

    public Identifier getQueryId() {
        return this.queryByParameter.getQueryIdentifier();
    }

    public void setQueryId(Identifier queryId) {
    	this.queryByParameter.setQueryIdentifier(queryId);
    }

    public Integer getQueryLimit() {
        return this.queryByParameter.getQueryLimit();
    }

    public void setQueryLimit(Integer queryLimit) {
        this.queryByParameter.setQueryLimit(queryLimit);
    }

    @Hl7XmlMapping("subjectOf2/consentEvent")
    public ConsentEventBean getConsentEvent() {
        return consentEvent;
    }

    public void setConsentEvent(ConsentEventBean consentEvent) {
        this.consentEvent = consentEvent;
    }

    @Hl7XmlMapping("queryByParameter")
	public QueryByParameterBean<Q> getQueryByParameter() {
		return this.queryByParameter;
	}

	public void setQueryByParameter(QueryByParameterBean<Q> queryByParameter) {
		this.queryByParameter = queryByParameter;
	}
}
