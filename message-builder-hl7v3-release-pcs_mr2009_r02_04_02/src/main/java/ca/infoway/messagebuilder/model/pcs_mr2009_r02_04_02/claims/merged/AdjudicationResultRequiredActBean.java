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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca.FormRoleBean;



/**
 * <p>FICR_MT510201CA.AdjudicationResultRequiredAct: (no 
 * business name)</p>
 * 
 * <p><p>Id allows for consolidating identical required acts on 
 * 1 form</p></p>
 * 
 * <p>FICR_MT610201CA.AdjudicationResultRequiredAct: (no 
 * business name)</p>
 * 
 * <p><p>Id allows for consolidating identical required acts on 
 * 1 form</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicationResultRequiredAct","FICR_MT610201CA.AdjudicationResultRequiredAct"})
public class AdjudicationResultRequiredActBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private CV requiredActionType = new CVImpl();
    private FormRoleBean directTargetFormRole;


    /**
     * <p>RequiredActionType</p>
     * 
     * <p>Required Action Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getRequiredActionType() {
        return (Code) this.requiredActionType.getValue();
    }
    public void setRequiredActionType(Code requiredActionType) {
        this.requiredActionType.setValue(requiredActionType);
    }


    @Hl7XmlMapping({"directTarget/formRole"})
    public FormRoleBean getDirectTargetFormRole() {
        return this.directTargetFormRole;
    }
    public void setDirectTargetFormRole(FormRoleBean directTargetFormRole) {
        this.directTargetFormRole = directTargetFormRole;
    }

}
