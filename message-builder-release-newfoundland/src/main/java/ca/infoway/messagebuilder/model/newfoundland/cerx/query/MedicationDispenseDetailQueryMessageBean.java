package ca.infoway.messagebuilder.model.newfoundland.cerx.query;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060210CA")
public class MedicationDispenseDetailQueryMessageBean extends NewQueryMessageBean<MedicationDispenseDetailQueryCriteriaBean> {

    private static final long serialVersionUID = 6567883546388299218L;

    public MedicationDispenseDetailQueryMessageBean() {
        this(new MedicationDispenseDetailQueryCriteriaBean());
    }

    public MedicationDispenseDetailQueryMessageBean(MedicationDispenseDetailQueryCriteriaBean criteria) {
        super(criteria);
    }
}
