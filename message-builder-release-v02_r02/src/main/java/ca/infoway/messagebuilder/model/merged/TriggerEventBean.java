/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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
import ca.infoway.messagebuilder.model.common.coct_mt260022ca.IssuesBean;
import ca.infoway.messagebuilder.model.common.coct_mt911102ca.ActingPersonBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"MCAI_MT700231CA.ControlActEvent","MCAI_MT700232CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II eventIdentifier = new IIImpl();
    private CV eventType = new CVImpl();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV eventReason = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private Author_1Bean author;
    private ActingPersonBean dataEntererActingPerson;
    private ServiceDeliveryLocation_1Bean locationServiceDeliveryLocation;
    private ServiceDeliveryLocation_1Bean dataEntryLocationServiceDeliveryLocation;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();
    private StoredInBean recordTarget;

    @Hl7XmlMapping({"id"})
    public Identifier getEventIdentifier() {
        return this.eventIdentifier.getValue();
    }
    public void setEventIdentifier(Identifier eventIdentifier) {
        this.eventIdentifier.setValue(eventIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getEventType() {
        return (HL7TriggerEventCode) this.eventType.getValue();
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
    public Author_1Bean getAuthor() {
        return this.author;
    }
    public void setAuthor(Author_1Bean author) {
        this.author = author;
    }

    @Hl7XmlMapping({"dataEnterer/actingPerson"})
    public ActingPersonBean getDataEntererActingPerson() {
        return this.dataEntererActingPerson;
    }
    public void setDataEntererActingPerson(ActingPersonBean dataEntererActingPerson) {
        this.dataEntererActingPerson = dataEntererActingPerson;
    }

    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceDeliveryLocation_1Bean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }
    public void setLocationServiceDeliveryLocation(ServiceDeliveryLocation_1Bean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceDeliveryLocation_1Bean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }
    public void setDataEntryLocationServiceDeliveryLocation(ServiceDeliveryLocation_1Bean dataEntryLocationServiceDeliveryLocation) {
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

    @Hl7XmlMapping({"recordTarget"})
    public StoredInBean getRecordTarget() {
        return this.recordTarget;
    }
    public void setRecordTarget(StoredInBean recordTarget) {
        this.recordTarget = recordTarget;
    }

}
