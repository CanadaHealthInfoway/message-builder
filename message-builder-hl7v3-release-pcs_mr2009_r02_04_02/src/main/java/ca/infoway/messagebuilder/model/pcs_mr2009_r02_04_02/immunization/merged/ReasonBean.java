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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.Choice;



/**
 * <p>POIZ_MT030060CA.Reason: (no business name)</p>
 * 
 * <p><p>Information about the reason why an immunization event 
 * did or did not occur.</p></p>
 * 
 * <p><p>Needed for explicit declaration of the reasons behind 
 * a vaccine administration - or why a vaccine was not 
 * administered. This information may not always be known, but 
 * is expected in most circumstances. As a result, this 
 * association is populated.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Reason","POIZ_MT030060CA.Reason","POIZ_MT060150CA.Reason"})
public class ReasonBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private Choice choice;


    @Hl7XmlMapping({"choice"})
    public Choice getChoice() {
        return this.choice;
    }
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public ImmunizationReasonBean getChoiceAsImmunizationReason() {
        return this.choice instanceof ImmunizationReasonBean ? (ImmunizationReasonBean) this.choice : null;
    }
    public boolean hasChoiceAsImmunizationReason() {
        return (this.choice instanceof ImmunizationReasonBean);
    }

    public NoImmunizationReasonBean getChoiceAsNoImmunizationReason() {
        return this.choice instanceof NoImmunizationReasonBean ? (NoImmunizationReasonBean) this.choice : null;
    }
    public boolean hasChoiceAsNoImmunizationReason() {
        return (this.choice instanceof NoImmunizationReasonBean);
    }

}
