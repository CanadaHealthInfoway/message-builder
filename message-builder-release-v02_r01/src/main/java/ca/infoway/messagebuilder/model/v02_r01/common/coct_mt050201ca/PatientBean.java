/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.coct_mt050201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT050201CA.Patient"})
@Hl7RootType
public class PatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.v02_r01.common.merged.Patient_2 {

    private static final long serialVersionUID = 20110318L;
    private II patientIdentifier = new IIImpl();


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