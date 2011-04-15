package ca.infoway.messagebuilder.model.newfoundland.referrals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ReferralDocumentType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedDeviceBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;

public abstract class ReferralDocumentBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 9195021250287583366L;

    private CD referralDocumentType = new CDImpl();

    private ST title = new STImpl();

    private final List<CV> confidentialityCodes = Collections.synchronizedList(new ArrayList<CV>());

    private PatientCareProvisionRequestBean patientCareProvisionRequestBean = new PatientCareProvisionRequestBean();

    private AuthorBean author;

    private AssignedPersonBean responsibleParty;

    private ServiceDeliveryLocationBean location;

    private AssignedDeviceBean assignedDevice;

    private final List<AssignedPersonBean> recipients = Collections.synchronizedList(new ArrayList<AssignedPersonBean>());

    private final List<NoteBean> notes = Collections.synchronizedList(new ArrayList<NoteBean>());

    public ReferralDocumentBean() {
        super();
    }

    @Hl7XmlMapping("code")
    public final ReferralDocumentType getReferralDocumentType() {
        return (ReferralDocumentType) this.referralDocumentType.getValue();
    }

    public final void setReferralDocumentType(ReferralDocumentType referralDocumentType) {
        this.referralDocumentType.setValue(referralDocumentType);
    }

    @Hl7XmlMapping("title")
    public final String getTitle() {
        return this.title.getValue();
    }

    public final void setTitle(String title) {
        this.title.setValue(title);
    }

    @Hl7XmlMapping("author")
    public final AuthorBean getAuthor() {
        return author;
    }

    public final void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({ "responsibleParty/actingPerson", "responsibleParty" })
    public final AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public final void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping("custodian1/serviceDeliveryLocation")
    public final ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public final void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("custodian2/assignedDevice")
    public final AssignedDeviceBean getAssignedDevice() {
        return assignedDevice;
    }

    public final void setAssignedDevice(AssignedDeviceBean assignedDevice) {
        this.assignedDevice = assignedDevice;
    }

    public List<x_VeryBasicConfidentialityKind> getConfidentialityCodes() {
    	return new RawListWrapper<CV, x_VeryBasicConfidentialityKind>(this.confidentialityCodes, CVImpl.class);
    }

    @Hl7XmlMapping("component/structuredBody/component/section/component1/documentContent")
    public PatientCareProvisionRequestBean getPatientCareProvisionRequestBean() {
        return patientCareProvisionRequestBean;
    }

    public void setPatientCareProvisionRequestBean(PatientCareProvisionRequestBean patientCareProvisionRequestBean) {
        this.patientCareProvisionRequestBean = patientCareProvisionRequestBean;
    }

    @Hl7XmlMapping("primaryInformationRecipient/recipients")
    public final List<AssignedPersonBean> getRecipients() {
        return recipients;
    }

    @Hl7XmlMapping("subjectOf/annotation")
    public List<NoteBean> getNotes() {
        return notes;
    }
}
