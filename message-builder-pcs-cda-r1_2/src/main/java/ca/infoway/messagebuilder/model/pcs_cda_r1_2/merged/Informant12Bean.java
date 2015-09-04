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
package ca.infoway.messagebuilder.model.pcs_cda_r1_2.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVLTSCDAR1;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.basemodel.Informant12Choice;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.domainvalue.RoleClassMutualRelationship;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.pccdaheader.Informant12OrganizationBean;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.pccdaheader.Informant12PersonBean;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.pccdaheader.RelatedEntityPersonBean;
import java.util.List;



@Hl7PartTypeMapping({"BaseModel.Informant12","PcCDAHeader.Informant12"})
public class Informant12Bean extends MessagePartBean {

    private static final long serialVersionUID = 20150328L;
    private LIST<CS, Code> realmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private Informant12Choice informant12Choice;
    private LIST<CS, Code> assignedEntityRealmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II assignedEntityTypeId = new IIImpl();
    private LIST<II, Identifier> assignedEntityTemplateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> assignedEntityId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE assignedEntityCode = new CEImpl();
    private LIST<AD, PostalAddress> assignedEntityAddr = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> assignedEntityTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private Informant12PersonBean assignedEntityAssignedPerson;
    private Informant12OrganizationBean assignedEntityRepresentedOrganization;
    private CS relatedEntityClassCode = new CSImpl();
    private LIST<CS, Code> relatedEntityRealmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II relatedEntityTypeId = new IIImpl();
    private LIST<II, Identifier> relatedEntityTemplateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CV relatedEntityCode = new CVImpl();
    private LIST<AD, PostalAddress> relatedEntityAddr = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> relatedEntityTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private IVLTSCDAR1 relatedEntityEffectiveTime = new IVLTSCDAR1Impl();
    private RelatedEntityPersonBean relatedEntityRelatedPerson;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Informant12.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.Informant12.realmCode</p>
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
     * <p>Relationship: BaseModel.Informant12.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.Informant12.typeId</p>
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
     * <p>Relationship: BaseModel.Informant12.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.Informant12.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Informant12.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.Informant12.templateId</p>
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
     * <p>Relationship: BaseModel.Informant12.informant12Choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"informant12Choice"})
    public Informant12Choice getInformant12Choice() {
        return this.informant12Choice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: BaseModel.Informant12.informant12Choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInformant12Choice(Informant12Choice informant12Choice) {
        this.informant12Choice = informant12Choice;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PcCDAHeader.Informant12AssignedEntity.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"assignedEntity/realmCode"})
    public List<Code> getAssignedEntityRealmCode() {
        return this.assignedEntityRealmCode.rawList(Code.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PcCDAHeader.Informant12AssignedEntity.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"assignedEntity/typeId"})
    public Identifier getAssignedEntityTypeId() {
        return this.assignedEntityTypeId.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PcCDAHeader.Informant12AssignedEntity.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAssignedEntityTypeId(Identifier assignedEntityTypeId) {
        this.assignedEntityTypeId.setValue(assignedEntityTypeId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PcCDAHeader.Informant12AssignedEntity.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"assignedEntity/templateId"})
    public List<Identifier> getAssignedEntityTemplateId() {
        return this.assignedEntityTemplateId.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.Informant12AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"assignedEntity/id"})
    public List<Identifier> getAssignedEntityId() {
        return this.assignedEntityId.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.Informant12AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"assignedEntity/code"})
    public HealthcareProviderRoleType getAssignedEntityCode() {
        return (HealthcareProviderRoleType) this.assignedEntityCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.Informant12AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAssignedEntityCode(HealthcareProviderRoleType assignedEntityCode) {
        this.assignedEntityCode.setValue(assignedEntityCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.Informant12AssignedEntity.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"assignedEntity/addr"})
    public List<PostalAddress> getAssignedEntityAddr() {
        return this.assignedEntityAddr.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PcCDAHeader.Informant12AssignedEntity.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"assignedEntity/telecom"})
    public List<TelecommunicationAddress> getAssignedEntityTelecom() {
        return this.assignedEntityTelecom.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PcCDAHeader.Informant12AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"assignedEntity/assignedPerson"})
    public Informant12PersonBean getAssignedEntityAssignedPerson() {
        return this.assignedEntityAssignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PcCDAHeader.Informant12AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAssignedEntityAssignedPerson(Informant12PersonBean assignedEntityAssignedPerson) {
        this.assignedEntityAssignedPerson = assignedEntityAssignedPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PcCDAHeader.Informant12AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"assignedEntity/representedOrganization"})
    public Informant12OrganizationBean getAssignedEntityRepresentedOrganization() {
        return this.assignedEntityRepresentedOrganization;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PcCDAHeader.Informant12AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAssignedEntityRepresentedOrganization(Informant12OrganizationBean assignedEntityRepresentedOrganization) {
        this.assignedEntityRepresentedOrganization = assignedEntityRepresentedOrganization;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"relatedEntity/classCode"})
    public RoleClassMutualRelationship getRelatedEntityClassCode() {
        return (RoleClassMutualRelationship) this.relatedEntityClassCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRelatedEntityClassCode(RoleClassMutualRelationship relatedEntityClassCode) {
        this.relatedEntityClassCode.setValue(relatedEntityClassCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"relatedEntity/realmCode"})
    public List<Code> getRelatedEntityRealmCode() {
        return this.relatedEntityRealmCode.rawList(Code.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"relatedEntity/typeId"})
    public Identifier getRelatedEntityTypeId() {
        return this.relatedEntityTypeId.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRelatedEntityTypeId(Identifier relatedEntityTypeId) {
        this.relatedEntityTypeId.setValue(relatedEntityTypeId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"relatedEntity/templateId"})
    public List<Identifier> getRelatedEntityTemplateId() {
        return this.relatedEntityTemplateId.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"relatedEntity/code"})
    public PersonalRelationshipRoleType getRelatedEntityCode() {
        return (PersonalRelationshipRoleType) this.relatedEntityCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRelatedEntityCode(PersonalRelationshipRoleType relatedEntityCode) {
        this.relatedEntityCode.setValue(relatedEntityCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"relatedEntity/addr"})
    public List<PostalAddress> getRelatedEntityAddr() {
        return this.relatedEntityAddr.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"relatedEntity/telecom"})
    public List<TelecommunicationAddress> getRelatedEntityTelecom() {
        return this.relatedEntityTelecom.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"relatedEntity/effectiveTime"})
    public DateInterval getRelatedEntityEffectiveTime() {
        return this.relatedEntityEffectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRelatedEntityEffectiveTime(DateInterval relatedEntityEffectiveTime) {
        this.relatedEntityEffectiveTime.setValue(relatedEntityEffectiveTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.relatedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"relatedEntity/relatedPerson"})
    public RelatedEntityPersonBean getRelatedEntityRelatedPerson() {
        return this.relatedEntityRelatedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PcCDAHeader.RelatedEntity.relatedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setRelatedEntityRelatedPerson(RelatedEntityPersonBean relatedEntityRelatedPerson) {
        this.relatedEntityRelatedPerson = relatedEntityRelatedPerson;
    }

}