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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: PriorRegistrationEvent</p>
 * 
 * <p>MFMI_MT700717CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p>Used to associate (replace) a current registration with a 
 * regsitration already received (supports merges).</p>
 * 
 * <p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p>
 * 
 * <p>MFMI_MT700726CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p>Used to associate (replace) a current registration with a 
 * regsitration already received (supports merges).</p>
 * 
 * <p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p>
 * 
 * <p>MFMI_MT700716CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p>Used to associate (replace) a current registration with a 
 * regsitration already received (supports merges).</p>
 * 
 * <p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p>
 * 
 * <p>MFMI_MT700711CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p>Used to associate (replace) a current registration with a 
 * regsitration already received (supports merges).</p>
 * 
 * <p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p>
 * 
 * <p>MFMI_MT700746CA.PriorRegistration: Prior Registration 
 * Event</p>
 * 
 * <p>Used to associate (replace) a current registration with a 
 * regsitration already received (supports merges).</p>
 * 
 * <p>This class describes the registration of a client, 
 * provider, location, etc. in the past.</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.PriorRegistration","MFMI_MT700716CA.PriorRegistration","MFMI_MT700717CA.PriorRegistration","MFMI_MT700726CA.PriorRegistration","MFMI_MT700746CA.PriorRegistration"})
public class PriorRegistrationEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private PriorRegistrationRoleIdsBean subjectPriorRegisteredRole;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700717CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/priorRegisteredRole"})
    public PriorRegistrationRoleIdsBean getSubjectPriorRegisteredRole() {
        return this.subjectPriorRegisteredRole;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700717CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.Subject5.priorRegisteredRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPriorRegisteredRole(PriorRegistrationRoleIdsBean subjectPriorRegisteredRole) {
        this.subjectPriorRegisteredRole = subjectPriorRegisteredRole;
    }

}
