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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050202nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;
import java.util.Set;



/**
 * <p>Business Name: Patient</p>
 * 
 * <p>Information used to identify the patient and confirm 
 * their identity against the client registry.</p>
 * 
 * <p>Only the identifier attribute is intended to be 
 * persisted, with the remaining attributes confirmed against 
 * the provider registry.</p>
 * 
 * <p>A person who is receiving or may receive healthcare 
 * services and has personal attributes (e.g. name, birth 
 * date).</p>
 */
@Hl7PartTypeMapping({"COCT_MT050202NB.Patient"})
@Hl7RootType
public class PatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.repc_mt000012nb.Choice, ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged.Party, ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.merged.Patient, ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt470012nb.SubjectChoice {

    private static final long serialVersionUID = 20150902L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private PN patientPersonName = new PNImpl();
    private CV patientPersonAdministrativeGenderCode = new CVImpl();
    private TS patientPersonBirthTime = new TSImpl();


    /**
     * <p>Business Name: A:Patient Identifier</p>
     * 
     * <p>Relationship: COCT_MT050202NB.Patient.id</p>
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
     * computer systems, the attribute is mandatory. If an 
     * identifier is not known, it should be looked up using the 
     * 'client registry' capabilities of the EHR application.</p>
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
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: COCT_MT050202NB.Person.name</p>
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
     * <p>Used, with other patient identity attributes, to confirm 
     * patient identity.</p><p>This element is 'populated' because 
     * the patient's name is necessary for positive identification 
     * of the patient in the jurisdictional client registry, 
     * however in some circumstances it may not exist in the 
     * registry (e.g. newborn).</p>
     * 
     * <p>The name by which the patient is known to the underlying 
     * client registry application</p>
     */
    @Hl7XmlMapping({"patientPerson/name"})
    public PersonName getPatientPersonName() {
        return this.patientPersonName.getValue();
    }

    /**
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: COCT_MT050202NB.Person.name</p>
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
     * <p>Used, with other patient identity attributes, to confirm 
     * patient identity.</p><p>This element is 'populated' because 
     * the patient's name is necessary for positive identification 
     * of the patient in the jurisdictional client registry, 
     * however in some circumstances it may not exist in the 
     * registry (e.g. newborn).</p>
     * 
     * <p>The name by which the patient is known to the underlying 
     * client registry application</p>
     */
    public void setPatientPersonName(PersonName patientPersonName) {
        this.patientPersonName.setValue(patientPersonName);
    }


    /**
     * <p>Business Name: F:Patient Gender</p>
     * 
     * <p>Relationship: 
     * COCT_MT050202NB.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p><p>The element is 
     * mandatory because the patient's gender is necessary for 
     * positive identification of the patient in the jurisdictional 
     * client registry and should always be known.</p>
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
     * COCT_MT050202NB.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p><p>The element is 
     * mandatory because the patient's gender is necessary for 
     * positive identification of the patient in the jurisdictional 
     * client registry and should always be known.</p>
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
     * <p>Relationship: COCT_MT050202NB.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p><p>This element is 
     * 'populated' because the patient's birth date is necessary 
     * for positive identification of the patient in the 
     * jurisdictional client registry. However, there may be 
     * circumstances where the date of birth is not known to the 
     * registry.</p>
     * 
     * <p>Indicates the date on which the patient was born, as 
     * known by the client registry.</p>
     */
    @Hl7XmlMapping({"patientPerson/birthTime"})
    public Date getPatientPersonBirthTime() {
        return this.patientPersonBirthTime.getValue();
    }

    /**
     * <p>Business Name: E:Patient Birth Date</p>
     * 
     * <p>Relationship: COCT_MT050202NB.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p><p>This element is 
     * 'populated' because the patient's birth date is necessary 
     * for positive identification of the patient in the 
     * jurisdictional client registry. However, there may be 
     * circumstances where the date of birth is not known to the 
     * registry.</p>
     * 
     * <p>Indicates the date on which the patient was born, as 
     * known by the client registry.</p>
     */
    public void setPatientPersonBirthTime(Date patientPersonBirthTime) {
        this.patientPersonBirthTime.setValue(patientPersonBirthTime);
    }

}
