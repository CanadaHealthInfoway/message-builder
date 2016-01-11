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
package ca.infoway.messagebuilder.model.ccda_r1_1.unstructureddocument;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS_R2;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TS_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.basemodel.RelatedDocumentBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.domainvalue.BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.ccda_r1_1.domainvalue.Language;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.AuthenticatorBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.AuthorizationChoice;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Component1_1Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Component2Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.DataEntererBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.DocumentationOfBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.InFulfillmentOfBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Informant12Choice;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.InformationRecipientBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.LegalAuthenticatorBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Participant1Choice;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"UnstructuredDocument.ClinicalDocument"})
@Hl7RootType
public class UnstructuredDocumentBean extends MessagePartBean {

    private static final long serialVersionUID = 20160107L;
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private II id = new IIImpl();
    private CE_R2<Code> code = new CE_R2Impl<Code>();
    private ST title = new STImpl();
    private TS_R2 effectiveTime = new TS_R2Impl();
    private CE_R2<BasicConfidentialityKind> confidentialityCode = new CE_R2Impl<BasicConfidentialityKind>();
    private CS_R2<Language> languageCode = new CS_R2Impl<Language>();
    private II setId = new IIImpl();
    private INT versionNumber = new INTImpl();
    private TS_R2 copyTime = new TS_R2Impl();
    private RecordTargetBean recordTarget;
    private AuthorBean author;
    private DataEntererBean dataEnterer;
    private List<Informant12Choice> informant = new ArrayList<Informant12Choice>();
    private CustodianBean custodian;
    private List<InformationRecipientBean> informationRecipient = new ArrayList<InformationRecipientBean>();
    private LegalAuthenticatorBean legalAuthenticator;
    private List<AuthenticatorBean> authenticator = new ArrayList<AuthenticatorBean>();
    private List<Participant1Choice> participant = new ArrayList<Participant1Choice>();
    private List<InFulfillmentOfBean> inFulfillmentOf = new ArrayList<InFulfillmentOfBean>();
    private List<DocumentationOfBean> documentationOf = new ArrayList<DocumentationOfBean>();
    private List<RelatedDocumentBean> relatedDocument = new ArrayList<RelatedDocumentBean>();
    private List<AuthorizationChoice> authorization = new ArrayList<AuthorizationChoice>();
    private Component1_1Bean componentOf;
    private Component2Bean component;

    protected UnstructuredDocumentBean() {}

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.typeId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.typeId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: UnstructuredDocument.ClinicalDocument.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Relationship: UnstructuredDocument.ClinicalDocument.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: UnstructuredDocument.ClinicalDocument.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: UnstructuredDocument.ClinicalDocument.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: UnstructuredDocument.ClinicalDocument.title</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Relationship: UnstructuredDocument.ClinicalDocument.title</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public MbDate getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setEffectiveTime(MbDate effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public CodedTypeR2<BasicConfidentialityKind> getConfidentialityCode() {
        return (CodedTypeR2<BasicConfidentialityKind>) this.confidentialityCode.getValue();
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setConfidentialityCode(CodedTypeR2<BasicConfidentialityKind> confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.languageCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public CodedTypeR2<Language> getLanguageCode() {
        return (CodedTypeR2<Language>) this.languageCode.getValue();
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.languageCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setLanguageCode(CodedTypeR2<Language> languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: UnstructuredDocument.ClinicalDocument.setId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"setId"})
    public Identifier getSetId() {
        return this.setId.getValue();
    }

    /**
     * <p>Relationship: UnstructuredDocument.ClinicalDocument.setId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSetId(Identifier setId) {
        this.setId.setValue(setId);
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.versionNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"versionNumber"})
    public Integer getVersionNumber() {
        return this.versionNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.versionNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber.setValue(versionNumber);
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.copyTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"copyTime"})
    public MbDate getCopyTime() {
        return this.copyTime.getValue();
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.copyTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCopyTime(MbDate copyTime) {
        this.copyTime.setValue(copyTime);
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.recordTarget</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"recordTarget"})
    public RecordTargetBean getRecordTarget() {
        return this.recordTarget;
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.recordTarget</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setRecordTarget(RecordTargetBean recordTarget) {
        this.recordTarget = recordTarget;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.author</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public AuthorBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.author</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAuthor(AuthorBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.dataEnterer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"dataEnterer"})
    public DataEntererBean getDataEnterer() {
        return this.dataEnterer;
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.dataEnterer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDataEnterer(DataEntererBean dataEnterer) {
        this.dataEnterer = dataEnterer;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Choice> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.custodian</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"custodian"})
    public CustodianBean getCustodian() {
        return this.custodian;
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.custodian</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setCustodian(CustodianBean custodian) {
        this.custodian = custodian;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.informationRecipient</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informationRecipient"})
    public List<InformationRecipientBean> getInformationRecipient() {
        return this.informationRecipient;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.legalAuthenticator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"legalAuthenticator"})
    public LegalAuthenticatorBean getLegalAuthenticator() {
        return this.legalAuthenticator;
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.legalAuthenticator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLegalAuthenticator(LegalAuthenticatorBean legalAuthenticator) {
        this.legalAuthenticator = legalAuthenticator;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.authenticator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"authenticator"})
    public List<AuthenticatorBean> getAuthenticator() {
        return this.authenticator;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant1Choice> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.inFulfillmentOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf"})
    public List<InFulfillmentOfBean> getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.documentationOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"documentationOf"})
    public List<DocumentationOfBean> getDocumentationOf() {
        return this.documentationOf;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.relatedDocument</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"relatedDocument"})
    public List<RelatedDocumentBean> getRelatedDocument() {
        return this.relatedDocument;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.authorization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"authorization"})
    public List<AuthorizationChoice> getAuthorization() {
        return this.authorization;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.componentOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"componentOf"})
    public Component1_1Bean getComponentOf() {
        return this.componentOf;
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.componentOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setComponentOf(Component1_1Bean componentOf) {
        this.componentOf = componentOf;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.component</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component"})
    public Component2Bean getComponent() {
        return this.component;
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.ClinicalDocument.component</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent(Component2Bean component) {
        this.component = component;
    }

}
