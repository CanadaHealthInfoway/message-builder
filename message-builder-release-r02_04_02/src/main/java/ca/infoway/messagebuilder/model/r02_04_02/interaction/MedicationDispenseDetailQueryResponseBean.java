/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged.DrugPrescriptionDetailQueryParametersBean;
import ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged.MedicationDispenseBean;



@Hl7PartTypeMapping({"PORX_IN060220CA"})
public class MedicationDispenseDetailQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<MedicationDispenseBean,DrugPrescriptionDetailQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
