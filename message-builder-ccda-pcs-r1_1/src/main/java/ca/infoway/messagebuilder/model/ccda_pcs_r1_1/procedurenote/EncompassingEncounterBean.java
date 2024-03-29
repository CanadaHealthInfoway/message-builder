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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.procedurenote;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVLTSCDAR1;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.ResponsiblePartyBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"ProcedureNote.EncompassingEncounter"})
public class EncompassingEncounterBean extends MessagePartBean {

    private static final long serialVersionUID = 20160107L;
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE code = new CEImpl();
    private IVLTSCDAR1 effectiveTime = new IVLTSCDAR1Impl();
    private CE dischargeDispositionCode = new CEImpl();
    private ResponsiblePartyBean responsibleParty;
    private List<EncounterParticipantChoice> encounterParticipant = new ArrayList<EncounterParticipantChoice>();
    private List<LocationBean> location = new ArrayList<LocationBean>();


    /**
     * <p>Relationship: ProcedureNote.EncompassingEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: ProcedureNote.EncompassingEncounter.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * ProcedureNote.EncompassingEncounter.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: ProcedureNote.EncompassingEncounter.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: ProcedureNote.EncompassingEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }

    /**
     * <p>Relationship: ProcedureNote.EncompassingEncounter.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * ProcedureNote.EncompassingEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public DateInterval getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureNote.EncompassingEncounter.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setEffectiveTime(DateInterval effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * ProcedureNote.EncompassingEncounter.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"dischargeDispositionCode"})
    public Code getDischargeDispositionCode() {
        return (Code) this.dischargeDispositionCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureNote.EncompassingEncounter.dischargeDispositionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDischargeDispositionCode(Code dischargeDispositionCode) {
        this.dischargeDispositionCode.setValue(dischargeDispositionCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureNote.EncompassingEncounter.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"responsibleParty"})
    public ResponsiblePartyBean getResponsibleParty() {
        return this.responsibleParty;
    }

    /**
     * <p>Relationship: 
     * ProcedureNote.EncompassingEncounter.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setResponsibleParty(ResponsiblePartyBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }


    /**
     * <p>Relationship: 
     * ProcedureNote.EncompassingEncounter.encounterParticipant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"encounterParticipant"})
    public List<EncounterParticipantChoice> getEncounterParticipant() {
        return this.encounterParticipant;
    }


    /**
     * <p>Relationship: 
     * ProcedureNote.EncompassingEncounter.location</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"location"})
    public List<LocationBean> getLocation() {
        return this.location;
    }

}
