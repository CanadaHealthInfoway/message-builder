/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Patient</p>
 * 
 * <p>Indicates the type of patient for whom the dosage 
 * instruction applies.</p>
 * 
 * <p>Important for qualifying and filtering dosage 
 * specifications.</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Patient"})
public class PatientBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CV patientGender = new CVImpl();

    @Hl7XmlMapping({"patientLivingSubjectKind/administrativeGenderCode"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }

}
