/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.qucr_mt800201ca.ParameterListBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120008ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.AdjudicatedResultsGroupBean;



/**
 * <p>The sender sends a SOFA (Statement of Financial Activity) 
 * Payment Advice Query Response message for Pharmacy services 
 * and/or products. 
 */
@Hl7PartTypeMapping({"QUCR_IN810102CA"})
public class SOFAPaymentAdviceQueryResponseRxBean extends HL7MessageBean<TriggerEventBean<AdjudicatedResultsGroupBean,ParameterListBean>> implements InteractionBean {


}
