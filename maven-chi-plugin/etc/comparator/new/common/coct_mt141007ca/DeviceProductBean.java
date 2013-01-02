/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt141007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDeviceEntity;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Device Product 
 * 
 * <p>A medical device product intended to be supplied and/or 
 * used by a patient. Encompasses supplies, aids, etc. 
 * 
 * <p>Allows devices to be clearly described and referenced. 
 * Also allows searching for and examining information about 
 * devices that can be or are being used by a patient. 
 * 
 * <p>A_BillablePharmacyDispense 
 */
@Hl7PartTypeMapping({"COCT_MT141007CA.ManufacturedProduct"})
@Hl7RootType
public class DeviceProductBean extends MessagePartBean {

    private CV<ClinicalDeviceEntity> deviceCode = new CVImpl<ClinicalDeviceEntity>();
    private ST deviceName = new STImpl();
    private ST deviceDescription = new STImpl();
    private INT devicePackageQuantity = new INTImpl();
    private DevicePackageBean manufacturedClinicalDeviceAsContentContainerPackagedDevice = new DevicePackageBean();

    @Hl7XmlMapping({"manufacturedClinicalDevice/code"})
    public ClinicalDeviceEntity getDeviceCode() {
        return this.deviceCode.getValue();
    }
    public void setDeviceCode(ClinicalDeviceEntity deviceCode) {
        this.deviceCode.setValue(deviceCode);
    }

    @Hl7XmlMapping({"manufacturedClinicalDevice/name"})
    public java.lang.String getDeviceName() {
        return this.deviceName.getValue();
    }
    public void setDeviceName(java.lang.String deviceName) {
        this.deviceName.setValue(deviceName);
    }

    @Hl7XmlMapping({"manufacturedClinicalDevice/desc"})
    public java.lang.String getDeviceDescription() {
        return this.deviceDescription.getValue();
    }
    public void setDeviceDescription(java.lang.String deviceDescription) {
        this.deviceDescription.setValue(deviceDescription);
    }

    @Hl7XmlMapping({"manufacturedClinicalDevice/asContent/quantity"})
    public java.lang.Integer getDevicePackageQuantity() {
        return this.devicePackageQuantity.getValue();
    }
    public void setDevicePackageQuantity(java.lang.Integer devicePackageQuantity) {
        this.devicePackageQuantity.setValue(devicePackageQuantity);
    }

    @Hl7XmlMapping({"manufacturedClinicalDevice/asContent/containerPackagedDevice"})
    public DevicePackageBean getManufacturedClinicalDeviceAsContentContainerPackagedDevice() {
        return this.manufacturedClinicalDeviceAsContentContainerPackagedDevice;
    }
    public void setManufacturedClinicalDeviceAsContentContainerPackagedDevice(DevicePackageBean manufacturedClinicalDeviceAsContentContainerPackagedDevice) {
        this.manufacturedClinicalDeviceAsContentContainerPackagedDevice = manufacturedClinicalDeviceAsContentContainerPackagedDevice;
    }

}
