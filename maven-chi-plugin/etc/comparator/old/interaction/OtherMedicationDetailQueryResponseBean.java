/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.porx_mt060220ca.ParameterListBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.OtherMedicationBean;



/**
 * <p>Returns detailed information about a single ""other 
 * medication"" record, referenced by identifier. 
 */
@Hl7PartTypeMapping({"PORX_IN060460CA"})
public class OtherMedicationDetailQueryResponseBean extends HL7MessageBean<TriggerEventBean<OtherMedicationBean,ParameterListBean>> implements InteractionBean {


}
