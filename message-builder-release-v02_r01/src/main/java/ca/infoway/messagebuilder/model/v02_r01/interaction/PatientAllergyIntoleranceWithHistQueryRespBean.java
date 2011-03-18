/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.v02_r01.iehr.repc_mt000009ca.AllergyIntoleranceBean;
import ca.infoway.messagebuilder.model.v02_r01.iehr.repc_mt000019ca.ConditionHistoryQueryParametersBean;



@Hl7PartTypeMapping({"REPC_IN000018CA"})
public class PatientAllergyIntoleranceWithHistQueryRespBean extends HL7Message_1Bean<TriggerEvent_5Bean<AllergyIntoleranceBean,ConditionHistoryQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
