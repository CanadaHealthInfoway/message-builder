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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.diagnosticimagingreport;

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
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.LocationBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.ResponsiblePartyBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.physicianofrecordparticipant.EncounterParticipantBean;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"DiagnosticImagingReport.Component1"})
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
    private EncounterParticipantBean encompassingEncounterEncounterParticipant;
    private LocationBean encompassingEncounterLocation;


    /**
     * <p>Relationship: DiagnosticImagingReport.Component1.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public CodedTypeR2<ActRelationshipHasComponent> getTypeCode() {
        return (CodedTypeR2<ActRelationshipHasComponent>) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: DiagnosticImagingReport.Component1.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeCode(CodedTypeR2<ActRelationshipHasComponent> typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.Component1.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: DiagnosticImagingReport.Component1.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: DiagnosticImagingReport.Component1.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.Component1.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/classCode"})
    public CodedTypeR2<ActClass> getEncompassingEncounterClassCode() {
        return (CodedTypeR2<ActClass>) this.encompassingEncounterClassCode.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterClassCode(CodedTypeR2<ActClass> encompassingEncounterClassCode) {
        this.encompassingEncounterClassCode.setValue(encompassingEncounterClassCode);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/moodCode"})
    public CodedTypeR2<ActMood> getEncompassingEncounterMoodCode() {
        return (CodedTypeR2<ActMood>) this.encompassingEncounterMoodCode.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterMoodCode(CodedTypeR2<ActMood> encompassingEncounterMoodCode) {
        this.encompassingEncounterMoodCode.setValue(encompassingEncounterMoodCode);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/realmCode"})
    public List<CodedTypeR2<Code>> getEncompassingEncounterRealmCode() {
        return this.encompassingEncounterRealmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/typeId"})
    public Identifier getEncompassingEncounterTypeId() {
        return this.encompassingEncounterTypeId.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterTypeId(Identifier encompassingEncounterTypeId) {
        this.encompassingEncounterTypeId.setValue(encompassingEncounterTypeId);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/templateId"})
    public List<Identifier> getEncompassingEncounterTemplateId() {
        return this.encompassingEncounterTemplateId.rawList();
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/id"})
    public List<Identifier> getEncompassingEncounterId() {
        return this.encompassingEncounterId.rawList();
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/code"})
    public CodedTypeR2<Code> getEncompassingEncounterCode() {
        return (CodedTypeR2<Code>) this.encompassingEncounterCode.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterCode(CodedTypeR2<Code> encompassingEncounterCode) {
        this.encompassingEncounterCode.setValue(encompassingEncounterCode);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/effectiveTime"})
    public Interval<Date> getEncompassingEncounterEffectiveTime() {
        return this.encompassingEncounterEffectiveTime.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setEncompassingEncounterEffectiveTime(Interval<Date> encompassingEncounterEffectiveTime) {
        this.encompassingEncounterEffectiveTime.setValue(encompassingEncounterEffectiveTime);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/dischargeDispositionCode"})
    public CodedTypeR2<Code> getEncompassingEncounterDischargeDispositionCode() {
        return (CodedTypeR2<Code>) this.encompassingEncounterDischargeDispositionCode.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterDischargeDispositionCode(CodedTypeR2<Code> encompassingEncounterDischargeDispositionCode) {
        this.encompassingEncounterDischargeDispositionCode.setValue(encompassingEncounterDischargeDispositionCode);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/responsibleParty"})
    public ResponsiblePartyBean getEncompassingEncounterResponsibleParty() {
        return this.encompassingEncounterResponsibleParty;
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterResponsibleParty(ResponsiblePartyBean encompassingEncounterResponsibleParty) {
        this.encompassingEncounterResponsibleParty = encompassingEncounterResponsibleParty;
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.encounterParticipant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/encounterParticipant"})
    public EncounterParticipantBean getEncompassingEncounterEncounterParticipant() {
        return this.encompassingEncounterEncounterParticipant;
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.encounterParticipant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterEncounterParticipant(EncounterParticipantBean encompassingEncounterEncounterParticipant) {
        this.encompassingEncounterEncounterParticipant = encompassingEncounterEncounterParticipant;
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.location</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encompassingEncounter/location"})
    public LocationBean getEncompassingEncounterLocation() {
        return this.encompassingEncounterLocation;
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.location</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncompassingEncounterLocation(LocationBean encompassingEncounterLocation) {
        this.encompassingEncounterLocation = encompassingEncounterLocation;
    }

}
