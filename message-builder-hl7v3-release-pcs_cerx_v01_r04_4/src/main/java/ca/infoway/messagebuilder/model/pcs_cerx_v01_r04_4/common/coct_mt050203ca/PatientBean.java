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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.coct_mt050203ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Patient</p>
 * 
 * <p>Information used to identify the patient and to support 
 * clinical decisions. This information applies to the person 
 * in the context of the associated action only, and should be 
 * stored separately. I.e. the address/phone/email only apply 
 * to the current prescription/dispense/lab order etc.</p>
 * 
 * <p>A person who is receiving or may receive healthcare 
 * services and has personal attributes (e.g. name, birth 
 * date). .</p>
 */
@Hl7PartTypeMapping({"COCT_MT050203CA.Patient"})
@Hl7RootType
public class PatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.iehr.repc_mt000007ca.Consenter, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.iehr.repc_mt000012ca.Choice, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.pharmacy.merged.Patient, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.iehr.merged.Party {

    private static final long serialVersionUID = 20150904L;
    private II id = new IIImpl();
    private AD addr = new ADImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN patientPersonName = new PNImpl();
    private CV patientPersonAdministrativeGenderCode = new CVImpl();
    private TS patientPersonBirthTime = new TSImpl();


    /**
     * <p>Business Name: A:Patient ID</p>
     * 
     * <p>Relationship: COCT_MT050203CA.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * this is the principal mechanism for identifying humans, the 
     * attribute is mandatory. If an identifier is not known, it 
     * should be looked up using the 'client registry' capabilities 
     * of the EHR application.</p>
     * 
     * <p>Unique identifier assigned to a person by Federal, 
     * Provincial and Territorial jurisdiction for the purposes of 
     * uniquely identifying the person within the EHR.</p><p>The 
     * EHR will define which identifier to use within a 
     * jurisdiction.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Patient ID</p>
     * 
     * <p>Relationship: COCT_MT050203CA.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * this is the principal mechanism for identifying humans, the 
     * attribute is mandatory. If an identifier is not known, it 
     * should be looked up using the 'client registry' capabilities 
     * of the EHR application.</p>
     * 
     * <p>Unique identifier assigned to a person by Federal, 
     * Provincial and Territorial jurisdiction for the purposes of 
     * uniquely identifying the person within the EHR.</p><p>The 
     * EHR will define which identifier to use within a 
     * jurisdiction.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C:Patient Contact Address</p>
     * 
     * <p>Relationship: COCT_MT050203CA.Patient.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPA2.1 (use)</p>
     * 
     * <p>ZPA2.2 (usablePeriod(IVL&lt;TS).low)</p>
     * 
     * <p>ZPA2.4 (partType=UNID)</p>
     * 
     * <p>ZPA2.5 (DMODID - following DMOD=P.P.Box)</p>
     * 
     * <p>ZPA2.6 (partType=??)</p>
     * 
     * <p>ZPA2.7 (partType=??)</p>
     * 
     * <p>ZPA2.8 (partType=CTY)</p>
     * 
     * <p>ZPA2.9 (partType=CNT - populate mnemonic of SC)</p>
     * 
     * <p>ZPA2.10 (partType=ZIP)</p>
     * 
     * <p>ZPA2.11 (partType=SINST=PST)</p>
     * 
     * <p>ZPA2.12 (partTYpe=STA)</p>
     * 
     * <p>ZPA2.13 (partType=DMODID-followingDMOD=RR)</p>
     * 
     * <p>ZPA2.14 (partType=DIR)</p>
     * 
     * <p>ZPA2.15 (partType=STB)</p>
     * 
     * <p>ZPA2.16 (partType=BNR) BC:ZPA2.17 (partType=STTYP)</p>
     * 
     * <p>ZPA2.18 (usablePeriod (IVL&lt;TS).high)</p>
     * 
     * <p>ZPA2.19 (Line demarked by carriage return)</p>
     * 
     * <p>PTT.060-01 (partType=SAL)</p>
     * 
     * <p>PTT.060-02 (partType=CTY)</p>
     * 
     * <p>PTT.060-03 (partType=CNT)</p>
     * 
     * <p>PTT.060-04 (partType=ZIP)</p>
     * 
     * <p>PID.11</p>
     * 
     * <p>Patient.322-CM (partType=SAL)</p>
     * 
     * <p>Patient.323-CN (partType=CTY)</p>
     * 
     * <p>Patient.324-CO (partType=STA)</p>
     * 
     * <p>Patient.325-CP (partType=ZIP)</p>
     * 
     * <p>PID.11</p>
     * 
     * <p>Can be used to record a temporary address used for the 
     * purposes of this prescription.</p><p>Not intended for use to 
     * confirm patient identity.</p>
     * 
     * <p>Physical address for the patient where they may be 
     * visited or found for the purposes of this particular action. 
     * Generally only specified when different from the addresses 
     * stored on the client registry. E.g. address on a 
     * prescription issued when a patient is temporary staying away 
     * from home.</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: C:Patient Contact Address</p>
     * 
     * <p>Relationship: COCT_MT050203CA.Patient.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPA2.1 (use)</p>
     * 
     * <p>ZPA2.2 (usablePeriod(IVL&lt;TS).low)</p>
     * 
     * <p>ZPA2.4 (partType=UNID)</p>
     * 
     * <p>ZPA2.5 (DMODID - following DMOD=P.P.Box)</p>
     * 
     * <p>ZPA2.6 (partType=??)</p>
     * 
     * <p>ZPA2.7 (partType=??)</p>
     * 
     * <p>ZPA2.8 (partType=CTY)</p>
     * 
     * <p>ZPA2.9 (partType=CNT - populate mnemonic of SC)</p>
     * 
     * <p>ZPA2.10 (partType=ZIP)</p>
     * 
     * <p>ZPA2.11 (partType=SINST=PST)</p>
     * 
     * <p>ZPA2.12 (partTYpe=STA)</p>
     * 
     * <p>ZPA2.13 (partType=DMODID-followingDMOD=RR)</p>
     * 
     * <p>ZPA2.14 (partType=DIR)</p>
     * 
     * <p>ZPA2.15 (partType=STB)</p>
     * 
     * <p>ZPA2.16 (partType=BNR) BC:ZPA2.17 (partType=STTYP)</p>
     * 
     * <p>ZPA2.18 (usablePeriod (IVL&lt;TS).high)</p>
     * 
     * <p>ZPA2.19 (Line demarked by carriage return)</p>
     * 
     * <p>PTT.060-01 (partType=SAL)</p>
     * 
     * <p>PTT.060-02 (partType=CTY)</p>
     * 
     * <p>PTT.060-03 (partType=CNT)</p>
     * 
     * <p>PTT.060-04 (partType=ZIP)</p>
     * 
     * <p>PID.11</p>
     * 
     * <p>Patient.322-CM (partType=SAL)</p>
     * 
     * <p>Patient.323-CN (partType=CTY)</p>
     * 
     * <p>Patient.324-CO (partType=STA)</p>
     * 
     * <p>Patient.325-CP (partType=ZIP)</p>
     * 
     * <p>PID.11</p>
     * 
     * <p>Can be used to record a temporary address used for the 
     * purposes of this prescription.</p><p>Not intended for use to 
     * confirm patient identity.</p>
     * 
     * <p>Physical address for the patient where they may be 
     * visited or found for the purposes of this particular action. 
     * Generally only specified when different from the addresses 
     * stored on the client registry. E.g. address on a 
     * prescription issued when a patient is temporary staying away 
     * from home.</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: D:Patient Contact Phone and E-mails</p>
     * 
     * <p>Relationship: COCT_MT050203CA.Patient.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-5)</p>
     * 
     * <p>ZPA1.1 (Use and/or URL.scheme)</p>
     * 
     * <p>ZPA1.2 (usablePeriod (IVL&lt;TS&gt;).low) BC:ZPA1.3 
     * (url.address - as per RFC2396)</p>
     * 
     * <p>ZPA1.4 (url.address - as per RFC2396)</p>
     * 
     * <p>ZPA1.5 (usablePeriod (IVL&lt;TS&gt;).high)</p>
     * 
     * <p>PTT.070-01</p>
     * 
     * <p>PTT.070-02</p>
     * 
     * <p>D99.03 (url.address - as per RFC2396)</p>
     * 
     * <p>patient.326-CQ</p>
     * 
     * <p>PID.13</p>
     * 
     * <p>PID.14</p>
     * 
     * <p>Can be used to record a temporary contact mechanism 
     * (phone, email) for the purposes of this action.</p><p>Not 
     * intended for use to confirm patient 
     * identity.</p><p>Important for following up with patient but 
     * not always available, and therefore only marked as 
     * 'populated'.</p>
     * 
     * <p>Telephone, fax or e-mail addresses intended as the 
     * principal means of contact for the patient with regard to 
     * the current action. E.g. the phone number to reach the 
     * patient at regarding the results of an ordered 
     * test.</p><p>On a prescription, this enables the 
     * communication of patient contact information to the 
     * dispenser for the specific prescription. This can be a 
     * phone/fax number and/or email address</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: COCT_MT050203CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPA.1 (partType=Given)</p>
     * 
     * <p>ZPA.2 (partType=Family)</p>
     * 
     * <p>ZPA.3 (partType=Given - all repetitions except first)</p>
     * 
     * <p>C37 (partType=Given)</p>
     * 
     * <p>C38 (partType=Family)</p>
     * 
     * <p>PTT.030-01 (partType=Family)</p>
     * 
     * <p>PTT.030-02 (partType=Given - 1st occurrence)</p>
     * 
     * <p>PTT.030-03 (partType=Given - subsequen occurrences)</p>
     * 
     * <p>PTT.030-04 (partType=Suffix)</p>
     * 
     * <p>PTT.030-05 (partType=Prefix)</p>
     * 
     * <p>patient Initials</p>
     * 
     * <p>PID.5</p>
     * 
     * <p>Patient.310-CA (partType=Given)</p>
     * 
     * <p>Patient.311-CB (partType=Family)</p>
     * 
     * <p>Recipient Name First (partType=Given)</p>
     * 
     * <p>Recipient Name Last (partType=Family)</p>
     * 
     * <p>PID.5</p>
     * 
     * <p>PID.9 (any name other than first repetition is an 
     * alias)</p>
     * 
     * <p>ZDU.3</p>
     * 
     * <p>ZKW.2</p>
     * 
     * <p>Person.givenName</p>
     * 
     * <p>Person.lastName</p>
     * 
     * <p>Person.middleName</p>
     * 
     * <p>Person.namePrefix</p>
     * 
     * <p>Person.nameSuffix</p>
     * 
     * <p>Used, with other patient identity attributes, to confirm 
     * patient identity, as well as when addressing the patient. 
     * Element is mandatory because the patient's name is necessary 
     * for positive identification of the patient in the 
     * jurisdictional client registry.</p>
     * 
     * <p>The name by which the patient is known and which apply to 
     * a particular clinical action being reported or recorded. For 
     * a prescription, this will be the name traditionally printed 
     * on the paper script or the name that appears on the 
     * patient's chart.</p>
     */
    @Hl7XmlMapping({"patientPerson/name"})
    public PersonName getPatientPersonName() {
        return this.patientPersonName.getValue();
    }

