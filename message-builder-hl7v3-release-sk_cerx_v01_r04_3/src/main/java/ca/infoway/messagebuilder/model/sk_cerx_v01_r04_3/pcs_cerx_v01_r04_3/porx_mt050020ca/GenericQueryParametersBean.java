/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt050020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Generic Query Parameters</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Defines the 
 * set of parameters that may be used to filter the query 
 * response.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Root class 
 * for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT050020CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private CV drugCode = new CVImpl();
    private TS patientBirthDate = new TSImpl();
    private CV patientGender = new CVImpl();
    private II patientID = new IIImpl();
    private PN patientName = new PNImpl();


    /**
     * <p>E:Drug Code</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * that the result set is to be filtered to include only those 
     * contraindications pertaining to the specified drug.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The code may refer 
     * to an administerable medication, an orderable medication or 
     * a higher level drug classification.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The 
     * contraindication records retrieve would comprise the 
     * drug-drug interactions between this specified and each of 
     * the drugs on the patient's profile, as well as drug-disease 
     * and drug-allergy contraindications that might result (based 
     * on the information on the patient's profile).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * that the result set is to be filtered to include only those 
     * contraindications pertaining to the specified drug.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The code may refer 
     * to an administerable medication, an orderable medication or 
     * a higher level drug classification.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The 
     * contraindication records retrieve would comprise the 
     * drug-drug interactions between this specified and each of 
     * the drugs on the patient's profile, as well as drug-disease 
     * and drug-allergy contraindications that might result (based 
     * on the information on the patient's profile).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * that the result set is to be filtered to include only those 
     * contraindications pertaining to the specified drug.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The code may refer 
     * to an administerable medication, an orderable medication or 
     * a higher level drug classification.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The 
     * contraindication records retrieve would comprise the 
     * drug-drug interactions between this specified and each of 
     * the drugs on the patient's profile, as well as drug-disease 
     * and drug-allergy contraindications that might result (based 
     * on the information on the patient's profile).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the retrieval of all potential contraindications based on a 
     * specific medication being introduced onto the patient's 
     * medication profile. Contraindications can't be found without 
     * specifying the medication, therefore this attribute is 
     * mandatory.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This will most 
     * commonly be used by providers to test the viability of 
     * prescribing/dispensing a medication to a patient (in view of 
     * the patient's existing medication profile).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the retrieval of all potential contraindications based on a 
     * specific medication being introduced onto the patient's 
     * medication profile. Contraindications can't be found without 
     * specifying the medication, therefore this attribute is 
     * mandatory.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This will most 
     * commonly be used by providers to test the viability of 
     * prescribing/dispensing a medication to a patient (in view of 
     * the patient's existing medication profile).</p></p>
     */
    @Hl7XmlMapping({"drugCode/value"})
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }


    /**
     * <p>D:Patient Birth Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the date on which the patient was born.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used to 
     * confirm the identity of the patient for the query and is 
     * therefore mandatory.</p></p>
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
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the gender (sex) of the patient.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used to 
     * confirm the identity of the patient for the query and is 
     * therefore mandatory.</p></p>
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
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifier 
     * of the patient who is the subject of the patient drug 
     * contraindication query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * filtering of result set by patient Id. This is a mandatory 
     * field because a patient must be specified for the query to 
     * be valid</p></p>
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
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the patient who is the subject of the drug contraindication 
     * query.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Filter the result 
     * set to include only those records pertaining to the patient 
     * with this name.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the patient who is the subject of the drug contraindication 
     * query.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Filter the result 
     * set to include only those records pertaining to the patient 
     * with this name.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * filtering of result set by patient name. This is a mandatory 
     * field because a patient name must match the patient Id for 
     * the query to be valid.</p></p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }

}
