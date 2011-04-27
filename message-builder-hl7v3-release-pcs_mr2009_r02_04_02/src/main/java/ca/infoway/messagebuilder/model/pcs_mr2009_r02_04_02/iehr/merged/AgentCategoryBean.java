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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>AgentCategory</p>
 * 
 * <p>REPC_MT000006CA.MaterialKind: Agent Category</p>
 * 
 * <p><p>Category of material or agent to which the patient was 
 * exposed.</p></p>
 * 
 * <p><p>Allows exposed materials or agents to be collectively 
 * referenced.</p></p>
 * 
 * <p>REPC_MT000012CA.MaterialKind: Agent Category</p>
 * 
 * <p><p>Category of material or agent to which the patient was 
 * exposed.</p></p>
 * 
 * <p><p>Allows exposed materials or agents to be collectively 
 * referenced.</p></p>
 * 
 * <p>REPC_MT000002CA.MaterialKind: Agent Category</p>
 * 
 * <p><p>Category of material or agent to which the patient was 
 * exposed.</p></p>
 * 
 * <p><p>Allows exposed materials or agents to be collectively 
 * referenced.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000002CA.MaterialKind","REPC_MT000006CA.MaterialKind","REPC_MT000012CA.MaterialKind"})
public class AgentCategoryBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV exposedMaterialType = new CVImpl();
    private ST exposedMaterialName = new STImpl();


    /**
     * <p>ExposedMaterialType</p>
     * 
     * <p>A:Exposed Material Type</p>
     * 
     * <p><p>Indicates the type of agent that the patient was 
     * exposed to which caused the adverse reaction. This includes 
     * Drug, Food, Latex, Dust, etc.</p></p>
     * 
     * <p><p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p></p>
     * 
     * <p>A:Exposed Material Type</p>
     * 
     * <p><p>Indicates the type of agent that the patient was 
     * exposed to which caused the adverse reaction. This includes 
     * Drug, Food, Latex, Dust, etc.</p></p>
     * 
     * <p><p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be coded. 
     * Also, the code may sometimes be masked, in which case a 
     * &quot;null flavor&quot; must be specified.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ExposureAgentEntityType getExposedMaterialType() {
        return (ExposureAgentEntityType) this.exposedMaterialType.getValue();
    }
    public void setExposedMaterialType(ExposureAgentEntityType exposedMaterialType) {
        this.exposedMaterialType.setValue(exposedMaterialType);
    }


    /**
     * <p>ExposedMaterialName</p>
     * 
     * <p>Exposed Material Name</p>
     * 
     * <p><p>Indicates the name of the agent identified by 
     * MaterialKind.code</p></p>
     * 
     * <p><p>Provides a human-readable name in circumstances where 
     * the agent is captured as code.</p></p>
     * 
     * <p>Exposed Material Name</p>
     * 
     * <p><p>Indicates the name of the agent identified by 
     * MaterialKind.code</p></p>
     * 
     * <p><p>Provides a human-readable name in circumstances where 
     * the agent is captured as a code.</p></p>
     * 
     * <p>Exposed Material Name</p>
     * 
     * <p><p>Indicates the name of the agent identified by 
     * MaterialKind.code.</p></p>
     * 
     * <p><p>Provides a human-readable name in circumstances where 
     * the agent is captured as a code.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getExposedMaterialName() {
        return this.exposedMaterialName.getValue();
    }
    public void setExposedMaterialName(String exposedMaterialName) {
        this.exposedMaterialName.setValue(exposedMaterialName);
    }

}
