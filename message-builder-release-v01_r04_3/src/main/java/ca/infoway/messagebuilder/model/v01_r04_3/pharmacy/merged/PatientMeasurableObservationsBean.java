/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ObservationIssueTriggerMeasuredObservationType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT980010CA.ObservationMeasurableEvent","PORX_MT980020CA.ObservationMeasurableEvent","PORX_MT980030CA.ObservationMeasurableEvent"})
public class PatientMeasurableObservationsBean extends MessagePartBean implements CausalActs {

    private static final long serialVersionUID = 20110318L;
    private CV confidentialityCode = new CVImpl();
    private II observationIdentifier = new IIImpl();
    private CV observationType = new CVImpl();
    private PQ observationValue = new PQImpl();


    /**
     * <p>D:Observation Masking Indicator</p>
     * 
     * <p>D:Observation Masked Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>ObservationIdentifier</p>
     * 
     * <p>A:Observation Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getObservationIdentifier() {
        return this.observationIdentifier.getValue();
    }
    public void setObservationIdentifier(Identifier observationIdentifier) {
        this.observationIdentifier.setValue(observationIdentifier);
    }


    /**
     * <p>ObservationType</p>
     * 
     * <p>B:Observation Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIssueTriggerMeasuredObservationType getObservationType() {
        return (ObservationIssueTriggerMeasuredObservationType) this.observationType.getValue();
    }
    public void setObservationType(ObservationIssueTriggerMeasuredObservationType observationType) {
        this.observationType.setValue(observationType);
    }


    /**
     * <p>ObservationValue</p>
     * 
     * <p>C:Observation Value</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getObservationValue() {
        return this.observationValue.getValue();
    }
    public void setObservationValue(PhysicalQuantity observationValue) {
        this.observationValue.setValue(observationValue);
    }

}
