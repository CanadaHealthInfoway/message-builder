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
 * Last modified: $LastChangedDate: 2012-03-06 13:41:31 -0500 (Tue, 06 Mar 2012) $
 * Revision:      $LastChangedRevision: 5770 $
 */
package ca.infoway.messagebuilder.generator.mif2.vocabulary;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.generator.MifProcessingException;

public class VocabularyMifMarshaller {
	
	private Serializer serializer = new Persister(new AnnotationStrategy());
	
	public MifVocabularyModel unmarshallVocabularyModel(InputStream input) throws IOException, MifProcessingException {
		try {
			return (MifVocabularyModel) this.serializer.read(MifVocabularyModel.class, input);
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw new MifProcessingException("Exception occurred during marshalling", e);
		}
	}
	public MifVocabularyModel unmarshallVocabularyModel(File file) throws IOException, MifProcessingException {
		try {
			return (MifVocabularyModel) this.serializer.read(MifVocabularyModel.class, file);
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw new MifProcessingException("Exception occurred during marshalling", e);
		}
	}

}
