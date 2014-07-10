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

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.TypeName;


public class InlinedAssociation extends Association {

	private final Association inlinedRelationship;
	private final BaseRelationship elidedRelationship;

	public InlinedAssociation(Association inlinedRelationship, BaseRelationship elidedRelationship) {
		super(inlinedRelationship.getRelationship(), inlinedRelationship.getAssociationType(), Collections.<Choice>emptyList());
		this.inlinedRelationship = inlinedRelationship;
		this.elidedRelationship = elidedRelationship;
	}

	@Override
	public String getName() {
		return this.elidedRelationship.getName() + WordUtils.capitalize(this.inlinedRelationship.getName());
	}
	
	
	@Override
	XmlMappingHelper getXmlMappingHelper() {
		return this.elidedRelationship.getXmlMappingHelper().concat(inlinedRelationship.getXmlMappingHelper());
	}
	
	@Override
	public Cardinality getCardinality() {
		Cardinality cardinality = super.getCardinality();
		if (new Cardinality(1,1).equals(cardinality)) {
			return this.elidedRelationship.getCardinality();
		} else {
			return cardinality;
		}
	}
	
	@Override
	public TemplateVariable getTemplateVariable() {
		return this.inlinedRelationship.getTemplateVariable();
	}
	
	@Override
	public String getType() {
		return this.inlinedRelationship.getType();
	}

	Association getInlinedRelationship() {
		return this.inlinedRelationship;
	}

	BaseRelationship getElidedRelationship() {
		return this.elidedRelationship;
	}

	@Override
	public Type getAssociationType() {
		return this.inlinedRelationship.getAssociationType();
	}
	
	@Override
	public List<Choice> getAllChoiceTypes() {
		return this.inlinedRelationship.getAllChoiceTypes();
	}
	
	@Override
	public Fingerprint getFingerprint(TypeName containingType) {
		return getElidedRelationship().getFingerprint(containingType).concat(getInlinedRelationship().getFingerprint(containingType));
	}
}
