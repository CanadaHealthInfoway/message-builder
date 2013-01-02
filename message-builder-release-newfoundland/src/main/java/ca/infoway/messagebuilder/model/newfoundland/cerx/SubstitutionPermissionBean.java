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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionNotAllowedReason;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT060160CA.SubstitutionPermission", "PORX_MT010120CA.SubstitutionPermission" })
public class SubstitutionPermissionBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 934660061096631377L;

    private CD code = new CDImpl();

    private CD reasonCode = new CDImpl();

    private BL negationInd = new BLImpl(false);

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("reasonCode")
    public SubstanceAdminSubstitutionNotAllowedReason getReasonCode() {
        return (SubstanceAdminSubstitutionNotAllowedReason) this.reasonCode.getValue();
    }

    public void setReasonCode(SubstanceAdminSubstitutionNotAllowedReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

    @Hl7XmlMapping("negationInd")
    public boolean isNegationInd() {
        return this.negationInd.getValue();
    }

    public void setNegationInd(boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }
}
