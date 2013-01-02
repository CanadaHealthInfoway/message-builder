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

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;

public class NoteBeanBuilder extends BaseBeanBuilder<NoteBean> {

	public NoteBeanBuilder() {
		super(new NoteBean());
	}

	public NoteBeanBuilder populate() {
		bean.setAuthor(new AuthorBeanBuilder().populate().create());
		bean.setText("note text");
		bean.setTime(new Date(0));
		bean.setAnnotationCode(lookup(ActPatientAnnotationCode.class, "MED", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		bean.setLanguageCode(lookup(HumanLanguage.class, "en", CodeSystem.VOCABULARY_HUMAN_LANGUAGE.getRoot()));
		bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		bean.setRecordIdentifier(new Identifier("1.2.3.2.1", "1122112"));
		bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		bean.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		return this;
	}
	
}
