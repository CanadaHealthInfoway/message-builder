/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>PORX_MT060340CA.MedicationDispense: Prescription 
 * Dispenses</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * detailed information about a medication dispense that has 
 * been performed on behalf of a patient.</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
 * is an integral part of the overall medication process.</p></p>
 * 
 * <p>PORX_MT060090CA.MedicationDispense: Dispense</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Describes 
 * the issuing of a drug in response to an authorizing 
 * prescription.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is a 
 * 'core' class of the medication model and is important for 
 * understanding what drugs the patient is actually 
 * receiving.</p></p>
 * 
 * <p>PORX_MT060160CA.MedicationDispense: Prescription 
 * Dispenses</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * detailed information about a medication dispense that has 
 * been performed on behalf of a patient.</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
 * is an integral part of the overall medication process.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060090CA.MedicationDispense","PORX_MT060160CA.MedicationDispense","PORX_MT060340CA.MedicationDispense"})
@Hl7RootType
public class MedicationDispense_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private II prescriptionDispenseNumber = new IIImpl();
    private CS dispenseStatus = new CSImpl();
    private List<AdministrationInstructionsBean> component2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SubstitutionBean component3SubstitutionMade;
    private SupplyEventBean component1SupplyEvent;
    private RecordedAtBean location;
    private ProviderBean performerAssignedPerson;
    private ProviderBean responsiblePartyAssignedPerson;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<CommentBean> subjectOf4Annotation = new ArrayList<CommentBean>();
    private BL subjectOf3DetectedIssueIndicator = new BLImpl(false);
    private List<IssuesBean> subjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private CV prescriptionMaskingIndicator = new CVImpl();
    private PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest;


    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * Prescription Dispense Number is a globally unique number 
     * assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">It is created by 
     * the EHR/DIS once the dispense has passed all edits and 
     * validation.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * Prescription Dispense Number is a globally unique number 
     * assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">It is created by 
     * the EHR/DIS once the dispense has passed all edits and 
     * validation.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the referencing of a specific dispense record.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Identifier for a 
     * dispensed record is needed so that dispenses may be uniquely 
     * referenced. Thus the mandatory requirement.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the referencing of a specific dispense record.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Identifier for a 
     * dispensed record is needed so that dispenses may be uniquely 
     * referenced. Thus the mandatory requirement.</p></p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * Prescription Dispense Number is a globally unique number 
     * assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">It is created by 
     * the EHR/DIS once the dispense has passed all edits and 
     * validation.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * Prescription Dispense Number is a globally unique number 
     * assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">It is created by 
     * the EHR/DIS once the dispense has passed all edits and 
     * validation.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedItemKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.externalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedItemKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.externalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedItemKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.externalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedItemKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.externalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedItemKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.externalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedItemKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.externalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }


    /**
     * <p>DispenseStatus</p>
     * 
     * <p>C:Dispense Status</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the status of the dispense record created on the EHR/DIS. If 
     * 'Active' it means that the dispense has been processed but 
     * not yet given to the patient. If 'Complete', it indicates 
     * that the medication has been delivered to the patient.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important in 
     * understanding what medication the patient actually has on 
     * hand, thus the attribute is mandatory. May also influence 
     * the ability of a different pharmacy to dispense the 
     * medication.</p></p>
     * 
     * <p>Dispense Status</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the status of the dispense record created on the EHR/DIS. If 
     * 'Active' it means that the dispense has been processed but 
     * not yet given to the patient. If 'Complete', it indicates 
     * that the medication has been delivered to the patient.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important in 
     * understanding what medication the patient actually has on 
     * hand, thus the attribute is mandatory. May also influence 
     * the ability of a different pharmacy to dispense the 
     * medication.</p></p>
     * 
     * <p>C:Dispense Status</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the status of the dispense record created on the EHR/DIS. If 
     * \342\200\234Active\342\200\235 it means that the dispense 
     * has been processed but not yet given to the patient. If 
     * \342\200\234Complete\342\200\235, it indicates that the 
     * medication has been delivered to the patient.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important in 
     * understanding what medication the patient actually has on 
     * hand, thus the attribute is mandatory. May also influence 
     * the ability of a different pharmacy to dispense the 
     * medication.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getDispenseStatus() {
        return (ActStatus) this.dispenseStatus.getValue();
    }
    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
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
    public SupplyEventBean getComponent1SupplyEvent() {
        return this.component1SupplyEvent;
    }
    public void setComponent1SupplyEvent(SupplyEventBean component1SupplyEvent) {
        this.component1SupplyEvent = component1SupplyEvent;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"performer/assignedPerson"})
    public ProviderBean getPerformerAssignedPerson() {
        return this.performerAssignedPerson;
    }
    public void setPerformerAssignedPerson(ProviderBean performerAssignedPerson) {
        this.performerAssignedPerson = performerAssignedPerson;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
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
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>PrescriptionMaskingIndicator</p>
     * 
     * <p>E:Prescription Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getPrescriptionMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.prescriptionMaskingIndicator.getValue();
    }
    public void setPrescriptionMaskingIndicator(x_VeryBasicConfidentialityKind prescriptionMaskingIndicator) {
        this.prescriptionMaskingIndicator.setValue(prescriptionMaskingIndicator);
    }


    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfSubstanceAdministrationRequest() {
        return this.inFulfillmentOfSubstanceAdministrationRequest;
    }
    public void setInFulfillmentOfSubstanceAdministrationRequest(PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest) {
        this.inFulfillmentOfSubstanceAdministrationRequest = inFulfillmentOfSubstanceAdministrationRequest;
    }

}
