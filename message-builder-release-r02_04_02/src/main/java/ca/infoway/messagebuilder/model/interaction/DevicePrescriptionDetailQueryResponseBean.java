/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.pharmacy.merged.DrugPrescriptionDetailQueryParametersBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt060040ca.PrescriptionBean;



@Hl7PartTypeMapping({"PORX_IN060100CA"})
public class DevicePrescriptionDetailQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<PrescriptionBean,DrugPrescriptionDetailQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110126L;

}
