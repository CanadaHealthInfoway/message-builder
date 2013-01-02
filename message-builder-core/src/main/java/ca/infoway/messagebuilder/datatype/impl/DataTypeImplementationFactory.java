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

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.datatype.StandardDataType;

/**
 * <p>A factory for obtaining datatype implementation classes from a type name.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class DataTypeImplementationFactory {
	
	private static final Log LOG = LogFactory.getLog(DataTypeImplementationFactory.class);

	/**
	 * <p>Obtains the datatype implementation class for a type name.
	 * 
	 * @param typeName the type name
	 * @return the impl class corresponding to the type name
	 */
	@SuppressWarnings("unchecked")
	public static final Class<? extends ANYImpl<?>> getImplementation(String typeName) {
		Class<? extends ANYImpl<?>> implementation = null;
		
		StandardDataType dataType = StandardDataType.getByTypeName(typeName);
		if (dataType!=null) {
			try {
				implementation = (Class) Class.forName(MessageFormat.format("{0}.{1}Impl", ANYImpl.class.getPackage().getName(), dataType.getRootType()));
			} catch (ClassNotFoundException e) {
				LOG.error("Unable to find implementation for type: " + typeName, e);
			}
		}
		
		return implementation;
	}
}
