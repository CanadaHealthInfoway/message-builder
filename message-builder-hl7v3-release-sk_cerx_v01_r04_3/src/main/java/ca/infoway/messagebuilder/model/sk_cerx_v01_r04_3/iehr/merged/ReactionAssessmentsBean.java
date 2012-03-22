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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.repc_mt000001ca.ObservationEventBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.AllergyIntoleranceSeverityLevelBean;
import java.util.Date;



/**
 * <p>REPC_MT000012CA.CausalityAssessment: Reaction Assessments</p>
 * 
 * <p><p>If code is SNOMED, value is not permitted. Otherise 
 * code must be RXNASSESS and value must be RELATED</p></p>
 * 
 * <p><p>This is a recording of the exposures and causality 
 * assessment deemed to be related to the reaction.</p></p>
 * 
 * <p><p>Indicates both the product and how related they are 
 * determined to be to the reaction.</p></p>
 * 
 * <p>REPC_MT000006CA.CausalityAssessment: Reaction Assessments</p>
 * 
 * <p><p>Value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to RXNASSESS if not using SNOMED</p></p>
 * 
 * <p><p>Value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to RXNASSESS if not using SNOMED</p></p>
 * 
 * <p><p>This is a recording of the exposures and causality 
 * assessment deemed to be related to the reaction.</p></p>
 * 
 * <p><p>Indicates both the product and how related they are 
 * determined to be to the reaction.</p></p>
 * 
 * <p>REPC_MT000005CA.ObservationEvent: Reported Reactions</p>
 * 
 * <p><p>Value must be mandatory if not using SNOMED</p><p>Code 
 * must be fixed to DX if not using SNOMED</p></p>
 * 
 * <p><p>Value must be mandatory if not using SNOMED</p><p>Code 
 * must be fixed to DX if not using SNOMED</p></p>
 * 
 * <p><p>This is a recording of a patient reaction that is 
 * believed to be associated with the allergy/intolerance.</p></p>
 * 
 * <p><p>Helps providers to distinguish between proper 
 * allergies and intolerances. Allows the provider recording 
 * the allergy to assign appropriate severity to the allergy. 
 * May give insight on how to mitigate an intolerance that is 
 * likely to be triggered by administering a substance. (E.g. 
 * If a given drug typically causes nausea in the patient, an 
 * additional medication may be co-prescribed to manage the 
 * nausea.)</p></p>
 * 
 * <p>REPC_MT000002CA.CausalityAssessment: Reaction Assessments</p>
 * 
 * <p><p>value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to RXNASSESS if not using SNOMED</p></p>
 * 
 * <p><p>value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to RXNASSESS if not using SNOMED</p></p>
 * 
 * <p><p>This is a recording of the exposures and causality 
 * assessment deemed to be related to the reaction.</p></p>
 * 
 * <p><p>Indicates both the product and how related they are 
 * determined to be to the reaction.</p></p>
 * 
 * <p>REPC_MT000001CA.CausalityAssessment: Reported Reactions</p>
 * 
 * <p><p>Value is required if not using SNOMED</p><p>Reaction 
 * Assessment code must be fixed to RXNASSESS if not using 
 * SNOMED</p></p>
 * 
 * <p><p>Value is required if not using SNOMED</p><p>Reaction 
 * Assessment code must be fixed to RXNASSESS if not using 
 * SNOMED</p></p>
 * 
 * <p><p>This is a recording of a patient reaction that is 
 * believed to be associated with the allergy/intolerance.</p></p>
 * 
 * <p><p>Helps providers to distinguish between proper 
 * allergies and intolerances. Allows the provider recording 
 * the allergy to assign appropriate severity to the allergy. 
 * May give insight on how to mitigate an intolerance that is 
 * likely to be triggered by administering a substance. (E.g. 
 * If a given drug typically causes nausea in the patient, an 
 * additional medication may be co-prescribed to manage the 
 * nausea.)</p></p>
 * 
 * <p>REPC_MT000009CA.ObservationEvent: (no business name)</p>
 * 
 * <p><p>Value must not be present when using SNOMED, mandatory 
 * otherwise</p></p>
 * 
 * <p>REPC_MT000013CA.ObservationEvent: (no business name)</p>
 * 
 * <p><p>If code is SNOMED, value is not permitted, otherwise 
 * it is mandatory and code must be DX</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.CausalityAssessment","REPC_MT000002CA.CausalityAssessment","REPC_MT000005CA.ObservationEvent","REPC_MT000006CA.CausalityAssessment","REPC_MT000009CA.ObservationEvent","REPC_MT000012CA.CausalityAssessment","REPC_MT000013CA.ObservationEvent"})
public class ReactionAssessmentsBean extends MessagePartBean implements Records {

    private static final long serialVersionUID = 20120322L;
    private CD code = new CDImpl();
    private CV value = new CVImpl();
    private ExposuresBean startsAfterStartOfExposureEvent;
    private II id = new IIImpl();
    private BL negationInd = new BLImpl();
    private ST text = new STImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation;
    private ObservationEventBean subjectObservationEvent;


    /**
     * <p>Diagnosis Type</p>
     * 
     * <p><p>Indicates the type of diagnosis being captured.</p></p>
     * 
     * <p><p>Indicates that the observation is actually a diagnosis 
     * and is therefore mandatory. The datatype is CD to support 
     * SNOMED post-coordination.</p></p>
     * 
     * <p><p>If using SNOMED, this will contain the diagnosis. 
     * Otherwise it will be a fixed value of 'DX'.</p></p>
     * 
     * <p>Assessment Type</p>
     * 
     * <p><p>Indicates the type of assessment being made</p></p>
     * 
     * <p><p>Communicates the relatedness assessment of the 
     * exposure to the reaction and is therefore mandatory. For 
     * SNOMED this will communicate the full assessment. It is 
     * expressed as a CD to allow for SNOMED post-coordination.</p></p>
     * 
     * <p><p>For SNOMED this will include the actual assessment. 
     * For non-SNOMED, this should be fixed to RXNASSESS.</p></p>
     * 
     * <p>Assessment Type</p>
     * 
     * <p><p>Indicates the type of assessment being made</p></p>
     * 
     * <p><p>Communicates the relatedness assessment of the 
     * exposure to the reaction and is therefore mandatory. For 
     * SNOMED this will communicate the full assessment. It is 
     * expressed as a CD to allow for SNOMED post-coordination.</p></p>
     * 
     * <p><p>For SNOMED this will include the actual assessment. 
     * For non-SNOMED, this should be fixed to RXNASSES.</p></p>
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
     * <p><p>Indicates whether the reaction is deemed to be related 
     * to the exposure.</p></p>
     * 
     * <p><p>Creates the link between the exposure and the 
     * reaction. Because the details of the assessment will be 
     * communicated in the 'code' attribute for SNOMED, this 
     * element is optional.</p></p>
     * 
     * <p><p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p></p>
     * 
     * <p><p><strong>Because PIN is not using SNOMED, this is fixed 
     * to "RELATED"</strong></p></p>
     * 
     * <p>B:Reaction</p>
     * 
     * <p><p>Specifies the kind of reaction, as experienced by the 
     * patient.</p></p>
     * 
     * <p><p>B.1</p></p>
     * 
     * <p><p>Ensures consistency in tracking and categorizing the 
     * reaction type. Helps ensure that only proper allergies are 
     * categorized as allergy. The attribute is optional because it 
     * will not be used for SNOMED. The attribute is CWE because 
     * not all possible types of reactions are expressible by coded 
     * values.</p></p>
     * 
     * <p>Relatedness Assessment</p>
     * 
     * <p><p>Indicates whether the reaction is deemed to be related 
     * to the exposure.</p></p>
     * 
     * <p><p>Creates the link between the exposure and the 
     * reaction. Because the details of the assessment will be 
     * communicated in the 'code' attribute for SNOMED, this 
     * element is optional.</p></p>
     * 
     * <p><p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public SubjectReaction getValue() {
        return (SubjectReaction) this.value.getValue();
    }
    public void setValue(SubjectReaction value) {
        this.value.setValue(value);
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p></font></font></font></p></p>
     */
    @Hl7XmlMapping({"startsAfterStartOf/exposureEvent"})
    public ExposuresBean getStartsAfterStartOfExposureEvent() {
        return this.startsAfterStartOfExposureEvent;
    }
    public void setStartsAfterStartOfExposureEvent(ExposuresBean startsAfterStartOfExposureEvent) {
        this.startsAfterStartOfExposureEvent = startsAfterStartOfExposureEvent;
    }


    /**
     * <p>ReactionRecordId</p>
     * 
     * <p>C:Reaction Record Id</p>
     * 
     * <p><p>An identifier assigned to the record of the adverse 
     * reaction.</p></p>
     * 
     * <p><p>Allows for direct referencing of an adverse reaction 
     * record which was previously recorded.</p></p>
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
     * 
     * <p><p>Indicates that there was no adverse reaction when the 
     * patient was exposed to the agent to which an 
     * allergy/intolerance has been recorded.</p></p>
     * 
     * <p><p>Allows providers to confirm or eliminate specific 
     * agents as being the cause for the allergy/intolerance. E.g. 
     * If a reaction is recorded for Tylenol 3, but no reaction is 
     * recorded for regular Tylenol or for coffee, this suggests 
     * that the likely cause of the allergy is 
     * Codeine.</p><p>Because it is essential to know whether the 
     * reaction occurred or not, this attribute is mandatory.</p></p>
     * 
     * <p><p>Allows providers to confirm or eliminate specific 
     * agents as being the cause for the allergy/intolerance. E.g. 
     * If a reaction is recorded for Tylenol 3, but no reaction is 
     * recorded for regular Tylenol or for coffee, this suggests 
     * that the likely cause of the allergy is 
     * Codeine.</p><p>Because it is essential to know whether the 
     * reaction occurred or not, this attribute is mandatory.</p></p>
     * 
     * <p>D:No reaction occurred</p>
     * 
     * <p><p>Indicates that there was no adverse reaction when the 
     * patient was exposed to the agent to which an 
     * allergy/intolerance has been recorded.</p></p>
     * 
     * <p><p>Allows providers to confirm or eliminate specific 
     * agents as being the cause for the allergy/intolerance. E.g. 
     * If a reaction is recorded for Tylenol 3, but no reaction is 
     * recorded for regular Tylenol or for coffee, this suggests 
     * that the likely cause of the allergy is 
     * Codeine.</p><p>Because it is essential to know whether the 
     * record reflects a reaction that did or did not occur, this 
     * attribute is mandatory.</p></p>
     * 
     * <p><p>Allows providers to confirm or eliminate specific 
     * agents as being the cause for the allergy/intolerance. E.g. 
     * If a reaction is recorded for Tylenol 3, but no reaction is 
     * recorded for regular Tylenol or for coffee, this suggests 
     * that the likely cause of the allergy is 
     * Codeine.</p><p>Because it is essential to know whether the 
     * record reflects a reaction that did or did not occur, this 
     * attribute is mandatory.</p></p>
     * 
     * <p>D:No reaction occurred</p>
     * 
     * <p><p>Indicates if there there was an adverse reaction when 
     * the patient was exposed to the agent to which an 
     * allergy/intolerance has been recorded.</p></p>
     * 
     * <p><p>Allows providers to confirm or eliminate specific 
     * agents as being the cause for the allergy/intolerance. E.g. 
     * If a reaction is recorded for Tylenol 3, but no reaction is 
     * recorded for regular Tylenol or for coffee, this suggests 
     * that the likely cause of the allergy is Codeine.</p><p>The 
     * attribute is mandatory because it is essential to know 
     * whether the reaction occurred or not.</p></p>
     * 
     * <p><p>Allows providers to confirm or eliminate specific 
     * agents as being the cause for the allergy/intolerance. E.g. 
     * If a reaction is recorded for Tylenol 3, but no reaction is 
     * recorded for regular Tylenol or for coffee, this suggests 
     * that the likely cause of the allergy is Codeine.</p><p>The 
     * attribute is mandatory because it is essential to know 
     * whether the reaction occurred or not.</p></p>
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
     * 
     * <p><p>A free form description of the reaction.</p></p>
     * 
     * <p><p>B.4</p></p>
     * 
     * <p><p>Allows for flexibility in the recording and reporting 
     * of the reaction.</p></p>
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
     * 
     * <p><p>The date on which the reaction occurrence began.</p></p>
     * 
     * <p><p>Indicates when evidence of the condition first 
     * appeared. May also provide information on the duration of 
     * the reaction.</p></p>
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


    /**
     * <p>ReactionRecord</p>
     * 
     * <p>Reaction Record</p>
     * 
     * <p><p>For the Reaction Record Identifier, 
     * observationEvent.id: This will be the identifier of a 
     * previously-created Adverse Drug Reaction record. Since PIN 
     * does not currently support the creation of Adverse Drug 
     * Reaction records, this field can not be populated with a 
     * valid PIN identifier. <strong>If this field is sent, a 
     * KEY204 error issue will be returned.</strong></p></p>
     */
    @Hl7XmlMapping({"subject/observationEvent"})
    public ObservationEventBean getSubjectObservationEvent() {
        return this.subjectObservationEvent;
    }
    public void setSubjectObservationEvent(ObservationEventBean subjectObservationEvent) {
        this.subjectObservationEvent = subjectObservationEvent;
    }

}
