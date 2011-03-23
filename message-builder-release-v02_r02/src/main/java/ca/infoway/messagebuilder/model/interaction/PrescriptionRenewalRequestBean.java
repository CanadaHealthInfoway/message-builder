/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.merged.ReferencedRecordBean;



/**
 * <p>Requests that a prescriber issue a renewal prescription 
 * based on a previously existing prescription.</p>
 */
@Hl7PartTypeMapping({"PORX_IN010720CA"})
public class PrescriptionRenewalRequestBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
