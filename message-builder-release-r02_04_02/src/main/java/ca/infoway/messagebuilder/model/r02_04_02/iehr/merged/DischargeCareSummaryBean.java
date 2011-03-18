/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.iehr.merged;

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
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>DischargeCareSummary</p>
 * 
 * <p>REPC_MT220001CA.Document: Discharge-Care Summary</p>
 * 
 * <p><p>Represents a particular health-related document 
 * pertaining to a single patient.</p></p>
 * 
 * <p><p>Allows the capture of patient health data in an 
 * encapsulated, contextualized manner with capability of 
 * displaying rendered content and communication between simple 
 * systems.</p></p>
 * 
 * <p>REPC_MT220003CA.Document: Discharge-Care Summary</p>
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
@Hl7PartTypeMapping({"REPC_MT220001CA.Document","REPC_MT220003CA.Document"})
@Hl7RootType
public class DischargeCareSummaryBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private List<Recipients> primaryInformationRecipientRecipients = new ArrayList<Recipients>();
    private CV documentCategory = new CVImpl();
    private IncludesBean subjectOf1;
    private List<OldClinicalDocumentEventBean> predecessorOldClinicalDocumentEvent = new ArrayList<OldClinicalDocumentEventBean>();
    private SectionBean componentStructuredBodyComponentSection;
    private ST documentTitle = new STImpl();
    private RequestedByBean author;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private SET<CV, Code> documentMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private BL subjectOf2AnnotationIndicator = new BLImpl();
    private SET<II, Identifier> documentIdentifiers = new SETImpl<II, Identifier>(IIImpl.class);
    private ActingPerson responsiblePartyActingPerson;
    private ServiceLocationBean custodian1ServiceDeliveryLocation;
    private EHRRepositoryBean custodian2AssignedDevice;
    private NewClinicalDocumentEventBean successorNewClinicalDocumentEvent;


    @Hl7XmlMapping({"primaryInformationRecipient/recipients"})
    public List<Recipients> getPrimaryInformationRecipientRecipients() {
        return this.primaryInformationRecipientRecipients;
    }


    /**
     * <p>DocumentCategory</p>
     * 
     * <p>B: Document Category</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public CareSummaryDocumentType getDocumentCategory() {
        return (CareSummaryDocumentType) this.documentCategory.getValue();
    }
    public void setDocumentCategory(CareSummaryDocumentType documentCategory) {
        this.documentCategory.setValue(documentCategory);
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


    /**
     * <p>DocumentTitle</p>
     * 
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


    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }


    /**
     * <p>DocumentMaskingIndicators</p>
     * 
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


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>DocumentIdentifiers</p>
     * 
     * <p>A: Document Identifiers</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getDocumentIdentifiers() {
        return this.documentIdentifiers.rawSet();
    }


    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }
    public void setResponsiblePartyActingPerson(ActingPerson responsiblePartyActingPerson) {
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

}
