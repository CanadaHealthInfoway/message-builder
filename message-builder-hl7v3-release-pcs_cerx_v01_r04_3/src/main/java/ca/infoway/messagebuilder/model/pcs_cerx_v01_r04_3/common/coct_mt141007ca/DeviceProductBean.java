/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt141007ca;

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



@Hl7PartTypeMapping({"COCT_MT141007CA.ManufacturedProduct"})
@Hl7RootType
public class DeviceProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV deviceCode = new CVImpl();
    private ST deviceName = new STImpl();
    private ST deviceDescription = new STImpl();
    private INT devicePackageQuantity = new INTImpl();


    /**
     * <p>A:Device Code</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/code"})
    public ClinicalDeviceEntity getDeviceCode() {
        return (ClinicalDeviceEntity) this.deviceCode.getValue();
    }
    public void setDeviceCode(ClinicalDeviceEntity deviceCode) {
        this.deviceCode.setValue(deviceCode);
    }


    /**
     * <p>B:Device Name</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/name"})
    public String getDeviceName() {
        return this.deviceName.getValue();
    }
    public void setDeviceName(String deviceName) {
        this.deviceName.setValue(deviceName);
    }


    /**
     * <p>C:Device Description</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/desc"})
    public String getDeviceDescription() {
        return this.deviceDescription.getValue();
    }
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription.setValue(deviceDescription);
    }


    /**
     * <p>F:Device Package Quantity</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/asContent/quantity"})
    public Integer getDevicePackageQuantity() {
        return this.devicePackageQuantity.getValue();
    }
    public void setDevicePackageQuantity(Integer devicePackageQuantity) {
        this.devicePackageQuantity.setValue(devicePackageQuantity);
    }

}
