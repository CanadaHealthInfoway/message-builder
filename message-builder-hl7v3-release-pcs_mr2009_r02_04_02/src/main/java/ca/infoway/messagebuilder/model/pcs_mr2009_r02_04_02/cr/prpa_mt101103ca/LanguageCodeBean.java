/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT101103CA.LanguageCode"})
public class LanguageCodeBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV languageOfCommunicationCode = new CVImpl();


    /**
     * <p>Language of Communication Code</p>
     */
    @Hl7XmlMapping({"value"})
    public HumanLanguage getLanguageOfCommunicationCode() {
        return (HumanLanguage) this.languageOfCommunicationCode.getValue();
    }
    public void setLanguageOfCommunicationCode(HumanLanguage languageOfCommunicationCode) {
        this.languageOfCommunicationCode.setValue(languageOfCommunicationCode);
    }

}
