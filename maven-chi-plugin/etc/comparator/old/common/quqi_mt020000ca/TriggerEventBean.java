/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.quqi_mt020000ca;

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
import ca.infoway.messagebuilder.model.common.coct_mt911102ca.ActingPersonBean;
import ca.infoway.messagebuilder.model.merged.AuthenticationTokenBean;
import ca.infoway.messagebuilder.model.merged.AuthorizedByBean;
import ca.infoway.messagebuilder.model.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.merged.CreatedByBean;
import ca.infoway.messagebuilder.model.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.IsPartOfBean;
import ca.infoway.messagebuilder.model.merged.IssuesBean;
import ca.infoway.messagebuilder.model.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.merged.RecordTargetBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * <p>Trigger Event 
 * 
 * <p>Identifies the action that resulted in this message being 
 * sent. 
 * 
 * <p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper. 
 * 
 * <p>Key to understanding what action a message represents. 
 */
@Hl7PartTypeMapping({"QUQI_MT020000CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<PL> extends MessagePartBean {

    private II eventIdentifier = new IIImpl();
    private CV<HL7TriggerEventCode> eventType = new CVImpl<HL7TriggerEventCode>();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV<ControlActReason> eventReason = new CVImpl<ControlActReason>();
    private RecordTargetBean recordTarget = new RecordTargetBean();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedByBean author;
    private ActingPersonBean dataEntererActingPerson;
    private CreatedAtBean location;
    private DispenseShipToLocationBean dataEntryLocationServiceDeliveryLocation;
    private AuthenticationTokenBean pertinentInformation;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private AuthorizedByBean subjectOf2;
    private List<IsPartOfBean> componentOf = new ArrayList<IsPartOfBean>();
    private QueryByParameterBean<PL> queryByParameter = new QueryByParameterBean<PL>();

    @Hl7XmlMapping({"id"})
    public Identifier getEventIdentifier() {
        return this.eventIdentifier.getValue();
    }
    public void setEventIdentifier(Identifier eventIdentifier) {
        this.eventIdentifier.setValue(eventIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getEventType() {
        return this.eventType.getValue();
    }
    public void setEventType(HL7TriggerEventCode eventType) {
        this.eventType.setValue(eventType);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEventEffectivePeriod() {
        return this.eventEffectivePeriod.getValue();
    }
    public void setEventEffectivePeriod(Interval<Date> eventEffectivePeriod) {
        this.eventEffectivePeriod.setValue(eventEffectivePeriod);
    }

    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getEventReason() {
        return this.eventReason.getValue();
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
    public ActingPersonBean getDataEntererActingPerson() {
        return this.dataEntererActingPerson;
    }
    public void setDataEntererActingPerson(ActingPersonBean dataEntererActingPerson) {
        this.dataEntererActingPerson = dataEntererActingPerson;
    }

    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }
    public void setDataEntryLocationServiceDeliveryLocation(DispenseShipToLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"pertinentInformation"})
    public AuthenticationTokenBean getPertinentInformation() {
        return this.pertinentInformation;
    }
    public void setPertinentInformation(AuthenticationTokenBean pertinentInformation) {
        this.pertinentInformation = pertinentInformation;
    }

    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }

    @Hl7XmlMapping({"subjectOf2"})
    public AuthorizedByBean getSubjectOf2() {
        return this.subjectOf2;
    }
    public void setSubjectOf2(AuthorizedByBean subjectOf2) {
        this.subjectOf2 = subjectOf2;
    }

    @Hl7XmlMapping({"componentOf"})
    public List<IsPartOfBean> getComponentOf() {
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
