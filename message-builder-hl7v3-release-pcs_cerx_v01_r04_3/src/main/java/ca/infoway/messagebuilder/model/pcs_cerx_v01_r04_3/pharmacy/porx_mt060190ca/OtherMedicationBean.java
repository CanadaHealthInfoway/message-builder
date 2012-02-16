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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt060190ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RefusedByBean;
import java.util.Date;



/**
 * <p>Other Medication</p>
 * 
 * <p><p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p><p>Status can only be ACTIVE or 
 * COMPLETED</p></p>
 * 
 * <p><p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p><p>Status can only be ACTIVE or 
 * COMPLETED</p></p>
 * 
 * <p><p>A record of a medication the patient is believed to be 
 * taking, but for which an electronic order does not exist. 
 * &quot;Other medications&quot; include any drug product 
 * deemed relevant to the patient's drug profile, but which was 
 * not specifically ordered by a prescriber in a DIS-enabled 
 * jurisdiction. Examples include over-the counter medications 
 * that were not specifically ordered, herbal remedies, and 
 * recreational drugs. Prescription drugs that the patient may 
 * be taking but was not prescribed on the EHR (e.g. 
 * institutionally administered or out-of-jurisdiction 
 * prescriptions) will also be recorded here.</p></p>
 * 
 * <p><p>Necessary component of a person's overall medication 
 * profile. Allows DUR checking against a more complete drug 
 * profile.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060190CA.OtherMedication"})
public class OtherMedicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.MedicationRecord {

    private static final long serialVersionUID = 20120215L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private CV routeCode = new CVImpl();
    private PatientBean subjectPatient;
    private DrugProductBean consumableMedication;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private RecordedAtBean location;
    private BL subjectOf1DetectedIssueIndicator = new BLImpl(false);
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);


    /**
     * <p>A:Other Medication Record Number</p>
     * 
     * <p><p>This is an identifier assigned to a unique instance of 
     * an other medication record.</p></p>
     * 
     * <p><p>Allows for the unique referencing of a specific other 
     * medication record. Thus the mandatory requirement. .</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Other Medication Type</p>
     * 
     * <p><p>Must be 'DRUG' unless using SNOMED</p></p>
     * 
     * <p><p>Indicates that the record is a drug administration 
     * rather than an immunization or other type of administration. 
     * For SNOMED, may also include route, drug and other 
     * information.</p></p>
     * 
     * <p><p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p></p>
     * 
     * <p><p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>B:Other Medication Status</p>
     * 
     * <p><p>Indicates the status of the other medication record 
     * created on the EHR/DIS. Valid statuses for other medication 
     * records are: ACTIVE, COMPLETE only.</p></p>
     * 
     * <p><p>Used to determine whether the medication should be 
     * considered in performing DUR checking and therefore 
     * mandatory.</p><p>Note ------ The provider might know that 
     * the patient is not taking the medication but not necessarily 
     * when the patient stopped it. Thus the status of the 
     * medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p></p>
     * 
     * <p><p>Used to determine whether the medication should be 
     * considered in performing DUR checking and therefore 
     * mandatory.</p><p>Note ------ The provider might know that 
     * the patient is not taking the medication but not necessarily 
     * when the patient stopped it. Thus the status of the 
     * medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>C:Drug Active Period</p>
     * 
     * <p><p>Indicates the time-period in which the patient has 
     * been taking or is expected to be taking the active 
     * medication.</p></p>
     * 
     * <p><p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p></p>
     * 
     * <p><p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p></p>
     * 
     * <p><p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p></p>
     * 
     * <p><p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p></p>
     * 
     * <p><p>Used to indicate help determine whether the medication 
     * is currently active. Because this information won't always 
     * be available, the attribute is marked as 'populated'.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>D:Other Medication Masking Indicator</p>
     * 
     * <p><p>Denotes access restriction place on the other 
     * medication record. Methods for accessing masked other 
     * medications will be governed by each jurisdiction (e.g. 
     * court orders, shared secret/consent, etc.).</p></p>
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
     * <p>E:Route of Administration</p>
     * 
     * <p><p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p></p>
     * 
     * <p><p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and 
     * route.</p><p>Because this information can be pre-coordinated 
     * with code by SNOMED, the attribute is optional.</p></p>
     * 
     * <p><p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and 
     * route.</p><p>Because this information can be pre-coordinated 
     * with code by SNOMED, the attribute is optional.</p></p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


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


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueIndicator"})
    public Boolean getSubjectOf1DetectedIssueIndicator() {
        return this.subjectOf1DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf1DetectedIssueIndicator(Boolean subjectOf1DetectedIssueIndicator) {
        this.subjectOf1DetectedIssueIndicator.setValue(subjectOf1DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }

}
