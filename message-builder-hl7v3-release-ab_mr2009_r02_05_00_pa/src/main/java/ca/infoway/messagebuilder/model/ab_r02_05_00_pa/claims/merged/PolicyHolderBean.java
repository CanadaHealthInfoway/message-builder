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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.PolicyHolder","FICR_MT400003CA.PolicyHolder","FICR_MT400004CA.PolicyHolder","FICR_MT490102CA.PolicyHolder"})
public class PolicyHolderBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private II id = new IIImpl();
    private PolicyHolderChoice policyHolderChoice;


    /**
     * <p>Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Un-merged Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490102CA.PolicyHolder.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400003CA.PolicyHolder.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400004CA.PolicyHolder.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400001CA.PolicyHolder.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Un-merged Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490102CA.PolicyHolder.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400003CA.PolicyHolder.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400004CA.PolicyHolder.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyHolderIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400001CA.PolicyHolder.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.PolicyHolder.policyHolderChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.PolicyHolder.policyHolderChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.PolicyHolder.policyHolderChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.PolicyHolder.policyHolderChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"policyHolderChoice"})
    public PolicyHolderChoice getPolicyHolderChoice() {
        return this.policyHolderChoice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.PolicyHolder.policyHolderChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.PolicyHolder.policyHolderChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.PolicyHolder.policyHolderChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.PolicyHolder.policyHolderChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPolicyHolderChoice(PolicyHolderChoice policyHolderChoice) {
        this.policyHolderChoice = policyHolderChoice;
    }

}