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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>RegisteredItem</p>
 * 
 * <p>MFMI_MT700746CA.Subject4: Registered Item</p>
 * 
 * <p><p>Commonly called the Payload stub. Any interaction that 
 * uses this ControlAct Wrapper will replace this class with a 
 * Role-based domain Message Type</p></p>
 * 
 * <p><p>Defines the content of the registration and is 
 * therefore mandatory.</p></p>
 * 
 * <p>MFMI_MT700711CA.Subject4: Registered Item</p>
 * 
 * <p><p>Commonly called the Payload stub. Any interaction that 
 * uses this ControlAct Wrapper will replace this class with a 
 * Role-based domain Message Type</p></p>
 * 
 * <p><p>Defines the content of the registration and is 
 * therefore mandatory.</p></p>
 * 
 * <p>MFMI_MT700726CA.Subject4: Registered Item</p>
 * 
 * <p><p>Commonly called the Payload stub. Any interaction that 
 * uses this ControlAct Wrapper will replace this class with a 
 * Role-based domain Message Type</p></p>
 * 
 * <p><p>Defines the content of the registration and is 
 * therefore mandatory.</p></p>
 * 
 * <p>MFMI_MT700716CA.Subject4: Registered Item</p>
 * 
 * <p><p>Commonly called the Payload stub. Any interaction that 
 * uses this ControlAct Wrapper will replace this class with a 
 * Role-based domain Message Type</p></p>
 * 
 * <p><p>Defines the content of the registration and is 
 * therefore mandatory.</p></p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.Subject4","MFMI_MT700716CA.Subject4","MFMI_MT700726CA.Subject4","MFMI_MT700746CA.Subject4"})
public class RegisteredItemBean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20120116L;
    private CS typeCode = new CSImpl();
    private CS contextControlCode = new CSImpl();
    private RR registeredRole;


    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return (ParticipationType) this.typeCode.getValue();
    }
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    @Hl7XmlMapping({"registeredRole"})
    public RR getRegisteredRole() {
        return this.registeredRole;
    }
    public void setRegisteredRole(RR registeredRole) {
        this.registeredRole = registeredRole;
    }

}
