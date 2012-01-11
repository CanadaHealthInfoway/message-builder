/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DeviceDispenseInstructionsBean;

@Hl7PartTypeMapping("PORX_MT060060CA.DevicePrescription")
public class DevicePrescriptionBean extends BasePrescriptionBean implements Serializable {

    private static final long serialVersionUID = 3613897949104613049L;

    private ClinicalDeviceBean directTarget;

    private DeviceDispenseInstructionsBean dispenseInstructions;

    @Hl7XmlMapping("component2/supplyRequest")
    public DeviceDispenseInstructionsBean getDispenseInstructions() {
        return dispenseInstructions;
    }

    public void setDispenseInstructions(DeviceDispenseInstructionsBean dispenseInstructions) {
        this.dispenseInstructions = dispenseInstructions;
    }

    @Hl7XmlMapping("directTarget/manufacturedProduct/manufacturedClinicalDevice")
    public ClinicalDeviceBean getDirectTarget() {
        return directTarget;
    }

    public void setDirectTarget(ClinicalDeviceBean directTarget) {
        this.directTarget = directTarget;
    }
}
