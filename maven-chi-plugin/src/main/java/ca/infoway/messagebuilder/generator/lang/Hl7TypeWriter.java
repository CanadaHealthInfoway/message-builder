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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.GeneratorException;

/**
 * <p>A standard interface to describe a component that writes out the definition
 * of a message type.  There are multiple "formats" that we can use to write the 
 * message type: Java classes, .Net classes or XML XSDs.  Each format has a corresponding
 * Type Writer implementation.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface Hl7TypeWriter {
	public void write(Writer writer) throws IOException, GeneratorException;
}