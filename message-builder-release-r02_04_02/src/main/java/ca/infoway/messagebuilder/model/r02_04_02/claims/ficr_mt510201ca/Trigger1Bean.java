/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.AdjudicationResultRequiredActBean;



/**
 * <p><p>Select association below for required acts that do not 
 * have associated adjudication reason &amp; adjudication 
 * information codes.</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.Trigger1"})
public class Trigger1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private BL negationInd = new BLImpl();
    private AdjudicationResultRequiredActBean adjudicationResultRequiredAct;


    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    @Hl7XmlMapping({"adjudicationResultRequiredAct"})
    public AdjudicationResultRequiredActBean getAdjudicationResultRequiredAct() {
        return this.adjudicationResultRequiredAct;
    }
    public void setAdjudicationResultRequiredAct(AdjudicationResultRequiredActBean adjudicationResultRequiredAct) {
        this.adjudicationResultRequiredAct = adjudicationResultRequiredAct;
    }

}