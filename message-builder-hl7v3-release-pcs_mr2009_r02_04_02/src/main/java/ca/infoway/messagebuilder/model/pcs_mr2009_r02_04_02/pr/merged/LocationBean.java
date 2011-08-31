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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPM_MT306011CA.Location","PRPM_MT309000CA.Location"})
public class LocationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private INT orderOfServiceDeliveryLocations = new INTImpl();
    private ServiceDeliveryLocationBean serviceDeliveryLocation;


    /**
     * <p>OrderOfServiceDeliveryLocations</p>
     * 
     * <p>Order of Service Delivery Locations</p>
     * 
     * <p><p>Allows each Service Delivery Location to be 
     * sequentially listed.</p></p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getOrderOfServiceDeliveryLocations() {
        return this.orderOfServiceDeliveryLocations.getValue();
    }
    public void setOrderOfServiceDeliveryLocations(Integer orderOfServiceDeliveryLocations) {
        this.orderOfServiceDeliveryLocations.setValue(orderOfServiceDeliveryLocations);
    }


    @Hl7XmlMapping({"serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getServiceDeliveryLocation() {
        return this.serviceDeliveryLocation;
    }
    public void setServiceDeliveryLocation(ServiceDeliveryLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

}