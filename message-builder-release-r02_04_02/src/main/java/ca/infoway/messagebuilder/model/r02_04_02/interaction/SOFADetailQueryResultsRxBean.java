/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.ParameterList_2Bean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.qucr_mt830201ca.TypeOfSummaryBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.TriggerEvent_6Bean;



@Hl7PartTypeMapping({"QUCR_IN830102CA"})
public class SOFADetailQueryResultsRxBean extends HL7Message_1Bean<TriggerEvent_6Bean<TypeOfSummaryBean,ParameterList_2Bean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
