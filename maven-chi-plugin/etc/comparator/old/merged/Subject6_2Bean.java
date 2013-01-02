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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ObservationValue;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT000002CA.Subject6","REPC_MT000006CA.Subject6","REPC_MT000012CA.Subject6"})
public class Subject6_2Bean extends MessagePartBean {

    private CD<ActCode> assessmentType = new CDImpl<ActCode>();
    private CV<ObservationValue> relatednessAssessment = new CVImpl<ObservationValue>();
    private StartsAfterStartOf_2Bean causalityAssessmentStartsAfterStartOf = new StartsAfterStartOf_2Bean();
    private Subject6_1Bean causalityAssessmentSubject = new Subject6_1Bean();
    private II reactionRecordId = new IIImpl();
    private BL noReactionOccurred = new BLImpl();
    private ST description = new STImpl();
    private IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();
    private CV<SeverityObservation> severityLevel = new CVImpl<SeverityObservation>();

    @Hl7XmlMapping({"causalityAssessment/code"})
    public ActCode getAssessmentType() {
        return this.assessmentType.getValue();
    }
    public void setAssessmentType(ActCode assessmentType) {
        this.assessmentType.setValue(assessmentType);
    }

    @Hl7XmlMapping({"causalityAssessment/value"})
    public ObservationValue getRelatednessAssessment() {
        return this.relatednessAssessment.getValue();
    }
    public void setRelatednessAssessment(ObservationValue relatednessAssessment) {
        this.relatednessAssessment.setValue(relatednessAssessment);
    }

    @Hl7XmlMapping({"causalityAssessment/startsAfterStartOf"})
    public StartsAfterStartOf_2Bean getCausalityAssessmentStartsAfterStartOf() {
        return this.causalityAssessmentStartsAfterStartOf;
    }
    public void setCausalityAssessmentStartsAfterStartOf(StartsAfterStartOf_2Bean causalityAssessmentStartsAfterStartOf) {
        this.causalityAssessmentStartsAfterStartOf = causalityAssessmentStartsAfterStartOf;
    }

    @Hl7XmlMapping({"causalityAssessment/subject"})
    public Subject6_1Bean getCausalityAssessmentSubject() {
        return this.causalityAssessmentSubject;
    }
    public void setCausalityAssessmentSubject(Subject6_1Bean causalityAssessmentSubject) {
        this.causalityAssessmentSubject = causalityAssessmentSubject;
    }

    @Hl7XmlMapping({"causalityAssessment/id"})
    public Identifier getReactionRecordId() {
        return this.reactionRecordId.getValue();
    }
    public void setReactionRecordId(Identifier reactionRecordId) {
        this.reactionRecordId.setValue(reactionRecordId);
    }

    @Hl7XmlMapping({"causalityAssessment/negationInd"})
    public java.lang.Boolean getNoReactionOccurred() {
        return this.noReactionOccurred.getValue();
    }
    public void setNoReactionOccurred(java.lang.Boolean noReactionOccurred) {
        this.noReactionOccurred.setValue(noReactionOccurred);
    }

    @Hl7XmlMapping({"causalityAssessment/text"})
    public java.lang.String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(java.lang.String description) {
        this.description.setValue(description);
    }

    @Hl7XmlMapping({"causalityAssessment/effectiveTime"})
    public Interval<Date> getReactionOnsetDate() {
        return this.reactionOnsetDate.getValue();
    }
    public void setReactionOnsetDate(Interval<Date> reactionOnsetDate) {
        this.reactionOnsetDate.setValue(reactionOnsetDate);
    }

    @Hl7XmlMapping({"causalityAssessment/subjectOf/severityObservation/value"})
    public SeverityObservation getSeverityLevel() {
        return this.severityLevel.getValue();
    }
    public void setSeverityLevel(SeverityObservation severityLevel) {
        this.severityLevel.setValue(severityLevel);
    }

}
