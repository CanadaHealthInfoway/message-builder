/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.porx_mt060160ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.Component7Bean;
import ca.infoway.messagebuilder.model.merged.DrugProductBean;
import java.util.Date;



/**
 * <p>g:includes 
 * 
 * <p>Identifies the instructions for how the prescribed 
 * medication should be dispensed to the patient. 
 * 
 * <p>An essential part of most prescriptions is the 
 * authorization to dispense. Multiple repetitions are included 
 * to accommodate circumstances where multiple drug products 
 * may need to be dispensed to complete a therapy. E.g. 100 x 
 * 20mg tablets and 50 x 10mg tablets. The association is 
 * marked as Populated because the authorization to dispense is 
 * a critical portion of a prescription. However the 
 * association is allowed to be 'null' when the order is for a 
 * medication which requires no dispense authorization (e.g. 
 * over-the-counter medications), or when the patient already 
 * has sufficient supply of the medication on hand to complete 
 * the therapy. 
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.Component3"})
public class Component3Bean extends MessagePartBean {

    private PQ totalPrescribedQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean supplyRequestItemProductMedication = new DrugProductBean();
    private Component7Bean supplyRequestItemComponent1;
    private IVL<TS, Interval<Date>> dispenseInterval = new IVLImpl<TS, Interval<Date>>();
    private INT numberOfFills = new INTImpl();
    private PQ fillQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> daysSupply = new IVLImpl<TS, Interval<Date>>();

    @Hl7XmlMapping({"supplyRequestItem/quantity"})
    public PhysicalQuantity getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(PhysicalQuantity totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }

    @Hl7XmlMapping({"supplyRequestItem/expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }

    @Hl7XmlMapping({"supplyRequestItem/product/medication"})
    public DrugProductBean getSupplyRequestItemProductMedication() {
        return this.supplyRequestItemProductMedication;
    }
    public void setSupplyRequestItemProductMedication(DrugProductBean supplyRequestItemProductMedication) {
        this.supplyRequestItemProductMedication = supplyRequestItemProductMedication;
    }

    @Hl7XmlMapping({"supplyRequestItem/component1"})
    public Component7Bean getSupplyRequestItemComponent1() {
        return this.supplyRequestItemComponent1;
    }
    public void setSupplyRequestItemComponent1(Component7Bean supplyRequestItemComponent1) {
        this.supplyRequestItemComponent1 = supplyRequestItemComponent1;
    }

    @Hl7XmlMapping({"supplyRequestItem/component2/subsequentSupplyRequest/effectiveTime"})
    public Interval<Date> getDispenseInterval() {
        return this.dispenseInterval.getValue();
    }
    public void setDispenseInterval(Interval<Date> dispenseInterval) {
        this.dispenseInterval.setValue(dispenseInterval);
    }

    @Hl7XmlMapping({"supplyRequestItem/component2/subsequentSupplyRequest/repeatNumber"})
    public java.lang.Integer getNumberOfFills() {
        return this.numberOfFills.getValue();
    }
    public void setNumberOfFills(java.lang.Integer numberOfFills) {
        this.numberOfFills.setValue(numberOfFills);
    }

    @Hl7XmlMapping({"supplyRequestItem/component2/subsequentSupplyRequest/quantity"})
    public PhysicalQuantity getFillQuantity() {
        return this.fillQuantity.getValue();
    }
    public void setFillQuantity(PhysicalQuantity fillQuantity) {
        this.fillQuantity.setValue(fillQuantity);
    }

    @Hl7XmlMapping({"supplyRequestItem/component2/subsequentSupplyRequest/expectedUseTime"})
    public Interval<Date> getDaysSupply() {
        return this.daysSupply.getValue();
    }
    public void setDaysSupply(Interval<Date> daysSupply) {
        this.daysSupply.setValue(daysSupply);
    }

}
