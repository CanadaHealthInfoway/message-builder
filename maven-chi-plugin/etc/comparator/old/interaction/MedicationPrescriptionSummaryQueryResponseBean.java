/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.porx_mt060130ca.ParameterListBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.PrescriptionBean;



/**
 * <p>Returns basic information about medication prescriptions 
 * provided to a single patient 
 */
@Hl7PartTypeMapping({"PORX_IN060300CA"})
public class MedicationPrescriptionSummaryQueryResponseBean extends HL7MessageBean<TriggerEventBean<PrescriptionBean,ParameterListBean>> implements InteractionBean {


}
