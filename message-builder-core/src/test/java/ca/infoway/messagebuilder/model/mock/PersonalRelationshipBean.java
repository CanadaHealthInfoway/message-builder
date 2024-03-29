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

package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PRPA_MT101102CA.PersonalRelationship", "PRPA_MT101001CA.PersonalRelationship", "PRPA_MT101002CA.PersonalRelationship" })
public class PersonalRelationshipBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -42113751918781255L;

    private CD roleType = new CDImpl();

    private II id = new IIImpl();

    private PN name = new PNImpl();

    @Hl7XmlMapping("code")
    public PersonalRelationshipRoleType getRoleType() {
        return (PersonalRelationshipRoleType) this.roleType.getValue();
    }

    public void setRoleType(PersonalRelationshipRoleType roleType) {
        this.roleType.setValue(roleType);
    }

    @Hl7XmlMapping("relationshipHolder/id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("relationshipHolder/name")
    public PersonName getName() {
        return this.name.getValue();
    }

    public void setName(PersonName name) {
        this.name.setValue(name);
    }
}
