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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.repc_mt230002ca;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.ActingPerson;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.EHRRepositoryBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.Patient_2Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.merged.Recipients;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.merged.RequestedByBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.merged.Section_3Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.CareCompositionsBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ClinicalReportDocumentType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Clinical Observation Document</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Allows the capture of patient health data in an 
 * encapsulated, contextualized manner with capability of 
 * displaying rendered content and communication between simple 
 * systems.</p>
 * 
 * <p>Represents a particular health-related document 
 * pertaining to a single patient.</p>
 */
@Hl7PartTypeMapping({"REPC_MT230002CA.Document"})
@Hl7RootType
public class ClinicalObservationDocumentBean extends MessagePartBean implements Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.comt_mt111111ca.SHR {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson responsiblePartyActingPerson;
    private RequestedByBean author;
    private ActingPerson informantActingPerson;
    private ServiceLocationBean custodian1ServiceDeliveryLocation;
    private EHRRepositoryBean custodian2AssignedDevice;
    private List<Recipients> primaryInformationRecipientRecipients = new ArrayList<Recipients>();
    private List<II> predecessorOldClinicalDocumentEventId = new ArrayList<II>();
    private Section_3Bean componentStructuredBodyComponentSection;
    private II successorNewClinicalDocumentEventId = new IIImpl();
    private IncludesBean subjectOf1;
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: A: Document Identifier</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows for unique identification of the Clinical 
     * Observation Document and is therefore mandatory. Supports 
     * drill-down queries, linking of this record to other records, 
     * matching of EHR records to locally-stored PoS records and is 
     * necessary when identifying records for amending 
     * (revising)/directional linking (superseding).</i> </p>
     * 
     * <p> <i>A globally unique identifier assigned by the EHR to 
     * the Clinical Observation Document record.</i> </p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A: Document Identifier</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows for unique identification of the Clinical 
     * Observation Document and is therefore mandatory. Supports 
     * drill-down queries, linking of this record to other records, 
     * matching of EHR records to locally-stored PoS records and is 
     * necessary when identifying records for amending 
     * (revising)/directional linking (superseding).</i> </p>
     * 
     * <p> <i>A globally unique identifier assigned by the EHR to 
     * the Clinical Observation Document record.</i> </p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: B: Document Category</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Document Category is used for searching and for 
     * organizing Clinical Observation Document records as well as 
     * sorting them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record. e.g. procedure note, clinical 
     * note.</i> </p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalReportDocumentType getCode() {
        return (ClinicalReportDocumentType) this.code.getValue();
    }

