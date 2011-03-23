/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.cr.prpa_mt101106ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.ConfidenceValueBean;
import ca.infoway.messagebuilder.model.merged.OtherIDsNonHealthcareIdentifiersBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Identified Person</p>
 * 
 * <p>The IdentifiedEntity class is the entry point to the 
 * R-MIM and contains one or more identifiers (for example an 
 * "internal" id used only by computer systems and an 
 * "external" id for display to users) for the Person in the 
 * Client Registry. The statusCode is set to "active". The 
 * beginning of the effectiveTime is when the record was added 
 * to the registry.</p>
 * 
 * <p>Provides the message entry point required to add a person 
 * to the Client Registry</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101106CA.IdentifiedEntity"})
@Hl7RootType
public class IdentifiedPersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private SET<II, Identifier> clientHealthcareIdentificationNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private CS clientStatusCode = new CSImpl();
    private IVL<TS, Interval<Date>> clientEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV clientMaskedInformation = new CVImpl();
    private List<OtherIDsNonHealthcareIdentifiersBean> identifiedPersonAsOtherIDs = new ArrayList<OtherIDsNonHealthcareIdentifiersBean>();
    private ConfidenceValueBean subjectOfObservationEvent;

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getClientHealthcareIdentificationNumber() {
        return this.clientHealthcareIdentificationNumber.rawSet();
    }

    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getClientStatusCode() {
        return (RoleStatus) this.clientStatusCode.getValue();
    }
    public void setClientStatusCode(RoleStatus clientStatusCode) {
        this.clientStatusCode.setValue(clientStatusCode);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getClientEffectiveTime() {
        return this.clientEffectiveTime.getValue();
    }
    public void setClientEffectiveTime(Interval<Date> clientEffectiveTime) {
        this.clientEffectiveTime.setValue(clientEffectiveTime);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Code getClientMaskedInformation() {
        return (Code) this.clientMaskedInformation.getValue();
    }
    public void setClientMaskedInformation(Code clientMaskedInformation) {
        this.clientMaskedInformation.setValue(clientMaskedInformation);
    }

    @Hl7XmlMapping({"identifiedPerson/asOtherIDs"})
    public List<OtherIDsNonHealthcareIdentifiersBean> getIdentifiedPersonAsOtherIDs() {
        return this.identifiedPersonAsOtherIDs;
    }

    @Hl7XmlMapping({"subjectOf/observationEvent"})
    public ConfidenceValueBean getSubjectOfObservationEvent() {
        return this.subjectOfObservationEvent;
    }
    public void setSubjectOfObservationEvent(ConfidenceValueBean subjectOfObservationEvent) {
        this.subjectOfObservationEvent = subjectOfObservationEvent;
    }

}
