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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RelatedPersonBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT400001CA.CoveredParty","FICR_MT400003CA.CoveredParty","FICR_MT400004CA.CoveredParty","FICR_MT490101CA.CoveredParty","FICR_MT490102CA.CoveredParty"})
public class CoveredPartyBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private II coveredPartyIdentifier = new IIImpl();
    private CV relationshipToPolicyHolder = new CVImpl();
    private SET<PN, PersonName> coveredPartyPatientNameS = new SETImpl<PN, PersonName>(PNImpl.class);
    private CV coveredPartyPatientGender = new CVImpl();
    private TS coveredPartyPatientDateOfBirth = new TSImpl();
    private AD coveredPartyPatientAddress = new ADImpl();
    private List<RelatedPersonBean> indirectAuthorityPersonalRelationship = new ArrayList<RelatedPersonBean>();


    /**
     * <p>CoveredPartyIdentifier</p>
     * 
     * <p>Covered Party Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getCoveredPartyIdentifier() {
        return this.coveredPartyIdentifier.getValue();
    }
    public void setCoveredPartyIdentifier(Identifier coveredPartyIdentifier) {
        this.coveredPartyIdentifier.setValue(coveredPartyIdentifier);
    }


    /**
     * <p>RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship to Policy Holder</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getRelationshipToPolicyHolder() {
        return (Code) this.relationshipToPolicyHolder.getValue();
    }
    public void setRelationshipToPolicyHolder(Code relationshipToPolicyHolder) {
        this.relationshipToPolicyHolder.setValue(relationshipToPolicyHolder);
    }


    /**
     * <p>CoveredPartyPatientNameS</p>
     * 
     * <p>Covered Party (Patient) Name(s</p>
     */
    @Hl7XmlMapping({"coveredPartyAsPatientPerson/name"})
    public Set<PersonName> getCoveredPartyPatientNameS() {
        return this.coveredPartyPatientNameS.rawSet();
    }


    /**
     * <p>CoveredPartyPatientGender</p>
     * 
     * <p>Covered Party (Patient) Gender</p>
     */
    @Hl7XmlMapping({"coveredPartyAsPatientPerson/administrativeGenderCode"})
    public AdministrativeGender getCoveredPartyPatientGender() {
        return (AdministrativeGender) this.coveredPartyPatientGender.getValue();
    }
    public void setCoveredPartyPatientGender(AdministrativeGender coveredPartyPatientGender) {
        this.coveredPartyPatientGender.setValue(coveredPartyPatientGender);
    }


    /**
     * <p>CoveredPartyPatientDateOfBirth</p>
     * 
     * <p>Covered Party (Patient) Date of Birth</p>
     */
    @Hl7XmlMapping({"coveredPartyAsPatientPerson/birthTime"})
    public Date getCoveredPartyPatientDateOfBirth() {
        return this.coveredPartyPatientDateOfBirth.getValue();
    }
    public void setCoveredPartyPatientDateOfBirth(Date coveredPartyPatientDateOfBirth) {
        this.coveredPartyPatientDateOfBirth.setValue(coveredPartyPatientDateOfBirth);
    }


    /**
     * <p>CoveredPartyPatientAddress</p>
     * 
     * <p>Covered Party (Patient) Address</p>
     */
    @Hl7XmlMapping({"coveredPartyAsPatientPerson/addr"})
    public PostalAddress getCoveredPartyPatientAddress() {
        return this.coveredPartyPatientAddress.getValue();
    }
    public void setCoveredPartyPatientAddress(PostalAddress coveredPartyPatientAddress) {
        this.coveredPartyPatientAddress.setValue(coveredPartyPatientAddress);
    }


    @Hl7XmlMapping({"indirectAuthority/personalRelationship"})
    public List<RelatedPersonBean> getIndirectAuthorityPersonalRelationship() {
        return this.indirectAuthorityPersonalRelationship;
    }

}
