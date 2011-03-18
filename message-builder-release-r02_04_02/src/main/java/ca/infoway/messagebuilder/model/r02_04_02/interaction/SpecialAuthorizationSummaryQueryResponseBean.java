/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.ParameterList_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.SpecialAuthorizationRequestBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.TriggerEvent_6Bean;



@Hl7PartTypeMapping({"FICR_IN404102CA"})
public class SpecialAuthorizationSummaryQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<SpecialAuthorizationRequestBean,ParameterList_1Bean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
