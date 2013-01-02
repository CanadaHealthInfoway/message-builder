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

import java.util.Date;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;

public interface IndeterminatePerson {
	
	public PersonName getName();
	public void setName(PersonName names);
	public List<PersonName> getNames();
	public List<TelecommunicationAddress> getTelecom();
	public AdministrativeGender getAdministrativeGenderCode();
	public void setAdministrativeGenderCode(AdministrativeGender administrativeGenderCode);
	public Date getBirthTime();
	public void setBirthTime(Date birthTime);
	public Date getDeceasedTime();
	public void setDeceasedTime(Date deceasedTime);
	public Boolean getDeceasedIndicator();
	public void setDeceasedIndicator(Boolean deceasedIndicator);
	public List<PostalAddress> getAddresses();
	public Set<OtherIdentifiersBean> getAsOtherIds();
	public List<PersonalRelationshipBean> getPersonalRelationships();
	public Set<LanguageCommunicationBean> getLanguageCommunications();
	public Set<Identifier> getIds();
	
}
