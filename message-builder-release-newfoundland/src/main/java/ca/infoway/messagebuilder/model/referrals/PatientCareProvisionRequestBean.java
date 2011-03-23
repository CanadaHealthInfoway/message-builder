package ca.infoway.messagebuilder.model.referrals;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareProvisionRequestType;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.x_ActStatusActiveComplete;
import ca.infoway.messagebuilder.model.AssignedPersonBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBean;

@Hl7PartTypeMapping("REPC_MT210001CA.PatientCareProvisionRequest")
public class PatientCareProvisionRequestBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 9195021250287583366L;

    private CD patientCareProvisionRequestType = new CDImpl();

    private CD statusCode = new CDImpl();

    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    private AssignedPersonBean performer = new AssignedPersonBean();

    private ServiceDeliveryLocationBean referralServiceLocation;

    private CD professionalServiceCode = new CDImpl();

    private II patientCareProvisionEventId = new IIImpl();

    public PatientCareProvisionRequestBean() {
        super();
    }

    @Hl7XmlMapping("code")
    public ActCareProvisionRequestType getPatientCareProvisionRequestType() {
        return (ActCareProvisionRequestType) this.patientCareProvisionRequestType.getValue();
    }

    public void setPatientCareProvisionRequestType(ActCareProvisionRequestType patientCareProvisionRequestType) {
        this.patientCareProvisionRequestType.setValue(patientCareProvisionRequestType);
    }

    @Hl7XmlMapping("statusCode")
    public x_ActStatusActiveComplete getStatusCode() {
        return (x_ActStatusActiveComplete) this.statusCode.getValue();
    }

    public void setStatusCode(x_ActStatusActiveComplete statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("performer/assignedEntity")
    public AssignedPersonBean getPerformer() {
        return performer;
    }

    public void setPerformer(AssignedPersonBean performer) {
        this.performer = performer;
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getReferralServiceLocation() {
        return referralServiceLocation;
    }

    public void setReferralServiceLocation(ServiceDeliveryLocationBean referralServiceLocation) {
        this.referralServiceLocation = referralServiceLocation;
    }

    @Hl7XmlMapping("component/actRequest/code")
    public ActProfessionalServiceCode getProfessionalServiceCode() {
        return (ActProfessionalServiceCode) this.professionalServiceCode.getValue();
    }

    public void setProfessionalServiceCode(ActProfessionalServiceCode professionalServiceCode) {
        this.professionalServiceCode.setValue(professionalServiceCode);
    }

    @Hl7XmlMapping("fulfillment/patientCareProvisionEvent/id")
    public Identifier getPatientCareProvisionEventId() {
        return this.patientCareProvisionEventId.getValue();
    }

    public void setPatientCareProvisionEventId(Identifier patientCareProvisionEventId) {
        this.patientCareProvisionEventId.setValue(patientCareProvisionEventId);
    }
}
