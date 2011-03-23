/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.LanguageAbilityMode;
import ca.infoway.messagebuilder.domainvalue.LanguageAbilityProficiency;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT101001CA.LanguageCommunication","PRPA_MT101002CA.LanguageCommunication","PRPA_MT101102CA.LanguageCommunication","PRPA_MT101104CA.LanguageCommunication","PRPM_MT301010CA.LanguageCommunication","PRPM_MT303010CA.LanguageCommunication","PRPM_MT306011CA.LanguageCommunication"})
public class LanguageCommunicationBean extends MessagePartBean {

    private CV<HumanLanguage> languageOfCommunicationCode = new CVImpl<HumanLanguage>();
    private CV<LanguageAbilityMode> languageOfCommunicationSkillsCode = new CVImpl<LanguageAbilityMode>();
    private CV<LanguageAbilityProficiency> languageOfCommunicationProficiencyLevelCode = new CVImpl<LanguageAbilityProficiency>();
    private BL languageOfCommunicationPreferenceIndicator = new BLImpl();

    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageOfCommunicationCode() {
        return this.languageOfCommunicationCode.getValue();
    }
    public void setLanguageOfCommunicationCode(HumanLanguage languageOfCommunicationCode) {
        this.languageOfCommunicationCode.setValue(languageOfCommunicationCode);
    }

    @Hl7XmlMapping({"modeCode"})
    public LanguageAbilityMode getLanguageOfCommunicationSkillsCode() {
        return this.languageOfCommunicationSkillsCode.getValue();
    }
    public void setLanguageOfCommunicationSkillsCode(LanguageAbilityMode languageOfCommunicationSkillsCode) {
        this.languageOfCommunicationSkillsCode.setValue(languageOfCommunicationSkillsCode);
    }

    @Hl7XmlMapping({"proficiencyLevelCode"})
    public LanguageAbilityProficiency getLanguageOfCommunicationProficiencyLevelCode() {
        return this.languageOfCommunicationProficiencyLevelCode.getValue();
    }
    public void setLanguageOfCommunicationProficiencyLevelCode(LanguageAbilityProficiency languageOfCommunicationProficiencyLevelCode) {
        this.languageOfCommunicationProficiencyLevelCode.setValue(languageOfCommunicationProficiencyLevelCode);
    }

    @Hl7XmlMapping({"preferenceInd"})
    public java.lang.Boolean getLanguageOfCommunicationPreferenceIndicator() {
        return this.languageOfCommunicationPreferenceIndicator.getValue();
    }
    public void setLanguageOfCommunicationPreferenceIndicator(java.lang.Boolean languageOfCommunicationPreferenceIndicator) {
        this.languageOfCommunicationPreferenceIndicator.setValue(languageOfCommunicationPreferenceIndicator);
    }

}
