/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt260030ca;

import java.util.Date;
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;



/**
 * <p>Dispense</p>
 * 
 * <p><p>Indicates a particular dispense event that resulted in 
 * the issue.</p></p>
 * 
 * <p><p>Used when the issue pertains to the supply of the drug 
 * rather than the drug itself. E.g. Duplicate pharmacy, refill 
 * too soon, etc.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260030CA.SupplyEvent"})
public class DispenseBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.CausalActs {

    private static final long serialVersionUID = 20110831L;
    private II prescriptionDispenseNumber = new IIImpl();
    private CS dispenseStatus = new CSImpl();
    private IVL<TS, Interval<Date>> dispensedDate = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> dispenseMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private DispensedBean product;
    private OccurredAtBean location;


    /**
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p><p>Unique identifier of the dispensed event that 
     * triggered the issue.</p></p>
     * 
     * <p><p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }


    /**
     * <p>B:Dispense Status</p>
     * 
     * <p><p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p></p>
     * 
     * <p><p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getDispenseStatus() {
        return (ActStatus) this.dispenseStatus.getValue();
    }
    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
    }


    /**
     * <p>B:Dispensed Date</p>
     * 
     * <p><p>The date and time on which the product was issued to 
     * the patient.</p></p>
     * 
     * <p><p>ZDU.4.5</p></p>
     * 
     * <p><p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as &quot;populated&quot; 
     * as a dispense record may not exist without processing 
     * date.</p></p>
     * 
     * <p><p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as &quot;populated&quot; 
     * as a dispense record may not exist without processing 
     * date.</p></p>
     * 
     * <p><p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispensedDate() {
        return this.dispensedDate.getValue();
    }
    public void setDispensedDate(Interval<Date> dispensedDate) {
        this.dispensedDate.setValue(dispensedDate);
    }


    /**
     * <p>C:Dispense Masking Indicator</p>
     * 
     * <p><p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p></p>
     * 
     * <p><p>Conveys the patient's wishes relating to the 
     * sensitivity of the drug information.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p>Conveys the patient's wishes relating to the 
     * sensitivity of the drug information.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getDispenseMaskingIndicator() {
        return this.dispenseMaskingIndicator.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"product"})
    public DispensedBean getProduct() {
        return this.product;
    }
    public void setProduct(DispensedBean product) {
        this.product = product;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }

}
