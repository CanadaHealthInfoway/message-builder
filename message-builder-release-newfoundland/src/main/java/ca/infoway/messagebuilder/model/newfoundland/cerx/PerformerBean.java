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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiablePractitioner;

/**
 * <p>The person who performed a particular service.</p>
 * 
 * <p>This type is currently only used in the context of professional services.</p>
 * 
 * @author administrator
 */
@Hl7PartTypeMapping("REPC_MT100001CA.Performer")
public class PerformerBean extends MessagePartBean implements Serializable, IdentifiablePractitioner {

    private static final long serialVersionUID = -8064569252221532979L;

    private AssignedPersonBean assignedPerson = new AssignedPersonBean();

    @Hl7XmlMapping("assignedPerson")
    public AssignedPersonBean getAssignedPerson() {
        return this.assignedPerson;
    }

    public void setAssignedPerson(AssignedPersonBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

    public Identifier getLicenseNumber() {
        return this.assignedPerson.getLicenseNumber();
    }

    public PersonName getName() {
        return this.assignedPerson.getName();
    }

    public Identifier getId() {
        return this.assignedPerson.getId();
    }
}
