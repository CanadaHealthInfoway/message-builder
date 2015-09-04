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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt120402ca.Indications;



/**
 * <p>REPC_MT230003CA.Reason: *m:because of Indications</p>
 * 
 * <p>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Clinical Observation Document is 
 * being done for multiple reasons.</p>
 * 
 * <p>Identifies the clinical reason(s) for performing the 
 * action described by the record.</p>
 * 
 * <p>REPC_MT410001CA.Reason: *j:because of</p>
 * 
 * <p> <i>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Measured Observation is being done 
 * for multiple reasons.</i> </p>
 * 
 * <p> <i>Identifies the clinical reason(s) for performing the 
 * action described by the record.</i> </p>
 * 
 * <p>POME_MT010040CA.Reason: recommended for</p>
 * 
 * <p>Useful in prescribing by narrowing selectable drugs based 
 * on specified indication.</p>
 * 
 * <p>Recommends which drugs are to be used for which 
 * indications.</p>
 * 
 * <p>PORX_MT060190CA.Reason: d:prescribed because of</p>
 * 
 * <p>Helps providers evaluate the appropriateness of the 
 * dosage instructions for the medication, and may influence 
 * education or literature provided to the patient on the use 
 * of the medication.</p><p>Provided at the discretion of the 
 * prescriber to enhance patient care. E.g., take 1 tab bid for 
 * migraine. Also needed for drug-disease interaction checking 
 * software to work properly.</p><p>This field is marked as 
 * populated because of its high clinical importance, however 
 * 'Nulls' are allowed because the individual recording the 
 * prescription (e.g. pharmacist) may not be aware of the 
 * indication or the prescriber may choose to withhold (mask) 
 * the information due to patient sensitivity.</p>
 * 
 * <p>Denotes the reason(s) for this specific prescription; it 
 * must not be interpreted as a permanent diagnosis.</p>
 * 
 * <p>REPC_MT230001CA.Reason: *m:because of Indications</p>
 * 
 * <p> <i>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Clinical Observation Document is 
 * being done for multiple reasons.</i> </p>
 * 
 * <p> <i>Identifies the clinical reason(s) for performing the 
 * action described by the record.</i> </p>
 * 
 * <p>REPC_MT220003CA.Reason: *m:because of Indications</p>
 * 
 * <p> <i>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Discharge-Care Summary is being done 
 * for multiple reasons.</i> </p>
 * 
 * <p> <i>Identifies the clinical reason(s) for performing the 
 * action described by the record.</i> </p>
 * 
 * <p>REPC_MT220002CA.Reason: *m:because of Indications</p>
 * 
 * <p> <i>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Discharge-Care Summary is being done 
 * for multiple reasons.</i> </p>
 * 
 * <p> <i>Identifies the clinical reason(s) for performing the 
 * action described by the record.</i> </p>
 * 
 * <p>REPC_MT230002CA.Reason: *m:because of Indications</p>
 * 
 * <p>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Clinical Observation Document is 
 * being done for multiple reasons.</p>
 * 
 * <p>Identifies the clinical reason(s) for performing the 
 * action described by the record.</p>
 * 
 * <p>PORX_MT060040CA.Reason2: d:prescribed because of</p>
 * 
 * <p>Helps providers evaluate the appropriateness of the 
 * instructions for the device, and may influence education or 
 * literature provided to the patient on the use of the 
 * device.</p><p>Provided at the discretion of the prescriber 
 * to enhance patient care. E.g., take 1 tab bid for migraine. 
 * Also needed for drug-disease interaction checking software 
 * to work properly.</p><p>This field is marked as populated 
 * because of its high clinical importance, however 'Nulls' are 
 * allowed because the individual recording the prescription 
 * (e.g. pharmacist) may not be aware of the indication or the 
 * prescriber may choose to withhold (mask) the information due 
 * to patient sensitivity.</p>
 * 
 * <p>Denotes the reason(s) for this specific prescription; it 
 * must not be interpreted as a permanent diagnosis.</p>
 * 
 * <p>REPC_MT210002CA.Reason: *m:because of Indications</p>
 * 
 * <p> <i>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Referral is being done for multiple 
 * reasons.</i> </p>
 * 
 * <p> <i>Identifies the clinical reason(s) for performing the 
 * action described by the record.</i> </p>
 * 
 * <p>REPC_MT420003CA.Reason: *j:because of</p>
 * 
 * <p> <i>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Coded Observation is being done for 
 * multiple reasons.</i> </p>
 * 
 * <p> <i>Identifies the clinical reason(s) for performing the 
 * action described by the record.</i> </p>
 * 
 * <p>PORX_MT060340CA.Reason2: d:prescribed because of</p>
 * 
 * <p>Helps providers evaluate the appropriateness of the 
 * dosage instructions for the medication, and may influence 
 * education or literature provided to the patient on the use 
 * of the medication.</p><p>Provided at the discretion of the 
 * prescriber to enhance patient care. E.g., take 1 tab bid for 
 * migraine. Also needed for drug-disease interaction checking 
 * software to work properly.</p><p>This field is marked as 
 * populated because of its high clinical importance, however 
 * 'Nulls' are allowed because the individual recording the 
 * prescription (e.g. pharmacist) may not be aware of the 
 * indication or the prescriber may choose to withhold (mask) 
 * the information due to patient sensitivity.</p>
 * 
 * <p>Denotes the reason(s) for this specific prescription; it 
 * must not be interpreted as a permanent diagnosis.</p>
 * 
 * <p>PORX_MT030040CA.Reason: d:prescribed because of</p>
 * 
 * <p>Helps providers evaluate the appropriateness of the 
 * dosage instructions for the medication, and may influence 
 * education or literature provided to the patient on the use 
 * of the medication.</p><p>Provided at the discretion of the 
 * prescriber to enhance patient care. E.g., take 1 tab bid for 
 * migraine. Also needed for drug-disease interaction checking 
 * software to work properly.</p><p>This field is marked as 
 * populated because of its high clinical importance, however 
 * 'Nulls' are allowed because the individual recording the 
 * prescription (e.g. pharmacist) may not be aware of the 
 * indication or the prescriber may choose to withhold (mask) 
 * the information due to patient sensitivity.</p>
 * 
 * <p>Denotes the reason(s) for this specific prescription; it 
 * must not be interpreted as a permanent diagnosis.</p>
 * 
 * <p>REPC_MT500001CA.Reason: k:because of</p>
 * 
 * <p>Association is mandatory, 1..1 when Care Composition Type 
 * is Episode (Health Condition-based) or a specialization 
 * there-of</p>
 * 
 * <p> <i>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Care Composition is being done for 
 * multiple reasons.</i> </p>
 * 
 * <p>For health condition-based (episode) collections, there 
 * must be exactly one indication (the 'definitional' problem 
 * for the episode). For care-based collections, there should 
 * not be any indications. (Problems are captured as part of 
 * the overall care, not as the reason for care.)</p>
 * 
 * <p> <i>Identifies the clinical reason(s) for performing the 
 * action described by the record.</i> </p>
 * 
 * <p>REPC_MT420001CA.Reason: *j:because of</p>
 * 
 * <p> <i>Essential for understanding the context in which the 
 * action was performed. Also frequently used in searching and 
 * filtering and can impact whether the record will be 
 * automatically masked. Multiple indications are supported for 
 * circumstances where the Coded Observation is being done for 
 * multiple reasons.</i> </p>
 * 
 * <p> <i>Identifies the clinical reason(s) for performing the 
 * action described by the record.</i> </p>
 * 
 * <p>PORX_MT060060CA.Reason: d:prescribed because of</p>
 * 
 * <p>Helps providers evaluate the appropriateness of the usage 
 * instructions for the device, and may influence education or 
 * literature provided to the patient on the use of the 
 * device.</p><p>Provided at the discretion of the prescriber 
 * to enhance patient care.</p><p>This field is marked as 
 * populated because of its high clinical importance, however 
 * '
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Reason","PORX_MT010110CA.Reason2","PORX_MT010120CA.Reason2","PORX_MT030040CA.Reason","PORX_MT060040CA.Reason2","PORX_MT060060CA.Reason","PORX_MT060160CA.Reason2","PORX_MT060190CA.Reason","PORX_MT060340CA.Reason2","REPC_MT210001CA.Reason","REPC_MT210002CA.Reason","REPC_MT210003CA.Reason","REPC_MT220001CA.Reason","REPC_MT220002CA.Reason","REPC_MT220003CA.Reason","REPC_MT230001CA.Reason","REPC_MT230002CA.Reason","REPC_MT230003CA.Reason","REPC_MT410001CA.Reason","REPC_MT410003CA.Reason","REPC_MT420001CA.Reason","REPC_MT420003CA.Reason","REPC_MT500001CA.Reason","REPC_MT500002CA.Reason","REPC_MT500003CA.Reason","REPC_MT500004CA.Reason","REPC_MT610001CA.Reason","REPC_MT610002CA.Reason"})
public class BecauseOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private Indications indications;
    private INT priorityNumber = new INTImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT410003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT410001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POME_MT010040CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT420003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT420001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500004CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"indications"})
    public Indications getIndications() {
        return this.indications;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT410003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT410001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POME_MT010040CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT420003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT420001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500004CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610002CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610001CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setIndications(Indications indications) {
        this.indications = indications;
    }


    /**
     * <p>Business Name: IndicationPriority</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Reason.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Reason.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Reason.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     */
    @Hl7XmlMapping({"priorityNumber"})
    public Integer getPriorityNumber() {
        return this.priorityNumber.getValue();
    }

    /**
     * <p>Business Name: IndicationPriority</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Reason.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Reason.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Reason.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     * 
     * <p>Un-merged Business Name: IndicationPriority</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Reason2.priorityNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to indicate whether indication is the 
     * primary or secondary target of the therapy. E.g., Terazosin 
     * for Benign Prostatic Hypertrophy as primary and Hypertension 
     * as secondary or vice-versa.</p>
     * 
     * <p>Ordering of prescribing indications from primary 
     * indication (low number) to minor indication (higher number). 
     * Multiple indications are permitted to have the same priority 
     * if they're considered of equivalent importance.</p>
     */
    public void setPriorityNumber(Integer priorityNumber) {
        this.priorityNumber.setValue(priorityNumber);
    }

}
