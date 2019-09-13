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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2013-05-06 12:01:14 -0400 (Mon, 06 May 2013) $
 * Revision:      $LastChangedRevision: 6818 $
 */
package ca.infoway.messagebuilder.generator.mif2.vocabulary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VocabularyMifMarshallerTest {

	@Test
	public void shouldReadAnnotations() throws Exception {
		
		MifVocabularyModel mifVocabularyModel = new VocabularyMifMarshaller().unmarshallVocabularyModel(getClass().getResourceAsStream("/DEFN=UV=VO=sample.coremif"));
		
		for (MifCodeSystem codeSystem : mifVocabularyModel.getCodeSystems()) {
			if (codeSystem.getName().equals("AcknowledgementDetailCode")) {
				assertEquals("<i>OpenIssue:</i>Missing description.", codeSystem.getAnnotations().getDocumentation().getDescription().getText().getParagraphs().get(0).getValue());
			}
		}
		
	}

}
