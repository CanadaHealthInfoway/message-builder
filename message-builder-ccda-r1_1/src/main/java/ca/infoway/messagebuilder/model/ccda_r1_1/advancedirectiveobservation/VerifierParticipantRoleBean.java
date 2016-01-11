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
package ca.infoway.messagebuilder.model.ccda_r1_1.advancedirectiveobservation;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.RoleClassRoot;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.basemodel.ParticipantRoleChoice;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.DeviceBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.EntityBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.PlayingEntity_2Bean;
import java.util.List;



@Hl7PartTypeMapping({"AdvanceDirectiveObservation.VerifierParticipantRole"})
public class VerifierParticipantRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20160107L;
    private CS_R2<RoleClassRoot> classCode = new CS_R2Impl<RoleClassRoot>();
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE_R2<Code> code = new CE_R2Impl<Code>();
    private LIST<AD, PostalAddress> addr = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ParticipantRoleChoice participantRoleChoice;
    private EntityBean scopingEntity;


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public CodedTypeR2<RoleClassRoot> getClassCode() {
        return (CodedTypeR2<RoleClassRoot>) this.classCode.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setClassCode(CodedTypeR2<RoleClassRoot> classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getAddr() {
        return this.addr.rawList();
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.participantRoleChoice</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"participantRoleChoice"})
    public ParticipantRoleChoice getParticipantRoleChoice() {
        return this.participantRoleChoice;
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.participantRoleChoice</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setParticipantRoleChoice(ParticipantRoleChoice participantRoleChoice) {
        this.participantRoleChoice = participantRoleChoice;
    }

    public DeviceBean getParticipantRoleChoiceAsPlayingDevice() {
        return this.participantRoleChoice instanceof DeviceBean ? (DeviceBean) this.participantRoleChoice : null;
    }
    public boolean hasParticipantRoleChoiceAsPlayingDevice() {
        return (this.participantRoleChoice instanceof DeviceBean);
    }

    public PlayingEntity_2Bean getParticipantRoleChoiceAsPlayingEntity() {
        return this.participantRoleChoice instanceof PlayingEntity_2Bean ? (PlayingEntity_2Bean) this.participantRoleChoice : null;
    }
    public boolean hasParticipantRoleChoiceAsPlayingEntity() {
        return (this.participantRoleChoice instanceof PlayingEntity_2Bean);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"scopingEntity"})
    public EntityBean getScopingEntity() {
        return this.scopingEntity;
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.VerifierParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setScopingEntity(EntityBean scopingEntity) {
        this.scopingEntity = scopingEntity;
    }

}
