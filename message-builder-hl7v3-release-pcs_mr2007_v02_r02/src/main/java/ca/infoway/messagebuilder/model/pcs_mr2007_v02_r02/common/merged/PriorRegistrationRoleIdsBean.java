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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: PriorRegistrationRoleIds</p>
 * 
 * <p>MFMI_MT700716CA.PriorRegisteredRole: Prior Registration 
 * Role Ids</p>
 * 
 * <p>Provides support for merges.</p>
 * 
 * <p>Identifies &quot;duplicate&quot; records of the 
 * registered item that have been superseded by this 
 * record.</p>
 * 
 * <p>MFMI_MT700711CA.PriorRegisteredRole: Prior Registration 
 * Role Ids</p>
 * 
 * <p>Provides support for merges.</p>
 * 
 * <p>Identifies &quot;duplicate&quot; records of the 
 * registered item that have been superseded by this 
 * record.</p>
 * 
 * <p>MFMI_MT700746CA.PriorRegisteredRole: Prior Registration 
 * Role Ids</p>
 * 
 * <p>Provides support for merges.</p>
 * 
 * <p>Identifies &quot;duplicate&quot; records of the 
 * registered item that have been superseded by this 
 * record.</p>
 * 
 * <p>MFMI_MT700726CA.PriorRegisteredRole: Prior Registration 
 * Role Ids</p>
 * 
 * <p>Provides support for merges.</p>
 * 
 * <p>Identifies &quot;duplicate&quot; records of the 
 * registered item that have been superseded by this 
 * record.</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.PriorRegisteredRole","MFMI_MT700716CA.PriorRegisteredRole","MFMI_MT700726CA.PriorRegisteredRole","MFMI_MT700746CA.PriorRegisteredRole"})
public class PriorRegistrationRoleIdsBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private CS classCode = new CSImpl();
    private II id = new IIImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.PriorRegisteredRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.PriorRegisteredRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.PriorRegisteredRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.PriorRegisteredRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public RoleClass getClassCode() {
        return (RoleClass) this.classCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.PriorRegisteredRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.PriorRegisteredRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.PriorRegisteredRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.PriorRegisteredRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setClassCode(RoleClass classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Un-merged Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Relationship: MFMI_MT700716CA.PriorRegisteredRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for merges.</p>
     * 
     * <p>Identifies &quot;duplicate&quot; records of the 
     * registered item that have been superseded by this 
     * record.</p>
     * 
     * <p>Un-merged Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Relationship: MFMI_MT700711CA.PriorRegisteredRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for merges.</p>
     * 
     * <p>Identifies &quot;duplicate&quot; records of the 
     * registered item that have been superseded by this 
     * record.</p>
     * 
     * <p>Un-merged Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.PriorRegisteredRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for merges.</p>
     * 
     * <p>Identifies &quot;duplicate&quot; records of the 
     * registered item that have been superseded by this 
     * record.</p>
     * 
     * <p>Un-merged Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Relationship: MFMI_MT700726CA.PriorRegisteredRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for merges.</p>
     * 
     * <p>Identifies &quot;duplicate&quot; records of the 
     * registered item that have been superseded by this 
     * record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Un-merged Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Relationship: MFMI_MT700716CA.PriorRegisteredRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for merges.</p>
     * 
     * <p>Identifies &quot;duplicate&quot; records of the 
     * registered item that have been superseded by this 
     * record.</p>
     * 
     * <p>Un-merged Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Relationship: MFMI_MT700711CA.PriorRegisteredRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for merges.</p>
     * 
     * <p>Identifies &quot;duplicate&quot; records of the 
     * registered item that have been superseded by this 
     * record.</p>
     * 
     * <p>Un-merged Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.PriorRegisteredRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for merges.</p>
     * 
     * <p>Identifies &quot;duplicate&quot; records of the 
     * registered item that have been superseded by this 
     * record.</p>
     * 
     * <p>Un-merged Business Name: PriorRegisteredRoleIds</p>
     * 
     * <p>Relationship: MFMI_MT700726CA.PriorRegisteredRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for merges.</p>
     * 
     * <p>Identifies &quot;duplicate&quot; records of the 
     * registered item that have been superseded by this 
     * record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
