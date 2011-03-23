/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.iehr.repc_mt230002ca.ClinicalObservationDocumentBean;
import ca.infoway.messagebuilder.model.iehr.repc_mt230004ca.QueryDefinitionBean;



@Hl7PartTypeMapping({"REPC_IN000089CA"})
public class PatientClinicalObsDocSummariesQueryResponseBean extends HL7MessageBean<TriggerEventBean<ClinicalObservationDocumentBean,QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100603L;

}
