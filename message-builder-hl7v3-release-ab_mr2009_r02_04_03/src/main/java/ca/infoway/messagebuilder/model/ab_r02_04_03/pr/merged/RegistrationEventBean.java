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
package ca.infoway.messagebuilder.model.ab_r02_04_03.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PRPM_MT301010CA.RegistrationEvent","PRPM_MT303010CA.RegistrationEvent","PRPM_MT306011CA.RegistrationEvent"})
public class RegistrationEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20150810L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: RecordedDate</p>
     * 
     * <p>Un-merged Business Name: RecordedDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.RegistrationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This date is recorded because it can be different from 
     * when the provider record is effective.</p>
     * 
     * <p>A high value indicates when the registration was removed 
     * (logically or physically) from the system.</p>
     * 
     * <p>The date when the registration was recorded and 
     * removed.</p>
     * 
     * <p>Un-merged Business Name: RecordedDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.RegistrationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This date is recorded because it can be different from 
     * when the provider record is effective.</p>
     * 
     * <p>A high value indicates when the registration was removed 
     * (logically or physically) from the system.</p>
     * 
     * <p>The date when the registration was recorded and 
     * removed.</p>
     * 
     * <p>Un-merged Business Name: RecordedDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.RegistrationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This date is recorded because it can be different from 
     * when the provider record is effective.</p>
     * 
     * <p>A high value indicates when the registration was removed 
     * (logically or physically) from the system.</p>
     * 
     * <p>The date when the registration was recorded and when it 
     * was nullified.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: RecordedDate</p>
     * 
     * <p>Un-merged Business Name: RecordedDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.RegistrationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This date is recorded because it can be different from 
     * when the provider record is effective.</p>
     * 
     * <p>A high value indicates when the registration was removed 
     * (logically or physically) from the system.</p>
     * 
     * <p>The date when the registration was recorded and 
     * removed.</p>
     * 
     * <p>Un-merged Business Name: RecordedDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.RegistrationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This date is recorded because it can be different from 
     * when the provider record is effective.</p>
     * 
     * <p>A high value indicates when the registration was removed 
     * (logically or physically) from the system.</p>
     * 
     * <p>The date when the registration was recorded and 
     * removed.</p>
     * 
     * <p>Un-merged Business Name: RecordedDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.RegistrationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This date is recorded because it can be different from 
     * when the provider record is effective.</p>
     * 
     * <p>A high value indicates when the registration was removed 
     * (logically or physically) from the system.</p>
     * 
     * <p>The date when the registration was recorded and when it 
     * was nullified.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

}
