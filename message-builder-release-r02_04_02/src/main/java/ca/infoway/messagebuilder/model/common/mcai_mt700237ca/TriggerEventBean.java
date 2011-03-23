/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.mcai_mt700237ca;

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
import ca.infoway.messagebuilder.model.common.coct_mt050201ca.PatientBean;
import ca.infoway.messagebuilder.model.common.coct_mt260022ca.IssuesBean;
import ca.infoway.messagebuilder.model.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.merged.Patient_2Bean;
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
@Hl7PartTypeMapping({"MCAI_MT700237CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II eventIdentifier = new IIImpl();
    private CV eventType = new CVImpl();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV eventReason = new CVImpl();
    private CE messageLanguage = new CEImpl();
    private Patient_2Bean recordTargetPatient1;
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

    @Hl7XmlMapping({"recordTarget/patient1"})
    public Patient_2Bean getRecordTargetPatient1() {
        return this.recordTargetPatient1;
    }
    public void setRecordTargetPatient1(Patient_2Bean recordTargetPatient1) {
        this.recordTargetPatient1 = recordTargetPatient1;
    }

    public ca.infoway.messagebuilder.model.common.coct_mt050202ca.PatientBean getRecordTargetPatient1AsPatient1() {
        return this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.common.coct_mt050202ca.PatientBean ? (ca.infoway.messagebuilder.model.common.coct_mt050202ca.PatientBean) this.recordTargetPatient1 : null;
    }
    public boolean hasRecordTargetPatient1AsPatient1() {
        return (this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.common.coct_mt050202ca.PatientBean);
    }

    public Patient_1Bean getRecordTargetPatient1AsPatient2() {
        return this.recordTargetPatient1 instanceof Patient_1Bean ? (Patient_1Bean) this.recordTargetPatient1 : null;
    }
    public boolean hasRecordTargetPatient1AsPatient2() {
        return (this.recordTargetPatient1 instanceof Patient_1Bean);
    }

    public PatientBean getRecordTargetPatient1AsPatient3() {
        return this.recordTargetPatient1 instanceof PatientBean ? (PatientBean) this.recordTargetPatient1 : null;
    }
    public boolean hasRecordTargetPatient1AsPatient3() {
        return (this.recordTargetPatient1 instanceof PatientBean);
    }

    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }

}
