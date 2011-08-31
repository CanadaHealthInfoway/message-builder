/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.AdjudicationResultRequiredActBean;



@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicationResultReason"})
public class AdjudicationResultReasonBean extends MessagePartBean implements AdjudicationCodeChoice {

    private static final long serialVersionUID = 20110831L;
    private List<AdjudicationResultRequiredActBean> triggerAdjudicationResultRequiredAct = new ArrayList<AdjudicationResultRequiredActBean>();
    private ED<EncapsulatedData> adjudicatedResultReason = new EDImpl<EncapsulatedData>();


    @Hl7XmlMapping({"trigger/adjudicationResultRequiredAct"})
    public List<AdjudicationResultRequiredActBean> getTriggerAdjudicationResultRequiredAct() {
        return this.triggerAdjudicationResultRequiredAct;
    }


    /**
     * <p>Adjudicated Result Reason</p>
     */
    @Hl7XmlMapping({"value"})
    public EncapsulatedData getAdjudicatedResultReason() {
        return this.adjudicatedResultReason.getValue();
    }
    public void setAdjudicatedResultReason(EncapsulatedData adjudicatedResultReason) {
        this.adjudicatedResultReason.setValue(adjudicatedResultReason);
    }

}
