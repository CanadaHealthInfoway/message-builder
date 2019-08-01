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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt050207ca;

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
 * clinical decisions. This is used when the patient is not 
 * known to the client registry but information still needs to 
 * be communicated. E.g. lab or drug reporting to PHS for an 
 * unconscious or otherwise unidentifiable patient.</p>
 * 
 * <p>A person who is receiving or may receive healthcare 
 * services and has personal attributes (e.g. name, birth 
 * date).</p>
 */
@Hl7PartTypeMapping({"COCT_MT050207CA.Patient"})
@Hl7RootType
public class PatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.Patient, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt911107ca.ActingPerson {

    private static final long serialVersionUID = 20190730L;
    private II id = new IIImpl();
    private AD addr = new ADImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN patientPersonName = new PNImpl();
    private CV patientPersonAdministrativeGenderCode = new CVImpl();
    private TS patientPersonBirthTime = new TSImpl();


    /**
     * <p>Business Name: A:Patient Identifier</p>
     * 
     * <p>Relationship: COCT_MT050207CA.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * this CMET deals with patients not confirmable against a 
     * client registry, it's possible that no identifier will be 
     * known and therefore the attribute is only 'populated'.</p>
     * 
     * <p>Unique identifier assigned to a person, possibly by a 
     * local system or some other non-client-registry 
     * identifier.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Patient Identifier</p>
     * 
     * <p>Relationship: COCT_MT050207CA.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * this CMET deals with patients not confirmable against a 
     * client registry, it's possible that no identifier will be 
     * known and therefore the attribute is only 'populated'.</p>
     * 
     * <p>Unique identifier assigned to a person, possibly by a 
     * local system or some other non-client-registry 
     * identifier.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C:Patient Contact Address</p>
     * 
     * <p>Relationship: COCT_MT050207CA.Patient.addr</p>
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
     * <p>Provides basic contact information for the patient.</p>
     * 
     * <p>Contact information specific to the patient for a 
     * particular action (prescription, lab test, etc.) will be 
     * conveyed as part of the payload.</p>
     * 
     * <p>Physical address for the patient where they may be 
     * visited or found.</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: C:Patient Contact Address</p>
     * 
     * <p>Relationship: COCT_MT050207CA.Patient.addr</p>
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
     * <p>Provides basic contact information for the patient.</p>
     * 
     * <p>Contact information specific to the patient for a 
     * particular action (prescription, lab test, etc.) will be 
     * conveyed as part of the payload.</p>
     * 
     * <p>Physical address for the patient where they may be 
     * visited or found.</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: D:Patient Contact Phone and E-mails</p>
     * 
     * <p>Relationship: COCT_MT050207CA.Patient.telecom</p>
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
     * <p>Provides basic contact information for the 
     * patient.</p><p>Important for following up with patient but 
     * not always available, and therefore only marked as 
     * 'populated'.</p>
     * 
     * <p>Contact information specific to the patient for a 
     * particular action (prescription, lab test, etc.) will be 
     * conveyed as part of the payload.</p>
     * 
     * <p>Telephone, fax and/or e-mail addresses intended as the 
     * principal means of contact for the patient.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: COCT_MT050207CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Used by to help identify the patient and also when 
     * referring to the patient</p><p>The element is populated 
     * because the patient's name is important for display. 
     * However, there may be circumstances where a name is not 
     * known by the reporting system.</p>
     * 
     * <p>The name by which the patient is known.</p>
     */
    @Hl7XmlMapping({"patientPerson/name"})
    public PersonName getPatientPersonName() {
        return this.patientPersonName.getValue();
    }

    /**
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: COCT_MT050207CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Used by to help identify the patient and also when 
     * referring to the patient</p><p>The element is populated 
     * because the patient's name is important for display. 
     * However, there may be circumstances where a name is not 
     * known by the reporting system.</p>
     * 
     * <p>The name by which the patient is known.</p>
     */
    public void setPatientPersonName(PersonName patientPersonName) {
        this.patientPersonName.setValue(patientPersonName);
    }


    /**
     * <p>Business Name: F:Patient Gender</p>
     * 
     * <p>Relationship: 
     * COCT_MT050207CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Used to confirm patient identity. May affect clinical 
     * decision support such as drug dosing, lab test 
     * appropriateness, etc.</p><p>The element is 'populated' 
     * because there are some situations where the patient's gender 
     * may not be known by the sending system when dealing with 
     * non-client registry patients.</p>
     * 
     * <p>Indicates the gender (sex) of the patient as known by the 
     * client registry. Complex genetic genders are handled as 
     * observations if they are considered relevant.</p>
     */
    @Hl7XmlMapping({"patientPerson/administrativeGenderCode"})
    public AdministrativeGender getPatientPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.patientPersonAdministrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: F:Patient Gender</p>
     * 
     * <p>Relationship: 
     * COCT_MT050207CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Used to confirm patient identity. May affect clinical 
     * decision support such as drug dosing, lab test 
     * appropriateness, etc.</p><p>The element is 'populated' 
     * because there are some situations where the patient's gender 
     * may not be known by the sending system when dealing with 
     * non-client registry patients.</p>
     * 
     * <p>Indicates the gender (sex) of the patient as known by the 
     * client registry. Complex genetic genders are handled as 
     * observations if they are considered relevant.</p>
     */
    public void setPatientPersonAdministrativeGenderCode(AdministrativeGender patientPersonAdministrativeGenderCode) {
        this.patientPersonAdministrativeGenderCode.setValue(patientPersonAdministrativeGenderCode);
    }


    /**
     * <p>Business Name: E:Patient Birth Date</p>
     * 
     * <p>Relationship: COCT_MT050207CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * influence clinical decision support such as dosage and 
     * therapy appropriateness.</p><p>The element is populated 
     * because the patient's birth date may not be known, 
     * particularly for patients not found in the client 
     * registry.</p>
     * 
     * <p>Indicates the date on which the patient was born as known 
     * by the client registry.</p>
     */
    @Hl7XmlMapping({"patientPerson/birthTime"})
    public Date getPatientPersonBirthTime() {
        return this.patientPersonBirthTime.getValue();
    }

    /**
     * <p>Business Name: E:Patient Birth Date</p>
     * 
     * <p>Relationship: COCT_MT050207CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * influence clinical decision support such as dosage and 
     * therapy appropriateness.</p><p>The element is populated 
     * because the patient's birth date may not be known, 
     * particularly for patients not found in the client 
     * registry.</p>
     * 
     * <p>Indicates the date on which the patient was born as known 
     * by the client registry.</p>
     */
    public void setPatientPersonBirthTime(Date patientPersonBirthTime) {
        this.patientPersonBirthTime.setValue(patientPersonBirthTime);
    }

}
