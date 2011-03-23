package ca.infoway.messagebuilder.model.cerx.immunization;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("POIZ_IN010090CA")
public class UpdateImmunizationRefusedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = 46874358681325317L;
}
