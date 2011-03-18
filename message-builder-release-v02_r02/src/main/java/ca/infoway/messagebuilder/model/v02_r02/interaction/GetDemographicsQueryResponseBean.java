/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v02_r02.common.mfmi_mt700746ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.v02_r02.cr.prpa_mt101101ca.ParameterListBean;
import ca.infoway.messagebuilder.model.v02_r02.cr.prpa_mt101102ca.IdentifiedPersonBean;



@Hl7PartTypeMapping({"PRPA_IN101102CA"})
public class GetDemographicsQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<ParameterListBean,IdentifiedPersonBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
