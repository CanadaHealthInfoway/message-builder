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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.RecipientChoice;



@Hl7PartTypeMapping({"POLB_MT004000CA.PrimaryInformationRecipient"})
public class PrimaryInformationRecipientBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CS contextControlCode = new CSImpl();
    private RecipientChoice recipientChoice;


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PrimaryInformationRecipient.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }

    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PrimaryInformationRecipient.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    @Hl7XmlMapping({"recipientChoice"})
    public RecipientChoice getRecipientChoice() {
        return this.recipientChoice;
    }

    public void setRecipientChoice(RecipientChoice recipientChoice) {
        this.recipientChoice = recipientChoice;
    }

    public HealthcareOrganizationBean getRecipientChoiceAsAssignedEntity1() {
        return this.recipientChoice instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.recipientChoice : null;
    }
    public boolean hasRecipientChoiceAsAssignedEntity1() {
        return (this.recipientChoice instanceof HealthcareOrganizationBean);
    }

    public HealthcareWorkerBean getRecipientChoiceAsAssignedEntity2() {
        return this.recipientChoice instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.recipientChoice : null;
    }
    public boolean hasRecipientChoiceAsAssignedEntity2() {
        return (this.recipientChoice instanceof HealthcareWorkerBean);
    }

}
