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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POME_MT010040CA.AssignedEntity1","POME_MT010040CA.AssignedEntity2","POME_MT010040CA.AssignedEntity3","PORR_MT050016CA.AssignedEntity"})
public class AssignedEntity3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private ST assignedOrganizationName = new STImpl();


    /**
     * <p>Formulary Owner Name</p>
     * 
     * <p><p>The name of the organization or facility responsible 
     * for the formulary.</p></p>
     * 
     * <p><p>Helps identify the circumstances in which the 
     * formulary applies.</p></p>
     * 
     * <p>D:Medication Document Author Name</p>
     * 
     * <p><p>The name of the organization responsible for creating 
     * the medication document.</p></p>
     * 
     * <p><p>Helps the receiver evaluate the supplied 
     * information.</p></p>
     * 
     * <p>Monograph Author Name</p>
     * 
     * <p><p>The name of the organization responsible for creating 
     * the monograph</p></p>
     * 
     * <p><p>Helps the receiver evaluate the supplied 
     * information.</p></p>
     * 
     * <p>Monitoring Organization Name</p>
     * 
     * <p><p>The name of the organization responsible for the 
     * monitoring program</p></p>
     * 
     * <p><p>Helps identify the program and understand its context. 
     * May also indicate who to send reports to.</p></p>
     */
    @Hl7XmlMapping({"assignedOrganization/name","representedOrganization/name"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization1"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization2"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization3"),
        @Hl7MapByPartType(name="representedOrganization", type="PORR_MT050016CA.Organization4")})
    public String getAssignedOrganizationName() {
        return this.assignedOrganizationName.getValue();
    }
    public void setAssignedOrganizationName(String assignedOrganizationName) {
        this.assignedOrganizationName.setValue(assignedOrganizationName);
    }

}
