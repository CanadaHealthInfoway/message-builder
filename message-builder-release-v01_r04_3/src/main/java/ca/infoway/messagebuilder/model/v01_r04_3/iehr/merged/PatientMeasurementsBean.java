/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.iehr.merged;

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
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT000018CA.CommonObservationEvent","REPC_MT100002CA.CommonObservationEvent"})
@Hl7RootType
public class PatientMeasurementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private RefusedByBean author;
    private ProviderBean responsiblePartyAssignedPerson;
    private PatientBean subjectPatient;
    private CV commonObservationMaskingIndicator = new CVImpl();
    private II observationMeasurementId = new IIImpl();
    private RecordedAtBean location;
    private CD measurementType = new CDImpl();
    private List<ComponentMeasurementsBean> componentSubObservationEvent = new ArrayList<ComponentMeasurementsBean>();
    private TS effectiveTime = new TSImpl();
    private PQ observationMeasurementValue = new PQImpl();
    private CommentBean subjectOfAnnotation;
    private BL subjectOf1AnnotationIndicator = new BLImpl();


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>CommonObservationMaskingIndicator</p>
     * 
     * <p>D:Common Observation Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getCommonObservationMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.commonObservationMaskingIndicator.getValue();
    }
    public void setCommonObservationMaskingIndicator(x_VeryBasicConfidentialityKind commonObservationMaskingIndicator) {
        this.commonObservationMaskingIndicator.setValue(commonObservationMaskingIndicator);
    }


    /**
     * <p>ObservationMeasurementId</p>
     * 
     * <p>E:Observation Measurement Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getObservationMeasurementId() {
        return this.observationMeasurementId.getValue();
    }
    public void setObservationMeasurementId(Identifier observationMeasurementId) {
        this.observationMeasurementId.setValue(observationMeasurementId);
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>MeasurementType</p>
     * 
     * <p>A:MeasurementType</p>
     * 
     * <p>A:Measurement Type</p>
     */
    @Hl7XmlMapping({"code"})
    public CommonClinicalObservationType getMeasurementType() {
        return (CommonClinicalObservationType) this.measurementType.getValue();
    }
    public void setMeasurementType(CommonClinicalObservationType measurementType) {
        this.measurementType.setValue(measurementType);
    }


    @Hl7XmlMapping({"component/subObservationEvent"})
    public List<ComponentMeasurementsBean> getComponentSubObservationEvent() {
        return this.componentSubObservationEvent;
    }


    /**
     * <p>C:Observation Timestamp</p>
     * 
     * <p>C:Observation Measurement Timestamp</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>ObservationMeasurementValue</p>
     * 
     * <p>B:Observation Measurement Value</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getObservationMeasurementValue() {
        return this.observationMeasurementValue.getValue();
    }
    public void setObservationMeasurementValue(PhysicalQuantity observationMeasurementValue) {
        this.observationMeasurementValue.setValue(observationMeasurementValue);
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


    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }

}
