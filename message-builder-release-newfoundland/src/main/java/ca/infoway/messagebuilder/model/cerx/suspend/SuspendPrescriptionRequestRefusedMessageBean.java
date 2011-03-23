package ca.infoway.messagebuilder.model.cerx.suspend;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN010460CA")
public class SuspendPrescriptionRequestRefusedMessageBean extends RecordResponseMessageBean<ActRequestBean> {

    private static final long serialVersionUID = 2601395497583423875L;
}
