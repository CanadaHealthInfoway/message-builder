/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicationResultReason"})
public class AdjudicationResultReasonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.merged.AdjudicationCodeChoice {

    private static final long serialVersionUID = 20110127L;
    private ST actAdjudicationReason = new STImpl();


    /**
     * <p>ActAdjudication Reason</p>
     * 
     * <p><p>Reason for the adjudication.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public String getActAdjudicationReason() {
        return this.actAdjudicationReason.getValue();
    }
    public void setActAdjudicationReason(String actAdjudicationReason) {
        this.actAdjudicationReason.setValue(actAdjudicationReason);
    }

}
