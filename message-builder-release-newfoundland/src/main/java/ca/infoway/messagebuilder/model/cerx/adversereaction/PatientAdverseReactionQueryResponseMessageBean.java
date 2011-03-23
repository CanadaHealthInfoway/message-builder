package ca.infoway.messagebuilder.model.cerx.adversereaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("REPC_IN000002CA")
public class PatientAdverseReactionQueryResponseMessageBean extends NewQueryResponseMessageBean<PatientAdverseReactionQueryCriteriaBean, AdverseReactionBean> {

    private static final long serialVersionUID = 7165135264265155338L;

    public PatientAdverseReactionQueryResponseMessageBean(ResponseMessageAttributesBean attributes, PatientAdverseReactionQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public PatientAdverseReactionQueryResponseMessageBean(PatientAdverseReactionQueryCriteriaBean criteria) {
        super(criteria);
    }

    public PatientAdverseReactionQueryResponseMessageBean() {
        this(new PatientAdverseReactionQueryCriteriaBean());
    }
}
