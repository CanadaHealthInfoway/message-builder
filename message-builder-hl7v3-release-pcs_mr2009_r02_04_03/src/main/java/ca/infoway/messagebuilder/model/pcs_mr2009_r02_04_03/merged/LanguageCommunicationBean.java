/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

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



/**
 * <p>PRPM_MT306011CA.LanguageCommunication: Language of 
 * Communication</p>
 * 
 * <p><p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * languages used by client for the purposes of 
 * communication</p></p>
 * 
 * <p>PRPA_MT101102CA.LanguageCommunication: Language 
 * Communication</p>
 * 
 * <p><p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * languages used by client for the purposes of 
 * communication</p></p>
 * 
 * <p>PRPA_MT101001CA.LanguageCommunication: 
 * LanguageCommunication</p>
 * 
 * <p><p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * languages used by client for the purposes of 
 * communication</p></p>
 * 
 * <p>PRPA_MT101002CA.LanguageCommunication: 
 * LanguageCommunication</p>
 * 
 * <p><p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * languages used by client for the purposes of 
 * communication</p></p>
 * 
 * <p>PRPA_MT101104CA.LanguageCommunication: 
 * LanguageCommunication</p>
 * 
 * <p><p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * languages used by client for the purposes of 
 * communication</p></p>
 * 
 * <p>PRPM_MT303010CA.LanguageCommunication: Language of 
 * Communication</p>
 * 
 * <p><p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * languages used by client for the purposes of 
 * communication</p></p>
 * 
 * <p>PRPM_MT301010CA.LanguageCommunication: Language of 
 * Communication</p>
 * 
 * <p><p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * languages used by the provider for the purposes of 
 * communication</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT101001CA.LanguageCommunication","PRPA_MT101002CA.LanguageCommunication","PRPA_MT101102CA.LanguageCommunication","PRPA_MT101104CA.LanguageCommunication","PRPM_MT301010CA.LanguageCommunication","PRPM_MT303010CA.LanguageCommunication","PRPM_MT306011CA.LanguageCommunication"})
public class LanguageCommunicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CV languageCode = new CVImpl();
    private CV modeCode = new CVImpl();
    private CV proficiencyLevelCode = new CVImpl();
    private BL preferenceInd = new BLImpl();


    /**
     * <p>LanguageOfCommunicationCode</p>
     * 
     * <p>Language of Communication Code</p>
     * 
     * <p><p>A code indicating the language of communication</p></p>
     * 
     * <p><p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p></p>
     * 
     * <p>Language of Communication Code</p>
     * 
     * <p><p>A code indicating the language of communication</p></p>
     * 
     * <p><p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in.</p></p>
     * 
     * <p>Language of Communication Code</p>
     * 
     * <p><p>A code indicating the language of communication</p></p>
     * 
     * <p><p>Required attribute conveying the expected language 
     * message elements are to be transmitted in</p></p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>LanguageOfCommunicationSkillsCode</p>
     * 
     * <p>Language of Communication Skills Code</p>
     * 
     * <p><p>Indicates the healthcare provider's ability to 
     * communicate in the indicated language i.e. written, spoken, 
     * read</p></p>
     * 
     * <p><p>Required attribute provides additional information 
     * about the healthcare provider's communication skills in a 
     * given language</p></p>
     */
    @Hl7XmlMapping({"modeCode"})
    public LanguageAbilityMode getModeCode() {
        return (LanguageAbilityMode) this.modeCode.getValue();
    }
    public void setModeCode(LanguageAbilityMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>LanguageOfCommunicationProficiencyLevelCode</p>
     * 
     * <p>Language of Communication Proficiency Level Code</p>
     * 
     * <p><p>Indicates the proficiency level at which healthcare 
     * provider is able to communicate in the indicated language of 
     * communication</p></p>
     * 
     * <p><p>Required attribute provides additional information 
     * about the healthcare provider's communication skills in a 
     * given language</p></p>
     */
    @Hl7XmlMapping({"proficiencyLevelCode"})
    public LanguageAbilityProficiency getProficiencyLevelCode() {
        return (LanguageAbilityProficiency) this.proficiencyLevelCode.getValue();
    }
    public void setProficiencyLevelCode(LanguageAbilityProficiency proficiencyLevelCode) {
        this.proficiencyLevelCode.setValue(proficiencyLevelCode);
    }


    /**
     * <p>LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Language of Communication Preference Indicator</p>
     * 
     * <p><p>Indicates the preferred language for all 
     * communications.</p></p>
     * 
     * <p><p>Required attribute that supports the business 
     * requirement to indicate the preferred language for all 
     * communications.</p></p>
     */
    @Hl7XmlMapping({"preferenceInd"})
    public Boolean getPreferenceInd() {
        return this.preferenceInd.getValue();
    }
    public void setPreferenceInd(Boolean preferenceInd) {
        this.preferenceInd.setValue(preferenceInd);
    }

}
