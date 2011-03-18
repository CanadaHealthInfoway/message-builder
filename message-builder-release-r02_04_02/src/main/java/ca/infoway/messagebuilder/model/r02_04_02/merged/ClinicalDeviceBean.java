/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.ClinicalDevice","FICR_MT400003CA.ClinicalDevice","FICR_MT400004CA.ClinicalDevice","FICR_MT490101CA.ClinicalDevice","FICR_MT490102CA.ClinicalDevice"})
public class ClinicalDeviceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV deviceCode = new CVImpl();
    private ST deviceName = new STImpl();
    private ST deviceDescription = new STImpl();


    /**
     * <p>DeviceCode</p>
     * 
     * <p>Device Code</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getDeviceCode() {
        return (Code) this.deviceCode.getValue();
    }
    public void setDeviceCode(Code deviceCode) {
        this.deviceCode.setValue(deviceCode);
    }


    /**
     * <p>DeviceName</p>
     * 
     * <p>Device Name</p>
     */
    @Hl7XmlMapping({"name"})
    public String getDeviceName() {
        return this.deviceName.getValue();
    }
    public void setDeviceName(String deviceName) {
        this.deviceName.setValue(deviceName);
    }


    /**
     * <p>DeviceDescription</p>
     * 
     * <p>Device Description</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDeviceDescription() {
        return this.deviceDescription.getValue();
    }
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription.setValue(deviceDescription);
    }

}
