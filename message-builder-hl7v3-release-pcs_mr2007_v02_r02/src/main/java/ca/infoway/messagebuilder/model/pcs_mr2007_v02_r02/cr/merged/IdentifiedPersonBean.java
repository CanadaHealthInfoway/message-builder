/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * <p>Business Name: IdentifiedPerson</p>
 * 
 * <p>PRPA_MT101104CA.IdentifiedEntity: Identified Person</p>
 * 
 * <p>Provides the message entry point required to add a person 
 * to the Client Registry</p>
 * 
 * <p>The IdentifiedEntity class is the entry point to the 
 * R-MIM and contains one or more identifiers (for example an 
 * &quot;internal&quot; id used only by computer systems and an 
 * &quot;external&quot; id for display to users) for the Person 
 * in the Client Registry. The statusCode is set to 
 * &quot;active&quot;. The beginning of the effectiveTime is 
 * when the record was added to the registry.</p>
 * 
 * <p>PRPA_MT101002CA.IdentifiedEntity: Identified Person</p>
 * 
 * <p>Provides the message entry point required to add a person 
 * to the Client Registry</p>
 * 
 * <p>The IdentifiedEntity class is the entry point to the 
 * R-MIM and contains one or more identifiers (for example an 
 * &quot;internal&quot; id used only by computer systems and an 
 * &quot;external&quot; id for display to users) for the Person 
 * in the Client Registry. The statusCode is set to 
 * &quot;active&quot;. The beginning of the effectiveTime is 
 * when the record was added to the registry.</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101002CA.IdentifiedEntity","PRPA_MT101104CA.IdentifiedEntity"})