    /**
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: COCT_MT050203CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPA.1 (partType=Given)</p>
     * 
     * <p>ZPA.2 (partType=Family)</p>
     * 
     * <p>ZPA.3 (partType=Given - all repetitions except first)</p>
     * 
     * <p>C37 (partType=Given)</p>
     * 
     * <p>C38 (partType=Family)</p>
     * 
     * <p>PTT.030-01 (partType=Family)</p>
     * 
     * <p>PTT.030-02 (partType=Given - 1st occurrence)</p>
     * 
     * <p>PTT.030-03 (partType=Given - subsequen occurrences)</p>
     * 
     * <p>PTT.030-04 (partType=Suffix)</p>
     * 
     * <p>PTT.030-05 (partType=Prefix)</p>
     * 
     * <p>patient Initials</p>
     * 
     * <p>PID.5</p>
     * 
     * <p>Patient.310-CA (partType=Given)</p>
     * 
     * <p>Patient.311-CB (partType=Family)</p>
     * 
     * <p>Recipient Name First (partType=Given)</p>
     * 
     * <p>Recipient Name Last (partType=Family)</p>
     * 
     * <p>PID.5</p>
     * 
     * <p>PID.9 (any name other than first repetition is an 
     * alias)</p>
     * 
     * <p>ZDU.3</p>
     * 
     * <p>ZKW.2</p>
     * 
     * <p>Person.givenName</p>
     * 
     * <p>Person.lastName</p>
     * 
     * <p>Person.middleName</p>
     * 
     * <p>Person.namePrefix</p>
     * 
     * <p>Person.nameSuffix</p>
     * 
     * <p>Used, with other patient identity attributes, to confirm 
     * patient identity, as well as when addressing the patient. 
     * Element is mandatory because the patient's name is necessary 
     * for positive identification of the patient in the 
     * jurisdictional client registry.</p>
     * 
     * <p>The name by which the patient is known and which apply to 
     * a particular clinical action being reported or recorded. For 
     * a prescription, this will be the name traditionally printed 
     * on the paper script or the name that appears on the 
     * patient's chart.</p>
     */
    public void setPatientPersonName(PersonName patientPersonName) {
        this.patientPersonName.setValue(patientPersonName);
    }


