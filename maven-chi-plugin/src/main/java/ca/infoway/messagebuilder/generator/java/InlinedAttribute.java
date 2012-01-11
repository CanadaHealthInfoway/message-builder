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

package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Documentation;

public class InlinedAttribute extends Attribute {

	private static final long serialVersionUID = -4309595874411105506L;
	
	private final BaseRelationship elidedRelationship;
	private final Attribute inlinedRelationship;

	protected InlinedAttribute(Attribute inlinedRelationship, BaseRelationship elidedRelationship) {
		this(inlinedRelationship, elidedRelationship, inlinedRelationship.isIndicator());
	}
	
	protected InlinedAttribute(Attribute inlinedRelationship, BaseRelationship elidedRelationship, boolean indicator) {
		super(inlinedRelationship.getRelationship(), inlinedRelationship.getDataType(), indicator);
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
	public Documentation getDocumentation() {
		if (this.inlinedRelationship.getDocumentation() != null) {
			return this.inlinedRelationship.getDocumentation();
		} else if (this.elidedRelationship.getDocumentation() != null) {
			return this.elidedRelationship.getDocumentation();
		} else {
			return null;
		}
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
	
	BaseRelationship getElidedRelationship() {
		return this.elidedRelationship;
	}

	Attribute getInlinedRelationship() {
		return this.inlinedRelationship;
	}
	
	@Override
	public Fingerprint getFingerprint() {
		return getElidedRelationship().getFingerprint().concat(getInlinedRelationship().getFingerprint());
	}
}
