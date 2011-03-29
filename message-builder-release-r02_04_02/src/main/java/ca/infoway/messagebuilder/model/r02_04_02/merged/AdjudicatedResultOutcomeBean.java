/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedResultOutcome","FICR_MT610201CA.AdjudicatedResultOutcome"})
public class AdjudicatedResultOutcomeBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private AdjudicationResultBean adjudicationResult;


    @Hl7XmlMapping({"adjudicationResult"})
    public AdjudicationResultBean getAdjudicationResult() {
        return this.adjudicationResult;
    }
    public void setAdjudicationResult(AdjudicationResultBean adjudicationResult) {
        this.adjudicationResult = adjudicationResult;
    }

}