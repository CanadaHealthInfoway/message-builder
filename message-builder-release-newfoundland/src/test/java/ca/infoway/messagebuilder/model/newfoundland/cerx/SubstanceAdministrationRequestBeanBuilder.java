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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SubstanceAdministrationRequestBean;

public class SubstanceAdministrationRequestBeanBuilder extends BaseBeanBuilder<SubstanceAdministrationRequestBean> {

	public SubstanceAdministrationRequestBeanBuilder() {
		super(new SubstanceAdministrationRequestBean());
	}

	public SubstanceAdministrationRequestBeanBuilder populate() {
		this.bean.getId().add(new Identifier("prescriptionIdRoot", "1"));
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		return this;
	}

}
