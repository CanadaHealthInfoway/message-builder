/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicationResultReason"})
public class AdjudicationResultReasonBean extends MessagePartBean implements AdjudicationCodeChoiceBean {

    private static final long serialVersionUID = 20100615L;
    private ST value = new STImpl();

    @Hl7XmlMapping({"value"})
    public String getValue() {
        return this.value.getValue();
    }
    public void setValue(String value) {
        this.value.setValue(value);
    }

}
