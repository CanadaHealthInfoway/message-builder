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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca;

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
 * <p>Business Name: Person Patient</p>
 * 
 * <p>The information of the person patient.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.CoveredPartyAsPatientPerson"})
public class PersonPatientBean extends MessagePartBean implements CoveredPartyAsPatientChoice {

    private static final long serialVersionUID = 20130103L;
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
     * 
     * <p>Name of the Patient</p>
     * 
     * <p>Person Name</p>
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
     * 
     * <p>Name of the Patient</p>
     * 
     * <p>Person Name</p>
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
     * 
     * <p>Administrative Gender is mandatory for Invoices without a 
     * policy identifier (e.g. WCB or Auto claim).</p><p>This would 
     * also be mandatory for active enrollment.</p><p>May not be 
     * provided based on privacy legislation, so cannot be 
     * mandatory and then NP'd b</p>
     * 
     * <p>The gender of the patient</p>
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
     * 
     * <p>Administrative Gender is mandatory for Invoices without a 
     * policy identifier (e.g. WCB or Auto claim).</p><p>This would 
     * also be mandatory for active enrollment.</p><p>May not be 
     * provided based on privacy legislation, so cannot be 
     * mandatory and then NP'd b</p>
     * 
     * <p>The gender of the patient</p>
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
     * 
     * <p>Patient Date of Birth + Patient Name and/or Patient 
     * Gender is used to help confirm the policy 
     * identifier.</p><p>Birth date is mandatory for Invoices 
     * without a policy identifier (e.g. WCB or Auto 
     * claim).</p><p>This would also be mandatory for active 
     * enrollment.</p><p>May not be provided based on privacy 
     * legislation, so cannot be mandatory and then NP'd by a 
     * benefit group (e.g. Rx).</p><p>Only date portion should be 
     * specified.</p>
     * 
     * <p>RxS1: Specify as YYYYMMDD.</p>
     * 
     * <p>Patient Date of Birth</p>
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
     * 
     * <p>Patient Date of Birth + Patient Name and/or Patient 
     * Gender is used to help confirm the policy 
     * identifier.</p><p>Birth date is mandatory for Invoices 
     * without a policy identifier (e.g. WCB or Auto 
     * claim).</p><p>This would also be mandatory for active 
     * enrollment.</p><p>May not be provided based on privacy 
     * legislation, so cannot be mandatory and then NP'd by a 
     * benefit group (e.g. Rx).</p><p>Only date portion should be 
     * specified.</p>
     * 
     * <p>RxS1: Specify as YYYYMMDD.</p>
     * 
     * <p>Patient Date of Birth</p>
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
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>An indicator used to specify if the patient is part of a 
     * multiple birth, as in a twin, triplet, etc.</p>
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
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>An indicator used to specify if the patient is part of a 
     * multiple birth, as in a twin, triplet, etc.</p>
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
     * 
     * <p>Valid only if MultipleBirthIndicator set to positive</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>The order of birth of the patient in the situation that 
     * the patient is indicated as part of a multiple birth.</p>
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
     * 
     * <p>Valid only if MultipleBirthIndicator set to positive</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>The order of birth of the patient in the situation that 
     * the patient is indicated as part of a multiple birth.</p>
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
     * 
     * <p>Guardian or Parent of new born. For example, use by 
     * FNIHB, as the newborn child under 1 is assumed to be a 
     * covered party under the policy. This would allow the 
     * specification of guardian, as this is not a familial 
     * relationship.</p><p>Guardian information is typically noted 
     * at time of claim enrollment (registration) and therefore may 
     * not be required on an invoice by invoice basis.</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>The parent or guardian information of the patient.</p>
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
     * 
     * <p>Guardian or Parent of new born. For example, use by 
     * FNIHB, as the newborn child under 1 is assumed to be a 
     * covered party under the policy. This would allow the 
     * specification of guardian, as this is not a familial 
     * relationship.</p><p>Guardian information is typically noted 
     * at time of claim enrollment (registration) and therefore may 
     * not be required on an invoice by invoice basis.</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>The parent or guardian information of the patient.</p>
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
     * 
     * <p>The allowable values are PRN (parent), MTH (mother) and 
     * FTH (father).</p><p>RxS1: Not permitted for this 
     * scenario.</p>
     * 
     * <p>The relationship of the parent or the guardian to the 
     * Patient. I.e.. Father, Mother, Aunt</p>
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
     * 
     * <p>The allowable values are PRN (parent), MTH (mother) and 
     * FTH (father).</p><p>RxS1: Not permitted for this 
     * scenario.</p>
     * 
     * <p>The relationship of the parent or the guardian to the 
     * Patient. I.e.. Father, Mother, Aunt</p>
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
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>Name of Parent or Guardian</p>
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
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>Name of Parent or Guardian</p>
     */
    public void setParentOrGuardianRoleRelationshipHolderName(PersonName parentOrGuardianRoleRelationshipHolderName) {
        this.parentOrGuardianRoleRelationshipHolderName.setValue(parentOrGuardianRoleRelationshipHolderName);
    }

}
