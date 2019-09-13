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

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.TypeName;

public class MergedAssociation extends Association {

	private static final long serialVersionUID = 3765276875077194477L;
	
	private final Type type;
	private final TypeName typeName;
	private final Association association;
	
	protected MergedAssociation(Association association, Type type) {
		super(association.getRelationship(), type, Collections.<Choice>emptyList());
		this.association = association;
		this.type = type;
		this.typeName = this.type.getTypeName();
	}

	@Override
	public String getName() {
		return this.association.getName();
	}

	@Override
	XmlMappingHelper getXmlMappingHelper() {
		return this.association.getXmlMappingHelper();
	}

	@Override
	public Cardinality getCardinality() {
		return this.association.getCardinality();
	}
	
	@Override
	public Type getAssociationType() {
		return this.type;
	}

	@Override
	public List<Choice> getAllChoiceTypes() {
		return this.association.getAllChoiceTypes();
	}
	
	@Override
	public TemplateVariable getTemplateVariable() {
		return this.association.getTemplateVariable(); 
	}
	
	@Override
	public String getType() {
		return this.typeName.toString();
	}

	public Association getOriginalAssociation() {
		return this.association;
	}
	
	@Override
	public Fingerprint getFingerprint(TypeName containingType) {
		return this.association.getFingerprint(containingType);
	}
}
