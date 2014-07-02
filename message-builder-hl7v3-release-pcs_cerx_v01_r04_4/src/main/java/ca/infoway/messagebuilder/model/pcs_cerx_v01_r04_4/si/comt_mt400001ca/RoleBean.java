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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.si.comt_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.MaskableMaterialEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COMT_MT400001CA.Role"})
public class RoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20140507L;
    private CV playingEntityKindCode = new CVImpl();


    /**
     * <p>Business Name: Maskable Material</p>
     * 
     * <p>Relationship: COMT_MT400001CA.EntityKind.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows masking a drug, avoiding the requirement to mask 
     * each prescription and dispense individually.</p>
     * 
     * <p>Usually specified at the generic or 
     * therapeutic-equivalent level to ensure related medications 
     * are also covered.</p>
     * 
     * <p>Indicates the materia (e.g drug) whose associated records 
     * should be masked.</p>
     */
    @Hl7XmlMapping({"playingEntityKind/code"})
    public MaskableMaterialEntityType getPlayingEntityKindCode() {
        return (MaskableMaterialEntityType) this.playingEntityKindCode.getValue();
    }

    /**
     * <p>Business Name: Maskable Material</p>
     * 
     * <p>Relationship: COMT_MT400001CA.EntityKind.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows masking a drug, avoiding the requirement to mask 
     * each prescription and dispense individually.</p>
     * 
     * <p>Usually specified at the generic or 
     * therapeutic-equivalent level to ensure related medications 
     * are also covered.</p>
     * 
     * <p>Indicates the materia (e.g drug) whose associated records 
     * should be masked.</p>
     */
    public void setPlayingEntityKindCode(MaskableMaterialEntityType playingEntityKindCode) {
        this.playingEntityKindCode.setValue(playingEntityKindCode);
    }

}