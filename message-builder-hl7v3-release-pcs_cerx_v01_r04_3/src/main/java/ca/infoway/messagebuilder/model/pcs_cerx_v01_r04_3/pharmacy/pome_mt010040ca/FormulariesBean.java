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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.AssignedEntity3Bean;



/**
 * <p>Formularies</p>
 * 
 * <p><p>At least One of Id or Title must be specified</p></p>
 * 
 * <p><p>List of drugs available from (or carried by) a 
 * particular organization. For example, University Hospital 
 * formulary, East Side Long Term Care formulary, Alberta Blue 
 * Cross formulary</p></p>
 * 
 * <p><p>Used to ascertain/ensure what drugs can be 
 * prescribed/dispensed within a specific jurisdiction or which 
 * will be covered by a patient's insurance.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.PotentialSupply"})
public class FormulariesBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private II id = new IIImpl();
    private ST title = new STImpl();
    private AssignedEntity3Bean performerAssignedEntity;


    /**
     * <p>Formulary Id</p>
     * 
     * <p><p>A unique identifier for a specific formulary.</p></p>
     * 
     * <p><p>Allows the formulary to be unambiguously 
     * referenced</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Formulary Name</p>
     * 
     * <p><p>The name by which the formulary is commonly known.</p></p>
     * 
     * <p><p>Gives a provider-recognizable label for the 
     * formulary.</p></p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    @Hl7XmlMapping({"performer/assignedEntity"})
    public AssignedEntity3Bean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }
    public void setPerformerAssignedEntity(AssignedEntity3Bean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }

}
