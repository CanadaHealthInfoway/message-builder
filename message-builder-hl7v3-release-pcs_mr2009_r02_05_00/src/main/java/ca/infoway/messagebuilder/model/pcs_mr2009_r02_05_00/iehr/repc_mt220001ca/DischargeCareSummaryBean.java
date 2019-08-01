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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt220001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.CareSummaryDocumentType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.AuthenticatedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.Recipients;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.ReplacesRecordIdsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.RequestedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Discharge-Care Summary</p>
 * 
 * <p>Allows the capture of patient health data in an 
 * encapsulated, contextualized manner with capability of 
 * displaying rendered content and communication between simple 
 * systems.</p>
 * 
 * <p>Represents a particular health-related document 
 * pertaining to a single patient.</p>
 */
@Hl7PartTypeMapping({"REPC_MT220001CA.Document"})
@Hl7RootType
public class DischargeCareSummaryBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private RequestedByBean author;
    private List<Recipients> primaryInformationRecipientRecipients = new ArrayList<Recipients>();
    private AuthenticatedByBean authenticator;
    private List<ReplacesRecordIdsBean> predecessorOldClinicalDocumentEvent = new ArrayList<ReplacesRecordIdsBean>();
    private DocumentContent component1DocumentContent;
    private SectionBean component2StructuredBodyComponentSection;
    private IncludesBean subjectOf;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: Document Identifier</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: B: Document Category</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Document Category is used for searching and for 
     * organizing Discharge-Care Summary records as well as sorting 
     * them for presentation.</p><p>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of Discharge-Care Summary represented 
     * by this record. e.g. summarization of episode note; 
     * discharge summarization note.</p>
     */
    @Hl7XmlMapping({"code"})
    public CareSummaryDocumentType getCode() {
        return (CareSummaryDocumentType) this.code.getValue();
    }

    /**
     * <p>Business Name: B: Document Category</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Document Category is used for searching and for 
     * organizing Discharge-Care Summary records as well as sorting 
     * them for presentation.</p><p>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of Discharge-Care Summary represented 
     * by this record. e.g. summarization of episode note; 
     * discharge summarization note.</p>
     */
    public void setCode(CareSummaryDocumentType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: J: Document Title</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Document.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is a human-recognizable name intended to be 
     * displayed on the screen in list transactions and is 
     * therefore mandatory. It provides a good indication of the 
     * content of the document at a quick glance.</p>
     * 
     * <p>Titles do not necessarily need to be unique, but should 
     * be precise-enough to give a pretty good idea of what the 
     * document contains. For example &quot;Right Knee Arthroscopy 
     * Report, Jan 3, 2006&quot; would represent a good title. 
     * &quot;Surgery Report&quot; would not.</p>
     * 
     * <p>A human-readable label for this particular document.</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Business Name: J: Document Title</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Document.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is a human-recognizable name intended to be 
     * displayed on the screen in list transactions and is 
     * therefore mandatory. It provides a good indication of the 
     * content of the document at a quick glance.</p>
     * 
     * <p>Titles do not necessarily need to be unique, but should 
     * be precise-enough to give a pretty good idea of what the 
     * document contains. For example &quot;Right Knee Arthroscopy 
     * Report, Jan 3, 2006&quot; would represent a good title. 
     * &quot;Surgery Report&quot; would not.</p>
     * 
     * <p>A human-readable label for this particular document.</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Business Name: Preliminary/Final Indicator</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Document.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Preliminary/Final Indicator</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Document.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: E: Document Masking Indicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.Document.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>The value specified for a particular record may be 
     * overridden by a higher level masking applied to an 
     * indication, a care composition, a type of record or even all 
     * patient records.</p>
     * 
     * <p>Communicates the desire of the patient to restrict access 
     * to this Discharge-Care Summary record. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Methods for 
     * accessing masked event records will be governed by each 
     * jurisdiction(e.g. court orders, shared secret/consent, 
     * etc.).</p><p>Can also be used to</p><p>communicate that the 
     * information is deemed to be sensitive and should not be 
     * communicated or exposed to the patient (at least without the 
     * guidance of the authoring or other responsible healthcare 
     * provider).</p><p>Valid values are: 'normal' (denotes 'Not 
     * Masked'); 'restricted' (denotes 'Masked') and 'taboo' 
     * (denotes 'patient restricted'). The default is 'normal' 
     * signifying 'Not Masked'. Either or both of the other codes 
     * can be asserted to indicate masking by the patient from 
     * providers or masking by a provider from the patient, 
     * respectively. 'normal' should never be asserted with one of 
     * the other codes.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: REPC_MT220001CA.Document.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: REPC_MT220001CA.Document.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: 
     * REPC_MT220001CA.InformationRecipient.recipients</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"primaryInformationRecipient/recipients"})
    public List<Recipients> getPrimaryInformationRecipientRecipients() {
        return this.primaryInformationRecipientRecipients;
    }


    /**
     * <p>Relationship: REPC_MT220001CA.Document.authenticator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"authenticator"})
    public AuthenticatedByBean getAuthenticator() {
        return this.authenticator;
    }

    /**
     * <p>Relationship: REPC_MT220001CA.Document.authenticator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthenticator(AuthenticatedByBean authenticator) {
        this.authenticator = authenticator;
    }


    /**
     * <p>Relationship: 
     * REPC_MT220001CA.Predecessor2.oldClinicalDocumentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/oldClinicalDocumentEvent"})
    public List<ReplacesRecordIdsBean> getPredecessorOldClinicalDocumentEvent() {
        return this.predecessorOldClinicalDocumentEvent;
    }


    /**
     * <p>Relationship: REPC_MT220001CA.Component4.documentContent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/documentContent"})
    public DocumentContent getComponent1DocumentContent() {
        return this.component1DocumentContent;
    }

    /**
     * <p>Relationship: REPC_MT220001CA.Component4.documentContent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent1DocumentContent(DocumentContent component1DocumentContent) {
        this.component1DocumentContent = component1DocumentContent;
    }

    public DischargeCareSummaryReportBean getComponent1DocumentContentAsPatientCareProvisionEvent() {
        return this.component1DocumentContent instanceof DischargeCareSummaryReportBean ? (DischargeCareSummaryReportBean) this.component1DocumentContent : null;
    }
    public boolean hasComponent1DocumentContentAsPatientCareProvisionEvent() {
        return (this.component1DocumentContent instanceof DischargeCareSummaryReportBean);
    }


    /**
     * <p>Relationship: REPC_MT220001CA.Component3.section</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component2/structuredBody/component/section"})
    public SectionBean getComponent2StructuredBodyComponentSection() {
        return this.component2StructuredBodyComponentSection;
    }

    /**
     * <p>Relationship: REPC_MT220001CA.Component3.section</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent2StructuredBodyComponentSection(SectionBean component2StructuredBodyComponentSection) {
        this.component2StructuredBodyComponentSection = component2StructuredBodyComponentSection;
    }


    /**
     * <p>Relationship: REPC_MT220001CA.Document.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }

    /**
     * <p>Relationship: REPC_MT220001CA.Document.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }


    /**
     * <p>Relationship: 
     * REPC_MT220001CA.Component6.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
