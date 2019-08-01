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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.merged;

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
 * <p>REPC_MT000006CA.CausalityAssessment: Reaction Assessments</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to RXNASSESS if not using SNOMED</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to RXNASSESS if not using SNOMED</p>
 * 
 * <p>This is a recording of the exposures and causality 
 * assessment deemed to be related to the reaction.</p>
 * 
 * <p>Indicates both the product and how related they are 
 * determined to be to the reaction.</p>
 * 
 * <p>REPC_MT000001CA.CausalityAssessment: Reported Reactions</p>
 * 
 * <p>Value is required if not using SNOMED</p><p>Reaction 
 * Assessment code must be fixed to RXNASSESS if not using 
 * SNOMED</p>
 * 
 * <p>Value is required if not using SNOMED</p><p>Reaction 
 * Assessment code must be fixed to RXNASSESS if not using 
 * SNOMED</p>
 * 
 * <p>This is a recording of a patient reaction that is 
 * believed to be associated with the allergy/intolerance.</p>
 * 
 * <p>Helps providers to distinguish between proper allergies 
 * and intolerances. Allows the provider recording the allergy 
 * to assign appropriate severity to the allergy. May give 
 * insight on how to mitigate an intolerance that is likely to 
 * be triggered by administering a substance. (E.g. If a given 
 * drug typically causes nausea in the patient, an additional 
 * medication may be co-prescribed to manage the nausea.)</p>
 * 
 * <p>REPC_MT000013CA.CausalityAssessment: Reported Reactions</p>
 * 
 * <p>If code is SNOMED, value is not permitted otherwise code 
 * must be RXNASSESS and value must be RELATED</p>
 * 
 * <p>This is a recording of a patient reaction that is 
 * believed to be associated with the allergy/intolerance.</p>
 * 
 * <p>Helps providers to distinguish between proper allergies 
 * and intolerances. Allows the provider recording the allergy 
 * to assign appropriate severity to the allergy. May give 
 * insight on how to mitigate an intolerance that is likely to 
 * be triggered by administering a substance. (E.g. If a given 
 * drug typically causes nausea in the patient, an additional 
 * medication may be co-prescribed to manage the nausea.)</p>
 * 
 * <p>REPC_MT000005CA.CausalityAssessment: Reported Reactions</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p><p>Code must be 
 * fixed to RXNASSESS if not using SNOMED</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p><p>Code must be 
 * fixed to RXNASSESS if not using SNOMED</p>
 * 
 * <p>This is a recording of a patient reaction that is 
 * believed to be associated with the allergy/intolerance.</p>
 * 
 * <p>Helps providers to distinguish between proper allergies 
 * and intolerances. Allows the provider recording the allergy 
 * to assign appropriate severity to the allergy. May give 
 * insight on how to mitigate an intolerance that is likely to 
 * be triggered by administering a substance. (E.g. If a given 
 * drug typically causes nausea in the patient, an additional 
 * medication may be co-prescribed to manage the nausea.)</p>
 * 
 * <p>REPC_MT000009CA.CausalityAssessment: Reported Reactions</p>
 * 
 * <p>Value is required if not using SNOME code must be 
 * RXNASSESS if not SNOMED</p>
 * 
 * <p>This is a recording of a patient reaction that is 
 * believed to be associated with the allergy/intolerance.</p>
 * 
 * <p>Helps providers to distinguish between proper allergies 
 * and intolerances. Allows the provider recording the allergy 
 * to assign appropriate severity to the allergy. May give 
 * insight on how to mitigate an intolerance that is likely to 
 * be triggered by administering a substance. (E.g. If a given 
 * drug typically causes nausea in the patient, an additional 
 * medication may be co-prescribed to manage the nausea.)</p>
 * 
 * <p>REPC_MT000012CA.CausalityAssessment: Reaction Assessments</p>
 * 
 * <p>If code is SNOMED, value is not permitted. Otherise code 
 * must be RXNASSESS and value must be RELATED</p>
 * 
 * <p>This is a recording of the exposures and causality 
 * assessment deemed to be related to the reaction.</p>
 * 
 * <p>Indicates both the product and how related they are 
 * determined to be to the reaction.</p>
 * 
 * <p>REPC_MT000002CA.CausalityAssessment: Reaction Assessments</p>
 * 
 * <p>value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to RXNASSESS if not using SNOMED</p>
 * 
 * <p>value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to RXNASSESS if not using SNOMED</p>
 * 
 * <p>This is a recording of the exposures and causality 
 * assessment deemed to be related to the reaction.</p>
 * 
 * <p>Indicates both the product and how related they are 
 * determined to be to the reaction.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.CausalityAssessment","REPC_MT000002CA.CausalityAssessment","REPC_MT000005CA.CausalityAssessment","REPC_MT000006CA.CausalityAssessment","REPC_MT000009CA.CausalityAssessment","REPC_MT000012CA.CausalityAssessment","REPC_MT000013CA.CausalityAssessment"})
