/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.immunization.poiz_mt061140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Immunization Candidate Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for the query.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT061140CA.ParameterList"})
@Hl7RootType
public class ImmunizationCandidateQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV patientGender = new CVImpl();
    private IVL<TS, Interval<Date>> patientBirthDateRange = new IVLImpl<TS, Interval<Date>>();
    private CV vaccineCode = new CVImpl();
    private ST postalCode = new STImpl();
    private List<PatientIDBean> patientID = new ArrayList<PatientIDBean>();
    private IVL<TS, Interval<Date>> immunizationPeriod = new IVLImpl<TS, Interval<Date>>();
    private PN patientName = new PNImpl();
    private List<II> serviceDeliveryLocations = new ArrayList<II>();


    /**
     * <p>C:Patient Gender</p>
     * 
     * <p><p>Indicates the gender (sex) of the patient.</p></p>
     * 
     * <p><p>Used to confirm the identity of the patient for the 
     * query. As a result, this parameter is required.</p></p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }


    /**
     * <p>D:Patient Birth Date Range</p>
     * 
     * <p><p>Indicates the range of on which the patient was 
     * born.</p></p>
     * 
     * <p><p>Use to confirm identity of the patient for the query. 
     * As a result, this parameter is required.</p></p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Interval<Date> getPatientBirthDateRange() {
        return this.patientBirthDateRange.getValue();
    }
    public void setPatientBirthDateRange(Interval<Date> patientBirthDateRange) {
        this.patientBirthDateRange.setValue(patientBirthDateRange);
    }


    /**
     * <p>E:Vaccine Code</p>
     * 
     * <p><p>A coded value indicating a specific vaccine to be used 
     * in searching for patient immunization record.</p><p>The 
     * result set will be filtered to only include immunization 
     * records involving the specific vaccine code</p></p>
     * 
     * <p><p>A coded value indicating a specific vaccine to be used 
     * in searching for patient immunization record.</p><p>The 
     * result set will be filtered to only include immunization 
     * records involving the specific vaccine code</p></p>
     * 
     * <p><p>Allows for finer sub-set of immunization records to be 
     * retrieved based on the vaccine code used in the 
     * immunization. As a result, this parameter is required.</p></p>
     */
    @Hl7XmlMapping({"vaccineCode/value"})
    public ClinicalDrug getVaccineCode() {
        return (ClinicalDrug) this.vaccineCode.getValue();
    }
    public void setVaccineCode(ClinicalDrug vaccineCode) {
        this.vaccineCode.setValue(vaccineCode);
    }


    /**
     * <p>I:Postal Code</p>
     * 
     * <p><p>Indicates that the returned records should be filtered 
     * to only include those immunizations that occurred within a 
     * specified postal code area</p></p>
     * 
     * <p><p>Allows the requester to specify the postal code area 
     * of interest for the retrieval of immunization 
     * records.</p><p>Useful for constraining run-away queries. As 
     * a result, this parameter is required.</p></p>
     * 
     * <p><p>Allows the requester to specify the postal code area 
     * of interest for the retrieval of immunization 
     * records.</p><p>Useful for constraining run-away queries. As 
     * a result, this parameter is required.</p></p>
     */
    @Hl7XmlMapping({"postalCode/value"})
    public String getPostalCode() {
        return this.postalCode.getValue();
    }
    public void setPostalCode(String postalCode) {
        this.postalCode.setValue(postalCode);
    }


    @Hl7XmlMapping({"patientID"})
    public List<PatientIDBean> getPatientID() {
        return this.patientID;
    }


    /**
     * <p>G:Immunization Period</p>
     * 
     * <p><p>Indicates that the returned records should be filtered 
     * to only include those immunizations that occurred within the 
     * indicated time-period. This will commonly be used to 
     * retrieve 'all immunizations since xxx'.</p></p>
     * 
     * <p><p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries. As a result, this parameter 
     * is required.</p></p>
     * 
     * <p><p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries. As a result, this parameter 
     * is required.</p></p>
     */
    @Hl7XmlMapping({"immunizationPeriod/value"})
    public Interval<Date> getImmunizationPeriod() {
        return this.immunizationPeriod.getValue();
    }
    public void setImmunizationPeriod(Interval<Date> immunizationPeriod) {
        this.immunizationPeriod.setValue(immunizationPeriod);
    }


    /**
     * <p>B:Patient Name</p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * immunization candidate query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p></p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * immunization candidate query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient name. As a 
     * result, this parameter is required.</p></p>
     * 
     * <p><p>names are messaged as iterations of the PN datatype, 
     * with specific name parts identified as a type declaration in 
     * addition to the text string.</p></p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }


    /**
     * <p>H:Service Delivery Locations</p>
     * 
     * <p><p>Indicates that the returned records should be filtered 
     * to only include those immunizations that occurred at an 
     * identified service delivery location</p></p>
     * 
     * <p><p>Allows the requester to specify the service delivery 
     * location of interest for the retrieval of immunization 
     * records.</p><p>Useful for constraining run-away queries. As 
     * a result, this parameter is required.</p></p>
     * 
     * <p><p>Allows the requester to specify the service delivery 
     * location of interest for the retrieval of immunization 
     * records.</p><p>Useful for constraining run-away queries. As 
     * a result, this parameter is required.</p></p>
     */
    @Hl7XmlMapping({"serviceDeliveryLocation/value"})
    public List<Identifier> getServiceDeliveryLocations() {
        return new RawListWrapper<II, Identifier>(serviceDeliveryLocations, IIImpl.class);
    }

}
