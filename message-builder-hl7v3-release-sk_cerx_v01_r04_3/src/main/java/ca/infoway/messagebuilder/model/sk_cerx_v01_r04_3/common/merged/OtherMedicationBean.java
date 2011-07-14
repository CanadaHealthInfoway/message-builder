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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt220100ca.DrugProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.porx_mt980040ca.AdministrationInstructionsBean;



/**
 * <p>OtherMedication</p>
 * 
 * <p>PORX_MT040020CA.OtherMedication: Other Medication</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A record of 
 * an 'other medication'. Other medications include any drug 
 * product deemed relevant to the patient's drug profile, but 
 * which was not specifically ordered by a prescriber. Examples 
 * include over-the counter medications that were not 
 * specifically ordered, herbal remedies, and recreational 
 * drugs.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
 * medication record being updated.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">While SNOMED 
 * codes may pre-coordinate the drug code, the drug must not be 
 * modified. However route information for a drug may be 
 * updated.</p></p>
 * 
 * <p>PORX_MT040010CA.OtherMedication: Other Medication</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A record of 
 * a medication the patient is believed to be taking, but for 
 * which an electronic order does not exist. 'Other 
 * medications' include any drug product deemed relevant to the 
 * patient's drug profile, but which was not specifically 
 * ordered by a prescriber in a DIS-enabled jurisdiction. 
 * Examples include over-the counter medications that were not 
 * specifically ordered, herbal remedies, and recreational 
 * drugs. Prescription drugs that the patient may be taking but 
 * were not prescribed on the EHR (e.g. institutionally 
 * administered or out-of-jurisdiction prescriptions) will also 
 * be recorded here.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Necessary 
 * component of a person's overall medication profile. Allows 
 * DUR checking against a more complete drug profile.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT040010CA.OtherMedication","PORX_MT040020CA.OtherMedication"})
@Hl7RootType
public class OtherMedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private II otherMedicationId = new IIImpl();
    private CS medicationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> drugActivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV routeCode = new CVImpl();
    private Patient_1Bean subjectPatient;
    private CV confidentialityCode = new CVImpl();
    private List<AdministrationInstructionsBean> componentDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private DrugProductBean consumableMedication;
    private CommentBean subjectOfAnnotation;


    /**
     * <p>OtherMedicationId</p>
     * 
     * <p>A:Other Medication Id</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifier 
     * of the Other Medication record that needs to be updated.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Uniquely 
     * identifies the record to be updated and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getOtherMedicationId() {
        return this.otherMedicationId.getValue();
    }
    public void setOtherMedicationId(Identifier otherMedicationId) {
        this.otherMedicationId.setValue(otherMedicationId);
    }


    /**
     * <p>MedicationStatus</p>
     * 
     * <p>(no business name)</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This denotes 
     * a state in the lifecycle of the other medication. Valid 
     * statuses are: 'ACTIVE' and 'COMPLETED' only.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * what actions are allowed to be performed against an other 
     * medication record. This is a mandatory field because every 
     * recorded 'other medication' needs to be in some state.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Note ------ The 
     * provider might know that the patient is not taking the 
     * medication but not necessarily when the patient stopped it. 
     * Thus the status of the medication could be set to 
     * 'COMPLETED' by the provider without necessarily setting an 
     * End Date on the medication record.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * what actions are allowed to be performed against an other 
     * medication record. This is a mandatory field because every 
     * recorded 'other medication' needs to be in some state.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Note ------ The 
     * provider might know that the patient is not taking the 
     * medication but not necessarily when the patient stopped it. 
     * Thus the status of the medication could be set to 
     * 'COMPLETED' by the provider without necessarily setting an 
     * End Date on the medication record.</p></p>
     * 
     * <p><p>Indicates the status of the other medication record. 
     * <strong>Only 'active' and 'completed' are allowed. 
     * Otherwise, a CODE_INVAL error issue will be 
     * returned.</strong></p></p>
     * 
     * <p>B:Medication Status</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * whether the medication is still considered active.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Valid status can 
     * only be 'ACTIVE' or 'COMPLETED'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * whether the medication is still considered active.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Valid status can 
     * only be 'ACTIVE' or 'COMPLETED'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the new state of the medication and is therefore 
     * mandatory.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Note ------ The 
     * provider might know that the patient is not taking the 
     * medication but not necessarily when the patient stopped it. 
     * Thus the status of the medication could be set to 
     * 'COMPLETED' by the provider without necessarily setting an 
     * End Date on the medication record.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the new state of the medication and is therefore 
     * mandatory.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Note ------ The 
     * provider might know that the patient is not taking the 
     * medication but not necessarily when the patient stopped it. 
     * Thus the status of the medication could be set to 
     * 'COMPLETED' by the provider without necessarily setting an 
     * End Date on the medication record.</p></p>
     * 
     * <p><p>If not active or completed, a CODE_INVAL error issue 
     * will be returned.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getMedicationStatus() {
        return (ActStatus) this.medicationStatus.getValue();
    }
    public void setMedicationStatus(ActStatus medicationStatus) {
        this.medicationStatus.setValue(medicationStatus);
    }


    /**
     * <p>DrugActivePeriod</p>
     * 
     * <p>C:Drug Active Period</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The new 
     * period in which the active medication is deemed to be 
     * active.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * drug active period information to be changed.</p></p>
     * 
     * <p>d:Drug Active Period</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the time-period in which the patient has been taking or is 
     * expected to be taking the medication.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.5</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.5</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.5</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.13.5</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used to help 
     * determine whether the medication is currently active. 
     * Because this information won't always be available, the 
     * attribute is marked as 'populated'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Either the 
     * start or end or both can be null if they are not known.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDrugActivePeriod() {
        return this.drugActivePeriod.getValue();
    }
    public void setDrugActivePeriod(Interval<Date> drugActivePeriod) {
        this.drugActivePeriod.setValue(drugActivePeriod);
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
     * means by which the patient is taking the other 
     * medication.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Route of 
     * administration</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Ensures 
     * consistency in description of routes. Provides potential for 
     * cross-checking dosage form and route. Because this 
     * information is pre-coordinated into 'code' for SNOMED, it is 
     * marked as optional.</p></p>
     * 
     * <p><p><strong>Because PIN is not using SNOMED, this element 
     * is mandatory.</strong></p></p>
     * 
     * <p>(no business name)</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
     * means by which the patient is taking the other 
     * medication.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Ensures 
     * consistency in description of routes. Provides potential for 
     * cross-checking dosage form and route. Because this 
     * information is pre-coordinated into 'code' for SNOMED, it is 
     * marked as optional.</p></p>
     * 
     * <p><p><strong>Because PIN is not using SNOMED, this element 
     * is mandatory.</strong></p></p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Denotes 
     * access restriction place on the other medication record. 
     * Methods for accessing masked other medications will be 
     * governed by each jurisdiction (e.g. court orders, shared 
     * secret/consent, etc.).</p></p>
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
     * 
     * <p><p><strong>As SK does not implement record-level masking, 
     * this must be "Normal" or a CODE_INVAL error issue will be 
     * returned.</strong></p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    @Hl7XmlMapping({"component/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponentDosageInstruction() {
        return this.componentDosageInstruction;
    }


    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    @Hl7XmlMapping({"subjectOf/annotation"})
    public CommentBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(CommentBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
