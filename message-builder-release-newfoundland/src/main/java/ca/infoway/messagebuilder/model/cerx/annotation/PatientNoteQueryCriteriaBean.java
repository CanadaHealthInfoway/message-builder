package ca.infoway.messagebuilder.model.cerx.annotation;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "COMT_MT300002CA.ParameterList" })
public class PatientNoteQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = -795480993762933383L;

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private CD annotationCode = new CDImpl();

    @Override
    @Hl7XmlMapping("patientBirthDate/value")
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }

    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }

    @Override
    @Hl7XmlMapping("patientGender/value")
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }

    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }

    @Override
    @Hl7XmlMapping("patientID/value")
    public Identifier getPatientId() {
        return this.patientId.getValue();
    }

    public void setPatientId(Identifier patientID) {
        this.patientId.setValue(patientID);
    }

    @Override
    @Hl7XmlMapping("patientName/value")
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }

    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }

    @Hl7XmlMapping("patientNoteCategoryCode/value")
    public ActPatientAnnotationCode getAnnotationCode() {
        return (ActPatientAnnotationCode) this.annotationCode.getValue();
    }

    public void setAnnotationCode(ActPatientAnnotationCode annotationCode) {
        this.annotationCode.setValue(annotationCode);
    }
}
