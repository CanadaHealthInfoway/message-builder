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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.HumanSubstanceAdministrationSite;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.AdministeredByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Immunizations</p>
 * 
 * <p>POIZ_MT060150CA.Immunization: Immunizations</p>
 * 
 * <p><p>A record of products administered to a patient 
 * specific to immunization.</p></p>
 * 
 * <p><p>Necessary component of a person's overall vaccine 
 * profile. Helps deal with outbreaks and also vaccine 
 * contraindication checking.</p></p>
 * 
 * <p>POIZ_MT030050CA.Immunization: Immunizations</p>
 * 
 * <p><p>A record of products administered to a patient 
 * specific to immunization.</p></p>
 * 
 * <p><p>Necessary component of a person's overall vaccine 
 * profile. Helps deal with outbreaks and also vaccine 
 * contraindication checking.</p></p>
 * 
 * <p>POIZ_MT030060CA.Immunization: Immunizations</p>
 * 
 * <p><p>A record of products administered to a patient 
 * specific to immunization.</p></p>
 * 
 * <p><p>Necessary component of a person's overall vaccine 
 * profile. Helps deal with outbreaks and also vaccine 
 * contraindication checking.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Immunization","POIZ_MT030060CA.Immunization","POIZ_MT060150CA.Immunization"})
