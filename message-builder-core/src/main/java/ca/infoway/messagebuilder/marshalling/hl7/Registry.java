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

package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.Typed;


public abstract class Registry<T> {
    
    private final Map<String,T> registryMap = Collections.synchronizedMap(new HashMap<String,T>());
    private final Log log = LogFactory.getLog(Registry.class);

    public Registry() {
        registerAll();
    }
    
    protected void register(Class<? extends T> c) {
        try {
        	T instance = (T) c.newInstance();
            register(instance);
        } catch (IllegalArgumentException e) {
            this.log.warn("Could not register an instance of " + c.getName() + ": " + e);
        } catch (IllegalAccessException e) {
            this.log.warn("Could not register an instance of " + c.getName() + ": " + e);
        } catch (InstantiationException e) {
            this.log.warn("Could not register an instance of " + c.getName() + ": " + e);
        }
    }

	@SuppressWarnings("unchecked")
	protected void register(T instance) {
        try {
			List<String> keys = getRegistrationKey((Class<? extends T>) instance.getClass());
			for (String key : keys) {
				putInstance(key, instance);
			}
	    } catch (IllegalArgumentException e) {
	        this.log.warn("Could not register an instance of " + instance.getClass().getName() + ": " + e);
	    } catch (IllegalAccessException e) {
	        this.log.warn("Could not register an instance of " + instance.getClass().getName() + ": " + e);
	    }
	}

    private void putInstance(String key, T instance) {
        Map<String, T> map = getRegistryMap();
        if (map.containsKey(key)) {
            this.log.warn("Not registering an instance of " + instance.getClass().getName() + " with type \"" + key 
                    + "\" because an instance of " + map.get(key).getClass() 
                    + " has already been registered");
        } else {
            map.put(key, instance);
            this.log.debug("An instance of " + instance.getClass().getName() + " was registered as type \"" + key + "\"");
        }
    }
    
    public List<String> getRegistrationKey(Class<? extends T> c) throws IllegalArgumentException, IllegalAccessException {
    	if (c.isAnnotationPresent(DataTypeHandler.class)) {
    		return getRegistrationKeyFromAnnotation(c);
    	} else {
    		throw new IllegalStateException("Registered class " + c + " does not contain a @DataTypeHandler annotation");
    	}
    }

	private List<String> getRegistrationKeyFromAnnotation(Class<? extends T> c) {
		DataTypeHandler handler = c.getAnnotation(DataTypeHandler.class);
		return Arrays.asList(handler.value());
	}

    public T get(Typed typed) {
    	return get(typed.getType());
    }
	
    public T get(String name) {
        T result = this.registryMap.get(name);
        if (result == null) {
        	result = this.registryMap.get(Hl7DataTypeName.getTypeWithoutParameters(name));
        }
        if (result == null) {
       		result = this.registryMap.get(Hl7DataTypeName.unqualify(name));
        }
        if (result == null) {
        	result = this.registryMap.get(Hl7DataTypeName.getTypeWithoutParameters(Hl7DataTypeName.unqualify(name)));
        }
		return result;
    }
    
    protected abstract void registerAll();

    private Map<String,T> getRegistryMap() {
        return this.registryMap;
    }
}
