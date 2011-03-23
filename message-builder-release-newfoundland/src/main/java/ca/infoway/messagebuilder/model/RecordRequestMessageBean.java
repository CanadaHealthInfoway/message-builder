package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public abstract class RecordRequestMessageBean<T> extends NewBaseMessageBean {

    private static final long serialVersionUID = -4171299182341789015L;

    private final RecordControlActEventBean<T> controlActEventBean;

    public RecordRequestMessageBean() {
        this.controlActEventBean = new RecordControlActEventBean<T>();
    }

    public RecordRequestMessageBean(RecordControlActEventBean<T> controlActEventBean) {
        this.controlActEventBean = controlActEventBean;
    }

    public RecordControlActEventBean<T> getControlActEvent() {
        return controlActEventBean;
    }

    @Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public final RecordControlActEventBean<T> getControlActEventBean() {
        return this.controlActEventBean;
    }

    public AuthorBean getAuthor() {
        return getControlActEvent().getAuthor();
    }

    public AssignedPersonBean getResponsibleParty() {
        return getControlActEvent().getResponsibleParty();
    }

    public T getRecord() {
        return this.controlActEventBean == null ? null : this.controlActEventBean.getRecord();
    }
}
