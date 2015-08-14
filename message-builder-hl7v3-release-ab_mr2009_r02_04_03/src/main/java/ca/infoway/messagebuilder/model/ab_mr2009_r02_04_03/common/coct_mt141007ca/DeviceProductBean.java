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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt141007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.domainvalue.MedicalDeviceType;



/**
 * <p>Business Name: Device Product</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Allows devices to be clearly described and referenced. 
 * Also allows searching for and examining information about 
 * devices that can be or are being used by a patient.</p>
 * 
 * <p>A medical device product intended to be supplied and/or 
 * used by a patient. Encompasses supplies, aids, etc.</p>
 */
@Hl7PartTypeMapping({"COCT_MT141007CA.ManufacturedProduct"})
@Hl7RootType
public class DeviceProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20150814L;
    private CV manufacturedClinicalDeviceCode = new CVImpl();
    private ST manufacturedClinicalDeviceName = new STImpl();
    private ST manufacturedClinicalDeviceDesc = new STImpl();
    private INT manufacturedClinicalDeviceAsContentQuantity = new INTImpl();


    /**
     * <p>Business Name: A:Device Code</p>
     * 
     * <p>Relationship: COCT_MT141007CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular device product when prescribing or 
     * dispensing. This attribute is only marked as 'populated' 
     * because some devices will not have codes associated with 
     * them.</p>
     * 
     * <p>An identifier for a type of device.</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/code"})
    public MedicalDeviceType getManufacturedClinicalDeviceCode() {
        return (MedicalDeviceType) this.manufacturedClinicalDeviceCode.getValue();
    }

    /**
     * <p>Business Name: A:Device Code</p>
     * 
     * <p>Relationship: COCT_MT141007CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular device product when prescribing or 
     * dispensing. This attribute is only marked as 'populated' 
     * because some devices will not have codes associated with 
     * them.</p>
     * 
     * <p>An identifier for a type of device.</p>
     */
    public void setManufacturedClinicalDeviceCode(MedicalDeviceType manufacturedClinicalDeviceCode) {
        this.manufacturedClinicalDeviceCode.setValue(manufacturedClinicalDeviceCode);
    }


    /**
     * <p>Business Name: B:Device Name</p>
     * 
     * <p>Relationship: COCT_MT141007CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. If a 
     * code is available, the name acts as a cross-check. If the 
     * code is not available the name acts as the primary 
     * identifier. The attribute is therefore mandatory.</p>
     * 
     * <p>First occurrence is preferred for display.</p>
     * 
     * <p>The name assigned to a type of device.</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/name"})
    public String getManufacturedClinicalDeviceName() {
        return this.manufacturedClinicalDeviceName.getValue();
    }

    /**
     * <p>Business Name: B:Device Name</p>
     * 
     * <p>Relationship: COCT_MT141007CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. If a 
     * code is available, the name acts as a cross-check. If the 
     * code is not available the name acts as the primary 
     * identifier. The attribute is therefore mandatory.</p>
     * 
     * <p>First occurrence is preferred for display.</p>
     * 
     * <p>The name assigned to a type of device.</p>
     */
    public void setManufacturedClinicalDeviceName(String manufacturedClinicalDeviceName) {
        this.manufacturedClinicalDeviceName.setValue(manufacturedClinicalDeviceName);
    }


    /**
     * <p>Business Name: C:Device Description</p>
     * 
     * <p>Relationship: COCT_MT141007CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows description of characteristics of the device not 
     * necessarily conveyed by the code or name.</p>
     * 
     * <p>A free form textual description of a device and its 
     * characteristics (e.g. size, shape, etc.). This is used when 
     * additional information must be conveyed that is not apparent 
     * by just specifying code and name.</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/desc"})
    public String getManufacturedClinicalDeviceDesc() {
        return this.manufacturedClinicalDeviceDesc.getValue();
    }

    /**
     * <p>Business Name: C:Device Description</p>
     * 
     * <p>Relationship: COCT_MT141007CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows description of characteristics of the device not 
     * necessarily conveyed by the code or name.</p>
     * 
     * <p>A free form textual description of a device and its 
     * characteristics (e.g. size, shape, etc.). This is used when 
     * additional information must be conveyed that is not apparent 
     * by just specifying code and name.</p>
     */
    public void setManufacturedClinicalDeviceDesc(String manufacturedClinicalDeviceDesc) {
        this.manufacturedClinicalDeviceDesc.setValue(manufacturedClinicalDeviceDesc);
    }


    /**
     * <p>Business Name: F:Device Package Quantity</p>
     * 
     * <p>Relationship: COCT_MT141007CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p><p>Attribute is marked 
     * as &quot;mandatory&quot; to ensure that quantity in a 
     * package is always known.</p>
     * 
     * <p>The quantity of devices contained in the package given or 
     * to be given to the patient.</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice/asContent/quantity"})
    public Integer getManufacturedClinicalDeviceAsContentQuantity() {
        return this.manufacturedClinicalDeviceAsContentQuantity.getValue();
    }

    /**
     * <p>Business Name: F:Device Package Quantity</p>
     * 
     * <p>Relationship: COCT_MT141007CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p><p>Attribute is marked 
     * as &quot;mandatory&quot; to ensure that quantity in a 
     * package is always known.</p>
     * 
     * <p>The quantity of devices contained in the package given or 
     * to be given to the patient.</p>
     */
    public void setManufacturedClinicalDeviceAsContentQuantity(Integer manufacturedClinicalDeviceAsContentQuantity) {
        this.manufacturedClinicalDeviceAsContentQuantity.setValue(manufacturedClinicalDeviceAsContentQuantity);
    }

}
