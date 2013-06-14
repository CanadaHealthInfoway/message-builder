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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.pharmacy.merged;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.domainvalue.SubstanceAdministrationType;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.RefusedByBean;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: PrescriptionReference</p>
 * 
 * <p>PORX_MT020070CA.SubstanceAdministrationRequest: 
 * Prescription Reference</p>
 * 
 * <p>The Prescriber Name must be specified only when the 
 * Prescription Order Number is Null.</p>
 * 
 * <p>Component MUST be specified if the id is null and CAN NOT 
 * be specified if the id is not null</p>
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
 * 
 * <p>PORX_MT020060CA.DeviceRequest: Prescription Reference</p>
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
@Hl7PartTypeMapping({"PORX_MT020060CA.DeviceRequest","PORX_MT020070CA.SubstanceAdministrationRequest","PORX_MT060010CA.SupplyRequest","PORX_MT060090CA.SubstanceAdministrationRequest"})
public class PrescriptionReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private RefusedByBean author;
    private CV component1WorkingListEventCode = new CVImpl();
    private SupplyRequestBean componentSupplyRequest;
    private CS statusCode = new CSImpl();


    /**
     * <p>Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SubstanceAdministrationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-2)</p>
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
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
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
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
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
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-2)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * ID is only 'populated' because in some cases the 
     * prescription will not yet exist electronically.</p>
     * 
     * <p>The identifier of the prescription for which a dispense 
     * is beiing created.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: PrescriptionType</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SubstanceAdministrationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Relevant to a full understanding of the prescription. For 
     * this reason is Mandatory.</p>
     * 
     * <p>Indicates that this is a drug rather than a vaccine.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.SubstanceAdministrationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding the context of the 
     * prescription being fulfilled. Therefoe is Mandatory.</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
     */
    @Hl7XmlMapping({"code"})
    public SubstanceAdministrationType getCode() {
        return (SubstanceAdministrationType) this.code.getValue();
    }

    /**
     * <p>Business Name: PrescriptionType</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.SubstanceAdministrationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Relevant to a full understanding of the prescription. For 
     * this reason is Mandatory.</p>
     * 
     * <p>Indicates that this is a drug rather than a vaccine.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.SubstanceAdministrationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding the context of the 
     * prescription being fulfilled. Therefoe is Mandatory.</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
     */
    public void setCode(SubstanceAdministrationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
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
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Business Name: TreatmentType</p>
     * 
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT020070CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The code is 
     * mandatory as this information is known at dispense time if 
     * the act relationship was not a NULL..</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     */
    @Hl7XmlMapping({"component1/workingListEvent/code"})
    public ActTherapyDurationWorkingListCode getComponent1WorkingListEventCode() {
        return (ActTherapyDurationWorkingListCode) this.component1WorkingListEventCode.getValue();
    }

    /**
     * <p>Business Name: TreatmentType</p>
     * 
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT020070CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The code is 
     * mandatory as this information is known at dispense time if 
     * the act relationship was not a NULL..</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     */
    public void setComponent1WorkingListEventCode(ActTherapyDurationWorkingListCode component1WorkingListEventCode) {
        this.component1WorkingListEventCode.setValue(component1WorkingListEventCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Component2.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Component2.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/supplyRequest","component2/supplyRequest"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component", type="PORX_MT020060CA.Component2"),
        @Hl7MapByPartType(name="component/supplyRequest", type="PORX_MT020060CA.SupplyRequest2"),
        @Hl7MapByPartType(name="component2", type="PORX_MT020070CA.Component2"),
        @Hl7MapByPartType(name="component2/supplyRequest", type="PORX_MT020070CA.SupplyRequest")})
    public SupplyRequestBean getComponentSupplyRequest() {
        return this.componentSupplyRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Component2.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Component2.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentSupplyRequest(SupplyRequestBean componentSupplyRequest) {
        this.componentSupplyRequest = componentSupplyRequest;
    }


    /**
     * <p>Business Name: PrescriptionStatus</p>
     * 
     * <p>Un-merged Business Name: PrescriptionStatus</p>
     * 
     * <p>Relationship: PORX_MT060010CA.SupplyRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed in some jurisdictions</p>
     * 
     * <p>Provides the status of the prescription without requiring 
     * additional queries</p>
     * 
     * <p>Un-merged Business Name: PrescriptionStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.SubstanceAdministrationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed in some jurisdictions</p>
     * 
     * <p>Provides the status of the prescription without requiring 
     * additional queries</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: PrescriptionStatus</p>
     * 
     * <p>Un-merged Business Name: PrescriptionStatus</p>
     * 
     * <p>Relationship: PORX_MT060010CA.SupplyRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed in some jurisdictions</p>
     * 
     * <p>Provides the status of the prescription without requiring 
     * additional queries</p>
     * 
     * <p>Un-merged Business Name: PrescriptionStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.SubstanceAdministrationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed in some jurisdictions</p>
     * 
     * <p>Provides the status of the prescription without requiring 
     * additional queries</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

}
