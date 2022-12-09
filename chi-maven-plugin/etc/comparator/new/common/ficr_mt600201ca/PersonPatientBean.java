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
package ca.infoway.messagebuilder.model.common.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Person Patient 
 * 
 * <p>The information of the person patient. 
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.CoveredPartyAsPatientPerson"})
public class PersonPatientBean extends MessagePartBean implements CoveredPartyAsPatientChoiceBean {

    private PN patientName = new PNImpl();
    private CV<AdministrativeGender> personGender = new CVImpl<AdministrativeGender>();
    private TS personDateOfBirth = new TSImpl();
    private BL personMultipleBirthIndicator = new BLImpl();
    private INT personMultipleBirthOrderNumber = new INTImpl();
    private II idOfParent = new IIImpl();
    private CE<PersonalRelationshipRoleType> parentOrGuardianRelationshipToPatient = new CEImpl<PersonalRelationshipRoleType>();
    private PN nameOfParentOrGuardian = new PNImpl();

    @Hl7XmlMapping({"name"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }

    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getPersonGender() {
        return this.personGender.getValue();
    }
    public void setPersonGender(AdministrativeGender personGender) {
        this.personGender.setValue(personGender);
    }

    @Hl7XmlMapping({"birthTime"})
    public Date getPersonDateOfBirth() {
        return this.personDateOfBirth.getValue();
    }
    public void setPersonDateOfBirth(Date personDateOfBirth) {
        this.personDateOfBirth.setValue(personDateOfBirth);
    }

    @Hl7XmlMapping({"multipleBirthInd"})
    public java.lang.Boolean getPersonMultipleBirthIndicator() {
        return this.personMultipleBirthIndicator.getValue();
    }
    public void setPersonMultipleBirthIndicator(java.lang.Boolean personMultipleBirthIndicator) {
        this.personMultipleBirthIndicator.setValue(personMultipleBirthIndicator);
    }

    @Hl7XmlMapping({"multipleBirthOrderNumber"})
    public java.lang.Integer getPersonMultipleBirthOrderNumber() {
        return this.personMultipleBirthOrderNumber.getValue();
    }
    public void setPersonMultipleBirthOrderNumber(java.lang.Integer personMultipleBirthOrderNumber) {
        this.personMultipleBirthOrderNumber.setValue(personMultipleBirthOrderNumber);
    }

    @Hl7XmlMapping({"parentOrGuardianRole/id"})
    public Identifier getIdOfParent() {
        return this.idOfParent.getValue();
    }
    public void setIdOfParent(Identifier idOfParent) {
        this.idOfParent.setValue(idOfParent);
    }

    @Hl7XmlMapping({"parentOrGuardianRole/code"})
    public PersonalRelationshipRoleType getParentOrGuardianRelationshipToPatient() {
        return this.parentOrGuardianRelationshipToPatient.getValue();
    }
    public void setParentOrGuardianRelationshipToPatient(PersonalRelationshipRoleType parentOrGuardianRelationshipToPatient) {
        this.parentOrGuardianRelationshipToPatient.setValue(parentOrGuardianRelationshipToPatient);
    }

    @Hl7XmlMapping({"parentOrGuardianRole/relationshipHolder/name"})
    public PersonName getNameOfParentOrGuardian() {
        return this.nameOfParentOrGuardian.getValue();
    }
    public void setNameOfParentOrGuardian(PersonName nameOfParentOrGuardian) {
        this.nameOfParentOrGuardian.setValue(nameOfParentOrGuardian);
    }

}