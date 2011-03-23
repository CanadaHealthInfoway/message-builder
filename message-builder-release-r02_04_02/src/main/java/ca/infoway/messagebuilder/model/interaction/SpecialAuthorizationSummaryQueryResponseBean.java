/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt490001ca.ParameterListBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt490101ca.SpecialAuthorizationRequestBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120008ca.TriggerEventBean;



@Hl7PartTypeMapping({"FICR_IN404102CA"})
public class SpecialAuthorizationSummaryQueryResponseBean extends HL7MessageBean<TriggerEventBean<SpecialAuthorizationRequestBean,ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100603L;

}
