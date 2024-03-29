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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.porx_mt020060ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt050303ca.AnimalPatientBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.IncludesBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.DispenseDetailsBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.PrescriptionReferenceBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.ProcedureRequestBean;
import java.util.Set;



/**
 * <p>Business Name: Prescription Dispense</p>
 * 
 * <p>Dispensing is an integral part of the overall 
 * prescription process.</p>
 * 
 * <p>This is the detailed information about a device dispense 
 * that has been performed on behalf a patient</p>
 */
@Hl7PartTypeMapping({"PORX_MT020060CA.DeviceDispense"})
@Hl7RootType
public class PrescriptionDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private II id = new IIImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private AnimalPatientBean subjectPatient;
    private PrescriptionReferenceBean inFulfillmentOfDeviceRequest;
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseDetailsBean component2SupplyEvent;
    private IncludesBean subjectOf;


    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     * 
     * <p>Identifier assigned by the dispensing facility.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     * 
     * <p>Identifier assigned by the dispensing facility.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: E:Prescription Masking Indicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.DeviceDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Can be used to set a mask for a new dispense, if present 
     * in a new dispense request.</p><p>Allows the patient to have 
     * discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can't have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p>
     * 
     * <p>If a dispense is masked, it implicitly masks the 
     * prescription being dispensed. (There's no point in masking a 
     * dispense if the prescription is unmasked.)</p>
     * 
     * <p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Communicates the intent of the patient to 
     * restrict access to their prescriptions.</p><p>Provides 
     * support for additional confidentiality constraint, giving 
     * patients a level of control over their 
     * information.</p><p>Valid values are: 'N' (normal - denotes 
     * 'Not Masked'); 'R' (restricted - denotes 'Masked'); 'V' 
     * (very restricted - denotes very restricted access as 
     * declared by the Privacy Officer of the record holder) and 
     * 'T' (taboo - denotes 'Patient Access Restricted').</p><p>The 
     * default is 'normal' signifying 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: PORX_MT020060CA.Subject8.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public AnimalPatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: PORX_MT020060CA.Subject8.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectPatient(AnimalPatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: 
     * PORX_MT020060CA.InFulfillmentOf1.deviceRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/deviceRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfDeviceRequest() {
        return this.inFulfillmentOfDeviceRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT020060CA.InFulfillmentOf1.deviceRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInFulfillmentOfDeviceRequest(PrescriptionReferenceBean inFulfillmentOfDeviceRequest) {
        this.inFulfillmentOfDeviceRequest = inFulfillmentOfDeviceRequest;
    }


    /**
     * <p>Relationship: 
     * PORX_MT020060CA.Component11.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT020060CA.Component11.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    /**
     * <p>Relationship: PORX_MT020060CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component2/supplyEvent"})
    public DispenseDetailsBean getComponent2SupplyEvent() {
        return this.component2SupplyEvent;
    }

    /**
     * <p>Relationship: PORX_MT020060CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent2SupplyEvent(DispenseDetailsBean component2SupplyEvent) {
        this.component2SupplyEvent = component2SupplyEvent;
    }


    /**
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }

    /**
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }

}
