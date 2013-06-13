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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt060190ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ServiceLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Other Medication</p>
 * 
 * <p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p>
 * 
 * <p>Status can only be '''ACTIVE''' or '''COMPLETED'''</p>
 * 
 * <p>Necessary component of a person's overall medication 
 * profile. Allows DUR checking against a more complete drug 
 * profile.</p>
 * 
 * <p>A record of a medication the patient is believed to be 
 * taking, but for which an electronic order does not exist. 
 * &quot;Other medications&quot; include any drug product 
 * deemed relevant to the patient's drug profile, but which was 
 * not specifically ordered by a prescriber in a DIS-enabled 
 * jurisdiction. Examples include over-the counter medications 
 * that were not specifically ordered, herbal remedies, and 
 * recreational drugs. Prescription drugs that the patient may 
 * be taking but was not prescribed on the EHR (e.g. 
 * institutionally administered or out-of-jurisdiction 
 * prescriptions) will also be recorded here.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060190CA.OtherMedication"})
public class OtherMedicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.MedicationRecord {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV routeCode = new CVImpl();
    private DrugProductBean consumableMedication;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private RefusedByBean author;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private BL subjectOf1DetectedIssueIndicator = new BLImpl(false);
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: A:Other Medication Record Number</p>
     * 
     * <p>Relationship: PORX_MT060190CA.OtherMedication.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique referencing of a specific other 
     * medication record. Thus the mandatory requirement. .</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * other medication record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Other Medication Record Number</p>
     * 
     * <p>Relationship: PORX_MT060190CA.OtherMedication.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique referencing of a specific other 
     * medication record. Thus the mandatory requirement. .</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * other medication record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Other Medication Type</p>
     * 
     * <p>Relationship: PORX_MT060190CA.OtherMedication.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Must be 'DRUG' unless using SNOMED</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Indicates that the record is a drug administration rather 
     * than an immunization or other type of administration. For 
     * SNOMED, may also include route, drug and other 
     * information.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Other Medication Type</p>
     * 
     * <p>Relationship: PORX_MT060190CA.OtherMedication.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Must be 'DRUG' unless using SNOMED</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Indicates that the record is a drug administration rather 
     * than an immunization or other type of administration. For 
     * SNOMED, may also include route, drug and other 
     * information.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: B:Other Medication Status</p>
     * 
     * <p>Relationship: PORX_MT060190CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking and therefore 
     * mandatory.</p><p>Note ------ The provider might know that 
     * the patient is not taking the medication but not necessarily 
     * when the patient stopped it. Thus the status of the 
     * medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Indicates the status of the other medication record 
     * created on the EHR/DIS. Valid statuses for other medication 
     * records are: ACTIVE, COMPLETE only.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: B:Other Medication Status</p>
     * 
     * <p>Relationship: PORX_MT060190CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to determine whether the medication should be 
     * considered in performing DUR checking and therefore 
     * mandatory.</p><p>Note ------ The provider might know that 
     * the patient is not taking the medication but not necessarily 
     * when the patient stopped it. Thus the status of the 
     * medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Indicates the status of the other medication record 
     * created on the EHR/DIS. Valid statuses for other medication 
     * records are: ACTIVE, COMPLETE only.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: C:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to indicate help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the active 
     * medication.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to indicate help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the active 
     * medication.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: D:Other Medication Masking Indicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.OtherMedication.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Can'''t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p>
     * 
     * <p>Denotes access restriction place on the other medication 
     * record. Methods for accessing masked other medications will 
     * be governed by each jurisdiction (e.g. court orders, shared 
     * secret/consent, etc.).</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Business Name: E:Route of Administration</p>
     * 
     * <p>Relationship: PORX_MT060190CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and 
     * route.</p><p>Because this information can be pre-coordinated 
     * with code by SNOMED, the attribute is optional.</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>Business Name: E:Route of Administration</p>
     * 
     * <p>Relationship: PORX_MT060190CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and 
     * route.</p><p>Because this information can be pre-coordinated 
     * with code by SNOMED, the attribute is optional.</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Relationship: PORX_MT060190CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }

    /**
     * <p>Relationship: PORX_MT060190CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060190CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060190CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Relationship: PORX_MT060190CA.OtherMedication.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: PORX_MT060190CA.OtherMedication.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060190CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060190CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060190CA.Subject7.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/detectedIssueIndicator"})
    public Boolean getSubjectOf1DetectedIssueIndicator() {
        return this.subjectOf1DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060190CA.Subject7.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1DetectedIssueIndicator(Boolean subjectOf1DetectedIssueIndicator) {
        this.subjectOf1DetectedIssueIndicator.setValue(subjectOf1DetectedIssueIndicator);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060190CA.Subject6.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060190CA.Subject6.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060190CA.Component2.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
