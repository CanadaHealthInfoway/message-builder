/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.coct_mt260010ca.IssuesBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;



/**
 * <p>Requests that the specified issue be updated to include 
 * the identified management(s).</p>
 */
@Hl7PartTypeMapping({"COMT_IN700001CA"})
public class AddIssueManagementRequestBean extends HL7MessageBean<TriggerEventBean<IssuesBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100615L;

}
