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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.repc_mt230001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalReportDocumentType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.OldClinicalDocumentEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.Recipients;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
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
@Hl7PartTypeMapping({"REPC_MT230001CA.Document"})
@Hl7RootType
public class ClinicalObservationDocumentBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private AuthorBean author;
    private ActingPerson informantActingPerson;
    private List<Recipients> primaryInformationRecipientRecipients = new ArrayList<Recipients>();
    private List<OldClinicalDocumentEventBean> predecessorOldClinicalDocumentEvent = new ArrayList<OldClinicalDocumentEventBean>();
    private SectionBean componentStructuredBodyComponentSection;
    private IncludesBean subjectOf;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: B: Document Category</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Document.code</p>
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
     * <p>Relationship: REPC_MT230001CA.Document.code</p>
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
     * <p>Relationship: REPC_MT230001CA.Document.title</p>
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
     * <p>Relationship: REPC_MT230001CA.Document.title</p>
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
     * REPC_MT230001CA.Document.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p> <i>Allows the patient to have discrete control over 
     * access to their health data. Awareness of the patient's 
     * desire for confidentiality is important even for providers 
     * who have access to the data because it indicates a need for 
     * extra caution before disclosing the information to other 
     * care providers.</i> </p><p> <i>Also allows providers to mark 
     * records as &quot;not for patient display&quot; for 
     * circumstances where the patient has access to their own EHR 
     * or where another healthcare provider discusses or provides 
     * them with a copy of information from their EHR. (There are 
     * some pieces of information where it would be detrimental to 
     * a patient's health or ongoing care were they to be aware of 
     * those records without careful guidance.)</i> </p><p> <i>Two 
     * repetitions are supported to allow indicating that the 
     * record is masked from both a provider and a patient 
     * perspective.</i> </p>
     * 
     * <p> <i>The value specified for a particular record may be 
     * overridden by a higher level masking applied to an 
     * indication, a care composition, a type of record or even all 
     * patient records.</i> </p>
     * 
     * <p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: REPC_MT230001CA.Document.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public AuthorBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: REPC_MT230001CA.Document.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(AuthorBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: REPC_MT230001CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"informant/actingPerson"})
    public ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT230001CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
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
     * REPC_MT230001CA.InformationRecipient.recipients</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"primaryInformationRecipient/recipients"})
    public List<Recipients> getPrimaryInformationRecipientRecipients() {
        return this.primaryInformationRecipientRecipients;
    }


    /**
     * <p>Relationship: 
     * REPC_MT230001CA.Predecessor2.oldClinicalDocumentEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/oldClinicalDocumentEvent"})
    public List<OldClinicalDocumentEventBean> getPredecessorOldClinicalDocumentEvent() {
        return this.predecessorOldClinicalDocumentEvent;
    }


    /**
     * <p>Relationship: REPC_MT230001CA.Component3.section</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/structuredBody/component/section"})
    public SectionBean getComponentStructuredBodyComponentSection() {
        return this.componentStructuredBodyComponentSection;
    }

    /**
     * <p>Relationship: REPC_MT230001CA.Component3.section</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentStructuredBodyComponentSection(SectionBean componentStructuredBodyComponentSection) {
        this.componentStructuredBodyComponentSection = componentStructuredBodyComponentSection;
    }


    /**
     * <p>Relationship: REPC_MT230001CA.Document.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }

    /**
     * <p>Relationship: REPC_MT230001CA.Document.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }


    /**
     * <p>Relationship: 
     * REPC_MT230001CA.Component6.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
