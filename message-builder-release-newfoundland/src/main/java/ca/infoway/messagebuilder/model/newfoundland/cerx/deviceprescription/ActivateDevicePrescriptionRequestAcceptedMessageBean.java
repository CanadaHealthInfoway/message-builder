package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN011040CA")
public class ActivateDevicePrescriptionRequestAcceptedMessageBean extends RecordResponseMessageBean<ActRequestBean> {

    private static final long serialVersionUID = 8643543198496189036L;
}