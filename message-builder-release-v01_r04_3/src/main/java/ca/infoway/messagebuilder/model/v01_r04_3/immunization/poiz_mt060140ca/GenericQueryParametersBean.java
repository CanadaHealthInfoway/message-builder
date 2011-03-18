/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.immunization.poiz_mt060140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
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
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"POIZ_MT060140CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private TS patientBirthDate = new TSImpl();
    private CV patientGender = new CVImpl();
    private II patientID = new IIImpl();
    private PN patientName = new PNImpl();
    private IVL<TS, Interval<Date>> immunizationPeriod = new IVLImpl<TS, Interval<Date>>();
    private BL includeNotesIndicator = new BLImpl();
    private BL includeIssuesIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> renewalPeriod = new IVLImpl<TS, Interval<Date>>();
    private INT vaccineDoseNumber = new INTImpl();
    private CV vaccineCode = new CVImpl();
    private IVL<TS, Interval<Date>> nextPlannedDosePeriod = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>D:Patient Birth Date</p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }
    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }


    /**
     * <p>C:Patient Gender</p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }


    /**
     * <p>B:Patient ID</p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientID() {
        return this.patientID.getValue();
    }
    public void setPatientID(Identifier patientID) {
        this.patientID.setValue(patientID);
    }


    /**
     * <p>C:Patient Name</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }


    /**
     * <p>G:Immunization Period</p>
     */
    @Hl7XmlMapping({"immunizationPeriod/value"})
    public Interval<Date> getImmunizationPeriod() {
        return this.immunizationPeriod.getValue();
    }
    public void setImmunizationPeriod(Interval<Date> immunizationPeriod) {
        this.immunizationPeriod.setValue(immunizationPeriod);
    }


    /**
     * <p>Include Notes Indicator</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }
    public void setIncludeNotesIndicator(Boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }


    /**
     * <p>Include Issues Indicator</p>
     */
    @Hl7XmlMapping({"includeIssuesIndicator/value"})
    public Boolean getIncludeIssuesIndicator() {
        return this.includeIssuesIndicator.getValue();
    }
    public void setIncludeIssuesIndicator(Boolean includeIssuesIndicator) {
        this.includeIssuesIndicator.setValue(includeIssuesIndicator);
    }


    /**
     * <p>I:Renewal Period</p>
     */
    @Hl7XmlMapping({"renewalPeriod/value"})
    public Interval<Date> getRenewalPeriod() {
        return this.renewalPeriod.getValue();
    }
    public void setRenewalPeriod(Interval<Date> renewalPeriod) {
        this.renewalPeriod.setValue(renewalPeriod);
    }


    /**
     * <p>F:Vaccine Dose Number</p>
     */
    @Hl7XmlMapping({"vaccineDoseNumber/value"})
    public Integer getVaccineDoseNumber() {
        return this.vaccineDoseNumber.getValue();
    }
    public void setVaccineDoseNumber(Integer vaccineDoseNumber) {
        this.vaccineDoseNumber.setValue(vaccineDoseNumber);
    }


    /**
     * <p>E:Vaccine Code</p>
     */
    @Hl7XmlMapping({"vaccineCode/value"})
    public VaccineEntityType getVaccineCode() {
        return (VaccineEntityType) this.vaccineCode.getValue();
    }
    public void setVaccineCode(VaccineEntityType vaccineCode) {
        this.vaccineCode.setValue(vaccineCode);
    }


    /**
     * <p>H:Next Planned Dose Period</p>
     */
    @Hl7XmlMapping({"nextPlannedDosePeriod/value"})
    public Interval<Date> getNextPlannedDosePeriod() {
        return this.nextPlannedDosePeriod.getValue();
    }
    public void setNextPlannedDosePeriod(Interval<Date> nextPlannedDosePeriod) {
        this.nextPlannedDosePeriod.setValue(nextPlannedDosePeriod);
    }

}
