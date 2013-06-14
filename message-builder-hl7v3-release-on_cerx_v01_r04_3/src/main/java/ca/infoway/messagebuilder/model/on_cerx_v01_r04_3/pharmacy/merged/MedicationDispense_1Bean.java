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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt090107on.ProviderBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt240003on.ServiceLocationBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt980040on.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>PORX_MT060340ON.MedicationDispense: Prescription 
 * Dispenses</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Dispensing is an integral part of the overall medication 
 * process.</p>
 * 
 * <p>This is the detailed information about a medication 
 * dispense that has been performed on behalf of a patient.</p>
 * 
 * <p>PORX_MT060160ON.MedicationDispense: Prescription 
 * Dispenses</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Dispensing is an integral part of the overall medication 
 * process.</p>
 * 
 * <p>This is the detailed information about a medication 
 * dispense that has been performed on behalf of a patient.</p>
 * 
 * <p>PORX_MT060090ON.MedicationDispense: Dispense</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * actually receiving.</p>
 * 
 * <p>Describes the issuing of a drug in response to an 
 * authorizing prescription.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060090ON.MedicationDispense","PORX_MT060160ON.MedicationDispense","PORX_MT060340ON.MedicationDispense"})
@Hl7RootType
public class MedicationDispense_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private ProviderBean performerAssignedPerson;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SubstitutionBean component2SubstitutionMade;
    private SupplyEventBean component3SupplyEvent;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<CommentBean> subjectOf3Annotation = new ArrayList<CommentBean>();
    private BL subjectOf4DetectedIssueIndicator = new BLImpl(false);
    private List<IssuesBean> subjectOf2DetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL subjectOf5AnnotationIndicator = new BLImpl(false);
    private CV confidentialityCode = new CVImpl();
    private SupplyRequest_1Bean inFulfillmentOfSubstanceAdministrationRequest;


    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060340ON.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p>
     * 
     * <p>DispensedItem.externalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
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
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060090ON.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060160ON.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p>
     * 
     * <p>DispensedItem.externalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
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
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060340ON.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p>
     * 
     * <p>DispensedItem.externalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
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
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060090ON.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060160ON.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p>
     * 
     * <p>DispensedItem.externalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
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
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.ResponsibleParty4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.ResponsibleParty2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.ResponsibleParty3.assignedPerson</p>
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
     * PORX_MT060340ON.ResponsibleParty4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.ResponsibleParty2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340ON.Performer3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090ON.Performer3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160ON.Performer3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedPerson"})
    public ProviderBean getPerformerAssignedPerson() {
        return this.performerAssignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340ON.Performer3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090ON.Performer3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160ON.Performer3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPerformerAssignedPerson(ProviderBean performerAssignedPerson) {
        this.performerAssignedPerson = performerAssignedPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Component11.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.Component11.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.Component11.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/dosageInstruction","component2/dosageInstruction"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060090ON.Component11"),
        @Hl7MapByPartType(name="component1", type="PORX_MT060340ON.Component11"),
        @Hl7MapByPartType(name="component1/dosageInstruction", type="PORX_MT980040ON.DosageInstruction"),
        @Hl7MapByPartType(name="component2", type="PORX_MT060160ON.Component11"),
        @Hl7MapByPartType(name="component2/dosageInstruction", type="PORX_MT980040ON.DosageInstruction")})
    public List<AdministrationInstructionsBean> getComponent1DosageInstruction() {
        return this.component1DosageInstruction;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/substitutionMade","component3/substitutionMade"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component2", type="PORX_MT060090ON.Component13"),
        @Hl7MapByPartType(name="component2", type="PORX_MT060340ON.Component13"),
        @Hl7MapByPartType(name="component2/substitutionMade", type="PORX_MT060090ON.SubstitutionMade"),
        @Hl7MapByPartType(name="component2/substitutionMade", type="PORX_MT060340ON.SubstitutionMade"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060160ON.Component13"),
        @Hl7MapByPartType(name="component3/substitutionMade", type="PORX_MT060160ON.SubstitutionMade")})
    public SubstitutionBean getComponent2SubstitutionMade() {
        return this.component2SubstitutionMade;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent2SubstitutionMade(SubstitutionBean component2SubstitutionMade) {
        this.component2SubstitutionMade = component2SubstitutionMade;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340ON.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090ON.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160ON.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/supplyEvent","component3/supplyEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060160ON.Component"),
        @Hl7MapByPartType(name="component1/supplyEvent", type="PORX_MT060160ON.SupplyEvent"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060090ON.Component"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060340ON.Component"),
        @Hl7MapByPartType(name="component3/supplyEvent", type="PORX_MT060090ON.SupplyEvent"),
        @Hl7MapByPartType(name="component3/supplyEvent", type="PORX_MT060340ON.SupplyEvent")})
    public SupplyEventBean getComponent3SupplyEvent() {
        return this.component3SupplyEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340ON.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090ON.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160ON.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent3SupplyEvent(SupplyEventBean component3SupplyEvent) {
        this.component3SupplyEvent = component3SupplyEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340ON.Subject10.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090ON.Subject.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160ON.Subject.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340ON.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090ON.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160ON.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotation","subjectOf3/annotation","subjectOf4/annotation"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060340ON.Subject7"),
        @Hl7MapByPartType(name="subjectOf2/annotation", type="COCT_MT120600ON.Annotation"),
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060090ON.Subject7"),
        @Hl7MapByPartType(name="subjectOf3/annotation", type="COCT_MT120600ON.Annotation"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060160ON.Subject7"),
        @Hl7MapByPartType(name="subjectOf4/annotation", type="COCT_MT120600ON.Annotation")})
    public List<CommentBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/detectedIssueIndicator","subjectOf4/detectedIssueIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060160ON.Subject13"),
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060340ON.Subject13"),
        @Hl7MapByPartType(name="subjectOf3/detectedIssueIndicator", type="PORX_MT060160ON.DetectedIssueIndicator"),
        @Hl7MapByPartType(name="subjectOf3/detectedIssueIndicator", type="PORX_MT060340ON.DetectedIssueIndicator"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060090ON.Subject13"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueIndicator", type="PORX_MT060090ON.DetectedIssueIndicator")})
    public Boolean getSubjectOf4DetectedIssueIndicator() {
        return this.subjectOf4DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf4DetectedIssueIndicator(Boolean subjectOf4DetectedIssueIndicator) {
        this.subjectOf4DetectedIssueIndicator.setValue(subjectOf4DetectedIssueIndicator);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340ON.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090ON.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160ON.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/detectedIssueEvent","subjectOf4/detectedIssueEvent","subjectOf5/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060090ON.Subject6"),
        @Hl7MapByPartType(name="subjectOf2/detectedIssueEvent", type="PORX_MT980030ON.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060340ON.Subject6"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueEvent", type="PORX_MT980030ON.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060160ON.Subject6"),
        @Hl7MapByPartType(name="subjectOf5/detectedIssueEvent", type="PORX_MT980030ON.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOf2DetectedIssueEvent() {
        return this.subjectOf2DetectedIssueEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator","subjectOf5/annotationIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060160ON.Subject12"),
        @Hl7MapByPartType(name="subjectOf2/annotationIndicator", type="PORX_MT060160ON.AnnotationIndicator"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060090ON.Subject12"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060340ON.Subject12"),
        @Hl7MapByPartType(name="subjectOf5/annotationIndicator", type="PORX_MT060090ON.AnnotationIndicator"),
        @Hl7MapByPartType(name="subjectOf5/annotationIndicator", type="PORX_MT060340ON.AnnotationIndicator")})
    public Boolean getSubjectOf5AnnotationIndicator() {
        return this.subjectOf5AnnotationIndicator.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340ON.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160ON.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf5AnnotationIndicator(Boolean subjectOf5AnnotationIndicator) {
        this.subjectOf5AnnotationIndicator.setValue(subjectOf5AnnotationIndicator);
    }


    /**
     * <p>Business Name: PrescriptionMaskingIndicator</p>
     * 
     * <p>Un-merged Business Name: PrescriptionMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.MedicationDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: PrescriptionMaskingIndicator</p>
     * 
     * <p>Un-merged Business Name: PrescriptionMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.MedicationDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationRequest"})
    public SupplyRequest_1Bean getInFulfillmentOfSubstanceAdministrationRequest() {
        return this.inFulfillmentOfSubstanceAdministrationRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090ON.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInFulfillmentOfSubstanceAdministrationRequest(SupplyRequest_1Bean inFulfillmentOfSubstanceAdministrationRequest) {
        this.inFulfillmentOfSubstanceAdministrationRequest = inFulfillmentOfSubstanceAdministrationRequest;
    }

}
