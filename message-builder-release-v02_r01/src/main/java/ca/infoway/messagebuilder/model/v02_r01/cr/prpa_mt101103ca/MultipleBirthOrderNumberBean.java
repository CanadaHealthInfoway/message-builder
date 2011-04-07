/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT101103CA.MultipleBirthOrderNumber"})
public class MultipleBirthOrderNumberBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private INT clientMultipleBirthOrderNumber = new INTImpl();


    /**
     * <p>Client Multiple Birth Order Number</p>
     */
    @Hl7XmlMapping({"value"})
    public Integer getClientMultipleBirthOrderNumber() {
        return this.clientMultipleBirthOrderNumber.getValue();
    }
    public void setClientMultipleBirthOrderNumber(Integer clientMultipleBirthOrderNumber) {
        this.clientMultipleBirthOrderNumber.setValue(clientMultipleBirthOrderNumber);
    }

}
