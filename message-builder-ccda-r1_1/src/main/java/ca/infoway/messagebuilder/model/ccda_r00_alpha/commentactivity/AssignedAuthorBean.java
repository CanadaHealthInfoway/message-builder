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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.commentactivity;

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
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.AuthoringDeviceBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Organization_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.AssignedAuthorChoice;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.PersonBean;
import java.util.List;



@Hl7PartTypeMapping({"CommentActivity.AssignedAuthor"})
public class AssignedAuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20150206L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private II id = new IIImpl();
    private CE_R2 code = new CE_R2Impl();
    private AD addr = new ADImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private AssignedAuthorChoice assignedAuthorChoice;
    private Organization_1Bean representedOrganization;


    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Relationship: CommentActivity.AssignedAuthor.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Relationship: 
     * CommentActivity.AssignedAuthor.assignedAuthorChoice</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"assignedAuthorChoice"})
    public AssignedAuthorChoice getAssignedAuthorChoice() {
        return this.assignedAuthorChoice;
    }

    /**
     * <p>Relationship: 
     * CommentActivity.AssignedAuthor.assignedAuthorChoice</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAssignedAuthorChoice(AssignedAuthorChoice assignedAuthorChoice) {
        this.assignedAuthorChoice = assignedAuthorChoice;
    }

    public PersonBean getAssignedAuthorChoiceAsAssignedPerson() {
        return this.assignedAuthorChoice instanceof PersonBean ? (PersonBean) this.assignedAuthorChoice : null;
    }
    public boolean hasAssignedAuthorChoiceAsAssignedPerson() {
        return (this.assignedAuthorChoice instanceof PersonBean);
    }

    public AuthoringDeviceBean getAssignedAuthorChoiceAsAssignedAuthoringDevice() {
        return this.assignedAuthorChoice instanceof AuthoringDeviceBean ? (AuthoringDeviceBean) this.assignedAuthorChoice : null;
    }
    public boolean hasAssignedAuthorChoiceAsAssignedAuthoringDevice() {
        return (this.assignedAuthorChoice instanceof AuthoringDeviceBean);
    }


    /**
     * <p>Relationship: 
     * CommentActivity.AssignedAuthor.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"representedOrganization"})
    public Organization_1Bean getRepresentedOrganization() {
        return this.representedOrganization;
    }

    /**
     * <p>Relationship: 
     * CommentActivity.AssignedAuthor.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRepresentedOrganization(Organization_1Bean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

}
