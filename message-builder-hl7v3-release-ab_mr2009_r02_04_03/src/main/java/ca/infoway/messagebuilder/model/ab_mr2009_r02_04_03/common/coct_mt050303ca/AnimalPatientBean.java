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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt050303ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: Animal Patient</p>
 * 
 * <p>Used when animal services are attached to a human patient 
 * record. E.g. narcotics prescribed for a pet may be attached 
 * to the owner's record for monitoring of abuse.</p>
 * 
 * <p>An animal that is receiving or may receive healthcare 
 * services.</p>
 */
@Hl7PartTypeMapping({"COCT_MT050303CA.Patient"})
@Hl7RootType
public class AnimalPatientBean extends MessagePartBean {

    private static final long serialVersionUID = 20150807L;
    private ST patientNonPersonLivingSubjectName = new STImpl();
    private AD patientNonPersonLivingSubjectContactPartyAddr = new ADImpl();
    private SET<TEL, TelecommunicationAddress> patientNonPersonLivingSubjectContactPartyTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN patientNonPersonLivingSubjectContactPartyContactPersonName = new PNImpl();


    /**
     * <p>Business Name: B:Animal name</p>
     * 
     * <p>Relationship: COCT_MT050303CA.NonPersonLivingSubject.name</p>
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
     * For animals, name is the primary identifier, and is 
     * therefore mandatory.</p>
     * 
     * <p>Name by which the animal patient is known.</p>
     */
    @Hl7XmlMapping({"patientNonPersonLivingSubject/name"})
    public String getPatientNonPersonLivingSubjectName() {
        return this.patientNonPersonLivingSubjectName.getValue();
    }

    /**
     * <p>Business Name: B:Animal name</p>
     * 
     * <p>Relationship: COCT_MT050303CA.NonPersonLivingSubject.name</p>
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
     * For animals, name is the primary identifier, and is 
     * therefore mandatory.</p>
     * 
     * <p>Name by which the animal patient is known.</p>
     */
    public void setPatientNonPersonLivingSubjectName(String patientNonPersonLivingSubjectName) {
        this.patientNonPersonLivingSubjectName.setValue(patientNonPersonLivingSubjectName);
    }


    /**
     * <p>Business Name: Owner address</p>
     * 
     * <p>Relationship: COCT_MT050303CA.ContactParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to contact the owner or contact person</p>
     * 
     * <p>The mail and/or physical address associated with the 
     * owner or contact person for the animal.</p>
     */
    @Hl7XmlMapping({"patientNonPersonLivingSubject/contactParty/addr"})
    public PostalAddress getPatientNonPersonLivingSubjectContactPartyAddr() {
        return this.patientNonPersonLivingSubjectContactPartyAddr.getValue();
    }

    /**
     * <p>Business Name: Owner address</p>
     * 
     * <p>Relationship: COCT_MT050303CA.ContactParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to contact the owner or contact person</p>
     * 
     * <p>The mail and/or physical address associated with the 
     * owner or contact person for the animal.</p>
     */
    public void setPatientNonPersonLivingSubjectContactPartyAddr(PostalAddress patientNonPersonLivingSubjectContactPartyAddr) {
        this.patientNonPersonLivingSubjectContactPartyAddr.setValue(patientNonPersonLivingSubjectContactPartyAddr);
    }


    /**
     * <p>Business Name: Owner Phones and Emails</p>
     * 
     * <p>Relationship: COCT_MT050303CA.ContactParty.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Used to contact the owner or contact person</p>
     * 
     * <p>The phone number(s) and email address(s) by which the 
     * owner may be contacted.</p>
     */
    @Hl7XmlMapping({"patientNonPersonLivingSubject/contactParty/telecom"})
    public Set<TelecommunicationAddress> getPatientNonPersonLivingSubjectContactPartyTelecom() {
        return this.patientNonPersonLivingSubjectContactPartyTelecom.rawSet();
    }


    /**
     * <p>Business Name: Owner Name</p>
     * 
     * <p>Relationship: COCT_MT050303CA.ContactPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used when contacting or addressing the owner person. 
     * Because this will be the principle means of identifying the 
     * owner person, it is mandatory.</p>
     * 
     * <p>The name by which the owner person is known</p>
     */
    @Hl7XmlMapping({"patientNonPersonLivingSubject/contactParty/contactPerson/name"})
    public PersonName getPatientNonPersonLivingSubjectContactPartyContactPersonName() {
        return this.patientNonPersonLivingSubjectContactPartyContactPersonName.getValue();
    }

    /**
     * <p>Business Name: Owner Name</p>
     * 
     * <p>Relationship: COCT_MT050303CA.ContactPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used when contacting or addressing the owner person. 
     * Because this will be the principle means of identifying the 
     * owner person, it is mandatory.</p>
     * 
     * <p>The name by which the owner person is known</p>
     */
    public void setPatientNonPersonLivingSubjectContactPartyContactPersonName(PersonName patientNonPersonLivingSubjectContactPartyContactPersonName) {
        this.patientNonPersonLivingSubjectContactPartyContactPersonName.setValue(patientNonPersonLivingSubjectContactPartyContactPersonName);
    }

}
