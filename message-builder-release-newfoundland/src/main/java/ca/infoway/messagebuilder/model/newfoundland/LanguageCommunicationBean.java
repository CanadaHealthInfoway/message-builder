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

package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PRPA_MT101002CA.LanguageCommunication", "PRPA_MT101001CA.LanguageCommunication" })
public class LanguageCommunicationBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 2510745260687171285L;

    private final CD languageCode = new CDImpl();

    private final BL preferenceInd = new BLImpl(false);

    public LanguageCommunicationBean() {
    }

    public LanguageCommunicationBean(HumanLanguage languageCode, boolean preferenceInd) {
        setLanguageCode(languageCode);
        setPreferenceInd(preferenceInd);
    }

    @Hl7XmlMapping("languageCode")
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }

    @Hl7XmlMapping("preferenceInd")
    public boolean isPreferenceInd() {
        return this.preferenceInd.getValue();
    }

    public void setPreferenceInd(boolean preferenceInd) {
        this.preferenceInd.setValue(preferenceInd);
    }
}
