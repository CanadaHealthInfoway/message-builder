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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.immunization.poiz_mt030050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActNoImmunizationReason;
import ca.infoway.messagebuilder.domainvalue.HumanSubstanceAdministrationSite;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt050203ca.PatientBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.immunization.merged.PartOfBean;
import java.util.Date;



/**
 * <p>Business Name: Immunization</p>
 * 
 * <p>approachSite must be required if not using SNOMED</p>
 * 
 * <p>Route must be required if not using SNOMED</p>
 * 
 * <p>If immunization was not refused, then refusal reason must 
 * not be specified otherwise field should be treated as 
 * populated.</p>
 * 
 * <p>Allows capturing a patient's immunization profile</p>
 * 
 * <p>Represents a single immunization occurrence for a 
 * particular patient</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Immunization"})
@Hl7RootType
public class ImmunizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private TS effectiveTime = new TSImpl();
    private CV confidentialityCode = new CVImpl();
    private CV reasonCode = new CVImpl();
    private CV routeCode = new CVImpl();
    private CV approachSiteCode = new CVImpl();
    private PQ doseQuantity = new PQImpl();
    private PatientBean subjectPatient;
    private DrugProductBean consumableMedication;
    private InformantionSourceRoleBean informantInformantionSourceRole;
    private PartOfBean inFulfillmentOf;
    private NotesBean subjectOfAnnotation;
    private BL causeAdverseReactionObservationEvent = new BLImpl(false);


    /**
     * <p>Business Name: Immunization Type</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the type of administration is an 
     * administration, and for SNOMED, also indicates the specific 
     * type of administration. Thus the attribute is mandatory. The 
     * datatype is CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>Indicates what type of administration is being 
     * performed.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Immunization Type</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the type of administration is an 
     * administration, and for SNOMED, also indicates the specific 
     * type of administration. Thus the attribute is mandatory. The 
     * datatype is CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>Indicates what type of administration is being 
     * performed.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Not Immunized?</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>NotImmunizedFlag</p>
     * 
     * <p>CompletionStstus (true = Not administered)</p>
     * 
     * <p>Tracking failures to be immunized is also important in 
     * immunization reporting. This flag must always be known and 
     * is always mandatory.</p>
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
     * <p>Relationship: POIZ_MT030050CA.Immunization.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>NotImmunizedFlag</p>
     * 
     * <p>CompletionStstus (true = Not administered)</p>
     * 
     * <p>Tracking failures to be immunized is also important in 
     * immunization reporting. This flag must always be known and 
     * is always mandatory.</p>
     * 
     * <p>An explicit indication that a person has not been 
     * immunized with the specified vaccine at the time 
     * indicated.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: C:Immunization Date</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DateOfVaccination</p>
     * 
     * <p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p>
     * 
     * <p>The date vaccination(s) was administered to the 
     * patient.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Immunization Date</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DateOfVaccination</p>
     * 
     * <p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p>
     * 
     * <p>The date vaccination(s) was administered to the 
     * patient.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: D:Immunization Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.Immunization.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Denotes access restriction placed on the immunization 
     * record. Methods for accessing masked immunization records 
     * will be governed by each jurisdiction (e.g. court orders, 
     * shared secret/consent, etc.).</p><p>The default is 
     * 'NORMAL'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: D:Immunization Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.Immunization.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Denotes access restriction placed on the immunization 
     * record. Methods for accessing masked immunization records 
     * will be governed by each jurisdiction (e.g. court orders, 
     * shared secret/consent, etc.).</p><p>The default is 
     * 'NORMAL'.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: Immunization Refusal Reason</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompletionStatus (Refused)</p>
     * 
     * <p>Useful information for planning future immunization 
     * encounters for the patient.</p>
     * 
     * <p>A coded value denoting a patient's reason for refusing to 
     * be immunized.</p><p>Typical reasons include: Parental 
     * decision, Religious exemption, Patient decision, etc</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActNoImmunizationReason getReasonCode() {
        return (ActNoImmunizationReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: Immunization Refusal Reason</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompletionStatus (Refused)</p>
     * 
     * <p>Useful information for planning future immunization 
     * encounters for the patient.</p>
     * 
     * <p>A coded value denoting a patient's reason for refusing to 
     * be immunized.</p><p>Typical reasons include: Parental 
     * decision, Religious exemption, Patient decision, etc</p>
     */
    public void setReasonCode(ActNoImmunizationReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Business Name: E:Route of Administration</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>RXR-1</p>
     * 
     * <p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>This is the means by which the drug was administered to 
     * the patient.</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>Business Name: E:Route of Administration</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>RXR-1</p>
     * 
     * <p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>This is the means by which the drug was administered to 
     * the patient.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Business Name: Administration Site</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.Immunization.approachSiteCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>RXR.2</p>
     * 
     * <p>Some immunizations are intended to adjust from site to 
     * site. (E.g. if first injection is given in right deltoid, 
     * first booster should be given in left 
     * deltoid.)</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>A coded value denoting the body area where the 
     * immunization was administered.</p><p>This is also referred 
     * to as the anatomical site of vaccination.</p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public HumanSubstanceAdministrationSite getApproachSiteCode() {
        return (HumanSubstanceAdministrationSite) this.approachSiteCode.getValue();
    }

    /**
     * <p>Business Name: Administration Site</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.Immunization.approachSiteCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>RXR.2</p>
     * 
     * <p>Some immunizations are intended to adjust from site to 
     * site. (E.g. if first injection is given in right deltoid, 
     * first booster should be given in left 
     * deltoid.)</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>A coded value denoting the body area where the 
     * immunization was administered.</p><p>This is also referred 
     * to as the anatomical site of vaccination.</p>
     */
    public void setApproachSiteCode(HumanSubstanceAdministrationSite approachSiteCode) {
        this.approachSiteCode.setValue(approachSiteCode);
    }


    /**
     * <p>Business Name: Quantity Administered</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Useful for evaluating reaction and for checking 
     * contraindication.</p><p>Attribute is populated to allow for 
     * situations where quantity may not be known and thus null 
     * flavor must be specified.</p>
     * 
     * <p>The amount of the vaccine administered to/by the 
     * patient.</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public PhysicalQuantity getDoseQuantity() {
        return this.doseQuantity.getValue();
    }

    /**
     * <p>Business Name: Quantity Administered</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Immunization.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Useful for evaluating reaction and for checking 
     * contraindication.</p><p>Attribute is populated to allow for 
     * situations where quantity may not be known and thus null 
     * flavor must be specified.</p>
     * 
     * <p>The amount of the vaccine administered to/by the 
     * patient.</p>
     */
    public void setDoseQuantity(PhysicalQuantity doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    /**
     * <p>Relationship: POIZ_MT030050CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: POIZ_MT030050CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: POIZ_MT030050CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }

    /**
     * <p>Relationship: POIZ_MT030050CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT030050CA.Informant.informantionSourceRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informant/informantionSourceRole"})
    public InformantionSourceRoleBean getInformantInformantionSourceRole() {
        return this.informantInformantionSourceRole;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT030050CA.Informant.informantionSourceRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInformantInformantionSourceRole(InformantionSourceRoleBean informantInformantionSourceRole) {
        this.informantInformantionSourceRole = informantInformantionSourceRole;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT030050CA.Immunization.inFulfillmentOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf"})
    public PartOfBean getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT030050CA.Immunization.inFulfillmentOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setInFulfillmentOf(PartOfBean inFulfillmentOf) {
        this.inFulfillmentOf = inFulfillmentOf;
    }


    /**
     * <p>Relationship: POIZ_MT030050CA.Subject9.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }

    /**
     * <p>Relationship: POIZ_MT030050CA.Subject9.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT030050CA.CauseOf.adverseReactionObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"cause/adverseReactionObservationEvent"})
    public Boolean getCauseAdverseReactionObservationEvent() {
        return this.causeAdverseReactionObservationEvent.getValue();
    }

    /**
     * <p>Relationship: 
     * POIZ_MT030050CA.CauseOf.adverseReactionObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCauseAdverseReactionObservationEvent(Boolean causeAdverseReactionObservationEvent) {
        this.causeAdverseReactionObservationEvent.setValue(causeAdverseReactionObservationEvent);
    }

}
