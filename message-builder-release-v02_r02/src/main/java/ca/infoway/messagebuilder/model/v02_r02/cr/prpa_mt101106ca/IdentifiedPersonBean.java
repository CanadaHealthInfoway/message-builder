/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.cr.prpa_mt101106ca;

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
import ca.infoway.messagebuilder.model.v02_r02.cr.merged.OtherIDsNonHealthcareIdentifiersBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Identified Person</p>
 * 
 * <p><p>The IdentifiedEntity class is the entry point to the 
 * R-MIM and contains one or more identifiers (for example an 
 * &quot;internal&quot; id used only by computer systems and an 
 * &quot;external&quot; id for display to users) for the Person 
 * in the Client Registry. The statusCode is set to 
 * &quot;active&quot;. The beginning of the effectiveTime is 
 * when the record was added to the registry.</p></p>
 * 
 * <p><p>Provides the message entry point required to add a 
 * person to the Client Registry</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT101106CA.IdentifiedEntity"})
@Hl7RootType
public class IdentifiedPersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private SET<II, Identifier> clientHealthcareIdentificationNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private CS clientStatusCode = new CSImpl();
    private IVL<TS, Interval<Date>> clientEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV clientMaskedInformation = new CVImpl();
    private List<OtherIDsNonHealthcareIdentifiersBean> identifiedPersonAsOtherIDs = new ArrayList<OtherIDsNonHealthcareIdentifiersBean>();
    private ConfidenceValueBean subjectOfObservationEvent;


    /**
     * <p>Client Healthcare Identification Number</p>
     * 
     * <p><p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p></p>
     * 
     * <p><p>Mandatory attribute supports unique identification of 
     * the client.</p></p>
     * 
     * <p><p>At least 1 client identifier must be present in the 
     * message</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getClientHealthcareIdentificationNumber() {
        return this.clientHealthcareIdentificationNumber.rawSet();
    }


    /**
     * <p>Client Status Code</p>
     * 
     * <p><p>Indicates the status of the Client role (e.g. 
     * Active)</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getClientStatusCode() {
        return (RoleStatus) this.clientStatusCode.getValue();
    }
    public void setClientStatusCode(RoleStatus clientStatusCode) {
        this.clientStatusCode.setValue(clientStatusCode);
    }


    /**
     * <p>Client Effective Time</p>
     * 
     * <p><p>Indicates the effective time of the Client role</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getClientEffectiveTime() {
        return this.clientEffectiveTime.getValue();
    }
    public void setClientEffectiveTime(Interval<Date> clientEffectiveTime) {
        this.clientEffectiveTime.setValue(clientEffectiveTime);
    }


    /**
     * <p>Client Masked Information</p>
     * 
     * <p><p>A code that controls the disclosure of information 
     * about this patient encounter.</p></p>
     * 
     * <p><p>Populated attribute supports the business requirement 
     * to provide restricted access where required</p></p>
     * 
     * <p><p>Data in the EHR may at some point (and in some 
     * jurisdictions) be accessed directly by patients. Some health 
     * information may be deemed inappropriate for direct access by 
     * patients and requires interpretation by a clinician (e.g. 
     * prescription of placebos, analysis of certain psychiatric 
     * conditions, etc) Even where direct access by patient is not 
     * provided, there may need to be guidance to other providers 
     * viewing the record where care should be used in disclosing 
     * information to the patient. Non-clinical data (e.g. 
     * demographics) may need to be flagged as not for disclosure 
     * to patient and or next of kin. There may be professional 
     * policy and or legislative guidelines about when/if records 
     * may be flagged as not for direct disclosure.</p></p>
     */
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
