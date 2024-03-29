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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareOrganizationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.prpm_mt306051ca.TerritorialAuthorityBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT080100CA.Organization","COCT_MT090102CA.Organization","COCT_MT090108CA.Organization","COCT_MT090502CA.Organization","COCT_MT090508CA.Organization","COCT_MT260010CA.Organization","COCT_MT260020CA.Organization","COCT_MT260030CA.Organization","POME_MT010040CA.Organization1","POME_MT010040CA.Organization2","POME_MT010040CA.Organization3","POME_MT010040CA.Organization4","PORR_MT050016CA.Organization4","PORX_MT010110CA.Organization","PORX_MT010120CA.Organization","PORX_MT060040CA.Organization","PORX_MT060340CA.Organization","PRPM_MT301010CA.Organization","PRPM_MT303010CA.Organization","PRPM_MT306011CA.Organization","PRPM_MT306051CA.Organization"})
public class ResponsibleOrganizationBean extends MessagePartBean {

    private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();
    private List<TerritorialAuthorityBean> territorialAuthority = new ArrayList<TerritorialAuthorityBean>();
    private SET<AD, PostalAddress> issuingRepresentingQualificationGrantingOrganizationAddressEs = new SETImpl<AD, PostalAddress>(ADImpl.class);
    private CV<HealthcareOrganizationRoleType> organizationType = new CVImpl<HealthcareOrganizationRoleType>();
    private SET<TEL, TelecommunicationAddress> organizationPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);

    @Hl7XmlMapping({"id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }

    @Hl7XmlMapping({"name"})
    public java.lang.String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(java.lang.String organizationName) {
        this.organizationName.setValue(organizationName);
    }

    @Hl7XmlMapping({"territorialAuthority"})
    public List<TerritorialAuthorityBean> getTerritorialAuthority() {
        return this.territorialAuthority;
    }

    @Hl7XmlMapping({"addr"})
    public Set<PostalAddress> getIssuingRepresentingQualificationGrantingOrganizationAddressEs() {
        return this.issuingRepresentingQualificationGrantingOrganizationAddressEs.rawSet();
    }

    @Hl7XmlMapping({"assignedOrganization/code"})
    public HealthcareOrganizationRoleType getOrganizationType() {
        return this.organizationType.getValue();
    }
    public void setOrganizationType(HealthcareOrganizationRoleType organizationType) {
        this.organizationType.setValue(organizationType);
    }

    @Hl7XmlMapping({"assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getOrganizationPhoneAndEmails() {
        return this.organizationPhoneAndEmails.rawSet();
    }

}
