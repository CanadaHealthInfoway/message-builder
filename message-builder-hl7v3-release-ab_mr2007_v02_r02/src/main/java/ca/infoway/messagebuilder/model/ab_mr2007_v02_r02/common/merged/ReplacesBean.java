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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Replaces</p>
 * 
 * <p>MFMI_MT700726CA.ReplacementOf: replaces</p>
 * 
 * <p>Associates a new registration which is intended to 
 * replace a registration received prior to this message.</p>
 * 
 * <p>Supports this message &quot;replacing&quot; a prior 
 * registration with a current regsitration (merges).</p>
 * 
 * <p>MFMI_MT700716CA.ReplacementOf: replaces</p>
 * 
 * <p>Associates a new registration which is intended to 
 * replace a registration received prior to this message.</p>
 * 
 * <p>Supports this message &quot;replacing&quot; a prior 
 * registration with a current regsitration (merges).</p>
 * 
 * <p>MFMI_MT700746CA.ReplacementOf: replaces</p>
 * 
 * <p>Associates a new registration which is intended to 
 * replace a registration received prior to this message.</p>
 * 
 * <p>Supports this message &quot;replacing&quot; a prior 
 * registration with a current regsitration (merges).</p>
 * 
 * <p>MFMI_MT700711CA.ReplacementOf: replaces</p>
 * 
 * <p>Associates a new registration which is intended to 
 * replace a registration received prior to this message.</p>
 * 
 * <p>Supports this message &quot;replacing&quot; a prior 
 * registration with a current regsitration (merges).</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.ReplacementOf","MFMI_MT700716CA.ReplacementOf","MFMI_MT700726CA.ReplacementOf","MFMI_MT700746CA.ReplacementOf"})
public class ReplacesBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private BL contextConductionInd = new BLImpl();
    private PriorRegistrationEventBean priorRegistration;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.ReplacementOf.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.ReplacementOf.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.ReplacementOf.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.ReplacementOf.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.ReplacementOf.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.ReplacementOf.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.ReplacementOf.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.ReplacementOf.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"priorRegistration"})
    public PriorRegistrationEventBean getPriorRegistration() {
        return this.priorRegistration;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPriorRegistration(PriorRegistrationEventBean priorRegistration) {
        this.priorRegistration = priorRegistration;
    }

}
