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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt100002ca;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt050203ca.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.merged.ComponentMeasurementsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Patient Measurement</p>
 * 
 * <p>Measurement Type with a nullFlavor value must have 
 * SubObservations Measurement Type without a nullFlavor value 
 * must not have SubObservations.</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p>
 * 
 * <p>Measurement Type with a nullFlavor value must have 
 * SubObservations Measurement Type without a nullFlavor value 
 * must not have SubObservations.</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p>
 * 
 * <p>This comprises a single point-in-time measurement made 
 * about a patient.</p>
 * 
 * <p>Allows pertinent patient measurements to be recorded for 
 * clinical purposes.</p>
 */
@Hl7PartTypeMapping({"REPC_MT100002CA.CommonObservationEvent"})
@Hl7RootType
public class PatientMeasurementBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
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
    private List<NotesBean> subjectOf2Annotation = new ArrayList<NotesBean>();


    /**
     * <p>Business Name: E:Observation Measurement Id</p>
     * 
     * <p>Relationship: REPC_MT100002CA.CommonObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier assigned to a record of observation 
     * measurement.</p>
     * 
     * <p>Allows observation measurement record to be directly 
     * accessed for &quot;undo's&quot;, and thus the attribute is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: E:Observation Measurement Id</p>
     * 
     * <p>Relationship: REPC_MT100002CA.CommonObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier assigned to a record of observation 
     * measurement.</p>
     * 
     * <p>Allows observation measurement record to be directly 
     * accessed for &quot;undo's&quot;, and thus the attribute is 
     * mandatory.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Measurement Type</p>
     * 
     * <p>Relationship: REPC_MT100002CA.CommonObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identification of the type of measurement/observation 
     * that was made about the patient. Observation types include: 
     * height, weight, blood pressure, body mass, etc.</p>
     * 
     * <p>Distinguishes what kind of information is being 
     * specified. Code is mandatory to ensure that observations are 
     * distinguishable. The attribute is CD to support SNOMED.</p>
     */
    @Hl7XmlMapping({"code"})
    public CommonClinicalObservationType getCode() {
        return (CommonClinicalObservationType) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Measurement Type</p>
     * 
     * <p>Relationship: REPC_MT100002CA.CommonObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identification of the type of measurement/observation 
     * that was made about the patient. Observation types include: 
     * height, weight, blood pressure, body mass, etc.</p>
     * 
     * <p>Distinguishes what kind of information is being 
     * specified. Code is mandatory to ensure that observations are 
     * distinguishable. The attribute is CD to support SNOMED.</p>
     */
    public void setCode(CommonClinicalObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Observation Measurement Timestamp</p>
     * 
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date to which the observation applies. E.g., if blood 
     * was drawn two days ago and White Blood Count (WBC) was done 
     * today, then WBC observation date should reflect the date of 
     * two days ago.</p>
     * 
     * <p>Allows providers to evaluate currency of the information. 
     * Because the date of observation/measurement determines the 
     * relevance of the information, this attribute is defined as 
     * 'populated'. Also allows tracking of observations over 
     * time.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Observation Measurement Timestamp</p>
     * 
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date to which the observation applies. E.g., if blood 
     * was drawn two days ago and White Blood Count (WBC) was done 
     * today, then WBC observation date should reflect the date of 
     * two days ago.</p>
     * 
     * <p>Allows providers to evaluate currency of the information. 
     * Because the date of observation/measurement determines the 
     * relevance of the information, this attribute is defined as 
     * 'populated'. Also allows tracking of observations over 
     * time.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: D:Common Observation Masking Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their common observations. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked'). The default is 'NORMAL' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their common observation data.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their common observation data.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: D:Common Observation Masking Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their common observations. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked'). The default is 'NORMAL' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their common observation data.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their common observation data.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: B:Observation Measurement Value</p>
     * 
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the specific type of observation. E.g. height in 
     * centimeters, weight in kilograms, etc. Valid observation</p>
     * 
     * <p>Provides standard representation of the measurement. May 
     * be used in calculations.</p>
     * 
     * <p><b><font color="#000080" size="2" 
     * face="Helvetica-Bold"><font color="#000080" size="2" 
     * face="Helvetica-Bold"><font color="#000080" size="2" 
     * face="Helvetica-Bold"> <p align="left">This element will 
     * only be sent if the</p> <p align="left">Measurement Type is 
     * not &lsquo;18684-1&rsquo; (Blood</p> <p>Pressure).</p> 
     * </font></font></font></b></p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: B:Observation Measurement Value</p>
     * 
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the specific type of observation. E.g. height in 
     * centimeters, weight in kilograms, etc. Valid observation</p>
     * 
     * <p>Provides standard representation of the measurement. May 
     * be used in calculations.</p>
     * 
     * <p><b><font color="#000080" size="2" 
     * face="Helvetica-Bold"><font color="#000080" size="2" 
     * face="Helvetica-Bold"><font color="#000080" size="2" 
     * face="Helvetica-Bold"> <p align="left">This element will 
     * only be sent if the</p> <p align="left">Measurement Type is 
     * not &lsquo;18684-1&rsquo; (Blood</p> <p>Pressure).</p> 
     * </font></font></font></b></p>
     */
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: REPC_MT100002CA.Subject5.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: REPC_MT100002CA.Subject5.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Business Name: Supervised By</p>
     * 
     * <p>Relationship: 
     * REPC_MT100002CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Identifies the provider who is taking 
     * responsibility</p> <div>for the actions of the author.</div>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Business Name: Supervised By</p>
     * 
     * <p>Relationship: 
     * REPC_MT100002CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Identifies the provider who is taking 
     * responsibility</p> <div>for the actions of the author.</div>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: 
     * REPC_MT100002CA.CommonObservationEvent.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * REPC_MT100002CA.Component.subObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Represents one of the two components (systolic</p> 
     * <div>and diastolic) of a blood pressure measurement.</div>
     */
    @Hl7XmlMapping({"component/subObservationEvent"})
    public List<ComponentMeasurementsBean> getComponentSubObservationEvent() {
        return this.componentSubObservationEvent;
    }


    /**
     * <p>Relationship: 
     * REPC_MT100002CA.Subject2.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;If present, indicates that there are notes</p> 
     * <div>associated with the common observation.</div>
     */
    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * REPC_MT100002CA.Subject2.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;If present, indicates that there are notes</p> 
     * <div>associated with the common observation.</div>
     */
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }


    /**
     * <p>Relationship: REPC_MT100002CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotation"})
    public List<NotesBean> getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }

}
