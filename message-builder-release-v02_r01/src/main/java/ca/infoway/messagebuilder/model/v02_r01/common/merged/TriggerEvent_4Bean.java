/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

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
import ca.infoway.messagebuilder.model.v02_r01.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.IssuesBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.ServiceLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"MFMI_MT700751CA.ControlActEvent","QUQI_MT020000CA.ControlActEvent","QUQI_MT020002CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_4Bean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II eventIdentifier = new IIImpl();
    private CV eventType = new CVImpl();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV eventReason = new CVImpl();
    private RecordTargetBean recordTarget;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedByBean author;
    private ActingPerson dataEntererActingPerson;
    private CreatedAtBean location;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private AuthorizedByBean subjectOf2;
    private List<CareCompositionsBean> componentOf = new ArrayList<CareCompositionsBean>();
    private QueryByParameterBean<PL> queryByParameter;


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


    @Hl7XmlMapping({"recordTarget"})
    public RecordTargetBean getRecordTarget() {
        return this.recordTarget;
    }
    public void setRecordTarget(RecordTargetBean recordTarget) {
        this.recordTarget = recordTarget;
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


    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent","subjectOf2/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf1", type="QUQI_MT020000CA.Subject"),
        @Hl7MapByPartType(name="subjectOf1", type="QUQI_MT020002CA.Subject"),
        @Hl7MapByPartType(name="subjectOf1/detectedIssueEvent", type="COCT_MT260012CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf2", type="MFMI_MT700751CA.Subject2"),
        @Hl7MapByPartType(name="subjectOf2/detectedIssueEvent", type="COCT_MT260012CA.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf1","subjectOf2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf1", type="MFMI_MT700751CA.Subject1"),
        @Hl7MapByPartType(name="subjectOf2", type="QUQI_MT020000CA.Subject3"),
        @Hl7MapByPartType(name="subjectOf2", type="QUQI_MT020002CA.Subject3")})
    public AuthorizedByBean getSubjectOf2() {
        return this.subjectOf2;
    }
    public void setSubjectOf2(AuthorizedByBean subjectOf2) {
        this.subjectOf2 = subjectOf2;
    }


    @Hl7XmlMapping({"componentOf"})
    public List<CareCompositionsBean> getComponentOf() {
        return this.componentOf;
    }


    @Hl7XmlMapping({"queryByParameter"})
    public QueryByParameterBean<PL> getQueryByParameter() {
        return this.queryByParameter;
    }
    public void setQueryByParameter(QueryByParameterBean<PL> queryByParameter) {
        this.queryByParameter = queryByParameter;
    }

}
