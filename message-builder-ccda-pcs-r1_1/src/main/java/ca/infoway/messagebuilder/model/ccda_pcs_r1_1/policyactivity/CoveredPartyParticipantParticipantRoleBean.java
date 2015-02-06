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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.policyactivity;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TSCDAR1;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.EntityClassRoot;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.domainvalue.CoverageRoleType;
import java.util.List;



@Hl7PartTypeMapping({"PolicyActivity.CoveredPartyParticipantParticipantRole"})
public class CoveredPartyParticipantParticipantRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20150206L;
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE code = new CEImpl();
    private AD addr = new ADImpl();
    private CS playingEntityClassCode = new CSImpl();
    private LIST<CS, Code> playingEntityRealmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II playingEntityTypeId = new IIImpl();
    private LIST<II, Identifier> playingEntityTemplateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE playingEntityCode = new CEImpl();
    private LIST<PQ, PhysicalQuantity> playingEntityQuantity = new LISTImpl<PQ, PhysicalQuantity>(PQImpl.class);
    private PN playingEntityName = new PNImpl();
    private TSCDAR1 playingEntityBirthTime = new TSCDAR1Impl();
    private ED<EncapsulatedData> playingEntityDesc = new EDImpl<EncapsulatedData>();


    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipantRole.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CoverageRoleType getCode() {
        return (CoverageRoleType) this.code.getValue();
    }

    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipantRole.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setCode(CoverageRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipantRole.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipantRole.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"playingEntity/classCode"})
    public EntityClassRoot getPlayingEntityClassCode() {
        return (EntityClassRoot) this.playingEntityClassCode.getValue();
    }

    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPlayingEntityClassCode(EntityClassRoot playingEntityClassCode) {
        this.playingEntityClassCode.setValue(playingEntityClassCode);
    }


    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"playingEntity/realmCode"})
    public List<Code> getPlayingEntityRealmCode() {
        return this.playingEntityRealmCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"playingEntity/typeId"})
    public Identifier getPlayingEntityTypeId() {
        return this.playingEntityTypeId.getValue();
    }

    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPlayingEntityTypeId(Identifier playingEntityTypeId) {
        this.playingEntityTypeId.setValue(playingEntityTypeId);
    }


    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"playingEntity/templateId"})
    public List<Identifier> getPlayingEntityTemplateId() {
        return this.playingEntityTemplateId.rawList();
    }


    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"playingEntity/code"})
    public Code getPlayingEntityCode() {
        return (Code) this.playingEntityCode.getValue();
    }

    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPlayingEntityCode(Code playingEntityCode) {
        this.playingEntityCode.setValue(playingEntityCode);
    }


    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.quantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"playingEntity/quantity"})
    public List<PhysicalQuantity> getPlayingEntityQuantity() {
        return this.playingEntityQuantity.rawList();
    }


    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"playingEntity/name"})
    public PersonName getPlayingEntityName() {
        return this.playingEntityName.getValue();
    }

    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPlayingEntityName(PersonName playingEntityName) {
        this.playingEntityName.setValue(playingEntityName);
    }


    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.birthTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"playingEntity/birthTime"})
    public MbDate getPlayingEntityBirthTime() {
        return this.playingEntityBirthTime.getValue();
    }

    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.birthTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPlayingEntityBirthTime(MbDate playingEntityBirthTime) {
        this.playingEntityBirthTime.setValue(playingEntityBirthTime);
    }


    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.desc</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"playingEntity/desc"})
    public EncapsulatedData getPlayingEntityDesc() {
        return this.playingEntityDesc.getValue();
    }

    /**
     * <p>Relationship: PolicyActivity.PlayingEntity.desc</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPlayingEntityDesc(EncapsulatedData playingEntityDesc) {
        this.playingEntityDesc.setValue(playingEntityDesc);
    }

}
