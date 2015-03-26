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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.prpm_mt309000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPM_MT309000CA.Location"})
public class LocationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private INT sequenceNumber = new INTImpl();
    private ServiceDeliveryLocationBean serviceDeliveryLocation;


    /**
     * <p>Business Name: Order of Service Delivery Locations</p>
     * 
     * <p>Relationship: PRPM_MT309000CA.Location.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows each Service Delivery Location to be sequentially 
     * listed.</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: Order of Service Delivery Locations</p>
     * 
     * <p>Relationship: PRPM_MT309000CA.Location.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows each Service Delivery Location to be sequentially 
     * listed.</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: 
     * PRPM_MT309000CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getServiceDeliveryLocation() {
        return this.serviceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT309000CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setServiceDeliveryLocation(ServiceDeliveryLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

}
