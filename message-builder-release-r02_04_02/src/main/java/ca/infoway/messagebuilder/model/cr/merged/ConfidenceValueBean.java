/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.domainvalue.ObservationQueryMatchType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.math.BigDecimal;



/**
 * <p>ConfidenceValue</p>
 * 
 * <p>PRPA_MT101106CA.ObservationEvent: Confidence Value</p>
 * 
 * <p><p>Each returned IdentifiedPerson can have an associated 
 * ObservationEvent reporting the confidence value (degree of 
 * certainty) and the name of the matching algorithm that 
 * resulted in that record's inclusion in the result set.</p></p>
 * 
 * <p><p>Supports the business requirement to provide a 
 * confidence value associated with the identifiedEntity 
 * returned in the responsedistinguishes these different 
 * representations.</p></p>
 * 
 * <p>PRPA_MT101102CA.ObservationEvent: Confidence Value</p>
 * 
 * <p><p>Each returned IdentifiedPerson can have an associated 
 * ObservationEvent reporting the confidence value (degree of 
 * certainty) and the name of the matching algorithm that 
 * resulted in that record's inclusion in the result set.</p></p>
 * 
 * <p><p>Supports the business requirement to provide a 
 * confidence value associated with the identifiedEntity 
 * returned in the response distinguishes these different 
 * representations.</p></p>
 * 
 * <p>PRPA_MT101104CA.ObservationEvent: Confidence Value</p>
 * 
 * <p><p>Each returned IdentifiedPerson can have an associated 
 * ObservationEvent reporting the confidence value (degree of 
 * certainty) and the name of the matching algorithm that 
 * resulted in that record's inclusion in the result set.</p></p>
 * 
 * <p><p>Supports the business requirement to provide a 
 * confidence value associated with the identifiedEntity 
 * returned in the responsedistinguishes these different 
 * representations.</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT101102CA.ObservationEvent","PRPA_MT101104CA.ObservationEvent","PRPA_MT101106CA.ObservationEvent"})
public class ConfidenceValueBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private REAL confidenceValue = new REALImpl();
    private CV probabilityMatchCode = new CVImpl();


    /**
     * <p>ConfidenceValue</p>
     * 
     * <p>Confidence Value</p>
     * 
     * <p><p>A real number value indicating the confidence of the 
     * query with regard to finding the intended target client i.e. 
     * the value would be the computed confidence value.</p></p>
     * 
     * <p><p>Required attribute to provide information about 
     * success of query</p></p>
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
     * <p>*Probability Match Code</p>
     * 
     * <p><p>Supports the business requirement to identify type of 
     * confidence matching used i.e. the code would be the name for 
     * the algorithm for the confidence value</p></p>
     * 
     * <p><p>Mandatory attribute supports confident identification 
     * of intended client</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationQueryMatchType getProbabilityMatchCode() {
        return (ObservationQueryMatchType) this.probabilityMatchCode.getValue();
    }
    public void setProbabilityMatchCode(ObservationQueryMatchType probabilityMatchCode) {
        this.probabilityMatchCode.setValue(probabilityMatchCode);
    }

}
