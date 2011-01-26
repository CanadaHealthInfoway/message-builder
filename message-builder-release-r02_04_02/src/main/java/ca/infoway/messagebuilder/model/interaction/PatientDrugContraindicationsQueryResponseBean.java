/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.DrugQueryParametersBean;



@Hl7PartTypeMapping({"PORX_IN050040CA"})
public class PatientDrugContraindicationsQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<IssuesBean,DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110126L;

}
