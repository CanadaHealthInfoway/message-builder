package ca.infoway.messagebuilder.model.newfoundland.cerx.immunization;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;

@Hl7PartTypeMapping("POIZ_IN010080CA")
public class UpdateImmunizationAcceptedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = 2503913045283046066L;
}