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