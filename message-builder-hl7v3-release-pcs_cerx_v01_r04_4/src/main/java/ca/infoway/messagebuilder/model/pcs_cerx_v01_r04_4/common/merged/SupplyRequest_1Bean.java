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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.coct_mt090107ca.ProviderBean;



/**
 * <p>Business Name: PrescriptionReference</p>
 * 
 * <p>PORX_MT020070CA.SubstanceAdministrationRequest: 
 * Prescription Reference</p>
 * 
 * <p>The Prescriber Name must be specified only when the 
 * Prescription Order Number is Null.</p>
 * 
 * <p>Dispenses for electronically created prescriptions must 
 * reference the prescription.</p>
 * 
 * <p>Information pertaining to the prescription for which a 
 * dispense is being created</p>
 * 
 * <p>PORX_MT060010CA.SupplyRequest: Prescription Reference</p>
 * 
 * <p>Links a dispense with its parent prescription.</p>
 * 
 * <p>A reference to the prescription order being dispensed</p>
 * 
 * <p>PORX_MT060090CA.SubstanceAdministrationRequest: 
 * Prescription Reference</p>
 * 
 * <p>Links a dispense with its parent prescription.</p>
 * 
 * <p>A reference to the prescription order being dispensed</p>
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.SubstanceAdministrationRequest","PORX_MT060010CA.SupplyRequest","PORX_MT060090CA.SubstanceAdministrationRequest"})
public class SupplyRequest_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20140506L;
    private II id = new IIImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private Component2_2Bean component;


    /**
     * <p>Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SubstanceAdministrationRequest.id</p>
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
     * is being created.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT060010CA.SupplyRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS will always assign a Prescription Order 
     * Number.</p>
     * 
     * <p>This is an identifier assigned to a specific device 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.SubstanceAdministrationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS will always assign a Prescription Order 
     * Number.</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SubstanceAdministrationRequest.id</p>
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
     * is being created.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT060010CA.SupplyRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS will always assign a Prescription Order 
     * Number.</p>
     * 
     * <p>This is an identifier assigned to a specific device 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.SubstanceAdministrationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS will always assign a Prescription Order 
     * Number.</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SubstanceAdministrationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.SupplyRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.SubstanceAdministrationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SubstanceAdministrationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.SupplyRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.SubstanceAdministrationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SubstanceAdministrationRequest.component</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"component"})
    public Component2_2Bean getComponent() {
        return this.component;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SubstanceAdministrationRequest.component</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setComponent(Component2_2Bean component) {
        this.component = component;
    }

}