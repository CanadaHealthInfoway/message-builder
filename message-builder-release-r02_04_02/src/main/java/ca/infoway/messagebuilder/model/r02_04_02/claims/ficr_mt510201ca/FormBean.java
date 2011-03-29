/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT510201CA.Form"})
public class FormBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private TEL uRLForLocationForForm = new TELImpl();


    /**
     * <p>URL for location for form</p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getURLForLocationForForm() {
        return this.uRLForLocationForForm.getValue();
    }
    public void setURLForLocationForForm(TelecommunicationAddress uRLForLocationForForm) {
        this.uRLForLocationForForm.setValue(uRLForLocationForForm);
    }

}