/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt050202ca;

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



@Hl7PartTypeMapping({"COCT_MT050202CA.Patient"})
@Hl7RootType
public class PatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.iehr.merged.Party, ca.infoway.messagebuilder.model.common.coct_mt470002ca.SubjectChoice, ca.infoway.messagebuilder.model.common.merged.Patient_2 {

    private static final long serialVersionUID = 20110127L;
    private TS patientBirthDate = new TSImpl();
    private CV patientGender = new CVImpl();
    private PN patientName = new PNImpl();
    private II patientIdentifier = new IIImpl();


    /**
     * <p>E:Patient Birth Date</p>
     */
    @Hl7XmlMapping({"patientPerson/birthTime"})
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }
    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }


    /**
     * <p>F:Patient Gender</p>
     */
    @Hl7XmlMapping({"patientPerson/administrativeGenderCode"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }


    /**
     * <p>B:Patient Name</p>
     */
    @Hl7XmlMapping({"patientPerson/name"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }


    /**
     * <p>A:Patient Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPatientIdentifier() {
        return this.patientIdentifier.getValue();
    }
    public void setPatientIdentifier(Identifier patientIdentifier) {
        this.patientIdentifier.setValue(patientIdentifier);
    }

}
