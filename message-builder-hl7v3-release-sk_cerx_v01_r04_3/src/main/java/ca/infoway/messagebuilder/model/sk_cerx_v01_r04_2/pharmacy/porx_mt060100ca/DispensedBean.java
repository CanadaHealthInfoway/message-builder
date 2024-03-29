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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt060100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.PrescriptionBean;



/**
 * <p>Business Name: a:dispensed</p>
 * 
 * <p>Indicates the prescription that was dispensed.</p>
 * 
 * <p>Links the dispense act to the prescription order it was 
 * performed against.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060100CA.InFulfillmentOf"})
public class DispensedBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private PrescriptionBean substanceAdministrationRequest;


    /**
     * <p>Relationship: 
     * PORX_MT060100CA.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"substanceAdministrationRequest"})
    public PrescriptionBean getSubstanceAdministrationRequest() {
        return this.substanceAdministrationRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060100CA.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubstanceAdministrationRequest(PrescriptionBean substanceAdministrationRequest) {
        this.substanceAdministrationRequest = substanceAdministrationRequest;
    }

}
