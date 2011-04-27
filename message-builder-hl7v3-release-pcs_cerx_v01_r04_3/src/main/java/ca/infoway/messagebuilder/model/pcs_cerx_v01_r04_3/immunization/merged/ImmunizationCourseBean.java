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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POIZ_MT030050CA.ImmunizationPlan","POIZ_MT030060CA.ImmunizationPlan","POIZ_MT060150CA.ImmunizationPlan"})
public class ImmunizationCourseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private NextPlannedImmunizationBean fulfillmentNextPlannedImmunization;
    private NextImmunizationPlanBean successorNextImmunizationPlan;


    @Hl7XmlMapping({"fulfillment/nextPlannedImmunization"})
    public NextPlannedImmunizationBean getFulfillmentNextPlannedImmunization() {
        return this.fulfillmentNextPlannedImmunization;
    }
    public void setFulfillmentNextPlannedImmunization(NextPlannedImmunizationBean fulfillmentNextPlannedImmunization) {
        this.fulfillmentNextPlannedImmunization = fulfillmentNextPlannedImmunization;
    }


    @Hl7XmlMapping({"successor/nextImmunizationPlan"})
    public NextImmunizationPlanBean getSuccessorNextImmunizationPlan() {
        return this.successorNextImmunizationPlan;
    }
    public void setSuccessorNextImmunizationPlan(NextImmunizationPlanBean successorNextImmunizationPlan) {
        this.successorNextImmunizationPlan = successorNextImmunizationPlan;
    }

}
