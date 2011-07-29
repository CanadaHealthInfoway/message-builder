/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.merged;

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

    private static final long serialVersionUID = 20110729L;
    private CV languageOfCommunicationCode = new CVImpl();
    private BL languageOfCommunicationPreferenceIndicator = new BLImpl();


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

}
