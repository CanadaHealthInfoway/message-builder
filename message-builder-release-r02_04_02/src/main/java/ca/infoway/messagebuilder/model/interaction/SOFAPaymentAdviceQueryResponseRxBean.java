/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.claims.qucr_mt810201ca.AdjudicatedResultsGroupBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120008ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.ParameterList_3Bean;



@Hl7PartTypeMapping({"QUCR_IN810102CA"})
public class SOFAPaymentAdviceQueryResponseRxBean extends HL7MessageBean<TriggerEventBean<AdjudicatedResultsGroupBean,ParameterList_3Bean>> implements InteractionBean {

    private static final long serialVersionUID = 20100603L;

}
