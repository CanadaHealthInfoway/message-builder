/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt060150ca;

import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt050207ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt260030ca.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.ConsentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.HealthDocumentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.InFulfillmentOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.IntoleranceConditionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.InvestigationEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.PatientImmunizationObservationsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.ReasonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.VaccineBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AdministeredByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Immunizations</p>
 * 
 * <p>Necessary component of a person's overall vaccine 
 * profile. Helps deal with outbreaks and also vaccine 
 * contraindication checking.</p>
 * 
 * <p>A record of products administered to a patient specific 
 * to immunization.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT060150CA.Immunization"})
@Hl7RootType
public class ImmunizationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV uncertaintyCode = new CVImpl();
    private CV approachSiteCode = new CVImpl();
    private CV routeCode = new CVImpl();
    private PQ doseQuantity = new PQImpl();
    private PatientBean subjectPatient;
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
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private InvestigationEventBean cause1InvestigationEvent;
    private List<IntoleranceConditionBean> cause2IntoleranceCondition = new ArrayList<IntoleranceConditionBean>();
    private HealthDocumentBean referencedByHealthDocument;


    /**
     * <p>Business Name: A:Immunization Event ID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique referencing of a specific 
     * immunization record. Thus the mandatory requirement.</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * immunization record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Immunization Event ID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique referencing of a specific 
     * immunization record. Thus the mandatory requirement.</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * immunization record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Not Immunized?</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Tracking failures to be immunized is also important in 
     * immunization reporting. Marked as mandatory because it is 
     * not meaningful for this flag to be 'unknown'.</p>
     * 
     * <p>An explicit indication that a person has not been 
     * immunized with the specified vaccine at the time 
     * indicated.</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: Not Immunized?</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Tracking failures to be immunized is also important in 
     * immunization reporting. Marked as mandatory because it is 
     * not meaningful for this flag to be 'unknown'.</p>
     * 
     * <p>An explicit indication that a person has not been 
     * immunized with the specified vaccine at the time 
     * indicated.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: Immunization Event Status</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to differentiate between valid, obsolete and 
     * invalid immunization events (e.g. immunization event has 
     * been retracted or nullified) and is therefore mandatory.</p>
     * 
     * <p>Nullified=Retracted</p>
     * 
     * <p>Status of the immunization event</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Immunization Event Status</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to differentiate between valid, obsolete and 
     * invalid immunization events (e.g. immunization event has 
     * been retracted or nullified) and is therefore mandatory.</p>
     * 
     * <p>Nullified=Retracted</p>
     * 
     * <p>Status of the immunization event</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Immunization Date</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p>
     * 
     * <p>The date the vaccine was administered to the patient.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Immunization Date</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p>
     * 
     * <p>The date the vaccine was administered to the patient.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Immunization Masking Indicators</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.Immunization.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Denotes access restriction place on the immunization 
     * record.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Business Name: Uncertainty Code</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.Immunization.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows for users of information to determine the degree 
     * of uncertainty regarding the details of an immunization 
     * event and is therefore populated.</p>
     * 
     * <p>Only populated when it is needed to communicate a degree 
     * of uncertainty - i.e. historical information.</p>
     * 
     * <p>An indication of uncertainty regarding an immunization 
     * event</p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }

    /**
     * <p>Business Name: Uncertainty Code</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.Immunization.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows for users of information to determine the degree 
     * of uncertainty regarding the details of an immunization 
     * event and is therefore populated.</p>
     * 
     * <p>Only populated when it is needed to communicate a degree 
     * of uncertainty - i.e. historical information.</p>
     * 
     * <p>An indication of uncertainty regarding an immunization 
     * event</p>
     */
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }


    /**
     * <p>Business Name: Anatomical Site</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.Immunization.approachSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>approachSiteCode is Required if not using SNOMED</p>
     * 
     * <p>Site of administration is needed for follow up in case of 
     * an adverse event and in some jurisdictions is part of the 
     * minimum dataset per national standard and legal client 
     * record.</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>A coded value denoting the body area where the 
     * immunization was administered.</p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public HumanSubstanceAdministrationSite getApproachSiteCode() {
        return (HumanSubstanceAdministrationSite) this.approachSiteCode.getValue();
    }

    /**
     * <p>Business Name: Anatomical Site</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.Immunization.approachSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>approachSiteCode is Required if not using SNOMED</p>
     * 
     * <p>Site of administration is needed for follow up in case of 
     * an adverse event and in some jurisdictions is part of the 
     * minimum dataset per national standard and legal client 
     * record.</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>A coded value denoting the body area where the 
     * immunization was administered.</p>
     */
    public void setApproachSiteCode(HumanSubstanceAdministrationSite approachSiteCode) {
        this.approachSiteCode.setValue(approachSiteCode);
    }


    /**
     * <p>Business Name: Route of Administration</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>RouteCode is Required if not using SNOMED.</p>
     * 
     * <p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked 'optional' to allow for 
     * use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>The route by which the drug was administered to the 
     * patient, for example, sub-cutaneous, intra-muscular</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>Business Name: Route of Administration</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>RouteCode is Required if not using SNOMED.</p>
     * 
     * <p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked 'optional' to allow for 
     * use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>The route by which the drug was administered to the 
     * patient, for example, sub-cutaneous, intra-muscular</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Business Name: Quantity Administered</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for evaluating reaction, evaluating vaccine 
     * failure and for checking contraindication.</p><p>Attribute 
     * is populated to allow for situations where quantity may not 
     * be known and thus null flavor must be specified.</p>
     * 
     * <p>The amount of the drug product administered to/by the 
     * patient.</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public PhysicalQuantity getDoseQuantity() {
        return this.doseQuantity.getValue();
    }

    /**
     * <p>Business Name: Quantity Administered</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Immunization.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for evaluating reaction, evaluating vaccine 
     * failure and for checking contraindication.</p><p>Attribute 
     * is populated to allow for situations where quantity may not 
     * be known and thus null flavor must be specified.</p>
     * 
     * <p>The amount of the drug product administered to/by the 
     * patient.</p>
     */
    public void setDoseQuantity(PhysicalQuantity doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: POIZ_MT060150CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.AdministerableMedicine.administerableVaccine</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/administerableMedicine/administerableVaccine"})
    public VaccineBean getConsumableAdministerableMedicineAdministerableVaccine() {
        return this.consumableAdministerableMedicineAdministerableVaccine;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.AdministerableMedicine.administerableVaccine</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableAdministerableMedicineAdministerableVaccine(VaccineBean consumableAdministerableMedicineAdministerableVaccine) {
        this.consumableAdministerableMedicineAdministerableVaccine = consumableAdministerableMedicineAdministerableVaccine;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Immunization.performer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"performer"})
    public AdministeredByBean getPerformer() {
        return this.performer;
    }

    /**
     * <p>Relationship: POIZ_MT060150CA.Immunization.performer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPerformer(AdministeredByBean performer) {
        this.performer = performer;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareWorkerBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    /**
     * <p>Relationship: POIZ_MT060150CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedEntity(HealthcareWorkerBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Immunization.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"informant"})
    public InformantBean getInformant() {
        return this.informant;
    }

    /**
     * <p>Relationship: POIZ_MT060150CA.Immunization.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setInformant(InformantBean informant) {
        this.informant = informant;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.Authenticator.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"authenticator/assignedEntity"})
    public HealthcareWorkerBean getAuthenticatorAssignedEntity() {
        return this.authenticatorAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.Authenticator.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAuthenticatorAssignedEntity(HealthcareWorkerBean authenticatorAssignedEntity) {
        this.authenticatorAssignedEntity = authenticatorAssignedEntity;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Immunization.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: POIZ_MT060150CA.Immunization.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.Immunization.inFulfillmentOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf"})
    public InFulfillmentOfBean getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.Immunization.inFulfillmentOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setInFulfillmentOf(InFulfillmentOfBean inFulfillmentOf) {
        this.inFulfillmentOf = inFulfillmentOf;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Immunization.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reason"})
    public ReasonBean getReason() {
        return this.reason;
    }

    /**
     * <p>Relationship: POIZ_MT060150CA.Immunization.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReason(ReasonBean reason) {
        this.reason = reason;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Authorization.consent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"authorization/consent"})
    public ConsentBean getAuthorizationConsent() {
        return this.authorizationConsent;
    }

    /**
     * <p>Relationship: POIZ_MT060150CA.Authorization.consent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAuthorizationConsent(ConsentBean authorizationConsent) {
        this.authorizationConsent = authorizationConsent;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.PertinentInformation.patientImmunizationObservations</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/patientImmunizationObservations"})
    public List<PatientImmunizationObservationsBean> getPertinentInformationPatientImmunizationObservations() {
        return this.pertinentInformationPatientImmunizationObservations;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Immunization.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-99)</p>
     */
    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.CauseOf.investigationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"cause1/investigationEvent"})
    public InvestigationEventBean getCause1InvestigationEvent() {
        return this.cause1InvestigationEvent;
    }

    /**
     * <p>Relationship: POIZ_MT060150CA.CauseOf.investigationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCause1InvestigationEvent(InvestigationEventBean cause1InvestigationEvent) {
        this.cause1InvestigationEvent = cause1InvestigationEvent;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT060150CA.CauseOf2.intoleranceCondition</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"cause2/intoleranceCondition"})
    public List<IntoleranceConditionBean> getCause2IntoleranceCondition() {
        return this.cause2IntoleranceCondition;
    }


    /**
     * <p>Relationship: POIZ_MT060150CA.Reference.healthDocument</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"referencedBy/healthDocument"})
    public HealthDocumentBean getReferencedByHealthDocument() {
        return this.referencedByHealthDocument;
    }

    /**
     * <p>Relationship: POIZ_MT060150CA.Reference.healthDocument</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReferencedByHealthDocument(HealthDocumentBean referencedByHealthDocument) {
        this.referencedByHealthDocument = referencedByHealthDocument;
    }

}
