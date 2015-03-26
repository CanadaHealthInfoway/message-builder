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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: DrugUse</p>
 * 
 * <p>PORX_MT060340CA.WorkingListEvent: Drug Use</p>
 * 
 * <p>Useful in establishing compliance for drug renewals and 
 * refills.</p>
 * 
 * <p>Categorization of prescriptions based on the intended 
 * duration of the prescribed therapy.</p>
 * 
 * <p>PORX_MT060160CA.WorkingListEvent: Drug Use</p>
 * 
 * <p>Useful in establishing compliance for drug renewals and 
 * refills.</p>
 * 
 * <p>Categorization of prescriptions based on the intended 
 * duration of the prescribed therapy.</p>
 * 
 * <p>PORX_MT030040CA.WorkingListEvent: Drug Use</p>
 * 
 * <p>Useful in establishing compliance for drug renewals and 
 * refills.</p>
 * 
 * <p>Categorization of prescriptions based on the intended 
 * duration of the prescribed therapy.</p>
 * 
 * <p>PORX_MT060190CA.WorkingListEvent: Drug Use</p>
 * 
 * <p>Useful in establishing compliance for drug renewals and 
 * refills.</p>
 * 
 * <p>Categorization of prescriptions based on the intended 
 * duration of the prescribed therapy.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.WorkingListEvent","PORX_MT020070CA.WorkingListEvent","PORX_MT030040CA.WorkingListEvent","PORX_MT060160CA.WorkingListEvent","PORX_MT060190CA.WorkingListEvent","PORX_MT060340CA.WorkingListEvent"})
public class DrugUseBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();


    /**
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed.</p><p>The field 
     * is marked as &quot;mandatory&quot; because the intended 
     * duration of the therapy should be known at prescribe 
     * time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT020070CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The code is 
     * mandatory as this information is known at dispense time if 
     * the act relationship was not a NULL..</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The field is 
     * marked as &quot;mandatory&quot; because the intended 
     * duration of the therapy should be known at prescribe 
     * time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTreatmentType</p>
     * 
     * <p>Relationship: PORX_MT030040CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed.</p><p>The field 
     * is marked mandatory because the intended duration of the 
     * therapy should be known at prescribe time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT010120CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The code is 
     * mandatory as this information should be known at prescribe 
     * time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTreatmentType</p>
     * 
     * <p>Relationship: PORX_MT060190CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The field is 
     * marked as &quot;mandatory&quot; because the intended 
     * duration of the therapy should be known at prescribe 
     * time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     */
    @Hl7XmlMapping({"code"})
    public ActTherapyDurationWorkingListCode getCode() {
        return (ActTherapyDurationWorkingListCode) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed.</p><p>The field 
     * is marked as &quot;mandatory&quot; because the intended 
     * duration of the therapy should be known at prescribe 
     * time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT020070CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The code is 
     * mandatory as this information is known at dispense time if 
     * the act relationship was not a NULL..</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The field is 
     * marked as &quot;mandatory&quot; because the intended 
     * duration of the therapy should be known at prescribe 
     * time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTreatmentType</p>
     * 
     * <p>Relationship: PORX_MT030040CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed.</p><p>The field 
     * is marked mandatory because the intended duration of the 
     * therapy should be known at prescribe time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: TreatmentType</p>
     * 
     * <p>Relationship: PORX_MT010120CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The code is 
     * mandatory as this information should be known at prescribe 
     * time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTreatmentType</p>
     * 
     * <p>Relationship: PORX_MT060190CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed. The field is 
     * marked as &quot;mandatory&quot; because the intended 
     * duration of the therapy should be known at prescribe 
     * time.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g. Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     */
    public void setCode(ActTherapyDurationWorkingListCode code) {
        this.code.setValue(code);
    }

}
