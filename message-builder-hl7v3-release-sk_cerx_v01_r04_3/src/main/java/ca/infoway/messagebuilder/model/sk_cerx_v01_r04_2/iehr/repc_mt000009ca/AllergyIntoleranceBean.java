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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt000009ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt050203ca.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.merged.MedicalConditionStatusChangesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Allergy/Intolerance</p>
 * 
 * <p>Value is not permitted when using SNOMED, mandatory 
 * otherwise</p>
 * 
 * <p>A record of a patient's allergy or intolerance.</p>
 * 
 * <p>Necessary component of a person's overall medication and 
 * clinical profile. Helps with drug contraindication 
 * checking.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000009CA.IntoleranceCondition"})
@Hl7RootType
public class AllergyIntoleranceBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private CV confidentialityCode = new CVImpl();
    private CV uncertaintyCode = new CVImpl();
    private CV value = new CVImpl();
    private PatientBean subjectPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private ReportedByBean informant;
    private RecordedAtBean location;
    private AllergyIntoleranceBean replacementOfIntoleranceCondition;
    private List<Records> supportRecords = new ArrayList<Records>();
    private List<MedicalConditionStatusChangesBean> subjectOf1ControlActEvent = new ArrayList<MedicalConditionStatusChangesBean>();
    private List<NotesBean> subjectOf2Annotation = new ArrayList<NotesBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOf3SeverityObservation;


    /**
     * <p>Business Name: D:Allergy/Intolerance Record Id</p>
     * 
     * <p>Relationship: REPC_MT000009CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for an allergy/intolerance record.</p>
     * 
     * <p>Allows for direct referencing of an allergy/intolerance 
     * record when querying or performing updates and is therefore 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: D:Allergy/Intolerance Record Id</p>
     * 
     * <p>Relationship: REPC_MT000009CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for an allergy/intolerance record.</p>
     * 
     * <p>Allows for direct referencing of an allergy/intolerance 
     * record when querying or performing updates and is therefore 
     * mandatory.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Allergy/Intolerance Type</p>
     * 
     * <p>Relationship: REPC_MT000009CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting whether the record pertains to an 
     * intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p>
     * 
     * <p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getCode() {
        return (ObservationIntoleranceType) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Allergy/Intolerance Type</p>
     * 
     * <p>Relationship: REPC_MT000009CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting whether the record pertains to an 
     * intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p>
     * 
     * <p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     */
    public void setCode(ObservationIntoleranceType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: G:Allergy/Intolerance Refuted</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p>
     * 
     * <p>Allows providers to refute a previously confirmed or 
     * suspected allergy. Because it is essential to know whether 
     * the record refutes or affirms an allergy, this attribute is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: G:Allergy/Intolerance Refuted</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p>
     * 
     * <p>Allows providers to refute a previously confirmed or 
     * suspected allergy. Because it is essential to know whether 
     * the record refutes or affirms an allergy, this attribute is 
     * mandatory.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: E:Allergy/Intolerance Status</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>&quot;Identifies what kind of change occurred. 
     * Allergy/Intolerance change types are Revise, Reactivate and 
     * Complete</p>
     * 
     * <p>Allows providers to evaluate the relevance of a recorded 
     * allergy/intolerance. The status has a default value of 
     * 'active' and is therefore mandatory.</p>
     * 
     * <p>System must default the status to 'ACTIVE'.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: E:Allergy/Intolerance Status</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>&quot;Identifies what kind of change occurred. 
     * Allergy/Intolerance change types are Revise, Reactivate and 
     * Complete</p>
     * 
     * <p>Allows providers to evaluate the relevance of a recorded 
     * allergy/intolerance. The status has a default value of 
     * 'active' and is therefore mandatory.</p>
     * 
     * <p>System must default the status to 'ACTIVE'.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: I:Allergy/Intolerance Date</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date on which the recorded allergy is considered 
     * active.</p>
     * 
     * <p>Allows providers to evaluate the period of relevance for 
     * the allergy/intolerance record.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: I:Allergy/Intolerance Date</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date on which the recorded allergy is considered 
     * active.</p>
     * 
     * <p>Allows providers to evaluate the period of relevance for 
     * the allergy/intolerance record.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: H:Allergy/Intolerance Masking Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Denotes access restriction placed on the allergy or 
     * intolerance record. Methods for accessing masked allergy 
     * records will be governed by each jurisdiction (e.g. court 
     * orders, shared secret/consent, etc.). The default 
     * confidentiality level is 'NORMAL'.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: H:Allergy/Intolerance Masking Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Denotes access restriction placed on the allergy or 
     * intolerance record. Methods for accessing masked allergy 
     * records will be governed by each jurisdiction (e.g. court 
     * orders, shared secret/consent, etc.). The default 
     * confidentiality level is 'NORMAL'.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: F:Confirmed Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either 
     * 'confirmed' or 'suspected'.</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either 
     * 'confirmed' or 'suspected'.</p>
     * 
     * <p>&nbsp;This can be &lsquo;N&rsquo; or &lsquo;U&rsquo;.</p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }

    /**
     * <p>Business Name: F:Confirmed Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information.</p><p>The two valid codes 
     * are:</p><p>- U (stated with uncertainty) -Specifies that the 
     * author of the act affirms the uncertainty of the act 
     * statement. In other words, they know that parts of the act 
     * statement are not certain or are inferred. An example of 
     * this is an inferred prescription where some order data is 
     * inferred from a supply event (i.e. dispense).</p><p>- N 
     * (stated with no assertion of uncertainty) - Specifies that 
     * the act statement is made without any explicit expression of 
     * certainty/uncertainty. This is the normal statement, meaning 
     * that it may not be free of errors and uncertainty may still 
     * exist. In healthcare, N is believed to express certainty to 
     * the strength possible.</p><p>An allergy or intolerance 
     * record is always used in drug contraindication checking 
     * whether the record is U or N.</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either 
     * 'confirmed' or 'suspected'.</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either 
     * 'confirmed' or 'suspected'.</p>
     * 
     * <p>&nbsp;This can be &lsquo;N&rsquo; or &lsquo;U&rsquo;.</p>
     */
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }


    /**
     * <p>Business Name: B:Agent</p>
     * 
     * <p>Relationship: REPC_MT000009CA.IntoleranceCondition.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the substance to which the patient is 
     * allergic</p>
     * 
     * <p>Critical for identifying the allergy or intolerance. 
     * However, because the attribute is not used for SNOMED, it is 
     * optional.</p>
     * 
     * <p><strong>Because PIN is not using SNOMED, this attribute 
     * is mandatory.</strong></p>
     */
    @Hl7XmlMapping({"value"})
    public IntoleranceValue getValue() {
        return (IntoleranceValue) this.value.getValue();
    }

    /**
     * <p>Business Name: B:Agent</p>
     * 
     * <p>Relationship: REPC_MT000009CA.IntoleranceCondition.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the substance to which the patient is 
     * allergic</p>
     * 
     * <p>Critical for identifying the allergy or intolerance. 
     * However, because the attribute is not used for SNOMED, it is 
     * optional.</p>
     * 
     * <p><strong>Because PIN is not using SNOMED, this attribute 
     * is mandatory.</strong></p>
     */
    public void setValue(IntoleranceValue value) {
        this.value.setValue(value);
    }


    /**
     * <p>Business Name: Suffered By</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Subject2.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>&nbsp;Identifies the person suffering from 
     * the&nbsp;allergy/intolerance.</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Business Name: Suffered By</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Subject2.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>&nbsp;Identifies the person suffering from 
     * the&nbsp;allergy/intolerance.</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Business Name: Supervised By</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Identifies the provider who is taking 
     * responsibility for&nbsp;the actions of the author.</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Business Name: Supervised By</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Identifies the provider who is taking 
     * responsibility for&nbsp;the actions of the author.</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Relationship: REPC_MT000009CA.IntoleranceCondition.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: REPC_MT000009CA.IntoleranceCondition.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Business Name: Reported By</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>&nbsp;Indicates where the information that led to 
     * the&nbsp;recording of this information came from.</p>
     */
    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }

    /**
     * <p>Business Name: Reported By</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>&nbsp;Indicates where the information that led to 
     * the&nbsp;recording of this information came from.</p>
     */
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000009CA.IntoleranceCondition.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000009CA.ReplacementOf.intoleranceCondition</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>This is a complete Allergy/Intolerance that reflects</p> 
     * <div>what the allergy/intolerance looked like before this 
     * set</div> <div>of change.</div>
     * 
     * <p>&nbsp;</p> <div>Since PIN does not analyze an update, all 
     * updates&nbsp;will be returned in this section instead of the 
     * Has</div> <div>History section.</div>
     */
    @Hl7XmlMapping({"replacementOf/intoleranceCondition"})
    public AllergyIntoleranceBean getReplacementOfIntoleranceCondition() {
        return this.replacementOfIntoleranceCondition;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000009CA.ReplacementOf.intoleranceCondition</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>This is a complete Allergy/Intolerance that reflects</p> 
     * <div>what the allergy/intolerance looked like before this 
     * set</div> <div>of change.</div>
     * 
     * <p>&nbsp;</p> <div>Since PIN does not analyze an update, all 
     * updates&nbsp;will be returned in this section instead of the 
     * Has</div> <div>History section.</div>
     */
    public void setReplacementOfIntoleranceCondition(AllergyIntoleranceBean replacementOfIntoleranceCondition) {
        this.replacementOfIntoleranceCondition = replacementOfIntoleranceCondition;
    }


    /**
     * <p>Relationship: REPC_MT000009CA.Support.records</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"support/records"})
    public List<Records> getSupportRecords() {
        return this.supportRecords;
    }


    /**
     * <p>Business Name: Allergy Intolerance Status Change</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Subject4.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>This records the history of changes that have 
     * been&nbsp;made to the allergy/intolerance, including why 
     * the&nbsp;changes were made, who made them and when.</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<MedicalConditionStatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    /**
     * <p>Business Name: Annotation</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><strong>Annotations will only be returned on the current 
     * allergy/intolerance record. They will not be present on the 
     * IntoleranceCondition objects that represent 
     * history.</strong></p>
     */
    @Hl7XmlMapping({"subjectOf2/annotation"})
    public List<NotesBean> getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }


    /**
     * <p>Relationship: 
     * REPC_MT000009CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf3SeverityObservation() {
        return this.subjectOf3SeverityObservation;
    }

    /**
     * <p>Relationship: 
     * REPC_MT000009CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf3SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf3SeverityObservation) {
        this.subjectOf3SeverityObservation = subjectOf3SeverityObservation;
    }

}
