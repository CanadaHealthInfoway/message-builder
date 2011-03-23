/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020002ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.ParameterList_2Bean;



/**
 * <p>The sender sends a SOFA (Statement of Financial Activity) 
 * Detail Query message for Pharmacy services and/or products. 
 * The request is for detailed account activity information, 
 * including references to previously adjudicated Invoices. 
 */
@Hl7PartTypeMapping({"QUCR_IN820102CA"})
public class SOFADetailQueryRequestRxBean extends HL7MessageBean<TriggerEventBean<ParameterList_2Bean>> implements InteractionBean {


}
