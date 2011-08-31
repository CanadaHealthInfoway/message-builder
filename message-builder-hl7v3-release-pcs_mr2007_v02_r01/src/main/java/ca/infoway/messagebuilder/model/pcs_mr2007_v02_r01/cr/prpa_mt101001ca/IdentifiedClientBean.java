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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.prpa_mt101001ca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.merged.LanguageCommunicationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.merged.OtherIDsNonHealthcareIdentifiersBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.merged.PersonalRelationshipBean;



@Hl7PartTypeMapping({"PRPA_MT101001CA.IdentifiedEntity"})
@Hl7RootType
public class IdentifiedClientBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private SET<II, Identifier> clientHealthcareIdentificationNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private CS clientStatusCode = new CSImpl();
    private IVL<TS, Interval<Date>> clientEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV clientMaskedInformation = new CVImpl();
    private LIST<PN, PersonName> clientName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<TEL, TelecommunicationAddress> clientTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CV clientGender = new CVImpl();
    private TS clientDateOfBirth = new TSImpl();
    private BL clientDeceasedIndicator = new BLImpl();
    private TS clientDeceasedDate = new TSImpl();
    private BL clientMultipleBirthIndicator = new BLImpl();
    private INT clientMultipleBirthOrderNumber = new INTImpl();
    private LIST<AD, PostalAddress> clientAddress = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private List<OtherIDsNonHealthcareIdentifiersBean> identifiedPersonAsOtherIDs = new ArrayList<OtherIDsNonHealthcareIdentifiersBean>();
    private List<PersonalRelationshipBean> identifiedPersonPersonalRelationship = new ArrayList<PersonalRelationshipBean>();
    private List<LanguageCommunicationBean> identifiedPersonLanguageCommunication = new ArrayList<LanguageCommunicationBean>();


    /**
     * <p>Client Healthcare Identification Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getClientHealthcareIdentificationNumber() {
        return this.clientHealthcareIdentificationNumber.rawSet();
    }


    /**
     * <p>Client Status Code</p>
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
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_NormalRestrictedTabooConfidentialityKind getClientMaskedInformation() {
        return (x_NormalRestrictedTabooConfidentialityKind) this.clientMaskedInformation.getValue();
    }
    public void setClientMaskedInformation(x_NormalRestrictedTabooConfidentialityKind clientMaskedInformation) {
        this.clientMaskedInformation.setValue(clientMaskedInformation);
    }


    /**
     * <p>Client Name</p>
     */
    @Hl7XmlMapping({"identifiedPerson/name"})
    public List<PersonName> getClientName() {
        return this.clientName.rawList();
    }


    /**
     * <p>Client Telecom</p>
     */
    @Hl7XmlMapping({"identifiedPerson/telecom"})
    public List<TelecommunicationAddress> getClientTelecom() {
        return this.clientTelecom.rawList();
    }


    /**
     * <p>Client Gender</p>
     */
    @Hl7XmlMapping({"identifiedPerson/administrativeGenderCode"})
    public AdministrativeGender getClientGender() {
        return (AdministrativeGender) this.clientGender.getValue();
    }
    public void setClientGender(AdministrativeGender clientGender) {
        this.clientGender.setValue(clientGender);
    }


    /**
     * <p>Client Date of Birth</p>
     */
    @Hl7XmlMapping({"identifiedPerson/birthTime"})
    public Date getClientDateOfBirth() {
        return this.clientDateOfBirth.getValue();
    }
    public void setClientDateOfBirth(Date clientDateOfBirth) {
        this.clientDateOfBirth.setValue(clientDateOfBirth);
    }


    /**
     * <p>Client Deceased Indicator</p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedInd"})
    public Boolean getClientDeceasedIndicator() {
        return this.clientDeceasedIndicator.getValue();
    }
    public void setClientDeceasedIndicator(Boolean clientDeceasedIndicator) {
        this.clientDeceasedIndicator.setValue(clientDeceasedIndicator);
    }


    /**
     * <p>Client Deceased Date</p>
     */
    @Hl7XmlMapping({"identifiedPerson/deceasedTime"})
    public Date getClientDeceasedDate() {
        return this.clientDeceasedDate.getValue();
    }
    public void setClientDeceasedDate(Date clientDeceasedDate) {
        this.clientDeceasedDate.setValue(clientDeceasedDate);
    }


    /**
     * <p>Client Multiple Birth Indicator</p>
     */
    @Hl7XmlMapping({"identifiedPerson/multipleBirthInd"})
    public Boolean getClientMultipleBirthIndicator() {
        return this.clientMultipleBirthIndicator.getValue();
    }
    public void setClientMultipleBirthIndicator(Boolean clientMultipleBirthIndicator) {
        this.clientMultipleBirthIndicator.setValue(clientMultipleBirthIndicator);
    }


    /**
     * <p>Client Multiple Birth Order Number</p>
     */
    @Hl7XmlMapping({"identifiedPerson/multipleBirthOrderNumber"})
    public Integer getClientMultipleBirthOrderNumber() {
        return this.clientMultipleBirthOrderNumber.getValue();
    }
    public void setClientMultipleBirthOrderNumber(Integer clientMultipleBirthOrderNumber) {
        this.clientMultipleBirthOrderNumber.setValue(clientMultipleBirthOrderNumber);
    }


    /**
     * <p>Client Address</p>
     */
    @Hl7XmlMapping({"identifiedPerson/addr"})
    public List<PostalAddress> getClientAddress() {
        return this.clientAddress.rawList();
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

}
