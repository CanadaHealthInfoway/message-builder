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

package ca.infoway.messagebuilder.xml;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 * <p>A utility to read and write the object representation of a message set.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class MessageSetMarshaller {

	private Serializer serializer = new Persister();
	
	/**
	 * <p>Unmarshall a message set to a file.
	 * 
	 * @param file - the file to read
	 * @return the message set.
	 * @throws Exception - if any underlying exception occurs
	 */
	public MessageSet unmarshall(File file) throws Exception {
		return (MessageSet) this.serializer.read(MessageSet.class, file);
	}

	/**
	 * <p>Marshall a message set to an output stream.
	 * 
	 * @param domain - the message set to marshall
	 * @param output - the output stream
	 * @throws Exception - if any underlying exception occurs
	 */
	public void marshall(MessageSet domain, OutputStream output) throws Exception {
		this.serializer.write(domain, output);
	}
	/**
	 * <p>Marshall a message set to an output stream.
	 * 
	 * @param domain - the message set to marshall
	 * @param file - the file to write to
	 * @throws Exception - if any underlying exception occurs
	 */
	public void marshall(MessageSet domain, File file) throws Exception {
		this.serializer.write(domain, file);
	}

	/**
	 * <p>Unmarshall a message set to a file.
	 * 
	 * @param input - the input stream
	 * @return the message set.
	 * @throws Exception - if any underlying exception occurs
	 */
	public MessageSet unmarshall(InputStream input) throws Exception {
		return (MessageSet) this.serializer.read(MessageSet.class, input);
	}
}
