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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.progressnote;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipHasComponent;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.EncounterParticipantBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.ResponsiblePartyBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"ProgressNote.Component1"})
public class Component1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20140915L;
    private CS_R2 typeCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CS_R2 encompassingEncounterClassCode = new CS_R2Impl();
    private CS_R2 encompassingEncounterMoodCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> encompassingEncounterRealmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II encompassingEncounterTypeId = new IIImpl();
    private LIST<II, Identifier> encompassingEncounterTemplateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> encompassingEncounterId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE_R2 encompassingEncounterCode = new CE_R2Impl();
    private IVL<TS, Interval<Date>> encompassingEncounterEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CE_R2 encompassingEncounterDischargeDispositionCode = new CE_R2Impl();
    private ResponsiblePartyBean encompassingEncounterResponsibleParty;
    private List<EncounterParticipantBean> encompassingEncounterEncounterParticipant = new ArrayList<EncounterParticipantBean>();
    private LocationBean encompassingEncounterLocation;


    /**
     * <p>Relationship: ProgressNote.Component1.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public CodedTypeR2<ActRelationshipHasComponent> getTypeCode() {
        return (CodedTypeR2<ActRelationshipHasComponent>) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: ProgressNote.Component1.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeCode(CodedTypeR2<ActRelationshipHasComponent> typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: ProgressNote.Component1.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: ProgressNote.Component1.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: ProgressNote.Component1.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: ProgressNote.Component1.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/classCode"})
    public CodedTypeR2<ActClass> getEncompassingEncounterClassCode() {
        return (CodedTypeR2<ActClass>) this.encompassingEncounterClassCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterClassCode(CodedTypeR2<ActClass> encompassingEncounterClassCode) {
        this.encompassingEncounterClassCode.setValue(encompassingEncounterClassCode);
    }


    /**
     * <p>Relationship: ProgressNote.EncompassingEncounter.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/moodCode"})
    public CodedTypeR2<ActMood> getEncompassingEncounterMoodCode() {
        return (CodedTypeR2<ActMood>) this.encompassingEncounterMoodCode.getValue();
    }

    /**
     * <p>Relationship: ProgressNote.EncompassingEncounter.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterMoodCode(CodedTypeR2<ActMood> encompassingEncounterMoodCode) {
        this.encompassingEncounterMoodCode.setValue(encompassingEncounterMoodCode);
    }


    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/realmCode"})
    public List<CodedTypeR2<Code>> getEncompassingEncounterRealmCode() {
        return this.encompassingEncounterRealmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: ProgressNote.EncompassingEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/typeId"})
    public Identifier getEncompassingEncounterTypeId() {
        return this.encompassingEncounterTypeId.getValue();
    }

    /**
     * <p>Relationship: ProgressNote.EncompassingEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterTypeId(Identifier encompassingEncounterTypeId) {
        this.encompassingEncounterTypeId.setValue(encompassingEncounterTypeId);
    }


    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/templateId"})
    public List<Identifier> getEncompassingEncounterTemplateId() {
        return this.encompassingEncounterTemplateId.rawList();
    }


    /**
     * <p>Relationship: ProgressNote.EncompassingEncounter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/id"})
    public List<Identifier> getEncompassingEncounterId() {
        return this.encompassingEncounterId.rawList();
    }


    /**
     * <p>Relationship: ProgressNote.EncompassingEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/code"})
    public CodedTypeR2<Code> getEncompassingEncounterCode() {
        return (CodedTypeR2<Code>) this.encompassingEncounterCode.getValue();
    }

    /**
     * <p>Relationship: ProgressNote.EncompassingEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterCode(CodedTypeR2<Code> encompassingEncounterCode) {
        this.encompassingEncounterCode.setValue(encompassingEncounterCode);
    }


    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/effectiveTime"})
    public Interval<Date> getEncompassingEncounterEffectiveTime() {
        return this.encompassingEncounterEffectiveTime.getValue();
    }

    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setEncompassingEncounterEffectiveTime(Interval<Date> encompassingEncounterEffectiveTime) {
        this.encompassingEncounterEffectiveTime.setValue(encompassingEncounterEffectiveTime);
    }


    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/dischargeDispositionCode"})
    public CodedTypeR2<Code> getEncompassingEncounterDischargeDispositionCode() {
        return (CodedTypeR2<Code>) this.encompassingEncounterDischargeDispositionCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterDischargeDispositionCode(CodedTypeR2<Code> encompassingEncounterDischargeDispositionCode) {
        this.encompassingEncounterDischargeDispositionCode.setValue(encompassingEncounterDischargeDispositionCode);
    }


    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/responsibleParty"})
    public ResponsiblePartyBean getEncompassingEncounterResponsibleParty() {
        return this.encompassingEncounterResponsibleParty;
    }

    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterResponsibleParty(ResponsiblePartyBean encompassingEncounterResponsibleParty) {
        this.encompassingEncounterResponsibleParty = encompassingEncounterResponsibleParty;
    }


    /**
     * <p>Relationship: 
     * ProgressNote.EncompassingEncounter.encounterParticipant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/encounterParticipant"})
    public List<EncounterParticipantBean> getEncompassingEncounterEncounterParticipant() {
        return this.encompassingEncounterEncounterParticipant;
    }


    /**
     * <p>Relationship: ProgressNote.EncompassingEncounter.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/location"})
    public LocationBean getEncompassingEncounterLocation() {
        return this.encompassingEncounterLocation;
    }

    /**
     * <p>Relationship: ProgressNote.EncompassingEncounter.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setEncompassingEncounterLocation(LocationBean encompassingEncounterLocation) {
        this.encompassingEncounterLocation = encompassingEncounterLocation;
    }

}
