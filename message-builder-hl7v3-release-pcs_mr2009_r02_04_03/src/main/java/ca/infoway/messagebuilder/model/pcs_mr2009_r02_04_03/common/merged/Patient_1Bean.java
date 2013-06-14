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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt050007ca.PatientIdentifyingCharacteristicsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.OtherSpecimenIdentificationsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Patient</p>
 * 
 * <p>COCT_MT050201CA.Patient: Patient</p>
 * 
 * <p>Used when patienty identity confirmation is handled as a 
 * distinct business process rather than as part of each 
 * transaction. Allows transactions to be linked to a specific 
 * patient.</p>
 * 
 * <p>A person who is receiving or may receive healthcare 
 * services and has had their identity previously confirmed</p>
 * 
 * <p>COCT_MT050007CA.Patient: Patient</p>
 * 
 * <p>Information used to identify the patient and to support 
 * clinical decisions. This information applies to the person 
 * in the context of the associated action only, and should be 
 * stored separately. I.e. the address/phone/email only apply 
 * to the current prescription/dispense/lab order etc.</p>
 * 
 * <p>A person who is receiving or may receive healthcare 
 * services and has personal attributes (e.g. name, birth 
 * date).</p>
 */
@Hl7PartTypeMapping({"COCT_MT050007CA.Patient","COCT_MT050201CA.Patient"})
@Hl7RootType
public class Patient_1Bean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Patient {

    private static final long serialVersionUID = 20130614L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private AD addr = new ADImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ST certificateText = new STImpl();
    private PN patientPersonName = new PNImpl();
    private CV patientPersonAdministrativeGenderCode = new CVImpl();
    private TS patientPersonBirthTime = new TSImpl();
    private BL patientPersonDeceasedInd = new BLImpl();
    private TS patientPersonDeceasedTime = new TSImpl();
    private List<OtherSpecimenIdentificationsBean> patientPersonAsIdentifiedEntity = new ArrayList<OtherSpecimenIdentificationsBean>();
    private PatientIdentifyingCharacteristicsBean subjectOfIdentifyingCharacteristicsObservationEvent;


    /**
     * <p>Business Name: PatientIdentifier</p>
     * 
     * <p>Un-merged Business Name: PatientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT050201CA.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-3)</p>
     * 
     * <p>C39 (Extension)</p>
     * 
     * <p>PTT.050.01 (Extension)</p>
     * 
     * <p>PTT.050.02 (Root)</p>
     * 
     * <p>A.1</p>
     * 
     * <p>PID.2</p>
     * 
     * <p>Patient.332-CY (Extension)</p>
     * 
     * <p>Patient.331-CX (Root)</p>
     * 
     * <p>Claim.330-CW</p>
     * 
     * <p>Health Card Number</p>
     * 
     * <p>PID.2</p>
     * 
     * <p>PID.4</p>
     * 
     * <p>ZDU.2</p>
     * 
     * <p>ZKW.3</p>
     * 
     * <p>Jurisdiction (Root)</p>
     * 
     * <p>Person.PHN (Extension)</p>
     * 
     * <p>Allows a patient to be referred to unambiguously. Because 
     * this is the principal mechanism for identifying patients to 
     * electronic systems, the attribute is mandatory. The 
     * cardinality of patient identifiers is up to 3 based on the 
     * use case to support communication of a local and 
     * jurisdictional identifier along with the national 
     * identifier.</p>
     * 
     * <p>Unique identifier issued as part of the patient identity 
     * verification process.</p>
     * 
     * <p>Un-merged Business Name: PatientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-3)</p>
     * 
     * <p>The cardinality of patient identifiers is up to 3 based 
     * on the use case to support communication of a local and 
     * jurisdictional identifier along with the national 
     * identifier.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: PatientAddress</p>
     * 
     * <p>Un-merged Business Name: PatientAddress</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Patient.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: PatientAddress</p>
     * 
     * <p>Un-merged Business Name: PatientAddress</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Patient.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: PatientContactPhoneAndEMails</p>
     * 
     * <p>Un-merged Business Name: PatientContactPhoneAndEMails</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Patient.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Business Name: PatientHealthCardVersionCode</p>
     * 
     * <p>Un-merged Business Name: PatientHealthCardVersionCode</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Patient.certificateText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"certificateText"})
    public String getCertificateText() {
        return this.certificateText.getValue();
    }

    /**
     * <p>Business Name: PatientHealthCardVersionCode</p>
     * 
     * <p>Un-merged Business Name: PatientHealthCardVersionCode</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Patient.certificateText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setCertificateText(String certificateText) {
        this.certificateText.setValue(certificateText);
    }


    /**
     * <p>Business Name: PatientName</p>
     * 
     * <p>Un-merged Business Name: PatientName</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used, with other patient identity attributes, to confirm 
     * patient identity, as well as when addressing the patient. 
     * Element is populated because the patient's name is 
     * frequently necessary for positive identification of the 
     * patient in the jurisdictional client registry.</p>
     * 
     * <p>The name by which the patient is known and which apply to 
     * a particular clinical action that has been reported or 
     * recorded.</p>
     */
    @Hl7XmlMapping({"patientPerson/name"})
    public PersonName getPatientPersonName() {
        return this.patientPersonName.getValue();
    }

