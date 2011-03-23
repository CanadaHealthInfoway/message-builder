package ca.infoway.messagebuilder.model;

import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

public abstract class NewQueryResponseMessageBean<Q extends QueryCriteria, R> extends NewBaseMessageBean implements BaseQueryResponseMessageBean<Q, R> {

    private static final long serialVersionUID = -637892711521645863L;

    private QueryResponseControlActEventBean<Q, R> controlActEventBean;

    public NewQueryResponseMessageBean(Q criteria) {
        this.messageAttributes = new ResponseMessageAttributesBean();
        this.controlActEventBean = new QueryResponseControlActEventBean<Q, R>(criteria);
    }

    public NewQueryResponseMessageBean(ResponseMessageAttributesBean attributes, Q criteria) {
        this.messageAttributes = attributes;
        this.controlActEventBean = new QueryResponseControlActEventBean<Q, R>(criteria);
    }

    @Override
    public ResponseMessageAttributesBean getMessageAttributes() {
        return (ResponseMessageAttributesBean) this.messageAttributes;
    }

    public void setMessageAttributes(ResponseMessageAttributesBean responseMessageAttributesBean) {
        this.messageAttributes = responseMessageAttributesBean;
    }

    public QueryResponseControlActEventBean<Q, R> getControlActEvent() {
        return controlActEventBean;
    }

    @Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public final QueryResponseControlActEventBean<Q, R> getControlActEventBean() {
        return this.controlActEventBean;
    }

    public AuthorBean getAuthor() {
        return getControlActEvent().getAuthor();
    }

    public Identifier getQueryId() {
        return getControlActEvent().getQueryId();
    }

    public void setQueryId(Identifier queryId) {
        getControlActEvent().setQueryId(queryId);
    }

    public Q getCriteria() {
        return getControlActEvent().getCriteria();
    }

    public QueryResultsSummaryBean getQuerySummary() {
        return getControlActEvent().getQueryResultsSummary();
    }

    public List<R> getRecords() {
        return getControlActEvent().getRecords();
    }

    public List<RecordBean<R>> getQueryRecords() {
        return getControlActEvent().getQueryRecords();
    }

    @Hl7XmlMapping("acknowledgement")
    public AcknowledgementBean getAcknowledgement() {
        return getMessageAttributes().getAcknowledgement();
    }

    public void setAcknowledgement(AcknowledgementBean acknowledgementBean) {
        getMessageAttributes().setAcknowledgement(acknowledgementBean);
    }

    public void clearControlActEvent() {
        this.controlActEventBean = null;
    }
}
