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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.repc_mt000012ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged.ReportedReactionsBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.AllergyIntoleranceSeverityLevelBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Reported Reaction</p>
 * 
 * <p>Value must be mandatory if not using SNOMED</p>
 * 
 * <p>Code must be fixed to DX if not using SNOMED</p>
 * 
 * <p>Useful in tracking reactions when it is not known 
 * precisely what product they are associated with and whether 
 * the reaction is due to an allergy or intolerance, a drug 
 * interaction or some other cause. Effectively gives a 'heads 
 * up' to clinicians using the drug or combination of 
 * drugs.</p>
 * 
 * <p>This is a record of an adverse reaction considered 
 * relevant to the patient's clinical record.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000012CA.ReactionObservationEvent"})
@Hl7RootType
public class ReportedReactionBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private CV value = new CVImpl();
    private PatientBean subjectPatient;
    private ReportedByBean informant;
    private AllergyIntoleranceSeverityLevelBean subjectOf1SeverityObservation;
    private List<ReportedReactionsBean> subjectOf2CausalityAssessment = new ArrayList<ReportedReactionsBean>();


    /**
     * <p>Business Name: C:Reaction Record Id</p>
     * 
     * <p>Relationship: REPC_MT000012CA.ReactionObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Uniquely identifies the specific reaction record and is 
     * therefore mandatory.</p>
     * 
     * <p>An identifier assigned to the record of the adverse 
     * reaction.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: C:Reaction Record Id</p>
     * 
     * <p>Relationship: REPC_MT000012CA.ReactionObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Uniquely identifies the specific reaction record and is 
     * therefore mandatory.</p>
     * 
     * <p>An identifier assigned to the record of the adverse 
     * reaction.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Diagnosis Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the observation is actually a diagnosis 
     * and is therefore mandatory. The datatype is CD to support 
     * SNOMED post-coordination.</p>
     * 
     * <p>If using SNOMED, this will contain the diagnosis. 
     * Otherwise it will be a fixed value of 'DX'.</p>
     * 
     * <p>Indicates the type of diagnosis being captured.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Diagnosis Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the observation is actually a diagnosis 
     * and is therefore mandatory. The datatype is CD to support 
     * SNOMED post-coordination.</p>
     * 
     * <p>If using SNOMED, this will contain the diagnosis. 
     * Otherwise it will be a fixed value of 'DX'.</p>
     * 
     * <p>Indicates the type of diagnosis being captured.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: G:Description</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>B.4</p>
     * 
     * <p>Allows for flexibility in the recording and reporting of 
     * the reaction.</p>
     * 
     * <p>A free form description of the reaction.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: G:Description</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>B.4</p>
     * 
     * <p>Allows for flexibility in the recording and reporting of 
     * the reaction.</p>
     * 
     * <p>A free form description of the reaction.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: F:Reaction Onset Date</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when evidence of the condition first appeared. 
     * May also provide information on the duration of the 
     * reaction.</p>
     * 
     * <p>The date on which the reaction occurrence began.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: F:Reaction Onset Date</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates when evidence of the condition first appeared. 
     * May also provide information on the duration of the 
     * reaction.</p>
     * 
     * <p>The date on which the reaction occurrence began.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: G:Adverse Reaction Masking Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their adverse reaction data.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their adverse reactions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information. Valid values are: 'NORMAL' 
     * (denotes 'Not Masked'); and 'RESTRICTED' (denotes 'Masked'). 
     * The default is 'NORMAL' signifying 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: G:Adverse Reaction Masking Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their adverse reaction data.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their adverse reactions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information. Valid values are: 'NORMAL' 
     * (denotes 'Not Masked'); and 'RESTRICTED' (denotes 'Masked'). 
     * The default is 'NORMAL' signifying 'Not Masked'.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: B:Reaction</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>B.1</p>
     * 
     * <p>Ensures consistency in tracking and categorizing the 
     * reaction type. Helps ensure that only proper allergies are 
     * categorized as allergy. The attribute is optional because it 
     * will not be used for SNOMED. The attribute is CWE because 
     * not all possible types of reactions are expressible by coded 
     * values.</p>
     * 
     * <p>Specifies the kind of reaction, as experienced by the 
     * patient.</p>
     */
    @Hl7XmlMapping({"value"})
    public SubjectReaction getValue() {
        return (SubjectReaction) this.value.getValue();
    }

    /**
     * <p>Business Name: B:Reaction</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>B.1</p>
     * 
     * <p>Ensures consistency in tracking and categorizing the 
     * reaction type. Helps ensure that only proper allergies are 
     * categorized as allergy. The attribute is optional because it 
     * will not be used for SNOMED. The attribute is CWE because 
     * not all possible types of reactions are expressible by coded 
     * values.</p>
     * 
     * <p>Specifies the kind of reaction, as experienced by the 
     * patient.</p>
     */
    public void setValue(SubjectReaction value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: REPC_MT000012CA.Subject2.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: REPC_MT000012CA.Subject2.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000012CA.ReactionObservationEvent.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000012CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf1SeverityObservation() {
        return this.subjectOf1SeverityObservation;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000012CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf1SeverityObservation) {
        this.subjectOf1SeverityObservation = subjectOf1SeverityObservation;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000012CA.Subject6.causalityAssessment</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/causalityAssessment"})
    public List<ReportedReactionsBean> getSubjectOf2CausalityAssessment() {
        return this.subjectOf2CausalityAssessment;
    }

}
