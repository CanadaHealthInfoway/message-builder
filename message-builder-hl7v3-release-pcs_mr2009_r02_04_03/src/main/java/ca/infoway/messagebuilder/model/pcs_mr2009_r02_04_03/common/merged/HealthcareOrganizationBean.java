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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AssignedRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ResponsibleOrganizationBean;
import java.util.List;
import java.util.Set;



/**
 * <p>COCT_MT090108CA.AssignedEntity: Healthcare Worker</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 * 
 * <p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p>
 * 
 * <p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p>
 * 
 * <p>COCT_MT090502CA.AssignedEntity: Healthcare Organization</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up.</p>
 * 
 * <p>The organization under whose authority the associated 
 * action (linked by a participation) was performed.</p>
 */
@Hl7PartTypeMapping({"COCT_MT090108CA.AssignedEntity","COCT_MT090502CA.AssignedEntity"})
@Hl7RootType
public class HealthcareOrganizationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.Party, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt080100ca.PerformerChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.RecipientChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Choice, ActingPerson, AuthorPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Recipient, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.RoleChoice, EntererChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt011001ca.Assignees, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged.ChangedBy {

    private static final long serialVersionUID = 20130613L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN assignedPersonName = new PNImpl();
    private II assignedPersonAsHealthCareProviderId = new IIImpl();
    private ResponsibleOrganizationBean representedOrganization;


    /**
     * <p>Business Name: HealthcareWorkerIdentifier</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerIdentifier</p>
     * 
     * <p>Relationship: COCT_MT090108CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-3)</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability and is therefore mandatory.</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: HealthcareWorkerType</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerType</p>
     * 
     * <p>Relationship: COCT_MT090108CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public AssignedRoleType getCode() {
        return (AssignedRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: HealthcareWorkerType</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerType</p>
     * 
     * <p>Relationship: COCT_MT090108CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     */
    public void setCode(AssignedRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>Relationship: COCT_MT090108CA.AssignedEntity.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>This is the most commonly used piece of contact 
     * information and is returned here to avoid unnecessary 
     * queries of the provider registry.</p>
     * 
     * <p>Indicates phone and/or e-mail addresses at which the 
     * healthcare worker can be reached.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Business Name: HealthcareWorkerName</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerName</p>
     * 
     * <p>Relationship: COCT_MT090108CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>This is a human-readable name and is thus essential for 
     * both display and validation of the person. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>The name of the participating person.</p>
     */
    @Hl7XmlMapping({"assignedPerson/name"})
    public PersonName getAssignedPersonName() {
        return this.assignedPersonName.getValue();
    }

    /**
     * <p>Business Name: HealthcareWorkerName</p>
     * 
     * <p>Un-merged Business Name: HealthcareWorkerName</p>
     * 
     * <p>Relationship: COCT_MT090108CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>This is a human-readable name and is thus essential for 
     * both display and validation of the person. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>The name of the participating person.</p>
     */
    public void setAssignedPersonName(PersonName assignedPersonName) {
        this.assignedPersonName.setValue(assignedPersonName);
    }


    /**
     * <p>Business Name: LicenseNumber</p>
     * 
     * <p>Un-merged Business Name: LicenseNumber</p>
     * 
     * <p>Relationship: COCT_MT090108CA.HealthCareProvider.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p><p>Detailed information about the 
     * status and effective period of licenses must be retrieved 
     * from the provider registry.</p>
     * 
     * <p>The license number issued to the provider and relevant to 
     * the current action.</p>
     */
    @Hl7XmlMapping({"assignedPerson/asHealthCareProvider/id"})
    public Identifier getAssignedPersonAsHealthCareProviderId() {
        return this.assignedPersonAsHealthCareProviderId.getValue();
    }

    /**
     * <p>Business Name: LicenseNumber</p>
     * 
     * <p>Un-merged Business Name: LicenseNumber</p>
     * 
     * <p>Relationship: COCT_MT090108CA.HealthCareProvider.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p><p>Detailed information about the 
     * status and effective period of licenses must be retrieved 
     * from the provider registry.</p>
     * 
     * <p>The license number issued to the provider and relevant to 
     * the current action.</p>
     */
    public void setAssignedPersonAsHealthCareProviderId(Identifier assignedPersonAsHealthCareProviderId) {
        this.assignedPersonAsHealthCareProviderId.setValue(assignedPersonAsHealthCareProviderId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT090108CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT090502CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"representedOrganization"})
    public ResponsibleOrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT090108CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT090502CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRepresentedOrganization(ResponsibleOrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

}
