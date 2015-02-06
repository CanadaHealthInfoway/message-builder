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
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVLTSCDAR1;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.domainvalue.x_DocumentProcedureMood;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Performer2_1Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.SpecimenBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POCD_MT000040.Procedure"})
public class ProcedureBean extends MessagePartBean implements EntryChoice, EntryRelationshipChoice, Component4Choice {

    private static final long serialVersionUID = 20150206L;
    private CS classCode = new CSImpl();
    private CS moodCode = new CSImpl();
    private BL negationInd = new BLImpl();
    private LIST<CS, Code> realmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CD code = new CDImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private CS statusCode = new CSImpl();
    private IVLTSCDAR1 effectiveTime = new IVLTSCDAR1Impl();
    private CE priorityCode = new CEImpl();
    private CS languageCode = new CSImpl();
    private LIST<CE, Code> methodCode = new LISTImpl<CE, Code>(CEImpl.class);
    private LIST<CD, Code> approachSiteCode = new LISTImpl<CD, Code>(CDImpl.class);
    private LIST<CD, Code> targetSiteCode = new LISTImpl<CD, Code>(CDImpl.class);
    private SubjectBean subject;
    private List<SpecimenBean> specimen = new ArrayList<SpecimenBean>();
    private List<Performer2_1Bean> performer = new ArrayList<Performer2_1Bean>();
    private List<Author_1Bean> author = new ArrayList<Author_1Bean>();
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private List<Participant2Bean> participant = new ArrayList<Participant2Bean>();
    private List<EntryRelationshipBean> entryRelationship = new ArrayList<EntryRelationshipBean>();
    private List<ReferenceBean> reference = new ArrayList<ReferenceBean>();
    private List<PreconditionBean> precondition = new ArrayList<PreconditionBean>();


    /**
     * <p>Relationship: POCD_MT000040.Procedure.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public ActClass getClassCode() {
        return (ActClass) this.classCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setClassCode(ActClass classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_DocumentProcedureMood getMoodCode() {
        return (x_DocumentProcedureMood) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setMoodCode(x_DocumentProcedureMood moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<Code> getRealmCode() {
        return this.realmCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public Code getStatusCode() {
        return (Code) this.statusCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setStatusCode(Code statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public DateInterval getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEffectiveTime(DateInterval effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public Code getPriorityCode() {
        return (Code) this.priorityCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPriorityCode(Code priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public Code getLanguageCode() {
        return (Code) this.languageCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLanguageCode(Code languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.methodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"methodCode"})
    public List<Code> getMethodCode() {
        return this.methodCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.approachSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public List<Code> getApproachSiteCode() {
        return this.approachSiteCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.targetSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"targetSiteCode"})
    public List<Code> getTargetSiteCode() {
        return this.targetSiteCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public SubjectBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: POCD_MT000040.Procedure.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.specimen</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<SpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.performer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"performer"})
    public List<Performer2_1Bean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"author"})
    public List<Author_1Bean> getAuthor() {
        return this.author;
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant2Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"entryRelationship"})
    public List<EntryRelationshipBean> getEntryRelationship() {
        return this.entryRelationship;
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.reference</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<ReferenceBean> getReference() {
        return this.reference;
    }


    /**
     * <p>Relationship: POCD_MT000040.Procedure.precondition</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"precondition"})
    public List<PreconditionBean> getPrecondition() {
        return this.precondition;
    }

}