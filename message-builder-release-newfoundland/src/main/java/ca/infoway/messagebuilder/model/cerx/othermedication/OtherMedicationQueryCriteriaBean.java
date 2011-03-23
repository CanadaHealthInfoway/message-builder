package ca.infoway.messagebuilder.model.cerx.othermedication;

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
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.model.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "PORX_MT060220CA.ParameterList" })
public class OtherMedicationQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = -2953716726745199385L;

    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();

    private IVL<TS, Interval<Date>> amendedInTimeRange = new IVLImpl<TS, Interval<Date>>();

    private BL includeIssuesIndicator = new BLImpl(false);

    private BL includeNotesIndicator = new BLImpl(false);

    private CD issueFilterCode = new CDImpl();

    private II otherMedicationRecordId = new IIImpl();

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    @Hl7XmlMapping("administrationEffectivePeriod/value")
    public Interval<Date> getAdministrationEffectivePeriod() {
        return this.administrationEffectivePeriod.getValue();
    }

    public void setAdministrationEffectivePeriod(Interval<Date> administrationEffectivePeriod) {
        this.administrationEffectivePeriod.setValue(administrationEffectivePeriod);
    }

    @Hl7XmlMapping("amendedInTimeRange/value")
    public Interval<Date> getAmendedInTimeRange() {
        return this.amendedInTimeRange.getValue();
    }

    public void setAmendedInTimeRange(Interval<Date> amendedInTimeRange) {
        this.amendedInTimeRange.setValue(amendedInTimeRange);
    }

    @Hl7XmlMapping("includeIssuesIndicator/value")
    public boolean isIncludeIssuesIndicator() {
        return this.includeIssuesIndicator.getValue();
    }

    public void setIncludeIssuesIndicator(boolean includeIssuesIndicator) {
        this.includeIssuesIndicator.setValue(includeIssuesIndicator);
    }

    @Hl7XmlMapping("includeNotesIndicator/value")
    public boolean isIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }

    public void setIncludeNotesIndicator(boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping("issueFilterCode/value")
    public IssueFilterCode getIssueFilterCode() {
        return (IssueFilterCode) this.issueFilterCode.getValue();
    }

    public void setIssueFilterCode(IssueFilterCode issueFilterCode) {
        this.issueFilterCode.setValue(issueFilterCode);
    }

    @Hl7XmlMapping("otherMedicationRecordId/value")
    public Identifier getOtherMedicationRecordId() {
        return this.otherMedicationRecordId.getValue();
    }

    public void setOtherMedicationRecordId(Identifier otherMedicationRecordId) {
        this.otherMedicationRecordId.setValue(otherMedicationRecordId);
    }

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
}
