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

package ca.infoway.messagebuilder.generator;

/**
 * <p>A high-level logging interface.
 * 
 * <p>In practice, we intend to direct the log messages to the Maven log mechanism, but
 * we use this interface to isolate the dependency on Maven.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface LogUI {
	
	/**
	 * <p>Write a message to the log.
	 * @param level - the log level ("DEBUG", "INFO", etc.) of the message
	 * @param message - a text message to log
	 */
	public void log(LogLevel level, String message);
}
