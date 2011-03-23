package ca.infoway.messagebuilder.model.cerx.prescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN010390CA")
public class ActivatePrescriptionRequestAcceptedMessageBean extends RecordResponseMessageBean<ActRequestBean> {

    private static final long serialVersionUID = -4465196884409391648L;
}
