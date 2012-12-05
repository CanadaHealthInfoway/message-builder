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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.FormRole"})
public class FormRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II playingFormId = new IIImpl();


    /**
     * <p>Business Name: Form Number + Version</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Form.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"playingForm/id"})
    public Identifier getPlayingFormId() {
        return this.playingFormId.getValue();
    }

    /**
     * <p>Business Name: Form Number + Version</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Form.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPlayingFormId(Identifier playingFormId) {
        this.playingFormId.setValue(playingFormId);
    }

}
