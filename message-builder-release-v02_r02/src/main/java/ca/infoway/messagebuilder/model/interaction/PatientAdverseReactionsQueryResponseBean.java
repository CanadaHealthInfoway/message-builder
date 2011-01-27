/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.iehr.repc_mt000006ca.ReportedReactionBean;
import ca.infoway.messagebuilder.model.merged.GenericQueryParametersBean;



@Hl7PartTypeMapping({"REPC_IN000002CA"})
public class PatientAdverseReactionsQueryResponseBean extends HL7Message_1Bean<TriggerEvent_5Bean<ReportedReactionBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110127L;

}
