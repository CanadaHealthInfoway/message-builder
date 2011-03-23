/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POIZ_MT030050CA.AntigenValidity","POIZ_MT030060CA.AntigenValidity","POIZ_MT060150CA.AntigenValidity","POIZ_MT061150CA.AntigenValidity"})
public class AntigenValidityBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CV invalidAntigenReasonCode = new CVImpl();
    private BL antigenValidityIndicator = new BLImpl();

    @Hl7XmlMapping({"reasonCode"})
    public Code getInvalidAntigenReasonCode() {
        return (Code) this.invalidAntigenReasonCode.getValue();
    }
    public void setInvalidAntigenReasonCode(Code invalidAntigenReasonCode) {
        this.invalidAntigenReasonCode.setValue(invalidAntigenReasonCode);
    }

    @Hl7XmlMapping({"value"})
    public Boolean getAntigenValidityIndicator() {
        return this.antigenValidityIndicator.getValue();
    }
    public void setAntigenValidityIndicator(Boolean antigenValidityIndicator) {
        this.antigenValidityIndicator.setValue(antigenValidityIndicator);
    }

}
