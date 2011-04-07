/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt600201ca.PaymentRequestBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.TriggerEvent_1Bean;



@Hl7PartTypeMapping({"FICR_IN600102CA"})
public class InvoiceRequestRxBean extends HL7Message_1Bean<TriggerEvent_1Bean<PaymentRequestBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110407L;

}
