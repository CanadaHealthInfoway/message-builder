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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged;

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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.AllergyIntoleranceSeverityLevelBean;
import java.util.Date;



/**
 * <p>REPC_MT000001CA.CausalityAssessment: (no business name)</p>
 * 
 * <p><p>This is a recording of a patient reaction that is 
 * believed to be associated with the allergy/intolerance.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.CausalityAssessment","REPC_MT000001CA.ObservationEvent","REPC_MT000002CA.CausalityAssessment","REPC_MT000005CA.CausalityAssessment","REPC_MT000005CA.ObservationEvent","REPC_MT000006CA.CausalityAssessment","REPC_MT000009CA.CausalityAssessment","REPC_MT000009CA.ObservationEvent","REPC_MT000012CA.CausalityAssessment","REPC_MT000013CA.CausalityAssessment","REPC_MT000013CA.ObservationEvent"})
public class ReportedReactionsBean extends MessagePartBean implements Records {

    private static final long serialVersionUID = 20110901L;
    private CD code = new CDImpl();
    private CV value = new CVImpl();
    private ExposuresBean startsAfterStartOfExposureEvent;
    private ReportedReactionsBean subjectObservationEvent;
    private II reactionRecordId = new IIImpl();
    private BL noReactionOccurred = new BLImpl();
    private ST description = new STImpl();
    private IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();
    private AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation;


    /**
     * <p>Diagnosis Type</p>
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
     * <p>Reaction</p>
     * 
     * <p><p><strong>Specifies the kind of reaction, as experienced 
     * by the patient. Because PIN does not support ADRs, this 
     * field is now mandatory.</strong></p></p>
     * 
     * <p>Relatedness Assessment</p>
     * 
     * <p>(no business name)</p>
     * 
     * <p><p><strong>Because PIN is not using SNOMED, this is fixed 
     * to "RELATED"</strong></p></p>
     * 
     * <p>B:Reaction</p>
     */
    @Hl7XmlMapping({"value"})
    public SubjectReaction getValue() {
        return (SubjectReaction) this.value.getValue();
    }
    public void setValue(SubjectReaction value) {
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
    public ReportedReactionsBean getSubjectObservationEvent() {
        return this.subjectObservationEvent;
    }
    public void setSubjectObservationEvent(ReportedReactionsBean subjectObservationEvent) {
        this.subjectObservationEvent = subjectObservationEvent;
    }


    /**
     * <p>ReactionRecordId</p>
     * 
     * <p>C:Reaction Record Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getReactionRecordId() {
        return this.reactionRecordId.getValue();
    }
    public void setReactionRecordId(Identifier reactionRecordId) {
        this.reactionRecordId.setValue(reactionRecordId);
    }


    /**
     * <p>NoReactionOccurred</p>
     * 
     * <p>D:No reaction occurred</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNoReactionOccurred() {
        return this.noReactionOccurred.getValue();
    }
    public void setNoReactionOccurred(Boolean noReactionOccurred) {
        this.noReactionOccurred.setValue(noReactionOccurred);
    }


    /**
     * <p>Description</p>
     * 
     * <p>G:Description</p>
     */
    @Hl7XmlMapping({"text"})
    public String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(String description) {
        this.description.setValue(description);
    }


    /**
     * <p>ReactionOnsetDate</p>
     * 
     * <p>F:Reaction Onset Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getReactionOnsetDate() {
        return this.reactionOnsetDate.getValue();
    }
    public void setReactionOnsetDate(Interval<Date> reactionOnsetDate) {
        this.reactionOnsetDate.setValue(reactionOnsetDate);
    }


    @Hl7XmlMapping({"subjectOf/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOfSeverityObservation() {
        return this.subjectOfSeverityObservation;
    }
    public void setSubjectOfSeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation) {
        this.subjectOfSeverityObservation = subjectOfSeverityObservation;
    }

}
