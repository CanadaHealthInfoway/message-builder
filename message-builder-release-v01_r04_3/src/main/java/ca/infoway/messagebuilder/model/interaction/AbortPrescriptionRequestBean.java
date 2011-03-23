/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.merged.ReferencedRecordBean;



/**
 * <p>Requests that the specified prescription be aborted 
 * (further dispensing or administrative must cease).</p>
 */
@Hl7PartTypeMapping({"PORX_IN010840CA"})
public class AbortPrescriptionRequestBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
