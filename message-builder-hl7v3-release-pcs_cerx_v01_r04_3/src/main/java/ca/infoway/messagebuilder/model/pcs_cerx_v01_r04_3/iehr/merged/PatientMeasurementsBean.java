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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.CommonClinicalObservationType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>REPC_MT100002CA.CommonObservationEvent: Patient 
 * Measurement</p>
 * 
 * <p><p>Measurement Type with a nullFlavor value must have 
 * SubObservations Measurement Type without a nullFlavor value 
 * must not have SubObservations.</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p></p>
 * 
 * <p><p>Measurement Type with a nullFlavor value must have 
 * SubObservations Measurement Type without a nullFlavor value 
 * must not have SubObservations.</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p></p>
 * 
 * <p><p>This comprises a single point-in-time measurement made 
 * about a patient.</p></p>
 * 
 * <p><p>Allows pertinent patient measurements to be recorded 
 * for clinical purposes.</p></p>
 * 
 * <p>REPC_MT000018CA.CommonObservationEvent: Patient 
 * Measurements</p>
 * 
 * <p><p>Measurement Type with a nullFlavorvalue must have 
 * SubObservations Measurement Type without a nullFlavor value 
 * must not have SubObservations.</p></p>
 * 
 * <p><p>This comprises a single point-in-time measurement made 
 * about a patient.</p></p>
 * 
 * <p><p>Allows pertinent patient measurements to be recorded 
 * for clinical purposes.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000018CA.CommonObservationEvent","REPC_MT100002CA.CommonObservationEvent"})
@Hl7RootType
public class PatientMeasurementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private TS effectiveTime = new TSImpl();
    private CV confidentialityCode = new CVImpl();
    private PQ value = new PQImpl();
    private PatientBean subjectPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private RecordedAtBean location;
    private List<ComponentMeasurementsBean> componentSubObservationEvent = new ArrayList<ComponentMeasurementsBean>();
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private CommentBean subjectOfAnnotation;


    /**
     * <p>ObservationMeasurementId</p>
     * 
     * <p>E:Observation Measurement Id</p>
     * 
     * <p><p>Unique identifier assigned to a record of observation 
     * measurement.</p></p>
     * 
     * <p><p>Allows observation measurement record to be directly 
     * accessed for &quot;undo's&quot;, and thus the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>MeasurementType</p>
     * 
     * <p>A:MeasurementType</p>
     * 
     * <p><p>Identification of the type of measurement/observation 
     * that was made about the patient. Observation types include: 
     * height, weight, blood pressure, body mass, etc</p></p>
     * 
     * <p><p>Distinguishes what kind of information is being 
     * specified.</p><p>The attribute is CD to support SNOMED</p></p>
     * 
     * <p><p>Distinguishes what kind of information is being 
     * specified.</p><p>The attribute is CD to support SNOMED</p></p>
     * 
     * <p>A:Measurement Type</p>
     * 
     * <p><p>Identification of the type of measurement/observation 
     * that was made about the patient. Observation types include: 
     * height, weight, blood pressure, body mass, etc.</p></p>
     * 
     * <p><p>Distinguishes what kind of information is being 
     * specified. Code is mandatory to ensure that observations are 
     * distinguishable. The attribute is CD to support SNOMED.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public CommonClinicalObservationType getCode() {
        return (CommonClinicalObservationType) this.code.getValue();
    }
    public void setCode(CommonClinicalObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>C:Observation Timestamp</p>
     * 
     * <p><p>The dateand time at which the observation applies. 
     * E.g., if blood was drawn two days ago and White Blood Count 
     * (WBC) was done today, then WBC observation date should 
     * reflect the date of two days ago.</p></p>
     * 
     * <p><p>OBS.010-04 NCPDP:Clinical.494-ZE 
     * NCPDP:Clinical.495-H1</p></p>
     * 
     * <p><p>Allows providers to evaluate currency of the 
     * information. Because the date of observation/measurement 
     * determines the relevance of the information, this attribute 
     * is defined as 'populated'. Also allows tracking of 
     * observations over time.</p></p>
     * 
     * <p>C:Observation Measurement Timestamp</p>
     * 
     * <p><p>The date to which the observation applies. E.g., if 
     * blood was drawn two days ago and White Blood Count (WBC) was 
     * done today, then WBC observation date should reflect the 
     * date of two days ago.</p></p>
     * 
     * <p><p>Allows providers to evaluate currency of the 
     * information. Because the date of observation/measurement 
     * determines the relevance of the information, this attribute 
     * is defined as 'populated'. Also allows tracking of 
     * observations over time.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>CommonObservationMaskingIndicator</p>
     * 
     * <p>D:Common Observation Masking Indicator</p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their common observations. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked'). The default is 'NORMAL' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their common observation data.</p><p>The attribute 
     * is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their common observation data.</p><p>The attribute 
     * is optional because not all systems will support 
     * masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>ObservationMeasurementValue</p>
     * 
     * <p>B:Observation Measurement Value</p>
     * 
     * <p><p>The amount (quantity and unit) that has been recorded 
     * for the specific type of observation. E.g. height in 
     * centimeters, weight in kilograms, etc. Valid observation</p></p>
     * 
     * <p><p>Provides standard representation of the measurement. 
     * May be used in calculations.</p></p>
     * 
     * <p>B:Observation Measurement Value</p>
     * 
     * <p><p>The amount (quantity and unit) that has been recorded 
     * for the specific type of observation. E.g. height in 
     * centimeters, weight in kilograms, etc.</p><p>Valid 
     * observation unit types are: kg, cm, mmHg, mmol/mL, L/min, C, 
     * 1/min, etc</p></p>
     * 
     * <p><p>The amount (quantity and unit) that has been recorded 
     * for the specific type of observation. E.g. height in 
     * centimeters, weight in kilograms, etc.</p><p>Valid 
     * observation unit types are: kg, cm, mmHg, mmol/mL, L/min, C, 
     * 1/min, etc</p></p>
     * 
     * <p><p>OBS.010-02 (value) eScript:OBS.010-03 (unit) 
     * NCPDP:Clinical.595-H4 (value) NCPDP:Clinical.495-H3 
     * (unit)</p></p>
     * 
     * <p><p>Provides standard representation of the measurement. 
     * May be used in calculations.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"component/subObservationEvent"})
    public List<ComponentMeasurementsBean> getComponentSubObservationEvent() {
        return this.componentSubObservationEvent;
    }


    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf/annotation","subjectOf2/annotation"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="REPC_MT000018CA.Subject"),
        @Hl7MapByPartType(name="subjectOf/annotation", type="COCT_MT120600CA.Annotation"),
        @Hl7MapByPartType(name="subjectOf2", type="REPC_MT100002CA.Subject"),
        @Hl7MapByPartType(name="subjectOf2/annotation", type="COCT_MT120600CA.Annotation")})
    public CommentBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(CommentBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
