/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pharmacy.porx_mt010140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt220100ca.DrugProductBean;



/**
 * <p>Remaining Dispenses</p>
 * 
 * <p><p>Indicates dispenses yet to be made against the 
 * prescription</p></p>
 * 
 * <p><p>Allows updating the quantity remaining to be 
 * dispensed.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010140CA.SupplyEvent"})
public class RemainingDispensesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private PQ remainingQuantity = new PQImpl();
    private DrugProductBean productMedication;


    /**
     * <p>C:Remaining Quantity</p>
     * 
     * <p><p>Indicates the remaining quantity to be dispensed.</p></p>
     * 
     * <p><p>Used to adjust quantity asserted with the electronic 
     * version of a prescription when fills have been issued by 
     * non-electronic pharmacies. Particularly important when the 
     * electronic version is being made 'authoritative' again.</p></p>
     * 
     * <p><p>The specified remaining fill quantity may never be 
     * greater than the remaining quantity recorded in the 
     * electronic system. If not specified, the quantity remaining 
     * will be left unchanged.</p></p>
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
