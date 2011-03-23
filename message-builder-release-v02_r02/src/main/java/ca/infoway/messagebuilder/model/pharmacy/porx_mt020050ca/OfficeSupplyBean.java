/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt020050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.common.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.merged.ServiceDeliveryLocation_1Bean;
import ca.infoway.messagebuilder.model.merged.SupplyOrderBean;
import java.util.Date;



/**
 * <p>Office Supply</p>
 * 
 * <p>This is the detailed information about a medication being 
 * supplied for office use.</p>
 * 
 * <p>Allows for tracking of medications supplied to an office.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyEvent"})
@Hl7RootType
public class OfficeSupplyBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II localDispenseID = new IIImpl();
    private CV dispenseType = new CVImpl();
    private TS supplyDate = new TSImpl();
    private PQ suppliedQuantity = new PQImpl();
    private DrugProductBean productMedication;
    private ServiceDeliveryLocation_1Bean destinationServiceDeliveryLocation;
    private SupplyOrderBean fulfillmentSupplyRequest;
    private NotesBean subjectOfAnnotation;

    @Hl7XmlMapping({"id"})
    public Identifier getLocalDispenseID() {
        return this.localDispenseID.getValue();
    }
    public void setLocalDispenseID(Identifier localDispenseID) {
        this.localDispenseID.setValue(localDispenseID);
    }

    @Hl7XmlMapping({"code"})
    public ActCode getDispenseType() {
        return (ActCode) this.dispenseType.getValue();
    }
    public void setDispenseType(ActCode dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Date getSupplyDate() {
        return this.supplyDate.getValue();
    }
    public void setSupplyDate(Date supplyDate) {
        this.supplyDate.setValue(supplyDate);
    }

    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getSuppliedQuantity() {
        return this.suppliedQuantity.getValue();
    }
    public void setSuppliedQuantity(PhysicalQuantity suppliedQuantity) {
        this.suppliedQuantity.setValue(suppliedQuantity);
    }

    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }

    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public ServiceDeliveryLocation_1Bean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(ServiceDeliveryLocation_1Bean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }

    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
