/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import java.util.Date;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.DispensedBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ServiceDeliveryLocationBean;



/**
 * <p>PORX_MT020030CA.SupplyEvent: Prescription Dispense 
 * Response</p>
 * 
 * <p><p>Represents the information returned when a dispense 
 * has been accepted</p></p>
 * 
 * <p><p>Allows communication of the identifiers assigned to 
 * the dispense and the prescription by the DIS.</p></p>
 * 
 * <p>PORX_MT020020CA.SupplyEvent: Dispense Pickup</p>
 * 
 * <p><p>Captures information about what prescription was 
 * picked up and who received it.</p></p>
 * 
 * <p><p>The root class for the message. The time of pickup is 
 * specified on the ControlAct wrapper.</p></p>
 * 
 * <p>PORX_MT020050CA.SupplyEvent: Office Supply</p>
 * 
 * <p><p>This is the detailed information about a medication 
 * being supplied for office use.</p></p>
 * 
 * <p><p>Allows for tracking of medications supplied to an 
 * office.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020020CA.SupplyEvent","PORX_MT020030CA.SupplyEvent","PORX_MT020050CA.SupplyEvent"})
@Hl7RootType
public class PrescriptionDispenseResponseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II id = new IIImpl();
    private SET<II, Identifier> prescriptionOrderNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private RelatedPersonBean receiverPersonalRelationship;
    private TS supplyDate = new TSImpl();
    private PQ suppliedQuantity = new PQImpl();
    private DispensedBean product;
    private ServiceDeliveryLocationBean destinationServiceDeliveryLocation;
    private SupplyOrderBean fulfillmentSupplyRequest;
    private IncludesBean subjectOf;


    /**
     * <p>A:Local Dispense ID</p>
     * 
     * <p><p>Identifier assigned by the dispensing facility.</p></p>
     * 
     * <p><p>Allows formal tracking of centrally recorded dispenses 
     * to local records for audit and related purposes.</p></p>
     * 
     * <p>Dispense Identifier</p>
     * 
     * <p><p>Identifier of a dispense event to be used by the 
     * requesting dispenser.</p></p>
     * 
     * <p><p>Establishes a record of impending dispense on the 
     * prescription. Attribute is mandatory to ensure that 
     * successful request to dispense has been acknowledged by the 
     * DIS.</p></p>
     * 
     * <p>Dispense Id</p>
     * 
     * <p><p>Identity of prescription dispense that has been picked 
     * up.</p></p>
     * 
     * <p><p>Allows dispenses to be uniquely identified. This 
     * attribute is mandatory because the identity of the dispense 
     * record must be known.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>PrescriptionOrderNumber</p>
     * 
     * <p>A:Prescription Order Number</p>
     * 
     * <p><p>This is an identifier assigned to a specific 
     * medication order. The number remains constant across the 
     * lifetime of the order, regardless of the number of providers 
     * or pharmacies involved in fulfilling the order.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced. 
     * Multiple identifiers are allowed to support assigning of 
     * prescription ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced. 
     * Multiple identifiers are allowed to support assigning of 
     * prescription ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest/id"})
    public Set<Identifier> getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.rawSet();
    }


    @Hl7XmlMapping({"receiver/personalRelationship"})
    public RelatedPersonBean getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }
    public void setReceiverPersonalRelationship(RelatedPersonBean receiverPersonalRelationship) {
        this.receiverPersonalRelationship = receiverPersonalRelationship;
    }


    /**
     * <p>SupplyDate</p>
     * 
     * <p>A:Supply Date</p>
     * 
     * <p><p>Represents the date medication was supplied.</p></p>
     * 
     * <p><p>Needed for audit purposes.</p><p>Because the supply 
     * date is always known, the attribute is mandatory.</p></p>
     * 
     * <p><p>Needed for audit purposes.</p><p>Because the supply 
     * date is always known, the attribute is mandatory.</p></p>
     * 
     * <p><p>Must be able to post date a dispense (enter 
     * retroactively) e.g. system failure</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getSupplyDate() {
        return this.supplyDate.getValue();
    }
    public void setSupplyDate(Date supplyDate) {
        this.supplyDate.setValue(supplyDate);
    }


    /**
     * <p>SuppliedQuantity</p>
     * 
     * <p>B:Supplied Quantity</p>
     * 
     * <p><p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p></p>
     * 
     * <p><p>Allows for auditing of medication dispensed to an 
     * office. This is mandatory to allow reconciliation with the 
     * amount used from the office.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getSuppliedQuantity() {
        return this.suppliedQuantity.getValue();
    }
    public void setSuppliedQuantity(PhysicalQuantity suppliedQuantity) {
        this.suppliedQuantity.setValue(suppliedQuantity);
    }


    @Hl7XmlMapping({"product"})
    public DispensedBean getProduct() {
        return this.product;
    }
    public void setProduct(DispensedBean product) {
        this.product = product;
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(ServiceDeliveryLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }

}
