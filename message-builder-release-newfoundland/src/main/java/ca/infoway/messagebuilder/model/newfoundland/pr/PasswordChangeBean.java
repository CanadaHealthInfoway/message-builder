package ca.infoway.messagebuilder.model.newfoundland.pr;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "NLPN_MT100200CA.PasswordChange" })
public class PasswordChangeBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 3617565414992486010L;

    private ST text = new STImpl();

    @Hl7XmlMapping("text")
    public String getText() {
        return this.text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }
}
