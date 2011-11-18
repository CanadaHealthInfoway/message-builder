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

    private static final long serialVersionUID = 20111117L;
    private CV manufacturedClinicalDeviceCode = new CVImpl();
    private ST manufacturedClinicalDeviceName = new STImpl();
    private ST manufacturedClinicalDeviceDesc = new STImpl();
    private INT manufacturedClinicalDeviceAsContentQuantity = new INTImpl();


    /**
     * <p>A:Device Code</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/code"})
    public ClinicalDeviceEntity getManufacturedClinicalDeviceCode() {
        return (ClinicalDeviceEntity) this.manufacturedClinicalDeviceCode.getValue();
    }
    public void setManufacturedClinicalDeviceCode(ClinicalDeviceEntity manufacturedClinicalDeviceCode) {
        this.manufacturedClinicalDeviceCode.setValue(manufacturedClinicalDeviceCode);
    }


    /**
     * <p>B:Device Name</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/name"})
    public String getManufacturedClinicalDeviceName() {
        return this.manufacturedClinicalDeviceName.getValue();
    }
    public void setManufacturedClinicalDeviceName(String manufacturedClinicalDeviceName) {
        this.manufacturedClinicalDeviceName.setValue(manufacturedClinicalDeviceName);
    }


    /**
     * <p>C:Device Description</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/desc"})
    public String getManufacturedClinicalDeviceDesc() {
        return this.manufacturedClinicalDeviceDesc.getValue();
    }
    public void setManufacturedClinicalDeviceDesc(String manufacturedClinicalDeviceDesc) {
        this.manufacturedClinicalDeviceDesc.setValue(manufacturedClinicalDeviceDesc);
    }


    /**
     * <p>F:Device Package Quantity</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/asContent/quantity"})
    public Integer getManufacturedClinicalDeviceAsContentQuantity() {
        return this.manufacturedClinicalDeviceAsContentQuantity.getValue();
    }
    public void setManufacturedClinicalDeviceAsContentQuantity(Integer manufacturedClinicalDeviceAsContentQuantity) {
        this.manufacturedClinicalDeviceAsContentQuantity.setValue(manufacturedClinicalDeviceAsContentQuantity);
    }

}
