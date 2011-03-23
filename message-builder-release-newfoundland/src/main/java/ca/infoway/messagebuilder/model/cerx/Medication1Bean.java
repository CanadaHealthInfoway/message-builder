package ca.infoway.messagebuilder.model.cerx;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping("COCT_MT220100CA.Medication")
public class Medication1Bean extends MessagePartBean implements MedicationChoice {

    private static final long serialVersionUID = -2066276899139113713L;

    private MedicineBean medicineBean;

    @Hl7XmlMapping("player")
    public MedicineBean getMedicineBean() {
        return medicineBean;
    }

    public void setMedicineBean(MedicineBean medicineBean) {
        this.medicineBean = medicineBean;
    }
}
