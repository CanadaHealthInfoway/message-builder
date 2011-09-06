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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RoleChoice;



/**
 * <p>POLB_MT004100CA.Performer: Culture Performer Person</p>
 * 
 * <p><p>Performer Clone</p></p>
 * 
 * <p>POLB_MT004200CA.Performer: was performed by</p>
 * 
 * <p><p>Associates the report with the entity(ies) that 
 * performed or conducted (the observations) which make up the 
 * focal report.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.Performer","POLB_MT004200CA.Performer"})
public class WasPerformedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private RoleChoice roleChoice;


    @Hl7XmlMapping({"roleChoice"})
    public RoleChoice getRoleChoice() {
        return this.roleChoice;
    }
    public void setRoleChoice(RoleChoice roleChoice) {
        this.roleChoice = roleChoice;
    }

}
