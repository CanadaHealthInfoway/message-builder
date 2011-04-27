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

package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.OtherIdentifierRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PRPA_MT101102CA.OtherIDs", "PRPA_MT101001CA.OtherIDs", "PRPA_MT101002CA.OtherIDs" })
public class OtherIdentifiersBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 3230221453725587616L;

    private final SET<II, Identifier> ids = new SETImpl<II, Identifier>(IIImpl.class);

    private final CD code = new CDImpl();

    private final II organizationId = new IIImpl();

    private final ST organizationName = new STImpl();

    @Hl7XmlMapping({ "id" })
    public Set<Identifier> getIds() {
        return this.ids.rawSet();
    }

    public Identifier getId() {
        return this.getIds().isEmpty() ? null : this.getIds().iterator().next();
    }

    @Hl7XmlMapping({ "code" })
    public OtherIdentifierRoleType getCode() {
        return (OtherIdentifierRoleType) this.code.getValue();
    }

    public void setCode(OtherIdentifierRoleType code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping({ "scopingIdOrganization/id", "assigningIdOrganization/id" })
    public Identifier getOrganizationId() {
        return this.organizationId.getValue();
    }

    public void setOrganizationId(Identifier organizationId) {
        this.organizationId.setValue(organizationId);
    }

    @Hl7XmlMapping({ "scopingIdOrganization/name", "assigningIdOrganization/name" })
    public String getOrganizationName() {
        return this.organizationName.getValue();
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName.setValue(organizationName);
    }
}
