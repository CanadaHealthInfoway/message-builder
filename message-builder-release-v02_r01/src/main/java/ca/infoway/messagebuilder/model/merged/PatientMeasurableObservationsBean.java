/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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
import ca.infoway.messagebuilder.model.common.coct_mt260030ca.CausalActsBean;



@Hl7PartTypeMapping({"COCT_MT260010CA.ObservationMeasurableEvent","COCT_MT260020CA.ObservationMeasurableEvent","COCT_MT260030CA.ObservationMeasurableEvent"})
public class PatientMeasurableObservationsBean extends MessagePartBean implements ca.infoway.messagebuilder.model.merged.CausalActsBean, CausalActsBean {

    private static final long serialVersionUID = 20100615L;
    private II observationIdentifier = new IIImpl();
    private CD observationType = new CDImpl();
    private CV observationMaskingIndicator = new CVImpl();
    private PQ observationValue = new PQImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getObservationIdentifier() {
        return this.observationIdentifier.getValue();
    }
    public void setObservationIdentifier(Identifier observationIdentifier) {
        this.observationIdentifier.setValue(observationIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public ActCode getObservationType() {
        return (ActCode) this.observationType.getValue();
    }
    public void setObservationType(ActCode observationType) {
        this.observationType.setValue(observationType);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getObservationMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.observationMaskingIndicator.getValue();
    }
    public void setObservationMaskingIndicator(x_VeryBasicConfidentialityKind observationMaskingIndicator) {
        this.observationMaskingIndicator.setValue(observationMaskingIndicator);
    }

    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getObservationValue() {
        return this.observationValue.getValue();
    }
    public void setObservationValue(PhysicalQuantity observationValue) {
        this.observationValue.setValue(observationValue);
    }

}
