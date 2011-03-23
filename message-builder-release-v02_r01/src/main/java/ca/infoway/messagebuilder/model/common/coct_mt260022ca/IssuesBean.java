/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt260022ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.ActRequestBean;
import ca.infoway.messagebuilder.model.merged.DetectedIssueManagement_2Bean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Issues</p>
 * 
 * <p>This is the list of clinical and business-rule issues 
 * that have been detected and recorded involving the current 
 * action.</p>
 * 
 * <p>Provides a list of issues that have been detected.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260022CA.DetectedIssueEvent"})
@Hl7RootType
public class IssuesBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private CV issueType = new CVImpl();
    private ST issueDetails = new STImpl();
    private CV issuePriority = new CVImpl();
    private List<DetectedIssueManagement_2Bean> mitigatedByDetectedIssueManagement = new ArrayList<DetectedIssueManagement_2Bean>();
    private ActRequestBean triggerForActRequest;

    @Hl7XmlMapping({"code"})
    public ActDetectedIssueCode getIssueType() {
        return (ActDetectedIssueCode) this.issueType.getValue();
    }
    public void setIssueType(ActDetectedIssueCode issueType) {
        this.issueType.setValue(issueType);
    }

    @Hl7XmlMapping({"text"})
    public String getIssueDetails() {
        return this.issueDetails.getValue();
    }
    public void setIssueDetails(String issueDetails) {
        this.issueDetails.setValue(issueDetails);
    }

    @Hl7XmlMapping({"priorityCode"})
    public ActIssuePriority getIssuePriority() {
        return (ActIssuePriority) this.issuePriority.getValue();
    }
    public void setIssuePriority(ActIssuePriority issuePriority) {
        this.issuePriority.setValue(issuePriority);
    }

    @Hl7XmlMapping({"mitigatedBy/detectedIssueManagement"})
    public List<DetectedIssueManagement_2Bean> getMitigatedByDetectedIssueManagement() {
        return this.mitigatedByDetectedIssueManagement;
    }

    @Hl7XmlMapping({"triggerFor/actRequest"})
    public ActRequestBean getTriggerForActRequest() {
        return this.triggerForActRequest;
    }
    public void setTriggerForActRequest(ActRequestBean triggerForActRequest) {
        this.triggerForActRequest = triggerForActRequest;
    }

}
