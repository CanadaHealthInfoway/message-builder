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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.pome_mt010040on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActMonitoringProtocolCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Monitoring Programs</p>
 * 
 * <p>DrugProduct.triplicate</p>
 * 
 * <p>Prescription.triplicate</p>
 * 
 * <p>Allows association of additional business requirements 
 * with a particular drug</p>
 * 
 * <p>A system of additional business rules, documentation or 
 * reporting associated with a particular drug or group of 
 * drugs. These are typically instituted to detect potential 
 * abuse, or to monitor prescribing and/or dispensing patterns 
 * of a sensitive class of medications. Examples include 
 * triplicate programs, antibiotic monitoring programs, 
 * etc.</p>
 */
@Hl7PartTypeMapping({"POME_MT010040ON.MonitoringProgram"})
public class MonitoringProgramsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private ST custodianAssignedEntityAssignedOrganizationName = new STImpl();


    /**
     * <p>Business Name: Program Type</p>
     * 
     * <p>Relationship: POME_MT010040ON.MonitoringProgram.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DispensedItem.triplicate</p>
     * 
     * <p>Used for classifying and sorting monitoring 
     * programs.</p><p>This is mandatory because, different program 
     * types have different business rules.</p>
     * 
     * <p>A coded value denoting a specific kind of monitoring 
     * program. For example, &quot;Drugs of potential abuse&quot;, 
     * &quot;Antibiotics&quot;, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActMonitoringProtocolCode getCode() {
        return (ActMonitoringProtocolCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Program Type</p>
     * 
     * <p>Relationship: POME_MT010040ON.MonitoringProgram.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DispensedItem.triplicate</p>
     * 
     * <p>Used for classifying and sorting monitoring 
     * programs.</p><p>This is mandatory because, different program 
     * types have different business rules.</p>
     * 
     * <p>A coded value denoting a specific kind of monitoring 
     * program. For example, &quot;Drugs of potential abuse&quot;, 
     * &quot;Antibiotics&quot;, etc.</p>
     */
    public void setCode(ActMonitoringProtocolCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Program Name</p>
     * 
     * <p>Relationship: POME_MT010040ON.MonitoringProgram.title</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a provider-recognizable label for the 
     * program.</p>
     * 
     * <p>A user-friendly label assigned to the monitoring 
     * program.</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Business Name: Program Name</p>
     * 
     * <p>Relationship: POME_MT010040ON.MonitoringProgram.title</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a provider-recognizable label for the 
     * program.</p>
     * 
     * <p>A user-friendly label assigned to the monitoring 
     * program.</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Business Name: Monitoring Organization Name</p>
     * 
     * <p>Relationship: POME_MT010040ON.Organization2.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps identify the program and understand its context. 
     * May also indicate who to send reports to.</p>
     * 
     * <p>The name of the organization responsible for the 
     * monitoring program</p>
     */
    @Hl7XmlMapping({"custodian/assignedEntity/assignedOrganization/name"})
    public String getCustodianAssignedEntityAssignedOrganizationName() {
        return this.custodianAssignedEntityAssignedOrganizationName.getValue();
    }

    /**
     * <p>Business Name: Monitoring Organization Name</p>
     * 
     * <p>Relationship: POME_MT010040ON.Organization2.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps identify the program and understand its context. 
     * May also indicate who to send reports to.</p>
     * 
     * <p>The name of the organization responsible for the 
     * monitoring program</p>
     */
    public void setCustodianAssignedEntityAssignedOrganizationName(String custodianAssignedEntityAssignedOrganizationName) {
        this.custodianAssignedEntityAssignedOrganizationName.setValue(custodianAssignedEntityAssignedOrganizationName);
    }

}
