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
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.x_ActRelationshipEntry;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.procedureactivityact.ActBean;
import java.util.List;



@Hl7PartTypeMapping({"ProceduresSectionentriesOptional.ProcedureActivityActEntry","ProceduresSectionentriesRequired.ProcedureActivityActEntry"})
public class ProcedureActivityActEntryBean extends MessagePartBean implements EntryChoice_8 {

    private static final long serialVersionUID = 20150206L;
    private CS_R2 typeCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private ActBean act;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesOptional.ProcedureActivityActEntry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesRequired.ProcedureActivityActEntry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public CodedTypeR2<x_ActRelationshipEntry> getTypeCode() {
        return (CodedTypeR2<x_ActRelationshipEntry>) this.typeCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesOptional.ProcedureActivityActEntry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesRequired.ProcedureActivityActEntry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeCode(CodedTypeR2<x_ActRelationshipEntry> typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesOptional.ProcedureActivityActEntry.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesRequired.ProcedureActivityActEntry.realmCode</p>
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
     * <p>Relationship: 
     * ProceduresSectionentriesOptional.ProcedureActivityActEntry.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesRequired.ProcedureActivityActEntry.typeId</p>
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
     * <p>Relationship: 
     * ProceduresSectionentriesOptional.ProcedureActivityActEntry.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesRequired.ProcedureActivityActEntry.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesOptional.ProcedureActivityActEntry.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesRequired.ProcedureActivityActEntry.templateId</p>
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
     * <p>Relationship: 
     * ProceduresSectionentriesOptional.ProcedureActivityActEntry.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesRequired.ProcedureActivityActEntry.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"act"})
    public ActBean getAct() {
        return this.act;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesOptional.ProcedureActivityActEntry.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProceduresSectionentriesRequired.ProcedureActivityActEntry.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAct(ActBean act) {
        this.act = act;
    }

}
