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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.AllergyIntoleranceSeverityLevelBean;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT000001CA.CausalityAssessment","REPC_MT000001CA.ObservationEvent","REPC_MT000002CA.CausalityAssessment","REPC_MT000005CA.CausalityAssessment","REPC_MT000005CA.ObservationEvent","REPC_MT000006CA.CausalityAssessment","REPC_MT000009CA.CausalityAssessment","REPC_MT000009CA.ObservationEvent","REPC_MT000012CA.CausalityAssessment","REPC_MT000013CA.CausalityAssessment","REPC_MT000013CA.ObservationEvent"})
public class ReportedReactionsBean extends MessagePartBean implements Records {

    private static final long serialVersionUID = 20111117L;
    private CD code = new CDImpl();
    private CV value = new CVImpl();
    private ExposuresBean startsAfterStartOfExposureEvent;
    private ReportedReactionsBean subjectObservationEvent;
    private II id = new IIImpl();
    private BL negationInd = new BLImpl();
    private ST text = new STImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
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
     * <p>Relatedness Assessment</p>
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
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>NoReactionOccurred</p>
     * 
     * <p>D:No reaction occurred</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Description</p>
     * 
     * <p>G:Description</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>ReactionOnsetDate</p>
     * 
     * <p>F:Reaction Onset Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"subjectOf/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOfSeverityObservation() {
        return this.subjectOfSeverityObservation;
    }
    public void setSubjectOfSeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation) {
        this.subjectOfSeverityObservation = subjectOfSeverityObservation;
    }

}
