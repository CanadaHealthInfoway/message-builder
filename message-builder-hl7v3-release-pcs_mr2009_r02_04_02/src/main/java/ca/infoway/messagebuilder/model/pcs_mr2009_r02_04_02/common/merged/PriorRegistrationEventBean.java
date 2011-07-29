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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PriorRegistrationEvent</p>
 * 
 * <p>MFMI_MT700711CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p><p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p></p>
 * 
 * <p><p>Used to associate (replace) a current registration 
 * with a regsitration already received (supports merges).</p></p>
 * 
 * <p>MFMI_MT700717CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p><p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p></p>
 * 
 * <p><p>Used to associate (replace) a current registration 
 * with a regsitration already received (supports merges).</p></p>
 * 
 * <p>MFMI_MT700746CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p><p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p></p>
 * 
 * <p><p>Used to associate (replace) a current registration 
 * with a regsitration already received (supports merges).</p></p>
 * 
 * <p>MFMI_MT700726CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p><p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p></p>
 * 
 * <p><p>Used to associate (replace) a current registration 
 * with a regsitration already received (supports merges).</p></p>
 * 
 * <p>MFMI_MT700716CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p><p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p></p>
 * 
 * <p><p>Used to associate (replace) a current registration 
 * with a regsitration already received (supports merges).</p></p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.PriorRegistration","MFMI_MT700716CA.PriorRegistration","MFMI_MT700717CA.PriorRegistration","MFMI_MT700726CA.PriorRegistration","MFMI_MT700746CA.PriorRegistration"})
public class PriorRegistrationEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private II priorRegisteredRoleIds = new IIImpl();


    /**
     * <p>PriorRegisteredRoleIds</p>
     * 
     * <p>Prior Registered Role Ids</p>
     * 
     * <p><p>Identifies &quot;duplicate&quot; records of the 
     * registered item that have been superseded by this 
     * record.</p></p>
     * 
     * <p><p>Provides support for merges.</p></p>
     */
    @Hl7XmlMapping({"subject/priorRegisteredRole/id"})
    public Identifier getPriorRegisteredRoleIds() {
        return this.priorRegisteredRoleIds.getValue();
    }
    public void setPriorRegisteredRoleIds(Identifier priorRegisteredRoleIds) {
        this.priorRegisteredRoleIds.setValue(priorRegisteredRoleIds);
    }

}
