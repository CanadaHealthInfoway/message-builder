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
