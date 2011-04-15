package ca.infoway.messagebuilder.model.newfoundland.cerx.allergy;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;

@Hl7PartTypeMapping("REPC_IN000022CA")
public class UpdateAllergyIntoleranceRefusedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = 5347504238755994418L;
}
