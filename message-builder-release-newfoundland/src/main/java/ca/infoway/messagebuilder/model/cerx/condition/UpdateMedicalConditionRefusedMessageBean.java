package ca.infoway.messagebuilder.model.cerx.condition;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("REPC_IN000034CA")
public class UpdateMedicalConditionRefusedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = 8249650530911805877L;
}
