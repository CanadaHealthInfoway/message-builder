/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.pharmacy.merged.DrugQueryParametersBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.MedicationRecord;



@Hl7PartTypeMapping({"PORX_IN060360CA"})
public class MedicationProfileDetailGenericQueryRespBean extends HL7Message_1Bean<TriggerEvent_6Bean<MedicationRecord,DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110126L;

}
