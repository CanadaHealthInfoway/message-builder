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



/**
 * <p>LanguageCommunication</p>
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
 * <p>PRPA_MT101104CA.LanguageCommunication: 
 * LanguageCommunication</p>
 * 
 * <p>Information about what language(s) should be used to 
 * communicate with the focal person can be sent in the 
 * LanguageCommunication class.</p>
 * 
 * <p>Supports the business requirement to identify languages 
 * used by client for the purposes of communication</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101001CA.LanguageCommunication","PRPA_MT101002CA.LanguageCommunication","PRPA_MT101102CA.LanguageCommunication","PRPA_MT101104CA.LanguageCommunication"})
public class LanguageCommunicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV languageCode = new CVImpl();
    private BL preferenceInd = new BLImpl();


    /**
     * <p>LanguageOfCommunicationCode</p>
     * 
     * <p>Language of Communication Code</p>
     * 
     * <p>Language of Communication Code</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>Language of Communication Code</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in.</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>LanguageOfCommunicationCode</p>
     * 
     * <p>Language of Communication Code</p>
     * 
     * <p>Language of Communication Code</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>Language of Communication Code</p>
     * 
     * <p>A code indicating the language of communication</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in.</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Language of Communication Preference Indicator</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Language of Communication Preference Indicator</p>
     */
    @Hl7XmlMapping({"preferenceInd"})
    public Boolean getPreferenceInd() {
        return this.preferenceInd.getValue();
    }

    /**
     * <p>LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Language of Communication Preference Indicator</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     * 
     * <p>Language of Communication Preference Indicator</p>
     */
    public void setPreferenceInd(Boolean preferenceInd) {
        this.preferenceInd.setValue(preferenceInd);
    }

}
