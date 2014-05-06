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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.domainvalue.CoveredPartyRoleType;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.PersonalRelationshipBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT400001CA.CoveredParty","FICR_MT400003CA.CoveredParty","FICR_MT400004CA.CoveredParty","FICR_MT490101CA.CoveredParty","FICR_MT490102CA.CoveredParty"})
public class CoveredPartyBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private SET<PN, PersonName> coveredPartyAsPatientPersonName = new SETImpl<PN, PersonName>(PNImpl.class);
    private CV coveredPartyAsPatientPersonAdministrativeGenderCode = new CVImpl();
    private TS coveredPartyAsPatientPersonBirthTime = new TSImpl();
    private AD coveredPartyAsPatientPersonAddr = new ADImpl();
    private List<PersonalRelationshipBean> indirectAuthorityPersonalRelationship = new ArrayList<PersonalRelationshipBean>();


    /**
     * <p>Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490101CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400001CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400003CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400004CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490102CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490101CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400001CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400003CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400004CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490102CA.CoveredParty.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT490101CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT400001CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT400003CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT400004CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT490102CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CoveredPartyRoleType getCode() {
        return (CoveredPartyRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT490101CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT400001CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT400003CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT400004CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT490102CA.CoveredParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(CoveredPartyRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: CoveredPartyPatientNameS</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientNameS</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.CoveredPartyAsPatientPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientNameS</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.CoveredPartyAsPatientPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientNameS</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.CoveredPartyAsPatientPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientNameS</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.CoveredPartyAsPatientPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientNameS</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.CoveredPartyAsPatientPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     */
    @Hl7XmlMapping({"coveredPartyAsPatientPerson/name"})
    public Set<PersonName> getCoveredPartyAsPatientPersonName() {
        return this.coveredPartyAsPatientPersonName.rawSet();
    }


    /**
     * <p>Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"coveredPartyAsPatientPerson/administrativeGenderCode"})
    public AdministrativeGender getCoveredPartyAsPatientPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.coveredPartyAsPatientPersonAdministrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientGender</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.CoveredPartyAsPatientPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCoveredPartyAsPatientPersonAdministrativeGenderCode(AdministrativeGender coveredPartyAsPatientPersonAdministrativeGenderCode) {
        this.coveredPartyAsPatientPersonAdministrativeGenderCode.setValue(coveredPartyAsPatientPersonAdministrativeGenderCode);
    }


    /**
     * <p>Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"coveredPartyAsPatientPerson/birthTime"})
    public Date getCoveredPartyAsPatientPersonBirthTime() {
        return this.coveredPartyAsPatientPersonBirthTime.getValue();
    }

    /**
     * <p>Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.CoveredPartyAsPatientPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCoveredPartyAsPatientPersonBirthTime(Date coveredPartyAsPatientPersonBirthTime) {
        this.coveredPartyAsPatientPersonBirthTime.setValue(coveredPartyAsPatientPersonBirthTime);
    }


    /**
     * <p>Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"coveredPartyAsPatientPerson/addr"})
    public PostalAddress getCoveredPartyAsPatientPersonAddr() {
        return this.coveredPartyAsPatientPersonAddr.getValue();
    }

    /**
     * <p>Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientAddress</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.CoveredPartyAsPatientPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setCoveredPartyAsPatientPersonAddr(PostalAddress coveredPartyAsPatientPersonAddr) {
        this.coveredPartyAsPatientPersonAddr.setValue(coveredPartyAsPatientPersonAddr);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"indirectAuthority/personalRelationship"})
    public List<PersonalRelationshipBean> getIndirectAuthorityPersonalRelationship() {
        return this.indirectAuthorityPersonalRelationship;
    }

}