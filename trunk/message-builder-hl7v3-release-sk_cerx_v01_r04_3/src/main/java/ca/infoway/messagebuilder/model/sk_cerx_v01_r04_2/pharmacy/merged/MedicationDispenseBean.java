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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>PORX_MT060340CA.MedicationDispense: Prescription 
 * Dispenses</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p><p>Annotation is only permitted if Annotation 
 * Indicator is not present</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p><p>Annotation is only permitted if Annotation 
 * Indicator is not present</p>
 * 
 * <p>This is the detailed information about a medication 
 * dispense that has been performed on behalf of a patient.</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Dispensing is an integral part of the overall medication 
 * process.</p>
 * 
 * <p>PORX_MT060090CA.MedicationDispense: Dispense</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p><p>Annotation is only permitted if Annotation 
 * Indicator is not present</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p><p>Annotation is only permitted if Annotation 
 * Indicator is not present</p>
 * 
 * <p>Describes the issuing of a drug in response to an 
 * authorizing prescription.</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * actually receiving.</p>
 * 
 * <p>PORX_MT060160CA.MedicationDispense: Prescription 
 * Dispenses</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p>
 * 
 * <p>This is the detailed information about a medication 
 * dispense that has been performed on behalf of a patient.</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Dispensing is an integral part of the overall medication 
 * process.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060090CA.MedicationDispense","PORX_MT060160CA.MedicationDispense","PORX_MT060340CA.MedicationDispense"})
