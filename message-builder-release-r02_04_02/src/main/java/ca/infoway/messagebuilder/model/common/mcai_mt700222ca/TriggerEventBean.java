/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.mcai_mt700222ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.common.coct_mt260022ca.IssuesBean;
import ca.infoway.messagebuilder.model.common.coct_mt911102ca.ActingPersonBean;
import ca.infoway.messagebuilder.model.merged.AssignedEntity_1Bean;
import ca.infoway.messagebuilder.model.merged.AuthenticationTokenBean;
import ca.infoway.messagebuilder.model.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.merged.ServiceDeliveryLocation_1Bean;
import ca.infoway.messagebuilder.model.merged.Subject2_1Bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Trigger Event</p>
 * 
 * <p>Identifies the action that resulted in this message being 
 * sent.</p>
 * 
 * <p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p>
 * 
 * <p>Key to understanding what action a message represents.</p>
 */
@Hl7PartTypeMapping({"MCAI_MT700222CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<ACT> extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II eventIdentifier = new IIImpl();
    private CV eventType = new CVImpl();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV eventReason = new CVImpl();
    private CE messageLanguage = new CEImpl();
    private AssignedEntity_1Bean responsiblePartyAssignedEntity;
    private Author_1Bean author;
    private ActingPersonBean dataEntererActingPerson;
    private ServiceDeliveryLocation_1Bean dataEntryLocationServiceDeliveryLocation;
    private ServiceDeliveryLocation_1Bean locationServiceDeliveryLocation;
    private Subject2_1Bean<ACT> subject;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();

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

    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getMessageLanguage() {
        return (HumanLanguage) this.messageLanguage.getValue();
    }
    public void setMessageLanguage(HumanLanguage messageLanguage) {
        this.messageLanguage.setValue(messageLanguage);
    }

    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public AssignedEntity_1Bean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(AssignedEntity_1Bean responsiblePartyAssignedEntity) {
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

    public AssignedEntity_1Bean getDataEntererActingPersonAsAssignedEntity1() {
        return this.dataEntererActingPerson instanceof AssignedEntity_1Bean ? (AssignedEntity_1Bean) this.dataEntererActingPerson : null;
    }
    public boolean hasDataEntererActingPersonAsAssignedEntity1() {
        return (this.dataEntererActingPerson instanceof AssignedEntity_1Bean);
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

    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceDeliveryLocation_1Bean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }
    public void setDataEntryLocationServiceDeliveryLocation(ServiceDeliveryLocation_1Bean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceDeliveryLocation_1Bean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }
    public void setLocationServiceDeliveryLocation(ServiceDeliveryLocation_1Bean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"subject"})
    public Subject2_1Bean<ACT> getSubject() {
        return this.subject;
    }
    public void setSubject(Subject2_1Bean<ACT> subject) {
        this.subject = subject;
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

}
