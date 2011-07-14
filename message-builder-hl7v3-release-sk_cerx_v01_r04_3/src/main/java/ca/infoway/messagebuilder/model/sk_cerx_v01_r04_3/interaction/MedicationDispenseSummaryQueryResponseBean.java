/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt060100ca.DispenseBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.quqi_mt120000ca.TriggerEventBean;



@Hl7PartTypeMapping({"PORX_IN060240CA"})
public class MedicationDispenseSummaryQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<DispenseBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110714L;

}
