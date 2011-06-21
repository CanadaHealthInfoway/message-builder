/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt090107ca.ProviderBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>REPC_MT100002CA.CommonObservationEvent: Patient 
 * Measurement</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This 
 * comprises a single point-in-time measurement made about a 
 * patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
 * pertinent patient measurements to be recorded for clinical 
 * purposes.</p></p>
 * 
 * <p>REPC_MT000018CA.CommonObservationEvent: Patient 
 * Measurements</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This 
 * comprises a single point-in-time measurement made about a 
 * patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
 * pertinent patient measurements to be recorded for clinical 
 * purposes.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000018CA.CommonObservationEvent","REPC_MT100002CA.CommonObservationEvent"})
@Hl7RootType
public class PatientMeasurementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private II observationMeasurementId = new IIImpl();
    private CD measurementType = new CDImpl();
    private TS effectiveTime = new TSImpl();
    private CV commonObservationMaskingIndicator = new CVImpl();
    private PQ observationMeasurementValue = new PQImpl();
    private RefusedByBean author;
    private List<ComponentMeasurementsBean> componentSubObservationEvent = new ArrayList<ComponentMeasurementsBean>();
    private RecordedAtBean location;
    private ProviderBean responsiblePartyAssignedPerson;
    private Patient_1Bean subjectPatient;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private CommentBean subjectOfAnnotation;


    /**
     * <p>ObservationMeasurementId</p>
     * 
     * <p>E:Observation Measurement Id</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Unique 
     * identifier assigned to a record of observation 
     * measurement.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * observation measurement record to be directly accessed for 
     * &quot;undo's&quot;, and thus the attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getObservationMeasurementId() {
        return this.observationMeasurementId.getValue();
    }
    public void setObservationMeasurementId(Identifier observationMeasurementId) {
        this.observationMeasurementId.setValue(observationMeasurementId);
    }


    /**
     * <p>MeasurementType</p>
     * 
     * <p>A:Measurement Type</p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Identification of 
     * the type of measurement/observation that was made about the 
     * patient. Observation types include: height, weight, blood 
     * pressure, body mass, etc.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Distinguishes what 
     * kind of information is being specified. Code is mandatory to 
     * ensure that observations are distinguishable. The attribute 
     * is CD to support SNOMED.</p></p>
     * 
     * <p>A:MeasurementType</p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Identification of 
     * the type of measurement/observation that was made about the 
     * patient. Observation types include: height, weight, blood 
     * pressure, body mass, etc</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">OBS.010-01 
     * NCPDP:Clinical.495-H2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Distinguishes what 
     * kind of information is being specified. Code is mandatory to 
     * ensure that observations are distinguishable. The attribute 
     * is CD to support SNOMED</p></p>
     */
    @Hl7XmlMapping({"code"})
    public CommonClinicalObservationType getMeasurementType() {
        return (CommonClinicalObservationType) this.measurementType.getValue();
    }
    public void setMeasurementType(CommonClinicalObservationType measurementType) {
        this.measurementType.setValue(measurementType);
    }


    /**
     * <p>C:Observation Timestamp</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The dateand 
     * time at which the observation applies. E.g., if blood was 
     * drawn two days ago and White Blood Count (WBC) was done 
     * today, then WBC observation date should reflect the date of 
     * two days ago.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">OBS.010-04 
     * NCPDP:Clinical.494-ZE NCPDP:Clinical.495-H1</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * providers to evaluate currency of the information. Because 
     * the date of observation/measurement determines the relevance 
     * of the information, this attribute is defined as 
     * 'populated'. Also allows tracking of observations over 
     * time.</p></p>
     * 
     * <p>C:Observation Measurement Timestamp</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date to 
     * which the observation applies. E.g., if blood was drawn two 
     * days ago and White Blood Count (WBC) was done today, then 
     * WBC observation date should reflect the date of two days 
     * ago.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * providers to evaluate currency of the information. Because 
     * the date of observation/measurement determines the relevance 
     * of the information, this attribute is defined as 
     * 'populated'. Also allows tracking of observations over 
     * time.</p></p>
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
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their common 
     * observations. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information. Valid values are: 'NORMAL' 
     * (denotes 'Not Masked'); and 'RESTRICTED' (denotes 'Masked'). 
     * The default is 'NORMAL' signifying 'Not Masked'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their common 
     * observation data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their common 
     * observation data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getCommonObservationMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.commonObservationMaskingIndicator.getValue();
    }
    public void setCommonObservationMaskingIndicator(x_VeryBasicConfidentialityKind commonObservationMaskingIndicator) {
        this.commonObservationMaskingIndicator.setValue(commonObservationMaskingIndicator);
    }


    /**
     * <p>ObservationMeasurementValue</p>
     * 
     * <p>B:Observation Measurement Value</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The amount 
     * (quantity and unit) that has been recorded for the specific 
     * type of observation. E.g. height in centimeters, weight in 
     * kilograms, etc. Valid observation</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * standard representation of the measurement. May be used in 
     * calculations.</p></p>
     * 
     * <p>B:Observation Measurement Value</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The amount 
     * (quantity and unit) that has been recorded for the specific 
     * type of observation. E.g. height in centimeters, weight in 
     * kilograms, etc.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Valid observation 
     * unit types are: kg, cm, mmHg, mmol/mL, L/min, C, 1/min, 
     * etc</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The amount 
     * (quantity and unit) that has been recorded for the specific 
     * type of observation. E.g. height in centimeters, weight in 
     * kilograms, etc.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Valid observation 
     * unit types are: kg, cm, mmHg, mmol/mL, L/min, C, 1/min, 
     * etc</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">OBS.010-02 
     * (value) eScript:OBS.010-03 (unit) NCPDP:Clinical.595-H4 
     * (value) NCPDP:Clinical.495-H3 (unit)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * standard representation of the measurement. May be used in 
     * calculations.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getObservationMeasurementValue() {
        return this.observationMeasurementValue.getValue();
    }
    public void setObservationMeasurementValue(PhysicalQuantity observationMeasurementValue) {
        this.observationMeasurementValue.setValue(observationMeasurementValue);
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"component/subObservationEvent"})
    public List<ComponentMeasurementsBean> getComponentSubObservationEvent() {
        return this.componentSubObservationEvent;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
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
