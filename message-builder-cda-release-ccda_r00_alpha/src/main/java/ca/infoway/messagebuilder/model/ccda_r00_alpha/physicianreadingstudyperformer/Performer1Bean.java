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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.physicianreadingstudyperformer;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.x_ServiceEventPerformer;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.AssignedEntity_1Bean;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PhysicianReadingStudyPerformer.Performer1"})
@Hl7RootType
public class Performer1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20140915L;
    private CS_R2 typeCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private II templateId = new IIImpl();
    private CE_R2 functionCode = new CE_R2Impl();
    private IVL<TS, Interval<Date>> time = new IVLImpl<TS, Interval<Date>>();
    private AssignedEntity_1Bean assignedEntity;


    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.typeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public CodedTypeR2<x_ServiceEventPerformer> getTypeCode() {
        return (CodedTypeR2<x_ServiceEventPerformer>) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.typeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setTypeCode(CodedTypeR2<x_ServiceEventPerformer> typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public Identifier getTemplateId() {
        return this.templateId.getValue();
    }

    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTemplateId(Identifier templateId) {
        this.templateId.setValue(templateId);
    }


    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.functionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"functionCode"})
    public CodedTypeR2<Code> getFunctionCode() {
        return (CodedTypeR2<Code>) this.functionCode.getValue();
    }

    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.functionCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setFunctionCode(CodedTypeR2<Code> functionCode) {
        this.functionCode.setValue(functionCode);
    }


    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"time"})
    public Interval<Date> getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTime(Interval<Date> time) {
        this.time.setValue(time);
    }


    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"assignedEntity"})
    public AssignedEntity_1Bean getAssignedEntity() {
        return this.assignedEntity;
    }

    /**
     * <p>Relationship: 
     * PhysicianReadingStudyPerformer.Performer1.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAssignedEntity(AssignedEntity_1Bean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

}
