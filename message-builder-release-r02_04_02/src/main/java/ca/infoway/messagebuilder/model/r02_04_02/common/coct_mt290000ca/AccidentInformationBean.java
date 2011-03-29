/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt290000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT290000CA.AccidentInformation"})
public class AccidentInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private INT injuryCodingPriority = new INTImpl();
    private AccidentInjuryCodingBean accidentInjuryCoding;


    /**
     * <p>Injury coding priority</p>
     * 
     * <p><p>Sets of injury observations are tied together with the 
     * same sequence number</p></p>
     * 
     * <p><p>Used for more than one set of injury coding.</p></p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getInjuryCodingPriority() {
        return this.injuryCodingPriority.getValue();
    }
    public void setInjuryCodingPriority(Integer injuryCodingPriority) {
        this.injuryCodingPriority.setValue(injuryCodingPriority);
    }


    @Hl7XmlMapping({"accidentInjuryCoding"})
    public AccidentInjuryCodingBean getAccidentInjuryCoding() {
        return this.accidentInjuryCoding;
    }
    public void setAccidentInjuryCoding(AccidentInjuryCodingBean accidentInjuryCoding) {
        this.accidentInjuryCoding = accidentInjuryCoding;
    }

}