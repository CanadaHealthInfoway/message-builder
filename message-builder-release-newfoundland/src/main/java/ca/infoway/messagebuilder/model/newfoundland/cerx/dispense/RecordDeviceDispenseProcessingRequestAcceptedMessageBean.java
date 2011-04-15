package ca.infoway.messagebuilder.model.newfoundland.cerx.dispense;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;

@Hl7PartTypeMapping("PORX_IN020340CA")
public class RecordDeviceDispenseProcessingRequestAcceptedMessageBean extends RecordResponseMessageBean<DispenseRecordedConfirmationBean> {

    private static final long serialVersionUID = -3278626512063501154L;
}
