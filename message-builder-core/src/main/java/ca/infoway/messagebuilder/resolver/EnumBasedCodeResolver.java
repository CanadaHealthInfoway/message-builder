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

package ca.infoway.messagebuilder.resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Class EnumBasedCodeResolver.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - terminology - translated manually
 */
public class EnumBasedCodeResolver extends CodeResolverImpl {

	private final Class<?> e;

	/**
	 * <p>Instantiates a new enum based code resolver.
	 *
	 * @param e the e
	 */
	public EnumBasedCodeResolver(Class<?> e) {
		this.e = e;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T extends Code> Collection<T> lookup(Class<T> type) {
		return new ArrayList(Arrays.asList(EnumPattern.getEnumConstants(this.e)));
	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<T> interfaceType, String code) {
		return lookup(interfaceType, code, null, false);
	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<T> interfaceType, String code, boolean ignoreCase) {
		return lookup(interfaceType, code, null, ignoreCase);
	}

	/**
	 * <p>Lookup.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @param code the code
	 * @param codeSystemOid the code system oid
	 * @param nullFlavor the null flavor
	 * @return the t
	 */
	public <T extends Code> T lookup(Class<T> interfaceType, String code, String codeSystemOid) {
		return lookup(interfaceType, code, codeSystemOid, false);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Code> T lookup(Class<T> type, String code, String codeSystemOid, boolean ignoreCase) {
		return (T) findMatchingOption(code, codeSystemOid, ignoreCase);
	}

	private Object findMatchingOption(String code, String codeSystem, boolean ignoreCase) {
	    Object[] values = EnumPattern.getEnumConstants(this.e);
	    Object result = null;
	    for (int i = 0, length = values == null ? 0 : values.length; 
	    		isCodeType() && result == null && i < length; i++) {
	    	if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(codeSystem)) {
	    		result = match((Code) values[i], code, codeSystem, ignoreCase);
	    	} else if (StringUtils.isNotBlank(code)) {
	    		result = match((Code) values[i], code, ignoreCase);
	    	}
	    }		
		return result;
	}

	private boolean isCodeType() {
		return Code.class.isAssignableFrom(this.e);
	}

	private Object match(Code code, String codeValue, boolean ignoreCase) {
		boolean match = (ignoreCase ? StringUtils.equalsIgnoreCase(code.getCodeValue(), codeValue) : StringUtils.equals(code.getCodeValue(), codeValue));
		return match ? code : null;
	}

	private Object match(Code code, String codeValue, String codeSystem, boolean ignoreCase) {
		boolean matchCode = (ignoreCase ? StringUtils.equalsIgnoreCase(code.getCodeValue(), codeValue) : StringUtils.equals(code.getCodeValue(), codeValue));
		boolean matchCodeSystem = StringUtils.equals(code.getCodeSystem(), codeSystem); // ignoreCase not checked here
		return matchCode && matchCodeSystem ? code : null;
	}

}
