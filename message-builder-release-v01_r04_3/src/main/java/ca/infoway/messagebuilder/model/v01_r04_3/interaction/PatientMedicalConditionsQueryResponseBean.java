/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.v01_r04_3.iehr.repc_mt000007ca.MedicalConditionBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.GenericQueryParametersBean;



@Hl7PartTypeMapping({"REPC_IN000024CA"})
public class PatientMedicalConditionsQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<MedicalConditionBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
