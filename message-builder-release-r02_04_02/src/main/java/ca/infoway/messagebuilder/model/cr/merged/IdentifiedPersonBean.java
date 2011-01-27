/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.LanguageCommunicationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>IdentifiedPerson</p>
 * 
 * <p>PRPA_MT101102CA.IdentifiedEntity: Identified Person</p>
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
 * 
 * <p>PRPA_MT101106CA.IdentifiedEntity: Identified Person</p>
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
 * 
 * <p>PRPA_MT101104CA.IdentifiedEntity: Identified Person</p>
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
 * 
 * <p>PRPA_MT101002CA.IdentifiedEntity: Identified Person</p>
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
@Hl7PartTypeMapping({"PRPA_MT101002CA.IdentifiedEntity","PRPA_MT101102CA.IdentifiedEntity","PRPA_MT101104CA.IdentifiedEntity","PRPA_MT101106CA.IdentifiedEntity"})
@Hl7RootType
public class IdentifiedPersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private CS clientStatusCode = new CSImpl();
    private List<LanguageCommunicationBean> identifiedPersonLanguageCommunication = new ArrayList<LanguageCommunicationBean>();
    private LIST<AD, PostalAddress> clientAddress = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<PN, PersonName> clientName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private List<PersonalRelationshipBean> identifiedPersonPersonalRelationship = new ArrayList<PersonalRelationshipBean>();
    private INT clientMultipleBirthOrderNumber = new INTImpl();
    private List<OtherIDsNonHealthcareIdentifiersBean> identifiedPersonAsOtherIDs = new ArrayList<OtherIDsNonHealthcareIdentifiersBean>();
    private BL clientMultipleBirthIndicator = new BLImpl();
    private LIST<TEL, TelecommunicationAddress> clientTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CV clientGender = new CVImpl();
    private BL clientDeceasedIndicator = new BLImpl();
    private TS clientDateOfBirth = new TSImpl();
    private TS clientDeceasedDate = new TSImpl();
    private SET<II, Identifier> clientHealthcareIdentificationNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private CV clientMaskedInformation = new CVImpl();
    private ConfidenceValueBean subjectOfObservationEvent;
    private IVL<TS, Interval<Date>> clientEffectiveTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>ClientStatusCode</p>
     * 
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


    @Hl7XmlMapping({"identifiedPerson/languageCommunication"})
    public List<LanguageCommunicationBean> getIdentifiedPersonLanguageCommunication() {
        return this.identifiedPersonLanguageCommunication;
    }


    /**
     * <p>ClientAddress</p>
     * 
     * <p>Client Address</p>
     * 
     * <p><p>Address(es) of the Client</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/addr"})
    public List<PostalAddress> getClientAddress() {
        return this.clientAddress.rawList();
    }


    /**
     * <p>ClientName</p>
     * 
     * <p>Client Name</p>
     * 
     * <p><p>Name(s) for the Client</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/name"})
    public List<PersonName> getClientName() {
        return this.clientName.rawList();
    }


    @Hl7XmlMapping({"identifiedPerson/personalRelationship"})
    public List<PersonalRelationshipBean> getIdentifiedPersonPersonalRelationship() {
        return this.identifiedPersonPersonalRelationship;
    }


    /**
     * <p>ClientMultipleBirthOrderNumber</p>
     * 
     * <p>Client Multiple Birth Order Number</p>
     * 
     * <p><p>The order in which this client was born if part of a 
     * multiple birth.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/multipleBirthOrderNumber"})
    public Integer getClientMultipleBirthOrderNumber() {
        return this.clientMultipleBirthOrderNumber.getValue();
    }
    public void setClientMultipleBirthOrderNumber(Integer clientMultipleBirthOrderNumber) {
        this.clientMultipleBirthOrderNumber.setValue(clientMultipleBirthOrderNumber);
    }


    @Hl7XmlMapping({"identifiedPerson/asOtherIDs"})
    public List<OtherIDsNonHealthcareIdentifiersBean> getIdentifiedPersonAsOtherIDs() {
        return this.identifiedPersonAsOtherIDs;
    }


    /**
     * <p>ClientMultipleBirthIndicator</p>
     * 
     * <p>Client Multiple Birth Indicator</p>
     * 
     * <p><p>An indication as to whether the client is part of a 
     * multiple birth.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/multipleBirthInd"})
    public Boolean getClientMultipleBirthIndicator() {
        return this.clientMultipleBirthIndicator.getValue();
    }
    public void setClientMultipleBirthIndicator(Boolean clientMultipleBirthIndicator) {
        this.clientMultipleBirthIndicator.setValue(clientMultipleBirthIndicator);
    }


    /**
     * <p>ClientTelecom</p>
     * 
     * <p>Client Telecom</p>
     * 
     * <p><p>Provides information about telecom</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     * 
     * <p>Client Telecom</p>
     * 
     * <p><p>Provides information about telecom</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/telecom"})
    public List<TelecommunicationAddress> getClientTelecom() {
        return this.clientTelecom.rawList();
    }


    /**
     * <p>ClientGender</p>
     * 
     * <p>Client Gender</p>
     * 
     * <p><p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or 
     * Undifferentiated (U)</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     * 
     * <p>Client Gender</p>
     * 
     * <p><p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or 
     * Undifferentiated (UN)</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/administrativeGenderCode"})
    public AdministrativeGender getClientGender() {
        return (AdministrativeGender) this.clientGender.getValue();
    }
    public void setClientGender(AdministrativeGender clientGender) {
        this.clientGender.setValue(clientGender);
    }


    /**
     * <p>ClientDeceasedIndicator</p>
     * 
     * <p>Client Deceased Indicator</p>
     * 
     * <p><p>An indication that the client is deceased. Appropriate 
     * business process/function will need to be employed to ensure 
     * that validation or verification of the death event has been 
     * established prior to populating the message.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedInd"})
    public Boolean getClientDeceasedIndicator() {
        return this.clientDeceasedIndicator.getValue();
    }
    public void setClientDeceasedIndicator(Boolean clientDeceasedIndicator) {
        this.clientDeceasedIndicator.setValue(clientDeceasedIndicator);
    }


    /**
     * <p>ClientDateOfBirth</p>
     * 
     * <p>Client Date of Birth</p>
     * 
     * <p><p>Date of birth of the Client</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/birthTime"})
    public Date getClientDateOfBirth() {
        return this.clientDateOfBirth.getValue();
    }
    public void setClientDateOfBirth(Date clientDateOfBirth) {
        this.clientDateOfBirth.setValue(clientDateOfBirth);
    }


    /**
     * <p>ClientDeceasedDate</p>
     * 
     * <p>Client Deceased Date</p>
     * 
     * <p><p>deceasedTime only present if deceasedInd is = TRUE</p></p>
     * 
     * <p><p>The date and time that a client's death occurred.</p></p>
     * 
     * <p><p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p></p>
     * 
     * <p>Client Deceased Date</p>
     * 
     * <p><p>deceasedTime is only present when deceasedInd = 
     * TRUE</p></p>
     * 
     * <p><p>The date and time that a client's death occurred.</p></p>
     * 
     * <p><p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedTime"})
    public Date getClientDeceasedDate() {
        return this.clientDeceasedDate.getValue();
    }
    public void setClientDeceasedDate(Date clientDeceasedDate) {
        this.clientDeceasedDate.setValue(clientDeceasedDate);
    }


    /**
     * <p>ClientHealthcareIdentificationNumber</p>
     * 
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
     * <p>ClientMaskedInformation</p>
     * 
     * <p>Client Masked Information</p>
     * 
     * <p><p>A code that controls the disclosure of information 
     * about this patient encounter.</p></p>
     * 
     * <p><p>Populated attribute supports the business requirement 
     * to provide restricted access where required</p></p>
     * 
     * <p><p>Data in the EHR may at some Data in the EHR may at 
     * some point (and in some jurisdictions) be accessed directly 
     * by patients. Some health information may be deemed 
     * inappropriate for direct access by patients and requires 
     * interpretation by a clinician (e.g. prescription of 
     * placebos, analysis of certain psychiatric conditions, etc) 
     * Even where direct access by patient is not provided, there 
     * may need to be guidance to other providers viewing the 
     * record where care should be used in disclosing information 
     * to the patient. Non-clinical data (e.g. demographics) may 
     * need to be flagged as not for disclosure to patient and or 
     * next of kin. There may be professional policy and or 
     * legislative guidelines about when/if records may be flagged 
     * as not for direct disclosure.</p></p>
     * 
     * <p>Client Masked Information</p>
     * 
     * <p><p>x_NormalRestrictedTabooConfidentialityKind</p><p>A 
     * code that controls the disclosure of information about this 
     * patient encounter.</p></p>
     * 
     * <p><p>x_NormalRestrictedTabooConfidentialityKind</p><p>A 
     * code that controls the disclosure of information about this 
     * patient encounter.</p></p>
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
     * 
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
     * 
     * <p>Client Masked Information</p>
     * 
     * <p><p>A code that controls the disclosure of information 
     * about this patient encounter.</p></p>
     * 
     * <p><p>Required attribute supports the business requirement 
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
    public x_VeryBasicConfidentialityKind getClientMaskedInformation() {
        return (x_VeryBasicConfidentialityKind) this.clientMaskedInformation.getValue();
    }
    public void setClientMaskedInformation(x_VeryBasicConfidentialityKind clientMaskedInformation) {
        this.clientMaskedInformation.setValue(clientMaskedInformation);
    }


    @Hl7XmlMapping({"subjectOf/observationEvent"})
    public ConfidenceValueBean getSubjectOfObservationEvent() {
        return this.subjectOfObservationEvent;
    }
    public void setSubjectOfObservationEvent(ConfidenceValueBean subjectOfObservationEvent) {
        this.subjectOfObservationEvent = subjectOfObservationEvent;
    }


    /**
     * <p>ClientEffectiveTime</p>
     * 
     * <p>Client Effective Time</p>
     * 
     * <p><p>An interval of time specifying the period during which 
     * this record in a client registry is in effect, if such time 
     * limit is applicable and known</p></p>
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

}
