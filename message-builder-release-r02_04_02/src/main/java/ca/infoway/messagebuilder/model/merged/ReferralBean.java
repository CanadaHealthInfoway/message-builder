/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareProvisionRequestType;
import ca.infoway.messagebuilder.domainvalue.x_ActStatusActiveComplete;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.iehr.repc_mt210001ca.DocumentContentBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT210001CA.PatientCareProvisionRequest","REPC_MT210002CA.PatientCareProvisionRequest","REPC_MT210003CA.PatientCareProvisionRequest"})
public class ReferralBean extends MessagePartBean implements DocumentContentBean, DocumentContent_1Bean {

    private static final long serialVersionUID = 20100603L;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private CD referralType = new CDImpl();
    private CS referralStatus = new CSImpl();
    private IVL<TS, Interval<Date>> referralRequestedByTime = new IVLImpl<TS, Interval<Date>>();
    private ProviderBean performerAssignedEntity;
    private OccurredAtBean location;
    private ActRequest2Bean componentActRequest;
    private PatientCareProvisionEvent2Bean fulfillmentPatientCareProvisionEvent;

    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }

    @Hl7XmlMapping({"code"})
    public ActCareProvisionRequestType getReferralType() {
        return (ActCareProvisionRequestType) this.referralType.getValue();
    }
    public void setReferralType(ActCareProvisionRequestType referralType) {
        this.referralType.setValue(referralType);
    }

    @Hl7XmlMapping({"statusCode"})
    public x_ActStatusActiveComplete getReferralStatus() {
        return (x_ActStatusActiveComplete) this.referralStatus.getValue();
    }
    public void setReferralStatus(x_ActStatusActiveComplete referralStatus) {
        this.referralStatus.setValue(referralStatus);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getReferralRequestedByTime() {
        return this.referralRequestedByTime.getValue();
    }
    public void setReferralRequestedByTime(Interval<Date> referralRequestedByTime) {
        this.referralRequestedByTime.setValue(referralRequestedByTime);
    }

    @Hl7XmlMapping({"performer/assignedEntity"})
    public ProviderBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }
    public void setPerformerAssignedEntity(ProviderBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }

    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"component/actRequest"})
    public ActRequest2Bean getComponentActRequest() {
        return this.componentActRequest;
    }
    public void setComponentActRequest(ActRequest2Bean componentActRequest) {
        this.componentActRequest = componentActRequest;
    }

    @Hl7XmlMapping({"fulfillment/patientCareProvisionEvent"})
    public PatientCareProvisionEvent2Bean getFulfillmentPatientCareProvisionEvent() {
        return this.fulfillmentPatientCareProvisionEvent;
    }
    public void setFulfillmentPatientCareProvisionEvent(PatientCareProvisionEvent2Bean fulfillmentPatientCareProvisionEvent) {
        this.fulfillmentPatientCareProvisionEvent = fulfillmentPatientCareProvisionEvent;
    }

}