@Hl7RootType
public class IdentifiedPersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
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
     * <p>Business Name: ClientHealthcareIdentificationNumber</p>
     * 
     * <p>Other Business Name: ClientHealthcareIdentificationNumber</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-100)</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client.</p>
     * 
     * <p>At least 1 client identifier must be present in the 
     * message</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     * 
     * <p>Other Business Name: ClientHealthcareIdentificationNumber</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-40)</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client.</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: ClientStatusCode</p>
     * 
     * <p>Other Business Name: ClientStatusCode</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdentifiedEntity.statusCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the status of the Client role (e.g. Active)</p>
     * 
     * <p>Other Business Name: ClientStatusCode</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdentifiedEntity.statusCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the status of the Client role (e.g. Active)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getStatusCode() {
        return (RoleStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: ClientStatusCode</p>
     * 
     * <p>Other Business Name: ClientStatusCode</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdentifiedEntity.statusCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the status of the Client role (e.g. Active)</p>
     * 
     * <p>Other Business Name: ClientStatusCode</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdentifiedEntity.statusCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the status of the Client role (e.g. Active)</p>
     */
    public void setStatusCode(RoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: ClientEffectiveTime</p>
     * 
     * <p>Other Business Name: ClientEffectiveTime</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.IdentifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the effective time of the Client role</p>
     * 
     * <p>Other Business Name: ClientEffectiveTime</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.IdentifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the effective time of the Client role</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: ClientEffectiveTime</p>
     * 
     * <p>Other Business Name: ClientEffectiveTime</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.IdentifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the effective time of the Client role</p>
     * 
     * <p>Other Business Name: ClientEffectiveTime</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.IdentifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the effective time of the Client role</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: ClientMaskedInformation</p>
     * 
     * <p>Other Business Name: ClientMaskedInformation</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.IdentifiedEntity.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the business requirement to 
     * provide restricted access where required</p>
     * 
     * <p>Data in the EHR may at some Data in the EHR may at some 
     * point (and in some jurisdictions) be accessed directly by 
     * patients. Some health information may be deemed 
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
     * as not for direct disclosure.</p>
     * 
     * <p>A code that controls the disclosure of information about 
     * this patient encounter.</p>
     * 
     * <p>Other Business Name: ClientMaskedInformation</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.IdentifiedEntity.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the business requirement to 
     * provide restricted access where required</p>
     * 
     * <p>Data in the EHR may at some point (and in some 
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
     * may be flagged as not for direct disclosure.</p>
     * 
     * <p>A code that controls the disclosure of information about 
     * this patient encounter.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_NormalRestrictedTabooConfidentialityKind getConfidentialityCode() {
        return (x_NormalRestrictedTabooConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: ClientMaskedInformation</p>
     * 
     * <p>Other Business Name: ClientMaskedInformation</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.IdentifiedEntity.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the business requirement to 
     * provide restricted access where required</p>
     * 
     * <p>Data in the EHR may at some Data in the EHR may at some 
     * point (and in some jurisdictions) be accessed directly by 
     * patients. Some health information may be deemed 
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
     * as not for direct disclosure.</p>
     * 
     * <p>A code that controls the disclosure of information about 
     * this patient encounter.</p>
     * 
     * <p>Other Business Name: ClientMaskedInformation</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.IdentifiedEntity.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the business requirement to 
     * provide restricted access where required</p>
     * 
     * <p>Data in the EHR may at some point (and in some 
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
     * may be flagged as not for direct disclosure.</p>
     * 
     * <p>A code that controls the disclosure of information about 
     * this patient encounter.</p>
     */
    public void setConfidentialityCode(x_NormalRestrictedTabooConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: ClientName</p>
     * 
     * <p>Other Business Name: ClientName</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-20)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Name(s) for the Client</p>
     * 
     * <p>Other Business Name: ClientName</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-20)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Name(s) for the Client</p>
     */
    @Hl7XmlMapping({"identifiedPerson/name"})
    public List<PersonName> getIdentifiedPersonName() {
        return this.identifiedPersonName.rawList();
    }


    /**
     * <p>Business Name: ClientTelecom</p>
     * 
     * <p>Other Business Name: ClientTelecom</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.telecom</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-10)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Provides information about telecom</p>
     * 
     * <p>Other Business Name: ClientTelecom</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.telecom</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-20)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>Provides information about telecom</p>
     */
    @Hl7XmlMapping({"identifiedPerson/telecom"})
    public List<TelecommunicationAddress> getIdentifiedPersonTelecom() {
        return this.identifiedPersonTelecom.rawList();
    }


    /**
     * <p>Business Name: ClientGender</p>
     * 
     * <p>Other Business Name: ClientGender</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or 
     * Undifferentiated (U)</p>
     * 
     * <p>Other Business Name: ClientGender</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or 
     * Undifferentiated (U)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/administrativeGenderCode"})
    public AdministrativeGender getIdentifiedPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.identifiedPersonAdministrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: ClientGender</p>
     * 
     * <p>Other Business Name: ClientGender</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or 
     * Undifferentiated (U)</p>
     * 
     * <p>Other Business Name: ClientGender</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or 
     * Undifferentiated (U)</p>
     */
    public void setIdentifiedPersonAdministrativeGenderCode(AdministrativeGender identifiedPersonAdministrativeGenderCode) {
        this.identifiedPersonAdministrativeGenderCode.setValue(identifiedPersonAdministrativeGenderCode);
    }


    /**
     * <p>Business Name: ClientDateOfBirth</p>
     * 
     * <p>Other Business Name: ClientDateOfBirth</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Date of birth of the Client</p>
     * 
     * <p>Other Business Name: ClientDateOfBirth</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Date of birth of the Client</p>
     */
    @Hl7XmlMapping({"identifiedPerson/birthTime"})
    public Date getIdentifiedPersonBirthTime() {
        return this.identifiedPersonBirthTime.getValue();
    }

    /**
     * <p>Business Name: ClientDateOfBirth</p>
     * 
     * <p>Other Business Name: ClientDateOfBirth</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Date of birth of the Client</p>
     * 
     * <p>Other Business Name: ClientDateOfBirth</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Date of birth of the Client</p>
     */
    public void setIdentifiedPersonBirthTime(Date identifiedPersonBirthTime) {
        this.identifiedPersonBirthTime.setValue(identifiedPersonBirthTime);
    }


    /**
     * <p>Business Name: ClientDeceasedIndicator</p>
     * 
     * <p>Other Business Name: ClientDeceasedIndicator</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An indication that the client is deceased.</p>
     * 
     * <p>Other Business Name: ClientDeceasedIndicator</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An indication that the client is deceased.</p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedInd"})
    public Boolean getIdentifiedPersonDeceasedInd() {
        return this.identifiedPersonDeceasedInd.getValue();
    }

    /**
     * <p>Business Name: ClientDeceasedIndicator</p>
     * 
     * <p>Other Business Name: ClientDeceasedIndicator</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An indication that the client is deceased.</p>
     * 
     * <p>Other Business Name: ClientDeceasedIndicator</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An indication that the client is deceased.</p>
     */
    public void setIdentifiedPersonDeceasedInd(Boolean identifiedPersonDeceasedInd) {
        this.identifiedPersonDeceasedInd.setValue(identifiedPersonDeceasedInd);
    }


    /**
     * <p>Business Name: ClientDeceasedDate</p>
     * 
     * <p>Other Business Name: ClientDeceasedDate</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p>
     * 
     * <p>The date and time that a client's death occurred.</p>
     * 
     * <p>Other Business Name: ClientDeceasedDate</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>deceasedTime only present if deceasedInd is = TRUE</p>
     * 
     * <p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p>
     * 
     * <p>The date and time that a client's death occurred.</p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedTime"})
    public Date getIdentifiedPersonDeceasedTime() {
        return this.identifiedPersonDeceasedTime.getValue();
    }

    /**
     * <p>Business Name: ClientDeceasedDate</p>
     * 
     * <p>Other Business Name: ClientDeceasedDate</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p>
     * 
     * <p>The date and time that a client's death occurred.</p>
     * 
     * <p>Other Business Name: ClientDeceasedDate</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>deceasedTime only present if deceasedInd is = TRUE</p>
     * 
     * <p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p>
     * 
     * <p>The date and time that a client's death occurred.</p>
     */
    public void setIdentifiedPersonDeceasedTime(Date identifiedPersonDeceasedTime) {
        this.identifiedPersonDeceasedTime.setValue(identifiedPersonDeceasedTime);
    }


    /**
     * <p>Business Name: ClientMultipleBirthIndicator</p>
     * 
     * <p>Other Business Name: ClientMultipleBirthIndicator</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.multipleBirthInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An indication as to whether the client is part of a 
     * multiple birth.</p>
     * 
     * <p>Other Business Name: ClientMultipleBirthIndicator</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.multipleBirthInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An indication as to whether the client is part of a 
     * multiple birth.</p>
     */
    @Hl7XmlMapping({"identifiedPerson/multipleBirthInd"})
    public Boolean getIdentifiedPersonMultipleBirthInd() {
        return this.identifiedPersonMultipleBirthInd.getValue();
    }

    /**
     * <p>Business Name: ClientMultipleBirthIndicator</p>
     * 
     * <p>Other Business Name: ClientMultipleBirthIndicator</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.multipleBirthInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An indication as to whether the client is part of a 
     * multiple birth.</p>
     * 
     * <p>Other Business Name: ClientMultipleBirthIndicator</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.multipleBirthInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An indication as to whether the client is part of a 
     * multiple birth.</p>
     */
    public void setIdentifiedPersonMultipleBirthInd(Boolean identifiedPersonMultipleBirthInd) {
        this.identifiedPersonMultipleBirthInd.setValue(identifiedPersonMultipleBirthInd);
    }


    /**
     * <p>Business Name: ClientMultipleBirthOrderNumber</p>
     * 
     * <p>Other Business Name: ClientMultipleBirthOrderNumber</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.Person.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>The order in which this client was born if part of a 
     * multiple birth.</p>
     * 
     * <p>Other Business Name: ClientMultipleBirthOrderNumber</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.Person.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>The order in which this client was born if part of a 
     * multiple birth.</p>
     */
    @Hl7XmlMapping({"identifiedPerson/multipleBirthOrderNumber"})
    public Integer getIdentifiedPersonMultipleBirthOrderNumber() {
        return this.identifiedPersonMultipleBirthOrderNumber.getValue();
    }

    /**
     * <p>Business Name: ClientMultipleBirthOrderNumber</p>
     * 
     * <p>Other Business Name: ClientMultipleBirthOrderNumber</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.Person.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>The order in which this client was born if part of a 
     * multiple birth.</p>
     * 
     * <p>Other Business Name: ClientMultipleBirthOrderNumber</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.Person.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>The order in which this client was born if part of a 
     * multiple birth.</p>
     */
    public void setIdentifiedPersonMultipleBirthOrderNumber(Integer identifiedPersonMultipleBirthOrderNumber) {
        this.identifiedPersonMultipleBirthOrderNumber.setValue(identifiedPersonMultipleBirthOrderNumber);
    }


    /**
     * <p>Business Name: ClientAddress</p>
     * 
     * <p>Other Business Name: ClientAddress</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-10)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Address(es) of the Client</p>
     * 
     * <p>Other Business Name: ClientAddress</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-10)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Address(es) of the Client</p>
     */
    @Hl7XmlMapping({"identifiedPerson/addr"})
    public List<PostalAddress> getIdentifiedPersonAddr() {
        return this.identifiedPersonAddr.rawList();
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.asOtherIDs</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.asOtherIDs</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/asOtherIDs"})
    public List<OtherIDsNonHealthcareIdentifiersBean> getIdentifiedPersonAsOtherIDs() {
        return this.identifiedPersonAsOtherIDs;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Person.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.Person.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/personalRelationship"})
    public List<PersonalRelationshipBean> getIdentifiedPersonPersonalRelationship() {
        return this.identifiedPersonPersonalRelationship;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.Person.languageCommunication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-10)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.Person.languageCommunication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-10)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/languageCommunication"})
    public List<LanguageCommunicationBean> getIdentifiedPersonLanguageCommunication() {
        return this.identifiedPersonLanguageCommunication;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Subject.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/observationEvent"})
    public ConfidenceValueBean getSubjectOfObservationEvent() {
        return this.subjectOfObservationEvent;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.Subject.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOfObservationEvent(ConfidenceValueBean subjectOfObservationEvent) {
        this.subjectOfObservationEvent = subjectOfObservationEvent;
    }

}
