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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
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
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AssignedRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ActingPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ResponsibleOrganizationBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>COCT_MT090108CA.AssignedEntity: Healthcare Worker</p>
 * 
 * <p><p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p></p>
 * 
 * <p><p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p></p>
 * 
 * <p><p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p></p>
 * 
 * <p>COCT_MT090502CA.AssignedEntity: Healthcare Organization</p>
 * 
 * <p><p>The organization under whose authority the associated 
 * action (linked by a participation) was performed.</p></p>
 * 
 * <p><p>Critical to tracking responsibility and performing 
 * follow-up.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT090108CA.AssignedEntity","COCT_MT090502CA.AssignedEntity"})
@Hl7RootType
public class HealthcareWorkerBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.Party, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt080100ca.PerformerChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.RecipientChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Choice, ActingPerson, AuthorPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Recipient, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.RoleChoice, EntererChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt011001ca.Assignees, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged.ChangedBy {

    private static final long serialVersionUID = 20120106L;
    private List<II> id = new ArrayList<II>();
    private CV code = new CVImpl();
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ActingPersonBean assignedPerson;
    private ResponsibleOrganizationBean representedOrganization;


    /**
     * <p>HealthcareWorkerIdentifier</p>
     * 
     * <p>A:Healthcare Worker Identifier</p>
     * 
     * <p><p>Unique identifier the person involved in the 
     * action.</p></p>
     * 
     * <p><p>Allows unique identification of the person which can 
     * be critical for authentication, permissions, drill-down and 
     * traceability and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return new RawListWrapper<II, Identifier>(id, IIImpl.class);
    }


    /**
     * <p>HealthcareWorkerType</p>
     * 
     * <p>B: Healthcare Worker Type</p>
     * 
     * <p><p>Indicates the &quot;kind&quot; of healthcare 
     * participant, such as &quot;physician&quot;, 
     * &quot;dentist&quot;, &quot;lab technician&quot;, 
     * &quot;receptionist&quot;, etc.</p></p>
     * 
     * <p><p>Provides context around the actions of the participant 
     * and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public AssignedRoleType getCode() {
        return (AssignedRoleType) this.code.getValue();
    }
    public void setCode(AssignedRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>HealthcareWorkerPhoneAndEmails</p>
     * 
     * <p>E: Healthcare Worker Phone and Emails</p>
     * 
     * <p><p>Indicates phone and/or e-mail addresses at which the 
     * healthcare worker can be reached.</p></p>
     * 
     * <p><p>This is the most commonly used piece of contact 
     * information and is returned here to avoid unnecessary 
     * queries of the provider registry.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    @Hl7XmlMapping({"assignedPerson"})
    public ActingPersonBean getAssignedPerson() {
        return this.assignedPerson;
    }
    public void setAssignedPerson(ActingPersonBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }


    @Hl7XmlMapping({"representedOrganization"})
    public ResponsibleOrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }
    public void setRepresentedOrganization(ResponsibleOrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

}
