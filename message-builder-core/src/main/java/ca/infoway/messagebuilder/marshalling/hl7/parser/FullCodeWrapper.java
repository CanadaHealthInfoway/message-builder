package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * @sharpen.ignore
 */
public class FullCodeWrapper {
	
	public static class FullCodeHandler implements InvocationHandler {

		private final Code code;
		private final NullFlavor nullFlavor;
		private final String codeSystem;

		public FullCodeHandler(String codeSystem,	NullFlavor nullFlavor) {
			this.code = null;
			this.codeSystem = codeSystem;
			this.nullFlavor = nullFlavor;
		}

		public FullCodeHandler(Code code, String codeSystem) {
			this.code = code;
			this.codeSystem = codeSystem;
			this.nullFlavor = null;
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if ("getCodeValue".equals(method.getName())) {
				return this.code == null ? null : method.invoke(this.code, args);
			} else if ("getCodeSystem".equals(method.getName())) {
				return this.codeSystem;
	        } else if ("hasNullFlavor".equals(method.getName())) {
	        	return this.nullFlavor != null;
	        } else if ("getNullFlavor".equals(method.getName())) {
	        	return this.nullFlavor;
			} else if ("equals".equals(method.getName())) {
				return false;
			} else if ("hashCode".equals(method.getName())) {
				return HashCodeBuilder.reflectionHashCode(this);
			} else if ("toString".equals(method.getName())) {
				return ToStringBuilder.reflectionToString(this);
			} else {
				return null;
			}
		}
	}
	
	public static <T extends Code> T wrap(Class<T> type, Code code, String codeSystem) {
		return type.cast(Proxy.newProxyInstance(type.getClassLoader(), 
				new Class[] { type },
				new FullCodeHandler(code, codeSystem)));
	}
}
