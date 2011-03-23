package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT980040CA.Component17" })
public class DosageLineWrapperBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -7923957589582260848L;

    private final INT sequenceNumber = new INTImpl();

    private DosageLineBean dosageLine;

    @Hl7XmlMapping("sequenceNumber")
    public int getSequenceNumber() {
        return sequenceNumber.getValue();
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }

    @Hl7XmlMapping("dosageLine")
    public DosageLineBean getDosageLine() {
        return dosageLine;
    }

    public void setDosageLine(DosageLineBean dosageLine) {
        this.dosageLine = dosageLine;
    }
}
