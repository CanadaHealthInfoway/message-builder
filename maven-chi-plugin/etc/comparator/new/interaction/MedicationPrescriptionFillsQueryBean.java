/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.porx_mt060080ca.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020000ca.TriggerEventBean;



/**
 * <p>Requests retrieval of basic information about all 
 * medication dispenses performed against a particular 
 * prescription referenced by id 
 */
@Hl7PartTypeMapping({"PORX_IN060270CA"})
public class MedicationPrescriptionFillsQueryBean extends HL7MessageBean<TriggerEventBean<GenericQueryParametersBean>> implements InteractionBean {


}
