package ca.infoway.messagebuilder.model.newfoundland.cerx.refusal;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN010060CA")
public class RecordRefusalToDispenseRequestMessageBean extends RecordRequestMessageBean<ActRequestBean> implements HasTargetReference<ActRequestBean> {

    private static final long serialVersionUID = 6875196521115880233L;

    public ActRequestBean getTargetReference() {
        return getControlActEvent().getRecord();
    }
}
