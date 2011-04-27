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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.ra.comt_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.MaskableMaterialEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COMT_MT400001CA.Role"})
public class RoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV maskableMaterial = new CVImpl();


    /**
     * <p>Maskable Material</p>
     * 
     * <p><p>Indicates the materia (e.g drug) whose associated 
     * records should be masked.</p></p>
     * 
     * <p><p>Allows masking a drug, avoiding the requirement to 
     * mask each prescription and dispense individually.</p></p>
     * 
     * <p><p>Usually specified at the generic or 
     * therapeutic-equivalent level to ensure related medications 
     * are also covered.</p></p>
     */
    @Hl7XmlMapping({"playingEntityKind/code"})
    public MaskableMaterialEntityType getMaskableMaterial() {
        return (MaskableMaterialEntityType) this.maskableMaterial.getValue();
    }
    public void setMaskableMaterial(MaskableMaterialEntityType maskableMaterial) {
        this.maskableMaterial.setValue(maskableMaterial);
    }

}
