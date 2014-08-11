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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.tools;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.math.NumberUtils;

import ca.infoway.messagebuilder.xml.TypeName;

public class NameAssigner {

	private Set<String> names = new HashSet<String>();
	
	public void initialize(Collection<String> namesInUse) {
		names.addAll(namesInUse);
	}
	
	public String determineName(String partType) {
		TypeName typeName = new TypeName(partType);
		String name = WordUtils.uncapitalize(typeName.getUnqualifiedName());
		if (!this.names.contains(name)) {
			this.names.add(name);
			return name;
		} else {
			if (!endsWithNumber(name)) {
				name += "2";
			}
			for ( ; this.names.contains(name); name = incrementNumber(name)) {
				
			}
			this.names.add(name);
			return name; 
		}
	}

	private String incrementNumber(String unqualifiedName) {
		String number = getNumericSuffix(unqualifiedName);
		String rest = StringUtils.substringBeforeLast(unqualifiedName, number);
		String nextNumber =  "" + (NumberUtils.toInt(number, 0) + 1);
		if (number.length() > nextNumber.length()) {
			nextNumber = StringUtils.leftPad(nextNumber, number.length(), '0');
		}
		return rest + nextNumber;
	}

	private boolean endsWithNumber(String unqualifiedName) {
		String number = getNumericSuffix(unqualifiedName);
		return StringUtils.isNotBlank(number);
	}

	private String getNumericSuffix(String name) {
		StringBuilder builder = new StringBuilder();
		for (int i = name.length() -1; i >=0 ;  i--) {
			if ("01234567890".indexOf(name.charAt(i)) >= 0) {
				builder.insert(0, name.charAt(i));
			} else {
				break;
			}
		}
		
		return builder.toString();
	}
}
