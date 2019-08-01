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
package ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt010140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_drug.common.coct_mt050203ca.PatientBean;
import ca.infoway.messagebuilder.model.nb_drug.merged.RecordedAtBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Dispense Instructions</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate.</p>
 * 
 * <p>This is the information that describes the authorization 
 * for a dispenser to dispense the prescription.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010140CA.SupplyRequest"})
@Hl7RootType
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private PatientBean subjectPatient;
    private RecordedAtBean location;
    private List<RemainingDispensesBean> fulfillmentSupplyEvent = new ArrayList<RemainingDispensesBean>();
    private ActRequestBean componentOfActRequest;


    /**
     * <p>Relationship: PORX_MT010140CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: PORX_MT010140CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: PORX_MT010140CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>A valid location identifier, registered in the NB 
     * Location Index, is used to specify the target pharmacy in 
     * the message path &ldquo;/subject /supplyRequest /location 
     * /id&rdquo;. Alternatively,thelocation can be nullFlavoured, 
     * thisallows the prescription to be unassigned to any 
     * particular dispensing facility.</p> <p>Please note: There is 
     * also a specific location identifier in New Brunswick for 
     * &ldquo;Out of Province&rdquo; and setting the location to 
     * this special location identifier is used to transfer the 
     * prescription to a facility outside the list of registered 
     * facilities.</p> <p></p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: PORX_MT010140CA.SupplyRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>A valid location identifier, registered in the NB 
     * Location Index, is used to specify the target pharmacy in 
     * the message path &ldquo;/subject /supplyRequest /location 
     * /id&rdquo;. Alternatively,thelocation can be nullFlavoured, 
     * thisallows the prescription to be unassigned to any 
     * particular dispensing facility.</p> <p>Please note: There is 
     * also a specific location identifier in New Brunswick for 
     * &ldquo;Out of Province&rdquo; and setting the location to 
     * this special location identifier is used to transfer the 
     * prescription to a facility outside the list of registered 
     * facilities.</p> <p></p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: PORX_MT010140CA.InFulfillmentOf.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/supplyEvent"})
    public List<RemainingDispensesBean> getFulfillmentSupplyEvent() {
        return this.fulfillmentSupplyEvent;
    }


    /**
     * <p>Relationship: PORX_MT010140CA.Component6.actRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"componentOf/actRequest"})
    public ActRequestBean getComponentOfActRequest() {
        return this.componentOfActRequest;
    }

    /**
     * <p>Relationship: PORX_MT010140CA.Component6.actRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentOfActRequest(ActRequestBean componentOfActRequest) {
        this.componentOfActRequest = componentOfActRequest;
    }

}
