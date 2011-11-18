/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.cr.merged;

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
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.LanguageCommunicationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>IdentifiedPerson</p>
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
@Hl7PartTypeMapping({"PRPA_MT101002CA.IdentifiedEntity","PRPA_MT101104CA.IdentifiedEntity"})
@Hl7RootType
public class IdentifiedPersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private LIST<PN, PersonName> identifiedPersonName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<TEL, TelecommunicationAddress> identifiedPersonTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CV identifiedPersonAdministrativeGenderCode = new CVImpl();
    private TS identifiedPersonBirthTime = new TSImpl();
    private BL identifiedPersonDeceasedInd = new BLImpl();
    private TS identifiedPersonDeceasedTime = new TSImpl();
    private BL identifiedPersonMultipleBirthInd = new BLImpl();
    private INT identifiedPersonMultipleBirthOrderNumber = new INTImpl();
    private LIST<AD, PostalAddress> identifiedPersonAddr = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private List<OtherIDsNonHealthcareIdentifiersBean> identifiedPersonAsOtherIDs = new ArrayList<OtherIDsNonHealthcareIdentifiersBean>();
    private List<PersonalRelationshipBean> identifiedPersonPersonalRelationship = new ArrayList<PersonalRelationshipBean>();
    private List<LanguageCommunicationBean> identifiedPersonLanguageCommunication = new ArrayList<LanguageCommunicationBean>();
    private ConfidenceValueBean subjectOfObservationEvent;


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
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


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
    public RoleStatus getStatusCode() {
        return (RoleStatus) this.statusCode.getValue();
    }
    public void setStatusCode(RoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>ClientEffectiveTime</p>
     * 
     * <p>Client Effective Time</p>
     * 
     * <p><p>Indicates the effective time of the Client role</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
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
    public x_NormalRestrictedTabooConfidentialityKind getConfidentialityCode() {
        return (x_NormalRestrictedTabooConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_NormalRestrictedTabooConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
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
    public List<PersonName> getIdentifiedPersonName() {
        return this.identifiedPersonName.rawList();
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
    public List<TelecommunicationAddress> getIdentifiedPersonTelecom() {
        return this.identifiedPersonTelecom.rawList();
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
     */
    @Hl7XmlMapping({"identifiedPerson/administrativeGenderCode"})
    public AdministrativeGender getIdentifiedPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.identifiedPersonAdministrativeGenderCode.getValue();
    }
    public void setIdentifiedPersonAdministrativeGenderCode(AdministrativeGender identifiedPersonAdministrativeGenderCode) {
        this.identifiedPersonAdministrativeGenderCode.setValue(identifiedPersonAdministrativeGenderCode);
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
    public Date getIdentifiedPersonBirthTime() {
        return this.identifiedPersonBirthTime.getValue();
    }
    public void setIdentifiedPersonBirthTime(Date identifiedPersonBirthTime) {
        this.identifiedPersonBirthTime.setValue(identifiedPersonBirthTime);
    }


    /**
     * <p>ClientDeceasedIndicator</p>
     * 
     * <p>Client Deceased Indicator</p>
     * 
     * <p><p>An indication that the client is deceased.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedInd"})
    public Boolean getIdentifiedPersonDeceasedInd() {
        return this.identifiedPersonDeceasedInd.getValue();
    }
    public void setIdentifiedPersonDeceasedInd(Boolean identifiedPersonDeceasedInd) {
        this.identifiedPersonDeceasedInd.setValue(identifiedPersonDeceasedInd);
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
     * <p><p>The date and time that a client's death occurred.</p></p>
     * 
     * <p><p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedTime"})
    public Date getIdentifiedPersonDeceasedTime() {
        return this.identifiedPersonDeceasedTime.getValue();
    }
    public void setIdentifiedPersonDeceasedTime(Date identifiedPersonDeceasedTime) {
        this.identifiedPersonDeceasedTime.setValue(identifiedPersonDeceasedTime);
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
    public Boolean getIdentifiedPersonMultipleBirthInd() {
        return this.identifiedPersonMultipleBirthInd.getValue();
    }
    public void setIdentifiedPersonMultipleBirthInd(Boolean identifiedPersonMultipleBirthInd) {
        this.identifiedPersonMultipleBirthInd.setValue(identifiedPersonMultipleBirthInd);
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
    public Integer getIdentifiedPersonMultipleBirthOrderNumber() {
        return this.identifiedPersonMultipleBirthOrderNumber.getValue();
    }
    public void setIdentifiedPersonMultipleBirthOrderNumber(Integer identifiedPersonMultipleBirthOrderNumber) {
        this.identifiedPersonMultipleBirthOrderNumber.setValue(identifiedPersonMultipleBirthOrderNumber);
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
    public List<PostalAddress> getIdentifiedPersonAddr() {
        return this.identifiedPersonAddr.rawList();
    }


    @Hl7XmlMapping({"identifiedPerson/asOtherIDs"})
    public List<OtherIDsNonHealthcareIdentifiersBean> getIdentifiedPersonAsOtherIDs() {
        return this.identifiedPersonAsOtherIDs;
    }


    @Hl7XmlMapping({"identifiedPerson/personalRelationship"})
    public List<PersonalRelationshipBean> getIdentifiedPersonPersonalRelationship() {
        return this.identifiedPersonPersonalRelationship;
    }


    @Hl7XmlMapping({"identifiedPerson/languageCommunication"})
    public List<LanguageCommunicationBean> getIdentifiedPersonLanguageCommunication() {
        return this.identifiedPersonLanguageCommunication;
    }


    @Hl7XmlMapping({"subjectOf/observationEvent"})
    public ConfidenceValueBean getSubjectOfObservationEvent() {
        return this.subjectOfObservationEvent;
    }
    public void setSubjectOfObservationEvent(ConfidenceValueBean subjectOfObservationEvent) {
        this.subjectOfObservationEvent = subjectOfObservationEvent;
    }

}
