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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ObservationValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ReportedReactions</p>
 * 
 * <p>REPC_MT000001CA.CausalityAssessment: Reported Reactions</p>
 * 
 * <p><p>This is a recording of a patient reaction that is 
 * believed to be associated with the allergy/intolerance.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.CausalityAssessment","REPC_MT000002CA.CausalityAssessment","REPC_MT000005CA.CausalityAssessment","REPC_MT000006CA.CausalityAssessment","REPC_MT000009CA.CausalityAssessment","REPC_MT000012CA.CausalityAssessment","REPC_MT000013CA.CausalityAssessment"})
public class ReactionAssessmentsBean extends MessagePartBean implements Records {

    private static final long serialVersionUID = 20120130L;
    private CD code = new CDImpl();
    private CV value = new CVImpl();
    private ExposuresBean startsAfterStartOfExposureEvent;
    private ObservationEventBean subjectObservationEvent;


    /**
     * <p>AssessmentType</p>
     * 
     * <p>Assessment Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>RelatednessAssessment</p>
     * 
     * <p>Relatedness Assessment</p>
     * 
     * <p>Relatedness Assessment</p>
     * 
     * <p><p><strong>Because PIN is not using SNOMED, this is fixed 
     * to "RELATED"</strong></p></p>
     */
    @Hl7XmlMapping({"value"})
    public ObservationValue getValue() {
        return (ObservationValue) this.value.getValue();
    }
    public void setValue(ObservationValue value) {
        this.value.setValue(value);
    }


    @Hl7XmlMapping({"startsAfterStartOf/exposureEvent"})
    public ExposuresBean getStartsAfterStartOfExposureEvent() {
        return this.startsAfterStartOfExposureEvent;
    }
    public void setStartsAfterStartOfExposureEvent(ExposuresBean startsAfterStartOfExposureEvent) {
        this.startsAfterStartOfExposureEvent = startsAfterStartOfExposureEvent;
    }


    @Hl7XmlMapping({"subject/observationEvent"})
    public ObservationEventBean getSubjectObservationEvent() {
        return this.subjectObservationEvent;
    }
    public void setSubjectObservationEvent(ObservationEventBean subjectObservationEvent) {
        this.subjectObservationEvent = subjectObservationEvent;
    }

}
