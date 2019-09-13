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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

public class MergedDocumentation extends Documentation {

	private List<Annotation> annotations = new ArrayList<Annotation>();
	private String businessName = null;
	
	public MergedDocumentation(Collection<BaseRelationship> mergedRelationships) {
		Set<String> businessNames = new HashSet<String>();
		for (BaseRelationship baseRelationship : mergedRelationships) {
			Documentation documentation = baseRelationship.getDocumentation();
			Relationship rel = baseRelationship.getRelationship();
			
			String businessName = "(no business name specified)";
			if (documentation != null && documentation.getBusinessName() != null) {
				businessName = BusinessNameUtil.cleanUpBusinessName(documentation.getBusinessName());
				businessNames.add(businessName);
			}
			this.annotations.add(new Annotation("Un-merged Business Name: " + businessName));
			this.annotations.add(new Annotation("Relationship: " + rel.getParentType() + "." + rel.getName()));
			this.annotations.add(new Annotation("Conformance/Cardinality: " + rel.getConformance() + " (" + rel.getCardinality() + ")"));
			
			if (documentation != null && !documentation.getAnnotations().isEmpty()) {
				this.annotations.addAll(documentation.getAnnotations());
			}
		}

		// only set an "official" business names if the business names are identical (skipping those w/o business names)
		if (businessNames.size() == 1) {
			this.businessName = businessNames.iterator().next();
		}
	}

	public MergedDocumentation(List<Type> types) {
		// allow doc duplication for types since we have the exact type name to match up with each set of documentation
		Set<String> businessNames = new HashSet<String>();
		for (Type type : types) {
			Documentation documentation = type.getTypeDocumentation().getOriginalDocumentation();
			if (documentation != null && 
					(StringUtils.isNotBlank(documentation.getBusinessName()) || !documentation.getAnnotations().isEmpty())) {
				String businessName = StringUtils.defaultIfEmpty(documentation.getBusinessName(), "(no business name)");
				this.annotations.add(new Annotation(type.getTypeName().getName() + ": " + businessName));
				if (!documentation.getAnnotations().isEmpty()) {
					this.annotations.addAll(documentation.getAnnotations());
				}
			}
			if (documentation != null && documentation.getBusinessName() != null) {
				businessNames.add(BusinessNameUtil.cleanUpBusinessName(documentation.getBusinessName()));
			}
		}

		// only use business names if the business names are identical (skipping those w/o business names)
		if (businessNames.size() == 1) {
			this.businessName = businessNames.iterator().next();
		}
	}

	@Override
	public List<Annotation> getAnnotations() {
		return this.annotations;
	}
	
	@Override
	public String getBusinessName() {
		return this.businessName;
	}
	
	@Override
	public String getTitle() {
		throw new UnsupportedOperationException("title not currently used by generator");
	}
	
}
