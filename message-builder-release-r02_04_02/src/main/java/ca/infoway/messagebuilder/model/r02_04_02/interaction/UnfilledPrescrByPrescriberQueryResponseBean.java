/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged.Prescription;
import ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged.UnfilledPrescriptionQueryParametersBean;



@Hl7PartTypeMapping({"PORX_IN060480CA"})
public class UnfilledPrescrByPrescriberQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<Prescription,UnfilledPrescriptionQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
