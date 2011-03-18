/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>b:consists of</p>
 * 
 * <p><p>Dosage instructions may be given as textual 
 * information (as in Ad-hoc Dosage Instructions specified 
 * above) or as a structured set of dosage lines. This 
 * association allows for the specification of structured 
 * dosage lines.</p></p>
 * 
 * <p><p>Structured dosage lines facilitate the checking of 
 * dosage appropriateness. It also allows for the formal 
 * calculation of days supply based on administration 
 * instructions and supplied quantity.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.Component17"})
public class ConsistsOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private INT dosageLineOrder = new INTImpl();
    private StructuredDosageLinesBean dosageLine;


    /**
     * <p>A:Dosage Line Order</p>
     * 
     * <p><p>Indicates the order in which dosage lines should be 
     * performed. Ensures that each step of multiple and complex 
     * SIGs (e.g ramp up/down) is in the desired order. Dosage 
     * lines with the same sequence number should be performed in 
     * parallel. E.g. 2 tabs tid for 3 days (sequence 1) and then 1 
     * tab tid for 4 days (sequence 2) E.g. 1 tab in the morning 
     * (sequence 1) and 2 tabs at bedtime (sequence 1)</p></p>
     * 
     * <p><p>ZDP.13.10</p></p>
     * 
     * <p><p>Clearly expresses the order of each dosage line to 
     * ensure the correct dosage is given. Element is mandatory to 
     * ensure that dosage lines are specified and followed in the 
     * order intended.</p></p>
     * 
     * <p><p>Need examples to illustrate use of sequence lines with 
     * 'ANDs' and 'THENs'.</p></p>
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
