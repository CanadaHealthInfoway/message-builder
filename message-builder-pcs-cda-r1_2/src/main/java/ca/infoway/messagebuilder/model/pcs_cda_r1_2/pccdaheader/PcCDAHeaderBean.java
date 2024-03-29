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
package ca.infoway.messagebuilder.model.pcs_cda_r1_2.pccdaheader;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TSCDAR1;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.basemodel.Component2Bean;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.domainvalue.CDAHeaderDocumentType;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.merged.CustodianBean;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.merged.RelatedDocumentBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"PcCDAHeader.ClinicalDocument"})
@Hl7RootType
public class PcCDAHeaderBean extends MessagePartBean {

    private static final long serialVersionUID = 20160107L;
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private TSCDAR1 effectiveTime = new TSCDAR1Impl();
    private CV confidentialityCode = new CVImpl();
    private CS languageCode = new CSImpl();
    private II setId = new IIImpl();
    private INT versionNumber = new INTImpl();
    private TSCDAR1 copyTime = new TSCDAR1Impl();
    private List<RecordTargetBean> recordTarget = new ArrayList<RecordTargetBean>();
    private List<AuthorBean> author = new ArrayList<AuthorBean>();
    private DataEntererBean dataEnterer;
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private CustodianBean custodian;
    private List<InformationRecipientBean> informationRecipient = new ArrayList<InformationRecipientBean>();
    private LegalAuthenticatorBean legalAuthenticator;
    private List<AuthenticatorBean> authenticator = new ArrayList<AuthenticatorBean>();
    private List<Participant1Bean> participant = new ArrayList<Participant1Bean>();
    private List<InFulfillmentOfBean> inFulfillmentOf = new ArrayList<InFulfillmentOfBean>();
    private List<DocumentationOfBean> documentationOf = new ArrayList<DocumentationOfBean>();
    private RelatedDocumentBean relatedDocument;
    private List<AuthorizationBean> authorization = new ArrayList<AuthorizationBean>();
    private Component1Bean componentOf;
    private Component2Bean component;

    protected PcCDAHeaderBean() {}

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.typeId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.typeId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.templateId</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CDAHeaderDocumentType getCode() {
        return (CDAHeaderDocumentType) this.code.getValue();
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setCode(CDAHeaderDocumentType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public MbDate getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setEffectiveTime(MbDate effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * PcCDAHeader.ClinicalDocument.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_BasicConfidentialityKind getConfidentialityCode() {
        return (x_BasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Relationship: 
     * PcCDAHeader.ClinicalDocument.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setConfidentialityCode(x_BasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.languageCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.languageCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.setId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"setId"})
    public Identifier getSetId() {
        return this.setId.getValue();
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.setId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSetId(Identifier setId) {
        this.setId.setValue(setId);
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.versionNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"versionNumber"})
    public Integer getVersionNumber() {
        return this.versionNumber.getValue();
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.versionNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber.setValue(versionNumber);
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.copyTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"copyTime"})
    public MbDate getCopyTime() {
        return this.copyTime.getValue();
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.copyTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCopyTime(MbDate copyTime) {
        this.copyTime.setValue(copyTime);
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.recordTarget</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"recordTarget"})
    public List<RecordTargetBean> getRecordTarget() {
        return this.recordTarget;
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.author</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"author"})
    public List<AuthorBean> getAuthor() {
        return this.author;
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.dataEnterer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"dataEnterer"})
    public DataEntererBean getDataEnterer() {
        return this.dataEnterer;
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.dataEnterer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDataEnterer(DataEntererBean dataEnterer) {
        this.dataEnterer = dataEnterer;
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.custodian</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"custodian"})
    public CustodianBean getCustodian() {
        return this.custodian;
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.custodian</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setCustodian(CustodianBean custodian) {
        this.custodian = custodian;
    }


    /**
     * <p>Relationship: 
     * PcCDAHeader.ClinicalDocument.informationRecipient</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informationRecipient"})
    public List<InformationRecipientBean> getInformationRecipient() {
        return this.informationRecipient;
    }


    /**
     * <p>Relationship: 
     * PcCDAHeader.ClinicalDocument.legalAuthenticator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"legalAuthenticator"})
    public LegalAuthenticatorBean getLegalAuthenticator() {
        return this.legalAuthenticator;
    }

    /**
     * <p>Relationship: 
     * PcCDAHeader.ClinicalDocument.legalAuthenticator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLegalAuthenticator(LegalAuthenticatorBean legalAuthenticator) {
        this.legalAuthenticator = legalAuthenticator;
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.authenticator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"authenticator"})
    public List<AuthenticatorBean> getAuthenticator() {
        return this.authenticator;
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant1Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: 
     * PcCDAHeader.ClinicalDocument.inFulfillmentOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf"})
    public List<InFulfillmentOfBean> getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }


    /**
     * <p>Relationship: 
     * PcCDAHeader.ClinicalDocument.documentationOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"documentationOf"})
    public List<DocumentationOfBean> getDocumentationOf() {
        return this.documentationOf;
    }


    /**
     * <p>Relationship: 
     * PcCDAHeader.ClinicalDocument.relatedDocument</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"relatedDocument"})
    public RelatedDocumentBean getRelatedDocument() {
        return this.relatedDocument;
    }

    /**
     * <p>Relationship: 
     * PcCDAHeader.ClinicalDocument.relatedDocument</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRelatedDocument(RelatedDocumentBean relatedDocument) {
        this.relatedDocument = relatedDocument;
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.authorization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"authorization"})
    public List<AuthorizationBean> getAuthorization() {
        return this.authorization;
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.componentOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"componentOf"})
    public Component1Bean getComponentOf() {
        return this.componentOf;
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.componentOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setComponentOf(Component1Bean componentOf) {
        this.componentOf = componentOf;
    }


    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.component</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component"})
    public Component2Bean getComponent() {
        return this.component;
    }

    /**
     * <p>Relationship: PcCDAHeader.ClinicalDocument.component</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent(Component2Bean component) {
        this.component = component;
    }

}
