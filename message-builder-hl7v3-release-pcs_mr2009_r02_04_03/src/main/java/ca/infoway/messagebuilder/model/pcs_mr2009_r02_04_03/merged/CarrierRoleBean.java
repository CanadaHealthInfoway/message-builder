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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: CarrierRole</p>
 * 
 * <p>COCT_MT680000CA.CarrierRole: Carrier Role</p>
 * 
 * <p>Role of Carrier, eg. underwriter</p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.CarrierRole","FICR_MT400001CA.CarrierRole","FICR_MT400003CA.CarrierRole","FICR_MT400004CA.CarrierRole","FICR_MT490101CA.CarrierRole","FICR_MT500201CA.CarrierRole","FICR_MT510201CA.CarrierRole","FICR_MT600201CA.CarrierRole","FICR_MT610201CA.CarrierRole","PORX_MT060160CA.CarrierRole","PORX_MT060340CA.CarrierRole"})
public class CarrierRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private ST underwritingCarrierOrganizationName = new STImpl();
    private ResponsibleOrganizationBean underwritingOrganization;


    /**
     * <p>Un-merged Business Name: CarrierIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400001CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060160CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Un-merged Business Name: CarrierIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400003CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400004CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060340CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Un-merged Business Name: CarrierID</p>
     * 
     * <p>Relationship: FICR_MT500201CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierId</p>
     * 
     * <p>Relationship: FICR_MT510201CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490101CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierID</p>
     * 
     * <p>Relationship: FICR_MT610201CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierRoleId</p>
     * 
     * <p>Relationship: COCT_MT680000CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: CarrierIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400001CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060160CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Un-merged Business Name: CarrierIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400003CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400004CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060340CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Un-merged Business Name: CarrierID</p>
     * 
     * <p>Relationship: FICR_MT500201CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierId</p>
     * 
     * <p>Relationship: FICR_MT510201CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490101CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierID</p>
     * 
     * <p>Relationship: FICR_MT610201CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CarrierRoleId</p>
     * 
     * <p>Relationship: COCT_MT680000CA.CarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: PayorName</p>
     * 
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT060160CA.CarrierOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension.</p>
     */
    @Hl7XmlMapping({"underwritingCarrierOrganization/name"})
    public String getUnderwritingCarrierOrganizationName() {
        return this.underwritingCarrierOrganizationName.getValue();
    }

    /**
     * <p>Business Name: PayorName</p>
     * 
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT060160CA.CarrierOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension.</p>
     */
    public void setUnderwritingCarrierOrganizationName(String underwritingCarrierOrganizationName) {
        this.underwritingCarrierOrganizationName.setValue(underwritingCarrierOrganizationName);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CarrierRole.underwritingOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"underwritingOrganization"})
    public ResponsibleOrganizationBean getUnderwritingOrganization() {
        return this.underwritingOrganization;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CarrierRole.underwritingOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setUnderwritingOrganization(ResponsibleOrganizationBean underwritingOrganization) {
        this.underwritingOrganization = underwritingOrganization;
    }

}
