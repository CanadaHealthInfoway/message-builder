/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ObservationDosageDefinitionPreconditionType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Patient Characteristics</p>
 * 
 * <p><p>Indicates a characteristic that should be possessed by 
 * the patient for the dose to be appropriate.</p></p>
 * 
 * <p><p>Allows filtering of dosages to be appropriate to the 
 * patient.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.ObservationEventCriterion"})
public class PatientCharacteristicsBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private IVL<PQ, Interval<PhysicalQuantity>> value = new IVLImpl<PQ, Interval<PhysicalQuantity>>();


    /**
     * <p>Patient Characteristic Type</p>
     * 
     * <p><p>Indicates the type of patient characteristic being 
     * expressed. E.g. Height, weight, age, lab values, etc. If 
     * negation indicator is true, then this indicates a 
     * characteristic the patient should *not* have.</p></p>
     * 
     * <p><p>Needed to identify what type of characteristic is 
     * being expressed, and therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationDosageDefinitionPreconditionType getCode() {
        return (ObservationDosageDefinitionPreconditionType) this.code.getValue();
    }
    public void setCode(ObservationDosageDefinitionPreconditionType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Exclude characteristic?</p>
     * 
     * <p><p>If true, indicates that the characteristic is one 
     * which should *not* be held by the patient for the dosage to 
     * apply.</p></p>
     * 
     * <p><p>Many dosages are inappropriate for patients with 
     * certain characteristics (e.g. INR values, 
     * etc.)</p><p>Because it must be known whether the 
     * characteristic is included or excluded, this element is 
     * mandatory.</p></p>
     * 
     * <p><p>Many dosages are inappropriate for patients with 
     * certain characteristics (e.g. INR values, 
     * etc.)</p><p>Because it must be known whether the 
     * characteristic is included or excluded, this element is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Patient Characteristic Value</p>
     * 
     * <p><p>Value should be mandatory if not using SNOMED</p></p>
     * 
     * <p><p>Indicates the specific value or range of values of the 
     * characteristic a patient should have for the dosage to be 
     * appropriate.</p></p>
     * 
     * <p><p>Allows comparison to actual patient characteristics to 
     * see if the dosage is applicable. In some circumstances, the 
     * specific range may not be known, thus the field is 
     * &quot;populated&quot;</p><p>Example: This dosage 
     * specification applies to people over 60 pounds&quot;.</p></p>
     * 
     * <p><p>Allows comparison to actual patient characteristics to 
     * see if the dosage is applicable. In some circumstances, the 
     * specific range may not be known, thus the field is 
     * &quot;populated&quot;</p><p>Example: This dosage 
     * specification applies to people over 60 pounds&quot;.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Interval<PhysicalQuantity> getValue() {
        return this.value.getValue();
    }
    public void setValue(Interval<PhysicalQuantity> value) {
        this.value.setValue(value);
    }

}
