/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt050007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.PatientCharacteristicObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Patient Identifying Characteristics</p>
 * 
 * <p>For this model, the observation is a description of 
 * patient characteristics used for identification.</p>
 * 
 * <p>Used for patient identification when the client registry 
 * is not available.</p>
 */
@Hl7PartTypeMapping({"COCT_MT050007CA.IdentifyingCharacteristicsObservationEvent"})
public class PatientIdentifyingCharacteristicsBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CV identifyingCharacteristicsObservationType = new CVImpl();
    private ST patientCharacteristicsText = new STImpl();

    @Hl7XmlMapping({"code"})
    public PatientCharacteristicObservationType getIdentifyingCharacteristicsObservationType() {
        return (PatientCharacteristicObservationType) this.identifyingCharacteristicsObservationType.getValue();
    }
    public void setIdentifyingCharacteristicsObservationType(PatientCharacteristicObservationType identifyingCharacteristicsObservationType) {
        this.identifyingCharacteristicsObservationType.setValue(identifyingCharacteristicsObservationType);
    }

    @Hl7XmlMapping({"value"})
    public String getPatientCharacteristicsText() {
        return this.patientCharacteristicsText.getValue();
    }
    public void setPatientCharacteristicsText(String patientCharacteristicsText) {
        this.patientCharacteristicsText.setValue(patientCharacteristicsText);
    }

}
