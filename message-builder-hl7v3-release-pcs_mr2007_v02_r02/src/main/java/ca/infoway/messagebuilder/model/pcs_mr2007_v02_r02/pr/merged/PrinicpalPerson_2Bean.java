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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.LanguageCommunicationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: PrinicpalPerson</p>
 * 
 * <p>PRPM_MT306051CA.PrincipalPerson: Prinicpal Person</p>
 * 
 * <p>Provides additional information about the person playing 
 * the role of Healthcare Provider</p>
 * 
 * <p>Identification of playing entity is required (0..1) to 
 * support the case in which information directly related to 
 * the playing party is not needed.</p>
 * 
 * <p>PRPM_MT306011CA.PrincipalPerson: Prinicpal Person</p>
 * 
 * <p>Provides additional information about the person playing 
 * the role of Healthcare Provider</p>
 * 
 * <p>Identification of playing entity is required (0..1) to 
 * support the case in which information directly related to 
 * the playing party is not needed.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.PrincipalPerson","PRPM_MT306051CA.PrincipalPerson"})
public class PrinicpalPerson_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CV administrativeGenderCode = new CVImpl();
    private TS birthTime = new TSImpl();
    private BL deceasedInd = new BLImpl();
    private TS deceasedTime = new TSImpl();
    private AD birthplaceAddr = new ADImpl();
    private List<LanguageCommunicationBean> languageCommunication = new ArrayList<LanguageCommunicationBean>();


    /**
     * <p>Business Name: PrincipalPersonAggregateIdentifier</p>
     * 
     * <p>Other Business Name: PrincipalPersonAggregateIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.PrincipalPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>A unique identifier for the person who may play various 
     * healthcare provider roles. This identifier is specific to 
     * the person not their roles.</p>
     * 
     * <p>Other Business Name: PrincipalPersonAggregateIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.PrincipalPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>A unique identifier for the person who may play various 
     * healthcare provider roles. This identifier is specific to 
     * the person not their roles.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: PrincipalPersonName</p>
     * 
     * <p>Other Business Name: PrincipalPersonName</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.PrincipalPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The persons name independent of any role they may 
     * play.</p>
     * 
     * <p>Other Business Name: PrincipalPersonName</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.PrincipalPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>If Principal Person is included in the message, then 
     * Person Name Must Exist.</p>
     * 
     * <p>The persons name independent of any role they may 
     * play.</p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getName() {
        return this.name.rawList();
    }


    /**
     * <p>Business Name: PrincipalPersonGender</p>
     * 
     * <p>Other Business Name: PrincipalPersonGender</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.PrincipalPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>If Principal Person is included in the message, then 
     * Person Gender is Expected to Exist.</p>
     * 
     * <p>The principal persons gender.</p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getAdministrativeGenderCode() {
        return (AdministrativeGender) this.administrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: PrincipalPersonGender</p>
     * 
     * <p>Other Business Name: PrincipalPersonGender</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.PrincipalPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>If Principal Person is included in the message, then 
     * Person Gender is Expected to Exist.</p>
     * 
     * <p>The principal persons gender.</p>
     */
    public void setAdministrativeGenderCode(AdministrativeGender administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }


    /**
     * <p>Business Name: PrincipalPersonDateOfBirth</p>
     * 
     * <p>Other Business Name: PrincipalPersonDateOfBirth</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.PrincipalPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>If Principal Person is included in the message, then 
     * Prinicpal Person Date of Birth is Expected to Exist.</p>
     * 
     * <p>The principal persons date of birth.</p>
     */
    @Hl7XmlMapping({"birthTime"})
    public Date getBirthTime() {
        return this.birthTime.getValue();
    }

    /**
     * <p>Business Name: PrincipalPersonDateOfBirth</p>
     * 
     * <p>Other Business Name: PrincipalPersonDateOfBirth</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.PrincipalPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>If Principal Person is included in the message, then 
     * Prinicpal Person Date of Birth is Expected to Exist.</p>
     * 
     * <p>The principal persons date of birth.</p>
     */
    public void setBirthTime(Date birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>Business Name: PrincipalPersonDeceasedIndicator</p>
     * 
     * <p>Other Business Name: PrincipalPersonDeceasedIndicator</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.PrincipalPerson.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>An indication that the principal person is deceased.</p>
     */
    @Hl7XmlMapping({"deceasedInd"})
    public Boolean getDeceasedInd() {
        return this.deceasedInd.getValue();
    }

    /**
     * <p>Business Name: PrincipalPersonDeceasedIndicator</p>
     * 
     * <p>Other Business Name: PrincipalPersonDeceasedIndicator</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.PrincipalPerson.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>An indication that the principal person is deceased.</p>
     */
    public void setDeceasedInd(Boolean deceasedInd) {
        this.deceasedInd.setValue(deceasedInd);
    }


    /**
     * <p>Business Name: PrincipalPersonDeceasedDate</p>
     * 
     * <p>Other Business Name: PrincipalPersonDeceasedDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.PrincipalPerson.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p>
     * 
     * <p>The date and time that a healthcare provider's death 
     * occurred.</p>
     */
    @Hl7XmlMapping({"deceasedTime"})
    public Date getDeceasedTime() {
        return this.deceasedTime.getValue();
    }

    /**
     * <p>Business Name: PrincipalPersonDeceasedDate</p>
     * 
     * <p>Other Business Name: PrincipalPersonDeceasedDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.PrincipalPerson.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p>
     * 
     * <p>The date and time that a healthcare provider's death 
     * occurred.</p>
     */
    public void setDeceasedTime(Date deceasedTime) {
        this.deceasedTime.setValue(deceasedTime);
    }


    /**
     * <p>Business Name: BirthplaceAddress</p>
     * 
     * <p>Other Business Name: BirthplaceAddress</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Birthplace.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>If Birthplace is included in the message, then Address is 
     * Expected to Exist.</p>
     * 
     * <p>Principal person's address at time of birth</p>
     */
    @Hl7XmlMapping({"birthplace/addr"})
    public PostalAddress getBirthplaceAddr() {
        return this.birthplaceAddr.getValue();
    }

    /**
     * <p>Business Name: BirthplaceAddress</p>
     * 
     * <p>Other Business Name: BirthplaceAddress</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Birthplace.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>If Birthplace is included in the message, then Address is 
     * Expected to Exist.</p>
     * 
     * <p>Principal person's address at time of birth</p>
     */
    public void setBirthplaceAddr(PostalAddress birthplaceAddr) {
        this.birthplaceAddr.setValue(birthplaceAddr);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.PrincipalPerson.languageCommunication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"languageCommunication"})
    public List<LanguageCommunicationBean> getLanguageCommunication() {
        return this.languageCommunication;
    }

}
