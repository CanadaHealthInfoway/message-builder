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

package ca.infoway.messagebuilder.terminology.loader.maven;

import java.util.Collection;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodeSystem;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSet;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;

interface Database {

	public VocabularyDomain getVocabularyDomainByName(String vocabularyDomainName);
	public void saveVocabularyDomains(Collection<VocabularyDomain> vocabularyDomain);
	public CodeSystem getCodeSystem(String oid);
	public CodedValue findCodedValue(Code code);
	public void saveCodedValues(Collection<CodedValue> values);
	public ValueSetEntry findValueSetEntry(String valueSetName, Code code, String version);
	public ValueSet findValueSet(String name, String version);
	public void saveValueSetEntry(ValueSetEntry valueSet);
	public void saveValueSet(ValueSet valueSet);
	
}
