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

package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.SXPR;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.ParentheticSetExpr;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * <p>Parenthetic Set Expression (SXPR) specializes SXCM. Backed by the java datatype ParentheticSetExpr.
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-SXPR
 * 
 * <p>Definition: A set-component that is itself made up of set-components that are
 * evaluated as one value.
 * 
 * <p>There must be at least 2 component elements.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying java datatype
 * @sharpen.ignore - datatype - translated manually 
 */
public class SXPRImpl<T> extends ANYImpl<ParentheticSetExpr<T>> implements SXPR<T> {

	/**
	 * <p>Constructs an empty SXPR. 
	 */
	@SuppressWarnings("unchecked")
	public SXPRImpl() {
		this((ParentheticSetExpr) null);
	}

	/**
	 * <p>Constructs an SXPR with the given initial value.
	 * 
	 * @param defaultValue the initial value
	 */
	public SXPRImpl(ParentheticSetExpr<T> defaultValue) {
		super(ParentheticSetExpr.class, defaultValue, null, StandardDataType.SXPR);
	}

	/**
	 * <p>Constructs an SXPR with the supplied null flavor.  
	 * 
	 * @param nullFlavor a null flavor
	 */
	public SXPRImpl(NullFlavor nullFlavor) {
		super(ParentheticSetExpr.class, null, nullFlavor, StandardDataType.SXPR);
	}

}

