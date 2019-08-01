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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt600201ca;

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
public class CoveredPartyAsPatientPersonBean extends MessagePartBean implements CoveredPartyAsPatientChoice {

    private static final long serialVersionUID = 20190731L;
    private PN name = new PNImpl();
    private CV administrativeGenderCode = new CVImpl();
    private TS birthTime = new TSImpl();
    private BL multipleBirthInd = new BLImpl();
    private INT multipleBirthOrderNumber = new INTImpl();
    private II parentOrGuardianRoleId = new IIImpl();
    private CE parentOrGuardianRoleCode = new CEImpl();
    private PN parentOrGuardianRoleRelationshipHolderName = new PNImpl();


    /**
     * <p>Business Name: Patient Name</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: Patient Name</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setName(PersonName name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: Person Gender</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getAdministrativeGenderCode() {
        return (AdministrativeGender) this.administrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: Person Gender</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAdministrativeGenderCode(AdministrativeGender administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }


    /**
     * <p>Business Name: Person Date of birth</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"birthTime"})
    public Date getBirthTime() {
        return this.birthTime.getValue();
    }

    /**
     * <p>Business Name: Person Date of birth</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setBirthTime(Date birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>Business Name: Person multiple birth indicator</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.multipleBirthInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"multipleBirthInd"})
    public Boolean getMultipleBirthInd() {
        return this.multipleBirthInd.getValue();
    }

    /**
     * <p>Business Name: Person multiple birth indicator</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.multipleBirthInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setMultipleBirthInd(Boolean multipleBirthInd) {
        this.multipleBirthInd.setValue(multipleBirthInd);
    }


    /**
     * <p>Business Name: Person multiple birth order number</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"multipleBirthOrderNumber"})
    public Integer getMultipleBirthOrderNumber() {
        return this.multipleBirthOrderNumber.getValue();
    }

    /**
     * <p>Business Name: Person multiple birth order number</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatientPerson.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setMultipleBirthOrderNumber(Integer multipleBirthOrderNumber) {
        this.multipleBirthOrderNumber.setValue(multipleBirthOrderNumber);
    }


    /**
     * <p>Business Name: Id of parent</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ParentOrGuardianRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"parentOrGuardianRole/id"})
    public Identifier getParentOrGuardianRoleId() {
        return this.parentOrGuardianRoleId.getValue();
    }

    /**
     * <p>Business Name: Id of parent</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ParentOrGuardianRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setParentOrGuardianRoleId(Identifier parentOrGuardianRoleId) {
        this.parentOrGuardianRoleId.setValue(parentOrGuardianRoleId);
    }


    /**
     * <p>Business Name: Parent or Guardian Relationship to patient</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ParentOrGuardianRole.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"parentOrGuardianRole/code"})
    public PersonalRelationshipRoleType getParentOrGuardianRoleCode() {
        return (PersonalRelationshipRoleType) this.parentOrGuardianRoleCode.getValue();
    }

    /**
     * <p>Business Name: Parent or Guardian Relationship to patient</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ParentOrGuardianRole.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setParentOrGuardianRoleCode(PersonalRelationshipRoleType parentOrGuardianRoleCode) {
        this.parentOrGuardianRoleCode.setValue(parentOrGuardianRoleCode);
    }


    /**
     * <p>Business Name: Name of Parent or Guardian</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ParentOrGuardian.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"parentOrGuardianRole/relationshipHolder/name"})
    public PersonName getParentOrGuardianRoleRelationshipHolderName() {
        return this.parentOrGuardianRoleRelationshipHolderName.getValue();
    }

    /**
     * <p>Business Name: Name of Parent or Guardian</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ParentOrGuardian.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setParentOrGuardianRoleRelationshipHolderName(PersonName parentOrGuardianRoleRelationshipHolderName) {
        this.parentOrGuardianRoleRelationshipHolderName.setValue(parentOrGuardianRoleRelationshipHolderName);
    }

}
