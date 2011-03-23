/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pharmacy.pome_mt010090ca.DrugQueryParametersBean;



/**
 * <p>Requests retrieval of a lists of candidate drugs based on 
 * various search criteria such as name, route, code, 
 * manufacturer, appearance, etc.</p>
 */
@Hl7PartTypeMapping({"POME_IN010070CA"})
public class DrugSearchQueryBean extends HL7MessageBean<TriggerEventBean<DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
