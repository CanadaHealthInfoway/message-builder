/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.ImmunizationsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt060140ca.ImmunizationQueryParametersBean;



@Hl7PartTypeMapping({"POIZ_IN020020CA"})
public class ImmunizationsQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<ImmunizationsBean,ImmunizationQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110407L;

}
