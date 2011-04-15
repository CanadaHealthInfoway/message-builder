package ca.infoway.messagebuilder.model.newfoundland.cerx.allergy;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("REPC_IN000020CA")
public class UpdateAllergyIntoleranceMessageBean extends RecordRequestMessageBean<AllergyIntoleranceBean> implements HasTargetReference<UpdateAllergyIntoleranceMessageBean> {

    private static final long serialVersionUID = 4996109384301163324L;

    public UpdateAllergyIntoleranceMessageBean getTargetReference() {
        return this;
    }
}
