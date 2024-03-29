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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt020020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt910107ca.RelatedPersonBean;



/**
 * <p>Business Name: Dispense Pickup</p>
 * 
 * <p>Captures information about what prescription was picked 
 * up and who received it.</p>
 * 
 * <p>The root class for the message. The time of pickup is 
 * specified on the ControlAct wrapper.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020020CA.SupplyEvent"})
@Hl7RootType
public class DispensePickupBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private RelatedPersonBean receiverPersonalRelationship;


    /**
     * <p>Business Name: Dispense Id</p>
     * 
     * <p>Relationship: PORX_MT020020CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of prescription dispense that has been picked 
     * up.</p>
     * 
     * <p>Allows dispenses to be uniquely identified. This 
     * attribute is mandatory because the identity of the dispense 
     * record must be known.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Dispense Id</p>
     * 
     * <p>Relationship: PORX_MT020020CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of prescription dispense that has been picked 
     * up.</p>
     * 
     * <p>Allows dispenses to be uniquely identified. This 
     * attribute is mandatory because the identity of the dispense 
     * record must be known.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: 
     * PORX_MT020020CA.Receiver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"receiver/personalRelationship"})
    public RelatedPersonBean getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }

    /**
     * <p>Relationship: 
     * PORX_MT020020CA.Receiver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setReceiverPersonalRelationship(RelatedPersonBean receiverPersonalRelationship) {
        this.receiverPersonalRelationship = receiverPersonalRelationship;
    }

}
