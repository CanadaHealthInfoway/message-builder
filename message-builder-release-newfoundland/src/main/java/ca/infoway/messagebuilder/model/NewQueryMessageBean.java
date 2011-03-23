package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

public abstract class NewQueryMessageBean<Q extends QueryCriteria> extends NewBaseMessageBean implements BaseQueryMessageBean<Q> {

    private static final long serialVersionUID = 3941752675494132716L;

    @Hl7BusinessName("controlActEvent")
    private final QueryControlActEventBean<Q> controlActEventBean;

    public NewQueryMessageBean(Q criteria) {
        this.controlActEventBean = new QueryControlActEventBean<Q>(criteria);
    }

    public QueryControlActEventBean<Q> getControlActEvent() {
        return controlActEventBean;
    }

    @Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public final QueryControlActEventBean<Q> getControlActEventBean() {
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
}
