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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVLTSCDAR1;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.List;



@Hl7PartTypeMapping({"BaseModel.Participant2","ProcedureNote.Participant1"})
public class Participant2_2Bean extends MessagePartBean implements ca.infoway.messagebuilder.model.ccda_pcs_r1_1.advancedirectiveobservation.Participant2Choice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.encounteractivities.Participant2Choice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.allergyintoleranceobservation.Participant2Choice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.medicationactivity.Participant2Choice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.procedureactivityprocedure.Participant2Choice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.procedurenote.Participant1Choice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.nonmedicinalsupplyactivity.Participant2Choice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.policyactivity.Participant2Choice {

    private static final long serialVersionUID = 20150328L;
    private CS typeCode = new CSImpl();
    private LIST<CS, Code> realmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private IVLTSCDAR1 time = new IVLTSCDAR1Impl();
    private CE awarenessCode = new CEImpl();
    private ParticipantRoleBean participantRole;
    private AssociatedEntityBean associatedEntity;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return (ParticipationType) this.typeCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: ProcedureNote.Participant1.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<Code> getRealmCode() {
        return this.realmCode.rawList(Code.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: ProcedureNote.Participant1.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: ProcedureNote.Participant1.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: ProcedureNote.Participant1.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: ProcedureNote.Participant1.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"time"})
    public DateInterval getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: ProcedureNote.Participant1.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTime(DateInterval time) {
        this.time.setValue(time);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.awarenessCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"awarenessCode"})
    public Code getAwarenessCode() {
        return (Code) this.awarenessCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.awarenessCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAwarenessCode(Code awarenessCode) {
        this.awarenessCode.setValue(awarenessCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.participantRole</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"participantRole"})
    public ParticipantRoleBean getParticipantRole() {
        return this.participantRole;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Participant2.participantRole</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setParticipantRole(ParticipantRoleBean participantRole) {
        this.participantRole = participantRole;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: ProcedureNote.Participant1.associatedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"associatedEntity"})
    public AssociatedEntityBean getAssociatedEntity() {
        return this.associatedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: ProcedureNote.Participant1.associatedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAssociatedEntity(AssociatedEntityBean associatedEntity) {
        this.associatedEntity = associatedEntity;
    }

}
