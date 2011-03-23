/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt010140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt220100ca.DrugProductBean;



/**
 * <p>Remaining Dispenses</p>
 * 
 * <p>Indicates dispenses yet to be made against the 
 * prescription</p>
 * 
 * <p>Allows updating the quantity remaining to be dispensed.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010140CA.SupplyEvent"})
public class RemainingDispensesBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private PQ remainingQuantity = new PQImpl();
    private DrugProductBean productMedication;

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
