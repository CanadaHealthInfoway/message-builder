/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.quqi_mt120006ca;

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
import ca.infoway.messagebuilder.model.common.coct_mt470002ca.ConsentBean;
import ca.infoway.messagebuilder.model.merged.IsPartOfBean;
import ca.infoway.messagebuilder.model.merged.QueryAckBean;
import ca.infoway.messagebuilder.model.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.merged.StoredInBean;
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
@Hl7PartTypeMapping({"QUQI_MT120006CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<ACT,PL> extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II eventIdentifier = new IIImpl();
    private CV eventType = new CVImpl();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV eventReason = new CVImpl();
    private StoredInBean recordTarget;
    private List<Subject2_1Bean<ACT>> subject = new ArrayList<Subject2_1Bean<ACT>>();
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private ConsentBean subjectOf2ConsentEvent;
    private List<IsPartOfBean> componentOf = new ArrayList<IsPartOfBean>();
    private QueryAckBean queryAck;
    private QueryByParameterBean<PL> queryByParameter;

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

    @Hl7XmlMapping({"recordTarget"})
    public StoredInBean getRecordTarget() {
        return this.recordTarget;
    }
    public void setRecordTarget(StoredInBean recordTarget) {
        this.recordTarget = recordTarget;
    }

    @Hl7XmlMapping({"subject"})
    public List<Subject2_1Bean<ACT>> getSubject() {
        return this.subject;
    }

    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }

    @Hl7XmlMapping({"subjectOf2/consentEvent"})
    public ConsentBean getSubjectOf2ConsentEvent() {
        return this.subjectOf2ConsentEvent;
    }
    public void setSubjectOf2ConsentEvent(ConsentBean subjectOf2ConsentEvent) {
        this.subjectOf2ConsentEvent = subjectOf2ConsentEvent;
    }

    @Hl7XmlMapping({"componentOf"})
    public List<IsPartOfBean> getComponentOf() {
        return this.componentOf;
    }

    @Hl7XmlMapping({"queryAck"})
    public QueryAckBean getQueryAck() {
        return this.queryAck;
    }
    public void setQueryAck(QueryAckBean queryAck) {
        this.queryAck = queryAck;
    }

    @Hl7XmlMapping({"queryByParameter"})
    public QueryByParameterBean<PL> getQueryByParameter() {
        return this.queryByParameter;
    }
    public void setQueryByParameter(QueryByParameterBean<PL> queryByParameter) {
        this.queryByParameter = queryByParameter;
    }

}
