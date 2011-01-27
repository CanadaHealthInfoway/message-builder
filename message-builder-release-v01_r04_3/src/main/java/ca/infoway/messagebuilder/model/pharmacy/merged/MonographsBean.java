/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActMedicationDocumentCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"POME_MT010040CA.Document","PORR_MT050016CA.Document"})
@Hl7RootType
public class MonographsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private ED<EncapsulatedData> monographContent = new EDImpl<EncapsulatedData>();
    private CV writtenIn = new CVImpl();
    private AssignedEntity3Bean authorAssignedEntity;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV code = new CVImpl();
    private II id = new IIImpl();
    private ED<EncapsulatedData> medicationDocumentContentLanguage = new EDImpl<EncapsulatedData>();


    /**
     * <p>MonographContent</p>
     * 
     * <p>Monograph Content</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getMonographContent() {
        return this.monographContent.getValue();
    }
    public void setMonographContent(EncapsulatedData monographContent) {
        this.monographContent.setValue(monographContent);
    }


    /**
     * <p>WrittenIn</p>
     * 
     * <p>Written in</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getWrittenIn() {
        return (HumanLanguage) this.writtenIn.getValue();
    }
    public void setWrittenIn(HumanLanguage writtenIn) {
        this.writtenIn.setValue(writtenIn);
    }


    @Hl7XmlMapping({"author/assignedEntity"})
    public AssignedEntity3Bean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }
    public void setAuthorAssignedEntity(AssignedEntity3Bean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Monograph Effective/Expiry Date</p>
     * 
     * <p>C:Medication Document Effective/Expiry Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Monograph Type</p>
     * 
     * <p>A:Medication Document Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActMedicationDocumentCode getCode() {
        return (ActMedicationDocumentCode) this.code.getValue();
    }
    public void setCode(ActMedicationDocumentCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>B:Medication Document Id</p>
     * 
     * <p>Monograph Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>MedicationDocumentContentLanguage</p>
     * 
     * <p>F:Medication Document Content + Language</p>
     */
    @Hl7XmlMapping({"component/documentBodyEvent/text"})
    public EncapsulatedData getMedicationDocumentContentLanguage() {
        return this.medicationDocumentContentLanguage.getValue();
    }
    public void setMedicationDocumentContentLanguage(EncapsulatedData medicationDocumentContentLanguage) {
        this.medicationDocumentContentLanguage.setValue(medicationDocumentContentLanguage);
    }

}
