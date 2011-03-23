package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT060040CA.SupplementalFillInformation" })
public class SupplementalFillInformationBean extends MessagePartBean implements Serializable {

    private INT numberOfFills = new INTImpl();

    private INT fillQuantity = new INTImpl();

    private static final long serialVersionUID = 567672969236440319L;

    @Hl7XmlMapping({ "repeatNumber" })
    public Integer getNumberOfFills() {
        return this.numberOfFills.getValue();
    }

    public void setNumberOfFills(Integer numberOfFills) {
        this.numberOfFills.setValue(numberOfFills);
    }

    @Hl7XmlMapping({ "quantity" })
    public Integer getFillQuantity() {
        return this.fillQuantity.getValue();
    }

    public void setFillQuantity(Integer fillQuantity) {
        this.fillQuantity.setValue(fillQuantity);
    }
}
