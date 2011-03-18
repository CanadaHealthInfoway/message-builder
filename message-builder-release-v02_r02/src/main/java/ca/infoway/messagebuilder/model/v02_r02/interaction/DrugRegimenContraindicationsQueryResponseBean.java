/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.v02_r02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.v02_r02.pharmacy.porx_mt050010ca.GenericQueryParametersBean;



@Hl7PartTypeMapping({"PORX_IN050020CA"})
public class DrugRegimenContraindicationsQueryResponseBean extends HL7Message_1Bean<TriggerEvent_5Bean<IssuesBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110318L;

}
