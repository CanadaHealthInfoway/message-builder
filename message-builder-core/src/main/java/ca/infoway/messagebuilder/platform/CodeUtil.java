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

package ca.infoway.messagebuilder.platform;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

/**
 * 
 * @sharpen.ignore
 *
 */
public class CodeUtil {

	private static TrivialCodeResolver trivialCodeResolver = new TrivialCodeResolver();
	private static Class<Code> codeInterface = Code.class;
	
	public static Code convertToCode(String codeAsString, String codeSystem) {
		Code result = null; 
		if (StringUtils.isNotBlank(codeAsString)) {
			result = trivialCodeResolver.lookup(codeInterface, codeAsString, codeSystem);
		}
		return result;
	}

}