    /**
     * <p>Business Name: B: Document Category</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Document Category is used for searching and for 
     * organizing Clinical Observation Document records as well as 
     * sorting them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record. e.g. procedure note, clinical 
     * note.</i> </p>
     */
    public void setCode(ClinicalReportDocumentType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: J: Document Title</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Document.title</p>
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
     * <p>Relationship: REPC_MT230002CA.Document.title</p>
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
     * <p>Business Name: E: Document Masking Indicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT230002CA.Document.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p></p>
     * 
     * <p> <i>The value specified for a particular record may be 
     * overridden by a higher level masking applied to an 
     * indication, a care composition, a type of record or even all 
     * patient records.</i> </p>
     * 
     * <p> <i>Communicates the desire of the patient to restrict 
     * access to this Clinical Observation Document record. 
     * Provides support for additional confidentiality constraint, 
     * giving patients a level of control over their information. 
     * Methods for accessing masked event records will be governed 
     * by each jurisdiction (e.g. court orders, shared 
     * secret/consent, etc.).</i> </p><p> <i>Can also be used to 
     * communicate that the information is deemed to be sensitive 
     * and should not be communicated or exposed to the patient (at 
     * least without the guidance of the authoring or other 
     * responsible healthcare provider).</i> </p><p> <i>Valid 
     * values are: 'normal' (denotes 'Not Masked'); 'restricted' 
     * (denotes 'Masked') and 'taboo' (denotes 'patient 
     * restricted'). The default is 'normal' signifying 'Not 
     * Masked'. Either or both of the other codes can be asserted 
     * to indicate masking by the patient from providers or masking 
     * by a provider from the patient, respectively. 'normal' 
     * should never be asserted with one of the other codes.</i> 
     * </p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: 
     * REPC_MT230002CA.ResponsibleParty.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }

    /**
     * <p>Relationship: 
     * REPC_MT230002CA.ResponsibleParty.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setResponsiblePartyActingPerson(Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson responsiblePartyActingPerson) {
        this.responsiblePartyActingPerson = responsiblePartyActingPerson;
    }

    public HealthcareWorkerBean getResponsiblePartyActingPersonAsAssignedEntity1() {
        return this.responsiblePartyActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsAssignedEntity1() {
        return (this.responsiblePartyActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getResponsiblePartyActingPersonAsAssignedEntity2() {
        return this.responsiblePartyActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsAssignedEntity2() {
        return (this.responsiblePartyActingPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getResponsiblePartyActingPersonAsPersonalRelationship() {
        return this.responsiblePartyActingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsPersonalRelationship() {
        return (this.responsiblePartyActingPerson instanceof RelatedPersonBean);
    }


    /**
     * <p>Relationship: REPC_MT230002CA.Document.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: REPC_MT230002CA.Document.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: REPC_MT230002CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informant/actingPerson"})
    public ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT230002CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInformantActingPerson(ActingPerson informantActingPerson) {
        this.informantActingPerson = informantActingPerson;
    }

    public HealthcareWorkerBean getInformantActingPersonAsAssignedEntity1() {
        return this.informantActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity1() {
        return (this.informantActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getInformantActingPersonAsAssignedEntity2() {
        return this.informantActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity2() {
        return (this.informantActingPerson instanceof HealthcareOrganizationBean);
    }

    public Patient_2Bean getInformantActingPersonAsPatient() {
        return this.informantActingPerson instanceof Patient_2Bean ? (Patient_2Bean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsPatient() {
        return (this.informantActingPerson instanceof Patient_2Bean);
    }


    /**
     * <p>Relationship: 
     * REPC_MT230002CA.Custodian2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"custodian1/serviceDeliveryLocation"})
    public ServiceLocationBean getCustodian1ServiceDeliveryLocation() {
        return this.custodian1ServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * REPC_MT230002CA.Custodian2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCustodian1ServiceDeliveryLocation(ServiceLocationBean custodian1ServiceDeliveryLocation) {
        this.custodian1ServiceDeliveryLocation = custodian1ServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: REPC_MT230002CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"custodian2/assignedDevice"})
    public EHRRepositoryBean getCustodian2AssignedDevice() {
        return this.custodian2AssignedDevice;
    }

    /**
     * <p>Relationship: REPC_MT230002CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCustodian2AssignedDevice(EHRRepositoryBean custodian2AssignedDevice) {
        this.custodian2AssignedDevice = custodian2AssignedDevice;
    }


    /**
     * <p>Relationship: 
     * REPC_MT230002CA.InformationRecipient.recipients</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"primaryInformationRecipient/recipients"})
    public List<Recipients> getPrimaryInformationRecipientRecipients() {
        return this.primaryInformationRecipientRecipients;
    }


    /**
     * <p>Business Name: G:Replaces Record Ids</p>
     * 
     * <p>Relationship: REPC_MT230002CA.OldClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where information initially 
     * captured about an event is erroneous, incomplete or not 
     * captured at the desired level of detail and the change 
     * cannot be made by retracting the original record. (E.g. Too 
     * much time has elapsed, change is being made by a provider 
     * other than the original author of the vent record, etc.) May 
     * also be used to reference multiple records in the case where 
     * the same event has been accidentally captured more than 
     * once. May also be used when this is a newer 
     * &quot;version&quot; of the type of Clinical Observation 
     * Document than those records being referenced.</i> </p>
     * 
     * <p> <i>Used to identify any records that are 
     * &quot;superseded&quot; by the current record. This will 
     * cause the referenced records to be marked as 
     * &quot;obsolete&quot; with a reference pointing to this 
     * record.</i> </p>
     */
    @Hl7XmlMapping({"predecessor/oldClinicalDocumentEvent/id"})
    public List<Identifier> getPredecessorOldClinicalDocumentEventId() {
        return new RawListWrapper<II, Identifier>(predecessorOldClinicalDocumentEventId, IIImpl.class);
    }


    /**
     * <p>Relationship: REPC_MT230002CA.Component3.section</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/structuredBody/component/section"})
    public Section_3Bean getComponentStructuredBodyComponentSection() {
        return this.componentStructuredBodyComponentSection;
    }

    /**
     * <p>Relationship: REPC_MT230002CA.Component3.section</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentStructuredBodyComponentSection(Section_3Bean componentStructuredBodyComponentSection) {
        this.componentStructuredBodyComponentSection = componentStructuredBodyComponentSection;
    }


    /**
     * <p>Business Name: H:Replaced by Record Id</p>
     * 
     * <p>Relationship: REPC_MT230002CA.NewClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where a newer or corrected 
     * version of the record of this event exists. May also be used 
     * when there is a newer &quot;version&quot; of the type of the 
     * Clinical Observation Document.</i> </p>
     * 
     * <p> <i>Used to identify the record that supersedes the 
     * current record. This attribute is set when a new record 
     * identifies the current record as being replaced.</i> </p>
     */
    @Hl7XmlMapping({"successor/newClinicalDocumentEvent/id"})
    public Identifier getSuccessorNewClinicalDocumentEventId() {
        return this.successorNewClinicalDocumentEventId.getValue();
    }

    /**
     * <p>Business Name: H:Replaced by Record Id</p>
     * 
     * <p>Relationship: REPC_MT230002CA.NewClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where a newer or corrected 
     * version of the record of this event exists. May also be used 
     * when there is a newer &quot;version&quot; of the type of the 
     * Clinical Observation Document.</i> </p>
     * 
     * <p> <i>Used to identify the record that supersedes the 
     * current record. This attribute is set when a new record 
     * identifies the current record as being replaced.</i> </p>
     */
    public void setSuccessorNewClinicalDocumentEventId(Identifier successorNewClinicalDocumentEventId) {
        this.successorNewClinicalDocumentEventId.setValue(successorNewClinicalDocumentEventId);
    }


    /**
     * <p>Relationship: REPC_MT230002CA.Document.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public IncludesBean getSubjectOf1() {
        return this.subjectOf1;
    }

    /**
     * <p>Relationship: REPC_MT230002CA.Document.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf1(IncludesBean subjectOf1) {
        this.subjectOf1 = subjectOf1;
    }


    /**
     * <p>Relationship: 
     * REPC_MT230002CA.Subject3.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * REPC_MT230002CA.Subject3.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>Relationship: 
     * REPC_MT230002CA.Component6.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
