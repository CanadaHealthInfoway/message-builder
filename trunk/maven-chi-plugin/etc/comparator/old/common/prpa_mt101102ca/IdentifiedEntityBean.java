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
package ca.infoway.messagebuilder.model.common.prpa_mt101102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.LanguageCommunicationBean;
import ca.infoway.messagebuilder.model.merged.PersonalRelationshipBean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"PRPA_MT101102CA.IdentifiedEntity"})
@Hl7RootType
public class IdentifiedEntityBean extends MessagePartBean {

    private SET<II, Identifier> clientHealthcareIdentificationNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private CS<RoleStatus> clientStatusCode = new CSImpl<RoleStatus>();
    private IVL<TS, Interval<Date>> clientEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV<x_NormalRestrictedTabooConfidentialityKind> clientMaskedInformation = new CVImpl<x_NormalRestrictedTabooConfidentialityKind>();
    private LIST<PN, PersonName> clientName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<TEL, TelecommunicationAddress> clientTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CV<AdministrativeGender> clientGender = new CVImpl<AdministrativeGender>();
    private TS clientDateOfBirth = new TSImpl();
    private BL clientDeceasedIndicator = new BLImpl();
    private TS clientDeceasedDate = new TSImpl();
    private BL clientMultipleBirthIndicator = new BLImpl();
    private INT clientMultipleBirthOrderNumber = new INTImpl();
    private LIST<AD, PostalAddress> clientAddress = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private List<OtherIDsBean> identifiedPersonAsOtherIDs = new ArrayList<OtherIDsBean>();
    private List<PersonalRelationshipBean> identifiedPersonPersonalRelationship = new ArrayList<PersonalRelationshipBean>();
    private List<LanguageCommunicationBean> identifiedPersonLanguageCommunication = new ArrayList<LanguageCommunicationBean>();
    private CD<ActCode> probabilityMatchCode = new CDImpl<ActCode>();
    private REAL confidenceValue = new REALImpl();

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getClientHealthcareIdentificationNumber() {
        return this.clientHealthcareIdentificationNumber.rawSet();
    }

    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getClientStatusCode() {
        return this.clientStatusCode.getValue();
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
    public x_NormalRestrictedTabooConfidentialityKind getClientMaskedInformation() {
        return this.clientMaskedInformation.getValue();
    }
    public void setClientMaskedInformation(x_NormalRestrictedTabooConfidentialityKind clientMaskedInformation) {
        this.clientMaskedInformation.setValue(clientMaskedInformation);
    }

    @Hl7XmlMapping({"identifiedPerson/name"})
    public List<PersonName> getClientName() {
        return this.clientName.rawList();
    }

    @Hl7XmlMapping({"identifiedPerson/telecom"})
    public List<TelecommunicationAddress> getClientTelecom() {
        return this.clientTelecom.rawList();
    }

    @Hl7XmlMapping({"identifiedPerson/administrativeGenderCode"})
    public AdministrativeGender getClientGender() {
        return this.clientGender.getValue();
    }
    public void setClientGender(AdministrativeGender clientGender) {
        this.clientGender.setValue(clientGender);
    }

    @Hl7XmlMapping({"identifiedPerson/birthTime"})
    public Date getClientDateOfBirth() {
        return this.clientDateOfBirth.getValue();
    }
    public void setClientDateOfBirth(Date clientDateOfBirth) {
        this.clientDateOfBirth.setValue(clientDateOfBirth);
    }

    @Hl7XmlMapping({"identifiedPerson/deceasedInd"})
    public java.lang.Boolean getClientDeceasedIndicator() {
        return this.clientDeceasedIndicator.getValue();
    }
    public void setClientDeceasedIndicator(java.lang.Boolean clientDeceasedIndicator) {
        this.clientDeceasedIndicator.setValue(clientDeceasedIndicator);
    }

    @Hl7XmlMapping({"identifiedPerson/deceasedTime"})
    public Date getClientDeceasedDate() {
        return this.clientDeceasedDate.getValue();
    }
    public void setClientDeceasedDate(Date clientDeceasedDate) {
        this.clientDeceasedDate.setValue(clientDeceasedDate);
    }

    @Hl7XmlMapping({"identifiedPerson/multipleBirthInd"})
    public java.lang.Boolean getClientMultipleBirthIndicator() {
        return this.clientMultipleBirthIndicator.getValue();
    }
    public void setClientMultipleBirthIndicator(java.lang.Boolean clientMultipleBirthIndicator) {
        this.clientMultipleBirthIndicator.setValue(clientMultipleBirthIndicator);
    }

    @Hl7XmlMapping({"identifiedPerson/multipleBirthOrderNumber"})
    public java.lang.Integer getClientMultipleBirthOrderNumber() {
        return this.clientMultipleBirthOrderNumber.getValue();
    }
    public void setClientMultipleBirthOrderNumber(java.lang.Integer clientMultipleBirthOrderNumber) {
        this.clientMultipleBirthOrderNumber.setValue(clientMultipleBirthOrderNumber);
    }

    @Hl7XmlMapping({"identifiedPerson/addr"})
    public List<PostalAddress> getClientAddress() {
        return this.clientAddress.rawList();
    }

    @Hl7XmlMapping({"identifiedPerson/asOtherIDs"})
    public List<OtherIDsBean> getIdentifiedPersonAsOtherIDs() {
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

    @Hl7XmlMapping({"subjectOf/observationEvent/code"})
    public ActCode getProbabilityMatchCode() {
        return this.probabilityMatchCode.getValue();
    }
    public void setProbabilityMatchCode(ActCode probabilityMatchCode) {
        this.probabilityMatchCode.setValue(probabilityMatchCode);
    }

    @Hl7XmlMapping({"subjectOf/observationEvent/value"})
    public BigDecimal getConfidenceValue() {
        return this.confidenceValue.getValue();
    }
    public void setConfidenceValue(BigDecimal confidenceValue) {
        this.confidenceValue.setValue(confidenceValue);
    }

}
