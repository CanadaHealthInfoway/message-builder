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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: DeviceProduct</p>
 * 
 * <p>COCT_MT141007CA.ManufacturedProduct: Device Product</p>
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
@Hl7PartTypeMapping({"COCT_MT141007CA.ManufacturedProduct","FICR_MT400001CA.ManufacturedProduct","FICR_MT400003CA.ManufacturedProduct","FICR_MT400004CA.ManufacturedProduct","FICR_MT490101CA.ManufacturedProduct","FICR_MT490102CA.ManufacturedProduct"})
@Hl7RootType
public class DeviceProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private DeviceBean manufacturedClinicalDevice;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT141007CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"manufacturedClinicalDevice"})
    public DeviceBean getManufacturedClinicalDevice() {
        return this.manufacturedClinicalDevice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT141007CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setManufacturedClinicalDevice(DeviceBean manufacturedClinicalDevice) {
        this.manufacturedClinicalDevice = manufacturedClinicalDevice;
    }

}
