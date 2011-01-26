/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt141007ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Device Product</p>
 * 
 * <p><p>A medical device product intended to be supplied 
 * and/or used by a patient. Encompasses supplies, aids, 
 * etc.</p></p>
 * 
 * <p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>Allows devices to be clearly described and referenced. 
 * Also allows searching for and examining information about 
 * devices that can be or are being used by a patient.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT141007CA.ManufacturedProduct"})
@Hl7RootType
public class DeviceProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private ST deviceDescription = new STImpl();
    private CV deviceCode = new CVImpl();
    private ST deviceName = new STImpl();
    private BL manufacturedClinicalDeviceAsContentContainerPackagedDevice = new BLImpl();
    private INT devicePackageQuantity = new INTImpl();


    /**
     * <p>C:Device Description</p>
     * 
     * <p><p>A free form textual description of a device and its 
     * characteristics (e.g. size, shape, etc.). This is used when 
     * additional information must be conveyed that is not apparent 
     * by just specifying code and name.</p></p>
     * 
     * <p><p>Allows description of characteristics of the device 
     * not necessarily conveyed by the code or name.</p></p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/desc"})
    public String getDeviceDescription() {
        return this.deviceDescription.getValue();
    }
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription.setValue(deviceDescription);
    }


    /**
     * <p>A:Device Code</p>
     * 
     * <p><p>An identifier for a type of device.</p></p>
     * 
     * <p><p>Used to ensure clear communication by uniquely 
     * identifying a particular device product when prescribing or 
     * dispensing. This attribute is only marked as 'populated' 
     * because some devices will not have codes associated with 
     * them.</p></p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/code"})
    public Code getDeviceCode() {
        return (Code) this.deviceCode.getValue();
    }
    public void setDeviceCode(Code deviceCode) {
        this.deviceCode.setValue(deviceCode);
    }


    /**
     * <p>B:Device Name</p>
     * 
     * <p><p>The name assigned to a type of device.</p></p>
     * 
     * <p><p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. If a 
     * code is available, the name acts as a cross-check. If the 
     * code is not available the name acts as the primary 
     * identifier. The attribute is therefore mandatory.</p></p>
     * 
     * <p><p>First occurrence is preferred for display.</p></p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/name"})
    public String getDeviceName() {
        return this.deviceName.getValue();
    }
    public void setDeviceName(String deviceName) {
        this.deviceName.setValue(deviceName);
    }


    @Hl7XmlMapping({"manufacturedClinicalDevice/asContent/containerPackagedDevice"})
    public Boolean getManufacturedClinicalDeviceAsContentContainerPackagedDevice() {
        return this.manufacturedClinicalDeviceAsContentContainerPackagedDevice.getValue();
    }
    public void setManufacturedClinicalDeviceAsContentContainerPackagedDevice(Boolean manufacturedClinicalDeviceAsContentContainerPackagedDevice) {
        this.manufacturedClinicalDeviceAsContentContainerPackagedDevice.setValue(manufacturedClinicalDeviceAsContentContainerPackagedDevice);
    }


    /**
     * <p>F:Device Package Quantity</p>
     * 
     * <p><p>The quantity of devices contained in the package given 
     * or to be given to the patient.</p></p>
     * 
     * <p><p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p><p>Attribute is marked 
     * as &quot;mandatory&quot; to ensure that quantity in a 
     * package is always known.</p></p>
     * 
     * <p><p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p><p>Attribute is marked 
     * as &quot;mandatory&quot; to ensure that quantity in a 
     * package is always known.</p></p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/asContent/quantity"})
    public Integer getDevicePackageQuantity() {
        return this.devicePackageQuantity.getValue();
    }
    public void setDevicePackageQuantity(Integer devicePackageQuantity) {
        this.devicePackageQuantity.setValue(devicePackageQuantity);
    }

}
