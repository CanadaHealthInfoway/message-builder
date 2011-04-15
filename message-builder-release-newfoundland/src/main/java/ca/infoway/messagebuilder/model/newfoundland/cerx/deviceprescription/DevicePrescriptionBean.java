package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DeviceDispenseInstructionsBean;

@Hl7PartTypeMapping("PORX_MT060060CA.DevicePrescription")
public class DevicePrescriptionBean extends BasePrescriptionBean implements Serializable {

    private static final long serialVersionUID = 3613897949104613049L;

    private ClinicalDeviceBean directTarget;

    private DeviceDispenseInstructionsBean dispenseInstructions;

    @Hl7XmlMapping("component2/supplyRequest")
    public DeviceDispenseInstructionsBean getDispenseInstructions() {
        return dispenseInstructions;
    }

    public void setDispenseInstructions(DeviceDispenseInstructionsBean dispenseInstructions) {
        this.dispenseInstructions = dispenseInstructions;
    }

    @Hl7XmlMapping("directTarget/manufacturedProduct/manufacturedClinicalDevice")
    public ClinicalDeviceBean getDirectTarget() {
        return directTarget;
    }

    public void setDirectTarget(ClinicalDeviceBean directTarget) {
        this.directTarget = directTarget;
    }
}
