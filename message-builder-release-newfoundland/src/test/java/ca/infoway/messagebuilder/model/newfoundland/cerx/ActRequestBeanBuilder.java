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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;

public class ActRequestBeanBuilder extends BaseBeanBuilder<ActRequestBean> {

	public ActRequestBeanBuilder() {
		super(new ActRequestBean());
	}
	
	public ActRequestBeanBuilder populate() {
		this.bean.getIds().add(new Identifier("1.2.3.2.1", "12321"));
		this.bean.getIds().add(new Identifier("5.4.3.2", "9876"));
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		return this;
	}

	public ActRequestBeanBuilder withIdentifier(Identifier identifier) {
		this.bean.setId(identifier);
		return this;
	}
}
