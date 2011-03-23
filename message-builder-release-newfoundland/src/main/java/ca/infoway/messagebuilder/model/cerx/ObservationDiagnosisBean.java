package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ 
	"PORX_MT980050CA.ObservationDiagnosis",
	"COCT_MT120402CA.ObservationProblem"
	})
public class ObservationDiagnosisBean extends MessagePartBean implements Serializable, Indication {

    private static final long serialVersionUID = 172164418515335874L;

    private CD code = new CDImpl();

    private ST text = new STImpl();

    private CD value = new CDImpl();

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("text")
    public String getText() {
        return this.text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    @Hl7XmlMapping("value")
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }

    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }
}
