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

package ca.infoway.messagebuilder.model.newfoundland;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.util.GregorianCalendar;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.newfoundland.IndeterminatePersonBean;
import ca.infoway.messagebuilder.model.newfoundland.LanguageCommunicationBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class IndeterminatePersonBeanBuilder extends BaseBeanBuilder<IndeterminatePersonBean>{
	
	public IndeterminatePersonBeanBuilder() {
		super(new IndeterminatePersonBean());
	}
	
	public IndeterminatePersonBeanBuilder populateMabelHauptman() {
		bean.setAdministrativeGenderCode(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		bean.setBirthTime(new GregorianCalendar(1972, 2, 21).getTime());
		PersonName name = PersonName.createFirstNameLastName("Mabel", "Hauptman");
		bean.setName(name);
		LanguageCommunicationBean language = new LanguageCommunicationBean();
		language.setLanguageCode(CodeResolverRegistry.lookup(HumanLanguage.class, "en", CodeSystem.VOCABULARY_HUMAN_LANGUAGE.getRoot()));
		language.setPreferenceInd(true);
		bean.getLanguageCommunications().add(language);
		return this;
	}
	
	public IndeterminatePersonBeanBuilder populate() {
		bean.getNames().add(PersonName.createFirstNameLastName("Hannah", "Lambert"));
		bean.getNames().add(PersonName.createFirstNameLastName("Alan", "Wall"));
		
		TelecommunicationAddress telecom1 = new TelecommunicationAddress(
				CodeResolverRegistry.lookup(URLScheme.class, "http"), "123.456.789.10");
		TelecommunicationAddress telecom2 = new TelecommunicationAddress(
				CodeResolverRegistry.lookup(URLScheme.class, "https"), "123.456.789.11");
		bean.getTelecom().add(telecom1);		
		bean.getTelecom().add(telecom2);		
		
		bean.setAdministrativeGenderCode(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		bean.setBirthTime(new GregorianCalendar(1972, 2, 21).getTime());
		bean.setDeceasedIndicator(true);
		bean.setDeceasedTime(DateUtil.getDate(2002, 02, 10));
		bean.setMultipleBirthIndicator(true);
		bean.setMultipleBirthOrderNumber(2);
		
		PostalAddress address1 = new PostalAddress();
		address1.addUse(PostalAddressUse.HOME);
		address1.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_NAME, "Bloor"));
		PostalAddress address2 = new PostalAddress();
		address2.addUse(PostalAddressUse.HOME);
		address2.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_NAME, "Yonge"));
		bean.getAddresses().add(address1);
		bean.getAddresses().add(address2);

		bean.getAsOtherIds().add(new OtherIdBeanBuilder().populate().create());
		bean.getAsOtherIds().add(new OtherIdBeanBuilder().populate().create());
		
		bean.getPersonalRelationships().add(new PersonalRelationshipBeanBuilder().populate().create());
		bean.getPersonalRelationships().add(new PersonalRelationshipBeanBuilder().populate().create());
		
		bean.getLanguageCommunications().add(new LanguageCommunicationBean(lookup(HumanLanguage.class, "en", CodeSystem.VOCABULARY_HUMAN_LANGUAGE.getRoot()), true));
		bean.getLanguageCommunications().add(new LanguageCommunicationBean(lookup(HumanLanguage.class, "de", CodeSystem.VOCABULARY_HUMAN_LANGUAGE.getRoot()), false));

		bean.getIds().add(new Identifier("5.4.3.2.1", "54321"));
		bean.getIds().add(new Identifier("5.4.3.1.1", "54311"));
		
		return this;
	}

}
