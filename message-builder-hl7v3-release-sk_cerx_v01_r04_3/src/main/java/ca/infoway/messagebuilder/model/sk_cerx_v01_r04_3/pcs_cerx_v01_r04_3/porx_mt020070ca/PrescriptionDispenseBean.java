/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt020070ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt050303ca.AnimalPatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.Patient_2;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.PrescriptionReferenceBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.SubstitutionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Prescription Dispense</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * detailed information about a medication dispense that has 
 * been performed on behalf a patient</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
 * is an integral part of the overall medication process.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.MedicationDispense"})
@Hl7RootType
public class PrescriptionDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private II localDispenseId = new IIImpl();
    private CV prescriptionMaskingIndicator = new CVImpl();
    private SubstitutionBean component1SubstitutionMade;
    private List<AdministrationInstructionsBean> component2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SupplyEventBean component3SupplyEvent;
    private PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest;
    private Patient_1Bean recordTargetPatient;
    private Patient_2 subjectPatient1;
    private CommentBean subjectOfAnnotation;


    /**
     * <p>A:Local Dispense Id</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifier 
     * assigned by the dispensing facility.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * formal tracking of centrally recorded dispenses to local 
     * records for audit and related purposes.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getLocalDispenseId() {
        return this.localDispenseId.getValue();
    }
    public void setLocalDispenseId(Identifier localDispenseId) {
        this.localDispenseId.setValue(localDispenseId);
    }


    /**
     * <p>E:Prescription Masking Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent that the dispense should be masked if it is 
     * created; If the dispense is masked, this makes the complete 
     * prescription and all dispenses masked.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.masked</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Can be used 
     * to set a mask for a new dispense, if present in a new 
     * dispense request.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If a 
     * dispense is masked, it implicitly masks the prescription 
     * being dispensed. (There's no point in masking a dispense if 
     * the prescription is unmasked.)</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getPrescriptionMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.prescriptionMaskingIndicator.getValue();
    }
    public void setPrescriptionMaskingIndicator(x_VeryBasicConfidentialityKind prescriptionMaskingIndicator) {
        this.prescriptionMaskingIndicator.setValue(prescriptionMaskingIndicator);
    }


    @Hl7XmlMapping({"component1/substitutionMade"})
    public SubstitutionBean getComponent1SubstitutionMade() {
        return this.component1SubstitutionMade;
    }
    public void setComponent1SubstitutionMade(SubstitutionBean component1SubstitutionMade) {
        this.component1SubstitutionMade = component1SubstitutionMade;
    }


    @Hl7XmlMapping({"component2/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent2DosageInstruction() {
        return this.component2DosageInstruction;
    }


    @Hl7XmlMapping({"component3/supplyEvent"})
    public SupplyEventBean getComponent3SupplyEvent() {
        return this.component3SupplyEvent;
    }
    public void setComponent3SupplyEvent(SupplyEventBean component3SupplyEvent) {
        this.component3SupplyEvent = component3SupplyEvent;
    }


    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfSubstanceAdministrationRequest() {
        return this.inFulfillmentOfSubstanceAdministrationRequest;
    }
    public void setInFulfillmentOfSubstanceAdministrationRequest(PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest) {
        this.inFulfillmentOfSubstanceAdministrationRequest = inFulfillmentOfSubstanceAdministrationRequest;
    }


    @Hl7XmlMapping({"recordTarget/patient"})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    @Hl7XmlMapping({"subject/patient1"})
    public Patient_2 getSubjectPatient1() {
        return this.subjectPatient1;
    }
    public void setSubjectPatient1(Patient_2 subjectPatient1) {
        this.subjectPatient1 = subjectPatient1;
    }

    public Patient_1Bean getSubjectPatient1AsPatient1() {
        return this.subjectPatient1 instanceof Patient_1Bean ? (Patient_1Bean) this.subjectPatient1 : null;
    }
    public boolean hasSubjectPatient1AsPatient1() {
        return (this.subjectPatient1 instanceof Patient_1Bean);
    }

    public AnimalPatientBean getSubjectPatient1AsPatient2() {
        return this.subjectPatient1 instanceof AnimalPatientBean ? (AnimalPatientBean) this.subjectPatient1 : null;
    }
    public boolean hasSubjectPatient1AsPatient2() {
        return (this.subjectPatient1 instanceof AnimalPatientBean);
    }


    @Hl7XmlMapping({"subjectOf/annotation"})
    public CommentBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(CommentBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
