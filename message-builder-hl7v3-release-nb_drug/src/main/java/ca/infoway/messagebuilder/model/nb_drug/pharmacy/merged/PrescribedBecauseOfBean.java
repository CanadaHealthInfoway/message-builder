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
package ca.infoway.messagebuilder.model.nb_drug.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt980050ca.Indications;



/**
 * <p>PORX_MT060060CA.Reason: d:prescribed because of</p>
 * 
 * <p>Helps providers evaluate the appropriateness of the usage 
 * instructions for the device, and may influence education or 
 * literature provided to the patient on the use of the 
 * device.</p><p>Provided at the discretion of the prescriber 
 * to enhance patient care.</p><p>This field is marked as 
 * populated because of its high clinical importance, however 
 * 'Nulls' are allowed because the individual recording the 
 * prescription (e.g. pharmacist) may not be aware of the 
 * indication or the prescriber may choose to withhold (mask) 
 * the information due to patient sensitivity.</p>
 * 
 * <p>Denotes the reason(s) for this specific prescription; it 
 * must not be interpreted as a permanent diagnosis.</p>
 * 
 * <p>PORX_MT010120CA.Reason2: *d:has prescribing reasons</p>
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
 * <p>PORX_MT060160CA.Reason2: d:prescribed because of</p>
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
 * <p>PORX_MT010110CA.Reason2: *d:has prescribing reasons</p>
 * 
 * <p>Helps providers evaluate the appropriateness of the 
 * instructions for the device, and may influence education or 
 * literature provided to the patient on the use of the 
 * device.</p><p>Provided at the discretion of the prescriber 
 * to enhance patient care.</p><p>This field is marked as 
 * populated because of its high clinical importance, however 
 * 'Nulls' are allowed because the individual recording the 
 * prescription (e.g. pharmacist) may not be aware of the 
 * indication or the prescriber may choose to withhold (mask) 
 * the information due to patient sensitivity.</p>
 * 
 * <p>Denotes the reason(s) for this specific prescription; it 
 * must not be interpreted as a permanent diagnosis.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.Reason2","PORX_MT010120CA.Reason2","PORX_MT030040CA.Reason","PORX_MT060040CA.Reason2","PORX_MT060060CA.Reason","PORX_MT060160CA.Reason2","PORX_MT060190CA.Reason","PORX_MT060340CA.Reason2"})
public class PrescribedBecauseOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20151013L;
    private INT priorityNumber = new INTImpl();
    private Indications indications;


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


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Reason.indications</p>
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
     * <p>Relationship: PORX_MT030040CA.Reason.indications</p>
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
     * <p>Relationship: PORX_MT060040CA.Reason2.indications</p>
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
     * <p>Relationship: PORX_MT060190CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Reason2.indications</p>
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
     * <p>Relationship: PORX_MT060060CA.Reason.indications</p>
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
     * <p>Relationship: PORX_MT030040CA.Reason.indications</p>
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
     * <p>Relationship: PORX_MT060040CA.Reason2.indications</p>
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
     * <p>Relationship: PORX_MT060190CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Reason2.indications</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setIndications(Indications indications) {
        this.indications = indications;
    }

}
