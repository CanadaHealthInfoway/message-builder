/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.porx_mt060340ca.PrescriptionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.quqi_mt120000ca.TriggerEventBean;



@Hl7PartTypeMapping({"PORX_IN060180CA"})
public class MedPrescrWithHistAndDispensesQueryRespBean extends HL7Message_1Bean<TriggerEventBean<PrescriptionBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110714L;

}
