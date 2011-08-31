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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.repc_mt000006ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT000006CA.MaterialKind"})
public class AgentCategoryBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV exposedMaterialType = new CVImpl();
    private ST exposedMaterialName = new STImpl();


    /**
     * <p>A:Exposed Material Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ExposureAgentEntityType getExposedMaterialType() {
        return (ExposureAgentEntityType) this.exposedMaterialType.getValue();
    }
    public void setExposedMaterialType(ExposureAgentEntityType exposedMaterialType) {
        this.exposedMaterialType.setValue(exposedMaterialType);
    }


    /**
     * <p>Exposed Material Name</p>
     */
    @Hl7XmlMapping({"name"})
    public String getExposedMaterialName() {
        return this.exposedMaterialName.getValue();
    }
    public void setExposedMaterialName(String exposedMaterialName) {
        this.exposedMaterialName.setValue(exposedMaterialName);
    }

}
