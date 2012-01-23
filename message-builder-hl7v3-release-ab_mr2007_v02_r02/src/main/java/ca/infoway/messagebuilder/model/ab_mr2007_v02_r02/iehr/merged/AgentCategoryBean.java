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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.iehr.merged;

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

    private static final long serialVersionUID = 20120122L;
    private CV code = new CVImpl();
    private ST name = new STImpl();


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
    public ExposureAgentEntityType getCode() {
        return (ExposureAgentEntityType) this.code.getValue();
    }
    public void setCode(ExposureAgentEntityType code) {
        this.code.setValue(code);
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
     * MaterialKind.code.</p></p>
     * 
     * <p><p>Proivdes a human-readable name in circumstances where 
     * the agent is captured as a code.</p></p>
     * 
     * <p>Exposed Material Name</p>
     * 
     * <p><p>Indicates the name of the agent identified by 
     * MaterialKind.code</p></p>
     * 
     * <p><p>Provides a human-readable name in circumstances where 
     * the agent is captured as a code.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }
    public void setName(String name) {
        this.name.setValue(name);
    }

}
