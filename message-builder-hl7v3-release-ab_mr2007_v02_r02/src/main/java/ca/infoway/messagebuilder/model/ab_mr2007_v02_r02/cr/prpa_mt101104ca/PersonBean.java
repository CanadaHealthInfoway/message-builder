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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.cr.prpa_mt101104ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.EntityClass;
import ca.infoway.messagebuilder.domainvalue.EntityDeterminer;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.cr.merged.LanguageCommunicationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.cr.merged.OtherIDsNonHealthcareIdentifiersBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.cr.merged.PersonalRelationshipBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>*Person</p>
 * 
 * <p><p>deceasedTime is only present when deceasedInd = 
 * TRUE</p></p>
 * 
 * <p><p>The Person class contains identifying and demographic 
 * data elements for the focal person similar to those in the 
 * HL7 v2.x PID segment such as name, gender, date of birth, 
 * deceased indicator and time.</p></p>
 * 
 * <p><p>Provides additional demographic data elements for the 
 * focal class IdentifiedEntity</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT101104CA.Person"})
public class PersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CS classCode = new CSImpl();
    private CS determinerCode = new CSImpl();
    private PN name = new PNImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CV administrativeGenderCode = new CVImpl();
    private TS birthTime = new TSImpl();
    private BL deceasedInd = new BLImpl();
    private TS deceasedTime = new TSImpl();
    private List<BL> multipleBirthInd = new ArrayList<BL>();
    private List<INT> multipleBirthOrderNumber = new ArrayList<INT>();
    private AD addr = new ADImpl();
    private List<OtherIDsNonHealthcareIdentifiersBean> asOtherIDs = new ArrayList<OtherIDsNonHealthcareIdentifiersBean>();
    private List<PersonalRelationshipBean> personalRelationship = new ArrayList<PersonalRelationshipBean>();
    private List<LanguageCommunicationBean> languageCommunication = new ArrayList<LanguageCommunicationBean>();


    /**
     * <p><p>An HL7 defined value representing the class or 
     * category that the Entity instance 
     * represents.</p><p>Examples: Person, Animal, Chemical 
     * Substance, Group, Organization</p></p>
     * 
     * <p><p>An HL7 defined value representing the class or 
     * category that the Entity instance 
     * represents.</p><p>Examples: Person, Animal, Chemical 
     * Substance, Group, Organization</p></p>
     * 
     * <p><p>Due to the extremely large number of potential values 
     * for a code set representing all physical things in the 
     * universe, the class code indicates both the subtype branch 
     * of the Entity hierarchy used as well as a high level 
     * classifier to represent the instance of Entity. This can be 
     * used to constrain the eligible value domains for the 
     * Entity.code attribute.</p></p>
     * 
     * <p><p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityClass.htm</p></p>
     */
    @Hl7XmlMapping({"classCode"})
    public EntityClass getClassCode() {
        return (EntityClass) this.classCode.getValue();
    }
    public void setClassCode(EntityClass classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p><p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p></p>
     * 
     * <p><p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p></p>
     * 
     * <p><p>An Entity may at times represent information 
     * concerning a specific instance (the most common), a 
     * quantifiable group with common characteristics or a general 
     * type of Entity. This code distinguishes these different 
     * representations.</p></p>
     * 
     * <p><p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityDeterminer.htm</p></p>
     */
    @Hl7XmlMapping({"determinerCode"})
    public EntityDeterminer getDeterminerCode() {
        return (EntityDeterminer) this.determinerCode.getValue();
    }
    public void setDeterminerCode(EntityDeterminer determinerCode) {
        this.determinerCode.setValue(determinerCode);
    }


    /**
     * <p>Client Name</p>
     * 
     * <p><p>Name(s) for the Client</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getName() {
        return this.name.getValue();
    }
    public void setName(PersonName name) {
        this.name.setValue(name);
    }


    /**
     * <p>Client Telecom</p>
     * 
     * <p><p>Provides information about telecom</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Client Gender</p>
     * 
     * <p><p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or 
     * Undifferentiated (U)</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getAdministrativeGenderCode() {
        return (AdministrativeGender) this.administrativeGenderCode.getValue();
    }
    public void setAdministrativeGenderCode(AdministrativeGender administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }


    /**
     * <p>Client Date of Birth</p>
     * 
     * <p><p>Date of birth of the Client</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"birthTime"})
    public Date getBirthTime() {
        return this.birthTime.getValue();
    }
    public void setBirthTime(Date birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>Client Deceased Indicator</p>
     * 
     * <p><p>An indication that the client is deceased.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"deceasedInd"})
    public Boolean getDeceasedInd() {
        return this.deceasedInd.getValue();
    }
    public void setDeceasedInd(Boolean deceasedInd) {
        this.deceasedInd.setValue(deceasedInd);
    }


    /**
     * <p>Client Deceased Date</p>
     * 
     * <p><p>The date and time that a client's death occurred.</p></p>
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
     * <p>Client Multiple Birth Indicator</p>
     * 
     * <p><p>An indication as to whether the client is part of a 
     * multiple birth.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"multipleBirthInd"})
    public List<Boolean> getMultipleBirthInd() {
        return new RawListWrapper<BL, Boolean>(multipleBirthInd, BLImpl.class);
    }


    /**
     * <p>Client Multiple Birth Order Number</p>
     * 
     * <p><p>The order in which this client was born if part of a 
     * multiple birth.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"multipleBirthOrderNumber"})
    public List<Integer> getMultipleBirthOrderNumber() {
        return new RawListWrapper<INT, Integer>(multipleBirthOrderNumber, INTImpl.class);
    }


    /**
     * <p>Client Address</p>
     * 
     * <p><p>Address(es) of the Client</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    @Hl7XmlMapping({"asOtherIDs"})
    public List<OtherIDsNonHealthcareIdentifiersBean> getAsOtherIDs() {
        return this.asOtherIDs;
    }


    @Hl7XmlMapping({"personalRelationship"})
    public List<PersonalRelationshipBean> getPersonalRelationship() {
        return this.personalRelationship;
    }


    @Hl7XmlMapping({"languageCommunication"})
    public List<LanguageCommunicationBean> getLanguageCommunication() {
        return this.languageCommunication;
    }

}