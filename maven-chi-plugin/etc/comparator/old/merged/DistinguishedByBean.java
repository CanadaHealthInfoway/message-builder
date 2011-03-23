/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.MedicationObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POME_MT010040CA.Subject10","POME_MT010100CA.Subject10"})
public class DistinguishedByBean extends MessagePartBean {

    private CV<MedicationObservationType> characteristicType = new CVImpl<MedicationObservationType>();
    private ST characteristic = new STImpl();

    @Hl7XmlMapping({"characteristic/code"})
    public MedicationObservationType getCharacteristicType() {
        return this.characteristicType.getValue();
    }
    public void setCharacteristicType(MedicationObservationType characteristicType) {
        this.characteristicType.setValue(characteristicType);
    }

    @Hl7XmlMapping({"characteristic/value"})
    public java.lang.String getCharacteristic() {
        return this.characteristic.getValue();
    }
    public void setCharacteristic(java.lang.String characteristic) {
        this.characteristic.setValue(characteristic);
    }

}
