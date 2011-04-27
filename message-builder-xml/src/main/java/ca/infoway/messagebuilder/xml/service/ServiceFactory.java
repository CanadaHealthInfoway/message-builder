/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.xml.service;

import static ca.infoway.messagebuilder.j5goodies.EnumeratedIterable.iterable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>A common Java practice for allowing configurable implementations of a service
 * interface is to look for a file in the META-INF directory of a jar.  An example of 
 * this problem is XML parsing.  There's an abstract factory type called
 * <code>javax.xml.parsers.DocumentBuilderFactory</code>, and the expectation is that
 * some component will provide a concrete implementation of this type.  
 * 
 * <p>The Java way of handling that is to look for a file in the META-INF directory
 * called /META-INF/javax.xml.parsers.DocumentBuilderFactory
 * 
 * <p>The file is a simple text file that contains the fully-qualified name of an
 * implementing class, and Java can decide to pick one (or many) of those implementations.
 * 
 * <p>This class implements behaviour like that -- it looks for a set of resources
 * on the classpath, named after a specific type, and finds the corresponding classes.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @param <T> - the interface type of the service
 * 
 * @sharpen.ignore ServiceFactory
 */
public abstract class ServiceFactory<T> {
	
	private Log log = LogFactory.getLog(ServiceFactory.class);
	private final Class<T> c;

	/**
	 * <p>Standard constructor.
	 * @param c - the type of service that the factory finds
	 */
	public ServiceFactory(Class<T> c) {
		this.c = c;
	}
	
	/**
	 * <p>Create an instance of the service.
	 * @return - the instance of the service.
	 */
	public T create() {
		try {
			Enumeration<URL> resources = getServiceImplementations();
			List<T> services = getServices(resources);
			return chooseImplementationOfService(services);
		} catch (IOException e) {
			return createTrivialService();
		}
	}
	/**
	 * <p>Choose an implementation of a service, based on several options.
	 * @return - the instance of the service.
	 */
	protected abstract T chooseImplementationOfService(List<T> services);
	/**
	 * <p>Create a trivial service if no other option exists.
	 * @return - the trivial service.
	 */
	protected abstract T createTrivialService();

	/**
	 * <p>Find all implementations of the message definition service.
	 * 
	 * @param resources - an enumeration of all the URLs to service files
	 * @return - a list of instances that implement the service interface.
	 * @throws IOException - if any resource cannot be accessed.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> getServices(Enumeration<URL> resources) throws IOException {
		List<T> result = new ArrayList<T>();
		for (URL url : iterable(resources)) {
			String className = read(url);
			if (StringUtils.isNotBlank(className)) {
				Class<?> messageServiceClass = getClass(className);
				if (messageServiceClass != null 
						&& c.isAssignableFrom(messageServiceClass)) {
					try {
						T service = (T) messageServiceClass.newInstance();
						result.add(service);
					} catch (InstantiationException e) {
						this.log.warn("Service " + className + " cannot be instantiated.  It will be ignored.", e);
					} catch (IllegalAccessException e) {
						this.log.warn("Service " + className + " cannot be instantiated.  It will be ignored.", e);
					} catch (RuntimeException e) {
						this.log.warn("Service " + className + " cannot be instantiated.  It will be ignored.", e);
					}
				} else {
					this.log.warn("Service " + className + " is not a valid service implementation.");
				}
			}
		}
		return result;
	}

	private Class<?> getClass(String className) {
		try {
			return Class.forName(StringUtils.trim(className));
		} catch (ClassNotFoundException e) {
			return null;
		} catch (NoClassDefFoundError e) {
			return null;
		}
	}

	private String read(URL url) throws IOException {
		InputStream input = url.openConnection().getInputStream();
		try {
			return IOUtils.toString(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

	private Enumeration<URL> getServiceImplementations() throws IOException {
		return getClass().getClassLoader().getResources(
				"META-INF/services/" + 
				c.getName());
	}
}
