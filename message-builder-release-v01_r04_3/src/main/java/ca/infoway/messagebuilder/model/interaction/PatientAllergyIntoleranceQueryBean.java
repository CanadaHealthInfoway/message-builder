/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.AllergyIntoleranceQueryParametersBean;



/**
 * <p>Requests retrieval of all allergies or intolerances that 
 * have been recorded for a particular patient, optionally 
 * filtered by time-range when the allergy or intolerance 
 * record has last been changed.</p>
 */
@Hl7PartTypeMapping({"REPC_IN000015CA"})
public class PatientAllergyIntoleranceQueryBean extends HL7MessageBean<TriggerEventBean<AllergyIntoleranceQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
