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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SXCM_R2;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;

/**
 * @sharpen.ignore platform Utility class for handling generics related code that requires reflection .NET due to generics at runtime
 */
public class GenericClassUtil {
	
	private GenericClassUtil() {};
	
	public static boolean isInstanceOfANY(Object value) {
		return value instanceof ANY<?>;
	}
	
	public static Object getValueFromANY(Object anyObject) {
		if (!isInstanceOfANY(anyObject)) {
			throw new IllegalArgumentException("Object is not an instance of ANY " + anyObject);
		}
		return ((ANY<?>) anyObject).getValue();
	}

	
	@SuppressWarnings("unchecked")
	public static Collection<BareANY> convertToBareANYCollection(BareANY hl7Value) {
		Object bareValue = (hl7Value == null ? null : hl7Value.getBareValue());
		if (bareValue instanceof Collection<?>) {
			return (Collection<BareANY>) bareValue;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Interval<Date> castBareValueAsIntervalDate(Object bareValue) {
		return bareValue instanceof Interval ? (Interval<Date>) bareValue : null;
	}
	
	public static CollectionHelper createSXCMR2List() {
		return new LISTImpl<SXCM_R2<MbDate>, MbDate>(ANYImpl.class);
	}

	public static BareANY adaptValue(BareANY bareANY) {
		return bareANY; //No-op in Java due to type erasure
	}

	public static Object instantiate(Class<?> partClass, Map<String, Class<?>> map) 
			throws InstantiationException, IllegalAccessException {
		return partClass.newInstance();
	}

	public static Class<?> getCollectionContentsType(BeanProperty property) {
		Type[] actualTypeArguments = ((java.lang.reflect.ParameterizedType) (property.getDescriptor().getReadMethod().getGenericReturnType())).getActualTypeArguments();
		// TM - changes below were *not* reflected in MB .NET (didn't seem to directly apply)
		if (actualTypeArguments != null && actualTypeArguments.length > 0) {
			if (actualTypeArguments[0] instanceof Class<?>) {
				return (Class<?>) actualTypeArguments[0];
			} else if (actualTypeArguments[0] instanceof ParameterizedType) {
				return (Class<?>) ((ParameterizedType) actualTypeArguments[0]).getRawType();
			}
		}
		return null;
	}

}
