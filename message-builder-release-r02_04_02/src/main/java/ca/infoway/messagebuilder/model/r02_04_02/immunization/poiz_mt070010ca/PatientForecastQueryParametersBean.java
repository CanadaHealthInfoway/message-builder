/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.immunization.poiz_mt070010ca;

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
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Patient Forecast Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT070010CA.ParameterList"})
@Hl7RootType
public class PatientForecastQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private TS patientBirthDate = new TSImpl();
    private CV patientGender = new CVImpl();
    private II patientIdentifier = new IIImpl();
    private PN patientName = new PNImpl();


    /**
     * <p>Patient Birth Date</p>
     * 
     * <p><p>Indicates the date on which the patient was born.</p></p>
     * 
     * <p><p>Use to confirm identity of the patient for the query. 
     * Full dates must be specified. As a result, this attribute is 
     * required.</p></p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }
    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }


    /**
     * <p>Patient Gender</p>
     * 
     * <p><p>Indicates the gender (sex) of the patient.</p></p>
     * 
     * <p><p>Used to confirm the identity of the patient for the 
     * query. As a result, this attribute is required.</p></p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }


    /**
     * <p>Patient Identifier</p>
     * 
     * <p><p>Identifier of the patient who is the subject of the 
     * patient forecast query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient ID. This is 
     * the key parameter and must always be present. As a result, 
     * this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIdentifier() {
        return this.patientIdentifier.getValue();
    }
    public void setPatientIdentifier(Identifier patientIdentifier) {
        this.patientIdentifier.setValue(patientIdentifier);
    }


    /**
     * <p>Patient Name</p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * patient forecast query.</p></p>
     * 
     * <p><p>This information is used to confirm the patient id. As 
     * a result, this attribute is required.</p></p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }

}