    /**
     * <p>Business Name: F:Patient Gender</p>
     * 
     * <p>Relationship: 
     * COCT_MT050203CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>C40 eScript:PTT.040</p>
     * 
     * <p>3</p>
     * 
     * <p>Sex</p>
     * 
     * <p>PID.8</p>
     * 
     * <p>Patient.305-C5</p>
     * 
     * <p>PID.8</p>
     * 
     * <p>Used to confirm patient identity. May affect dosing or 
     * therapy appropriateness.</p><p>Element is mandatory because 
     * the patient's gender is necessary for positive 
     * identification of the patient in the jurisdictional client 
     * registry.</p>
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
     * <p>Business Name: F:Patient Gender</p>
     * 
     * <p>Relationship: 
     * COCT_MT050203CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>C40 eScript:PTT.040</p>
     * 
     * <p>3</p>
     * 
     * <p>Sex</p>
     * 
     * <p>PID.8</p>
     * 
     * <p>Patient.305-C5</p>
     * 
     * <p>PID.8</p>
     * 
     * <p>Used to confirm patient identity. May affect dosing or 
     * therapy appropriateness.</p><p>Element is mandatory because 
     * the patient's gender is necessary for positive 
     * identification of the patient in the jurisdictional client 
     * registry.</p>
     * 
     * <p>Indicates the gender (sex) of the patient. Complex 
     * genetic genders are handled as observations if they are 
     * considered relevant.</p>
     */
    public void setPatientPersonAdministrativeGenderCode(AdministrativeGender patientPersonAdministrativeGenderCode) {
        this.patientPersonAdministrativeGenderCode.setValue(patientPersonAdministrativeGenderCode);
    }


