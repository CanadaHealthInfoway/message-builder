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

import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class LanguageCommunicationBeanBuilder extends BaseBeanBuilder<LanguageCommunicationBean> {

	public LanguageCommunicationBeanBuilder() {
		super(new LanguageCommunicationBean());
	}

	public LanguageCommunicationBeanBuilder withLanguageCode(String codeValue) {
		this.bean.setLanguageCode(CodeResolverRegistry.lookup(HumanLanguage.class, codeValue, "2.16.840.1.113883.6.84"));
		return this;
	}

}
