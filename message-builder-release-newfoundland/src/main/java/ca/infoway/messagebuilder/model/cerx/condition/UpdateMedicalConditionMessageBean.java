package ca.infoway.messagebuilder.model.cerx.condition;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("REPC_IN000032CA")
public class UpdateMedicalConditionMessageBean extends RecordRequestMessageBean<MedicalConditionBean> implements HasTargetReference<UpdateMedicalConditionMessageBean> {

    private static final long serialVersionUID = 3066705196417392272L;

    public UpdateMedicalConditionMessageBean getTargetReference() {
        return this;
    }
}
