/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt230002ca.ClinicalObservationDocumentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt230004ca.QueryDefinitionBean;



@Hl7PartTypeMapping({"REPC_IN000089CA"})
public class PatientClinicalObsDocSummariesQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<ClinicalObservationDocumentBean,QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110831L;

}
