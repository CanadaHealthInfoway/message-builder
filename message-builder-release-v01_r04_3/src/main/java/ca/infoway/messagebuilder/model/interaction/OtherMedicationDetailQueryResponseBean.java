/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.ParameterListBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt060210ca.OtherMedicationBean;



/**
 * <p>Returns detailed information about a single ""other 
 * medication"" record, referenced by identifier.</p>
 */
@Hl7PartTypeMapping({"PORX_IN060460CA"})
public class OtherMedicationDetailQueryResponseBean extends HL7MessageBean<TriggerEventBean<OtherMedicationBean,ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
