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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.medicalgeneralhistorysection;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Component4Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.EntryBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.SubjectBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"MedicalGeneralHistorySection.Section"})
@Hl7RootType
public class SectionBean extends MessagePartBean {

    private static final long serialVersionUID = 20140915L;
    private ST iD = new STImpl();
    private CS_R2 classCode = new CS_R2Impl();
    private CS_R2 moodCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private II templateId = new IIImpl();
    private II id = new IIImpl();
    private ST title = new STImpl();
    private ED<EncapsulatedDataR2> text = new EDImpl<EncapsulatedDataR2>();
    private CE_R2 confidentialityCode = new CE_R2Impl();
    private CS_R2 languageCode = new CS_R2Impl();
    private SubjectBean subject;
    private List<Author_1Bean> author = new ArrayList<Author_1Bean>();
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private List<EntryBean> entry = new ArrayList<EntryBean>();
    private List<Component4Bean> component = new ArrayList<Component4Bean>();


    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.ID</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"ID"})
    public String getID() {
        return this.iD.getValue();
    }

    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.ID</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setID(String iD) {
        this.iD.setValue(iD);
    }


    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public CodedTypeR2<ActClass> getClassCode() {
        return (CodedTypeR2<ActClass>) this.classCode.getValue();
    }

    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setClassCode(CodedTypeR2<ActClass> classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public CodedTypeR2<ActMood> getMoodCode() {
        return (CodedTypeR2<ActMood>) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMoodCode(CodedTypeR2<ActMood> moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public Identifier getTemplateId() {
        return this.templateId.getValue();
    }

    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTemplateId(Identifier templateId) {
        this.templateId.setValue(templateId);
    }


    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedDataR2 getText() {
        return this.text.getValue();
    }

    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setText(EncapsulatedDataR2 text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public CodedTypeR2<Code> getConfidentialityCode() {
        return (CodedTypeR2<Code>) this.confidentialityCode.getValue();
    }

    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setConfidentialityCode(CodedTypeR2<Code> confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public CodedTypeR2<Code> getLanguageCode() {
        return (CodedTypeR2<Code>) this.languageCode.getValue();
    }

    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLanguageCode(CodedTypeR2<Code> languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public SubjectBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"author"})
    public List<Author_1Bean> getAuthor() {
        return this.author;
    }


    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: MedicalGeneralHistorySection.Section.entry</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"entry"})
    public List<EntryBean> getEntry() {
        return this.entry;
    }


    /**
     * <p>Relationship: 
     * MedicalGeneralHistorySection.Section.component</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"component"})
    public List<Component4Bean> getComponent() {
        return this.component;
    }

}
