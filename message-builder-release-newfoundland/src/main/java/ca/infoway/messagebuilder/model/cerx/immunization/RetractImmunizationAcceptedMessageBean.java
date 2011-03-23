package ca.infoway.messagebuilder.model.cerx.immunization;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("POIZ_IN010110CA")
public class RetractImmunizationAcceptedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = -2686254590054412749L;
}
