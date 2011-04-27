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
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.prpm_mt301010ca.ChoiceBean;
import ca.infoway.messagebuilder.model.common.prpm_mt301010ca.RoleChoiceBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT090102CA.HealthCareProvider","COCT_MT090108CA.HealthCareProvider","PRPM_MT301010CA.HealthCareProvider"})
public class HealthCareProvider_1Bean extends MessagePartBean implements RoleChoiceBean, ChoiceBean {

    private II healthcareProviderRoleIdentification = new IIImpl();
    private CV<HealthcareProviderRoleType> healthcareProviderRoleType = new CVImpl<HealthcareProviderRoleType>();
    private LIST<PN, PersonName> healthcareProviderRoleName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<AD, PostalAddress> healthcareProviderRoleAddress = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> healthcareProviderRoleTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CS<RoleStatus> healthcareProviderRoleStatusCode = new CSImpl<RoleStatus>();
    private IVL<TS, Interval<Date>> healthcareProviderRoleEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private PrincipalPerson_1Bean healthCarePrincipalPerson;
    private ResponsibleOrganizationBean issuingOrganization;

    @Hl7XmlMapping({"id"})
    public Identifier getHealthcareProviderRoleIdentification() {
        return this.healthcareProviderRoleIdentification.getValue();
    }
    public void setHealthcareProviderRoleIdentification(Identifier healthcareProviderRoleIdentification) {
        this.healthcareProviderRoleIdentification.setValue(healthcareProviderRoleIdentification);
    }

    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getHealthcareProviderRoleType() {
        return this.healthcareProviderRoleType.getValue();
    }
    public void setHealthcareProviderRoleType(HealthcareProviderRoleType healthcareProviderRoleType) {
        this.healthcareProviderRoleType.setValue(healthcareProviderRoleType);
    }

    @Hl7XmlMapping({"name"})
    public List<PersonName> getHealthcareProviderRoleName() {
        return this.healthcareProviderRoleName.rawList();
    }

    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getHealthcareProviderRoleAddress() {
        return this.healthcareProviderRoleAddress.rawList();
    }

    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getHealthcareProviderRoleTelecom() {
        return this.healthcareProviderRoleTelecom.rawList();
    }

    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getHealthcareProviderRoleStatusCode() {
        return this.healthcareProviderRoleStatusCode.getValue();
    }
    public void setHealthcareProviderRoleStatusCode(RoleStatus healthcareProviderRoleStatusCode) {
        this.healthcareProviderRoleStatusCode.setValue(healthcareProviderRoleStatusCode);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getHealthcareProviderRoleEffectiveDate() {
        return this.healthcareProviderRoleEffectiveDate.getValue();
    }
    public void setHealthcareProviderRoleEffectiveDate(Interval<Date> healthcareProviderRoleEffectiveDate) {
        this.healthcareProviderRoleEffectiveDate.setValue(healthcareProviderRoleEffectiveDate);
    }

    @Hl7XmlMapping({"healthCarePrincipalPerson"})
    public PrincipalPerson_1Bean getHealthCarePrincipalPerson() {
        return this.healthCarePrincipalPerson;
    }
    public void setHealthCarePrincipalPerson(PrincipalPerson_1Bean healthCarePrincipalPerson) {
        this.healthCarePrincipalPerson = healthCarePrincipalPerson;
    }

    @Hl7XmlMapping({"issuingOrganization"})
    public ResponsibleOrganizationBean getIssuingOrganization() {
        return this.issuingOrganization;
    }
    public void setIssuingOrganization(ResponsibleOrganizationBean issuingOrganization) {
        this.issuingOrganization = issuingOrganization;
    }

}
