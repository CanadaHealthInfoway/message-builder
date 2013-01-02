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

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.MapOfMaps;

/**
 * <p>The Class TrivialCodeResolver. Used to resolve a code that does not have any other resolver registered for its type.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - terminology - translated manually
 */
public class TrivialCodeResolver extends CodeResolverImpl {

    static class Handler implements InvocationHandler, Serializable {
        
    	private static final long serialVersionUID = -8622581065197800993L;
        
		private final String code;
        private final String codeSystem;
		private final NullFlavor nullFlavor;

        public Handler(String code, String codeSystem) {
            this.code = code;
			this.codeSystem = codeSystem;
            this.nullFlavor = null;
        }

        public Handler(NullFlavor nullFlavor) {
			this.nullFlavor = nullFlavor;
			this.code = null;
			this.codeSystem = null;
		}

		public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
            if ("getCodeValue".equals(method.getName())) {
                return this.code;
            } else if ("getCodeSystem".equals(method.getName())){
            	return this.codeSystem;
            } else if ("hashCode".equals(method.getName())) {
            	return new HashCodeBuilder().append(this.code)
	            	.append(this.codeSystem)
	            	.append(this.nullFlavor).toHashCode();
            } else if ("equals".equals(method.getName()) && arg2.length == 1) {
            	return isEqualTo(arg2[0]);
            } else if ("toString".equals(method.getName())) {
                return this.code;
            } else if ("isAccepted".equals(method.getName())) {
            	return new Boolean("AA".equals(code));
            } else {
                return null;
            }
        }

		private boolean isEqualTo(Object object) {
			if (object == null) {
				return false;
			} else if (!(object instanceof Code)) {
				return false;
			} else {
				Code that = (Code) object;
				EqualsBuilder builder = new EqualsBuilder();
				builder.append(this.code, that.getCodeValue());
				builder.append(this.codeSystem, that.getCodeSystem());
				builder.append(this.nullFlavor, null);
				return builder.isEquals();
			}
		}
	}
    
    private final MapOfMaps<Class<?>, String, Code> map = new MapOfMaps<Class<?>, String, Code>();
    
	private final Set<Class<? extends Code>> emptyDomains = new HashSet<Class<? extends Code>>();

    /**
     * {@inheritDoc}
     */
    @Override
	@SuppressWarnings("unchecked")
    public <T extends Code> T lookup(Class<? extends T> interfaceType, String code, String codeSystemOid) {
        if (code == null || this.emptyDomains.contains(interfaceType)) {
            return null;
        } else if (this.map.containsKey(interfaceType, code)) {
            return (T) this.map.get(interfaceType, code);
        } else if (this.map.containsKey(interfaceType, null)) {
            return (T) this.map.get(interfaceType, code);
        } else {
            return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class[] { interfaceType }, new Handler(code, codeSystemOid));
        }
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T extends Code> T lookup(Class<T> interfaceType, String code) {
    	return lookup(interfaceType, code, null);
	}

    /**
     * <p>Adds the domain value.
     *
     * @param code the code
     * @param interfaceType the interface type
     */
    public void addDomainValue(Code code, Class<? extends Code> interfaceType) {
    	if (code==null) {
    		this.emptyDomains.add(interfaceType);
    	} else {
    		this.map.put(interfaceType, code != null ? code.getCodeValue() : null, code);
    		this.emptyDomains.remove(interfaceType);
    	}
    }


}
