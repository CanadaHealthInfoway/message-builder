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

import ca.infoway.messagebuilder.datatype.ANY;

/**
 * <p>A factory to create a datatype object given a type name. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class DataTypeFactory {

	/**
	 * <p>Creates a datatype object given a type name. 
	 * 
	 * @param typeName the type
	 * @return the created datatype
	 */
	@SuppressWarnings("rawtypes")
	public static final ANY createDataType(String typeName, boolean isCdaR2) {
		Class<? extends ANYImpl<?>> implementation = DataTypeImplementationFactory.getImplementation(typeName,isCdaR2);
		try {
			if (implementation!=null) {
				return implementation.newInstance();
			} else {
				throw new RuntimeException("Unable to create data type: " + typeName);
			}
		} catch (InstantiationException e) {
			throw new RuntimeException("Unable to create data type: " + typeName, e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Unable to create data type: " + typeName, e);
		}
	}

}
