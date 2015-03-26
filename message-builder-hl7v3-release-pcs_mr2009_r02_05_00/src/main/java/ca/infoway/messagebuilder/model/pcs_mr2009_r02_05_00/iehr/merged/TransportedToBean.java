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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.OccurredAtBean;



/**
 * <p>Business Name: TransportedTo</p>
 * 
 * <p>REPC_MT220003CA.TransportationEvent: transported to</p>
 * 
 * <p>Needed to know what query to execute to retrieve details 
 * about the request. (I.e. Get Patient Referral vs. Get 
 * Discharge-Care Summary Order.)</p>
 * 
 * <p>This distinguishes between &quot;referral&quot; requests 
 * and specific orders.</p>
 */
@Hl7PartTypeMapping({"REPC_MT220001CA.TransportationEvent","REPC_MT220003CA.TransportationEvent"})
public class TransportedToBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private OccurredAtBean destination;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.TransportationEvent.destination</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220003CA.TransportationEvent.destination</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"destination"})
    public OccurredAtBean getDestination() {
        return this.destination;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.TransportationEvent.destination</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220003CA.TransportationEvent.destination</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setDestination(OccurredAtBean destination) {
        this.destination = destination;
    }

}
