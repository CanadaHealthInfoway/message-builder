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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PORX_MT060090CA.Agent: (no business name)</p>
 * 
 * <p>The identifier must be either the patient identifier, the 
 * prescriber identifier or the dispenser identifier</p>
 * 
 * <p>PORX_MT060340CA.Agent: (no business name)</p>
 * 
 * <p>The identifier must be either the patient identifier, the 
 * prescriber identifier or the dispenser identifier</p>
 * 
 * <p>PORX_MT020070CA.Agent: (no business name)</p>
 * 
 * <p>invariant( x) { The identifier must be either the patient 
 * identifier, the prescriber identifier or the dispenser 
 * identifier. }</p>
 * 
 * <p>PORX_MT060160CA.Agent: (no business name)</p>
 * 
 * <p>The identifier must be either the patient identifier, the 
 * prescriber identifier or the dispenser identifier</p>
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.Agent","PORX_MT060090CA.Agent","PORX_MT060160CA.Agent","PORX_MT060340CA.Agent"})
public class AgentBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Other Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Agent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a trace of responsibility for the dispensed 
     * drug.</p>
     * 
     * <p>The identity of the person who was ultimately responsible 
     * for the drug substitution.</p><p>This is either the patient, 
     * the prescriber of the dispenser.</p>
     * 
     * <p>Other Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Agent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a trace of responsibility for the dispensed 
     * drug.</p>
     * 
     * <p>The identity of the person who was ultimately responsible 
     * for the drug substitution.</p><p>This is either the patient, 
     * the prescriber of the dispenser.</p>
     * 
     * <p>Other Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Agent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a trace of responsibility for the 
     * substitution.</p>
     * 
     * <p>Identity of the person who ultimately made the 
     * substitution decision.</p>
     * 
     * <p>Other Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Agent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a trace of responsibility for the dispensed 
     * drug.</p>
     * 
     * <p>The identity of the person who was ultimately responsible 
     * for the drug substitution.</p><p>This is either the patient, 
     * the prescriber of the dispenser.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Other Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Agent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a trace of responsibility for the dispensed 
     * drug.</p>
     * 
     * <p>The identity of the person who was ultimately responsible 
     * for the drug substitution.</p><p>This is either the patient, 
     * the prescriber of the dispenser.</p>
     * 
     * <p>Other Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Agent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a trace of responsibility for the dispensed 
     * drug.</p>
     * 
     * <p>The identity of the person who was ultimately responsible 
     * for the drug substitution.</p><p>This is either the patient, 
     * the prescriber of the dispenser.</p>
     * 
     * <p>Other Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Agent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a trace of responsibility for the 
     * substitution.</p>
     * 
     * <p>Identity of the person who ultimately made the 
     * substitution decision.</p>
     * 
     * <p>Other Business Name: SubstitutingPersonIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Agent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a trace of responsibility for the dispensed 
     * drug.</p>
     * 
     * <p>The identity of the person who was ultimately responsible 
     * for the drug substitution.</p><p>This is either the patient, 
     * the prescriber of the dispenser.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
