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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Protocols</p>
 * 
 * <p>PORX_MT060340CA.SubstanceAdministrationDefinition: 
 * Protocols</p>
 * 
 * <p>Allows linking to specific guidelines or protocols. Also 
 * used to provide additional detail needed when requesting a 
 * '''special access''' drug from Health Canada.</p>
 * 
 * <p>Documentation of why a prescriber has chosen to prescribe 
 * the drug in the manner they have.</p>
 * 
 * <p>PORX_MT060160CA.SubstanceAdministrationDefinition: 
 * Protocols</p>
 * 
 * <p>Allows linking to specific guidelines or protocols. Also 
 * used to provide additional detail needed when requesting a 
 * 'special access' drug from Health Canada.</p>
 * 
 * <p>Documentation of why a prescriber has chosen to prescribe 
 * the drug in the manner they have.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.SubstanceAdministrationDefinition","PORX_MT060160CA.SubstanceAdministrationDefinition","PORX_MT060340CA.SubstanceAdministrationDefinition"})
public class ProtocolsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: ProtocolIdentifiers</p>
     * 
     * <p>Un-merged Business Name: ProtocolIdentifiers</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubstanceAdministrationDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Enables the communication of a reference to a protocol, 
     * study or guideline id, specific to the 
     * jurisdiction;</p><p>Allows providers to reference a 
     * protocol/guideline for prescribing to specific situations. 
     * This could also be used for justification for prescribing a 
     * medication from a particular formulary. E.g., 'Limited' 
     * Use''' medications in Ontario require physicians to use a 
     * code indicating that a patient is eligible for this 
     * particular medication.</p>
     * 
     * <p>A unique identifier for a specific protocol or guideline 
     * which the prescription has been written in accordance 
     * with.</p>
     * 
     * <p>Un-merged Business Name: ProtocolIdentifiers</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubstanceAdministrationDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Enables the communication of a reference to a protocol, 
     * study or guideline id, specific to the 
     * jurisdiction;</p><p>Allows providers to reference a 
     * protocol/guideline for prescribing to specific situations. 
     * This could also be used for justification for prescribing a 
     * medication from a particular formulary. E.g., 'Limited Use' 
     * medications in Ontario require physicians to use a code 
     * indicating that a patient is eligible for this particular 
     * medication.</p>
     * 
     * <p>A unique identifier for a specific protocol or guideline 
     * which the prescription has been written in accordance 
     * with.</p>
     * 
     * <p>Un-merged Business Name: ProtocolIdentifiers</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubstanceAdministrationDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Enables the communication of a reference to a protocol, 
     * study or guideline id, specific to the 
     * jurisdiction;</p><p>Allows providers to reference a 
     * protocol/guideline for prescribing to specific situations. 
     * This could also be used for justification for prescribing a 
     * medication from a particular formulary. E.g., 'Limited Use' 
     * medications in Ontario require physicians to use a code 
     * indicating that a patient is eligible for this particular 
     * medication</p>
     * 
     * <p>A unique identifier for a specific protocol or guideline 
     * which the prescription has been written in accordance 
     * with.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ProtocolIdentifiers</p>
     * 
     * <p>Un-merged Business Name: ProtocolIdentifiers</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubstanceAdministrationDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Enables the communication of a reference to a protocol, 
     * study or guideline id, specific to the 
     * jurisdiction;</p><p>Allows providers to reference a 
     * protocol/guideline for prescribing to specific situations. 
     * This could also be used for justification for prescribing a 
     * medication from a particular formulary. E.g., 'Limited' 
     * Use''' medications in Ontario require physicians to use a 
     * code indicating that a patient is eligible for this 
     * particular medication.</p>
     * 
     * <p>A unique identifier for a specific protocol or guideline 
     * which the prescription has been written in accordance 
     * with.</p>
     * 
     * <p>Un-merged Business Name: ProtocolIdentifiers</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubstanceAdministrationDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Enables the communication of a reference to a protocol, 
     * study or guideline id, specific to the 
     * jurisdiction;</p><p>Allows providers to reference a 
     * protocol/guideline for prescribing to specific situations. 
     * This could also be used for justification for prescribing a 
     * medication from a particular formulary. E.g., 'Limited Use' 
     * medications in Ontario require physicians to use a code 
     * indicating that a patient is eligible for this particular 
     * medication.</p>
     * 
     * <p>A unique identifier for a specific protocol or guideline 
     * which the prescription has been written in accordance 
     * with.</p>
     * 
     * <p>Un-merged Business Name: ProtocolIdentifiers</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubstanceAdministrationDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Enables the communication of a reference to a protocol, 
     * study or guideline id, specific to the 
     * jurisdiction;</p><p>Allows providers to reference a 
     * protocol/guideline for prescribing to specific situations. 
     * This could also be used for justification for prescribing a 
     * medication from a particular formulary. E.g., 'Limited Use' 
     * medications in Ontario require physicians to use a code 
     * indicating that a patient is eligible for this particular 
     * medication</p>
     * 
     * <p>A unique identifier for a specific protocol or guideline 
     * which the prescription has been written in accordance 
     * with.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
