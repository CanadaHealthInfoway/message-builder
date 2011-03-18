/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.v02_r02.pharmacy.merged.Prescription;
import ca.infoway.messagebuilder.model.v02_r02.pharmacy.merged.UnfilledPrescriptionQueryParametersBean;



@Hl7PartTypeMapping({"PORX_IN060480CA"})
public class UnfilledPrescrByPrescriberQueryResponseBean extends HL7Message_1Bean<TriggerEvent_5Bean<Prescription,UnfilledPrescriptionQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
