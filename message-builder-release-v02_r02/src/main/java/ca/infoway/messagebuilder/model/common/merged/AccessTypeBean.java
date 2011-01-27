/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.ConsentGivenToBean;



/**
 * <p>AccessType</p>
 * 
 * <p>COCT_MT470012CA.InformDefinition: Access Type</p>
 * 
 * <p><p>Defines the types of information permission is being 
 * granted to access.</p></p>
 * 
 * <p><p>Allows discrete control over different types of 
 * information.</p></p>
 * 
 * <p>COCT_MT470002CA.InformDefinition: Access Type</p>
 * 
 * <p><p>Defines the types of information permission is being 
 * granted to access.</p></p>
 * 
 * <p><p>Allows discrete control over different types of 
 * information.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.InformDefinition","COCT_MT470012CA.InformDefinition"})
public class AccessTypeBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private ConsentGivenToBean receiver;
    private CV consentInformationTypes = new CVImpl();


    @Hl7XmlMapping({"receiver"})
    public ConsentGivenToBean getReceiver() {
        return this.receiver;
    }
    public void setReceiver(ConsentGivenToBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>ConsentInformationTypes</p>
     * 
     * <p>B:Consent Information Types</p>
     * 
     * <p><p>The type of patient, client, or provider information 
     * that can be accessed or modified.</p></p>
     * 
     * <p><p>Different consents (or even keywords) may be needed to 
     * access different types of patient, client, or provider 
     * information (e.g. demographics, medications, allergies, lab 
     * results). Understanding the type of information the consent 
     * applies to is critical, and therefore the attribute is 
     * mandatory.</p></p>
     * 
     * <p>B:Consent Information Types</p>
     * 
     * <p><p>The type of patient information that can be accessed 
     * or modified.</p></p>
     * 
     * <p><p>Different consents (or even keywords) may be needed to 
     * access different types of patient information (e.g. 
     * demographics, medications, allergies, lab results). 
     * Understanding the type of information the consent applies to 
     * is critical, and therefore the attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"subject/actDefinition/code"})
    public ActInformationAccessTypeCode getConsentInformationTypes() {
        return (ActInformationAccessTypeCode) this.consentInformationTypes.getValue();
    }
    public void setConsentInformationTypes(ActInformationAccessTypeCode consentInformationTypes) {
        this.consentInformationTypes.setValue(consentInformationTypes);
    }

}
