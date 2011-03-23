package ca.infoway.messagebuilder.model.cerx.allergy;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.model.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "REPC_MT000004CA.ParameterList" })
public class AllergyIntoleranceQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = 3950385135187534269L;

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private CD status = new CDImpl();

    private IVL<TS, Interval<Date>> changePeriod = new IVLImpl<TS, Interval<Date>>();

    private CD type = new CDImpl();

    private CD reactionType = new CDImpl();

    private BL includeNotesIndicator = new BLImpl(false);

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

    public SubjectReaction getReactionType() {
        return (SubjectReaction) this.reactionType.getValue();
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

    @Hl7XmlMapping("includeNotesIndicator/value")
    public boolean isIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }

    public void setIncludeNotesIndicator(boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping("alllergyIntoleranceChangePeriod/value")
    public Interval<Date> getChangePeriod() {
        return this.changePeriod.getValue();
    }

    public void setChangePeriod(Interval<Date> changePeriod) {
        this.changePeriod.setValue(changePeriod);
    }

    @Hl7XmlMapping("allergyIntoleranceType/value")
    public ObservationIntoleranceType getType() {
        return (ObservationIntoleranceType) this.type.getValue();
    }

    public void setType(ObservationIntoleranceType type) {
        this.type.setValue(type);
    }

    @Hl7XmlMapping("allergyIntoleranceStatus/value")
    public ActStatus getStatus() {
        return (ActStatus) this.status.getValue();
    }

    public void setStatus(ActStatus status) {
        this.status.setValue(status);
    }

    @Hl7XmlMapping("reactionType/value")
    public void setReactionType(SubjectReaction reactionType) {
        this.reactionType.setValue(reactionType);
    }

    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }
}
