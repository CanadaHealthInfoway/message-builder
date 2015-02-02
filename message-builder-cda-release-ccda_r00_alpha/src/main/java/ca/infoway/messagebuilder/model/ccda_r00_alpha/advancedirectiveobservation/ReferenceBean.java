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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.advancedirectiveobservation;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.ActClassDocument;
import java.util.List;



@Hl7PartTypeMapping({"AdvanceDirectiveObservation.Reference"})
public class ReferenceBean extends MessagePartBean implements ReferenceChoice {

    private static final long serialVersionUID = 20150202L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private BL seperatableInd = new BLImpl();
    private CS_R2 externalDocumentClassCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> externalDocumentRealmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II externalDocumentTypeId = new IIImpl();
    private LIST<II, Identifier> externalDocumentTemplateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> externalDocumentId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CD_R2 externalDocumentCode = new CD_R2Impl();
    private ED<EncapsulatedData> externalDocumentText = new EDImpl<EncapsulatedData>();
    private II externalDocumentSetId = new IIImpl();
    private INT externalDocumentVersionNumber = new INTImpl();


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.Reference.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.Reference.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.Reference.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.Reference.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.Reference.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"seperatableInd"})
    public Boolean getSeperatableInd() {
        return this.seperatableInd.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.Reference.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSeperatableInd(Boolean seperatableInd) {
        this.seperatableInd.setValue(seperatableInd);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"externalDocument/classCode"})
    public CodedTypeR2<ActClassDocument> getExternalDocumentClassCode() {
        return (CodedTypeR2<ActClassDocument>) this.externalDocumentClassCode.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setExternalDocumentClassCode(CodedTypeR2<ActClassDocument> externalDocumentClassCode) {
        this.externalDocumentClassCode.setValue(externalDocumentClassCode);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"externalDocument/realmCode"})
    public List<CodedTypeR2<Code>> getExternalDocumentRealmCode() {
        return this.externalDocumentRealmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"externalDocument/typeId"})
    public Identifier getExternalDocumentTypeId() {
        return this.externalDocumentTypeId.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setExternalDocumentTypeId(Identifier externalDocumentTypeId) {
        this.externalDocumentTypeId.setValue(externalDocumentTypeId);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"externalDocument/templateId"})
    public List<Identifier> getExternalDocumentTemplateId() {
        return this.externalDocumentTemplateId.rawList();
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"externalDocument/id"})
    public List<Identifier> getExternalDocumentId() {
        return this.externalDocumentId.rawList();
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"externalDocument/code"})
    public CodedTypeR2<Code> getExternalDocumentCode() {
        return (CodedTypeR2<Code>) this.externalDocumentCode.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setExternalDocumentCode(CodedTypeR2<Code> externalDocumentCode) {
        this.externalDocumentCode.setValue(externalDocumentCode);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"externalDocument/text"})
    public EncapsulatedData getExternalDocumentText() {
        return this.externalDocumentText.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setExternalDocumentText(EncapsulatedData externalDocumentText) {
        this.externalDocumentText.setValue(externalDocumentText);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.setId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"externalDocument/setId"})
    public Identifier getExternalDocumentSetId() {
        return this.externalDocumentSetId.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.setId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setExternalDocumentSetId(Identifier externalDocumentSetId) {
        this.externalDocumentSetId.setValue(externalDocumentSetId);
    }


    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.versionNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"externalDocument/versionNumber"})
    public Integer getExternalDocumentVersionNumber() {
        return this.externalDocumentVersionNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * AdvanceDirectiveObservation.ExternalDocument.versionNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setExternalDocumentVersionNumber(Integer externalDocumentVersionNumber) {
        this.externalDocumentVersionNumber.setValue(externalDocumentVersionNumber);
    }

}
