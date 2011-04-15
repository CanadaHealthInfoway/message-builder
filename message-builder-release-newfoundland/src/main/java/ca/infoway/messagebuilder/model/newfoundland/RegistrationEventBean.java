package ca.infoway.messagebuilder.model.newfoundland;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping({ "MFMI_MT700726CA.Subject2" })
public class RegistrationEventBean<T> extends RegistrationBean<T> {

    private static final long serialVersionUID = 7819655724847295114L;

    @Override
    @Hl7XmlMapping("registrationEvent/subject/registeredRole")
    public T getRecord() {
        return record;
    }

    @Override
    @Hl7XmlMapping("registrationEvent/custodian/assignedDevice")
    public AssignedDeviceBean getAssignedDevice() {
        return this.assignedDevice;
    }
}
