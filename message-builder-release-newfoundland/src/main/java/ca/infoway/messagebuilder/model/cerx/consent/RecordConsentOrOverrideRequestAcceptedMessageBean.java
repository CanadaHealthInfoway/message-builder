package ca.infoway.messagebuilder.model.cerx.consent;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("RCMR_IN010001CA")
public class RecordConsentOrOverrideRequestAcceptedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = -4109885938785666378L;
}
