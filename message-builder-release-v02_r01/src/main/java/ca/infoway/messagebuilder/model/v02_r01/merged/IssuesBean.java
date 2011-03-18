/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.ActiveMedicationBean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.CausalActs;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.DispenseBean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.IssueDescriptionBean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.IssueManagementsBean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.PatientCodedObservationsBean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.PatientMeasurableObservationsBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT260010CA.DetectedIssueEvent","COCT_MT260012CA.DetectedIssueEvent","COCT_MT260020CA.DetectedIssueEvent","COCT_MT260022CA.DetectedIssueEvent","COCT_MT260030CA.DetectedIssueEvent","PORX_MT030040CA.DetectedIssueEvent","PORX_MT060040CA.DetectedIssueEvent","PORX_MT060060CA.DetectedIssueEvent","PORX_MT060160CA.DetectedIssueEvent","PORX_MT060190CA.DetectedIssueEvent","PORX_MT060340CA.DetectedIssueEvent"})
@Hl7RootType
public class IssuesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private List<CausalActs> subjectCausalActs = new ArrayList<CausalActs>();
    private CV issuePriority = new CVImpl();
    private IssueDescriptionBean instantiationDetectedIssueDefinition;
    private CV issueType = new CVImpl();
    private ST text = new STImpl();
    private CV severityCode = new CVImpl();
    private List<IssueManagementsBean> mitigatedByDetectedIssueManagement = new ArrayList<IssueManagementsBean>();
    private BL triggerForActRequest = new BLImpl();
    private BL subjectOf1StorageIntent = new BLImpl();


    @Hl7XmlMapping({"subject/causalActs"})
    public List<CausalActs> getSubjectCausalActs() {
        return this.subjectCausalActs;
    }


    /**
     * <p>IssuePriority</p>
     * 
     * <p>C:Issue Priority</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActIssuePriority getIssuePriority() {
        return (ActIssuePriority) this.issuePriority.getValue();
    }
    public void setIssuePriority(ActIssuePriority issuePriority) {
        this.issuePriority.setValue(issuePriority);
    }


    @Hl7XmlMapping({"instantiation/detectedIssueDefinition"})
    public IssueDescriptionBean getInstantiationDetectedIssueDefinition() {
        return this.instantiationDetectedIssueDefinition;
    }
    public void setInstantiationDetectedIssueDefinition(IssueDescriptionBean instantiationDetectedIssueDefinition) {
        this.instantiationDetectedIssueDefinition = instantiationDetectedIssueDefinition;
    }


    /**
     * <p>IssueType</p>
     * 
     * <p>Issue Type</p>
     * 
     * <p>A:Issue Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueCode getIssueType() {
        return (ActDetectedIssueCode) this.issueType.getValue();
    }
    public void setIssueType(ActDetectedIssueCode issueType) {
        this.issueType.setValue(issueType);
    }


    /**
     * <p>Issue Comment</p>
     * 
     * <p>D:Issue Details</p>
     * 
     * <p>B:Issue Comment</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>SeverityCode</p>
     * 
     * <p>B:Severity Code</p>
     */
    @Hl7XmlMapping({"subjectOf/severityObservation/value","subjectOf2/severityObservation/value"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="COCT_MT260010CA.Subject"),
        @Hl7MapByPartType(name="subjectOf", type="COCT_MT260030CA.Subject"),
        @Hl7MapByPartType(name="subjectOf/severityObservation", type="COCT_MT260010CA.SeverityObservation"),
        @Hl7MapByPartType(name="subjectOf/severityObservation", type="COCT_MT260030CA.SeverityObservation"),
        @Hl7MapByPartType(name="subjectOf2", type="COCT_MT260020CA.Subject"),
        @Hl7MapByPartType(name="subjectOf2/severityObservation", type="COCT_MT260020CA.SeverityObservation")})
    public SeverityObservation getSeverityCode() {
        return (SeverityObservation) this.severityCode.getValue();
    }
    public void setSeverityCode(SeverityObservation severityCode) {
        this.severityCode.setValue(severityCode);
    }


    @Hl7XmlMapping({"mitigatedBy/detectedIssueManagement"})
    public List<IssueManagementsBean> getMitigatedByDetectedIssueManagement() {
        return this.mitigatedByDetectedIssueManagement;
    }


    @Hl7XmlMapping({"triggerFor/actRequest"})
    public Boolean getTriggerForActRequest() {
        return this.triggerForActRequest.getValue();
    }
    public void setTriggerForActRequest(Boolean triggerForActRequest) {
        this.triggerForActRequest.setValue(triggerForActRequest);
    }


    @Hl7XmlMapping({"subjectOf1/storageIntent"})
    public Boolean getSubjectOf1StorageIntent() {
        return this.subjectOf1StorageIntent.getValue();
    }
    public void setSubjectOf1StorageIntent(Boolean subjectOf1StorageIntent) {
        this.subjectOf1StorageIntent.setValue(subjectOf1StorageIntent);
    }

}
