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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.procedureactivityobservation;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD_R2;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.x_DocumentEncounterMood;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.EntryRelationship_3Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Participant1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Performer2_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.ReferenceBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.SpecimenBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.PreconditionBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.SubjectBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"ProcedureActivityObservation.ComponentEncounter"})
public class ComponentEncounterBean extends MessagePartBean {

    private static final long serialVersionUID = 20140915L;
    private CS_R2 classCode = new CS_R2Impl();
    private CS_R2 moodCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private II id = new IIImpl();
    private CD_R2 code = new CD_R2Impl();
    private ED<EncapsulatedDataR2> text = new EDImpl<EncapsulatedDataR2>();
    private CS_R2 statusCode = new CS_R2Impl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CE_R2 priorityCode = new CE_R2Impl();
    private SubjectBean subject;
    private List<SpecimenBean> specimen = new ArrayList<SpecimenBean>();
    private List<Performer2_1Bean> performer = new ArrayList<Performer2_1Bean>();
    private List<Author_1Bean> author = new ArrayList<Author_1Bean>();
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private List<Participant1Bean> participant = new ArrayList<Participant1Bean>();
    private List<EntryRelationship_3Bean> entryRelationship = new ArrayList<EntryRelationship_3Bean>();
    private List<ReferenceBean> reference = new ArrayList<ReferenceBean>();
    private List<PreconditionBean> precondition = new ArrayList<PreconditionBean>();


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.classCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public CodedTypeR2<ActClass> getClassCode() {
        return (CodedTypeR2<ActClass>) this.classCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.classCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setClassCode(CodedTypeR2<ActClass> classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.moodCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public CodedTypeR2<x_DocumentEncounterMood> getMoodCode() {
        return (CodedTypeR2<x_DocumentEncounterMood>) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.moodCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setMoodCode(CodedTypeR2<x_DocumentEncounterMood> moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedDataR2 getText() {
        return this.text.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setText(EncapsulatedDataR2 text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public CodedTypeR2<Code> getStatusCode() {
        return (CodedTypeR2<Code>) this.statusCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setStatusCode(CodedTypeR2<Code> statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public CodedTypeR2<Code> getPriorityCode() {
        return (CodedTypeR2<Code>) this.priorityCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPriorityCode(CodedTypeR2<Code> priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public SubjectBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.specimen</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<SpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.performer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"performer"})
    public List<Performer2_1Bean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"author"})
    public List<Author_1Bean> getAuthor() {
        return this.author;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant1Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"entryRelationship"})
    public List<EntryRelationship_3Bean> getEntryRelationship() {
        return this.entryRelationship;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.reference</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<ReferenceBean> getReference() {
        return this.reference;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.ComponentEncounter.precondition</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"precondition"})
    public List<PreconditionBean> getPrecondition() {
        return this.precondition;
    }

}
