package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ 
	"PORX_MT010110CA.Reason2", "PORX_MT010120CA.Reason2", "PORX_MT030040CA.Reason", 
	"PORX_MT060040CA.Reason2", "PORX_MT060060CA.Reason", "PORX_MT060190CA.Reason", "PORX_MT060160CA.Reason2" })
public class ReasonBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -9049218952620423437L;

    private final INT priorityNumber = new INTImpl();

    private Indication indication;

    @Hl7XmlMapping("priorityNumber")
    public Integer getPriorityNumber() {
        return this.priorityNumber.getValue();
    }

    public void setPriorityNumber(Integer priorityNumber) {
        this.priorityNumber.setValue(priorityNumber);
    }

    @Hl7XmlMapping("indications")
    public Indication getIndication() {
        return indication;
    }

    public void setIndication(Indication indication) {
        this.indication = indication;
    }
}
