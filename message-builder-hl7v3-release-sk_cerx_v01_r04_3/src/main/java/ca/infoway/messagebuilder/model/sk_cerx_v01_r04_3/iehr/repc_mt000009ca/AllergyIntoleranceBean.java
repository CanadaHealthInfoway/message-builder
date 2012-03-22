/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.repc_mt000009ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged.Records;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.VersionInformationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Allergy/Intolerance</p>
 * 
 * <p><p>Value is not permitted when using SNOMED, mandatory 
 * otherwise</p></p>
 * 
 * <p><p>A record of a patient's allergy or intolerance.</p></p>
 * 
 * <p><p>Necessary component of a person's overall medication 
 * and clinical profile. Helps with drug contraindication 
 * checking.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000009CA.IntoleranceCondition"})
@Hl7RootType
public class AllergyIntoleranceBean extends MessagePartBean {

    private static final long serialVersionUID = 20120322L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private CV confidentialityCode = new CVImpl();
    private CV uncertaintyCode = new CVImpl();
    private CV value = new CVImpl();
    private PatientBean subjectPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private ReportedByBean informant;
    private RecordedAtBean location;
    private AllergyIntoleranceBean replacementOfIntoleranceCondition;
    private List<Records> supportRecords = new ArrayList<Records>();
    private List<VersionInformationBean> subjectOf1ControlActEvent = new ArrayList<VersionInformationBean>();
    private List<CommentBean> subjectOf2Annotation = new ArrayList<CommentBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOf3SeverityObservation;


    /**
     * <p>D:Allergy/Intolerance Record Id</p>
     * 
     * <p><p>Unique identifier for an allergy/intolerance 
     * record.</p></p>
     * 
     * <p><p>Allows for direct referencing of an 
     * allergy/intolerance record when querying or performing 
     * updates and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>A:Allergy/Intolerance Type</p>
     * 
     * <p><p>A coded value denoting whether the record pertains to 
     * an intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p></p>
     * 
     * <p><p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getCode() {
        return (ObservationIntoleranceType) this.code.getValue();
    }
    public void setCode(ObservationIntoleranceType code) {
        this.code.setValue(code);
    }


    /**
     * <p>G:Allergy/Intolerance Refuted</p>
     * 
     * <p><p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p></p>
     * 
     * <p><p>Allows providers to refute a previously confirmed or 
     * suspected allergy. Because it is essential to know whether 
     * the record refutes or affirms an allergy, this attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>E:Allergy/Intolerance Status</p>
     * 
     * <p><p>&quot;Identifies what kind of change occurred. 
     * Allergy/Intolerance change types are Revise, Reactivate and 
     * Complete</p></p>
     * 
     * <p><p>Allows providers to evaluate the relevance of a 
     * recorded allergy/intolerance. The status has a default value 
     * of 'active' and is therefore mandatory.</p></p>
     * 
     * <p><p>System must default the status to 'ACTIVE'.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>I:Allergy/Intolerance Date</p>
     * 
     * <p><p>The date on which the recorded allergy is considered 
     * active.</p></p>
     * 
     * <p><p>Allows providers to evaluate the period of relevance 
     * for the allergy/intolerance record.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>H:Allergy/Intolerance Masking Indicator</p>
     * 
     * <p><p>Denotes access restriction placed on the allergy or 
     * intolerance record. Methods for accessing masked allergy 
     * records will be governed by each jurisdiction (e.g. court 
     * orders, shared secret/consent, etc.). The default 
     * confidentiality level is 'NORMAL'.</p></p>
     * 
     * <p><p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>F:Confirmed Indicator</p>
     * 
     * <p><p>An indication of the level of confidence/surety placed 
     * in the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p></p>
     * 
     * <p><p>An indication of the level of confidence/surety placed 
     * in the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p></p>
     * 
     * <p><p>An indication of the level of confidence/surety placed 
     * in the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p></p>
     * 
     * <p><p>An indication of the level of confidence/surety placed 
     * in the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p></p>
     * 
     * <p><p>An indication of the level of confidence/surety placed 
     * in the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p></p>
     * 
     * <p><p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either 
     * 'confirmed' or 'suspected'.</p></p>
     * 
     * <p><p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either 
     * 'confirmed' or 'suspected'.</p></p>
     * 
     * <p><p>&nbsp;This can be &lsquo;N&rsquo; or 
     * &lsquo;U&rsquo;.</p></p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }


    /**
     * <p>B:Agent</p>
     * 
     * <p><p>Indicates the substance to which the patient is 
     * allergic</p></p>
     * 
     * <p><p>Critical for identifying the allergy or intolerance. 
     * However, because the attribute is not used for SNOMED, it is 
     * optional.</p></p>
     * 
     * <p><p><strong>Because PIN is not using SNOMED, this 
     * attribute is mandatory.</strong></p></p>
     */
    @Hl7XmlMapping({"value"})
    public IntoleranceValue getValue() {
        return (IntoleranceValue) this.value.getValue();
    }
    public void setValue(IntoleranceValue value) {
        this.value.setValue(value);
    }


    /**
     * <p>Suffered By</p>
     * 
     * <p><p>&nbsp;Identifies the person suffering from 
     * the&nbsp;allergy/intolerance.</p></p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Supervised By</p>
     * 
     * <p><p>&nbsp;Identifies the provider who is taking 
     * responsibility for&nbsp;the actions of the author.</p></p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Reported By</p>
     * 
     * <p><p>&nbsp;Indicates where the information that led to 
     * the&nbsp;recording of this information came from.</p></p>
     */
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


    /**
     * <p><div>of change.</div></p>
     * 
     * <p><div>History section.</div></p>
     */
    @Hl7XmlMapping({"replacementOf/intoleranceCondition"})
    public AllergyIntoleranceBean getReplacementOfIntoleranceCondition() {
        return this.replacementOfIntoleranceCondition;
    }
    public void setReplacementOfIntoleranceCondition(AllergyIntoleranceBean replacementOfIntoleranceCondition) {
        this.replacementOfIntoleranceCondition = replacementOfIntoleranceCondition;
    }


    @Hl7XmlMapping({"support/records"})
    public List<Records> getSupportRecords() {
        return this.supportRecords;
    }


    /**
     * <p>Allergy Intolerance Status Change</p>
     * 
     * <p><p>This records the history of changes that have 
     * been&nbsp;made to the allergy/intolerance, including why 
     * the&nbsp;changes were made, who made them and when.</p></p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<VersionInformationBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    /**
     * <p>Annotation</p>
     * 
     * <p><p><strong>Annotations will only be returned on the 
     * current allergy/intolerance record. They will not be present 
     * on the IntoleranceCondition objects that represent 
     * history.</strong></p></p>
     */
    @Hl7XmlMapping({"subjectOf2/annotation"})
    public List<CommentBean> getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }


    @Hl7XmlMapping({"subjectOf3/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf3SeverityObservation() {
        return this.subjectOf3SeverityObservation;
    }
    public void setSubjectOf3SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf3SeverityObservation) {
        this.subjectOf3SeverityObservation = subjectOf3SeverityObservation;
    }

}
