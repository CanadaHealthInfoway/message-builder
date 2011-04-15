package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;
import java.math.BigDecimal;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PRPA_MT101104CA.ObservationEvent" })
public class ObservationEventMatchBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -9105897749766362384L;

    private CD code = new CDImpl();

    private REAL value = new REALImpl();

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("value")
    public BigDecimal getValue() {
        return this.value.getValue();
    }

    public void setValue(BigDecimal value) {
        this.value.setValue(value);
    }
}
