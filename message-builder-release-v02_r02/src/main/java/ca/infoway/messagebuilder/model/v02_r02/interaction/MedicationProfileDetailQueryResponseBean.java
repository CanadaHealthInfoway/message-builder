/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.v02_r02.pharmacy.merged.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.v02_r02.pharmacy.merged.MedicationRecord;



@Hl7PartTypeMapping({"PORX_IN060380CA"})
public class MedicationProfileDetailQueryResponseBean extends HL7Message_1Bean<TriggerEvent_5Bean<MedicationRecord,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
