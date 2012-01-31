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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT020070CA.Agent","PORX_MT060090CA.Agent","PORX_MT060160CA.Agent","PORX_MT060340CA.Agent"})
public class AgentBean extends MessagePartBean {

    private static final long serialVersionUID = 20120130L;
    private II id = new IIImpl();


    /**
     * <p>SubstitutingPersonIdentifier</p>
     * 
     * <p>Substituting Person Identifier</p>
     * 
     * <p><p>Identity of the person who ultimately made the 
     * substitution decision. This must be either the patient's 
     * identifier, the prescriber identifier, or the dispenser 
     * identifier <strong>or a BUS error will be 
     * returned.</strong></p></p>
     * 
     * <p>Substituting Person Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
