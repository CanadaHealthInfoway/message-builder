package ca.infoway.messagebuilder.model.cerx.condition;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("REPC_IN000023CA")
public class PatientMedicalConditionsQueryMessageBean extends NewQueryMessageBean<PatientMedicalConditionsQueryCriteriaBean> {

    private static final long serialVersionUID = -2898310369793541311L;

    public PatientMedicalConditionsQueryMessageBean() {
        this(new PatientMedicalConditionsQueryCriteriaBean());
    }

    public PatientMedicalConditionsQueryMessageBean(PatientMedicalConditionsQueryCriteriaBean criteria) {
        super(criteria);
    }
}
