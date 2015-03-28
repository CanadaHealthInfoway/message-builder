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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt050007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.ActingPersonBean;
import java.util.List;
import java.util.Set;



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
 * date).</p>
 */
@Hl7PartTypeMapping({"COCT_MT050007CA.Patient"})
@Hl7RootType
public class PatientBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private AD addr = new ADImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ST certificateText = new STImpl();
    private ActingPersonBean patientPerson;
    private PatientIdentifyingCharacteristicsBean subjectOfIdentifyingCharacteristicsObservationEvent;


    /**
     * <p>Business Name: A:Patient Identifier</p>
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
     * <p>Business Name: E:Patient Address</p>
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
     * <p>Business Name: E:Patient Address</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Patient.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: F:Patient Contact Phone and E-Mails</p>
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
     * <p>Business Name: L:Patient Health Card Version Code</p>
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
     * <p>Business Name: L:Patient Health Card Version Code</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Patient.certificateText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setCertificateText(String certificateText) {
        this.certificateText.setValue(certificateText);
    }


    /**
     * <p>Relationship: COCT_MT050007CA.Patient.patientPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"patientPerson"})
    public ActingPersonBean getPatientPerson() {
        return this.patientPerson;
    }

    /**
     * <p>Relationship: COCT_MT050007CA.Patient.patientPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPatientPerson(ActingPersonBean patientPerson) {
        this.patientPerson = patientPerson;
    }


    /**
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
     * <p>Relationship: 
     * COCT_MT050007CA.Subject.identifyingCharacteristicsObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOfIdentifyingCharacteristicsObservationEvent(PatientIdentifyingCharacteristicsBean subjectOfIdentifyingCharacteristicsObservationEvent) {
        this.subjectOfIdentifyingCharacteristicsObservationEvent = subjectOfIdentifyingCharacteristicsObservationEvent;
    }

}
