package ca.infoway.messagebuilder.model.newfoundland.cerx.condition;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("REPC_IN000032CA")
public class UpdateMedicalConditionMessageBean extends RecordRequestMessageBean<MedicalConditionBean> implements HasTargetReference<UpdateMedicalConditionMessageBean> {

    private static final long serialVersionUID = 3066705196417392272L;

    public UpdateMedicalConditionMessageBean getTargetReference() {
        return this;
    }
}
