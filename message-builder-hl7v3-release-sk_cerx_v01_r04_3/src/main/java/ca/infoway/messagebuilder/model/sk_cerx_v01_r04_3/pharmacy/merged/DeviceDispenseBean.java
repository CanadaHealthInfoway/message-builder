/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RecordedAtBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>PORX_MT060010CA.DeviceDispense: Dispense</p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present</p><p>Reported Issue is only permitted if 
 * Issue Indicator is not present</p><p>One of 
 * DetectedIssueIndicator or Reported Issues detailed info must 
 * be returned, but not both</p><p>One of AnnotationIndicator 
 * or Annotation detail info must be returned, but not 
 * both.</p></p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present</p><p>Reported Issue is only permitted if 
 * Issue Indicator is not present</p><p>One of 
 * DetectedIssueIndicator or Reported Issues detailed info must 
 * be returned, but not both</p><p>One of AnnotationIndicator 
 * or Annotation detail info must be returned, but not 
 * both.</p></p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present</p><p>Reported Issue is only permitted if 
 * Issue Indicator is not present</p><p>One of 
 * DetectedIssueIndicator or Reported Issues detailed info must 
 * be returned, but not both</p><p>One of AnnotationIndicator 
 * or Annotation detail info must be returned, but not 
 * both.</p></p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present</p><p>Reported Issue is only permitted if 
 * Issue Indicator is not present</p><p>One of 
 * DetectedIssueIndicator or Reported Issues detailed info must 
 * be returned, but not both</p><p>One of AnnotationIndicator 
 * or Annotation detail info must be returned, but not 
 * both.</p></p>
 * 
 * <p><p>Describes the issuing of a drug in response to an 
 * authorizing prescription.</p></p>
 * 
 * <p><p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * actually receiving.</p></p>
 * 
 * <p>PORX_MT060040CA.DeviceDispense: Prescription Dispenses</p>
 * 
 * <p><p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p><p>Annotation is only permitted if Annotation 
 * Indicator is not present</p></p>
 * 
 * <p><p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p><p>Annotation is only permitted if Annotation 
 * Indicator is not present</p></p>
 * 
 * <p><p>This is the detailed information about a device 
 * dispense that has been performed on behalf of a patient.</p></p>
 * 
 * <p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>Dispensing is an integral part of the overall 
 * prescription process.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060010CA.DeviceDispense","PORX_MT060040CA.DeviceDispense"})
@Hl7RootType
public class DeviceDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20120322L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private CV confidentialityCode = new CVImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private ProviderBean performerAssignedPerson;
    private RecordedAtBean location;
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseDetailsBean component2SupplyEvent;
    private PrescriptionReferenceBean fulfillmentSupplyRequest;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<IssuesBean> subjectOf4DetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private BL subjectOf3DetectedIssueIndicator = new BLImpl(false);
    private List<CommentBean> subjectOf5Annotation = new ArrayList<CommentBean>();


    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p><p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p></p>
     * 
     * <p><p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p></p>
     * 
     * <p><p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p></p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p><p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p></p>
     * 
     * <p><p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p></p>
     * 
     * <p><p>Allows dispense events to be uniquely referenced and 
     * is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>DispenseStatus</p>
     * 
     * <p>Dispense Status</p>
     * 
     * <p><p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the device has been delivered to the 
     * patient.</p></p>
     * 
     * <p><p>Important in understanding what devices the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the device.</p></p>
     * 
     * <p>B:Dispense Status</p>
     * 
     * <p><p>Indicates whether the dispense has been picked up 
     * ('complete') or has just been processed ('active').</p></p>
     * 
     * <p><p>Indicates how far along the process the dispense event 
     * is. It should always be known and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>PrescriptionMaskingIndicator</p>
     * 
     * <p>E:Prescription Masking Indicator</p>
     * 
     * <p><p>Indicates whether the dispense (and associated 
     * prescription) is masked.</p></p>
     * 
     * <p><p>Allows a patient to control access to 'sensitive' 
     * prescriptions. The attribute is optional because not all 
     * systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"performer/assignedPerson"})
    public ProviderBean getPerformerAssignedPerson() {
        return this.performerAssignedPerson;
    }
    public void setPerformerAssignedPerson(ProviderBean performerAssignedPerson) {
        this.performerAssignedPerson = performerAssignedPerson;
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><div>was performed.</div></p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    @Hl7XmlMapping({"component2/supplyEvent"})
    public DispenseDetailsBean getComponent2SupplyEvent() {
        return this.component2SupplyEvent;
    }
    public void setComponent2SupplyEvent(DispenseDetailsBean component2SupplyEvent) {
        this.component2SupplyEvent = component2SupplyEvent;
    }


    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public PrescriptionReferenceBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }
    public void setFulfillmentSupplyRequest(PrescriptionReferenceBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf2/detectedIssueEvent","subjectOf4/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060010CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf2/detectedIssueEvent", type="PORX_MT980030CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060040CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueEvent", type="PORX_MT980030CA.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOf4DetectedIssueEvent() {
        return this.subjectOf4DetectedIssueEvent;
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><p>notes were not to be included and there are 
     * notes.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator","subjectOf3/annotationIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060040CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf2/annotationIndicator", type="PORX_MT060040CA.AnnotationIndicator"),
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060010CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf3/annotationIndicator", type="PORX_MT060010CA.AnnotationIndicator")})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><p>issues.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"subjectOf3/detectedIssueIndicator","subjectOf4/detectedIssueIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060040CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf3/detectedIssueIndicator", type="PORX_MT060040CA.DetectedIssueIndicator"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060010CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueIndicator", type="PORX_MT060010CA.DetectedIssueIndicator")})
    public Boolean getSubjectOf3DetectedIssueIndicator() {
        return this.subjectOf3DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf3DetectedIssueIndicator(Boolean subjectOf3DetectedIssueIndicator) {
        this.subjectOf3DetectedIssueIndicator.setValue(subjectOf3DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf5/annotation"})
    public List<CommentBean> getSubjectOf5Annotation() {
        return this.subjectOf5Annotation;
    }

}
