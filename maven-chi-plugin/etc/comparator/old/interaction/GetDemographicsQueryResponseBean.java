/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.mfmi_mt700746ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.prpa_mt101101ca.ParameterListBean;
import ca.infoway.messagebuilder.model.common.prpa_mt101102ca.IdentifiedEntityBean;



/**
 * <p>This interaction sends a response from a Person Registry 
 * with demographic information for a specific person 
 * identifier. 
 */
@Hl7PartTypeMapping({"PRPA_IN101102CA"})
public class GetDemographicsQueryResponseBean extends HL7MessageBean<TriggerEventBean<IdentifiedEntityBean,ParameterListBean>> implements InteractionBean {


}
