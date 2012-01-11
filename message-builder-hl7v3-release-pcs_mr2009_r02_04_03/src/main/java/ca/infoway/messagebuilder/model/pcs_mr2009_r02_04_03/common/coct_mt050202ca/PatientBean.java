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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt050202ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ActingPersonBean;
import java.util.Set;



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
public class PatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.Party, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt470012ca.SubjectChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Choice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Patient {

    private static final long serialVersionUID = 20120106L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private ActingPersonBean patientPerson;


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
     * 'client registry' capabilities of the EHR application. The 
     * cardinality of patient identifiers is up to 3 based on the 
     * use case to support communication of a local and 
     * jurisdictional identifier along with the national 
     * identifier.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    @Hl7XmlMapping({"patientPerson"})
    public ActingPersonBean getPatientPerson() {
        return this.patientPerson;
    }
    public void setPatientPerson(ActingPersonBean patientPerson) {
        this.patientPerson = patientPerson;
    }

}
