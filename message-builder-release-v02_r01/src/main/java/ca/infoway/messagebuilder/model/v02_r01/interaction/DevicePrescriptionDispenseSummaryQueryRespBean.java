/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v02_r01.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged.PrescriptionDispenseBean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.porx_mt060030ca.GenericQueryParametersBean;



@Hl7PartTypeMapping({"PORX_IN060080CA"})
public class DevicePrescriptionDispenseSummaryQueryRespBean extends HL7Message_1Bean<TriggerEvent_5Bean<PrescriptionDispenseBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
