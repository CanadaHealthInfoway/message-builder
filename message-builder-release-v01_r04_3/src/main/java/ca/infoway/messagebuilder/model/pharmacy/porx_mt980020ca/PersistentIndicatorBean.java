/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt980020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Persistent Indicator</p>
 * 
 * <p>Indicates that this issue will be persisted as part of 
 * the patient's record.</p>
 * 
 * <p>Some issues are transitory and are only relevant while a 
 * request is being made. Others are relevant for clinical 
 * communication and need to be made available after the fact. 
 * When deciding whether and how to manage an issue, it is 
 * important to recognize which category it fits within.</p>
 * 
 * <p>This element behaves as a mandatory boolean where the 
 * presence of the association indicates true and the absence 
 * of the association indicates false.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980020CA.StorageIntent"})
public class PersistentIndicatorBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;

}
