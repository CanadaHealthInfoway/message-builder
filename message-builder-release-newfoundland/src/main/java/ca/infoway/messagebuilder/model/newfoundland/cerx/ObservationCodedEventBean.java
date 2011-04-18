package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.IssueTriggerObservationValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIssueTriggerCodedObservationType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.CausalActs;
import ca.infoway.messagebuilder.model.newfoundland.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "PORX_MT980010CA.ObservationCodedEvent", "PORX_MT980020CA.ObservationCodedEvent", "PORX_MT980030CA.ObservationCodedEvent" })
public class ObservationCodedEventBean extends MessagePartBean implements Serializable, CausalActs, VeryBasicConfidentiality {

    private static final long serialVersionUID = -6988709874889043719L;

    private II id = new IIImpl();

    private CD observationType = new CDImpl();

    private CD confidentialityCode = new CDImpl();

    private CD observationValue = new CDImpl();

    @Hl7XmlMapping({ "id" })
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier observationIdentifier) {
        this.id.setValue(observationIdentifier);
    }

    @Hl7XmlMapping({ "code" })
    public ObservationIssueTriggerCodedObservationType getObservationType() {
        return (ObservationIssueTriggerCodedObservationType) this.observationType.getValue();
    }

    public void setObservationType(ObservationIssueTriggerCodedObservationType observationType) {
        this.observationType.setValue(observationType);
    }

    @Hl7XmlMapping({ "value" })
    public IssueTriggerObservationValue getObservationValue() {
        return (IssueTriggerObservationValue) this.observationValue.getValue();
    }

    public void setObservationValue(IssueTriggerObservationValue observationValue) {
        this.observationValue.setValue(observationValue);
    }

    @Hl7XmlMapping({ "confidentialityCode" })
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }
}