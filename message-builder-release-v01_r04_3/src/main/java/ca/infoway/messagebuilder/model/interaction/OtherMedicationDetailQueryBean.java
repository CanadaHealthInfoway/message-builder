/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.ParameterListBean;



/**
 * <p>Requests retrieval of detailed information about a single 
 * ""other medication"" record, referenced by identifier.</p>
 */
@Hl7PartTypeMapping({"PORX_IN060450CA"})
public class OtherMedicationDetailQueryBean extends HL7MessageBean<TriggerEventBean<ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
