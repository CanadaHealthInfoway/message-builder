package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT010120CA.SupplyRequestItem", "PORX_MT010140CA.SupplyEvent", "PORX_MT020070CA.SupplyRequest" })
public class SupplyRequestBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -928443315583435934L;

    private final PQ quantity = new PQImpl();

    private final IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();

    private MedicineBean product;

    private FillInstructionsBean subsequentSupplyRequest;

    private FillInstructionsBean intitialSupplyRequest;

    @Hl7XmlMapping("quantity")
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

    @Hl7XmlMapping("expectedUseTime")
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }

    @Hl7XmlMapping("product/medication/player")
    public MedicineBean getProduct() {
        return product;
    }

    public void setProduct(MedicineBean product) {
        this.product = product;
    }

    @Hl7XmlMapping("component1/subsequentSupplyRequest")
    public FillInstructionsBean getSubsequentSupplyRequest() {
        return subsequentSupplyRequest;
    }

    public void setSubsequentSupplyRequest(FillInstructionsBean subsequentSupplyRequest) {
        this.subsequentSupplyRequest = subsequentSupplyRequest;
    }

    @Hl7XmlMapping("component2/initialSupplyRequest")
    public FillInstructionsBean getIntitialSupplyRequest() {
        return intitialSupplyRequest;
    }

    public void setIntitialSupplyRequest(FillInstructionsBean intitialSupplyRequest) {
        this.intitialSupplyRequest = intitialSupplyRequest;
    }
}
