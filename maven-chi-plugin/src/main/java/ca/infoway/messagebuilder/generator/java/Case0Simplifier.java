/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.LogUI;

public class Case0Simplifier extends InlineableSimplifier {

	public Case0Simplifier(LogUI log, SimplifiableDefinitions definitions) {
		super(log, definitions);
	}

	@Override
	protected boolean isInlineable(SimplifiablePackage simplifiablePackage,	SimplifiableType inlineableType) {
		boolean result = true;
		
		if (inlineableType.isRootType()) {
			result = false;
		} else if (!getNonFixedRelationships(inlineableType).isEmpty()) {
			result = false;
		} else if (inlineableType.isAbstract()) {
			result = false;
		} else if (!inlineableType.getInterfaceTypes().isEmpty()) {
			result = false;
		}

		return result;
	}

	@Override
	protected void inline(SimplifiableType type) {
		super.inline(type);
		type.setIndicator(true);
	}	
	
}
