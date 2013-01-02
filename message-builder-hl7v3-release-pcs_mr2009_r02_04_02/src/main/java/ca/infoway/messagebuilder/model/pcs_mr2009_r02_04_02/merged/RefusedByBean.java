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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import java.util.Date;



/**
 * <p>PORX_MT060210CA.Author: *b:recorded by</p>
 * 
 * <p>Allows other providers to enquire about the authenticity 
 * of the content of the other medication record and is 
 * therefore mandatory.</p>
 * 
 * <p>Indicates the identity of the provider who recorded the 
 * other medication information.</p>
 * 
 * <p>PORX_MT060160CA.Author5: *refused by</p>
 * 
 * <p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the provider 
 * refusing the fill must be known.</p>
 * 
 * <p>Indicates who refused to fulfill the prescription</p>
 * 
 * <p>PORX_MT020070CA.Author: bc:prescribed by</p>
 * 
 * <p>Used to create an 'inferred' prescription if an 
 * electronic prescription does not already exist in the 
 * EHR.</p>
 * 
 * <p>The person who prescribed the medication.</p>
 * 
 * <p>PORX_MT060190CA.Author: *recorded by</p>
 * 
 * <p>Useful for follow-up and audit purposes, and therefore 
 * mandatory.</p>
 * 
 * <p>Indicates the provider who recorded the &quot;other 
 * active medication&quot;.</p>
 * 
 * <p>PORX_MT060190CA.Author3: *refused by</p>
 * 
 * <p>Allows follow-up and traceability of the refusal and is 
 * therefore mandatory</p>
 * 
 * <p>Indicates who refused to fulfill the prescription</p>
 * 
 * <p>PORX_MT030040CA.Author: *refused by</p>
 * 
 * <p>Allows follow-up and traceability of the refusal and is 
 * therefore mandatory.</p>
 * 
 * <p>Indicates who refused to fulfill the prescription</p>
 * 
 * <p>PORX_MT060090CA.Author5: *prescribed by</p>
 * 
 * <p>The prescriber is a key piece of legal information which 
 * must be conveyed and is therefore mandatory.</p>
 * 
 * <p>Indicates the prescriber of the prescription.</p>
 * 
 * <p>PORX_MT060160CA.Author: *created by</p>
 * 
 * <p>Provides traceability as well as contact information for 
 * follow-up and is therefore mandatory.</p>
 * 
 * <p>Identifies the provider responsible for capturing the 
 * Other Medication record</p>
 * 
 * <p>REPC_MT000009CA.Author: *f:authored by</p>
 * 
 * <p>Identifies responsibility for accuracy and relevance of 
 * the information. This association reflects primary 
 * responsibility, and is therefore mandatory.</p>
 * 
 * <p>Identifies the provider who reported the allergy or 
 * intolerance.</p>
 * 
 * <p>PORX_MT060340CA.Author: *refused by</p>
 * 
 * <p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the provider 
 * refusing the fill must be known.</p>
 * 
 * <p>Indicates who refused to fulfill the prescription</p>
 * 
 * <p>PORX_MT060060CA.Author: *refused by</p>
 * 
 * <p>Allows follow-up and traceability of the refusal and is 
 * therefore mandatory</p>
 * 
 * <p>Indicates who refused to fulfill the prescription</p>
 * 
 * <p>PORX_MT060040CA.Author: *refused by</p>
 * 
 * <p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the provider 
 * refusing the fill must be known.</p>
 * 
 * <p>Indicates who refused to fulfill the prescription</p>
 * 
 * <p>REPC_MT000005CA.Author: *f:authored by</p>
 * 
 * <p>Identifies responsibility for accuracy and relevance of 
 * the information. This association reflects primary 
 * responsibility, and is therefore mandatory.</p>
 * 
 * <p>Identifies the provider who reported the allergy or 
 * intolerance.</p>
 * 
 * <p>PORX_MT060010CA.Author5: *prescribed by</p>
 * 
 * <p>The prescriber is a key piece of legal information which 
 * must be conveyed and is therefore mandatory.</p>
 * 
 * <p>Indicates the prescriber of the prescription.</p>
 * 
 * <p>REPC_MT000006CA.Author: *f:authored by</p>
 * 
 * <p>Identifies responsibility for accuracy and relevance of 
 * the information. This association reflects primary 
 * responsibility, and is therefore mandatory.</p>
 * 
 * <p>Identifies the provider who reported the reaction.</p>
 * 
 * <p>PORX_MT020060CA.Author: bc:prescribed by</p>
 * 
 * <p>Used to create an 'inferred' prescription if an 
 * electronic prescription does not already exist in the 
 * EHR.</p>
 * 
 * <p>The person who prescribed the device.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020060CA.Author","PORX_MT020070CA.Author","PORX_MT030040CA.Author","PORX_MT060010CA.Author5","PORX_MT060040CA.Author","PORX_MT060060CA.Author","PORX_MT060090CA.Author5","PORX_MT060160CA.Author","PORX_MT060160CA.Author5","PORX_MT060190CA.Author","PORX_MT060190CA.Author3","PORX_MT060210CA.Author","PORX_MT060340CA.Author","REPC_MT000005CA.Author","REPC_MT000006CA.Author","REPC_MT000009CA.Author"})
public class RefusedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private HealthcareWorkerBean assignedEntity;
    private TS time = new TSImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060210CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author5.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Author5.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Author5.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060210CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author5.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Author5.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Author5.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }


    /**
     * <p>Un-merged Business Name: CreateTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies timing of allergy/intolerance for sorting and 
     * for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record common 
     * observation' interaction.</p>
     * 
     * <p>The date and time on which the allergy/intolerance record 
     * was created.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: CreateTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies timing of allergy/intolerance for sorting and 
     * for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record 
     * allergy/intolerance' interaction.</p>
     * 
     * <p>The date and time on which the allergy/intolerance record 
     * was created.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Author5.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Author5.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: CreateTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies timing of adverse reaction for sorting and for 
     * audit purposes. Attribute is populated because the source of 
     * the data may not be through the 'record common observation' 
     * interaction.</p>
     * 
     * <p>The date and time on which the adverse reaction record 
     * was created.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p>
     * 
     * <p>The calendar date on which the device was prescribed. 
     * This may differ from the date on which the prescription 
     * becomes effective. E.g. A prescription created today may not 
     * be valid to be dispensed or used for two weeks.</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Un-merged Business Name: CreateTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies timing of allergy/intolerance for sorting and 
     * for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record common 
     * observation' interaction.</p>
     * 
     * <p>The date and time on which the allergy/intolerance record 
     * was created.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: CreateTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies timing of allergy/intolerance for sorting and 
     * for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record 
     * allergy/intolerance' interaction.</p>
     * 
     * <p>The date and time on which the allergy/intolerance record 
     * was created.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Author5.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Author5.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: CreateTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies timing of adverse reaction for sorting and for 
     * audit purposes. Attribute is populated because the source of 
     * the data may not be through the 'record common observation' 
     * interaction.</p>
     * 
     * <p>The date and time on which the adverse reaction record 
     * was created.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p>
     * 
     * <p>The calendar date on which the device was prescribed. 
     * This may differ from the date on which the prescription 
     * becomes effective. E.g. A prescription created today may not 
     * be valid to be dispensed or used for two weeks.</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }

}
