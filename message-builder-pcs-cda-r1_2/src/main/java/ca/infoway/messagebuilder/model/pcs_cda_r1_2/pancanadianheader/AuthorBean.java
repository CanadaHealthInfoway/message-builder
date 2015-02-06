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
package ca.infoway.messagebuilder.model.pcs_cda_r1_2.pancanadianheader;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ParticipationFunction;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PanCanadianHeader.Author"})
public class AuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20141210L;
    private LIST<CS, Code> realmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE functionCode = new CEImpl();
    private TS time = new TSImpl();
    private AssignedAuthorBean assignedAuthor;


    /**
     * <p>Relationship: PanCanadianHeader.Author.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<Code> getRealmCode() {
        return this.realmCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: PanCanadianHeader.Author.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: PanCanadianHeader.Author.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: PanCanadianHeader.Author.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: PanCanadianHeader.Author.functionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"functionCode"})
    public ParticipationFunction getFunctionCode() {
        return (ParticipationFunction) this.functionCode.getValue();
    }

    /**
     * <p>Relationship: PanCanadianHeader.Author.functionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setFunctionCode(ParticipationFunction functionCode) {
        this.functionCode.setValue(functionCode);
    }


    /**
     * <p>Relationship: PanCanadianHeader.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Relationship: PanCanadianHeader.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Relationship: PanCanadianHeader.Author.assignedAuthor</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"assignedAuthor"})
    public AssignedAuthorBean getAssignedAuthor() {
        return this.assignedAuthor;
    }

    /**
     * <p>Relationship: PanCanadianHeader.Author.assignedAuthor</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAssignedAuthor(AssignedAuthorBean assignedAuthor) {
        this.assignedAuthor = assignedAuthor;
    }

}