    /**
     * <p>Business Name: E:Patient Birth Date</p>
     * 
     * <p>Relationship: COCT_MT050203CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>C34</p>
     * 
     * <p>PTT.020</p>
     * 
     * <p>A.2b</p>
     * 
     * <p>HC-SA</p>
     * 
     * <p>PID.7</p>
     * 
     * <p>patient.304-C4</p>
     * 
     * <p>PID.7</p>
     * 
     * <p>Used to confirm patient identity.</p><p>May also 
     * influence dosage and therapy appropriateness.</p><p>Element 
     * is mandatory because the patient's birth date is necessary 
     * for positive identification of the patient in the 
     * jurisdictional client registry.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    @Hl7XmlMapping({"patientPerson/birthTime"})
    public Date getPatientPersonBirthTime() {
        return this.patientPersonBirthTime.getValue();
    }

    /**
     * <p>Business Name: E:Patient Birth Date</p>
     * 
     * <p>Relationship: COCT_MT050203CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>C34</p>
     * 
     * <p>PTT.020</p>
     * 
     * <p>A.2b</p>
     * 
     * <p>HC-SA</p>
     * 
     * <p>PID.7</p>
     * 
     * <p>patient.304-C4</p>
     * 
     * <p>PID.7</p>
     * 
     * <p>Used to confirm patient identity.</p><p>May also 
     * influence dosage and therapy appropriateness.</p><p>Element 
     * is mandatory because the patient's birth date is necessary 
     * for positive identification of the patient in the 
     * jurisdictional client registry.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    public void setPatientPersonBirthTime(Date patientPersonBirthTime) {
        this.patientPersonBirthTime.setValue(patientPersonBirthTime);
    }

}
