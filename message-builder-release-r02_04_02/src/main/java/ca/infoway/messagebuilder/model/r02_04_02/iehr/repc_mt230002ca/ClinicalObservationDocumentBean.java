/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.iehr.repc_mt230002ca;

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
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ClinicalReportDocumentType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.ActingPerson;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.DocumentContent_3;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.NewClinicalDocumentEventBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.OldClinicalDocumentEventBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.Recipients;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.RequestedByBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Clinical Observation Document</p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present and vice versa</p></p>
 * 
 * <p><p>Represents a particular health-related document 
 * pertaining to a single patient.</p></p>
 * 
 * <p><p>Allows the capture of patient health data in an 
 * encapsulated, contextualized manner with capability of 
 * displaying rendered content and communication between simple 
 * systems.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT230002CA.Document"})
@Hl7RootType
public class ClinicalObservationDocumentBean extends MessagePartBean implements ca.infoway.messagebuilder.model.r02_04_02.iehr.comt_mt111111ca.SHR {

    private static final long serialVersionUID = 20110407L;
    private II documentIdentifier = new IIImpl();
    private CV documentCategory = new CVImpl();
    private ST documentTitle = new STImpl();
    private SET<CV, Code> documentMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson responsiblePartyActingPerson;
    private RequestedByBean author;
    private ActingPerson informantActingPerson;
    private ServiceLocationBean custodian1ServiceDeliveryLocation;
    private EHRRepositoryBean custodian2AssignedDevice;
    private List<Recipients> primaryInformationRecipientRecipients = new ArrayList<Recipients>();
    private List<OldClinicalDocumentEventBean> predecessorOldClinicalDocumentEvent = new ArrayList<OldClinicalDocumentEventBean>();
    private DocumentContent_3 componentStructuredBodyComponentSectionComponentDocumentContent;
    private NewClinicalDocumentEventBean successorNewClinicalDocumentEvent;
    private IncludesBean subjectOf1;
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>A: Document Identifier</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getDocumentIdentifier() {
        return this.documentIdentifier.getValue();
    }
    public void setDocumentIdentifier(Identifier documentIdentifier) {
        this.documentIdentifier.setValue(documentIdentifier);
    }


    /**
     * <p>B: Document Category</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalReportDocumentType getDocumentCategory() {
        return (ClinicalReportDocumentType) this.documentCategory.getValue();
    }
    public void setDocumentCategory(ClinicalReportDocumentType documentCategory) {
        this.documentCategory.setValue(documentCategory);
    }


    /**
     * <p>J: Document Title</p>
     * 
     * <p><p>A human-readable label for this particular 
     * document.</p></p>
     * 
     * <p><p>This is a human-recognizable name intended to be 
     * displayed on the screen in list transactions and is 
     * therefore mandatory. It provides a good indication of the 
     * content of the document at a quick glance.</p></p>
     * 
     * <p><p>Titles do not necessarily need to be unique, but 
     * should be precise-enough to give a pretty good idea of what 
     * the document contains. For example &quot;Right Knee 
     * Arthroscopy Report, Jan 3, 2006&quot; would represent a good 
     * title. &quot;Surgery Report&quot; would not.</p></p>
     */
    @Hl7XmlMapping({"title"})
    public String getDocumentTitle() {
        return this.documentTitle.getValue();
    }
    public void setDocumentTitle(String documentTitle) {
        this.documentTitle.setValue(documentTitle);
    }


    /**
     * <p>E: Document Masking Indicators</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getDocumentMaskingIndicators() {
        return this.documentMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }
    public void setResponsiblePartyActingPerson(ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson responsiblePartyActingPerson) {
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


    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"informant/actingPerson"})
    public ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }
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


    @Hl7XmlMapping({"primaryInformationRecipient/recipients"})
    public List<Recipients> getPrimaryInformationRecipientRecipients() {
        return this.primaryInformationRecipientRecipients;
    }


    @Hl7XmlMapping({"predecessor/oldClinicalDocumentEvent"})
    public List<OldClinicalDocumentEventBean> getPredecessorOldClinicalDocumentEvent() {
        return this.predecessorOldClinicalDocumentEvent;
    }


    @Hl7XmlMapping({"component/structuredBody/component/section/component/documentContent"})
    public DocumentContent_3 getComponentStructuredBodyComponentSectionComponentDocumentContent() {
        return this.componentStructuredBodyComponentSectionComponentDocumentContent;
    }
    public void setComponentStructuredBodyComponentSectionComponentDocumentContent(DocumentContent_3 componentStructuredBodyComponentSectionComponentDocumentContent) {
        this.componentStructuredBodyComponentSectionComponentDocumentContent = componentStructuredBodyComponentSectionComponentDocumentContent;
    }

    public ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.ClinicalObservationDocumentBean getComponentStructuredBodyComponentSectionComponentDocumentContentAsObservation() {
        return this.componentStructuredBodyComponentSectionComponentDocumentContent instanceof ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.ClinicalObservationDocumentBean ? (ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.ClinicalObservationDocumentBean) this.componentStructuredBodyComponentSectionComponentDocumentContent : null;
    }
    public boolean hasComponentStructuredBodyComponentSectionComponentDocumentContentAsObservation() {
        return (this.componentStructuredBodyComponentSectionComponentDocumentContent instanceof ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.ClinicalObservationDocumentBean);
    }


    @Hl7XmlMapping({"successor/newClinicalDocumentEvent"})
    public NewClinicalDocumentEventBean getSuccessorNewClinicalDocumentEvent() {
        return this.successorNewClinicalDocumentEvent;
    }
    public void setSuccessorNewClinicalDocumentEvent(NewClinicalDocumentEventBean successorNewClinicalDocumentEvent) {
        this.successorNewClinicalDocumentEvent = successorNewClinicalDocumentEvent;
    }


    @Hl7XmlMapping({"subjectOf1"})
    public IncludesBean getSubjectOf1() {
        return this.subjectOf1;
    }
    public void setSubjectOf1(IncludesBean subjectOf1) {
        this.subjectOf1 = subjectOf1;
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
