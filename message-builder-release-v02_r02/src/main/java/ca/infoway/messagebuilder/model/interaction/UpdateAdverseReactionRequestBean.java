/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.iehr.repc_mt000012ca.ReportedReactionBean;



/**
 * <p>Requests that information such as severity, outcome and 
 * suspected cause of a previously-recorded adverse reaction be 
 * updated.</p>
 */
@Hl7PartTypeMapping({"REPC_IN000008CA"})
public class UpdateAdverseReactionRequestBean extends HL7MessageBean<TriggerEventBean<ReportedReactionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
