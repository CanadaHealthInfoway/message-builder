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
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.DispenseShipToLocationBean;



@Hl7PartTypeMapping({"PRPM_MT301010CA.Location","PRPM_MT303010CA.Location"})
public class Location_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private INT sequenceNumber = new INTImpl();
    private DispenseShipToLocationBean serviceDeliveryLocation;


    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    @Hl7XmlMapping({"serviceDeliveryLocation"})
    public DispenseShipToLocationBean getServiceDeliveryLocation() {
        return this.serviceDeliveryLocation;
    }
    public void setServiceDeliveryLocation(DispenseShipToLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

}
