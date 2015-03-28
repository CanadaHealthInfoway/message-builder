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
package ca.infoway.messagebuilder.model.ccda_r1_1.basemodel;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.List;



@Hl7PartTypeMapping({"BaseModel.LanguageCommunication"})
public class LanguageCommunicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150328L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CS_R2 languageCode = new CS_R2Impl();
    private CE_R2 modeCode = new CE_R2Impl();
    private CE_R2 proficiencyLevelCode = new CE_R2Impl();
    private BL preferenceInd = new BLImpl();


    /**
     * <p>Relationship: BaseModel.LanguageCommunication.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: BaseModel.LanguageCommunication.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: BaseModel.LanguageCommunication.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: BaseModel.LanguageCommunication.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * BaseModel.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public CodedTypeR2<Code> getLanguageCode() {
        return (CodedTypeR2<Code>) this.languageCode.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLanguageCode(CodedTypeR2<Code> languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: BaseModel.LanguageCommunication.modeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public CodedTypeR2<Code> getModeCode() {
        return (CodedTypeR2<Code>) this.modeCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.LanguageCommunication.modeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setModeCode(CodedTypeR2<Code> modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Relationship: 
     * BaseModel.LanguageCommunication.proficiencyLevelCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"proficiencyLevelCode"})
    public CodedTypeR2<Code> getProficiencyLevelCode() {
        return (CodedTypeR2<Code>) this.proficiencyLevelCode.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.LanguageCommunication.proficiencyLevelCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setProficiencyLevelCode(CodedTypeR2<Code> proficiencyLevelCode) {
        this.proficiencyLevelCode.setValue(proficiencyLevelCode);
    }


    /**
     * <p>Relationship: 
     * BaseModel.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"preferenceInd"})
    public Boolean getPreferenceInd() {
        return this.preferenceInd.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPreferenceInd(Boolean preferenceInd) {
        this.preferenceInd.setValue(preferenceInd);
    }

}
