/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.claims.qucr_mt820201ca.ParameterListBean;
import ca.infoway.messagebuilder.model.claims.qucr_mt830201ca.TypeOfSummaryBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120008ca.TriggerEventBean;



/**
 * <p>The sender sends a SOFA (Statement of Financial Activity) 
 * Detail Query Response message for Pharmacy services and/or 
 * products.The response is for detailed account activity 
 * information, including references to previously adjudicated 
 * Invoices.</p>
 */
@Hl7PartTypeMapping({"QUCR_IN830102CA"})
public class SOFADetailQueryResultsRxBean extends HL7MessageBean<TriggerEventBean<TypeOfSummaryBean,ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100615L;

}
