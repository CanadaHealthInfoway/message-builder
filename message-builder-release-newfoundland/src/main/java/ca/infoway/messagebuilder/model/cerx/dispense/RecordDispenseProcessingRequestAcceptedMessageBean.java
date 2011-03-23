package ca.infoway.messagebuilder.model.cerx.dispense;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("PORX_IN020130CA")
public class RecordDispenseProcessingRequestAcceptedMessageBean extends RecordResponseMessageBean<DispenseRecordedConfirmationBean> {

    private static final long serialVersionUID = 3325775842462638616L;
}
