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

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;

public class SupplementalInstructionBeanBuilder extends BaseBeanBuilder<SupplementalInstructionBean> {

	public SupplementalInstructionBeanBuilder() {
		super(new SupplementalInstructionBean());
	}

	public SupplementalInstructionBeanBuilder populate() {
		this.bean.setMoodCode(lookup(x_ActMoodDefEvnRqo.class, "EVN", CodeSystem.VOCABULARY_ACT_MOOD.getRoot()));
		this.bean.setText("supplemental instruction text");
		return this;
	}
	
}
