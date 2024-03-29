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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt050208ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.ActingPersonBean;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Patient</p>
 * 
 * <p>Information used to identify the patient and to support 
 * clinical decisions. This information is that captured within 
 * the client registry record for the patient.</p>
 * 
 * <p>A person who is receiving or may receive healthcare 
 * services and has personal attributes (e.g. name, birth 
 * date).</p>
 */
@Hl7PartTypeMapping({"COCT_MT050208CA.Patient"})
@Hl7RootType
public class PatientBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private AD addr = new ADImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ActingPersonBean patientPerson;


    /**
     * <p>Business Name: A:Patient Identifier</p>
     * 
     * <p>Relationship: COCT_MT050208CA.Patient.id</p>
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
     * computer systems, the attribute is mandatory. The 
     * cardinality of patient identifiers is up to 3 based on the 
     * use case to support communication of a local and 
     * jurisdictional identifier along with the national 
     * identifier.</p>
     * 
     * <p>Unique identifier assigned to a person by Federal, 
     * Provincial and Territorial jurisdiction for the purposes of 
     * uniquely identifying the person within the EHR.</p><p>The 
     * EHR will define which identifier to use within a 
     * jurisdiction.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: C:Patient Contact Address</p>
     * 
     * <p>Relationship: COCT_MT050208CA.Patient.addr</p>
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
     * <p>Provides basic contact information for the patient 
     * avoiding the need to separately query the client 
     * registry.</p>
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
     * <p>Relationship: COCT_MT050208CA.Patient.addr</p>
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
     * <p>Provides basic contact information for the patient 
     * avoiding the need to separately query the client 
     * registry.</p>
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
     * <p>Relationship: COCT_MT050208CA.Patient.telecom</p>
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
     * <p>Provides basic contact information for the patient 
     * avoiding the need to separately query the client 
     * registry.</p><p>Important for following up with patient but 
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
     * <p>Relationship: COCT_MT050208CA.Patient.patientPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"patientPerson"})
    public ActingPersonBean getPatientPerson() {
        return this.patientPerson;
    }

    /**
     * <p>Relationship: COCT_MT050208CA.Patient.patientPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPatientPerson(ActingPersonBean patientPerson) {
        this.patientPerson = patientPerson;
    }

}
