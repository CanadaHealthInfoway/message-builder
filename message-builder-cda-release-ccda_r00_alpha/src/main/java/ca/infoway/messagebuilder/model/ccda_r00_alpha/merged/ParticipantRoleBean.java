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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.merged;

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
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.ParticipantRoleChoice;
import java.util.List;



@Hl7PartTypeMapping({"AllergyIntoleranceObservation.ParticipantRole","CaregiverCharacteristics.ParticipantRole","POCD_MT000040.ParticipantRole","SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole"})
public class ParticipantRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20141104L;
    private CS_R2 classCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE_R2 code = new CE_R2Impl();
    private LIST<AD, PostalAddress> addr = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ParticipantRoleChoice participantRoleChoice;
    private EntityBean scopingEntity;
    private PlayingEntity_2Bean playingEntity;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public CodedTypeR2<RoleClassRoot> getClassCode() {
        return (CodedTypeR2<RoleClassRoot>) this.classCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setClassCode(CodedTypeR2<RoleClassRoot> classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.typeId</p>
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
     * <p>Relationship: POCD_MT000040.ParticipantRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.templateId</p>
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
     * <p>Relationship: POCD_MT000040.ParticipantRole.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: CaregiverCharacteristics.ParticipantRole.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getAddr() {
        return this.addr.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POCD_MT000040.ParticipantRole.participantRoleChoice</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.participantRoleChoice</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"participantRoleChoice"})
    public ParticipantRoleChoice getParticipantRoleChoice() {
        return this.participantRoleChoice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POCD_MT000040.ParticipantRole.participantRoleChoice</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.participantRoleChoice</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setParticipantRoleChoice(ParticipantRoleChoice participantRoleChoice) {
        this.participantRoleChoice = participantRoleChoice;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"scopingEntity"})
    public EntityBean getScopingEntity() {
        return this.scopingEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POCD_MT000040.ParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * CaregiverCharacteristics.ParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.scopingEntity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setScopingEntity(EntityBean scopingEntity) {
        this.scopingEntity = scopingEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.playingEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.playingEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"playingEntity"})
    public PlayingEntity_2Bean getPlayingEntity() {
        return this.playingEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * AllergyIntoleranceObservation.ParticipantRole.playingEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * SubstanceOrDeviceAllergyIntoleranceObservation.ParticipantRole.playingEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPlayingEntity(PlayingEntity_2Bean playingEntity) {
        this.playingEntity = playingEntity;
    }

}