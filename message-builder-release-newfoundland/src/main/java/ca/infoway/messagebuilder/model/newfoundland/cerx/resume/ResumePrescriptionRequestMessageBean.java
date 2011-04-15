package ca.infoway.messagebuilder.model.newfoundland.cerx.resume;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN010520CA")
public class ResumePrescriptionRequestMessageBean extends RecordRequestMessageBean<ActRequestBean> implements HasTargetReference<ActRequestBean> {

    private static final long serialVersionUID = 6875196521115880233L;

    public ActRequestBean getTargetReference() {
        return getControlActEvent().getRecord();
    }
}
