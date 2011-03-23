/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.iehr.repc_mt000004ca.AllergyIntoleranceQueryParametersBean;
import ca.infoway.messagebuilder.model.iehr.repc_mt000005ca.AllergyIntoleranceBean;



@Hl7PartTypeMapping({"REPC_IN000016CA"})
public class PatientAllergyIntoleranceQueryResponseBean extends HL7MessageBean<TriggerEventBean<AllergyIntoleranceBean,AllergyIntoleranceQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100603L;

}
