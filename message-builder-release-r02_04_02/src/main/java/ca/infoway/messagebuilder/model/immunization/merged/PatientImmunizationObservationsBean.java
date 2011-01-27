/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.immunization.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PatientImmunizationObservations</p>
 * 
 * <p>POIZ_MT060150CA.PatientImmunizationObservations: Patient 
 * Immunization Observations</p>
 * 
 * <p><p>Captures a wide range of observations mandated by the 
 * appropriate or organizational administrative definitions or 
 * other criteria that govern reporting.</p></p>
 * 
 * <p><p>Provides a mechanism to communicate information that 
 * is not otherwise modeled.</p></p>
 * 
 * <p>POIZ_MT030050CA.PatientImmunizationObservations: Patient 
 * Immunization Observations</p>
 * 
 * <p><p>Captures a wide range of observations mandated by the 
 * appropriate or organizational administrative definitions or 
 * other criteria that govern reporting.</p></p>
 * 
 * <p><p>Provides a mechanism to communicate information that 
 * is not otherwise modeled.</p></p>
 * 
 * <p>POIZ_MT030060CA.PatientImmunizationObservations: Patient 
 * Immunization Observations</p>
 * 
 * <p><p>Captures a wide range of observations mandated by the 
 * appropriate or organizational administrative definitions or 
 * other criteria that govern reporting.</p></p>
 * 
 * <p><p>Provides a mechanism to communicate information that 
 * is not otherwise modeled.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.PatientImmunizationObservations","POIZ_MT030060CA.PatientImmunizationObservations","POIZ_MT060150CA.PatientImmunizationObservations"})
public class PatientImmunizationObservationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private ANY<Object> patientImmunizationObservationValue = new ANYImpl<Object>();
    private CV patientImmunizationObservationType = new CVImpl();


    /**
     * <p>PatientImmunizationObservationValue</p>
     * 
     * <p>Patient Immunization Observation Value</p>
     * 
     * <p><p>Allows the specification of a value related to the 
     * patient immunization observation in question.</p></p>
     * 
     * <p><p>Needed to convey meaning of the patient immunization 
     * observation. As a result, this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Object getPatientImmunizationObservationValue() {
        return this.patientImmunizationObservationValue.getValue();
    }
    public void setPatientImmunizationObservationValue(Object patientImmunizationObservationValue) {
        this.patientImmunizationObservationValue.setValue(patientImmunizationObservationValue);
    }


    /**
     * <p>PatientImmunizationObservationType</p>
     * 
     * <p>Patient Immunization Observation Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getPatientImmunizationObservationType() {
        return (Code) this.patientImmunizationObservationType.getValue();
    }
    public void setPatientImmunizationObservationType(Code patientImmunizationObservationType) {
        this.patientImmunizationObservationType.setValue(patientImmunizationObservationType);
    }

}
