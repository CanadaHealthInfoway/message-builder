package ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN040020CA")
public class RecordOtherMedicationRequestMessageBean extends RecordRequestMessageBean<OtherMedicationBean> implements HasTargetReference<OtherMedicationBean> {

    private static final long serialVersionUID = 3813853649521477074L;

    public OtherMedicationBean getTargetReference() {
        return getControlActEvent().getRecordBean().getRecord();
    }
}
