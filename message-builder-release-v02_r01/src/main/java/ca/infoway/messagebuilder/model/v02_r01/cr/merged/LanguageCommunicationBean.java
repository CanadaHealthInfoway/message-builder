/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT101001CA.LanguageCommunication","PRPA_MT101002CA.LanguageCommunication","PRPA_MT101102CA.LanguageCommunication","PRPA_MT101104CA.LanguageCommunication"})
public class LanguageCommunicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private BL languageOfCommunicationPreferenceIndicator = new BLImpl();
    private CV languageOfCommunicationCode = new CVImpl();


    /**
     * <p>LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Language of Communication Preference Indicator</p>
     */
    @Hl7XmlMapping({"preferenceInd"})
    public Boolean getLanguageOfCommunicationPreferenceIndicator() {
        return this.languageOfCommunicationPreferenceIndicator.getValue();
    }
    public void setLanguageOfCommunicationPreferenceIndicator(Boolean languageOfCommunicationPreferenceIndicator) {
        this.languageOfCommunicationPreferenceIndicator.setValue(languageOfCommunicationPreferenceIndicator);
    }


    /**
     * <p>LanguageOfCommunicationCode</p>
     * 
     * <p>Language of Communication Code</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageOfCommunicationCode() {
        return (HumanLanguage) this.languageOfCommunicationCode.getValue();
    }
    public void setLanguageOfCommunicationCode(HumanLanguage languageOfCommunicationCode) {
        this.languageOfCommunicationCode.setValue(languageOfCommunicationCode);
    }

}