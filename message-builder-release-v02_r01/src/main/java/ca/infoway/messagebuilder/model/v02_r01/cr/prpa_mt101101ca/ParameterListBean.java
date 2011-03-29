/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.cr.prpa_mt101101ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT101101CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II clientHealthcareIdentificationNumber = new IIImpl();
    private II clientIDPubValue = new IIImpl();


    /**
     * <p>Client Healthcare Identification Number</p>
     */
    @Hl7XmlMapping({"clientIDBus/value"})
    public Identifier getClientHealthcareIdentificationNumber() {
        return this.clientHealthcareIdentificationNumber.getValue();
    }
    public void setClientHealthcareIdentificationNumber(Identifier clientHealthcareIdentificationNumber) {
        this.clientHealthcareIdentificationNumber.setValue(clientHealthcareIdentificationNumber);
    }


    /**
     * <p>Client Healthcare Identification Number</p>
     */
    @Hl7XmlMapping({"clientIDPub/value"})
    public Identifier getClientIDPubValue() {
        return this.clientIDPubValue.getValue();
    }
    public void setClientIDPubValue(Identifier clientIDPubValue) {
        this.clientIDPubValue.setValue(clientIDPubValue);
    }

}