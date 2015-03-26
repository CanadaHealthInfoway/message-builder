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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: AgentCategory</p>
 * 
 * <p>REPC_MT000012ON.MaterialKind: Agent Category</p>
 * 
 * <p>Allows exposed materials or agents to be collectively 
 * referenced.</p>
 * 
 * <p>Category of material or agent to which the patient was 
 * exposed.</p>
 * 
 * <p>REPC_MT000005ON.MaterialKind: Agent Category</p>
 * 
 * <p>Allows exposed materials or agents to be collectively 
 * referenced.</p>
 * 
 * <p>Category of material or agent to which the patient was 
 * exposed.</p>
 * 
 * <p>REPC_MT000013ON.MaterialKind: Agent Category</p>
 * 
 * <p>Allows exposed materials or agents to be collectively 
 * referenced.</p>
 * 
 * <p>Category of material or agent to which the patient was 
 * exposed.</p>
 * 
 * <p>REPC_MT000006ON.MaterialKind: Agent Category</p>
 * 
 * <p>Allows exposed materials or agents to be collectively 
 * referenced.</p>
 * 
 * <p>Category of material or agent to which the patient was 
 * exposed.</p>
 * 
 * <p>REPC_MT000002ON.MaterialKind: Agent Category</p>
 * 
 * <p>Allows exposed materials or agents to be collectively 
 * referenced.</p>
 * 
 * <p>Category of material or agent to which the patient was 
 * exposed.</p>
 * 
 * <p>REPC_MT000001ON.MaterialKind: Agent Category</p>
 * 
 * <p>Allows exposed materials or agents to be collectively 
 * referenced.</p>
 * 
 * <p>Category of material or agent to which the patient was 
 * exposed.</p>
 * 
 * <p>REPC_MT000009ON.MaterialKind: Agent Category</p>
 * 
 * <p>Allows exposed materials or agents to be collectively 
 * referenced.</p>
 * 
 * <p>Category of material or agent to which the patient was 
 * exposed.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000001ON.MaterialKind","REPC_MT000002ON.MaterialKind","REPC_MT000005ON.MaterialKind","REPC_MT000006ON.MaterialKind","REPC_MT000009ON.MaterialKind","REPC_MT000012ON.MaterialKind","REPC_MT000013ON.MaterialKind"})
public class AgentCategoryBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private ST name = new STImpl();


    /**
     * <p>Business Name: ExposedMaterialType</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000005ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000012ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000013ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000006ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000001ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be coded. 
     * Also, the code may sometimes be masked, in which case a 
     * &quot;null flavor&quot; must be specified.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000002ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be coded. 
     * Also, the code may sometimes be masked, in which case a 
     * &quot;null flavor&quot; must be specified.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000009ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ExposureAgentEntityType getCode() {
        return (ExposureAgentEntityType) this.code.getValue();
    }

    /**
     * <p>Business Name: ExposedMaterialType</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000005ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000012ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000013ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000006ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000001ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be coded. 
     * Also, the code may sometimes be masked, in which case a 
     * &quot;null flavor&quot; must be specified.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000002ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be coded. 
     * Also, the code may sometimes be masked, in which case a 
     * &quot;null flavor&quot; must be specified.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialType</p>
     * 
     * <p>Relationship: REPC_MT000009ON.MaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows different kinds of reaction agents to be 
     * distinguished. Coding strength is set to CWE because the 
     * exposure agent type may not always be codified. The 
     * attribute is populated because there is little point in 
     * communicating about the exposure to an agent if it is not 
     * known what the agent is, however it may not always be 
     * coded.</p>
     * 
     * <p>Indicates the type of agent that the patient was exposed 
     * to which caused the adverse reaction. This includes Drug, 
     * Food, Latex, Dust, etc.</p>
     */
    public void setCode(ExposureAgentEntityType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ExposedMaterialName</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialName</p>
     * 
     * <p>Relationship: REPC_MT000012ON.MaterialKind.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a human-readable name in circumstances where the 
     * agent is captured as code.</p>
     * 
     * <p>Indicates the name of the agent identified by 
     * MaterialKind.code</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialName</p>
     * 
     * <p>Relationship: REPC_MT000006ON.MaterialKind.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a human-readable name in circumstances where the 
     * agent is captured as code.</p>
     * 
     * <p>Indicates the name of the agent identified by 
     * MaterialKind.code</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialName</p>
     * 
     * <p>Relationship: REPC_MT000002ON.MaterialKind.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a human-readable name in circumstances where the 
     * agent is captured as code.</p>
     * 
     * <p>Indicates the name of the agent identified by 
     * MaterialKind.code</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: ExposedMaterialName</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialName</p>
     * 
     * <p>Relationship: REPC_MT000012ON.MaterialKind.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a human-readable name in circumstances where the 
     * agent is captured as code.</p>
     * 
     * <p>Indicates the name of the agent identified by 
     * MaterialKind.code</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialName</p>
     * 
     * <p>Relationship: REPC_MT000006ON.MaterialKind.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a human-readable name in circumstances where the 
     * agent is captured as code.</p>
     * 
     * <p>Indicates the name of the agent identified by 
     * MaterialKind.code</p>
     * 
     * <p>Un-merged Business Name: ExposedMaterialName</p>
     * 
     * <p>Relationship: REPC_MT000002ON.MaterialKind.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a human-readable name in circumstances where the 
     * agent is captured as code.</p>
     * 
     * <p>Indicates the name of the agent identified by 
     * MaterialKind.code</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }

}
