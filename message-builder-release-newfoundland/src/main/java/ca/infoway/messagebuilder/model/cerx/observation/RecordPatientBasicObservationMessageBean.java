package ca.infoway.messagebuilder.model.cerx.observation;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("REPC_IN000051CA")
public class RecordPatientBasicObservationMessageBean extends RecordRequestMessageBean<ObservationBean> implements HasTargetReference<RecordPatientBasicObservationMessageBean> {

    private static final long serialVersionUID = 8231859928712790183L;

    public RecordPatientBasicObservationMessageBean getTargetReference() {
        return this;
    }
}
