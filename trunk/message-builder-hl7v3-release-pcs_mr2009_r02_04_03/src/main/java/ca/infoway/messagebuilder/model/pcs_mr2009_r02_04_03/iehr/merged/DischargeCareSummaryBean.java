/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.CareSummaryDocumentType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>DischargeCareSummary</p>
 * 
 * <p>REPC_MT220001CA.Document: Discharge-Care Summary</p>
 * 
 * <p>Represents a particular health-related document 
 * pertaining to a single patient.</p>
 * 
 * <p>Allows the capture of patient health data in an 
 * encapsulated, contextualized manner with capability of 
 * displaying rendered content and communication between simple 
 * systems.</p>
 * 
 * <p>REPC_MT220003CA.Document: Discharge-Care Summary</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Represents a particular health-related document 
 * pertaining to a single patient.</p>
 * 
 * <p>Allows the capture of patient health data in an 
 * encapsulated, contextualized manner with capability of 
 * displaying rendered content and communication between simple 
 * systems.</p>
 */
@Hl7PartTypeMapping({"REPC_MT220001CA.Document","REPC_MT220003CA.Document"})
@Hl7RootType
public class DischargeCareSummaryBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private RequestedByBean author;
    private List<Recipients> primaryInformationRecipientRecipients = new ArrayList<Recipients>();
    private List<OldClinicalDocumentEventBean> predecessorOldClinicalDocumentEvent = new ArrayList<OldClinicalDocumentEventBean>();
    private SectionBean componentStructuredBodyComponentSection;
    private IncludesBean subjectOf1;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private ActingPerson responsiblePartyActingPerson;
    private ServiceLocationBean custodian1ServiceDeliveryLocation;
    private EHRRepositoryBean custodian2AssignedDevice;
    private NewClinicalDocumentEventBean successorNewClinicalDocumentEvent;
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);


    /**
     * <p>DocumentCategory</p>
     * 
     * <p>B: Document Category</p>
     * 
     * <p> <i>Identifies the type of Discharge-Care Summary 
     * represented by this record. e.g. summarization of episode 
     * note; discharge summarization note.</i> </p>
     * 
     * <p> <i>Document Category is used for searching and for 
     * organizing Discharge-Care Summary records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p>
     * 
     * <p> <i>Document Category is used for searching and for 
     * organizing Discharge-Care Summary records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p>
     */
    @Hl7XmlMapping({"code"})
    public CareSummaryDocumentType getCode() {
        return (CareSummaryDocumentType) this.code.getValue();
    }

    /**
     * <p>DocumentCategory</p>
     * 
     * <p>B: Document Category</p>
     * 
     * <p> <i>Identifies the type of Discharge-Care Summary 
     * represented by this record. e.g. summarization of episode 
     * note; discharge summarization note.</i> </p>
     * 
     * <p> <i>Document Category is used for searching and for 
     * organizing Discharge-Care Summary records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p>
     * 
     * <p> <i>Document Category is used for searching and for 
     * organizing Discharge-Care Summary records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p>
     */
    public void setCode(CareSummaryDocumentType code) {
        this.code.setValue(code);
    }


    /**
     * <p>DocumentTitle</p>
     * 
     * <p>J: Document Title</p>
     * 
     * <p>A human-readable label for this particular document.</p>
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
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>DocumentTitle</p>
     * 
     * <p>J: Document Title</p>
     * 
     * <p>A human-readable label for this particular document.</p>
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
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>DocumentMaskingIndicators</p>
     * 
     * <p>E: Document Masking Indicators</p>
     * 
     * <p> <i>Communicates the desire of the patient to restrict 
     * access to this Discharge-Care Summary record. Provides 
     * support for additional confidentiality constraint, giving 
     * patients a level of control over their information. Methods 
     * for accessing masked event records will be governed by each 
     * jurisdiction (e.g. court orders, shared secret/consent, 
     * etc.).</i> </p><p> <i>Can also be used to communicate that 
     * the information is deemed to be sensitive and should not be 
     * communicated or exposed to the patient (at least without the 
     * guidance of the authoring or other responsible healthcare 
     * provider).</i> </p><p> <i>Valid values are: 'normal' 
     * (denotes 'Not Masked'); 'restricted' (denotes 'Masked') and 
     * 'taboo' (denotes 'patient restricted'). The default is 
     * 'normal' signifying 'Not Masked'. Either or both of the 
     * other codes can be asserted to indicate masking by the 
     * patient from providers or masking by a provider from the 
     * patient, respectively. 'normal' should never be asserted 
     * with one of the other codes.</i> </p>
     * 
     * <p> <i>Communicates the desire of the patient to restrict 
     * access to this Discharge-Care Summary record. Provides 
     * support for additional confidentiality constraint, giving 
     * patients a level of control over their information. Methods 
     * for accessing masked event records will be governed by each 
     * jurisdiction (e.g. court orders, shared secret/consent, 
     * etc.).</i> </p><p> <i>Can also be used to communicate that 
     * the information is deemed to be sensitive and should not be 
     * communicated or exposed to the patient (at least without the 
     * guidance of the authoring or other responsible healthcare 
     * provider).</i> </p><p> <i>Valid values are: 'normal' 
     * (denotes 'Not Masked'); 'restricted' (denotes 'Masked') and 
     * 'taboo' (denotes 'patient restricted'). The default is 
     * 'normal' signifying 'Not Masked'. Either or both of the 
     * other codes can be asserted to indicate masking by the 
     * patient from providers or masking by a provider from the 
     * patient, respectively. 'normal' should never be asserted 
     * with one of the other codes.</i> </p>
     * 
     * <p> <i>Communicates the desire of the patient to restrict 
     * access to this Discharge-Care Summary record. Provides 
     * support for additional confidentiality constraint, giving 
     * patients a level of control over their information. Methods 
     * for accessing masked event records will be governed by each 
     * jurisdiction (e.g. court orders, shared secret/consent, 
     * etc.).</i> </p><p> <i>Can also be used to communicate that 
     * the information is deemed to be sensitive and should not be 
     * communicated or exposed to the patient (at least without the 
     * guidance of the authoring or other responsible healthcare 
     * provider).</i> </p><p> <i>Valid values are: 'normal' 
     * (denotes 'Not Masked'); 'restricted' (denotes 'Masked') and 
     * 'taboo' (denotes 'patient restricted'). The default is 
     * 'normal' signifying 'Not Masked'. Either or both of the 
     * other codes can be asserted to indicate masking by the 
     * patient from providers or masking by a provider from the 
     * patient, respectively. 'normal' should never be asserted 
     * with one of the other codes.</i> </p>
     * 
     * <p> <i>The value specified for a particular record may be 
     * overridden by a higher level masking applied to an 
     * indication, a care composition, a type of record or even all 
     * patient records.</i> </p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }

    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"primaryInformationRecipient/recipients"})
    public List<Recipients> getPrimaryInformationRecipientRecipients() {
        return this.primaryInformationRecipientRecipients;
    }


    @Hl7XmlMapping({"predecessor/oldClinicalDocumentEvent"})
    public List<OldClinicalDocumentEventBean> getPredecessorOldClinicalDocumentEvent() {
        return this.predecessorOldClinicalDocumentEvent;
    }


    @Hl7XmlMapping({"component/structuredBody/component/section"})
    public SectionBean getComponentStructuredBodyComponentSection() {
        return this.componentStructuredBodyComponentSection;
    }

    public void setComponentStructuredBodyComponentSection(SectionBean componentStructuredBodyComponentSection) {
        this.componentStructuredBodyComponentSection = componentStructuredBodyComponentSection;
    }


    @Hl7XmlMapping({"subjectOf","subjectOf1"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="REPC_MT220001CA.Subject4"),
        @Hl7MapByPartType(name="subjectOf1", type="REPC_MT220003CA.Subject4")})
    public IncludesBean getSubjectOf1() {
        return this.subjectOf1;
    }

    public void setSubjectOf1(IncludesBean subjectOf1) {
        this.subjectOf1 = subjectOf1;
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }


    /**
     * <p>DocumentIdentifiers</p>
     * 
     * <p>A: Document Identifiers</p>
     * 
     * <p> <i>A globally unique identifier assigned by the EHR to 
     * the Discharge-Care Summary record.</i> </p>
     * 
     * <p> <i>Allows for unique identification of the 
     * Discharge-Care Summary and is therefore mandatory. Supports 
     * drill-down queries, linking of this record to other records, 
     * matching of EHR records to locally-stored PoS records and is 
     * necessary when identifying records for amending 
     * (revising)/directional linking (superseding).</i> </p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }

    public void setResponsiblePartyActingPerson(ActingPerson responsiblePartyActingPerson) {
        this.responsiblePartyActingPerson = responsiblePartyActingPerson;
    }


    @Hl7XmlMapping({"custodian1/serviceDeliveryLocation"})
    public ServiceLocationBean getCustodian1ServiceDeliveryLocation() {
        return this.custodian1ServiceDeliveryLocation;
    }

    public void setCustodian1ServiceDeliveryLocation(ServiceLocationBean custodian1ServiceDeliveryLocation) {
        this.custodian1ServiceDeliveryLocation = custodian1ServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"custodian2/assignedDevice"})
    public EHRRepositoryBean getCustodian2AssignedDevice() {
        return this.custodian2AssignedDevice;
    }

    public void setCustodian2AssignedDevice(EHRRepositoryBean custodian2AssignedDevice) {
        this.custodian2AssignedDevice = custodian2AssignedDevice;
    }


    @Hl7XmlMapping({"successor/newClinicalDocumentEvent"})
    public NewClinicalDocumentEventBean getSuccessorNewClinicalDocumentEvent() {
        return this.successorNewClinicalDocumentEvent;
    }

    public void setSuccessorNewClinicalDocumentEvent(NewClinicalDocumentEventBean successorNewClinicalDocumentEvent) {
        this.successorNewClinicalDocumentEvent = successorNewClinicalDocumentEvent;
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }

}
