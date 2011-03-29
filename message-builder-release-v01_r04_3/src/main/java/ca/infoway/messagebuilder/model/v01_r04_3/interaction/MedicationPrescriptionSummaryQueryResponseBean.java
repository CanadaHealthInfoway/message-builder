/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.CombinedMedicationRequest_1Bean;



@Hl7PartTypeMapping({"PORX_IN060300CA"})
public class MedicationPrescriptionSummaryQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<CombinedMedicationRequest_1Bean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}