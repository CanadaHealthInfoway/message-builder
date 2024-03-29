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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2015-01-30 14:20:12 -0500 (Fri, 30 Jan 2015) $
 * Revision:      $LastChangedRevision: 9162 $
 */

package ca.infoway.messagebuilder.terminology.proxy;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.terminology.domainvalue.Active;
import ca.infoway.messagebuilder.terminology.domainvalue.Common;
import ca.infoway.messagebuilder.terminology.domainvalue.Displayable;
import ca.infoway.messagebuilder.terminology.domainvalue.Sortable;

/**
 * A CodeImpl that also contains a VocabularyDomain type. For example, the type might be
 * AdministrableDrugForm.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - Moved from terminology project - requires manual translation 
 */
public class TypedCode implements Code, Displayable, Sortable, Active, Common, Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Class<?> type;
	private final Collection<Class<?>> interfaceTypes;
	private final String code;
	private final String codeSystemOid;
	private final String codeSystemName;
	private final Integer ordinal;
	private final Map<String,String> displayTextMap;
	private final Boolean active;
	private final Boolean common;

	
	/**
	 * <p>Instantiates a new typed code.
	 */
	@SuppressWarnings("unchecked")
	public TypedCode() {
		this(null, Collections.EMPTY_SET, null, null, null, null, null, null, null);
	}

	TypedCode(Class<?> type, Collection<Class<?>> interfaceTypes, String code, String codeSystemOid, String codeSystemName, Map<String,String> displayTextMap, Integer sortValue, Boolean active, Boolean common) {
		this.type = type;
		this.interfaceTypes = interfaceTypes;
		this.code = code;
		this.codeSystemOid = codeSystemOid;
		this.codeSystemName = codeSystemName;
		this.displayTextMap = displayTextMap;
		this.ordinal = sortValue;
		this.active = active;
		this.common = common;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return code;
	}


	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return codeSystemOid;
	}


    /**
     * {@inheritDoc}
     */
    public String getCodeSystemName() {
    	return codeSystemName;
    }
    
	/**
	 * {@inheritDoc}
	 */
	public String getDisplayText(String language) {
		if (displayTextMap.containsKey(language)) {
			return (String) displayTextMap.get(language);
		} else {
			return getCodeValue();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return getCodeValue();
	}
	
	//CP: Should move these methods up to the CodeImpl class. 
	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object that) {
		if(!type.isInstance(that)) {
			return false;
		}
		
		EqualsBuilder equalsBuilder = new EqualsBuilder();
		equalsBuilder.append(this.getCodeValue(), ((Code)that).getCodeValue());
		equalsBuilder.append(this.getCodeSystem(), ((Code)that).getCodeSystem());
		
		return equalsBuilder.isEquals();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		return new HashCodeBuilder()
			.append(this.getCodeValue())
			.append(this.getCodeSystem())
			.append(this.type)
			.toHashCode(); 
	}

	/**
	 * Invoked during Deserialization. This needs to be (at least) package scope in order for it to
	 * be invoked when TypedCode is specified as the superclass inside a Cglib Enhanced Proxy.
	 * 
	 * @return A Code that implements the appropriate type.
	 * @see TypedCode
	 * @see TypedCodeFactory
	 */
	Object readResolve() {
		return new TypedCodeFactory().create(type, interfaceTypes, getCodeValue(), getCodeSystem(), getCodeSystemName(), displayTextMap, ordinal, active, common);
	}
	
	/**
	 * Invoked during Serialization. This needs to be (at least) package scope in order for it to be
	 * invoked when TypedCode is specified as the superclass inside a Cglib Enhanced Proxy.
	 * 
	 * @return A Code that implements the appropriate type.
	 * @see TypedCode
	 * @see TypedCodeFactory
	 */
	Object writeReplace() {
		return new TypedCode(type, interfaceTypes, getCodeValue(), getCodeSystem(), getCodeSystemName(), displayTextMap, ordinal, active, common);
	}

	/**
	 * {@inheritDoc}
	 */
	public Integer getSortValue() {
		return ordinal;
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean isActive() {
		return active.booleanValue();
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean isCommon() {
		return common.booleanValue();
	}
}
