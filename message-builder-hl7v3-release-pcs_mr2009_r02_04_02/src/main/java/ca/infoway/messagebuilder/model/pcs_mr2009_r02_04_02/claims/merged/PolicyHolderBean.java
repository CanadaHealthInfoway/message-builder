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

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.PolicyHolder","FICR_MT400003CA.PolicyHolder","FICR_MT400004CA.PolicyHolder","FICR_MT490102CA.PolicyHolder"})
public class PolicyHolderBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private II policyHolderIdentifier = new IIImpl();
    private PolicyHolderChoice policyHolderChoice;


    /**
     * <p>PolicyHolderIdentifier</p>
     * 
     * <p>Policy Holder Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPolicyHolderIdentifier() {
        return this.policyHolderIdentifier.getValue();
    }
    public void setPolicyHolderIdentifier(Identifier policyHolderIdentifier) {
        this.policyHolderIdentifier.setValue(policyHolderIdentifier);
    }


    @Hl7XmlMapping({"policyHolderChoice"})
    public PolicyHolderChoice getPolicyHolderChoice() {
        return this.policyHolderChoice;
    }
    public void setPolicyHolderChoice(PolicyHolderChoice policyHolderChoice) {
        this.policyHolderChoice = policyHolderChoice;
    }

}
