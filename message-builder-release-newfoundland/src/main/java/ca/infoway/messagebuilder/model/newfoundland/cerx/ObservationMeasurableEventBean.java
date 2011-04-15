package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ObservationIssueTriggerMeasuredObservationType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.CausalActs;
import ca.infoway.messagebuilder.model.newfoundland.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "PORX_MT980010CA.ObservationMeasurableEvent", "PORX_MT980020CA.ObservationMeasurableEvent", "PORX_MT980030CA.ObservationMeasurableEvent" })
public class ObservationMeasurableEventBean extends MessagePartBean implements Serializable, CausalActs, VeryBasicConfidentiality {

    private static final long serialVersionUID = 4145895701846868905L;

    private II id = new IIImpl();

    private CD observationType = new CDImpl();

    private CD confidentialityCode = new CDImpl();

    private PQ observationValue = new PQImpl();

    @Hl7XmlMapping({ "id" })
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier observationIdentifier) {
        this.id.setValue(observationIdentifier);
    }

    @Hl7XmlMapping({ "code" })
    public ObservationIssueTriggerMeasuredObservationType getObservationType() {
        return (ObservationIssueTriggerMeasuredObservationType) this.observationType.getValue();
    }

    public void setObservationType(ObservationIssueTriggerMeasuredObservationType observationType) {
        this.observationType.setValue(observationType);
    }

    @Hl7XmlMapping({ "confidentialityCode" })
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping({ "value" })
    public PhysicalQuantity getObservationValue() {
        return this.observationValue.getValue();
    }

    public void setObservationValue(PhysicalQuantity observationValue) {
        this.observationValue.setValue(observationValue);
    }
}
