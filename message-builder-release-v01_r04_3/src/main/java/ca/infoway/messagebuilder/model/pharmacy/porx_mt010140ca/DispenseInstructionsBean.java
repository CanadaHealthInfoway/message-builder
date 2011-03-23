/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt010140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.merged.ReferencedRecordBean;
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
 * 
 * <p>A_BillablePharmacyDispense</p>
 */
@Hl7PartTypeMapping({"PORX_MT010140CA.SupplyRequest"})
@Hl7RootType
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private Patient_1Bean subjectPatient;
    private RecordedAtBean location;
    private List<RemainingDispensesBean> fulfillmentSupplyEvent = new ArrayList<RemainingDispensesBean>();
    private ReferencedRecordBean componentOfActRequest;

    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }

    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"fulfillment/supplyEvent"})
    public List<RemainingDispensesBean> getFulfillmentSupplyEvent() {
        return this.fulfillmentSupplyEvent;
    }

    @Hl7XmlMapping({"componentOf/actRequest"})
    public ReferencedRecordBean getComponentOfActRequest() {
        return this.componentOfActRequest;
    }
    public void setComponentOfActRequest(ReferencedRecordBean componentOfActRequest) {
        this.componentOfActRequest = componentOfActRequest;
    }

}
