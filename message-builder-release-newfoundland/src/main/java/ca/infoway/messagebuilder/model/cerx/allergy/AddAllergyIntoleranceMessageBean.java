package ca.infoway.messagebuilder.model.cerx.allergy;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("REPC_IN000012CA")
public class AddAllergyIntoleranceMessageBean extends RecordRequestMessageBean<AllergyIntoleranceBean> implements HasTargetReference<AddAllergyIntoleranceMessageBean> {

    private static final long serialVersionUID = 8231859928712790183L;

    public AddAllergyIntoleranceMessageBean getTargetReference() {
        return this;
    }
}
