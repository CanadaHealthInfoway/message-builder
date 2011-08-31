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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt050202ca;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Patient</p>
 * 
 * <p><p>A person who is receiving or may receive healthcare 
 * services and has personal attributes (e.g. name, birth 
 * date).</p></p>
 * 
 * <p><p>Information used to identify the patient and confirm 
 * their identity against the client registry.</p></p>
 * 
 * <p><p>Only the identifier attribute is intended to be 
 * persisted, with the remaining attributes confirmed against 
 * the provider registry.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT050202CA.Patient"})
@Hl7RootType
public class PatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.Choice, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.SubjectChoice, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.Patient_2, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.iehr.merged.Party {

    private static final long serialVersionUID = 20110831L;
    private II patientIdentifier = new IIImpl();
    private PN patientName = new PNImpl();
    private CV patientGender = new CVImpl();
    private TS patientBirthDate = new TSImpl();


    /**
     * <p>A:Patient Identifier</p>
     * 
     * <p><p>Unique identifier assigned to a person by Federal, 
     * Provincial and Territorial jurisdiction for the purposes of 
     * uniquely identifying the person within the EHR.</p><p>The 
     * EHR will define which identifier to use within a 
     * jurisdiction.</p></p>
     * 
     * <p><p>Unique identifier assigned to a person by Federal, 
     * Provincial and Territorial jurisdiction for the purposes of 
     * uniquely identifying the person within the EHR.</p><p>The 
     * EHR will define which identifier to use within a 
     * jurisdiction.</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>C39 (Extension)</p><p>PTT.050.01 
     * (Extension)</p><p>PTT.050.02 
     * (Root)</p><p>A.1</p><p>PID.2</p><p>Patient.332-CY 
     * (Extension)</p><p>Patient.331-CX 
     * (Root)</p><p>Claim.330-CW</p><p>Health Card 
     * Number</p><p>PID.2</p><p>PID.4</p><p>ZDU.2</p><p>ZKW.3</p><p>Jurisdiction 
     * (Root)</p><p>Person.PHN (Extension)</p></p>
     * 
     * <p><p>Allows a patient to be referred to unambiguously. 
     * Because this is the principal mechanism for identifying 
     * patients to computer systems, the attribute is mandatory. If 
     * an identifier is not known, it should be looked up using the 
     * 'client registry' capabilities of the EHR application.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPatientIdentifier() {
        return this.patientIdentifier.getValue();
    }
    public void setPatientIdentifier(Identifier patientIdentifier) {
        this.patientIdentifier.setValue(patientIdentifier);
    }


    /**
     * <p>B:Patient Name</p>
     * 
     * <p><p>The name by which the patient is known to the 
     * underlying client registry application</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=Given - 1st 
     * occurrence)</p><p>PTT.030-03 (partType=Given - subsequen 
     * occurrences)</p><p>PTT.030-04 
     * (partType=Suffix)</p><p>PTT.030-05 
     * (partType=Prefix)</p><p>patient 
     * Initials</p><p>PID.5</p><p>Patient.310-CA 
     * (partType=Given)</p><p>Patient.311-CB 
     * (partType=Family)</p><p>Recipient Name First 
     * (partType=Given)</p><p>Recipient Name Last 
     * (partType=Family)</p><p>PID.5</p><p>PID.9 (any name other 
     * than first repetition is an 
     * alias)</p><p>ZDU.3</p><p>ZKW.2</p><p>Person.givenName</p><p>Person.lastName</p><p>Person.middleName</p><p>Person.namePrefix</p><p>Person.nameSuffix</p></p>
     * 
     * <p><p>ZPA.1 (partType=Given)</p><p>ZPA.2 
     * (partType=Family)</p><p>ZPA.3 (partType=Given - all 
     * repetitions except first)</p><p>C37 
     * (partType=Given)</p><p>C38 
     * (partType=Family)</p><p>PTT.030-01 
     * (partType=Family)</p><p>PTT.030-02 (partType=
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"patientPerson/name"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }


    /**
     * <p>F:Patient Gender</p>
     * 
     * <p><p>Indicates the gender (sex) of the patient as known by 
     * the client registry. Complex genetic genders are handled as 
     * observations if they are considered relevant.</p></p>
     * 
     * <p><p>Used to confirm patient identity.</p><p>The element is 
     * mandatory because the patient's gender is necessary for 
     * positive identification of the patient in the jurisdictional 
     * client registry and should always be known.</p></p>
     * 
     * <p><p>Used to confirm patient identity.</p><p>The element is 
     * mandatory because the patient's gender is necessary for 
     * positive identification of the patient in the jurisdictional 
     * client registry and should always be known.</p></p>
     */
    @Hl7XmlMapping({"patientPerson/administrativeGenderCode"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }


    /**
     * <p>E:Patient Birth Date</p>
     * 
     * <p><p>Indicates the date on which the patient was born, as 
     * known by the client registry.</p></p>
     * 
     * <p><p>Used to confirm patient identity.</p><p>This element 
     * is 'populated' because the patient's birth date is necessary 
     * for positive identification of the patient in the 
     * jurisdictional client registry. However, there may be 
     * circumstances where the date of birth is not known to the 
     * registry.</p></p>
     * 
     * <p><p>Used to confirm patient identity.</p><p>This element 
     * is 'populated' because the patient's birth date is necessary 
     * for positive identification of the patient in the 
     * jurisdictional client registry. However, there may be 
     * circumstances where the date of birth is not known to the 
     * registry.</p></p>
     */
    @Hl7XmlMapping({"patientPerson/birthTime"})
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }
    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }

}