    /**
     * <p>Business Name: PatientName</p>
     * 
     * <p>Un-merged Business Name: PatientName</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used, with other patient identity attributes, to confirm 
     * patient identity, as well as when addressing the patient. 
     * Element is populated because the patient's name is 
     * frequently necessary for positive identification of the 
     * patient in the jurisdictional client registry.</p>
     * 
     * <p>The name by which the patient is known and which apply to 
     * a particular clinical action that has been reported or 
     * recorded.</p>
     */
    public void setPatientPersonName(PersonName patientPersonName) {
        this.patientPersonName.setValue(patientPersonName);
    }


    /**
     * <p>Business Name: PatientGender</p>
     * 
     * <p>Un-merged Business Name: PatientGender</p>
     * 
     * <p>Relationship: 
     * COCT_MT050007CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p>
     * 
     * <p>Indicates the gender (sex) of the patient. Complex 
     * genetic genders are handled as observations if they are 
     * considered relevant.</p>
     */
    @Hl7XmlMapping({"patientPerson/administrativeGenderCode"})
    public AdministrativeGender getPatientPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.patientPersonAdministrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: PatientGender</p>
     * 
     * <p>Un-merged Business Name: PatientGender</p>
     * 
     * <p>Relationship: 
     * COCT_MT050007CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p>
     * 
     * <p>Indicates the gender (sex) of the patient. Complex 
     * genetic genders are handled as observations if they are 
     * considered relevant.</p>
     */
    public void setPatientPersonAdministrativeGenderCode(AdministrativeGender patientPersonAdministrativeGenderCode) {
        this.patientPersonAdministrativeGenderCode.setValue(patientPersonAdministrativeGenderCode);
    }


    /**
     * <p>Business Name: PatientBirthDatetime</p>
     * 
     * <p>Un-merged Business Name: PatientBirthDatetime</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    @Hl7XmlMapping({"patientPerson/birthTime"})
    public Date getPatientPersonBirthTime() {
        return this.patientPersonBirthTime.getValue();
    }

    /**
     * <p>Business Name: PatientBirthDatetime</p>
     * 
     * <p>Un-merged Business Name: PatientBirthDatetime</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    public void setPatientPersonBirthTime(Date patientPersonBirthTime) {
        this.patientPersonBirthTime.setValue(patientPersonBirthTime);
    }


    /**
     * <p>Business Name: PatientDeceasedIndicator</p>
     * 
     * <p>Un-merged Business Name: PatientDeceasedIndicator</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates whether the patient is deceased.</p>
     */
    @Hl7XmlMapping({"patientPerson/deceasedInd"})
    public Boolean getPatientPersonDeceasedInd() {
        return this.patientPersonDeceasedInd.getValue();
    }

    /**
     * <p>Business Name: PatientDeceasedIndicator</p>
     * 
     * <p>Un-merged Business Name: PatientDeceasedIndicator</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates whether the patient is deceased.</p>
     */
    public void setPatientPersonDeceasedInd(Boolean patientPersonDeceasedInd) {
        this.patientPersonDeceasedInd.setValue(patientPersonDeceasedInd);
    }


    /**
     * <p>Business Name: PatientDeceasedDatetime</p>
     * 
     * <p>Un-merged Business Name: PatientDeceasedDatetime</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time the patient died or was ruled 
     * &quot;deceased.&quot;</p>
     */
    @Hl7XmlMapping({"patientPerson/deceasedTime"})
    public Date getPatientPersonDeceasedTime() {
        return this.patientPersonDeceasedTime.getValue();
    }

    /**
     * <p>Business Name: PatientDeceasedDatetime</p>
     * 
     * <p>Un-merged Business Name: PatientDeceasedDatetime</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time the patient died or was ruled 
     * &quot;deceased.&quot;</p>
     */
    public void setPatientPersonDeceasedTime(Date patientPersonDeceasedTime) {
        this.patientPersonDeceasedTime.setValue(patientPersonDeceasedTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.asIdentifiedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-4)</p>
     */
    @Hl7XmlMapping({"patientPerson/asIdentifiedEntity"})
    public List<OtherSpecimenIdentificationsBean> getPatientPersonAsIdentifiedEntity() {
        return this.patientPersonAsIdentifiedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT050007CA.Subject.identifyingCharacteristicsObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/identifyingCharacteristicsObservationEvent"})
    public PatientIdentifyingCharacteristicsBean getSubjectOfIdentifyingCharacteristicsObservationEvent() {
        return this.subjectOfIdentifyingCharacteristicsObservationEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT050007CA.Subject.identifyingCharacteristicsObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOfIdentifyingCharacteristicsObservationEvent(PatientIdentifyingCharacteristicsBean subjectOfIdentifyingCharacteristicsObservationEvent) {
        this.subjectOfIdentifyingCharacteristicsObservationEvent = subjectOfIdentifyingCharacteristicsObservationEvent;
    }

}
