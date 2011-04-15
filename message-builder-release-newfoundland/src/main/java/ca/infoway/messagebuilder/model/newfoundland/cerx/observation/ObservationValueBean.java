package ca.infoway.messagebuilder.model.newfoundland.cerx.observation;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.CommonClinicalObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "REPC_MT000018CA.SubObservationEvent", "REPC_MT100002CA.SubObservationEvent" })
public class ObservationValueBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -2133731163905048498L;

    private CD type = new CDImpl();

    private PQ value = new PQImpl();

    @Hl7XmlMapping("code")
    public CommonClinicalObservationType getType() {
        return (CommonClinicalObservationType) this.type.getValue();
    }

    public void setType(CommonClinicalObservationType type) {
        this.type.setValue(type);
    }

    @Hl7XmlMapping("value")
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }
}
