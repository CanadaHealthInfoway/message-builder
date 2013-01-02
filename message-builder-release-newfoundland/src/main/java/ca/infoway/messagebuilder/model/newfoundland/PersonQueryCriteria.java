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
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;

public abstract class PersonQueryCriteria extends QueryCriteria implements Serializable {

    private static final long serialVersionUID = 1314143115772807147L;


    private final LIST<II, Identifier> identifiers = new LISTImpl<II, Identifier>(IIImpl.class);

    private final PN name = new PNImpl();

    public List<Identifier> getIdentifiers() {
        return this.identifiers.rawList();
    }

    public abstract Date getBirthDate();
    public abstract void setBirthDate(Date birthDate);

    public abstract AdministrativeGender getGender();    
    public abstract void setGender(AdministrativeGender gender);

    public void setName(PersonName name) {
        this.name.setValue(name);
    }

    public PersonName getName() {
        return this.name.getValue();
    }

    public abstract List<TelecommunicationAddress> getTelecoms();
}
