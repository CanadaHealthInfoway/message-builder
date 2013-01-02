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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"POIZ_MT030050CA.NextPlannedImmunization","POIZ_MT030060CA.NextPlannedImmunization","POIZ_MT060150CA.NextPlannedImmunization"})
public class NextPlannedImmunizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Un-merged Business Name: RenewalDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered.</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered. .</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: RenewalDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered.</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Un-merged Business Name: NextPlannedDoseDate</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.NextPlannedImmunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered. .</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

}
