/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.IssuesBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.ServiceLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"MCAI_MT700230CA.ControlActEvent","MCAI_MT700231CA.ControlActEvent","MCAI_MT700232CA.ControlActEvent","MCAI_MT700236CA.ControlActEvent","MCAI_MT700237CA.ControlActEvent","QUQI_MT000001CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II eventIdentifier = new IIImpl();
    private CV eventType = new CVImpl();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV eventReason = new CVImpl();
    private RecordTargetBean participant;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedByBean author;
    private ActingPerson dataEntererActingPerson;
    private CreatedAtBean location;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();
    private II queryIdentifier = new IIImpl();
    private INT startPosition = new INTImpl();
    private INT queryLimit = new INTImpl();


    /**
     * <p>EventIdentifier</p>
     * 
     * <p>B:Event Identifier</p>
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
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getEventReason() {
        return (ControlActReason) this.eventReason.getValue();
    }
    public void setEventReason(ControlActReason eventReason) {
        this.eventReason.setValue(eventReason);
    }


    @Hl7XmlMapping({"participant","recordTarget"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="participant", type="MCAI_MT700236CA.RecordTarget"),
        @Hl7MapByPartType(name="participant", type="MCAI_MT700237CA.RecordTarget"),
        @Hl7MapByPartType(name="recordTarget", type="MCAI_MT700230CA.RecordTarget"),
        @Hl7MapByPartType(name="recordTarget", type="MCAI_MT700231CA.RecordTarget")})
    public RecordTargetBean getParticipant() {
        return this.participant;
    }
    public void setParticipant(RecordTargetBean participant) {
        this.participant = participant;
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public CreatedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(CreatedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"dataEnterer/actingPerson"})
    public ActingPerson getDataEntererActingPerson() {
        return this.dataEntererActingPerson;
    }
    public void setDataEntererActingPerson(ActingPerson dataEntererActingPerson) {
        this.dataEntererActingPerson = dataEntererActingPerson;
    }

    public HealthcareWorkerBean getDataEntererActingPersonAsAssignedEntity1() {
        return this.dataEntererActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.dataEntererActingPerson : null;
    }
    public boolean hasDataEntererActingPersonAsAssignedEntity1() {
        return (this.dataEntererActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getDataEntererActingPersonAsAssignedEntity2() {
        return this.dataEntererActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.dataEntererActingPerson : null;
    }
    public boolean hasDataEntererActingPersonAsAssignedEntity2() {
        return (this.dataEntererActingPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getDataEntererActingPersonAsPersonalRelationship() {
        return this.dataEntererActingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.dataEntererActingPerson : null;
    }
    public boolean hasDataEntererActingPersonAsPersonalRelationship() {
        return (this.dataEntererActingPerson instanceof RelatedPersonBean);
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }
    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"pertinentInformation/authorizationToken"})
    public AuthenticationTokenBean getPertinentInformationAuthorizationToken() {
        return this.pertinentInformationAuthorizationToken;
    }
    public void setPertinentInformationAuthorizationToken(AuthenticationTokenBean pertinentInformationAuthorizationToken) {
        this.pertinentInformationAuthorizationToken = pertinentInformationAuthorizationToken;
    }


    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }


    /**
     * <p>QueryIdentifier</p>
     * 
     * <p>H:Query Identifier</p>
     */
    @Hl7XmlMapping({"queryContinuation/queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }


    /**
     * <p>StartPosition</p>
     * 
     * <p>I:Start Position</p>
     */
    @Hl7XmlMapping({"queryContinuation/startResultNumber"})
    public Integer getStartPosition() {
        return this.startPosition.getValue();
    }
    public void setStartPosition(Integer startPosition) {
        this.startPosition.setValue(startPosition);
    }


    /**
     * <p>QueryLimit</p>
     * 
     * <p>J:Query Limit</p>
     */
    @Hl7XmlMapping({"queryContinuation/continuationQuantity"})
    public Integer getQueryLimit() {
        return this.queryLimit.getValue();
    }
    public void setQueryLimit(Integer queryLimit) {
        this.queryLimit.setValue(queryLimit);
    }

}