@Hl7RootType
public class ImmunizationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV uncertaintyCode = new CVImpl();
    private CV routeCode = new CVImpl();
    private CV approachSiteCode = new CVImpl();
    private PQ doseQuantity = new PQImpl();
    private AdministeredToBean subject;
    private VaccineBean consumableAdministerableMedicineAdministerableVaccine;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private AdministeredByBean performer;
    private HealthcareWorkerBean authorAssignedEntity;
    private InformantBean informant;
    private HealthcareWorkerBean authenticatorAssignedEntity;
    private OccurredAtBean location;
    private InFulfillmentOfBean inFulfillmentOf;
    private ReasonBean reason;
    private ConsentBean authorizationConsent;
    private List<PatientImmunizationObservationsBean> pertinentInformationPatientImmunizationObservations = new ArrayList<PatientImmunizationObservationsBean>();
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();
    private InvestigationEventBean cause1InvestigationEvent;
    private List<IntoleranceConditionBean> cause2IntoleranceCondition = new ArrayList<IntoleranceConditionBean>();
    private HealthDocumentBean referencedByHealthDocument;


    /**
     * <p>ImmunizationEventID</p>
     * 
     * <p>A:Immunization Event ID</p>
     * 
     * <p><p>This is an identifier assigned to a unique instance of 
     * an immunization record.</p></p>
     * 
     * <p><p>Allows for the unique referencing of a specific 
     * immunization record. Thus the mandatory requirement.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>NotImmunized</p>
     * 
     * <p>Not Immunized?</p>
     * 
     * <p><p>An explicit indication that a person has not been 
     * immunized with the specified vaccine at the time 
     * indicated.</p></p>
     * 
     * <p><p>Tracking failures to be immunized is also important in 
     * immunization reporting. Marked as mandatory because it is 
     * not meaningful for this flag to be 'unknown'.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>ImmunizationEventStatus</p>
     * 
     * <p>Immunization Event Status</p>
     * 
     * <p><p>Status of the immunization event</p></p>
     * 
     * <p><p>Needed to differentiate between valid, obsolete and 
     * invalid immunization events (e.g. immunization event has 
     * been retracted or nullified) and is therefore mandatory.</p></p>
     * 
     * <p><p>Nullified=Retracted</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>ImmunizationDate</p>
     * 
     * <p>Immunization Date</p>
     * 
     * <p><p>The date the vaccine was administered to the 
     * patient.</p></p>
     * 
     * <p><p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>ImmunizationMaskingIndicators</p>
     * 
     * <p>Immunization Masking Indicators</p>
     * 
     * <p><p>Denotes access restriction place on the immunization 
     * record.</p></p>
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
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>UncertaintyCode</p>
     * 
     * <p>Uncertainty Code</p>
     * 
     * <p><p>An indication of uncertainty regarding an immunization 
     * event</p></p>
     * 
     * <p><p>Allows for users of information to determine the 
     * degree of uncertainty regarding the details of an 
     * immunization event and is therefore populated.</p></p>
     * 
     * <p><p>Only populated when it is needed to communicate a 
     * degree of uncertainty - i.e. historical information.</p></p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }


    /**
     * <p>RouteOfAdministration</p>
     * 
     * <p>Route of Administration</p>
     * 
     * <p><p>RouteCode is Required if not using SNOMED.</p></p>
     * 
     * <p><p>The route by which the drug was administered to the 
     * patient, for example, sub-cutaneous, intra-muscular</p></p>
     * 
     * <p><p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked 'optional' to allow for 
     * use of pre-coordinated SNOMED Codes.</p></p>
     * 
     * <p><p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked 'optional' to allow for 
     * use of pre-coordinated SNOMED Codes.</p></p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>AnatomicalSite</p>
     * 
     * <p>Anatomical Site</p>
     * 
     * <p><p>approachSiteCode is Required if not using SNOMED</p></p>
     * 
     * <p><p>A coded value denoting the body area where the 
     * immunization was administered.</p></p>
     * 
     * <p><p>Site of administration is needed for follow up in case 
     * of an adverse event and in some jurisdictions is part of the 
     * minimum dataset per national standard and legal client 
     * record.</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p></p>
     * 
     * <p><p>Site of administration is needed for follow up in case 
     * of an adverse event and in some jurisdictions is part of the 
     * minimum dataset per national standard and legal client 
     * record.</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p></p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public HumanSubstanceAdministrationSite getApproachSiteCode() {
        return (HumanSubstanceAdministrationSite) this.approachSiteCode.getValue();
    }
    public void setApproachSiteCode(HumanSubstanceAdministrationSite approachSiteCode) {
        this.approachSiteCode.setValue(approachSiteCode);
    }


    /**
     * <p>QuantityAdministered</p>
     * 
     * <p>Quantity Administered</p>
     * 
     * <p><p>The amount of the drug product administered to/by the 
     * patient.</p></p>
     * 
     * <p><p>Useful for evaluating reaction, evaluating vaccine 
     * failure and for checking contraindication.</p><p>Attribute 
     * is populated to allow for situations where quantity may not 
     * be known and thus null flavor must be specified.</p></p>
     * 
     * <p><p>Useful for evaluating reaction, evaluating vaccine 
     * failure and for checking contraindication.</p><p>Attribute 
     * is populated to allow for situations where quantity may not 
     * be known and thus null flavor must be specified.</p></p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public PhysicalQuantity getDoseQuantity() {
        return this.doseQuantity.getValue();
    }
    public void setDoseQuantity(PhysicalQuantity doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    @Hl7XmlMapping({"subject"})
    public AdministeredToBean getSubject() {
        return this.subject;
    }
    public void setSubject(AdministeredToBean subject) {
        this.subject = subject;
    }


    @Hl7XmlMapping({"consumable/administerableMedicine/administerableVaccine"})
    public VaccineBean getConsumableAdministerableMedicineAdministerableVaccine() {
        return this.consumableAdministerableMedicineAdministerableVaccine;
    }
    public void setConsumableAdministerableMedicineAdministerableVaccine(VaccineBean consumableAdministerableMedicineAdministerableVaccine) {
        this.consumableAdministerableMedicineAdministerableVaccine = consumableAdministerableMedicineAdministerableVaccine;
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"performer"})
    public AdministeredByBean getPerformer() {
        return this.performer;
    }
    public void setPerformer(AdministeredByBean performer) {
        this.performer = performer;
    }


    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareWorkerBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }
    public void setAuthorAssignedEntity(HealthcareWorkerBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    @Hl7XmlMapping({"informant"})
    public InformantBean getInformant() {
        return this.informant;
    }
    public void setInformant(InformantBean informant) {
        this.informant = informant;
    }


    @Hl7XmlMapping({"authenticator/assignedEntity"})
    public HealthcareWorkerBean getAuthenticatorAssignedEntity() {
        return this.authenticatorAssignedEntity;
    }
    public void setAuthenticatorAssignedEntity(HealthcareWorkerBean authenticatorAssignedEntity) {
        this.authenticatorAssignedEntity = authenticatorAssignedEntity;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"inFulfillmentOf"})
    public InFulfillmentOfBean getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }
    public void setInFulfillmentOf(InFulfillmentOfBean inFulfillmentOf) {
        this.inFulfillmentOf = inFulfillmentOf;
    }


    @Hl7XmlMapping({"reason"})
    public ReasonBean getReason() {
        return this.reason;
    }
    public void setReason(ReasonBean reason) {
        this.reason = reason;
    }


    @Hl7XmlMapping({"authorization/consent"})
    public ConsentBean getAuthorizationConsent() {
        return this.authorizationConsent;
    }
    public void setAuthorizationConsent(ConsentBean authorizationConsent) {
        this.authorizationConsent = authorizationConsent;
    }


    @Hl7XmlMapping({"pertinentInformation/patientImmunizationObservations"})
    public List<PatientImmunizationObservationsBean> getPertinentInformationPatientImmunizationObservations() {
        return this.pertinentInformationPatientImmunizationObservations;
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf","subjectOf2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="POIZ_MT030050CA.Subject2"),
        @Hl7MapByPartType(name="subjectOf", type="POIZ_MT030060CA.Subject2"),
        @Hl7MapByPartType(name="subjectOf2", type="POIZ_MT060150CA.Subject2")})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }


    @Hl7XmlMapping({"cause1/investigationEvent"})
    public InvestigationEventBean getCause1InvestigationEvent() {
        return this.cause1InvestigationEvent;
    }
    public void setCause1InvestigationEvent(InvestigationEventBean cause1InvestigationEvent) {
        this.cause1InvestigationEvent = cause1InvestigationEvent;
    }


    @Hl7XmlMapping({"cause2/intoleranceCondition"})
    public List<IntoleranceConditionBean> getCause2IntoleranceCondition() {
        return this.cause2IntoleranceCondition;
    }


    @Hl7XmlMapping({"referencedBy/healthDocument"})
    public HealthDocumentBean getReferencedByHealthDocument() {
        return this.referencedByHealthDocument;
    }
    public void setReferencedByHealthDocument(HealthDocumentBean referencedByHealthDocument) {
        this.referencedByHealthDocument = referencedByHealthDocument;
    }

}