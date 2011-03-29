/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.porx_mt010140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt220100ca.DrugProductBean;



@Hl7PartTypeMapping({"PORX_MT010140CA.SupplyEvent"})
public class RemainingDispensesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private PQ remainingQuantity = new PQImpl();
    private DrugProductBean productMedication;


    /**
     * <p>C:Remaining Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getRemainingQuantity() {
        return this.remainingQuantity.getValue();
    }
    public void setRemainingQuantity(PhysicalQuantity remainingQuantity) {
        this.remainingQuantity.setValue(remainingQuantity);
    }


    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }

}