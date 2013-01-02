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

package ca.infoway.messagebuilder.terminology.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * <p>The Class TypedCodeMethodInterceptor.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class TypedCodeMethodInterceptor implements MethodInterceptor {

	private final TypedCode typedCode;

	/**
	 * <p>Instantiates a new typed code method interceptor.
	 *
	 * @param typedCode the typed code
	 */
	public TypedCodeMethodInterceptor(TypedCode typedCode) {
		this.typedCode = typedCode;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		try {
			return method.invoke(typedCode, args);
		} catch (Exception e) {
			// unwrap InvocationtargetException to accurately emulate behaviour of proxied class
			throw ExceptionUtils.getRootCause(e);
		}
	}

}
