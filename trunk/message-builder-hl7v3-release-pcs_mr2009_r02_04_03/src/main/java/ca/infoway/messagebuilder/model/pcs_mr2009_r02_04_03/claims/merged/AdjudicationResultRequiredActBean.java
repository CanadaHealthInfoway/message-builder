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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt510201ca.FormRoleBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActAdjudicationResultActionType;



/**
 * <p>FICR_MT510201CA.AdjudicationResultRequiredAct: (no 
 * business name)</p>
 * 
 * <p>Id allows for consolidating identical required acts on 1 
 * form</p>
 * 
 * <p>FICR_MT610201CA.AdjudicationResultRequiredAct: (no 
 * business name)</p>
 * 
 * <p>Id allows for consolidating identical required acts on 1 
 * form</p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicationResultRequiredAct","FICR_MT610201CA.AdjudicationResultRequiredAct"})
public class AdjudicationResultRequiredActBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private FormRoleBean directTargetFormRole;


    /**
     * <p>RequiredActionType</p>
     * 
     * <p>Required Action Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActAdjudicationResultActionType getCode() {
        return (ActAdjudicationResultActionType) this.code.getValue();
    }

    /**
     * <p>RequiredActionType</p>
     * 
     * <p>Required Action Type</p>
     */
    public void setCode(ActAdjudicationResultActionType code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"directTarget/formRole"})
    public FormRoleBean getDirectTargetFormRole() {
        return this.directTargetFormRole;
    }

    public void setDirectTargetFormRole(FormRoleBean directTargetFormRole) {
        this.directTargetFormRole = directTargetFormRole;
    }

}
