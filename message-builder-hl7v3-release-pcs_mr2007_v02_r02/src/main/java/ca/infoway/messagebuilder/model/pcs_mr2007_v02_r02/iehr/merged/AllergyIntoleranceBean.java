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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.iehr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.AllergyIntoleranceSeverityLevelBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: AllergyIntolerance</p>
 * 
 * <p>REPC_MT000001CA.IntoleranceCondition: Allergy/Intolerance</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p>
 * 
 * <p>Necessary component of a person's overall medication and 
 * clinical profile. Helps with drug contraindication 
 * checking.</p>
 * 
 * <p>A record of a patient's allergy or intolerance.</p>
 * 
 * <p>REPC_MT000013CA.IntoleranceCondition: Allergy/Intolerance</p>
 * 
 * <p>Necessary component of a person's overall medication and 
 * clinical profile. Helps with drug contraindication 
 * checking.</p>
 * 
 * <p>A record of a patient's allergy or intolerance.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.IntoleranceCondition","REPC_MT000013CA.IntoleranceCondition"})
@Hl7RootType
public class AllergyIntoleranceBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CD code = new CDImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV uncertaintyCode = new CVImpl();
    private CV value = new CVImpl();
    private ReportedByBean informant;
    private List<Records> supportRecords = new ArrayList<Records>();
    private NotesBean subjectOf1Annotation;
    private AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation;
    private II id = new IIImpl();


    /**
     * <p>Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: REPC_MT000001CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>A coded value denoting whether the record pertains to an 
     * intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: REPC_MT000013CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>A coded value denoting whether the record pertains to an 
     * intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getCode() {
        return (ObservationIntoleranceType) this.code.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: REPC_MT000001CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>A coded value denoting whether the record pertains to an 
     * intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: REPC_MT000013CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>A coded value denoting whether the record pertains to an 
     * intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p>
     */
    public void setCode(ObservationIntoleranceType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to refute a previously confirmed or 
     * suspected allergy. The attribute is mandatory because it is 
     * essential to know whether a record is refuted or not.</p>
     * 
     * <p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to refute a previously confirmed or 
     * suspected allergy. Because it is essential to know whether 
     * the allergy or intolerance is being refuted or affirmed, 
     * this attribute is mandatory.</p>
     * 
     * <p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to refute a previously confirmed or 
     * suspected allergy. The attribute is mandatory because it is 
     * essential to know whether a record is refuted or not.</p>
     * 
     * <p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to refute a previously confirmed or 
     * suspected allergy. Because it is essential to know whether 
     * the allergy or intolerance is being refuted or affirmed, 
     * this attribute is mandatory.</p>
     * 
     * <p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the relevance of a recorded 
     * allergy/intolerance. The status has a default value of 
     * 'active' and is therefore mandatory.</p>
     * 
     * <p>System must default the status to 'active'.</p>
     * 
     * <p>A coded value that indicates whether an 
     * allergy/intolerance is 'active' or 'completed' (indicating 
     * no longer active).</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the relevance of a recorded 
     * allergy/intolerance. The status has a default value of 
     * 'ACTIVE' and is therefore mandatory.</p>
     * 
     * <p>System must default the status to 'ACTIVE'.</p>
     * 
     * <p>A coded value that indicates whether an 
     * allergy/intolerance is 'ACTIVE' or 'COMPLETE' (indicating no 
     * longer active).</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the relevance of a recorded 
     * allergy/intolerance. The status has a default value of 
     * 'active' and is therefore mandatory.</p>
     * 
     * <p>System must default the status to 'active'.</p>
     * 
     * <p>A coded value that indicates whether an 
     * allergy/intolerance is 'active' or 'completed' (indicating 
     * no longer active).</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the relevance of a recorded 
     * allergy/intolerance. The status has a default value of 
     * 'ACTIVE' and is therefore mandatory.</p>
     * 
     * <p>System must default the status to 'ACTIVE'.</p>
     * 
     * <p>A coded value that indicates whether an 
     * allergy/intolerance is 'ACTIVE' or 'COMPLETE' (indicating no 
     * longer active).</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: AllergyIntoleranceDate</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the period of relevance for 
     * the allergy/intolerance record.</p>
     * 
     * <p>The date on which the recorded allergy is considered 
     * active.</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the period of relevance for 
     * the allergy/intolerance record.</p>
     * 
     * <p>The date on which the recorded allergy is considered 
     * active.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceDate</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the period of relevance for 
     * the allergy/intolerance record.</p>
     * 
     * <p>The date on which the recorded allergy is considered 
     * active.</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the period of relevance for 
     * the allergy/intolerance record.</p>
     * 
     * <p>The date on which the recorded allergy is considered 
     * active.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: AllergyIntoleranceMaskingIndicators</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceMaskingIndicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Cant have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Denotes access restriction placed on the allergy or 
     * intolerance record. Methods for accessing masked allergy 
     * records will be governed by each jurisdiction (e.g. court 
     * orders, shared secret/consent, etc.).</p><p>Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceMaskingIndicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Cant have both normal 
     * and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Denotes access restriction placed on the allergy or 
     * intolerance record. Methods for accessing masked allergy 
     * records will be governed by each jurisdiction (e.g. court 
     * orders, shared secret/consent, etc.).</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Business Name: ConfirmedIndicator</p>
     * 
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either U or 
     * N.</p>
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
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either U or 
     * N</p>
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
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }

    /**
     * <p>Business Name: ConfirmedIndicator</p>
     * 
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either U or 
     * N.</p>
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
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications.</p><p>Attribute is mandatory because an 
     * allergy or intolerance record must be tagged as either U or 
     * N</p>
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
     */
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }


    /**
     * <p>Business Name: Agent</p>
     * 
     * <p>Un-merged Business Name: Agent</p>
     * 
     * <p>Relationship: REPC_MT000001CA.IntoleranceCondition.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Critical for identifying the allergy or intolerance. 
     * However, because the attribute is not used for SNOMED, it is 
     * optional.</p>
     * 
     * <p>Indicates the substance to which the patient is 
     * allergic</p>
     */
    @Hl7XmlMapping({"value"})
    public IntoleranceValue getValue() {
        return (IntoleranceValue) this.value.getValue();
    }

    /**
     * <p>Business Name: Agent</p>
     * 
     * <p>Un-merged Business Name: Agent</p>
     * 
     * <p>Relationship: REPC_MT000001CA.IntoleranceCondition.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Critical for identifying the allergy or intolerance. 
     * However, because the attribute is not used for SNOMED, it is 
     * optional.</p>
     * 
     * <p>Indicates the substance to which the patient is 
     * allergic</p>
     */
    public void setValue(IntoleranceValue value) {
        this.value.setValue(value);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.IntoleranceCondition.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.IntoleranceCondition.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Support.records</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000013CA.Support.records</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"support/records"})
    public List<Records> getSupportRecords() {
        return this.supportRecords;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/annotation"})
    public NotesBean getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1Annotation(NotesBean subjectOf1Annotation) {
        this.subjectOf1Annotation = subjectOf1Annotation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/severityObservation","subjectOf2/severityObservation"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="REPC_MT000013CA.Subject1"),
        @Hl7MapByPartType(name="subjectOf/severityObservation", type="REPC_MT000013CA.SeverityObservation"),
        @Hl7MapByPartType(name="subjectOf2", type="REPC_MT000001CA.Subject1"),
        @Hl7MapByPartType(name="subjectOf2/severityObservation", type="REPC_MT000001CA.SeverityObservation")})
    public AllergyIntoleranceSeverityLevelBean getSubjectOfSeverityObservation() {
        return this.subjectOfSeverityObservation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.Subject1.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOfSeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation) {
        this.subjectOfSeverityObservation = subjectOfSeverityObservation;
    }


    /**
     * <p>Business Name: AllergyIntoleranceRecordId</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRecordId</p>
     * 
     * <p>Relationship: REPC_MT000013CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the allergy or intolerance record to be updated 
     * and is therefore mandatory.</p>
     * 
     * <p>Unique identifier for an allergy/intolerance record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceRecordId</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRecordId</p>
     * 
     * <p>Relationship: REPC_MT000013CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the allergy or intolerance record to be updated 
     * and is therefore mandatory.</p>
     * 
     * <p>Unique identifier for an allergy/intolerance record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
