package ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060450CA")
public class OtherMedicationDetailQueryMessageBean extends NewQueryMessageBean<OtherMedicationQueryCriteriaBean> {

    private static final long serialVersionUID = -1859407550764756631L;

    public OtherMedicationDetailQueryMessageBean() {
        super(new OtherMedicationQueryCriteriaBean());
    }
}
