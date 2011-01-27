/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.GenericQueryParametersBean;



@Hl7PartTypeMapping({"PORX_IN050040CA"})
public class PatientDrugContraindicationsQueryResponseBean extends HL7Message_1Bean<TriggerEvent_5Bean<IssuesBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110127L;

}
