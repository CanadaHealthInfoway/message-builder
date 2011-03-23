package ca.infoway.messagebuilder.model.mock;

import java.util.LinkedHashSet;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping({ "MFMI_MT700711CA.Subject2", "MFMI_MT700716CA.Subject2" })
public class RegistrationRequestBean<RR> {

    private static final long serialVersionUID = -6919002674167520092L;

    private final Set<ReplacementOfBean> priorRegistrations = new LinkedHashSet<ReplacementOfBean>();

    protected AssignedDeviceBean assignedDevice;

    protected RR record;

    public void setRecord(RR record) {
        this.record = record;
    }

    public void setAssignedDevice(AssignedDeviceBean custodian) {
        this.assignedDevice = custodian;
    }
    
    
    @Hl7XmlMapping("registrationRequest/subject/registeredRole")
    public RR getRecord() {
        return this.record;
    }

    @Hl7XmlMapping("registrationRequest/custodian/assignedDevice")
    public AssignedDeviceBean getAssignedDevice() {
        return this.assignedDevice;
    }

    @Hl7XmlMapping("registrationRequest/replacementOf")
    public Set<ReplacementOfBean> getPriorRegistrations() {
        return priorRegistrations;
    }
}
