package ca.infoway.messagebuilder.model.cerx.refusal;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN010060CA")
public class RecordRefusalToDispenseRequestMessageBean extends RecordRequestMessageBean<ActRequestBean> implements HasTargetReference<ActRequestBean> {

    private static final long serialVersionUID = 6875196521115880233L;

    public ActRequestBean getTargetReference() {
        return getControlActEvent().getRecord();
    }
}
