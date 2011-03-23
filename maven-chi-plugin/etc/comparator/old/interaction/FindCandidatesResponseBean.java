/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.mfmi_mt700746ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.prpa_mt101103ca.ParameterListBean;
import ca.infoway.messagebuilder.model.common.prpa_mt101104ca.IdentifiedPersonBean;



/**
 * <p>This interaction returns a list of candidates from a 
 * Person Registry that match a particular set of person 
 * demographics. The response may also include a score 
 * indicating the probability of match for each candidate. 
 */
@Hl7PartTypeMapping({"PRPA_IN101104CA"})
public class FindCandidatesResponseBean extends HL7MessageBean<TriggerEventBean<IdentifiedPersonBean,ParameterListBean>> implements InteractionBean {


}
