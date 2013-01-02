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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCAI_MT700210CA.Subject2","MCAI_MT700211CA.Subject2","MCAI_MT700212CA.Subject2","MCAI_MT700216CA.Subject2","MCAI_MT700217CA.Subject2","MCAI_MT700218CA.Subject2","MCAI_MT700220CA.Subject2","MCAI_MT700221CA.Subject2","MCAI_MT700222CA.Subject2","MCAI_MT700226CA.Subject2","MCAI_MT700227CA.Subject2","QUQI_MT120006CA.Subject2","QUQI_MT120008CA.Subject2"})
public class Subject2_1Bean<ACT> extends MessagePartBean {

    private BL cascadeResponsibilityIndicator = new BLImpl();
    private ACT act;

    @Hl7XmlMapping({"contextConductionInd"})
    public java.lang.Boolean getCascadeResponsibilityIndicator() {
        return this.cascadeResponsibilityIndicator.getValue();
    }
    public void setCascadeResponsibilityIndicator(java.lang.Boolean cascadeResponsibilityIndicator) {
        this.cascadeResponsibilityIndicator.setValue(cascadeResponsibilityIndicator);
    }

    @Hl7XmlMapping({"act"})
    public ACT getAct() {
        return this.act;
    }
    public void setAct(ACT act) {
        this.act = act;
    }

}
