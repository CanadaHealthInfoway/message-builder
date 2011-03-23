package ca.infoway.messagebuilder.model.cerx.deviceprescription;

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
import ca.infoway.messagebuilder.model.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "PORX_MT060280CA.ParameterList" })
public class DevicePrescriptionDetailQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = -7498117037585753494L;

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    private IVL<TS, Interval<Date>> amendedInTimeRange = new IVLImpl<TS, Interval<Date>>();

    private BL includeEventHistoryIndicator = new BLImpl(false);

    private BL includeIssuesIndicator = new BLImpl(false);

    private BL includeNotesIndicator = new BLImpl(false);

    private BL includePendingChangesIndicator = new BLImpl(false);

    private II prescriptionOrderNumber = new IIImpl();

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

    @Hl7XmlMapping("amendedInTimeRange/value")
    public Interval<Date> getAmendedInTimeRange() {
        return this.amendedInTimeRange.getValue();
    }

    public void setAmendedInTimeRange(Interval<Date> amendedInTimeRange) {
        this.amendedInTimeRange.setValue(amendedInTimeRange);
    }

    @Hl7XmlMapping("includeEventHistoryIndicator/value")
    public boolean isIncludeEventHistoryIndicator() {
        return this.includeEventHistoryIndicator.getValue();
    }

    public void setIncludeEventHistoryIndicator(boolean includeEventHistoryIndicator) {
        this.includeEventHistoryIndicator.setValue(includeEventHistoryIndicator);
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

    @Hl7XmlMapping("includePendingChangesIndicator/value")
    public boolean isIncludePendingChangesIndicator() {
        return this.includePendingChangesIndicator.getValue();
    }

    public void setIncludePendingChangesIndicator(boolean includePendingChangesIndicator) {
        this.includePendingChangesIndicator.setValue(includePendingChangesIndicator);
    }

    @Hl7XmlMapping("prescriptionOrderNumber/value")
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }

    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }
}
