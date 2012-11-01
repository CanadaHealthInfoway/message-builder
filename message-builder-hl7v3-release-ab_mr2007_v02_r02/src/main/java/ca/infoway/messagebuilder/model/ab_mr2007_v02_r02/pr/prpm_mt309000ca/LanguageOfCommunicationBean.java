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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pr.prpm_mt309000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.LanguageAbilityMode;
import ca.infoway.messagebuilder.domainvalue.LanguageAbilityProficiency;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Language of Communication</p>
 * 
 * <p><p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * languages used by client for the purposes of 
 * communication</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT309000CA.LanguageCommunication"})
public class LanguageOfCommunicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20120122L;
    private CE languageCode = new CEImpl();
    private CV modeCode = new CVImpl();
    private CV proficiencyLevelCode = new CVImpl();
    private BL preferenceInd = new BLImpl();


    /**
     * <p>Language of Communication Code</p>
     * 
     * <p><p>A code indicating the language of communication</p></p>
     * 
     * <p><p>Mandatory attribute conveying the expected language 
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