package ca.infoway.messagebuilder.model.cerx.othermedication;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("PORX_IN040090CA")
public class UpdateOtherMedicationRequestRefusedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = -280510740819196970L;
}
