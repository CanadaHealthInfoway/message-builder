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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090108ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareOrganizationRoleType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ActingPersonBean;
import java.util.Set;



/**
 * <p>Business Name: Healthcare Worker</p>
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
 */
@Hl7PartTypeMapping({"COCT_MT090108CA.AssignedEntity"})
@Hl7RootType
public class HealthcareWorkerBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.ChangedBy, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt000012ca.Choice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.Party, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911107ca.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.Recipient {

    private static final long serialVersionUID = 20190730L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private SET<TEL, TelecommunicationAddress> telecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ActingPersonBean assignedPerson;
    private II representedOrganizationId = new IIImpl();
    private ST representedOrganizationName = new STImpl();
    private CV representedOrganizationAssignedOrganizationCode = new CVImpl();
    private SET<TEL, TelecommunicationAddress> representedOrganizationAssignedOrganizationTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>Business Name: A:Healthcare Worker Identifier</p>
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
     * <p>Business Name: B: Healthcare Worker Type</p>
     * 
     * <p>Relationship: COCT_MT090108CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: B: Healthcare Worker Type</p>
     * 
     * <p>Relationship: COCT_MT090108CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the &quot;kind&quot; of healthcare participant, 
     * such as &quot;physician&quot;, &quot;dentist&quot;, 
     * &quot;lab technician&quot;, &quot;receptionist&quot;, 
     * etc.</p>
     */
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: E: Healthcare Worker Phone and Emails</p>
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
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }


    /**
     * <p>Relationship: 
     * COCT_MT090108CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"assignedPerson"})
    public ActingPersonBean getAssignedPerson() {
        return this.assignedPerson;
    }

    /**
     * <p>Relationship: 
     * COCT_MT090108CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAssignedPerson(ActingPersonBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }


    /**
     * <p>Business Name: F: Organization identifier</p>
     * 
     * <p>Relationship: COCT_MT090108CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getRepresentedOrganizationId() {
        return this.representedOrganizationId.getValue();
    }

    /**
     * <p>Business Name: F: Organization identifier</p>
     * 
     * <p>Relationship: COCT_MT090108CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    public void setRepresentedOrganizationId(Identifier representedOrganizationId) {
        this.representedOrganizationId.setValue(representedOrganizationId);
    }


    /**
     * <p>Business Name: H: Organization Name</p>
     * 
     * <p>Relationship: COCT_MT090108CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     */
    @Hl7XmlMapping({"representedOrganization/name"})
    public String getRepresentedOrganizationName() {
        return this.representedOrganizationName.getValue();
    }

    /**
     * <p>Business Name: H: Organization Name</p>
     * 
     * <p>Relationship: COCT_MT090108CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     */
    public void setRepresentedOrganizationName(String representedOrganizationName) {
        this.representedOrganizationName.setValue(representedOrganizationName);
    }


    /**
     * <p>Business Name: G: Organization Type</p>
     * 
     * <p>Relationship: COCT_MT090108CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getRepresentedOrganizationAssignedOrganizationCode() {
        return (HealthcareOrganizationRoleType) this.representedOrganizationAssignedOrganizationCode.getValue();
    }

    /**
     * <p>Business Name: G: Organization Type</p>
     * 
     * <p>Relationship: COCT_MT090108CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     */
    public void setRepresentedOrganizationAssignedOrganizationCode(HealthcareOrganizationRoleType representedOrganizationAssignedOrganizationCode) {
        this.representedOrganizationAssignedOrganizationCode.setValue(representedOrganizationAssignedOrganizationCode);
    }


    /**
     * <p>Business Name: I: Organization Phone and Emails</p>
     * 
     * <p>Relationship: 
     * COCT_MT090108CA.AssignedOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>This is the most commonly used contact information and is 
     * returned to avoid unnecessary queries against the client 
     * registry.</p>
     * 
     * <p>Identifies contact information for the responsible 
     * organization.</p>
     */
    @Hl7XmlMapping({"representedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getRepresentedOrganizationAssignedOrganizationTelecom() {
        return this.representedOrganizationAssignedOrganizationTelecom.rawSet();
    }

}
