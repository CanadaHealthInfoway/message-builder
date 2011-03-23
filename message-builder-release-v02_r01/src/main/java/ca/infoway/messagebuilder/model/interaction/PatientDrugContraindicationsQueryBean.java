/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.GenericQueryParametersBean;



/**
 * <p>Requests retrieval of the potential contraindications 
 * associated with issuing a specified medication to a 
 * particular patient based on their existing medication and 
 * clinical profile.</p>
 */
@Hl7PartTypeMapping({"PORX_IN050030CA"})
public class PatientDrugContraindicationsQueryBean extends HL7MessageBean<TriggerEventBean<GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100615L;

}
