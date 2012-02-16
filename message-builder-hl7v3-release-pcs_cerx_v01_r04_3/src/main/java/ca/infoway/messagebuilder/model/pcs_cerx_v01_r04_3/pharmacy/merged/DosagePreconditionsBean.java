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
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.ObservationDosageDefinitionPreconditionType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>DosagePreconditions</p>
 * 
 * <p>PORX_MT980010CA.ObservationEventCriterion: Dosage 
 * Preconditions</p>
 * 
 * <p><p>A condition that must be true for the patient in order 
 * for the specified recommended dosage range to apply.</p></p>
 * 
 * <p><p>Allows recommended dosage instructions to be bound to 
 * a particular characteristic of the patient.</p></p>
 * 
 * <p>PORX_MT980020CA.ObservationEventCriterion: Dosage 
 * Preconditions</p>
 * 
 * <p><p>A condition that must be true for the patient in order 
 * for the specified recommended dosage range to apply.</p></p>
 * 
 * <p><p>Allows recommended dosage instructions to be bound to 
 * a particular characteristic of the patient.</p></p>
 * 
 * <p>PORX_MT980030CA.ObservationEventCriterion: Dosage 
 * Preconditions</p>
 * 
 * <p><p>A condition that must be true for the patient in order 
 * for the specified recommended dosage range to apply.</p></p>
 * 
 * <p><p>Allows recommended dosage instructions to be bound to 
 * a particular characteristic of the patient.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980010CA.ObservationEventCriterion","PORX_MT980020CA.ObservationEventCriterion","PORX_MT980030CA.ObservationEventCriterion"})
public class DosagePreconditionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private CV code = new CVImpl();
    private URG<PQ, PhysicalQuantity> value = new URGImpl<PQ, PhysicalQuantity>();


    /**
     * <p>DosagePreconditionType</p>
     * 
     * <p>A:Dosage Precondition Type</p>
     * 
     * <p><p>Indicates the type of characteristic against which the 
     * patient is evaluated. This includes age, weight, height, 
     * etc.</p></p>
     * 
     * <p><p>Allows the specification of multiple preconditions for 
     * a dosage specification, such as Age Range, Weight Range, 
     * etc. This is mandatory because the precondition range cannot 
     * be evaluated without knowing the precondition type.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationDosageDefinitionPreconditionType getCode() {
        return (ObservationDosageDefinitionPreconditionType) this.code.getValue();
    }
    public void setCode(ObservationDosageDefinitionPreconditionType code) {
        this.code.setValue(code);
    }


    /**
     * <p>DosagePreconditionValue</p>
     * 
     * <p>B:Dosage Precondition Value</p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * values of the measurements must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * values of the measurements must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * values of the measurements must be known.</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>If not specified, it means that the range is based on 
     * a criteria (e.g. weight), but the specific range on which 
     * the criteria is based is not known.</p></p>
     * 
     * <p>B:Dosage Precondition Value</p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This attribute is mandatory as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This attribute is mandatory as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This attribute is mandatory as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>If not specified, it means that the range is based on 
     * a criteria (e.g. weight), but the specific range on which 
     * the criteria is based is not known.</p></p>
     * 
     * <p>B:Dosage Precondition Value</p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>If not specified, it means that the range is based on 
     * a criteria (e.g. weight), but the specific range on which 
     * the criteria is based is not known.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public UncertainRange<PhysicalQuantity> getValue() {
        return this.value.getValue();
    }
    public void setValue(UncertainRange<PhysicalQuantity> value) {
        this.value.setValue(value);
    }

}
