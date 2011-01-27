/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.PrescribedByBean;



/**
 * <p>IssueDescription</p>
 * 
 * <p>COCT_MT260030CA.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p><p>This is the decision support rule that triggered the 
 * issue.</p></p>
 * 
 * <p><p>Provides detailed background for providers in 
 * evaluating the issue.</p></p>
 * 
 * <p>COCT_MT260020CA.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p><p>This is the decision support rule that triggered the 
 * issue.</p></p>
 * 
 * <p><p>Provides detailed background for providers in 
 * evaluating the issue.</p></p>
 * 
 * <p>COCT_MT260010CA.DetectedIssueDefinition: Issue 
 * Description</p>
 * 
 * <p><p>This is the decision support rule that triggered the 
 * issue.</p></p>
 * 
 * <p><p>Provides detailed background for providers in 
 * evaluating the issue.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.DetectedIssueDefinition","COCT_MT260020CA.DetectedIssueDefinition","COCT_MT260030CA.DetectedIssueDefinition"})
public class IssueDescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private RecommendedDosageBean componentSubstanceAdministrationEventCriterion;
    private II issueMonographId = new IIImpl();
    private PrescribedByBean author;
    private ED<EncapsulatedData> issueDescription = new EDImpl<EncapsulatedData>();


    @Hl7XmlMapping({"component/substanceAdministrationEventCriterion"})
    public RecommendedDosageBean getComponentSubstanceAdministrationEventCriterion() {
        return this.componentSubstanceAdministrationEventCriterion;
    }
    public void setComponentSubstanceAdministrationEventCriterion(RecommendedDosageBean componentSubstanceAdministrationEventCriterion) {
        this.componentSubstanceAdministrationEventCriterion = componentSubstanceAdministrationEventCriterion;
    }


    /**
     * <p>IssueMonographId</p>
     * 
     * <p>A:Issue Monograph Id</p>
     * 
     * <p><p>Knowledgebase organization specific identifier for the 
     * issue definition.</p></p>
     * 
     * <p><p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p></p>
     * 
     * <p><p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p></p>
     * 
     * <p><p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p></p>
     * 
     * <p><p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p></p>
     * 
     * <p><p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p></p>
     * 
     * <p><p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p></p>
     * 
     * <p><p>DDIMonograph.DDIMonographId</p><p>ZPE.2</p><p>MB.05.03C</p><p>ZPS.14</p><p>ZDU.5.2</p><p>A_DetectedMedicationIssue</p><p>Monograph 
     * Code</p></p>
     * 
     * <p><p>Allows applications to match with local 
     * Knowledge-bases and avoid displaying duplicate issues to 
     * providers.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getIssueMonographId() {
        return this.issueMonographId.getValue();
    }
    public void setIssueMonographId(Identifier issueMonographId) {
        this.issueMonographId.setValue(issueMonographId);
    }


    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    /**
     * <p>IssueDescription</p>
     * 
     * <p>C:Issue Description</p>
     * 
     * <p><p>A free form textual description of the issue. This is 
     * usually in the form of a monograph.</p></p>
     * 
     * <p><p>Monograph URI (Reference)</p><p>Monograph 
     * description</p></p>
     * 
     * <p><p>Monograph URI (Reference)</p><p>Monograph 
     * description</p></p>
     * 
     * <p><p>Provides detailed clinical background on reasons for 
     * issue.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getIssueDescription() {
        return this.issueDescription.getValue();
    }
    public void setIssueDescription(EncapsulatedData issueDescription) {
        this.issueDescription.setValue(issueDescription);
    }

}