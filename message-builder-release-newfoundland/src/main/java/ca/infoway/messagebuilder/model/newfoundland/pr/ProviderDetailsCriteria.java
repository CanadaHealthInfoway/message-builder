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

package ca.infoway.messagebuilder.model.newfoundland.pr;

import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.URL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.impl.URLImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.newfoundland.PersonQueryCriteria;

public class ProviderDetailsCriteria extends PersonQueryCriteria {

    private static final long serialVersionUID = -2719940067887114094L;

    private final BL includeHistory = new BLImpl(false);

    private final CD gender = new CDImpl();
    
    private final LIST<URL, TelecommunicationAddress> telephone = new LISTImpl<URL, TelecommunicationAddress>(URLImpl.class);

    private final TS birthDate = new TSImpl();

    @Hl7XmlMapping("dOB/value")
    public Date getBirthDate() {
        return this.birthDate.getValue();
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate.setValue(birthDate);
    }

    @Hl7XmlMapping("includeHistoryIndicator/value")
    public boolean isIncludeHistory() {
        return this.includeHistory.getValue();
    }

    public void setIncludeHistory(boolean includeHistory) {
        this.includeHistory.setValue(includeHistory);
    }

    @Override
    @Hl7XmlMapping("administrativeGender/value")
    public AdministrativeGender getGender() {
        return (AdministrativeGender) this.gender.getValue();
    }
    
    public void setGender(AdministrativeGender gender) {
        this.gender.setValue(gender);
    }

    @Override
    @Hl7XmlMapping("name/value")
    public PersonName getName() {
        return super.getName();
    }

    @Override
    @Hl7XmlMapping("telecom/value")
    public List<TelecommunicationAddress> getTelecoms() {
        return this.telephone.rawList();
    }
}
