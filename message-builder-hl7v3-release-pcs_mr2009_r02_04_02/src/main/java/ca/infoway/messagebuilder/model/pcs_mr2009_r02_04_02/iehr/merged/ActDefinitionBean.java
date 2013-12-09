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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT410001CA.ActDefinition","REPC_MT410003CA.ActDefinition","REPC_MT420001CA.ActDefinition","REPC_MT420003CA.ActDefinition","REPC_MT610001CA.ActDefinition","REPC_MT610002CA.ActDefinition"})
public class ActDefinitionBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: ProtocolIds</p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the 
     * Professional Service record was performed as part of a 
     * particular protocol.</i> </p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT410003CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT420001CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the Coded 
     * Observation record was performed as part of a particular 
     * protocol.</i> </p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT420003CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the Coded 
     * Observation record was performed as part of a particular 
     * protocol.</i> </p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT410001CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the Measured 
     * Observation record was performed as part of a particular 
     * protocol.</i> </p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT610002CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the 
     * Professional Service record was performed as part of a 
     * particular protocol.</i> </p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ProtocolIds</p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the 
     * Professional Service record was performed as part of a 
     * particular protocol.</i> </p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT410003CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT420001CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the Coded 
     * Observation record was performed as part of a particular 
     * protocol.</i> </p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT420003CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the Coded 
     * Observation record was performed as part of a particular 
     * protocol.</i> </p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT410001CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the Measured 
     * Observation record was performed as part of a particular 
     * protocol.</i> </p>
     * 
     * <p>Un-merged Business Name: ProtocolIds</p>
     * 
     * <p>Relationship: REPC_MT610002CA.ActDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows linking together a series of observations, 
     * procedures, drug administrations and other clinical actions 
     * as part of a particular protocol. Useful in clinical studies 
     * and may also provide context around why the action was 
     * performed. The element also allows providers to filter 
     * searches to only expose data related to a particular 
     * protocol.</i> </p><p> <i>This element is optional because 
     * the use of and need to reference protocols will not apply to 
     * all healthcare providers. PoS applications should choose 
     * whether to support the element based on the perceived needs 
     * of their client base.</i> </p>
     * 
     * <p> <i>Indicates that the action described by the 
     * Professional Service record was performed as part of a 
     * particular protocol.</i> </p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
