/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.mfmi_mt700751ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.prpa_mt101101ca.ParameterListBean;



/**
 * <p>This interaction sends a query to a Person Registry 
 * requesting all other identifiers associated with a specific 
 * person identifier. 
 */
@Hl7PartTypeMapping({"PRPA_IN101105CA"})
public class FindAssociatedPersonIdentifiersQueryBean extends HL7MessageBean<TriggerEventBean<ParameterListBean>> implements InteractionBean {


}
