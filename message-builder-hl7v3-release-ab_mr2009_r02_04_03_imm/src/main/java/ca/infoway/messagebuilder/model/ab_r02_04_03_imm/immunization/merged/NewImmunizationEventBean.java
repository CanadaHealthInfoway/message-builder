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
package ca.infoway.messagebuilder.model.ab_r02_04_03_imm.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>POIZ_MT060150AB.NewImmunziationEvent: New Immunization 
 * Event</p>
 * 
 * <p>Information about the immunization event that succeeds 
 * the current immunization event.</p>
 * 
 * <p>POIZ_MT030060AB.NewImmunizationEvent: New Immunization 
 * Event</p>
 * 
 * <p>Information about the immunization event that succeeds 
 * the current immunization event.</p>
 * 
 * <p>POIZ_MT030050AB.NewImmunizationEvent: New Immunization 
 * Event ID</p>
 * 
 * <p>Information about the immunization event that succeeds 
 * the current immunization event.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050AB.NewImmunizationEvent","POIZ_MT030060AB.NewImmunizationEvent","POIZ_MT060150AB.NewImmunziationEvent"})
public class NewImmunizationEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20140514L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: NewImmunizationEventID</p>
     * 
     * <p>Un-merged Business Name: NewImmunizationEventID</p>
     * 
     * <p>Relationship: POIZ_MT060150AB.NewImmunziationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: NewImmunizationEventID</p>
     * 
     * <p>Relationship: POIZ_MT030060AB.NewImmunizationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050AB.NewImmunizationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: NewImmunizationEventID</p>
     * 
     * <p>Un-merged Business Name: NewImmunizationEventID</p>
     * 
     * <p>Relationship: POIZ_MT060150AB.NewImmunziationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: NewImmunizationEventID</p>
     * 
     * <p>Relationship: POIZ_MT030060AB.NewImmunizationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050AB.NewImmunizationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}