/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>b:consists of</p>
 * 
 * <p>Dosage instructions may be given as textual information 
 * (as in Ad-hoc Dosage Instructions specified above) or as a 
 * structured set of dosage lines. This association allows for 
 * the specification of structured dosage lines.</p>
 * 
 * <p>Structured dosage lines facilitate the checking of dosage 
 * appropriateness. It also allows for the formal calculation 
 * of days supply based on administration instructions and 
 * supplied quantity.</p>
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.Component17"})
public class ConsistsOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private INT dosageLineOrder = new INTImpl();
    private StructuredDosageLinesBean dosageLine;

    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getDosageLineOrder() {
        return this.dosageLineOrder.getValue();
    }
    public void setDosageLineOrder(Integer dosageLineOrder) {
        this.dosageLineOrder.setValue(dosageLineOrder);
    }

    @Hl7XmlMapping({"dosageLine"})
    public StructuredDosageLinesBean getDosageLine() {
        return this.dosageLine;
    }
    public void setDosageLine(StructuredDosageLinesBean dosageLine) {
        this.dosageLine = dosageLine;
    }

}
