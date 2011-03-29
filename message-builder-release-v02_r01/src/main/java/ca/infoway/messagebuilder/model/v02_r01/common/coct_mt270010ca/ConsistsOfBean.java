/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT270010CA.Component17"})
public class ConsistsOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private INT dosageLineOrder = new INTImpl();
    private StructuredDosageLinesBean dosageLine;


    /**
     * <p>A:Dosage Line Order</p>
     */
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