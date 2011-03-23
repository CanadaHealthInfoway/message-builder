/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt980030ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.RecordedAtBean;
import java.util.Date;



/**
 * <p>Dispense</p>
 * 
 * <p>Indicates a particular dispense event that resulted in 
 * the issue.</p>
 * 
 * <p>Used when the issue pertains to the supply of the drug 
 * rather than the drug itself. E.g. Duplicate pharmacy, refill 
 * too soon, etc.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980030CA.SupplyEvent"})
public class DispenseBean extends MessagePartBean implements CausalActsBean {

    private static final long serialVersionUID = 20100614L;
    private II prescriptionDispenseNumber = new IIImpl();
    private CS dispenseStatus = new CSImpl();
    private IVL<TS, Interval<Date>> dispensedDate = new IVLImpl<TS, Interval<Date>>();
    private CV dispenseMaskingIndicator = new CVImpl();
    private DispensedBean product;
    private RecordedAtBean location;

    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getDispenseStatus() {
        return (ActStatus) this.dispenseStatus.getValue();
    }
    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispensedDate() {
        return this.dispensedDate.getValue();
    }
    public void setDispensedDate(Interval<Date> dispensedDate) {
        this.dispensedDate.setValue(dispensedDate);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getDispenseMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.dispenseMaskingIndicator.getValue();
    }
    public void setDispenseMaskingIndicator(x_VeryBasicConfidentialityKind dispenseMaskingIndicator) {
        this.dispenseMaskingIndicator.setValue(dispenseMaskingIndicator);
    }

    @Hl7XmlMapping({"product"})
    public DispensedBean getProduct() {
        return this.product;
    }
    public void setProduct(DispensedBean product) {
        this.product = product;
    }

    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }

}
