/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.OccurredAtBean;
import java.util.Date;



/**
 * <p>PORX_MT020070CA.SupplyRequest: (no business name)</p>
 * 
 * <p><p>Additional information about the prescription being 
 * fulfilled.</p></p>
 * 
 * <p><p>Important in understanding the patient's treatment. 
 * May also be required by the EHR repository.</p></p>
 * 
 * <p>PORX_MT020060CA.SupplyRequest2: (no business name)</p>
 * 
 * <p><p>At least one of Total Prescribed Quantity and Total 
 * Days Supply must be present and not Null.</p></p>
 * 
 * <p><p>Additional information about the prescription being 
 * fulfilled.</p></p>
 * 
 * <p><p>Important in understanding the patient's treatment. 
 * May also be required by the EHR repository.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020060CA.SupplyRequest2","PORX_MT020070CA.SupplyRequest","PORX_MT060190CA.SupplyRequest"})
public class SupplyRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private PQ totalPrescribedQuantity = new PQImpl();
    private OccurredAtBean location;
    private CS prescriptionDispensableIndicator = new CSImpl();
    private INT numberOfAuthorizedFills = new INTImpl();
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>TotalPrescribedQuantity</p>
     * 
     * <p>B:Total Prescribed Quantity</p>
     * 
     * <p><p>The overall amount of amount medication to be 
     * dispensed under this prescription. Includes any first fills 
     * (trials, aligning quantities), the initial standard fill 
     * plus all refills.</p></p>
     * 
     * <p><p>Sets upper limit for medication to be dispensed. Can 
     * be used to verify the intention of the prescriber with 
     * respect to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p></p>
     * 
     * <p>Total Prescribed Quantity</p>
     * 
     * <p><p>The overall amount of amount medication to be 
     * dispensed under this prescription. Includes any first fills 
     * (trials, aligning quantities), the initial standard fill 
     * plus all refills.</p></p>
     * 
     * <p><p>Critical in understanding the patient's medication 
     * profile, both past and current. This also allows 
     * determination of the amount that remains to be dispensed 
     * against the prescription.</p></p>
     * 
     * <p>Total Prescribed Quantity</p>
     * 
     * <p><p>The overall amount to be dispensed under this 
     * prescription. Includes the initial standard fill plus all 
     * refills</p></p>
     * 
     * <p><p>Critical in understanding the patient's profile, both 
     * past and current. This also allows determination of the 
     * amount that remains to be dispensed against the 
     * prescription.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(PhysicalQuantity totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    /**
     * <p>PrescriptionDispensableIndicator</p>
     * 
     * <p>A:Prescription Dispensable Indicator</p>
     * 
     * <p><p>This generally mirrors the status for the 
     * prescription, but in some circumstances may be changed to 
     * 'aborted' while the prescription is still active. When this 
     * occurs, it means the prescription may no longer be 
     * dispensed, though it may still be administered.</p></p>
     * 
     * <p><p>Allows the dispensing authorization of the 
     * prescription to be controlled/manipulates as 
     * needed.</p><p>Attribute is marked as &quot;mandatory&quot; 
     * as the dispensing authority of the prescription will always 
     * be known.</p></p>
     * 
     * <p><p>Allows the dispensing authorization of the 
     * prescription to be controlled/manipulates as 
     * needed.</p><p>Attribute is marked as &quot;mandatory&quot; 
     * as the dispensing authority of the prescription will always 
     * be known.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionDispensableIndicator() {
        return (ActStatus) this.prescriptionDispensableIndicator.getValue();
    }
    public void setPrescriptionDispensableIndicator(ActStatus prescriptionDispensableIndicator) {
        this.prescriptionDispensableIndicator.setValue(prescriptionDispensableIndicator);
    }


    /**
     * <p>NumberOfAuthorizedFills</p>
     * 
     * <p>Number of Authorized Fills</p>
     * 
     * <p><p>Records the total number of fills authorized</p></p>
     * 
     * <p><p>Regulation prevents this number from being calculated 
     * in some jurisdictions.</p></p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getNumberOfAuthorizedFills() {
        return this.numberOfAuthorizedFills.getValue();
    }
    public void setNumberOfAuthorizedFills(Integer numberOfAuthorizedFills) {
        this.numberOfAuthorizedFills.setValue(numberOfAuthorizedFills);
    }


    /**
     * <p>TotalDaysSupply</p>
     * 
     * <p>Total Days Supply</p>
     * 
     * <p><p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription.</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy').</p></p>
     * 
     * <p>Total Days Supply</p>
     * 
     * <p><p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and administration of the prescription.</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy').</p><p>As it should always be known and for the 
     * reasons cited, the attribute is Mandatory.</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy').</p><p>As it should always be known and for the 
     * reasons cited, the attribute is Mandatory.</p></p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }

}