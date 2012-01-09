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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT210001CA.Reference","REPC_MT210003CA.Reference","REPC_MT220001CA.Reference","REPC_MT220003CA.Reference","REPC_MT230001CA.Reference","REPC_MT230003CA.Reference"})
public class ReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();


    /**
     * <p>ReferenceRecordLinks</p>
     * 
     * <p>L:Reference Record Links</p>
     * 
     * <p>L:Reference Record Links</p>
     * 
     * <p><p>These identifiers allow for referencing other discrete 
     * records within the EHR which are considered relevant to the 
     * document as a whole or a particular section.</p></p>
     * 
     * <p><p>The external references allow accessing discrete data 
     * for additional analysis and manipulation such as graphing, 
     * automated comparison or decision-support.</p></p>
     * 
     * <p><p>For sections, the links may refer specifically to 
     * records which have been rendered as part of the section.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
