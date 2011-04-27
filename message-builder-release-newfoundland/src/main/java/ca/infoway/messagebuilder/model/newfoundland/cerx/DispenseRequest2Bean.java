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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;

@Hl7PartTypeMapping({ "PORX_MT020060CA.DeviceDispense_V01R04_3_HOTFIX3" })
public class DispenseRequest2Bean extends BaseDispenseRequestBean implements Serializable {

    private static final long serialVersionUID = -2095634015394561160L;

    private SupplyEventBean supplyEvent;

    private ST usageInstructions = new STImpl();
    
    private SimpleDeviceRequestBean deviceRequestBean;


    @Hl7XmlMapping("component1/procedureRequest/text")
    public String getUsageInstructions() {
        return this.usageInstructions.getValue();
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions.setValue(usageInstructions);
    }

    @Hl7XmlMapping({ "component2/supplyEvent"})
    public SupplyEventBean getSupplyEvent() {
        return supplyEvent;
    }

    public void setSupplyEvent(SupplyEventBean supplyEvent) {
        this.supplyEvent = supplyEvent;
    }

    @Hl7XmlMapping({ "inFulfillmentOf/deviceRequest" })
    public SimpleDeviceRequestBean getSimpleDeviceRequestBean() {
        return deviceRequestBean;
    }

    public void setSimpleDeviceRequestBean(SimpleDeviceRequestBean deviceRequestBean) {
        this.deviceRequestBean = deviceRequestBean;
    }

}
