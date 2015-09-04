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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt000003ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt050203ca.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.merged.ReportedByBean;
import java.util.Date;



/**
 * <p>Business Name: Medical Condition</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to DX if not using SNOMED</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p><p>Code is 
 * fixed to DX if not using SNOMED</p>
 * 
 * <p>A record of a patient's medical condition. Includes 
 * diseases, disabilities, pregnancy, lactation and other 
 * clinical conditions of interest.</p>
 * 
 * <p>Necessary component of a person's overall medication and 
 * clinical profile. Helps with contraindication checking.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000003CA.MedicalCondition"})
@Hl7RootType
public class MedicalConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private CV value = new CVImpl();
    private PatientBean subjectPatient;
    private ReportedByBean informant;
    private BL subjectOf1ChronicIndicator = new BLImpl(false);
    private NotesBean subjectOf2Annotation;


    /**
     * <p>Business Name: Condition Type</p>
     * 
     * <p>Relationship: REPC_MT000003CA.MedicalCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what kind of condition is being reported.</p>
     * 
     * <p>Identifies this observation as reporting a medical 
     * condition and is therefore mandatory. When using SNOMED, the 
     * actual condition may be post-coordinated into this 
     * attribute, thus CD is used.</p>
     * 
     * <p>If SNOMED is used, the diagnosis will appear here. 
     * Otherwise, a fixed value of &quot;DX&quot; should be 
     * sent.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Condition Type</p>
     * 
     * <p>Relationship: REPC_MT000003CA.MedicalCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what kind of condition is being reported.</p>
     * 
     * <p>Identifies this observation as reporting a medical 
     * condition and is therefore mandatory. When using SNOMED, the 
     * actual condition may be post-coordinated into this 
     * attribute, thus CD is used.</p>
     * 
     * <p>If SNOMED is used, the diagnosis will appear here. 
     * Otherwise, a fixed value of &quot;DX&quot; should be 
     * sent.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Condition Status</p>
     * 
     * <p>Relationship: REPC_MT000003CA.MedicalCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A coded value that indicates whether the condition is 
     * still impacting the patient. 'active' means the condition is 
     * still affecting the patient. 'completed' means the condition 
     * no longer holds</p>
     * 
     * <p>Essential to evaluating the relevance of the condition 
     * record. In some cases, it may not be known whether the 
     * condition still exists or not. Therefore the status is 
     * treated as 'populated'.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Condition Status</p>
     * 
     * <p>Relationship: REPC_MT000003CA.MedicalCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A coded value that indicates whether the condition is 
     * still impacting the patient. 'active' means the condition is 
     * still affecting the patient. 'completed' means the condition 
     * no longer holds</p>
     * 
     * <p>Essential to evaluating the relevance of the condition 
     * record. In some cases, it may not be known whether the 
     * condition still exists or not. Therefore the status is 
     * treated as 'populated'.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: D:Condition Time Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT000003CA.MedicalCondition.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date on which the condition first began and when it 
     * ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p>
     * 
     * <p>The date on which the condition first began and when it 
     * ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p>
     * 
     * <p>The date on which the condition first began and when it 
     * ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p>
     * 
     * <p>Allows providers to evaluate the period of relevance for 
     * the medical condition.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: D:Condition Time Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT000003CA.MedicalCondition.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date on which the condition first began and when it 
     * ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p>
     * 
     * <p>The date on which the condition first began and when it 
     * ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p>
     * 
     * <p>The date on which the condition first began and when it 
     * ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p>
     * 
     * <p>Allows providers to evaluate the period of relevance for 
     * the medical condition.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E:Condition Masking Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000003CA.MedicalCondition.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Denotes access restriction placed on the medical 
     * condition record. Methods for accessing masked medical 
     * condition records will be governed by each jurisdiction 
     * (e.g. court orders, shared secret/consent, etc.).</p><p>The 
     * default confidentiality level is 'NORMAL'.</p>
     * 
     * <p>Denotes access restriction placed on the medical 
     * condition record. Methods for accessing masked medical 
     * condition records will be governed by each jurisdiction 
     * (e.g. court orders, shared secret/consent, etc.).</p><p>The 
     * default confidentiality level is 'NORMAL'.</p>
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
     * <p>Business Name: E:Condition Masking Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000003CA.MedicalCondition.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Denotes access restriction placed on the medical 
     * condition record. Methods for accessing masked medical 
     * condition records will be governed by each jurisdiction 
     * (e.g. court orders, shared secret/consent, etc.).</p><p>The 
     * default confidentiality level is 'NORMAL'.</p>
     * 
     * <p>Denotes access restriction placed on the medical 
     * condition record. Methods for accessing masked medical 
     * condition records will be governed by each jurisdiction 
     * (e.g. court orders, shared secret/consent, etc.).</p><p>The 
     * default confidentiality level is 'NORMAL'.</p>
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
     * <p>Business Name: B:Condition</p>
     * 
     * <p>Relationship: REPC_MT000003CA.MedicalCondition.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>A code indicating the specific condition. E.g. 
     * Hypertension, Pregnancy.</p>
     * 
     * <p>This is the central piece of information in recording a 
     * condition. However because when using SNOMED the actual 
     * diagnosis will be sent in the 'code' attribute, this element 
     * is optional.</p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }

    /**
     * <p>Business Name: B:Condition</p>
     * 
     * <p>Relationship: REPC_MT000003CA.MedicalCondition.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>A code indicating the specific condition. E.g. 
     * Hypertension, Pregnancy.</p>
     * 
     * <p>This is the central piece of information in recording a 
     * condition. However because when using SNOMED the actual 
     * diagnosis will be sent in the 'code' attribute, this element 
     * is optional.</p>
     */
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: REPC_MT000003CA.Subject2.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: REPC_MT000003CA.Subject2.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: REPC_MT000003CA.MedicalCondition.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }

    /**
     * <p>Relationship: REPC_MT000003CA.MedicalCondition.informant</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    /**
     * <p>Relationship: REPC_MT000003CA.Subject.chronicIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/chronicIndicator"})
    public Boolean getSubjectOf1ChronicIndicator() {
        return this.subjectOf1ChronicIndicator.getValue();
    }

    /**
     * <p>Relationship: REPC_MT000003CA.Subject.chronicIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1ChronicIndicator(Boolean subjectOf1ChronicIndicator) {
        this.subjectOf1ChronicIndicator.setValue(subjectOf1ChronicIndicator);
    }


    /**
     * <p>Relationship: REPC_MT000003CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotation"})
    public NotesBean getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }

    /**
     * <p>Relationship: REPC_MT000003CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2Annotation(NotesBean subjectOf2Annotation) {
        this.subjectOf2Annotation = subjectOf2Annotation;
    }

}
