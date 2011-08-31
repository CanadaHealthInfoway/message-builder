/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.PrescriptionDispenseBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060080ca.GenericQueryParametersBean;



@Hl7PartTypeMapping({"PORX_IN060120CA"})
public class DevicePrescriptionFillsQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<PrescriptionDispenseBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110831L;

}
