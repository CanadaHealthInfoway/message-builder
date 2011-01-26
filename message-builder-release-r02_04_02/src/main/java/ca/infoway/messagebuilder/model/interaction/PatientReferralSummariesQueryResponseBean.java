/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.iehr.repc_mt210002ca.ReferralBean;
import ca.infoway.messagebuilder.model.iehr.repc_mt210004ca.QueryDefinitionBean;



@Hl7PartTypeMapping({"REPC_IN000085CA"})
public class PatientReferralSummariesQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<ReferralBean,QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110126L;

}