public class ReactionAssessmentsBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt000005ca.Records, ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt000013ca.Records, ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt000009ca.Records, ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt000001ca.Records {

    private static final long serialVersionUID = 20190731L;
    private CD code = new CDImpl();
    private CV value = new CVImpl();
    private ExposuresBean startsAfterStartOfExposureEvent;
    private ObservationEventBean subjectObservationEvent;


    /**
     * <p>Business Name: AssessmentType</p>
     * 
     * <p>Un-merged Business Name: AssessmentType</p>
     * 
     * <p>Relationship: REPC_MT000006CA.CausalityAssessment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of assessment being made</p>
     * 
     * <p>Communicates the relatedness assessment of the exposure 
     * to the reaction and is therefore mandatory. For SNOMED this 
     * will communicate the full assessment. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>For SNOMED this will include the actual assessment. For 
     * non-SNOMED, this should be fixed to RXNASSESS.</p>
     * 
     * <p>Un-merged Business Name: AssessmentType</p>
     * 
     * <p>Relationship: REPC_MT000012CA.CausalityAssessment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of assessment being made</p>
     * 
     * <p>Communicates the relatedness assessment of the exposure 
     * to the reaction and is therefore mandatory. For SNOMED this 
     * will communicate the full assessment. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>For SNOMED this will include the actual assessment. For 
     * non-SNOMED, this should be fixed to RXNASSES.</p>
     * 
     * <p>Un-merged Business Name: AssessmentType</p>
     * 
     * <p>Relationship: REPC_MT000002CA.CausalityAssessment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of assessment being made</p>
     * 
     * <p>Communicates the relatedness assessment of the exposure 
     * to the reaction and is therefore mandatory. For SNOMED this 
     * will communicate the full assessment. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>For SNOMED this will include the actual assessment. For 
     * non-SNOMED, this should be fixed to RXNASSES.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: AssessmentType</p>
     * 
     * <p>Un-merged Business Name: AssessmentType</p>
     * 
     * <p>Relationship: REPC_MT000006CA.CausalityAssessment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of assessment being made</p>
     * 
     * <p>Communicates the relatedness assessment of the exposure 
     * to the reaction and is therefore mandatory. For SNOMED this 
     * will communicate the full assessment. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>For SNOMED this will include the actual assessment. For 
     * non-SNOMED, this should be fixed to RXNASSESS.</p>
     * 
     * <p>Un-merged Business Name: AssessmentType</p>
     * 
     * <p>Relationship: REPC_MT000012CA.CausalityAssessment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of assessment being made</p>
     * 
     * <p>Communicates the relatedness assessment of the exposure 
     * to the reaction and is therefore mandatory. For SNOMED this 
     * will communicate the full assessment. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>For SNOMED this will include the actual assessment. For 
     * non-SNOMED, this should be fixed to RXNASSES.</p>
     * 
     * <p>Un-merged Business Name: AssessmentType</p>
     * 
     * <p>Relationship: REPC_MT000002CA.CausalityAssessment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of assessment being made</p>
     * 
     * <p>Communicates the relatedness assessment of the exposure 
     * to the reaction and is therefore mandatory. For SNOMED this 
     * will communicate the full assessment. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>For SNOMED this will include the actual assessment. For 
     * non-SNOMED, this should be fixed to RXNASSES.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: RelatednessAssessment</p>
     * 
     * <p>Un-merged Business Name: RelatednessAssessment</p>
     * 
     * <p>Relationship: REPC_MT000006CA.CausalityAssessment.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates whether the reaction is deemed to be related to 
     * the exposure.</p>
     * 
     * <p>Creates the link between the exposure and the reaction. 
     * Because the details of the assessment will be communicated 
     * in the 'code' attribute for SNOMED, this element is 
     * optional.</p>
     * 
     * <p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p>
     * 
     * <p>Un-merged Business Name: RelatednessAssessment</p>
     * 
     * <p>Relationship: REPC_MT000001CA.CausalityAssessment.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether the reaction is deemed to be related to 
     * the exposure.</p>
     * 
     * <p>Creates the link between the exposure and the reaction. 
     * Because the details of the assessment will be communicated 
     * in the 'code' attribute for SNOMED, this element is 
     * optional.</p>
     * 
     * <p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p>
     * 
     * <p><strong>Because PIN is not using SNOMED, this is fixed to 
     * "RELATED"</strong></p>
     * 
     * <p>Un-merged Business Name: RelatednessAssessment</p>
     * 
     * <p>Relationship: REPC_MT000012CA.CausalityAssessment.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates whether the reaction is deemed to be related to 
     * the exposure.</p>
     * 
     * <p>Creates the link between the exposure and the reaction. 
     * Because the details of the assessment will be communicated 
     * in the 'code' attribute for SNOMED, this element is 
     * optional.</p>
     * 
     * <p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p>
     * 
     * <p>Un-merged Business Name: RelatednessAssessment</p>
     * 
     * <p>Relationship: REPC_MT000002CA.CausalityAssessment.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates whether the reaction is deemed to be related to 
     * the exposure.</p>
     * 
     * <p>Creates the link between the exposure and the reaction. 
     * Because the details of the assessment will be communicated 
     * in the 'code' attribute for SNOMED, this element is 
     * optional.</p>
     * 
     * <p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p>
     */
    @Hl7XmlMapping({"value"})
    public ObservationValue getValue() {
        return (ObservationValue) this.value.getValue();
    }

