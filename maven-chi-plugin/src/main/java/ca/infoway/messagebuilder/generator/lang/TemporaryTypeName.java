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

import static org.apache.commons.lang.StringUtils.EMPTY;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.TypeName;

public class TemporaryTypeName extends TypeName {

	private static final long serialVersionUID = 6941022774291107237L;
	private static int counter = 0;
	private static final int MAX_INT_LENGTH = 9; // 10, actually, but the leftmost digit only goes to 2

	/**
	 * This constructor for tests only. Please use the static creation method for normal use.
	 * 
	 * @param qualifier the temporary type name qualifier
	 * @param suffix the temporary type name suffix
	 */
	protected TemporaryTypeName(String qualifier, String suffix) {
		super(qualifier + "." + suffix);
	}
	
	private TemporaryTypeName(String fullName) {
		super(fullName);
	}
	
	public static TemporaryTypeName create(String qualifier) {
		String counterString = EMPTY + (++counter); 
		String suffix = StringUtils.leftPad(counterString, MAX_INT_LENGTH, '0');
		return new TemporaryTypeName(qualifier, suffix);
	}
	
	protected static TemporaryTypeName createNameAsIs(String fullName) {
		return new TemporaryTypeName(fullName);
	}
}
