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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.pharmacy.porx_mt020060ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.pharmacy.merged.DispenseInstructions_1Bean;



/**
 * <p>Business Name: Prescription Reference</p>
 * 
 * <p>The Prescriber Name must be specified only when the 
 * Prescription ID is Null</p>
 * 
 * <p>Dispenses for electronically created prescriptions must 
 * reference the prescription.</p>
 * 
 * <p>Information pertaining to the prescription for which a 
 * dispense is being created</p>
 */
@Hl7PartTypeMapping({"PORX_MT020060CA.DeviceRequest"})
public class PrescriptionReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private II id = new IIImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private DispenseInstructions_1Bean componentSupplyRequest;


    /**
     * <p>Business Name: D:Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Component must be specified if the id is null and can not 
     * be specified if the id is not null.</p>
     * 
     * <p>Prescription.prescriptionNumber</p>
     * 
     * <p>Prescription.prescriptionExternalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
     * 
     * <p>X0101(id for prescription)</p>
     * 
     * <p>ZDP.5</p>
     * 
     * <p>ZDP.6</p>
     * 
     * <p>ZDP.22</p>
     * 
     * <p>ZRV.5</p>
     * 
     * <p>DRU.080-01(extension)</p>
     * 
     * <p>DRU.080-02(route)</p>
     * 
     * <p>Claim.455-EM (route)</p>
     * 
     * <p>Claim.402-D2 (extension)</p>
     * 
     * <p>Claim.456-EN</p>
     * 
     * <p>Claim.454-EK</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     * 
     * <p>The identifier of the prescription for which a dispense 
     * is beiing created.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: D:Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Component must be specified if the id is null and can not 
     * be specified if the id is not null.</p>
     * 
     * <p>Prescription.prescriptionNumber</p>
     * 
     * <p>Prescription.prescriptionExternalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
     * 
     * <p>X0101(id for prescription)</p>
     * 
     * <p>ZDP.5</p>
     * 
     * <p>ZDP.6</p>
     * 
     * <p>ZDP.22</p>
     * 
     * <p>ZRV.5</p>
     * 
     * <p>DRU.080-01(extension)</p>
     * 
     * <p>DRU.080-02(route)</p>
     * 
     * <p>Claim.455-EM (route)</p>
     * 
     * <p>Claim.402-D2 (extension)</p>
     * 
     * <p>Claim.456-EN</p>
     * 
     * <p>Claim.454-EK</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     * 
     * <p>The identifier of the prescription for which a dispense 
     * is beiing created.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: 
     * PORX_MT020060CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Relationship: 
     * PORX_MT020060CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Relationship: PORX_MT020060CA.DeviceRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: PORX_MT020060CA.DeviceRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: PORX_MT020060CA.Component2.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/supplyRequest"})
    public DispenseInstructions_1Bean getComponentSupplyRequest() {
        return this.componentSupplyRequest;
    }

    /**
     * <p>Relationship: PORX_MT020060CA.Component2.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentSupplyRequest(DispenseInstructions_1Bean componentSupplyRequest) {
        this.componentSupplyRequest = componentSupplyRequest;
    }

}
