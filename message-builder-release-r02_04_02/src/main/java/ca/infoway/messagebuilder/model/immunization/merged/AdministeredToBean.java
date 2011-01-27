/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.merged.Patient_2Bean;



/**
 * <p>AdministeredTo</p>
 * 
 * <p>POIZ_MT030060CA.Subject10: (no business name)</p>
 * 
 * <p><p>Indicates the patient who was immunized.</p></p>
 * 
 * <p><p>Essential for linking the immunization to the 
 * patient's record, and is therefore mandatory.</p></p>
 * 
 * <p>POIZ_MT070020CA.Subject: administered to</p>
 * 
 * <p><p>Indicates the patient who is scheduled to be 
 * immunized.</p></p>
 * 
 * <p><p>Essential for linking the immunization to the 
 * patient's record, and is therefore mandatory.</p></p>
 * 
 * <p>POIZ_MT061150CA.Subject10: *administered to</p>
 * 
 * <p><p>Indicates the patient who was immunized.</p></p>
 * 
 * <p><p>Essential for linking the immunization to the 
 * patient's record, and is therefore mandatory.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Subject10","POIZ_MT030060CA.Subject10","POIZ_MT060150CA.Subject10","POIZ_MT061150CA.Subject10","POIZ_MT070020CA.Subject"})
public class AdministeredToBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private Patient_2Bean patient;


    @Hl7XmlMapping({"patient"})
    public Patient_2Bean getPatient() {
        return this.patient;
    }
    public void setPatient(Patient_2Bean patient) {
        this.patient = patient;
    }

}
