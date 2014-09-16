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
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.ActClinicalDocument;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.AuthorizationBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Component4Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.CustodianBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.InFulfillmentOfBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Participant1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.RelatedDocumentBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"POCD_MT000040.ClinicalDocument"})
public class ClinicalDocumentBean extends MessagePartBean {

    private static final long serialVersionUID = 20140915L;
    private CS_R2 classCode = new CS_R2Impl();
    private CS_R2 moodCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private II id = new IIImpl();
    private CE_R2 code = new CE_R2Impl();
    private ST title = new STImpl();
    private TS effectiveTime = new TSImpl();
    private CE_R2 confidentialityCode = new CE_R2Impl();
    private CS_R2 languageCode = new CS_R2Impl();
    private II setId = new IIImpl();
    private INT versionNumber = new INTImpl();
    private TS copyTime = new TSImpl();
    private List<RecordTargetBean> recordTarget = new ArrayList<RecordTargetBean>();
    private List<Author_1Bean> author = new ArrayList<Author_1Bean>();
    private DataEntererBean dataEnterer;
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private CustodianBean custodian;
    private List<InformationRecipientBean> informationRecipient = new ArrayList<InformationRecipientBean>();
    private LegalAuthenticatorBean legalAuthenticator;
    private List<AuthenticatorBean> authenticator = new ArrayList<AuthenticatorBean>();
    private List<Participant1Bean> participant = new ArrayList<Participant1Bean>();
    private List<InFulfillmentOfBean> inFulfillmentOf = new ArrayList<InFulfillmentOfBean>();
    private List<DocumentationOfBean> documentationOf = new ArrayList<DocumentationOfBean>();
    private List<RelatedDocumentBean> relatedDocument = new ArrayList<RelatedDocumentBean>();
    private List<AuthorizationBean> authorization = new ArrayList<AuthorizationBean>();
    private Component4Bean componentOf;
    private Component4Bean component;


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public CodedTypeR2<ActClinicalDocument> getClassCode() {
        return (CodedTypeR2<ActClinicalDocument>) this.classCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setClassCode(CodedTypeR2<ActClinicalDocument> classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public CodedTypeR2<ActMood> getMoodCode() {
        return (CodedTypeR2<ActMood>) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMoodCode(CodedTypeR2<ActMood> moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.typeId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.typeId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public CodedTypeR2<Code> getConfidentialityCode() {
        return (CodedTypeR2<Code>) this.confidentialityCode.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConfidentialityCode(CodedTypeR2<Code> confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public CodedTypeR2<Code> getLanguageCode() {
        return (CodedTypeR2<Code>) this.languageCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLanguageCode(CodedTypeR2<Code> languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.setId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"setId"})
    public Identifier getSetId() {
        return this.setId.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.setId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSetId(Identifier setId) {
        this.setId.setValue(setId);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.versionNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"versionNumber"})
    public Integer getVersionNumber() {
        return this.versionNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.versionNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber.setValue(versionNumber);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.copyTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"copyTime"})
    public Date getCopyTime() {
        return this.copyTime.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.copyTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCopyTime(Date copyTime) {
        this.copyTime.setValue(copyTime);
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.recordTarget</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"recordTarget"})
    public List<RecordTargetBean> getRecordTarget() {
        return this.recordTarget;
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"author"})
    public List<Author_1Bean> getAuthor() {
        return this.author;
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.dataEnterer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"dataEnterer"})
    public DataEntererBean getDataEnterer() {
        return this.dataEnterer;
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.dataEnterer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDataEnterer(DataEntererBean dataEnterer) {
        this.dataEnterer = dataEnterer;
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.custodian</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"custodian"})
    public CustodianBean getCustodian() {
        return this.custodian;
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.custodian</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCustodian(CustodianBean custodian) {
        this.custodian = custodian;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.informationRecipient</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informationRecipient"})
    public List<InformationRecipientBean> getInformationRecipient() {
        return this.informationRecipient;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.legalAuthenticator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"legalAuthenticator"})
    public LegalAuthenticatorBean getLegalAuthenticator() {
        return this.legalAuthenticator;
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.legalAuthenticator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLegalAuthenticator(LegalAuthenticatorBean legalAuthenticator) {
        this.legalAuthenticator = legalAuthenticator;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.authenticator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"authenticator"})
    public List<AuthenticatorBean> getAuthenticator() {
        return this.authenticator;
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant1Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.inFulfillmentOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf"})
    public List<InFulfillmentOfBean> getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.documentationOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"documentationOf"})
    public List<DocumentationOfBean> getDocumentationOf() {
        return this.documentationOf;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.relatedDocument</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"relatedDocument"})
    public List<RelatedDocumentBean> getRelatedDocument() {
        return this.relatedDocument;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.ClinicalDocument.authorization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"authorization"})
    public List<AuthorizationBean> getAuthorization() {
        return this.authorization;
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.componentOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"componentOf"})
    public Component4Bean getComponentOf() {
        return this.componentOf;
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.componentOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setComponentOf(Component4Bean componentOf) {
        this.componentOf = componentOf;
    }


    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.component</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component"})
    public Component4Bean getComponent() {
        return this.component;
    }

    /**
     * <p>Relationship: POCD_MT000040.ClinicalDocument.component</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent(Component4Bean component) {
        this.component = component;
    }

}
