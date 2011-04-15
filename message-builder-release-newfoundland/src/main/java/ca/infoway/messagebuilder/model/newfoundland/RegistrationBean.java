package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;

public abstract class RegistrationBean<T> extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 4357656443876780252L;

    private BL contextConductionInd = new BLImpl(false);

    protected AssignedDeviceBean assignedDevice;

    protected T record;

    @Hl7XmlMapping("contextConductionInd")
    public boolean isContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    public void setContextConductionInd(boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }

    public abstract T getRecord();

    public void setRecord(T record) {
        this.record = record;
    }

    public abstract AssignedDeviceBean getAssignedDevice();

    public void setAssignedDevice(AssignedDeviceBean custodian) {
        this.assignedDevice = custodian;
    }
}
