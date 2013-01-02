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

package ca.infoway.messagebuilder.model.newfoundland.cerx.medicalprofile;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CoverageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class CoverageBeanBuilder extends BaseBeanBuilder<CoverageBean> {
	
	public CoverageBeanBuilder() {
		super(new CoverageBean());
	}

	public CoverageBeanBuilder populate() {
		this.bean.setIdentifier(new Identifier("coverageRoot", "extension"));
		this.bean.setMoodCode(CodeResolverRegistry.lookup(x_ActMoodOrderEvent.class, "RQO", CodeSystem.VOCABULARY_ACT_MOOD.getRoot()));
		this.bean.setPayorIdentifier(new Identifier("payorIdentifierRoot", "extension"));
		this.bean.setPayorName("Payor name");
		
		return this;
	}

}
