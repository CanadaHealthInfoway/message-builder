/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.v02_r02.pharmacy.porx_mt060060ca.PrescriptionBean;
import ca.infoway.messagebuilder.model.v02_r02.pharmacy.porx_mt060070ca.QueryParametersBean;



@Hl7PartTypeMapping({"PORX_IN060140CA"})
public class DevicePrescriptionSummaryQueryResponseBean extends HL7Message_1Bean<TriggerEvent_5Bean<PrescriptionBean,QueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
