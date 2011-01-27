/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.iehr.repc_mt000007ca.HealthConditionBean;
import ca.infoway.messagebuilder.model.iehr.repc_mt000015ca.QueryDefinitionBean;



@Hl7PartTypeMapping({"REPC_IN000024CA"})
public class PatientHealthConditionSummariesQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<HealthConditionBean,QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110127L;

}
