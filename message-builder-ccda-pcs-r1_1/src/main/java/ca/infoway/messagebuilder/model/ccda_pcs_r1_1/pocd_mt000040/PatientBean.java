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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.pocd_mt000040;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TSCDAR1;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.BirthplaceBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POCD_MT000040.Patient"})
public class PatientBean extends MessagePartBean {

    private static final long serialVersionUID = 20150206L;
    private LIST<CS, Code> realmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private II id = new IIImpl();
    private LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CE administrativeGenderCode = new CEImpl();
    private TSCDAR1 birthTime = new TSCDAR1Impl();
    private CE maritalStatusCode = new CEImpl();
    private CE religiousAffiliationCode = new CEImpl();
    private CE raceCode = new CEImpl();
    private CE ethnicGroupCode = new CEImpl();
    private List<GuardianBean> guardian = new ArrayList<GuardianBean>();
    private BirthplaceBean birthplace;
    private List<LanguageCommunicationBean> languageCommunication = new ArrayList<LanguageCommunicationBean>();


    /**
     * <p>Relationship: POCD_MT000040.Patient.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<Code> getRealmCode() {
        return this.realmCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Patient.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.name</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getName() {
        return this.name.rawList();
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.Patient.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public Code getAdministrativeGenderCode() {
        return (Code) this.administrativeGenderCode.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.Patient.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAdministrativeGenderCode(Code administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.birthTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"birthTime"})
    public MbDate getBirthTime() {
        return this.birthTime.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Patient.birthTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setBirthTime(MbDate birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.maritalStatusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"maritalStatusCode"})
    public Code getMaritalStatusCode() {
        return (Code) this.maritalStatusCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Patient.maritalStatusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMaritalStatusCode(Code maritalStatusCode) {
        this.maritalStatusCode.setValue(maritalStatusCode);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.Patient.religiousAffiliationCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"religiousAffiliationCode"})
    public Code getReligiousAffiliationCode() {
        return (Code) this.religiousAffiliationCode.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.Patient.religiousAffiliationCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setReligiousAffiliationCode(Code religiousAffiliationCode) {
        this.religiousAffiliationCode.setValue(religiousAffiliationCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.raceCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"raceCode"})
    public Code getRaceCode() {
        return (Code) this.raceCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Patient.raceCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRaceCode(Code raceCode) {
        this.raceCode.setValue(raceCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.ethnicGroupCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"ethnicGroupCode"})
    public Code getEthnicGroupCode() {
        return (Code) this.ethnicGroupCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Patient.ethnicGroupCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEthnicGroupCode(Code ethnicGroupCode) {
        this.ethnicGroupCode.setValue(ethnicGroupCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.guardian</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"guardian"})
    public List<GuardianBean> getGuardian() {
        return this.guardian;
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.birthplace</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"birthplace"})
    public BirthplaceBean getBirthplace() {
        return this.birthplace;
    }

    /**
     * <p>Relationship: POCD_MT000040.Patient.birthplace</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setBirthplace(BirthplaceBean birthplace) {
        this.birthplace = birthplace;
    }


    /**
     * <p>Relationship: POCD_MT000040.Patient.languageCommunication</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"languageCommunication"})
    public List<LanguageCommunicationBean> getLanguageCommunication() {
        return this.languageCommunication;
    }

}