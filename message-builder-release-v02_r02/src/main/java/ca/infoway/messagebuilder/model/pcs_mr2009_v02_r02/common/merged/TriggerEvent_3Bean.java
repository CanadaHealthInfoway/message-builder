/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.merged.ConsentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.merged.ServiceLocationBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>TriggerEvent</p>
 * 
 * <p>MFMI_MT700711CA.ControlActEvent: Trigger Event</p>
 * 
 * <p><p>Identifies the action that resulted in this message 
 * being sent.</p></p>
 * 
 * <p><p>Key to understanding what action a message 
 * represents.</p></p>
 * 
 * <p><p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p></p>
 * 
 * <p>MFMI_MT700716CA.ControlActEvent: Trigger Event</p>
 * 
 * <p><p>Identifies the action that resulted in this message 
 * being sent.</p></p>
 * 
 * <p><p>Key to understanding what action a message 
 * represents.</p></p>
 * 
 * <p><p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p></p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.ControlActEvent","MFMI_MT700716CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_3Bean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II eventIdentifier = new IIImpl();
    private CV eventType = new CVImpl();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV eventReason = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedBy_2Bean author;
    private EntererChoice dataEntererEntererChoice;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private CreatedAtBean location;
    private RefersTo_2Bean<RR> subject;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private ConsentBean subjectOf1ConsentEvent;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>EventIdentifier</p>
     * 
     * <p>B:Event Identifier</p>
     * 
     * <p><p>A unique identifier for this particular event assigned 
     * by the system in which the event occurred.</p></p>
     * 
     * <p><p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p></p>
     * 
     * <p><p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone).</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getEventIdentifier() {
        return this.eventIdentifier.getValue();
    }
    public void setEventIdentifier(Identifier eventIdentifier) {
        this.eventIdentifier.setValue(eventIdentifier);
    }


    /**
     * <p>EventType</p>
     * 
     * <p>A:Event Type</p>
     * 
     * <p><p>Identifies the trigger event that occurred.</p></p>
     * 
     * <p><p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getEventType() {
        return (HL7TriggerEventCode) this.eventType.getValue();
    }
    public void setEventType(HL7TriggerEventCode eventType) {
        this.eventType.setValue(eventType);
    }


    /**
     * <p>EventEffectivePeriod</p>
     * 
     * <p>C:Event Effective Period</p>
     * 
     * <p><p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p></p>
     * 
     * <p><p>The time an event becomes effective may differ from 
     * the time the event is recorded (i.e. it may be in the future 
     * or the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEventEffectivePeriod() {
        return this.eventEffectivePeriod.getValue();
    }
    public void setEventEffectivePeriod(Interval<Date> eventEffectivePeriod) {
        this.eventEffectivePeriod.setValue(eventEffectivePeriod);
    }


    /**
     * <p>EventReason</p>
     * 
     * <p>E:Event Reason</p>
     * 
     * <p><p>Identifies why this specific message interaction (e.g. 
     * query, activation request, modification request) 
     * occurred.</p></p>
     * 
     * <p><p>Allows identifying a reason for a specific action, 
     * such as 'reason for hold' or 'reason for accessing 
     * information'.</p></p>
     * 
     * <p><p>The domain associated with this attribute will vary 
     * for each interaction and will be noted as part of the 
     * interaction description.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getEventReason() {
        return (ControlActReason) this.eventReason.getValue();
    }
    public void setEventReason(ControlActReason eventReason) {
        this.eventReason.setValue(eventReason);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public CreatedBy_2Bean getAuthor() {
        return this.author;
    }
    public void setAuthor(CreatedBy_2Bean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"dataEnterer/entererChoice"})
    public EntererChoice getDataEntererEntererChoice() {
        return this.dataEntererEntererChoice;
    }
    public void setDataEntererEntererChoice(EntererChoice dataEntererEntererChoice) {
        this.dataEntererEntererChoice = dataEntererEntererChoice;
    }

    public HealthcareWorkerBean getDataEntererEntererChoiceAsAssignedEntity1() {
        return this.dataEntererEntererChoice instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.dataEntererEntererChoice : null;
    }
    public boolean hasDataEntererEntererChoiceAsAssignedEntity1() {
        return (this.dataEntererEntererChoice instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getDataEntererEntererChoiceAsAssignedEntity2() {
        return this.dataEntererEntererChoice instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.dataEntererEntererChoice : null;
    }
    public boolean hasDataEntererEntererChoiceAsAssignedEntity2() {
        return (this.dataEntererEntererChoice instanceof HealthcareOrganizationBean);
    }


    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }
    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"subject"})
    public RefersTo_2Bean<RR> getSubject() {
        return this.subject;
    }
    public void setSubject(RefersTo_2Bean<RR> subject) {
        this.subject = subject;
    }


    @Hl7XmlMapping({"pertinentInformation/authorizationToken"})
    public AuthenticationTokenBean getPertinentInformationAuthorizationToken() {
        return this.pertinentInformationAuthorizationToken;
    }
    public void setPertinentInformationAuthorizationToken(AuthenticationTokenBean pertinentInformationAuthorizationToken) {
        this.pertinentInformationAuthorizationToken = pertinentInformationAuthorizationToken;
    }


    @Hl7XmlMapping({"subjectOf1/consentEvent"})
    public ConsentBean getSubjectOf1ConsentEvent() {
        return this.subjectOf1ConsentEvent;
    }
    public void setSubjectOf1ConsentEvent(ConsentBean subjectOf1ConsentEvent) {
        this.subjectOf1ConsentEvent = subjectOf1ConsentEvent;
    }


    @Hl7XmlMapping({"subjectOf/detectedIssueEvent","subjectOf2/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="MFMI_MT700716CA.Subject"),
        @Hl7MapByPartType(name="subjectOf/detectedIssueEvent", type="COCT_MT260012CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf2", type="MFMI_MT700711CA.Subject"),
        @Hl7MapByPartType(name="subjectOf2/detectedIssueEvent", type="COCT_MT260012CA.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }

}