/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt000009ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.AllergyIntoleranceStatusChangesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.AllergyTestsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.Records;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ReportedReactionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Allergy/Intolerance</p>
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

    private static final long serialVersionUID = 20110831L;
    private II allergyIntoleranceRecordId = new IIImpl();
    private CD allergyIntoleranceType = new CDImpl();
    private BL allergyIntoleranceRefuted = new BLImpl();
    private CS allergyIntoleranceStatus = new CSImpl();
    private TS allergyIntoleranceDate = new TSImpl();
    private SET<CV, Code> allergyIntoleranceMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private CV confirmedIndicator = new CVImpl();
    private CV agent = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private RefusedByBean author;
    private ReportedByBean informant;
    private OccurredAtBean location;
    private AllergyIntoleranceBean replacementOfIntoleranceCondition;
    private List<Records> supportRecords = new ArrayList<Records>();
    private AllergyIntoleranceStatusChangesBean subjectOf1ControlActEvent;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOf3SeverityObservation;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


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
    public Identifier getAllergyIntoleranceRecordId() {
        return this.allergyIntoleranceRecordId.getValue();
    }
    public void setAllergyIntoleranceRecordId(Identifier allergyIntoleranceRecordId) {
        this.allergyIntoleranceRecordId.setValue(allergyIntoleranceRecordId);
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
    public ObservationIntoleranceType getAllergyIntoleranceType() {
        return (ObservationIntoleranceType) this.allergyIntoleranceType.getValue();
    }
    public void setAllergyIntoleranceType(ObservationIntoleranceType allergyIntoleranceType) {
        this.allergyIntoleranceType.setValue(allergyIntoleranceType);
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
    public Boolean getAllergyIntoleranceRefuted() {
        return this.allergyIntoleranceRefuted.getValue();
    }
    public void setAllergyIntoleranceRefuted(Boolean allergyIntoleranceRefuted) {
        this.allergyIntoleranceRefuted.setValue(allergyIntoleranceRefuted);
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
    public ActStatus getAllergyIntoleranceStatus() {
        return (ActStatus) this.allergyIntoleranceStatus.getValue();
    }
    public void setAllergyIntoleranceStatus(ActStatus allergyIntoleranceStatus) {
        this.allergyIntoleranceStatus.setValue(allergyIntoleranceStatus);
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
    public Date getAllergyIntoleranceDate() {
        return this.allergyIntoleranceDate.getValue();
    }
    public void setAllergyIntoleranceDate(Date allergyIntoleranceDate) {
        this.allergyIntoleranceDate.setValue(allergyIntoleranceDate);
    }


    /**
     * <p>H:Allergy/Intolerance Masking Indicators</p>
     * 
     * <p><p>Communicates the desire of the patient to restrict 
     * access to this Health Condition record. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Methods for 
     * accessing masked event records will be governed by each 
     * jurisdiction (e.g. court orders, shared secret/consent, 
     * etc.). Can also be used to communicate that the information 
     * is deemed to be sensitive and should not be communicated or 
     * exposed to the patient (at least without the guidance of the 
     * authoring or other responsible healthcare provider). Valid 
     * values are: 'normal' (denotes 'Not Masked'); 'restricted' 
     * (denotes 'Masked'); '''very restricted''' (denotes '''Masked 
     * by Regulation'''); and 'taboo' (denotes 'patient 
     * restricted'). The default is 'normal' signifying 'Not 
     * Masked'. Either or both of the other codes can be asserted 
     * to indicate masking by the patient from providers or masking 
     * by a provider from the patient, respectively. 'normal' 
     * should never be asserted with one of the other codes.</p></p>
     * 
     * <p><p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Can'''t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p></p>
     * 
     * <p><p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Can'''t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p></p>
     * 
     * <p><p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Can'''t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p></p>
     * 
     * <p><p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Can'''t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getAllergyIntoleranceMaskingIndicators() {
        return this.allergyIntoleranceMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
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
     * allergy or intolerance record must be tagged as either U or 
     * N.</p></p>
     * 
     * <p><p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either U or 
     * N.</p></p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getConfirmedIndicator() {
        return (ActUncertainty) this.confirmedIndicator.getValue();
    }
    public void setConfirmedIndicator(ActUncertainty confirmedIndicator) {
        this.confirmedIndicator.setValue(confirmedIndicator);
    }


    /**
     * <p>B:Agent</p>
     * 
     * <p><p>Value is not permitted when using SNOMED, mandatory 
     * otherwise</p></p>
     * 
     * <p><p>Indicates the substance to which the patient is 
     * allergic</p></p>
     * 
     * <p><p>Critical for identifying the allergy or intolerance. 
     * However, because the attribute is not used for SNOMED, it is 
     * optional.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public IntoleranceValue getAgent() {
        return (IntoleranceValue) this.agent.getValue();
    }
    public void setAgent(IntoleranceValue agent) {
        this.agent.setValue(agent);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
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
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


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


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public AllergyIntoleranceStatusChangesBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }
    public void setSubjectOf1ControlActEvent(AllergyIntoleranceStatusChangesBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    @Hl7XmlMapping({"subjectOf3/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf3SeverityObservation() {
        return this.subjectOf3SeverityObservation;
    }
    public void setSubjectOf3SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf3SeverityObservation) {
        this.subjectOf3SeverityObservation = subjectOf3SeverityObservation;
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
