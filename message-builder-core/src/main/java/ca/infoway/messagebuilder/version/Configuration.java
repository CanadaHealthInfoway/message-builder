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

package ca.infoway.messagebuilder.version;

import java.io.IOException;
import java.util.Date;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.commons.lang.SystemUtils;

import ca.infoway.messagebuilder.j5goodies.ManifestReader;

/**
 * <p>A class that provides easy access to configuration information found in the 
 * manifest file.  
 * 
 * <p>This class can be used, for example, to provide default values for version numbers
 * that could be used in the sender block of an HL7 message.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore platform - uses the class Manifest
 */
public class Configuration {
	
	private static Configuration instance;
	
	private Date date = new Date(); 
	private String name = "Message Builder Tool";
	private String version = "1.x";

	/**
	 * Static accessor.
	 * @return - the instance of the configuration.
	 */
	public static Configuration getInstance() {
		if (instance == null) {
			initializeInstance();
		}
		return instance;
	}

	private synchronized static void initializeInstance() {
		try {
			Configuration configuration = new Configuration();
			Manifest manifest = ManifestReader.read(Configuration.class);
			Attributes attributes = manifest.getMainAttributes();
			configuration.setVersion(attributes.getValue("Implementation-Version"));
			configuration.setDate(attributes.getValue("Implementation-Build-Date"));
			instance = configuration;
		} catch (IOException e) {
		}
	}

	private void setDate(String time) {
		try {
			setDate(Long.parseLong(time));
		} catch (NumberFormatException e) {
		}
	}

	private void setDate(long time) {
		this.date.setTime(time);
	}

	private void setVersion(String version) {
		this.version = version;
	}

	/**
	 * <p>Get the date that appears as the "Implementation-Build-Date" attribute in the
	 * manifest.
	 * @return - the build date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * <p>Get the component name.
	 * @return - the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * <p>Get the version that appears as the "Implementation-Version" attribute in the
	 * manifest.
	 * @return - the version
	 */
	public String getVersion() {
		return this.version;
	}
	
	/**
	 * <p>Get a version of the configuration details, suitably formatted as a 
	 * user-agent header for sending over HTTP.
	 * 
	 * @return - the configuration details formatted as a user agent header.
	 */
	public String asUserAgent() {
		return getName() + "(" + SystemUtils.OS_NAME + ") Version " + getVersion();
	}
}
