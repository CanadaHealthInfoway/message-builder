/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.math.BigDecimal;



@Hl7PartTypeMapping({"PRPA_MT101102CA.ObservationEvent","PRPA_MT101104CA.ObservationEvent","PRPA_MT101106CA.ObservationEvent"})
public class ConfidenceValueBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private REAL confidenceValue = new REALImpl();
    private CD probabilityMatchCode = new CDImpl();


    /**
     * <p>ConfidenceValue</p>
     * 
     * <p>Confidence Value</p>
     */
    @Hl7XmlMapping({"value"})
    public BigDecimal getConfidenceValue() {
        return this.confidenceValue.getValue();
    }
    public void setConfidenceValue(BigDecimal confidenceValue) {
        this.confidenceValue.setValue(confidenceValue);
    }


    /**
     * <p>ProbabilityMatchCode</p>
     * 
     * <p>Probability Match Code</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getProbabilityMatchCode() {
        return (ActCode) this.probabilityMatchCode.getValue();
    }
    public void setProbabilityMatchCode(ActCode probabilityMatchCode) {
        this.probabilityMatchCode.setValue(probabilityMatchCode);
    }

}