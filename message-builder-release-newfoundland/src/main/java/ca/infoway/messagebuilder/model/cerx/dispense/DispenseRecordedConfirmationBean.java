package ca.infoway.messagebuilder.model.cerx.dispense;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT020030CA.SupplyEvent" })
public class DispenseRecordedConfirmationBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 3761320389995371050L;

    private II dispenseId = new IIImpl();

    private II prescriptionId = new IIImpl();

    @Hl7XmlMapping("id")
    public Identifier getDispenseId() {
        return this.dispenseId.getValue();
    }

    public void setDispenseId(Identifier dispenseId) {
        this.dispenseId.setValue(dispenseId);
    }

    @Hl7XmlMapping("inFulfillmentOf/actRequest/id")
    public Identifier getPrescriptionId() {
        return this.prescriptionId.getValue();
    }

    public void setPrescriptionId(Identifier prescriptionId) {
        this.prescriptionId.setValue(prescriptionId);
    }
}
