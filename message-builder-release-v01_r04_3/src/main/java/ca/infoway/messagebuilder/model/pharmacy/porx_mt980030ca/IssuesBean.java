/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt980030ca;

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
import ca.infoway.messagebuilder.model.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.merged.IssueDescriptionBean;
import ca.infoway.messagebuilder.model.merged.IssueManagementsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Issues</p>
 * 
 * <p>This is the list of clinical and business issues that 
 * have been detected and recorded involving the current 
 * action.</p>
 * 
 * <p>Provides a list of issues that have been detected and/or 
 * managed.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980030CA.DetectedIssueEvent"})
@Hl7RootType
public class IssuesBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private CV issueType = new CVImpl();
    private ST issueDetails = new STImpl();
    private CV issuePriority = new CVImpl();
    private List<CausalActsBean> subjectCausalActs = new ArrayList<CausalActsBean>();
    private IssueDescriptionBean instantiationDetectedIssueDefinition;
    private List<IssueManagementsBean> mitigatedByDetectedIssueManagement = new ArrayList<IssueManagementsBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation;

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

    @Hl7XmlMapping({"subject/causalActs"})
    public List<CausalActsBean> getSubjectCausalActs() {
        return this.subjectCausalActs;
    }

    @Hl7XmlMapping({"instantiation/detectedIssueDefinition"})
    public IssueDescriptionBean getInstantiationDetectedIssueDefinition() {
        return this.instantiationDetectedIssueDefinition;
    }
    public void setInstantiationDetectedIssueDefinition(IssueDescriptionBean instantiationDetectedIssueDefinition) {
        this.instantiationDetectedIssueDefinition = instantiationDetectedIssueDefinition;
    }

    @Hl7XmlMapping({"mitigatedBy/detectedIssueManagement"})
    public List<IssueManagementsBean> getMitigatedByDetectedIssueManagement() {
        return this.mitigatedByDetectedIssueManagement;
    }

    @Hl7XmlMapping({"subjectOf/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOfSeverityObservation() {
        return this.subjectOfSeverityObservation;
    }
    public void setSubjectOfSeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation) {
        this.subjectOfSeverityObservation = subjectOfSeverityObservation;
    }

}
