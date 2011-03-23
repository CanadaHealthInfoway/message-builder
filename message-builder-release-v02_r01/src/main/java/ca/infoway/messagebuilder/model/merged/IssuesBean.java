/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT260012CA.DetectedIssueEvent","PORX_MT030040CA.DetectedIssueEvent","PORX_MT060040CA.DetectedIssueEvent","PORX_MT060060CA.DetectedIssueEvent","PORX_MT060160CA.DetectedIssueEvent","PORX_MT060190CA.DetectedIssueEvent","PORX_MT060340CA.DetectedIssueEvent"})
@Hl7RootType
public class IssuesBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private CV issueType = new CVImpl();
    private ST issueComment = new STImpl();
    private CV issuePriority = new CVImpl();
    private List<DetectedIssueManagement_1Bean> mitigatedByDetectedIssueManagement = new ArrayList<DetectedIssueManagement_1Bean>();

    @Hl7XmlMapping({"code"})
    public ActDetectedIssueCode getIssueType() {
        return (ActDetectedIssueCode) this.issueType.getValue();
    }
    public void setIssueType(ActDetectedIssueCode issueType) {
        this.issueType.setValue(issueType);
    }

    @Hl7XmlMapping({"text"})
    public String getIssueComment() {
        return this.issueComment.getValue();
    }
    public void setIssueComment(String issueComment) {
        this.issueComment.setValue(issueComment);
    }

    @Hl7XmlMapping({"priorityCode"})
    public ActIssuePriority getIssuePriority() {
        return (ActIssuePriority) this.issuePriority.getValue();
    }
    public void setIssuePriority(ActIssuePriority issuePriority) {
        this.issuePriority.setValue(issuePriority);
    }

    @Hl7XmlMapping({"mitigatedBy/detectedIssueManagement"})
    public List<DetectedIssueManagement_1Bean> getMitigatedByDetectedIssueManagement() {
        return this.mitigatedByDetectedIssueManagement;
    }

}
