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

package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "MFMI_MT700716CA.ReplacementOf" })
public class ReplacementOfBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -4042017390746338658L;

    private final II id = new IIImpl();

    private final CD roleClass = new CDImpl(ca.infoway.messagebuilder.domainvalue.payload.RoleClass.ROLE);

    private final BL contextConductionInd = new BLImpl(false);

    @Hl7XmlMapping("priorRegistration/subject/priorRegisteredRole/id")
    public Identifier getId() {
        return this.id.getValue();
    }

    @Hl7XmlMapping("priorRegistration/subject/priorRegisteredRole/classCode")
    public RoleClass getRoleClass() {
        return (RoleClass) this.roleClass.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("contextConductionInd")
    public boolean isContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    public void setContextConductionInd(boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }

    public void setRoleClass(RoleClass roleClass) {
        this.roleClass.setValue(roleClass);
    }
}
