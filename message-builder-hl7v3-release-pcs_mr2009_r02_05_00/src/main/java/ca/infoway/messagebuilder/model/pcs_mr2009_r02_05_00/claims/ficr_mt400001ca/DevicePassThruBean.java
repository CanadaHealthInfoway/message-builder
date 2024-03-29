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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.ficr_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.ClinicalDeviceBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.DevicePassThru"})
public class DevicePassThruBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged.SpecialAuthorizationChoice_1 {

    private static final long serialVersionUID = 20190731L;
    private ClinicalDeviceBean directTargetManufacturedProductManufacturedClinicalDevice;


    /**
     * <p>Relationship: 
     * FICR_MT400001CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"directTarget/manufacturedProduct/manufacturedClinicalDevice"})
    public ClinicalDeviceBean getDirectTargetManufacturedProductManufacturedClinicalDevice() {
        return this.directTargetManufacturedProductManufacturedClinicalDevice;
    }

    /**
     * <p>Relationship: 
     * FICR_MT400001CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setDirectTargetManufacturedProductManufacturedClinicalDevice(ClinicalDeviceBean directTargetManufacturedProductManufacturedClinicalDevice) {
        this.directTargetManufacturedProductManufacturedClinicalDevice = directTargetManufacturedProductManufacturedClinicalDevice;
    }

}
