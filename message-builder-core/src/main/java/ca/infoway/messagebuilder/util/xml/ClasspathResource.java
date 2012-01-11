/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.util.xml;

import java.io.InputStream;

/**
 * <p>A class that makes it easy to read a resource on the classpath as an XML document.
 * 
 * @author Intelliware Development
 * 
 * @sharpen.ignore - util.xml - translated manually
 */
public class ClasspathResource implements InputStreamResource {

	private final Class<?> c;
	private final String resourceName;

	/**
	 * <p>Standard constructor.
	 * 
	 * <p>Using this constructor is equivalent to 
	 * <code>ClasspathResource.class.getClassLoader().getResourceAsStream(resourceName)</code>
	 * 
	 * @param resourceName - the resource name.
	 */
	public ClasspathResource(String resourceName) {
		this.resourceName = resourceName;
		this.c = null;
	}
	/**
	 * <p>Standard constructor.
	 * 
	 * <p>Using this constructor is equivalent to 
	 * <code>c.getResourceAsStream(resourceName)</code>
	 * 
	 * @param c - a class whose package helps identify the location of the resource name.
	 * @param resourceName - the resource name that can be found relative to the class, c
	 */
	public ClasspathResource(Class<?> c, String resourceName) {
		this.c = c;
		this.resourceName = resourceName;
		
	}
	
	/**
	 * <p>Obtain the classpath resource as a stream.
	 * @return - the stream
	 */
	public InputStream getInputStream() {
		if (c == null) {
			return getClass().getClassLoader().getResourceAsStream(this.resourceName);
		} else {
			return c.getResourceAsStream(this.resourceName);
		}
	}

}