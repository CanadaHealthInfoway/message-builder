/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.MedicationRecord;



@Hl7PartTypeMapping({"PORX_IN060380CA"})
public class MedicationProfileDetailQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<MedicationRecord,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110127L;

}
