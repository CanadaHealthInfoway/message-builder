/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.porx_mt020070ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged.PrescriptionReferenceBean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged.SubstitutionBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"PORX_MT020070CA.MedicationDispense"})
@Hl7RootType
public class PrescriptionDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II localDispenseId = new IIImpl();
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private BL subject = new BLImpl(false);
    private PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest;
    private SubstitutionBean component1SubstitutionMade;
    private List<AdministrationInstructionsBean> component2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SupplyEventBean component3SupplyEvent;
    private NotesBean subjectOfAnnotation;


    /**
     * <p>A:Local Dispense Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getLocalDispenseId() {
        return this.localDispenseId.getValue();
    }
    public void setLocalDispenseId(Identifier localDispenseId) {
        this.localDispenseId.setValue(localDispenseId);
    }


    /**
     * <p>E:Prescription Masking Indicators</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    @Hl7XmlMapping({"subject"})
    public Boolean getSubject() {
        return this.subject.getValue();
    }
    public void setSubject(Boolean subject) {
        this.subject.setValue(subject);
    }


    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfSubstanceAdministrationRequest() {
        return this.inFulfillmentOfSubstanceAdministrationRequest;
    }
    public void setInFulfillmentOfSubstanceAdministrationRequest(PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest) {
        this.inFulfillmentOfSubstanceAdministrationRequest = inFulfillmentOfSubstanceAdministrationRequest;
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


    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
