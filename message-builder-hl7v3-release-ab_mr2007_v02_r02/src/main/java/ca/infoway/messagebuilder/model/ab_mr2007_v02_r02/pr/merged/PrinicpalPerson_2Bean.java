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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pr.merged;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.LanguageOfCommunicationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>PrinicpalPerson</p>
 * 
 * <p>PRPM_MT306051CA.PrincipalPerson: Prinicpal Person</p>
 * 
 * <p><p>Identification of playing entity is required (0..1) to 
 * support the case in which information directly related to 
 * the playing party is not needed.</p></p>
 * 
 * <p><p>Provides additional information about the person 
 * playing the role of Healthcare Provider</p></p>
 * 
 * <p>PRPM_MT306011CA.PrincipalPerson: Prinicpal Person</p>
 * 
 * <p><p>Identification of playing entity is required (0..1) to 
 * support the case in which information directly related to 
 * the playing party is not needed.</p></p>
 * 
 * <p><p>Provides additional information about the person 
 * playing the role of Healthcare Provider</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.PrincipalPerson","PRPM_MT306051CA.PrincipalPerson"})
public class PrinicpalPerson_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CV administrativeGenderCode = new CVImpl();
    private TS birthTime = new TSImpl();
    private BL deceasedInd = new BLImpl();
    private TS deceasedTime = new TSImpl();
    private AD birthplaceAddr = new ADImpl();
    private List<LanguageOfCommunicationBean> languageCommunication = new ArrayList<LanguageOfCommunicationBean>();


    /**
     * <p>PrincipalPersonAggregateIdentifier</p>
     * 
     * <p>Principal Person Aggregate Identifier</p>
     * 
     * <p><p>A unique identifier for the person who may play 
     * various healthcare provider roles. This identifier is 
     * specific to the person not their roles.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>PrincipalPersonName</p>
     * 
     * <p>Principal Person Name</p>
     * 
     * <p><p>The person&#226;&#128;&#153;s name independent of any 
     * role they may play.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     * 
     * <p><p>If Principal Person is included in the message, then 
     * Person Name Must Exist.</p></p>
     * 
     * <p>Principal Person Name</p>
     * 
     * <p><p>The person&#226;&#128;&#153;s name independent of any 
     * role they may play.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getName() {
        return this.name.rawList();
    }


    /**
     * <p>PrincipalPersonGender</p>
     * 
     * <p>Principal Person Gender</p>
     * 
     * <p><p>The principal person&#226;&#128;&#153;s gender.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     * 
     * <p><p>If Principal Person is included in the message, then 
     * Person Gender is Expected to Exist.</p></p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getAdministrativeGenderCode() {
        return (AdministrativeGender) this.administrativeGenderCode.getValue();
    }
    public void setAdministrativeGenderCode(AdministrativeGender administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }


    /**
     * <p>PrincipalPersonDateOfBirth</p>
     * 
     * <p>Principal Person Date of Birth</p>
     * 
     * <p><p>The principal person&#226;&#128;&#153;s date of 
     * birth.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     * 
     * <p><p>If Principal Person is included in the message, then 
     * Prinicpal Person Date of Birth is Expected to Exist.</p></p>
     */
    @Hl7XmlMapping({"birthTime"})
    public Date getBirthTime() {
        return this.birthTime.getValue();
    }
    public void setBirthTime(Date birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>PrincipalPersonDeceasedIndicator</p>
     * 
     * <p>Principal Person Deceased Indicator</p>
     * 
     * <p><p>An indication that the principal person is 
     * deceased.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"deceasedInd"})
    public Boolean getDeceasedInd() {
        return this.deceasedInd.getValue();
    }
    public void setDeceasedInd(Boolean deceasedInd) {
        this.deceasedInd.setValue(deceasedInd);
    }


    /**
     * <p>PrincipalPersonDeceasedDate</p>
     * 
     * <p>Principal Person Deceased Date</p>
     * 
     * <p><p>The date and time that a healthcare provider's death 
     * occurred.</p></p>
     * 
     * <p><p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p></p>
     */
    @Hl7XmlMapping({"deceasedTime"})
    public Date getDeceasedTime() {
        return this.deceasedTime.getValue();
    }
    public void setDeceasedTime(Date deceasedTime) {
        this.deceasedTime.setValue(deceasedTime);
    }


    /**
     * <p>BirthplaceAddress</p>
     * 
     * <p>Birthplace Address</p>
     * 
     * <p><p>Principal person's address at time of birth</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     * 
     * <p><p>If Birthplace is included in the message, then Address 
     * is Expected to Exist.</p></p>
     */
    @Hl7XmlMapping({"birthplace/addr"})
    public PostalAddress getBirthplaceAddr() {
        return this.birthplaceAddr.getValue();
    }
    public void setBirthplaceAddr(PostalAddress birthplaceAddr) {
        this.birthplaceAddr.setValue(birthplaceAddr);
    }


    @Hl7XmlMapping({"languageCommunication"})
    public List<LanguageOfCommunicationBean> getLanguageCommunication() {
        return this.languageCommunication;
    }

}
