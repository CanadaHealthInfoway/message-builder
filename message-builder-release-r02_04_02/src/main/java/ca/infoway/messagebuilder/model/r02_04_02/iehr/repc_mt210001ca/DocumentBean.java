/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.iehr.repc_mt210001ca;

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
import ca.infoway.messagebuilder.domainvalue.ReferralDocumentType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.OldClinicalDocumentEventBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.Recipients;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.RequestedByBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"REPC_MT210001CA.Document"})
@Hl7RootType
public class DocumentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private List<Recipients> primaryInformationRecipientRecipients = new ArrayList<Recipients>();
    private ActingPerson responsiblePartyActingPerson;
    private CV documentCategory = new CVImpl();
    private IncludesBean subjectOf;
    private List<OldClinicalDocumentEventBean> predecessorOldClinicalDocumentEvent = new ArrayList<OldClinicalDocumentEventBean>();
    private ST documentTitle = new STImpl();
    private RequestedByBean author;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private SET<CV, Code> documentMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private SectionBean componentStructuredBodyComponentSection;


    @Hl7XmlMapping({"primaryInformationRecipient/recipients"})
    public List<Recipients> getPrimaryInformationRecipientRecipients() {
        return this.primaryInformationRecipientRecipients;
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


    /**
     * <p>B: Document Category</p>
     */
    @Hl7XmlMapping({"code"})
    public ReferralDocumentType getDocumentCategory() {
        return (ReferralDocumentType) this.documentCategory.getValue();
    }
    public void setDocumentCategory(ReferralDocumentType documentCategory) {
        this.documentCategory.setValue(documentCategory);
    }


    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }


    @Hl7XmlMapping({"predecessor/oldClinicalDocumentEvent"})
    public List<OldClinicalDocumentEventBean> getPredecessorOldClinicalDocumentEvent() {
        return this.predecessorOldClinicalDocumentEvent;
    }


    /**
     * <p>J: Document Title</p>
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
     * <p>E: Document Masking Indicators</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getDocumentMaskingIndicators() {
        return this.documentMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"component/structuredBody/component/section"})
    public SectionBean getComponentStructuredBodyComponentSection() {
        return this.componentStructuredBodyComponentSection;
    }
    public void setComponentStructuredBodyComponentSection(SectionBean componentStructuredBodyComponentSection) {
        this.componentStructuredBodyComponentSection = componentStructuredBodyComponentSection;
    }

}