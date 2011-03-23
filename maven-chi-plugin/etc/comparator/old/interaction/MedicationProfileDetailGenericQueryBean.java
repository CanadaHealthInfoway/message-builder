/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.GenericQueryParametersBean;



/**
 * <p>Requests retrieval of detailed information about a 
 * patient's prescriptions, dispenses and other medications for 
 * a specific patient filtered by a variety of criteria, 
 * including id, drug, indication, date, etc. 
 */
@Hl7PartTypeMapping({"PORX_IN060350CA"})
public class MedicationProfileDetailGenericQueryBean extends HL7MessageBean<TriggerEventBean<GenericQueryParametersBean>> implements InteractionBean {


}
