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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.HealthcareOrganizationRoleType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt911107ca.ActingPersonBean;
import ca.infoway.messagebuilder.model.common.rcmr_mt010001ca.RecipientBean;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT090102CA.AssignedEntity","COCT_MT090108CA.AssignedEntity","COCT_MT090502CA.AssignedEntity","COCT_MT090508CA.AssignedEntity","PORR_MT050016CA.AssignedEntity"})
@Hl7RootType
public class HealthcareWorkerBean extends MessagePartBean implements ChangedByBean, ca.infoway.messagebuilder.model.common.coct_mt911102ca.ActingPersonBean, ActingPersonBean, ca.infoway.messagebuilder.model.common.coct_mt470002ca.RecipientBean, PartyBean, RecipientBean, ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPersonBean {

    private II healthcareWorkerIdentifier = new IIImpl();
    private CV<HealthcareProviderRoleType> healthcareWorkerType = new CVImpl<HealthcareProviderRoleType>();
    private SET<TEL, TelecommunicationAddress> healthcareWorkerPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN patientName = new PNImpl();
    private CV<AdministrativeGender> patientGender = new CVImpl<AdministrativeGender>();
    private TS patientBirthDate = new TSImpl();
    private SET<TEL, TelecommunicationAddress> relatedPersonPhonesAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private AD relatedPersonAddress = new ADImpl();
    private II licenseNumber = new IIImpl();
    private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();
    private CV<HealthcareOrganizationRoleType> organizationType = new CVImpl<HealthcareOrganizationRoleType>();
    private SET<TEL, TelecommunicationAddress> organizationPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);

    @Hl7XmlMapping({"id"})
    public Identifier getHealthcareWorkerIdentifier() {
        return this.healthcareWorkerIdentifier.getValue();
    }
    public void setHealthcareWorkerIdentifier(Identifier healthcareWorkerIdentifier) {
        this.healthcareWorkerIdentifier.setValue(healthcareWorkerIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getHealthcareWorkerType() {
        return this.healthcareWorkerType.getValue();
    }
    public void setHealthcareWorkerType(HealthcareProviderRoleType healthcareWorkerType) {
        this.healthcareWorkerType.setValue(healthcareWorkerType);
    }

    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getHealthcareWorkerPhoneAndEmails() {
        return this.healthcareWorkerPhoneAndEmails.rawSet();
    }

    @Hl7XmlMapping({"assignedPerson/name"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }

    @Hl7XmlMapping({"assignedPerson/administrativeGenderCode"})
    public AdministrativeGender getPatientGender() {
        return this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }

    @Hl7XmlMapping({"assignedPerson/birthTime"})
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }
    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }

    @Hl7XmlMapping({"assignedPerson/telecom"})
    public Set<TelecommunicationAddress> getRelatedPersonPhonesAndEmails() {
        return this.relatedPersonPhonesAndEmails.rawSet();
    }

    @Hl7XmlMapping({"assignedPerson/addr"})
    public PostalAddress getRelatedPersonAddress() {
        return this.relatedPersonAddress.getValue();
    }
    public void setRelatedPersonAddress(PostalAddress relatedPersonAddress) {
        this.relatedPersonAddress.setValue(relatedPersonAddress);
    }

    @Hl7XmlMapping({"assignedPerson/asHealthCareProvider/id"})
    public Identifier getLicenseNumber() {
        return this.licenseNumber.getValue();
    }
    public void setLicenseNumber(Identifier licenseNumber) {
        this.licenseNumber.setValue(licenseNumber);
    }

    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }

    @Hl7XmlMapping({"representedOrganization/name"})
    public java.lang.String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(java.lang.String organizationName) {
        this.organizationName.setValue(organizationName);
    }

    @Hl7XmlMapping({"representedOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getOrganizationType() {
        return this.organizationType.getValue();
    }
    public void setOrganizationType(HealthcareOrganizationRoleType organizationType) {
        this.organizationType.setValue(organizationType);
    }

    @Hl7XmlMapping({"representedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getOrganizationPhoneAndEmails() {
        return this.organizationPhoneAndEmails.rawSet();
    }

}
