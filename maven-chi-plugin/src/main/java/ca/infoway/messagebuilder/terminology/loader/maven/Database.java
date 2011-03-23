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
	public ValueSetEntry findValueSetEntry(String valueSetName, Code code);
	public ValueSet findValueSet(String name);
	public void saveValueSetEntry(ValueSetEntry valueSet);
	public void saveValueSet(ValueSet valueSet);
	
}
