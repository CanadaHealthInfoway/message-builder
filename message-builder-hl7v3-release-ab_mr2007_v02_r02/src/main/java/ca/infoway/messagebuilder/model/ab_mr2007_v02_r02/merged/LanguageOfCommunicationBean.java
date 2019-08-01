/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

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
 * <p>PRPA_MT101002CA.LanguageCommunication: 
 * LanguageCommunication</p>
 * 
 * <p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p>
 * 
 * <p>Supports the business requirement to identify languages 
 * used by client for the purposes of communication</p>
 * 
 * <p>PRPM_MT306011CA.LanguageCommunication: Language of 
 * Communication</p>
 * 
 * <p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p>
 * 
 * <p>Supports the business requirement to identify languages 
 * used by client for the purposes of communication</p>
 * 
 * <p>PRPA_MT101001CA.LanguageCommunication: 
 * LanguageCommunication</p>
 * 
 * <p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p>
 * 
 * <p>Supports the business requirement to identify languages 
 * used by client for the purposes of communication</p>
 * 
 * <p>PRPM_MT301010CA.LanguageCommunication: Language of 
 * Communication</p>
 * 
 * <p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p>
 * 
 * <p>Supports the business requirement to identify languages 
 * used by the provider for the purposes of communication</p>
 * 
 * <p>PRPM_MT303010CA.LanguageCommunication: Language of 
 * Communication</p>
 * 
 * <p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p>
 * 
 * <p>Supports the business requirement to identify languages 
 * used by client for the purposes of communication</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101001CA.LanguageCommunication","PRPA_MT101002CA.LanguageCommunication","PRPM_MT301010CA.LanguageCommunication","PRPM_MT303010CA.LanguageCommunication","PRPM_MT306011CA.LanguageCommunication"})
public class LanguageOfCommunicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV languageCode = new CVImpl();
    private BL preferenceInd = new BLImpl();
    private CV modeCode = new CVImpl();
    private CV proficiencyLevelCode = new CVImpl();


    /**
     * <p>Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Required attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101001CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in.</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Required attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101001CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in.</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.LanguageCommunication.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Business Name: LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101001CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     */
    @Hl7XmlMapping({"preferenceInd"})
    public Boolean getPreferenceInd() {
        return this.preferenceInd.getValue();
    }

    /**
     * <p>Business Name: LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101002CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101001CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     */
    public void setPreferenceInd(Boolean preferenceInd) {
        this.preferenceInd.setValue(preferenceInd);
    }


    /**
     * <p>Business Name: LanguageOfCommunicationSkillsCode</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationSkillsCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.LanguageCommunication.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the healthcare provider's ability to 
     * communicate in the indicated language i.e. written, spoken, 
     * read</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationSkillsCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.LanguageCommunication.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the healthcare provider's ability to 
     * communicate in the indicated language i.e. written, spoken, 
     * read</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationSkillsCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.LanguageCommunication.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the healthcare provider's ability to 
     * communicate in the indicated language i.e. written, spoken, 
     * read</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public LanguageAbilityMode getModeCode() {
        return (LanguageAbilityMode) this.modeCode.getValue();
    }

    /**
     * <p>Business Name: LanguageOfCommunicationSkillsCode</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationSkillsCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.LanguageCommunication.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the healthcare provider's ability to 
     * communicate in the indicated language i.e. written, spoken, 
     * read</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationSkillsCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.LanguageCommunication.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the healthcare provider's ability to 
     * communicate in the indicated language i.e. written, spoken, 
     * read</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationSkillsCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.LanguageCommunication.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the healthcare provider's ability to 
     * communicate in the indicated language i.e. written, spoken, 
     * read</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     */
    public void setModeCode(LanguageAbilityMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Business Name: 
     * LanguageOfCommunicationProficiencyLevelCode</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationProficiencyLevelCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.LanguageCommunication.proficiencyLevelCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the proficiency level at which healthcare 
     * provider is able to communicate in the indicated language of 
     * communication</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationProficiencyLevelCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.LanguageCommunication.proficiencyLevelCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the proficiency level at which healthcare 
     * provider is able to communicate in the indicated language of 
     * communication</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationProficiencyLevelCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.LanguageCommunication.proficiencyLevelCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the proficiency level at which healthcare 
     * provider is able to communicate in the indicated language of 
     * communication</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     */
    @Hl7XmlMapping({"proficiencyLevelCode"})
    public LanguageAbilityProficiency getProficiencyLevelCode() {
        return (LanguageAbilityProficiency) this.proficiencyLevelCode.getValue();
    }

    /**
     * <p>Business Name: 
     * LanguageOfCommunicationProficiencyLevelCode</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationProficiencyLevelCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.LanguageCommunication.proficiencyLevelCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the proficiency level at which healthcare 
     * provider is able to communicate in the indicated language of 
     * communication</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationProficiencyLevelCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.LanguageCommunication.proficiencyLevelCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the proficiency level at which healthcare 
     * provider is able to communicate in the indicated language of 
     * communication</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationProficiencyLevelCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.LanguageCommunication.proficiencyLevelCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the proficiency level at which healthcare 
     * provider is able to communicate in the indicated language of 
     * communication</p>
     * 
     * <p>Required attribute provides additional information about 
     * the healthcare provider's communication skills in a given 
     * language</p>
     */
    public void setProficiencyLevelCode(LanguageAbilityProficiency proficiencyLevelCode) {
        this.proficiencyLevelCode.setValue(proficiencyLevelCode);
    }

}
