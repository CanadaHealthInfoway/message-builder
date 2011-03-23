package ca.infoway.messagebuilder.model.cerx.othermedication;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("PORX_IN040020CA")
public class RecordOtherMedicationRequestMessageBean extends RecordRequestMessageBean<OtherMedicationBean> implements HasTargetReference<OtherMedicationBean> {

    private static final long serialVersionUID = 3813853649521477074L;

    public OtherMedicationBean getTargetReference() {
        return getControlActEvent().getRecordBean().getRecord();
    }
}
