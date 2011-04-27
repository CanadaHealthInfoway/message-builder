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

package ca.infoway.messagebuilder.maven.util;

import org.apache.maven.plugin.Mojo;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;

/**
 * <p>This class provides an implementation of the output UI that connects to the 
 * Maven output/log mechanism.  When the generator tools indicate that information 
 * should be displayed to the user, this class directs that output to the appropriate
 * Maven constructs.
 * 
 * @author administrator
 */
public class OutputUIImpl implements OutputUI {
	
	private final Mojo mojo;

	/**
	 * <p>Default constructor.
	 * @param mojo - the plugin that will generate the output log events.
	 */
	public OutputUIImpl(Mojo mojo) {
		this.mojo = mojo;
	}

	/**
	 * <p>Perform logging.
	 * 
	 * @param level - the log level (e.g. "INFO", "WARN", etc.)
	 * @param message - the message that should be written to the log.
	 */
	public void log(LogLevel level, String message) {
		if (level == null) {
			level = LogLevel.INFO;
		}
		switch (level) {
		case DEBUG:
			this.mojo.getLog().debug(message);
			break;
		case INFO:
			this.mojo.getLog().info(message);
			break;
		case WARN:
			this.mojo.getLog().warn(message);
			break;
		case ERROR:
		case SEVERE:
			this.mojo.getLog().error(message);
		default:
		}
	}
}