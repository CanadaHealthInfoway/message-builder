package ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("REPC_IN000001CA")
public class PatientAdverseReactionQueryMessageBean extends NewQueryMessageBean<PatientAdverseReactionQueryCriteriaBean> {

    private static final long serialVersionUID = -2868748571293401596L;

    public PatientAdverseReactionQueryMessageBean() {
        this(new PatientAdverseReactionQueryCriteriaBean());
    }

    public PatientAdverseReactionQueryMessageBean(PatientAdverseReactionQueryCriteriaBean patientAdverseReactionQueryCriteriaBean) {
        super(patientAdverseReactionQueryCriteriaBean);
    }
}
