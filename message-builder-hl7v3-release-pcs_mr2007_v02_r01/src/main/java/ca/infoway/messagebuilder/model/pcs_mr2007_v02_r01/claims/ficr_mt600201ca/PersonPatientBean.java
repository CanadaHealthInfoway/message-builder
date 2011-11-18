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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca;

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



@Hl7PartTypeMapping({"FICR_MT600201CA.CoveredPartyAsPatientPerson"})
public class PersonPatientBean extends MessagePartBean implements CoveredPartyAsPatientChoice {

    private static final long serialVersionUID = 20111117L;
    private PN name = new PNImpl();
    private CV administrativeGenderCode = new CVImpl();
    private TS birthTime = new TSImpl();
    private BL multipleBirthInd = new BLImpl();
    private INT multipleBirthOrderNumber = new INTImpl();
    private II parentOrGuardianRoleId = new IIImpl();
    private CE parentOrGuardianRoleCode = new CEImpl();
    private PN parentOrGuardianRoleRelationshipHolderName = new PNImpl();


    /**
     * <p>Patient Name</p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getName() {
        return this.name.getValue();
    }
    public void setName(PersonName name) {
        this.name.setValue(name);
    }


    /**
     * <p>Person Gender</p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getAdministrativeGenderCode() {
        return (AdministrativeGender) this.administrativeGenderCode.getValue();
    }
    public void setAdministrativeGenderCode(AdministrativeGender administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }


    /**
     * <p>Person Date of birth</p>
     */
    @Hl7XmlMapping({"birthTime"})
    public Date getBirthTime() {
        return this.birthTime.getValue();
    }
    public void setBirthTime(Date birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>Person multiple birth indicator</p>
     */
    @Hl7XmlMapping({"multipleBirthInd"})
    public Boolean getMultipleBirthInd() {
        return this.multipleBirthInd.getValue();
    }
    public void setMultipleBirthInd(Boolean multipleBirthInd) {
        this.multipleBirthInd.setValue(multipleBirthInd);
    }


    /**
     * <p>Person multiple birth order number</p>
     */
    @Hl7XmlMapping({"multipleBirthOrderNumber"})
    public Integer getMultipleBirthOrderNumber() {
        return this.multipleBirthOrderNumber.getValue();
    }
    public void setMultipleBirthOrderNumber(Integer multipleBirthOrderNumber) {
        this.multipleBirthOrderNumber.setValue(multipleBirthOrderNumber);
    }


    /**
     * <p>Id of parent</p>
     */
    @Hl7XmlMapping({"parentOrGuardianRole/id"})
    public Identifier getParentOrGuardianRoleId() {
        return this.parentOrGuardianRoleId.getValue();
    }
    public void setParentOrGuardianRoleId(Identifier parentOrGuardianRoleId) {
        this.parentOrGuardianRoleId.setValue(parentOrGuardianRoleId);
    }


    /**
     * <p>Parent or Guardian Relationship to patient</p>
     */
    @Hl7XmlMapping({"parentOrGuardianRole/code"})
    public PersonalRelationshipRoleType getParentOrGuardianRoleCode() {
        return (PersonalRelationshipRoleType) this.parentOrGuardianRoleCode.getValue();
    }
    public void setParentOrGuardianRoleCode(PersonalRelationshipRoleType parentOrGuardianRoleCode) {
        this.parentOrGuardianRoleCode.setValue(parentOrGuardianRoleCode);
    }


    /**
     * <p>Name of Parent or Guardian</p>
     */
    @Hl7XmlMapping({"parentOrGuardianRole/relationshipHolder/name"})
    public PersonName getParentOrGuardianRoleRelationshipHolderName() {
        return this.parentOrGuardianRoleRelationshipHolderName.getValue();
    }
    public void setParentOrGuardianRoleRelationshipHolderName(PersonName parentOrGuardianRoleRelationshipHolderName) {
        this.parentOrGuardianRoleRelationshipHolderName.setValue(parentOrGuardianRoleRelationshipHolderName);
    }

}
