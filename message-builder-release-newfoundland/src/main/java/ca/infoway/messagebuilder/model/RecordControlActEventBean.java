package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public class RecordControlActEventBean<T> extends ControlActEventBean {

    private static final long serialVersionUID = 6512047519951312670L;

    private RecordBean<T> recordBean;

    @Hl7XmlMapping("subject")
    public RecordBean<T> getRecordBean() {
        return recordBean;
    }

    public void setRecordBean(RecordBean<T> recordBean) {
        this.recordBean = recordBean;
    }

    public T getRecord() {
        return this.recordBean == null ? null : this.recordBean.getRecord();
    }
}
