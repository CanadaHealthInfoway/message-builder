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

package ca.infoway.messagebuilder.junit;

import org.jmock.Mockery;
import org.jmock.lib.AssertionErrorTranslator;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * @sharpen.ignore
 * @author administrator
 *
 */
public class JMockMockeryRule extends Mockery implements MethodRule {
	
	public JMockMockeryRule() {
		setExpectationErrorTranslator(AssertionErrorTranslator.INSTANCE);
	}

	public Statement apply(final Statement base, final FrameworkMethod method, Object target) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					base.evaluate();
				} catch (Throwable e) {
					reThrowIfMatchExceptionExpectedByTest(method, e);
				}
				assertIsSatisfied();
			}
		};
	}

	private void reThrowIfMatchExceptionExpectedByTest(final FrameworkMethod method, Throwable e) throws Throwable {
		if (!isExceptionExpectedByTest(e, method)) {
			throw e;
		}
	}
	
	private boolean isExceptionExpectedByTest(Throwable exp, FrameworkMethod method) {
		Test test = method.getAnnotation(Test.class);
		return test.expected().equals(exp.getClass());
	}

}