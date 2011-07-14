/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.DrugQueryParametersBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.MonographsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.quqi_mt120000ca.TriggerEventBean;



@Hl7PartTypeMapping({"POME_IN010020CA"})
public class DrugDocumentQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<MonographsBean,DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110714L;

}
