package ca.infoway.messagebuilder.model.cerx.observation;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("REPC_IN000055CA")
public class PatientBasicObservationsQueryResponseMessageBean extends NewQueryResponseMessageBean<PatientBasicObservationsQueryCriteriaBean, ObservationBean> {

    private static final long serialVersionUID = 2123487827104945848L;

    public PatientBasicObservationsQueryResponseMessageBean(ResponseMessageAttributesBean attributes, PatientBasicObservationsQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public PatientBasicObservationsQueryResponseMessageBean(PatientBasicObservationsQueryCriteriaBean criteria) {
        super(criteria);
    }

    public PatientBasicObservationsQueryResponseMessageBean() {
        this(new PatientBasicObservationsQueryCriteriaBean());
    }
}
