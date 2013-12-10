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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: LanguageCommunication</p>
 * 
 * <p>PRPA_MT101102CA.LanguageCommunication: Language 
 * Communication</p>
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
@Hl7PartTypeMapping({"PRPA_MT101102CA.LanguageCommunication","PRPA_MT101104CA.LanguageCommunication"})
public class LanguageCommunicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20131210L;
    private List<BL> preferenceInd = new ArrayList<BL>();
    private CV languageCode = new CVImpl();


    /**
     * <p>Business Name: LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * LanguageOfCommunicationPreferenceIndicator</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101102CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0)</p>
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
     * PRPA_MT101104CA.LanguageCommunication.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0)</p>
     * 
     * <p>Indicates the preferred language for all 
     * communications.</p>
     * 
     * <p>Required attribute that supports the business requirement 
     * to indicate the preferred language for all 
     * communications.</p>
     */
    @Hl7XmlMapping({"preferenceInd"})
    public List<Boolean> getPreferenceInd() {
        return new RawListWrapper<BL, Boolean>(preferenceInd, BLImpl.class);
    }


    /**
     * <p>Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Un-merged Business Name: LanguageOfCommunicationCode</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.LanguageCommunication.languageCode</p>
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
     * PRPA_MT101104CA.LanguageCommunication.languageCode</p>
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

}
