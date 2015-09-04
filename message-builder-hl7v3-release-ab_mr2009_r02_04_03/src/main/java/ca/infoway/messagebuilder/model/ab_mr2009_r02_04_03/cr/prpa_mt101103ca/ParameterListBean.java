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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PRPA_MT101103CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV administrativeGenderValue = new CVImpl();
    private List<II> clientIdValue = new ArrayList<II>();
    private DeceasedIndicatorBean deceasedIndicator;
    private DeceasedTimeBean deceasedTime;
    private FathersNameBean fathersName;
    private LanguageCodeBean languageCode;
    private MothersMaidenNameBean mothersMaidenName;
    private MultipleBirthIndicatorBean multipleBirthIndicator;
    private MultipleBirthOrderNumberBean multipleBirthOrderNumber;
    private List<AD> personAddressValue = new ArrayList<AD>();
    private TS personBirthtimeValue = new TSImpl();
    private List<PN> personNameValue = new ArrayList<PN>();
    private List<TEL> personTelecomValue = new ArrayList<TEL>();
    private PersonalRelationshipCodeBean personalRelationshipCode;


    /**
     * <p>Business Name: Client Gender</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.AdministrativeGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"administrativeGender/value"})
    public AdministrativeGender getAdministrativeGenderValue() {
        return (AdministrativeGender) this.administrativeGenderValue.getValue();
    }

    /**
     * <p>Business Name: Client Gender</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.AdministrativeGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAdministrativeGenderValue(AdministrativeGender administrativeGenderValue) {
        this.administrativeGenderValue.setValue(administrativeGenderValue);
    }


    /**
     * <p>Business Name: (Client Healthcare Identification Number 
     * And Or NonHealthcare Identification</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.ClientId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"clientId/value"})
    public List<Identifier> getClientIdValue() {
        return new RawListWrapper<II, Identifier>(clientIdValue, IIImpl.class);
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.deceasedIndicator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"deceasedIndicator"})
    public DeceasedIndicatorBean getDeceasedIndicator() {
        return this.deceasedIndicator;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.deceasedIndicator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDeceasedIndicator(DeceasedIndicatorBean deceasedIndicator) {
        this.deceasedIndicator = deceasedIndicator;
    }


    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"deceasedTime"})
    public DeceasedTimeBean getDeceasedTime() {
        return this.deceasedTime;
    }

    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setDeceasedTime(DeceasedTimeBean deceasedTime) {
        this.deceasedTime = deceasedTime;
    }


    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.fathersName</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"fathersName"})
    public FathersNameBean getFathersName() {
        return this.fathersName;
    }

    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.fathersName</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setFathersName(FathersNameBean fathersName) {
        this.fathersName = fathersName;
    }


    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public LanguageCodeBean getLanguageCode() {
        return this.languageCode;
    }

    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setLanguageCode(LanguageCodeBean languageCode) {
        this.languageCode = languageCode;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.mothersMaidenName</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"mothersMaidenName"})
    public MothersMaidenNameBean getMothersMaidenName() {
        return this.mothersMaidenName;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.mothersMaidenName</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMothersMaidenName(MothersMaidenNameBean mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.multipleBirthIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"multipleBirthIndicator"})
    public MultipleBirthIndicatorBean getMultipleBirthIndicator() {
        return this.multipleBirthIndicator;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.multipleBirthIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setMultipleBirthIndicator(MultipleBirthIndicatorBean multipleBirthIndicator) {
        this.multipleBirthIndicator = multipleBirthIndicator;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"multipleBirthOrderNumber"})
    public MultipleBirthOrderNumberBean getMultipleBirthOrderNumber() {
        return this.multipleBirthOrderNumber;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setMultipleBirthOrderNumber(MultipleBirthOrderNumberBean multipleBirthOrderNumber) {
        this.multipleBirthOrderNumber = multipleBirthOrderNumber;
    }


    /**
     * <p>Business Name: Client Address</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonAddress.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"personAddress/value"})
    public List<PostalAddress> getPersonAddressValue() {
        return new RawListWrapper<AD, PostalAddress>(personAddressValue, ADImpl.class);
    }


    /**
     * <p>Business Name: Client Date of Birth</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonBirthtime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"personBirthtime/value"})
    public Date getPersonBirthtimeValue() {
        return this.personBirthtimeValue.getValue();
    }

    /**
     * <p>Business Name: Client Date of Birth</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonBirthtime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPersonBirthtimeValue(Date personBirthtimeValue) {
        this.personBirthtimeValue.setValue(personBirthtimeValue);
    }


    /**
     * <p>Business Name: Client Name</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"personName/value"})
    public List<PersonName> getPersonNameValue() {
        return new RawListWrapper<PN, PersonName>(personNameValue, PNImpl.class);
    }


    /**
     * <p>Business Name: Client Telecom</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonTelecom.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"personTelecom/value"})
    public List<TelecommunicationAddress> getPersonTelecomValue() {
        return new RawListWrapper<TEL, TelecommunicationAddress>(personTelecomValue, TELImpl.class);
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.personalRelationshipCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"personalRelationshipCode"})
    public PersonalRelationshipCodeBean getPersonalRelationshipCode() {
        return this.personalRelationshipCode;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.personalRelationshipCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPersonalRelationshipCode(PersonalRelationshipCodeBean personalRelationshipCode) {
        this.personalRelationshipCode = personalRelationshipCode;
    }

}