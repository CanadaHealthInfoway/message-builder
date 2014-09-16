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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.ParticipationTargetSubject;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.List;



@Hl7PartTypeMapping({"POCD_MT000040.Subject"})
public class SubjectBean extends MessagePartBean {

    private static final long serialVersionUID = 20140915L;
    private CS_R2 typeCode = new CS_R2Impl();
    private CS_R2 contextControlCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE_R2 awarenessCode = new CE_R2Impl();
    private RelatedSubjectBean relatedSubject;


    /**
     * <p>Relationship: POCD_MT000040.Subject.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public CodedTypeR2<ParticipationTargetSubject> getTypeCode() {
        return (CodedTypeR2<ParticipationTargetSubject>) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Subject.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeCode(CodedTypeR2<ParticipationTargetSubject> typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Subject.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"contextControlCode"})
    public CodedTypeR2<ContextControl> getContextControlCode() {
        return (CodedTypeR2<ContextControl>) this.contextControlCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Subject.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setContextControlCode(CodedTypeR2<ContextControl> contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Subject.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: POCD_MT000040.Subject.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Subject.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: POCD_MT000040.Subject.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: POCD_MT000040.Subject.awarenessCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"awarenessCode"})
    public CodedTypeR2<Code> getAwarenessCode() {
        return (CodedTypeR2<Code>) this.awarenessCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Subject.awarenessCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAwarenessCode(CodedTypeR2<Code> awarenessCode) {
        this.awarenessCode.setValue(awarenessCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Subject.relatedSubject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"relatedSubject"})
    public RelatedSubjectBean getRelatedSubject() {
        return this.relatedSubject;
    }

    /**
     * <p>Relationship: POCD_MT000040.Subject.relatedSubject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRelatedSubject(RelatedSubjectBean relatedSubject) {
        this.relatedSubject = relatedSubject;
    }

}
