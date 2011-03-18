/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.immunization.poiz_mt060140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Immunization Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT060140CA.ParameterList"})
@Hl7RootType
public class ImmunizationQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private TS patientBirthDate = new TSImpl();
    private CV patientGender = new CVImpl();
    private II immunizationEventID = new IIImpl();
    private SET<II, Identifier> patientIdentifiers = new SETImpl<II, Identifier>(IIImpl.class);
    private PN patientName = new PNImpl();


    /**
     * <p>E:Patient Birth Date</p>
     * 
     * <p><p>Indicates the date on which the patient was born.</p></p>
     * 
     * <p><p>Use to confirm identity of the patient for the query. 
     * As a result, this attribute is required.</p></p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }
    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }


    /**
     * <p>D:Patient Gender</p>
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
     * <p>A:Immunization Event ID</p>
     * 
     * <p><p>Specifies the identifier of the immunization event</p></p>
     * 
     * <p><p>Allows for filtering of queries by immuniation event 
     * ID. As a result, this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"immunizationEventID/value"})
    public Identifier getImmunizationEventID() {
        return this.immunizationEventID.getValue();
    }
    public void setImmunizationEventID(Identifier immunizationEventID) {
        this.immunizationEventID.setValue(immunizationEventID);
    }


    /**
     * <p>B:Patient Identifiers</p>
     * 
     * <p><p>Identifier of the patient who is the subject of the 
     * patient immunization query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient ID. This 
     * information is used to verify the record. As a result, this 
     * attribute is required.</p></p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Set<Identifier> getPatientIdentifiers() {
        return this.patientIdentifiers.rawSet();
    }


    /**
     * <p>C:Patient Name</p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * patient immunization query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p></p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * patient immunization query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient name. This 
     * information is used to verify the record. As a result, this 
     * attribute is required.</p></p>
     * 
     * <p><p>Names are messaged as iterations of the PN datatype, 
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

}
