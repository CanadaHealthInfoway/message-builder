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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * 
 * A code resolver to look up codes for code types registered against enums.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - terminology - translated manually
 */
class EnumPatternCodeResolver extends CodeResolverImpl {

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<? extends T> type, String code) {
        if (code == null) {
            return null;
        } else if (!type.isInterface()) {
            return (T) lookupClass(type, code);
        } else {
            return null;
        }
    }

	/**
     * {@inheritDoc}
     * 
     * enum pattern code resolver doesn't understand code system
     */
    public <T extends Code> T lookup(Class<? extends T> type, String code, String codeSystemOid) {
		return lookup(type, code);
	}
    
    
    /**
     * <p>Lookup.
     *
     * enum pattern code resolver doesn't understand null flavor
     *
     * @param <T> the generic type
     * @param type the type
     * @param nullFlavor the null flavor
     * @return the t
     */
    public <T extends Code> T lookup(Class<T> type, NullFlavor nullFlavor) {
        return null;
    }
    
    @SuppressWarnings("unchecked")
    private static <T extends Code> T lookupClass(Class<T> type, String code) {
        Field[] fields = type.getFields();
        T result = null;
        for (int i = 0, length = fields == null ? 0 : fields.length; i < length; i++) {
            if (isPseudoEnumConstant(type, fields[i])) {
                Code object = getValue(fields[i]);
                if (object.getCodeValue().equals(code)) {
                    result = (T) object;
                    break;
                }
            }
        }
        return result;
    }

    private static Code getValue(Field field) {
        try {
            return (Code) field.get(null);
        } catch (IllegalArgumentException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    private static boolean isPseudoEnumConstant(Class<? extends Code> type, Field field) {
        if (!Modifier.isPublic(field.getModifiers())) {
            return false;
        } else if (!Modifier.isStatic(field.getModifiers())) {
            return false;
        } else if (!type.isAssignableFrom(field.getType())) {
            return false;
        } else {
            return true;
        }
    }
}
