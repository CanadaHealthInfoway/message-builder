/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT101103CA.DeceasedIndicator"})
public class DeceasedIndicatorBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private BL deceasedIndicator = new BLImpl();

    @Hl7XmlMapping({"value"})
    public Boolean getDeceasedIndicator() {
        return this.deceasedIndicator.getValue();
    }
    public void setDeceasedIndicator(Boolean deceasedIndicator) {
        this.deceasedIndicator.setValue(deceasedIndicator);
    }

}
