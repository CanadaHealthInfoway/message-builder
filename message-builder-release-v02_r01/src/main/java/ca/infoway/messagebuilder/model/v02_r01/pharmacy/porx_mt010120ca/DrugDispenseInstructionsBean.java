/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt220100ca.DrugProductBean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged.FirstFillBean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged.SubsequentSupplyRequestBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT010120CA.SupplyRequestItem"})
public class DrugDispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private PQ totalPrescribedQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean productMedication;
    private SubsequentSupplyRequestBean component1SubsequentSupplyRequest;
    private FirstFillBean component2InitialSupplyRequest;


    /**
     * <p>B:Total Prescribed Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(PhysicalQuantity totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }


    /**
     * <p>A:Total Days Supply</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }


    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    @Hl7XmlMapping({"component1/subsequentSupplyRequest"})
    public SubsequentSupplyRequestBean getComponent1SubsequentSupplyRequest() {
        return this.component1SubsequentSupplyRequest;
    }
    public void setComponent1SubsequentSupplyRequest(SubsequentSupplyRequestBean component1SubsequentSupplyRequest) {
        this.component1SubsequentSupplyRequest = component1SubsequentSupplyRequest;
    }


    @Hl7XmlMapping({"component2/initialSupplyRequest"})
    public FirstFillBean getComponent2InitialSupplyRequest() {
        return this.component2InitialSupplyRequest;
    }
    public void setComponent2InitialSupplyRequest(FirstFillBean component2InitialSupplyRequest) {
        this.component2InitialSupplyRequest = component2InitialSupplyRequest;
    }

}
