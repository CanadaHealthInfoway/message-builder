/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT260010CA.ObservationMeasurableEvent","COCT_MT260020CA.ObservationMeasurableEvent","COCT_MT260030CA.ObservationMeasurableEvent"})
public class PatientMeasurableObservationsBean extends MessagePartBean implements CausalActs {

    private static final long serialVersionUID = 20110407L;
    private II observationIdentifier = new IIImpl();
    private CD observationType = new CDImpl();
    private CV confidentialityCode = new CVImpl();
    private PQ observationValue = new PQImpl();


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
    public ActCode getObservationType() {
        return (ActCode) this.observationType.getValue();
    }
    public void setObservationType(ActCode observationType) {
        this.observationType.setValue(observationType);
    }


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
