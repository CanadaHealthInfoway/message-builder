/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.mfmi_mt700746ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pr.prpm_mt306050ca.ParameterListBean;
import ca.infoway.messagebuilder.model.pr.prpm_mt306051ca.RoleChoiceBean;



@Hl7PartTypeMapping({"PRPM_IN306051CA"})
public class ProviderAssociatedIdentifiersQueryResponseBean extends HL7MessageBean<TriggerEventBean<ParameterListBean,RoleChoiceBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100603L;

}
