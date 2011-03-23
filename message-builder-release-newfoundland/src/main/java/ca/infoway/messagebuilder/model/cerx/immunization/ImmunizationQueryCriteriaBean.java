package ca.infoway.messagebuilder.model.cerx.immunization;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.VaccineEntityType;
import ca.infoway.messagebuilder.model.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "POIZ_MT060140CA.ParameterList" })
public class ImmunizationQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = -134058128932217776L;

    private IVL<TS, Interval<Date>> immunizationPeriod = new IVLImpl<TS, Interval<Date>>();

    private BL includeIssuesIndicator = new BLImpl(false);

    private BL includeNotesIndicator = new BLImpl(false);

    private IVL<TS, Interval<Date>> nextPlannedDosePeriod = new IVLImpl<TS, Interval<Date>>();

    private IVL<TS, Interval<Date>> renewalPeriod = new IVLImpl<TS, Interval<Date>>();

    private CD vaccineCode = new CDImpl();

    private INT vaccineDoseNumber = new INTImpl();

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    @Hl7XmlMapping("includeNotesIndicator/value")
    public boolean isIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }

    public void setIncludeNotesIndicator(boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping("immunizationPeriod/value")
    public Interval<Date> getImmunizationPeriod() {
        return this.immunizationPeriod.getValue();
    }

    public void setImmunizationPeriod(Interval<Date> immunizationPeriod) {
        this.immunizationPeriod.setValue(immunizationPeriod);
    }

    @Hl7XmlMapping("includeIssuesIndicator/value")
    public boolean isIncludeIssuesIndicator() {
        return this.includeIssuesIndicator.getValue();
    }

    public void setIncludeIssuesIndicator(boolean includeIssuesIndicator) {
        this.includeIssuesIndicator.setValue(includeIssuesIndicator);
    }

    @Hl7XmlMapping("nextPlannedDosePeriod/value")
    public Interval<Date> getNextPlannedDosePeriod() {
        return this.nextPlannedDosePeriod.getValue();
    }

    public void setNextPlannedDosePeriod(Interval<Date> nextPlannedDosePeriod) {
        this.nextPlannedDosePeriod.setValue(nextPlannedDosePeriod);
    }

    @Hl7XmlMapping("renewalPeriod/value")
    public Interval<Date> getRenewalPeriod() {
        return this.renewalPeriod.getValue();
    }

    public void setRenewalPeriod(Interval<Date> renewalPeriod) {
        this.renewalPeriod.setValue(renewalPeriod);
    }

    @Hl7XmlMapping("vaccineCode/value")
    public VaccineEntityType getVaccineCode() {
        return (VaccineEntityType) this.vaccineCode.getValue();
    }

    public void setVaccineCode(VaccineEntityType vaccineCode) {
        this.vaccineCode.setValue(vaccineCode);
    }

    @Hl7XmlMapping("vaccineDoesNumber/value")
    public Integer getVaccineDoseNumber() {
        return this.vaccineDoseNumber.getValue();
    }

    public void setVaccineDoseNumber(Integer vaccineDoseNumber) {
        this.vaccineDoseNumber.setValue(vaccineDoseNumber);
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
