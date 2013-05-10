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
package ca.infoway.messagebuilder.datatype.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

public class DatatypeSetMarshaller {
	
	Serializer serializer = new Persister(new AnnotationStrategy());
	
	public DatatypeSet unmarshallDatatypeModel(File inputFile) throws IOException {
		try {
			return (DatatypeSet) this.serializer.read(DatatypeSet.class, inputFile);
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Exception occurred during marshalling", e);
		}
	}
	
	public DatatypeSet unmarshallDatatypeModel(InputStream input) throws IOException {
		try {
			return (DatatypeSet) this.serializer.read(DatatypeSet.class, input);
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Exception occurred during marshalling", e);
		}
	}

	public void marshall(DatatypeSet model, OutputStream outputStream) throws IOException {
		try {
			this.serializer.write(model, outputStream);
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Exception occurred during marshalling", e);
		}
	}

}
