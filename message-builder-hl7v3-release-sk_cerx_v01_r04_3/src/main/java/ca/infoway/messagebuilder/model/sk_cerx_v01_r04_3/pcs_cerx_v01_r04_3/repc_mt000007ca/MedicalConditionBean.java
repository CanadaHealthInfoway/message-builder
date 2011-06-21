/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.repc_mt000007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.ReportedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Medical Condition</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A record of 
 * a patient's medical condition. Includes diseases, 
 * disabilities, pregnancy, lactation and other clinical 
 * conditions of interest.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Necessary 
 * component of a person's overall medication and clinical 
 * profile. Helps with contraindication checking.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000007CA.MedicalCondition"})
@Hl7RootType
public class MedicalConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private II medicalConditionRecordId = new IIImpl();
    private CD conditionType = new CDImpl();
    private CS conditionStatus = new CSImpl();
    private IVL<TS, Interval<Date>> conditionTimePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV conditionMaskingIndicator = new CVImpl();
    private CV condition = new CVImpl();
    private RefusedByBean author;
    private ReportedByBean informant;
    private RecordedAtBean location;
    private ProviderBean responsiblePartyAssignedPerson;
    private Patient_1Bean subjectPatient;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private List<CommentBean> subjectOf2Annotation = new ArrayList<CommentBean>();
    private BL subjectOf3ChronicIndicator = new BLImpl(false);


    /**
     * <p>A:Medical Condition Record Id</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Unique 
     * identifier for medical condition record.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * direct referencing of a medical condition record when 
     * querying or updating and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getMedicalConditionRecordId() {
        return this.medicalConditionRecordId.getValue();
    }
    public void setMedicalConditionRecordId(Identifier medicalConditionRecordId) {
        this.medicalConditionRecordId.setValue(medicalConditionRecordId);
    }


    /**
     * <p>Condition Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * what kind of condition is being reported.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
     * this observation as reporting a medical condition and is 
     * therefore mandatory. When using SNOMED, the actual condition 
     * may be post-coordinated into this attribute, thus CD is 
     * used.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If SNOMED is 
     * used, the diagnosis will appear here. Otherwise, a fixed 
     * value of &quot;DX&quot; should be sent.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getConditionType() {
        return (ActCode) this.conditionType.getValue();
    }
    public void setConditionType(ActCode conditionType) {
        this.conditionType.setValue(conditionType);
    }


    /**
     * <p>D:Condition Status</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value that indicates whether the condition is still 
     * impacting the patient. 'ACTIVE' means the condition is still 
     * affecting the patient. 'COMPLETE' means the condition no 
     * longer holds</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Essential to 
     * evaluating the relevance of the condition record. In some 
     * cases, it may not be known whether the condition still 
     * exists or not. Therefore the status is treated as 
     * 'populated'.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getConditionStatus() {
        return (ActStatus) this.conditionStatus.getValue();
    }
    public void setConditionStatus(ActStatus conditionStatus) {
        this.conditionStatus.setValue(conditionStatus);
    }


    /**
     * <p>E:Condition Time Period</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date on 
     * which the condition first began and when it ended.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">For ongoing 
     * conditions such as chronic diseases, the upper boundary may 
     * be unknown.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">For transient 
     * conditions such as pregnancy, lactation, etc; the upper 
     * boundary of the period would usually be specified to signify 
     * the end of the condition.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date on 
     * which the condition first began and when it ended.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">For ongoing 
     * conditions such as chronic diseases, the upper boundary may 
     * be unknown.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">For transient 
     * conditions such as pregnancy, lactation, etc; the upper 
     * boundary of the period would usually be specified to signify 
     * the end of the condition.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date on 
     * which the condition first began and when it ended.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">For ongoing 
     * conditions such as chronic diseases, the upper boundary may 
     * be unknown.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">For transient 
     * conditions such as pregnancy, lactation, etc; the upper 
     * boundary of the period would usually be specified to signify 
     * the end of the condition.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * providers to evaluate the period of relevance for the 
     * medical condition.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConditionTimePeriod() {
        return this.conditionTimePeriod.getValue();
    }
    public void setConditionTimePeriod(Interval<Date> conditionTimePeriod) {
        this.conditionTimePeriod.setValue(conditionTimePeriod);
    }


    /**
     * <p>F:Condition Masking Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Denotes 
     * access restriction placed on the medical condition record. 
     * Methods for accessing masked medical condition records will 
     * be governed by each jurisdiction (e.g. court orders, shared 
     * secret/consent, etc.).</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The default 
     * confidentiality level is 'NORMAL'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Denotes 
     * access restriction placed on the medical condition record. 
     * Methods for accessing masked medical condition records will 
     * be governed by each jurisdiction (e.g. court orders, shared 
     * secret/consent, etc.).</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The default 
     * confidentiality level is 'NORMAL'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * support for additional confidentiality constraint to reflect 
     * the wishes of the patient.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * support for additional confidentiality constraint to reflect 
     * the wishes of the patient.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConditionMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.conditionMaskingIndicator.getValue();
    }
    public void setConditionMaskingIndicator(x_VeryBasicConfidentialityKind conditionMaskingIndicator) {
        this.conditionMaskingIndicator.setValue(conditionMaskingIndicator);
    }


    /**
     * <p>C:Condition</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A code 
     * indicating the specific condition. E.g. Hypertension, 
     * Pregnancy.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
     * central piece of information in recording a condition. 
     * However because when using SNOMED the actual diagnosis will 
     * be sent in the 'code' attribute, this element is 
     * optional.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getCondition() {
        return (DiagnosisValue) this.condition.getValue();
    }
    public void setCondition(DiagnosisValue condition) {
        this.condition.setValue(condition);
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf2/annotation"})
    public List<CommentBean> getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }


    @Hl7XmlMapping({"subjectOf3/chronicIndicator"})
    public Boolean getSubjectOf3ChronicIndicator() {
        return this.subjectOf3ChronicIndicator.getValue();
    }
    public void setSubjectOf3ChronicIndicator(Boolean subjectOf3ChronicIndicator) {
        this.subjectOf3ChronicIndicator.setValue(subjectOf3ChronicIndicator);
    }

}
