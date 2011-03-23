/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt010140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.TargetedToPharmacyBean;
import ca.infoway.messagebuilder.model.merged.VerificationEventCriterionBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Dispense Instructions</p>
 * 
 * <p>This is the information that describes the authorization 
 * for a dispenser to dispense the prescription.</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010140CA.SupplyRequest"})
@Hl7RootType
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private TargetedToPharmacyBean location;
    private List<RemainingDispensesBean> fulfillmentSupplyEvent = new ArrayList<RemainingDispensesBean>();
    private II prescriptionOrderNumber = new IIImpl();
    private VerificationEventCriterionBean componentOfActRequestPreconditionVerificationEventCriterion;

    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"fulfillment/supplyEvent"})
    public List<RemainingDispensesBean> getFulfillmentSupplyEvent() {
        return this.fulfillmentSupplyEvent;
    }

    @Hl7XmlMapping({"componentOf/actRequest/id"})
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }
    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }

    @Hl7XmlMapping({"componentOf/actRequest/precondition/verificationEventCriterion"})
    public VerificationEventCriterionBean getComponentOfActRequestPreconditionVerificationEventCriterion() {
        return this.componentOfActRequestPreconditionVerificationEventCriterion;
    }
    public void setComponentOfActRequestPreconditionVerificationEventCriterion(VerificationEventCriterionBean componentOfActRequestPreconditionVerificationEventCriterion) {
        this.componentOfActRequestPreconditionVerificationEventCriterion = componentOfActRequestPreconditionVerificationEventCriterion;
    }

}
