/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.coct_mt260030ca;

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
import ca.infoway.messagebuilder.model.v02_r01.merged.CreatedAtBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT260030CA.SupplyEvent"})
public class DispenseBean extends MessagePartBean implements ca.infoway.messagebuilder.model.v02_r01.common.merged.CausalActs {

    private static final long serialVersionUID = 20110318L;
    private II prescriptionDispenseNumber = new IIImpl();
    private CV dispenseMaskingIndicator = new CVImpl();
    private IVL<TS, Interval<Date>> dispensedDate = new IVLImpl<TS, Interval<Date>>();
    private DispensedBean product;
    private CS dispenseStatus = new CSImpl();
    private CreatedAtBean location;


    /**
     * <p>A:Prescription Dispense Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }


    /**
     * <p>C:Dispense Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getDispenseMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.dispenseMaskingIndicator.getValue();
    }
    public void setDispenseMaskingIndicator(x_VeryBasicConfidentialityKind dispenseMaskingIndicator) {
        this.dispenseMaskingIndicator.setValue(dispenseMaskingIndicator);
    }


    /**
     * <p>B:Dispensed Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispensedDate() {
        return this.dispensedDate.getValue();
    }
    public void setDispensedDate(Interval<Date> dispensedDate) {
        this.dispensedDate.setValue(dispensedDate);
    }


    @Hl7XmlMapping({"product"})
    public DispensedBean getProduct() {
        return this.product;
    }
    public void setProduct(DispensedBean product) {
        this.product = product;
    }


    /**
     * <p>B:Dispense Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getDispenseStatus() {
        return (ActStatus) this.dispenseStatus.getValue();
    }
    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

}
