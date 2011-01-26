/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.claims.merged.AdjudicationResultRequiredActBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicationCodeChoice"})
public interface AdjudicationCodeChoice {

    public List<AdjudicationResultRequiredActBean> getTriggerAdjudicationResultRequiredAct();

}
