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
import ca.infoway.messagebuilder.datatype.IVL_TS;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVL_TSImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.LocationBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.ResponsiblePartyBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.physicianofrecordparticipant.EncounterParticipantBean;
import java.util.List;



@Hl7PartTypeMapping({"DiagnosticImagingReport.EncompassingEncounter"})
public class EncompassingEncounterBean extends MessagePartBean {

    private static final long serialVersionUID = 20150202L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE_R2 code = new CE_R2Impl();
    private IVL_TS effectiveTime = new IVL_TSImpl();
    private CE_R2 dischargeDispositionCode = new CE_R2Impl();
    private ResponsiblePartyBean responsibleParty;
    private EncounterParticipantBean encounterParticipant;
    private LocationBean location;


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public DateInterval getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setEffectiveTime(DateInterval effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"dischargeDispositionCode"})
    public CodedTypeR2<Code> getDischargeDispositionCode() {
        return (CodedTypeR2<Code>) this.dischargeDispositionCode.getValue();
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDischargeDispositionCode(CodedTypeR2<Code> dischargeDispositionCode) {
        this.dischargeDispositionCode.setValue(dischargeDispositionCode);
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"responsibleParty"})
    public ResponsiblePartyBean getResponsibleParty() {
        return this.responsibleParty;
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setResponsibleParty(ResponsiblePartyBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.encounterParticipant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"encounterParticipant"})
    public EncounterParticipantBean getEncounterParticipant() {
        return this.encounterParticipant;
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.encounterParticipant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEncounterParticipant(EncounterParticipantBean encounterParticipant) {
        this.encounterParticipant = encounterParticipant;
    }


    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.location</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"location"})
    public LocationBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: 
     * DiagnosticImagingReport.EncompassingEncounter.location</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLocation(LocationBean location) {
        this.location = location;
    }

}
