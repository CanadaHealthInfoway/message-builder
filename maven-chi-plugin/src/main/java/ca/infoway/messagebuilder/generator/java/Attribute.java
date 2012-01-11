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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Relationship;

public class Attribute extends BaseRelationship {

	private static final long serialVersionUID = -6995768063449967900L;
	
	private final DataType dataType;
	private final boolean indicator;

	public Attribute(Relationship relationship, DataType dataType) {
		this(relationship, dataType, false);
	}
	
	public Attribute(Relationship relationship, DataType dataType, boolean indicator) {
		super(relationship, 
				dataType == null ? null : dataType.getHl7ClassName(), 
				dataType == null ? null : dataType.getTypeName());
		this.dataType = dataType;
		this.indicator = indicator;
	}
	
	@Override
	public RelationshipType getRelationshipType() {
		return RelationshipType.ATTRIBUTE;
	}
	
    /**
     * <p>We say that an attribute is a collection type if the underlying data type
     * is a collection.  For example, if the attribute is defined as <code>LIST&lt;II&gt;</code>, 
     * then the attribute is a collection type.  
     * 
     * <p>The idea of a collection type is separate from (but often related to) the idea
     * of multiple cardinality.
     * 
     * @return
     */
    public boolean isCollection() {
        return getDataType().isTypeCollection();
    }
	
	@Override
	public Set<Object> getImportTypes(boolean parentTypeIsMerged, boolean parentTypeIsAbstract) {
		Set<Object> result = super.getImportTypes(parentTypeIsMerged, parentTypeIsAbstract);
		if (getDataType().isTypeCollection()) {
			result.add(getDataType().getTypeName());
			if (getDataType().getParameters()!=null && getDataType().getParameters().length > 0) {
				DataType parameter = getDataType().getParameters()[0];
				if (parameter.isCodedType()) {
					result.add(Code.class.getName());
				}
			}
		}
		if (getDataType() != null) {
			result.addAll(getDataType().getImportTypes());
		}
		
		if (!getDataType().isWrappedTypeListOrSet() && isCardinalityMultiple()) {
			result.add(RawListWrapper.class.getName());
		}
		
		if (isCardinalityMultiple() && !getDataType().isWrappedTypeSet()) {
			result.add(List.class.getName());
			if (!parentTypeIsAbstract && !getDataType().isWrappedTypeListOrSet()) {
				result.add(ArrayList.class.getName());
			}
		}
		return result;
	}

	public DataType getDataType() {
		return this.dataType;
	}
	
	@Override
	public boolean isWriteable() {
		return super.isWriteable() && !isCollection();
	}
	
	@Override
	public String getTypeParameters() {
		// TODO: BCH: I don't think this should be called, here.
		return getDataType().getTypeParameters(ProgrammingLanguage.JAVA);
	}
	
	public PropertyGenerator getPropertyGenerator(ProgrammingLanguage language, ClassNameManager representation, BaseRelationshipNameResolver nameResolver) {
		return PropertyGeneratorBuilders.newAttributeBuilder(language, this).build(representation, nameResolver);
	}

	/**
	 * If this is an attribute that has replaced an indicator bean, this will return true.
	 * 
	 * @return whether this attribute represents an indicator bean
	 */
	public boolean isIndicator() {
		return this.indicator;
	}

	@Override
	public Fingerprint getFingerprint() {
		return new Fingerprint(RelationshipType.ATTRIBUTE, this.relationship.getName());
	}
	
}
