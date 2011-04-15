package ca.infoway.messagebuilder.model.newfoundland.cerx.observation;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("REPC_IN000054CA")
public class PatientBasicObservationsQueryMessageBean extends NewQueryMessageBean<PatientBasicObservationsQueryCriteriaBean> {

    private static final long serialVersionUID = 3168384981366793898L;

    public PatientBasicObservationsQueryMessageBean() {
        this(new PatientBasicObservationsQueryCriteriaBean());
    }

    public PatientBasicObservationsQueryMessageBean(PatientBasicObservationsQueryCriteriaBean criteria) {
        super(criteria);
    }
}
