package ca.infoway.messagebuilder.model.newfoundland.cerx.query;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicineBean;

@Hl7PartTypeMapping("POME_MT010040CA.Medication")
public class DrugProductDetailRecord extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 6357168155492287270L;

    private MedicineBean medicine;

    @Hl7XmlMapping("player")
    public MedicineBean getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineBean medicine) {
        this.medicine = medicine;
    }
}
