/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.comt_mt111111ca.Summary;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.QueryDefinitionBean;



@Hl7PartTypeMapping({"COMT_IN200000CA"})
public class ClinicalSummaryProfileQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<Summary,QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
