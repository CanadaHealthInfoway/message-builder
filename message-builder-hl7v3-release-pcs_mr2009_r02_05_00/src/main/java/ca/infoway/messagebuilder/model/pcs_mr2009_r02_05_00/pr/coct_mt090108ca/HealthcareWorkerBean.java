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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pr.coct_mt090108ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.ActingPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.ResponsibleOrganizationBean;
import java.util.List;



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
public class HealthcareWorkerBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt911108ca.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.Party, ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt000012ca.Choice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.Recipient, ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pharmacy.merged.ChangedBy, ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt911107ca.ActingPerson {

    private static final long serialVersionUID = 20190731L;
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ActingPersonBean assignedPerson;
    private ResponsibleOrganizationBean representedOrganization;


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
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Business Name: B: Healthcare Worker Type</p>
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
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: B: Healthcare Worker Type</p>
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
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
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
     * <p>Relationship: 
     * COCT_MT090108CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"representedOrganization"})
    public ResponsibleOrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }

    /**
     * <p>Relationship: 
     * COCT_MT090108CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setRepresentedOrganization(ResponsibleOrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

}
