package ca.infoway.messagebuilder.model.cerx.othermedication;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("PORX_IN040040CA")
public class RecordOtherMedicationRequestRefusedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = -8282832278794538332L;
}
