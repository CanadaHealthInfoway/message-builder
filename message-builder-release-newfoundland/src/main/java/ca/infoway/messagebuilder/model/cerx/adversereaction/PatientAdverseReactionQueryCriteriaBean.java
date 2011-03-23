package ca.infoway.messagebuilder.model.cerx.adversereaction;

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
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.model.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "REPC_MT000016CA.ParameterList" })
public class PatientAdverseReactionQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = -134058128932217776L;

    private BL includeNotesIndicator = new BLImpl(false);

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    private IVL<TS, Interval<Date>> reactionPeriod = new IVLImpl<TS, Interval<Date>>();

    private CD reactionType = new CDImpl();

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

    public void setPatientId(Identifier patientId) {
        this.patientId.setValue(patientId);
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

    @Hl7XmlMapping("reactionPeriod/value")
    public Interval<Date> getReactionPeriod() {
        return this.reactionPeriod.getValue();
    }

    public void setReactionPeriod(Interval<Date> reactionPeriod) {
        this.reactionPeriod.setValue(reactionPeriod);
    }

    @Hl7XmlMapping("reactionType/value")
    public SubjectReaction getReactionType() {
        return (SubjectReaction) this.reactionType.getValue();
    }

    public void setReactionType(SubjectReaction reactionType) {
        this.reactionType.setValue(reactionType);
    }
}
