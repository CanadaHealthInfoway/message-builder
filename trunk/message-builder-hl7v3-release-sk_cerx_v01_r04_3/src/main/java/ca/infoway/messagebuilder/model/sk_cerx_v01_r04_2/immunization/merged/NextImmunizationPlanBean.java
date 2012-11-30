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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"POIZ_MT030050CA.NextImmunizationPlan","POIZ_MT030060CA.NextImmunizationPlan","POIZ_MT060150CA.NextImmunizationPlan"})
public class NextImmunizationPlanBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private TS effectiveTime = new TSImpl();


    /**
     * <p>Renewal Date</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Next Planned Dose Date</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered.</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Repeat Date</p>
     * 
     * <p>The date on which the overall immunization therapy is to 
     * be repeated.</p>
     * 
     * <p>Allows for immunization therapy planning for a 
     * patient.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Renewal Date</p>
     * 
     * <p>Indicates the date on which the next course of 
     * immunization is to be undertaken.</p>
     * 
     * <p>Necessary reminder to a patient and his/or provider for a 
     * follow-up therapy.</p>
     * 
     * <p>Next Planned Dose Date</p>
     * 
     * <p>Indicates the date on which the next dose is to be 
     * administered.</p>
     * 
     * <p>Allows for the scheduling of a multi-dose immunization 
     * course.</p>
     * 
     * <p>Repeat Date</p>
     * 
     * <p>The date on which the overall immunization therapy is to 
     * be repeated.</p>
     * 
     * <p>Allows for immunization therapy planning for a 
     * patient.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

}
