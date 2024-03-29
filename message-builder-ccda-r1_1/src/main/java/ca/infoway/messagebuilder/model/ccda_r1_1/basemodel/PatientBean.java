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
package ca.infoway.messagebuilder.model.ccda_r1_1.basemodel;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS_R2;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TS_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.BirthplaceBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"BaseModel.Patient"})
public class PatientBean extends MessagePartBean {

    private static final long serialVersionUID = 20190617L;
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private II id = new IIImpl();
    private LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CE_R2<Code> administrativeGenderCode = new CE_R2Impl<Code>();
    private TS_R2 birthTime = new TS_R2Impl();
    private CE_R2<Code> maritalStatusCode = new CE_R2Impl<Code>();
    private CE_R2<Code> religiousAffiliationCode = new CE_R2Impl<Code>();
    private CE_R2<Code> raceCode = new CE_R2Impl<Code>();
    private CE_R2<Code> ethnicGroupCode = new CE_R2Impl<Code>();
    private List<GuardianBean> guardian = new ArrayList<GuardianBean>();
    private BirthplaceBean birthplace;
    private List<LanguageCommunicationBean> languageCommunication = new ArrayList<LanguageCommunicationBean>();


    /**
     * <p>Relationship: BaseModel.Patient.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Patient.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: BaseModel.Patient.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: BaseModel.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Patient.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: BaseModel.Patient.name</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getName() {
        return this.name.rawList();
    }


    /**
     * <p>Relationship: BaseModel.Patient.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public CodedTypeR2<Code> getAdministrativeGenderCode() {
        return (CodedTypeR2<Code>) this.administrativeGenderCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Patient.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAdministrativeGenderCode(CodedTypeR2<Code> administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }


    /**
     * <p>Relationship: BaseModel.Patient.birthTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"birthTime"})
    public MbDate getBirthTime() {
        return this.birthTime.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Patient.birthTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setBirthTime(MbDate birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>Relationship: BaseModel.Patient.maritalStatusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"maritalStatusCode"})
    public CodedTypeR2<Code> getMaritalStatusCode() {
        return (CodedTypeR2<Code>) this.maritalStatusCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Patient.maritalStatusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMaritalStatusCode(CodedTypeR2<Code> maritalStatusCode) {
        this.maritalStatusCode.setValue(maritalStatusCode);
    }


    /**
     * <p>Relationship: BaseModel.Patient.religiousAffiliationCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"religiousAffiliationCode"})
    public CodedTypeR2<Code> getReligiousAffiliationCode() {
        return (CodedTypeR2<Code>) this.religiousAffiliationCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Patient.religiousAffiliationCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setReligiousAffiliationCode(CodedTypeR2<Code> religiousAffiliationCode) {
        this.religiousAffiliationCode.setValue(religiousAffiliationCode);
    }


    /**
     * <p>Relationship: BaseModel.Patient.raceCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"raceCode"})
    public CodedTypeR2<Code> getRaceCode() {
        return (CodedTypeR2<Code>) this.raceCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Patient.raceCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRaceCode(CodedTypeR2<Code> raceCode) {
        this.raceCode.setValue(raceCode);
    }


    /**
     * <p>Relationship: BaseModel.Patient.ethnicGroupCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"ethnicGroupCode"})
    public CodedTypeR2<Code> getEthnicGroupCode() {
        return (CodedTypeR2<Code>) this.ethnicGroupCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Patient.ethnicGroupCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEthnicGroupCode(CodedTypeR2<Code> ethnicGroupCode) {
        this.ethnicGroupCode.setValue(ethnicGroupCode);
    }


    /**
     * <p>Relationship: BaseModel.Patient.guardian</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"guardian"})
    public List<GuardianBean> getGuardian() {
        return this.guardian;
    }


    /**
     * <p>Relationship: BaseModel.Patient.birthplace</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"birthplace"})
    public BirthplaceBean getBirthplace() {
        return this.birthplace;
    }

    /**
     * <p>Relationship: BaseModel.Patient.birthplace</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setBirthplace(BirthplaceBean birthplace) {
        this.birthplace = birthplace;
    }


    /**
     * <p>Relationship: BaseModel.Patient.languageCommunication</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"languageCommunication"})
    public List<LanguageCommunicationBean> getLanguageCommunication() {
        return this.languageCommunication;
    }

}
