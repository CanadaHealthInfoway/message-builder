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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt500201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT500201CA.CoveredPartyAsPatientPerson"})
public class CoveredPartyAsPatientPersonBean extends MessagePartBean implements CoveredPartyAsPatientChoice {

    private static final long serialVersionUID = 20150326L;
    private PN name = new PNImpl();
    private CV administrativeGenderCode = new CVImpl();
    private TS birthTime = new TSImpl();
    private TS deceasedTime = new TSImpl();
    private BL multipleBirthInd = new BLImpl();
    private INT multipleBirthOrderNumber = new INTImpl();
    private ParentOrGuardianRoleBean parentOrGuardianRole;


    /**
     * <p>Business Name: Patient Name</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.name</p>
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
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.name</p>
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
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
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
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
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
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.birthTime</p>
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
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setBirthTime(Date birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>Business Name: time of death</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"deceasedTime"})
    public Date getDeceasedTime() {
        return this.deceasedTime.getValue();
    }

    /**
     * <p>Business Name: time of death</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setDeceasedTime(Date deceasedTime) {
        this.deceasedTime.setValue(deceasedTime);
    }


    /**
     * <p>Business Name: Person multiple birth indicator</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.multipleBirthInd</p>
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
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.multipleBirthInd</p>
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
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.multipleBirthOrderNumber</p>
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
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setMultipleBirthOrderNumber(Integer multipleBirthOrderNumber) {
        this.multipleBirthOrderNumber.setValue(multipleBirthOrderNumber);
    }


    /**
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.parentOrGuardianRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"parentOrGuardianRole"})
    public ParentOrGuardianRoleBean getParentOrGuardianRole() {
        return this.parentOrGuardianRole;
    }

    /**
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredPartyAsPatientPerson.parentOrGuardianRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setParentOrGuardianRole(ParentOrGuardianRoleBean parentOrGuardianRole) {
        this.parentOrGuardianRole = parentOrGuardianRole;
    }

}
