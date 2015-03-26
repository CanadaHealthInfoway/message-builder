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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt400003ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.ClinicalDeviceBean;



@Hl7PartTypeMapping({"FICR_MT400003CA.DevicePassThru"})
public class DevicePassThruBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.SpecialAuthorizationChoice_2 {

    private static final long serialVersionUID = 20150326L;
    private ClinicalDeviceBean directTargetManufacturedProductManufacturedClinicalDevice;


    /**
     * <p>Relationship: 
     * FICR_MT400003CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"directTarget/manufacturedProduct/manufacturedClinicalDevice"})
    public ClinicalDeviceBean getDirectTargetManufacturedProductManufacturedClinicalDevice() {
        return this.directTargetManufacturedProductManufacturedClinicalDevice;
    }

    /**
     * <p>Relationship: 
     * FICR_MT400003CA.ManufacturedProduct.manufacturedClinicalDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setDirectTargetManufacturedProductManufacturedClinicalDevice(ClinicalDeviceBean directTargetManufacturedProductManufacturedClinicalDevice) {
        this.directTargetManufacturedProductManufacturedClinicalDevice = directTargetManufacturedProductManufacturedClinicalDevice;
    }

}