    /**
     * <p>Business Name: RelatednessAssessment</p>
     * 
     * <p>Un-merged Business Name: RelatednessAssessment</p>
     * 
     * <p>Relationship: REPC_MT000006CA.CausalityAssessment.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates whether the reaction is deemed to be related to 
     * the exposure.</p>
     * 
     * <p>Creates the link between the exposure and the reaction. 
     * Because the details of the assessment will be communicated 
     * in the 'code' attribute for SNOMED, this element is 
     * optional.</p>
     * 
     * <p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p>
     * 
     * <p>Un-merged Business Name: RelatednessAssessment</p>
     * 
     * <p>Relationship: REPC_MT000001CA.CausalityAssessment.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether the reaction is deemed to be related to 
     * the exposure.</p>
     * 
     * <p>Creates the link between the exposure and the reaction. 
     * Because the details of the assessment will be communicated 
     * in the 'code' attribute for SNOMED, this element is 
     * optional.</p>
     * 
     * <p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p>
     * 
     * <p><strong>Because PIN is not using SNOMED, this is fixed to 
     * "RELATED"</strong></p>
     * 
     * <p>Un-merged Business Name: RelatednessAssessment</p>
     * 
     * <p>Relationship: REPC_MT000012CA.CausalityAssessment.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates whether the reaction is deemed to be related to 
     * the exposure.</p>
     * 
     * <p>Creates the link between the exposure and the reaction. 
     * Because the details of the assessment will be communicated 
     * in the 'code' attribute for SNOMED, this element is 
     * optional.</p>
     * 
     * <p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p>
     * 
     * <p>Un-merged Business Name: RelatednessAssessment</p>
     * 
     * <p>Relationship: REPC_MT000002CA.CausalityAssessment.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates whether the reaction is deemed to be related to 
     * the exposure.</p>
     * 
     * <p>Creates the link between the exposure and the reaction. 
     * Because the details of the assessment will be communicated 
     * in the 'code' attribute for SNOMED, this element is 
     * optional.</p>
     * 
     * <p>This attribute will not be populated if using SNOMED. 
     * Otherwise it should have a fixed value of 
     * &quot;RELATED&quot;.</p>
     */
    public void setValue(ObservationValue value) {
        this.value.setValue(value);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p> </p><p align="left">Indicates the agent that is believed 
     * to have caused the adverse reaction.</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000005CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000002CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"startsAfterStartOf/exposureEvent"})
    public ExposuresBean getStartsAfterStartOfExposureEvent() {
        return this.startsAfterStartOfExposureEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p> </p><p align="left">Indicates the agent that is believed 
     * to have caused the adverse reaction.</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000005CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000002CA.StartsAfterStartOf.exposureEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStartsAfterStartOfExposureEvent(ExposuresBean startsAfterStartOfExposureEvent) {
        this.startsAfterStartOfExposureEvent = startsAfterStartOfExposureEvent;
    }


    /**
     * <p>Business Name: ReactionRecord</p>
     * 
     * <p>Un-merged Business Name: ReactionRecord</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Subject6.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For the Reaction Record Identifier, observationEvent.id: 
     * This will be the identifier of a previously-created Adverse 
     * Drug Reaction record. Since PIN does not currently support 
     * the creation of Adverse Drug Reaction records, this field 
     * can not be populated with a valid PIN identifier. <strong>If 
     * this field is sent, a KEY204 error issue will be 
     * returned.</strong></p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000013CA.Subject6.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Subject6.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Subject6.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/observationEvent"})
    public ObservationEventBean getSubjectObservationEvent() {
        return this.subjectObservationEvent;
    }

    /**
     * <p>Business Name: ReactionRecord</p>
     * 
     * <p>Un-merged Business Name: ReactionRecord</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Subject6.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For the Reaction Record Identifier, observationEvent.id: 
     * This will be the identifier of a previously-created Adverse 
     * Drug Reaction record. Since PIN does not currently support 
     * the creation of Adverse Drug Reaction records, this field 
     * can not be populated with a valid PIN identifier. <strong>If 
     * this field is sent, a KEY204 error issue will be 
     * returned.</strong></p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000013CA.Subject6.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Subject6.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Subject6.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectObservationEvent(ObservationEventBean subjectObservationEvent) {
        this.subjectObservationEvent = subjectObservationEvent;
    }

}
