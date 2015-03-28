/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.prpa_mt101104ab;

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
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.merged.OtherIDsNonHealthcareIdentifiersBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.merged.PersonalRelationshipBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.merged.ConfidenceValueBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.merged.LanguageCommunicationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"PRPA_MT101104AB.IdentifiedEntity"})
@Hl7RootType
public class IdentifiedEntityBean extends MessagePartBean {

    private static final long serialVersionUID = 20150328L;
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
     * <p>Business Name: Client Healthcare Identification Number</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-40)</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Client Status Code</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.IdentifiedEntity.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getStatusCode() {
        return (RoleStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Client Status Code</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.IdentifiedEntity.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setStatusCode(RoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Client Effective Time</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104AB.IdentifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Client Effective Time</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104AB.IdentifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Client Masked Information</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104AB.IdentifiedEntity.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: Client Masked Information</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104AB.IdentifiedEntity.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: Client Name</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-20)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/name"})
    public List<PersonName> getIdentifiedPersonName() {
        return this.identifiedPersonName.rawList();
    }


    /**
     * <p>Business Name: Client Telecom</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-10)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/telecom"})
    public List<TelecommunicationAddress> getIdentifiedPersonTelecom() {
        return this.identifiedPersonTelecom.rawList();
    }


    /**
     * <p>Business Name: Client Gender</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104AB.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/administrativeGenderCode"})
    public AdministrativeGender getIdentifiedPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.identifiedPersonAdministrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: Client Gender</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104AB.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setIdentifiedPersonAdministrativeGenderCode(AdministrativeGender identifiedPersonAdministrativeGenderCode) {
        this.identifiedPersonAdministrativeGenderCode.setValue(identifiedPersonAdministrativeGenderCode);
    }


    /**
     * <p>Business Name: Client Date of Birth</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/birthTime"})
    public Date getIdentifiedPersonBirthTime() {
        return this.identifiedPersonBirthTime.getValue();
    }

    /**
     * <p>Business Name: Client Date of Birth</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setIdentifiedPersonBirthTime(Date identifiedPersonBirthTime) {
        this.identifiedPersonBirthTime.setValue(identifiedPersonBirthTime);
    }


    /**
     * <p>Business Name: Client Deceased Indicator</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedInd"})
    public Boolean getIdentifiedPersonDeceasedInd() {
        return this.identifiedPersonDeceasedInd.getValue();
    }

    /**
     * <p>Business Name: Client Deceased Indicator</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setIdentifiedPersonDeceasedInd(Boolean identifiedPersonDeceasedInd) {
        this.identifiedPersonDeceasedInd.setValue(identifiedPersonDeceasedInd);
    }


    /**
     * <p>Business Name: Client Deceased Date</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedTime"})
    public Date getIdentifiedPersonDeceasedTime() {
        return this.identifiedPersonDeceasedTime.getValue();
    }

    /**
     * <p>Business Name: Client Deceased Date</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setIdentifiedPersonDeceasedTime(Date identifiedPersonDeceasedTime) {
        this.identifiedPersonDeceasedTime.setValue(identifiedPersonDeceasedTime);
    }


    /**
     * <p>Business Name: Client Multiple Birth Indicator</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.multipleBirthInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/multipleBirthInd"})
    public Boolean getIdentifiedPersonMultipleBirthInd() {
        return this.identifiedPersonMultipleBirthInd.getValue();
    }

    /**
     * <p>Business Name: Client Multiple Birth Indicator</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.multipleBirthInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setIdentifiedPersonMultipleBirthInd(Boolean identifiedPersonMultipleBirthInd) {
        this.identifiedPersonMultipleBirthInd.setValue(identifiedPersonMultipleBirthInd);
    }


    /**
     * <p>Business Name: Client Multiple Birth Order Number</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104AB.Person.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/multipleBirthOrderNumber"})
    public Integer getIdentifiedPersonMultipleBirthOrderNumber() {
        return this.identifiedPersonMultipleBirthOrderNumber.getValue();
    }

    /**
     * <p>Business Name: Client Multiple Birth Order Number</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104AB.Person.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setIdentifiedPersonMultipleBirthOrderNumber(Integer identifiedPersonMultipleBirthOrderNumber) {
        this.identifiedPersonMultipleBirthOrderNumber.setValue(identifiedPersonMultipleBirthOrderNumber);
    }


    /**
     * <p>Business Name: Client Address</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.Person.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-10)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/addr"})
    public List<PostalAddress> getIdentifiedPersonAddr() {
        return this.identifiedPersonAddr.rawList();
    }


    /**
     * <p>Relationship: PRPA_MT101104AB.Person.asOtherIDs</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/asOtherIDs"})
    public List<OtherIDsNonHealthcareIdentifiersBean> getIdentifiedPersonAsOtherIDs() {
        return this.identifiedPersonAsOtherIDs;
    }


    /**
     * <p>Relationship: PRPA_MT101104AB.Person.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/personalRelationship"})
    public List<PersonalRelationshipBean> getIdentifiedPersonPersonalRelationship() {
        return this.identifiedPersonPersonalRelationship;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101104AB.Person.languageCommunication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-10)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/languageCommunication"})
    public List<LanguageCommunicationBean> getIdentifiedPersonLanguageCommunication() {
        return this.identifiedPersonLanguageCommunication;
    }


    /**
     * <p>Relationship: PRPA_MT101104AB.Subject.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/observationEvent"})
    public ConfidenceValueBean getSubjectOfObservationEvent() {
        return this.subjectOfObservationEvent;
    }

    /**
     * <p>Relationship: PRPA_MT101104AB.Subject.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOfObservationEvent(ConfidenceValueBean subjectOfObservationEvent) {
        this.subjectOfObservationEvent = subjectOfObservationEvent;
    }

}
