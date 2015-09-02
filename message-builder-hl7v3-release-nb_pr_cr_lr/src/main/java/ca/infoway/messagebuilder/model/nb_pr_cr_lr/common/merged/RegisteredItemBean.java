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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: RegisteredItem</p>
 * 
 * <p>MFMI_MT700716NB.Subject4: Registered Item</p>
 * 
 * <p>Defines the content of the registration and is therefore 
 * mandatory.</p>
 * 
 * <p>Commonly called the Payload stub. Any interaction that 
 * uses this ControlAct Wrapper will replace this class with a 
 * Role-based domain Message Type</p>
 * 
 * <p>MFMI_MT700717NB.Subject4: Registered Item</p>
 * 
 * <p>Defines the content of the registration and is therefore 
 * mandatory.</p>
 * 
 * <p>Commonly called the Payload stub. Any interaction that 
 * uses this ControlAct Wrapper will replace this class with a 
 * Role-based domain Message Type</p>
 * 
 * <p>MFMI_MT700746NB.Subject4: Registered Item</p>
 * 
 * <p>Defines the content of the registration and is therefore 
 * mandatory.</p>
 * 
 * <p>Commonly called the Payload stub. Any interaction that 
 * uses this ControlAct Wrapper will replace this class with a 
 * Role-based domain Message Type</p>
 * 
 * <p>MFMI_MT700711NB.Subject4: Registered Item</p>
 * 
 * <p>Defines the content of the registration and is therefore 
 * mandatory.</p>
 * 
 * <p>Commonly called the Payload stub. Any interaction that 
 * uses this ControlAct Wrapper will replace this class with a 
 * Role-based domain Message Type</p>
 * 
 * <p>MFMI_MT700726NB.Subject4: Registered Item</p>
 * 
 * <p>Defines the content of the registration and is therefore 
 * mandatory.</p>
 * 
 * <p>Commonly called the Payload stub. Any interaction that 
 * uses this ControlAct Wrapper will replace this class with a 
 * Role-based domain Message Type</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711NB.Subject4","MFMI_MT700716NB.Subject4","MFMI_MT700717NB.Subject4","MFMI_MT700726NB.Subject4","MFMI_MT700746NB.Subject4"})
public class RegisteredItemBean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private RR registeredRole;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700716NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700717NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700746NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700711NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700726NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"registeredRole"})
    public RR getRegisteredRole() {
        return this.registeredRole;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700716NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700717NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700746NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700711NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700726NB.Subject4.registeredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRegisteredRole(RR registeredRole) {
        this.registeredRole = registeredRole;
    }

}