@Hl7RootType
public class MedicationDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private ProviderBean performerAssignedPerson;
    private RecordedAtBean location;
    private List<AdministrationInstructionsBean> component2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SubstitutionBean component3SubstitutionMade;
    private SupplyEvent_1Bean component1SupplyEvent;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<CommentBean> subjectOf4Annotation = new ArrayList<CommentBean>();
    private BL subjectOf3DetectedIssueIndicator = new BLImpl(false);
    private List<IssuesBean> subjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private CV confidentialityCode = new CVImpl();
    private PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest;


    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p><div>The Prescription Dispense Number is a globally</div> 
     * <div>unique number assigned to a dispense (single 
     * fill)</div> <p>by PIN irrespective of the source of the 
     * dispense.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.dispensedItemKey</p><p>DispensedItem.externalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense 
     * event)</p><p>D99.01</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p><div>The Prescription Dispense Number is a globally</div> 
     * <div>unique number assigned to a dispense (single 
     * fill)</div> <p>by PIN irrespective of the source of the 
     * dispense.&nbsp;</p></p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>DispenseStatus</p>
     * 
     * <p>C:Dispense Status</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If Active it means that the dispense has been 
     * processed but not yet given to the patient. If Complete, it 
     * indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Dispense Status</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>C:Dispense Status</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>DispenseStatus</p>
     * 
     * <p>C:Dispense Status</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If Active it means that the dispense has been 
     * processed but not yet given to the patient. If Complete, it 
     * indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Dispense Status</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>C:Dispense Status</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
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
     * <p><div>Indicates the facility/location where the 
     * dispensing</div> <p>was performed.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>(no business name)</p>
     * 
     * <p><div>Indicates the facility/location where the 
     * dispensing</div> <p>was performed.&nbsp;</p></p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"component1/dosageInstruction","component2/dosageInstruction"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060090CA.Component11"),
        @Hl7MapByPartType(name="component1", type="PORX_MT060340CA.Component11"),
        @Hl7MapByPartType(name="component1/dosageInstruction", type="PORX_MT980040CA.DosageInstruction"),
        @Hl7MapByPartType(name="component2", type="PORX_MT060160CA.Component11"),
        @Hl7MapByPartType(name="component2/dosageInstruction", type="PORX_MT980040CA.DosageInstruction")})
    public List<AdministrationInstructionsBean> getComponent2DosageInstruction() {
        return this.component2DosageInstruction;
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><div>An indication of what kind of substitution made, 
     * if</div> <p>any.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"component2/substitutionMade","component3/substitutionMade"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component2", type="PORX_MT060090CA.Component13"),
        @Hl7MapByPartType(name="component2", type="PORX_MT060340CA.Component13"),
        @Hl7MapByPartType(name="component2/substitutionMade", type="PORX_MT060090CA.SubstitutionMade"),
        @Hl7MapByPartType(name="component2/substitutionMade", type="PORX_MT060340CA.SubstitutionMade"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060160CA.Component13"),
        @Hl7MapByPartType(name="component3/substitutionMade", type="PORX_MT060160CA.SubstitutionMade")})
    public SubstitutionBean getComponent3SubstitutionMade() {
        return this.component3SubstitutionMade;
    }

    /**
     * <p>(no business name)</p>
     * 
     * <p><div>An indication of what kind of substitution made, 
     * if</div> <p>any.&nbsp;</p></p>
     */
    public void setComponent3SubstitutionMade(SubstitutionBean component3SubstitutionMade) {
        this.component3SubstitutionMade = component3SubstitutionMade;
    }


    @Hl7XmlMapping({"component1/supplyEvent","component3/supplyEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060160CA.Component"),
        @Hl7MapByPartType(name="component1/supplyEvent", type="PORX_MT060160CA.SupplyEvent"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060090CA.Component"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060340CA.Component"),
        @Hl7MapByPartType(name="component3/supplyEvent", type="PORX_MT060090CA.SupplyEvent"),
        @Hl7MapByPartType(name="component3/supplyEvent", type="PORX_MT060340CA.SupplyEvent")})
    public SupplyEvent_1Bean getComponent1SupplyEvent() {
        return this.component1SupplyEvent;
    }

    public void setComponent1SupplyEvent(SupplyEvent_1Bean component1SupplyEvent) {
        this.component1SupplyEvent = component1SupplyEvent;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf2/annotation","subjectOf3/annotation","subjectOf4/annotation"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060340CA.Subject7"),
        @Hl7MapByPartType(name="subjectOf2/annotation", type="COCT_MT120600CA.Annotation"),
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060090CA.Subject7"),
        @Hl7MapByPartType(name="subjectOf3/annotation", type="COCT_MT120600CA.Annotation"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060160CA.Subject7"),
        @Hl7MapByPartType(name="subjectOf4/annotation", type="COCT_MT120600CA.Annotation")})
    public List<CommentBean> getSubjectOf4Annotation() {
        return this.subjectOf4Annotation;
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><div>If present, indicates that there are issues</div> 
     * <div>associated with this record.</div> <div>This will only 
     * be present if the query indicated that</div> <div>issues 
     * were not to be included and there are</div> 
     * <p>issues.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"subjectOf3/detectedIssueIndicator","subjectOf4/detectedIssueIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060160CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060340CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf3/detectedIssueIndicator", type="PORX_MT060160CA.DetectedIssueIndicator"),
        @Hl7MapByPartType(name="subjectOf3/detectedIssueIndicator", type="PORX_MT060340CA.DetectedIssueIndicator"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060090CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueIndicator", type="PORX_MT060090CA.DetectedIssueIndicator")})
    public Boolean getSubjectOf3DetectedIssueIndicator() {
        return this.subjectOf3DetectedIssueIndicator.getValue();
    }

    /**
     * <p>(no business name)</p>
     * 
     * <p><div>If present, indicates that there are issues</div> 
     * <div>associated with this record.</div> <div>This will only 
     * be present if the query indicated that</div> <div>issues 
     * were not to be included and there are</div> 
     * <p>issues.&nbsp;</p></p>
     */
    public void setSubjectOf3DetectedIssueIndicator(Boolean subjectOf3DetectedIssueIndicator) {
        this.subjectOf3DetectedIssueIndicator.setValue(subjectOf3DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf2/detectedIssueEvent","subjectOf4/detectedIssueEvent","subjectOf5/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060090CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf2/detectedIssueEvent", type="PORX_MT980030CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060340CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueEvent", type="PORX_MT980030CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060160CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf5/detectedIssueEvent", type="PORX_MT980030CA.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOf5DetectedIssueEvent() {
        return this.subjectOf5DetectedIssueEvent;
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><div>If present, indicates that there are notes</div> 
     * <div>associated with the record.</div> <div>This will only 
     * be present if the query indicated that</div> <p>notes were 
     * not to be included and there are notes.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator","subjectOf5/annotationIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060160CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf2/annotationIndicator", type="PORX_MT060160CA.AnnotationIndicator"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060090CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060340CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf5/annotationIndicator", type="PORX_MT060090CA.AnnotationIndicator"),
        @Hl7MapByPartType(name="subjectOf5/annotationIndicator", type="PORX_MT060340CA.AnnotationIndicator")})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>(no business name)</p>
     * 
     * <p><div>If present, indicates that there are notes</div> 
     * <div>associated with the record.</div> <div>This will only 
     * be present if the query indicated that</div> <p>notes were 
     * not to be included and there are notes.&nbsp;</p></p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>PrescriptionMaskingIndicator</p>
     * 
     * <p>E:Prescription Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>PrescriptionMaskingIndicator</p>
     * 
     * <p>E:Prescription Masking Indicator</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfSubstanceAdministrationRequest() {
        return this.inFulfillmentOfSubstanceAdministrationRequest;
    }

    public void setInFulfillmentOfSubstanceAdministrationRequest(PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest) {
        this.inFulfillmentOfSubstanceAdministrationRequest = inFulfillmentOfSubstanceAdministrationRequest;
    }

}
