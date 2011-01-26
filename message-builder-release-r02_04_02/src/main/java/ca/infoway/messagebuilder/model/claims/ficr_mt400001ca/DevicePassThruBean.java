/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.ClinicalDeviceBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.DevicePassThru"})
public class DevicePassThruBean extends MessagePartBean implements ca.infoway.messagebuilder.model.claims.merged.SpecialAuthorizationChoice {

    private static final long serialVersionUID = 20110126L;
    private ClinicalDeviceBean directTargetManufacturedProductManufacturedClinicalDevice;


    @Hl7XmlMapping({"directTarget/manufacturedProduct/manufacturedClinicalDevice"})
    public ClinicalDeviceBean getDirectTargetManufacturedProductManufacturedClinicalDevice() {
        return this.directTargetManufacturedProductManufacturedClinicalDevice;
    }
    public void setDirectTargetManufacturedProductManufacturedClinicalDevice(ClinicalDeviceBean directTargetManufacturedProductManufacturedClinicalDevice) {
        this.directTargetManufacturedProductManufacturedClinicalDevice = directTargetManufacturedProductManufacturedClinicalDevice;
    }

}
