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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RoleChoice;



/**
 * <p>POLB_MT002000CA.Receiver: (no business name)</p>
 * 
 * <p>Distribution List</p>
 * 
 * <p>POLB_MT004000CA.Receiver: Electronic Receiver</p>
 * 
 * <p>Distribution List</p>
 * 
 * <p>These are the persons or organizations identifed on the 
 * Distribution List.</p>
 * 
 * <p>POLB_MT004100CA.Receiver: (no business name)</p>
 * 
 * <p>Receiver Clone</p>
 * 
 * <p>POLB_MT004200CA.Receiver: Electronic Result Receiver</p>
 * 
 * <p>Identifies the healthcare providers who are to receive 
 * electronic copies of the result via the JLIS.</p>
 */
@Hl7PartTypeMapping({"POLB_MT002000CA.Receiver","POLB_MT004000CA.Receiver","POLB_MT004100CA.Receiver","POLB_MT004200CA.Receiver"})
public class ElectronicResultReceiverBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CS contextControlCode = new CSImpl();
    private RoleChoice roleChoice;


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT002000CA.Receiver.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004000CA.Receiver.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Receiver.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004200CA.Receiver.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT002000CA.Receiver.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004000CA.Receiver.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Receiver.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004200CA.Receiver.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT002000CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004000CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004200CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"roleChoice"})
    public RoleChoice getRoleChoice() {
        return this.roleChoice;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT002000CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004000CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004200CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setRoleChoice(RoleChoice roleChoice) {
        this.roleChoice = roleChoice;
    }

}
