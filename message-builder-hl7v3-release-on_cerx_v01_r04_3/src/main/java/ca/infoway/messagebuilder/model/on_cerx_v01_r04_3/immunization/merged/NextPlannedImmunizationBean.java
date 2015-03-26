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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>POIZ_MT030050ON.NextPlannedImmunization: (no business 
 * name)</p>
 * 
 * <p>The NextPlannedImmunization is the next scheduled dose 
 * within a set or &quot;series&quot; of immunizations.</p>
 * 
 * <p>POIZ_MT030060ON.NextPlannedImmunization: (no business 
 * name)</p>
 * 
 * <p>The NextPlannedImmunization is the next scheduled dose 
 * within a set or &quot;series&quot; of immunizations.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050ON.NextPlannedImmunization","POIZ_MT030060ON.NextPlannedImmunization","POIZ_MT060150ON.NextPlannedImmunization"})
public class NextPlannedImmunizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered. .</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered. .</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060ON.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

}
