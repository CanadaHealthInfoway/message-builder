package ca.infoway.messagebuilder.terminology.codeset;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.domainvalue.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.terminology.codeset.dao.CodeSetDao;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodeSystem;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSet;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;
import ca.infoway.messagebuilder.terminology.proxy.TypedCodeFactory;

@RunWith(JMock.class)
public class DatabaseCodeResolverTest {
	
	Mockery jmock = new Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};

	private static final String CODE_VALUE = "TEST";
	private static final String CODE_SYSTEM_OID = "TEST OID";
	private static final Code CODE = createDummyCode();
	
	private CodeSetDao codeSetDao;
	private TypedCodeFactory codeFactory;
	private CodeResolver resolver; 
	
	@Before
	public void setUp() throws Exception {
		codeSetDao = this.jmock.mock(CodeSetDao.class);
		codeFactory = this.jmock.mock(TypedCodeFactory.class);
		resolver = new DatabaseCodeResolver(this.codeSetDao, this.codeFactory);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testShouldHandleLookupByCode() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(codeSetDao).selectValueSetsByCode(with(any(Class.class)), with(any(String.class)));
				will(returnValue(createValueSetsCollection(new String[] {CODE_VALUE})));
			one(codeFactory).create(
					with(same(x_NormalRestrictedTabooConfidentialityKind.class)), 
					with(hasSameContents(Arrays.asList(x_NormalRestrictedTabooConfidentialityKind.class))), 
					with(equal(CODE_VALUE)), 
					with(equal(CODE_SYSTEM_OID)), 
					with(any(Map.class)),
					with(any(Integer.class)), 
					with(any(Boolean.class)), 
					with(any(Boolean.class)));
				will(returnValue(CODE));
		}});

		Code result = resolver.lookup(x_NormalRestrictedTabooConfidentialityKind.class, CODE_VALUE);
		assertSame(CODE, result);
	}
	
	@SuppressWarnings("unchecked")
	private Matcher<Collection<Class<?>>> hasSameContents(final List types) {
		return new TypeSafeMatcher<Collection<Class<?>>>() {
			@Override
			public boolean matchesSafely(Collection<Class<?>> o) {
				Collection<Class<?>> list = (Collection<Class<?>>) o;
				if (list.size() != types.size()) {
					return false;
				} else {
					return types.containsAll(list) && list.containsAll(types);
				}
			}

			public void describeTo(Description description) {
				description.appendText("hasSameContents as " + types);
			}
		};
	}

	@Test
	public void testShouldNotDieWhenLookupByCodeFindsNoMatch() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(codeSetDao).selectValueSetsByCode(with(any(Class.class)), with(any(String.class)));
				will(returnValue(createEmptyCollection()));
		}});
		
		Code result = resolver.lookup(x_NormalRestrictedTabooConfidentialityKind.class, CODE_VALUE);
		assertNull(result);
	}
	
	@Test
	public void testShouldNotDieWhenLookupByCodeFindsMultipleMatches() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(codeSetDao).selectValueSetsByCode(with(any(Class.class)), with(any(String.class)));
				will(returnValue(createValueSetsCollection(new String[] {CODE_VALUE, "another_code"})));
			one(codeFactory).create(
					with(same(x_NormalRestrictedTabooConfidentialityKind.class)), 
					with(hasSameContents(Arrays.asList(x_NormalRestrictedTabooConfidentialityKind.class))), 
					with(equal(CODE_VALUE)), 
					with(equal(CODE_SYSTEM_OID)), 
					with(any(Map.class)),
					with(any(Integer.class)), 
					with(any(Boolean.class)), 
					with(any(Boolean.class)));
				will(returnValue(CODE));
		}});
	
		Code result = resolver.lookup(x_NormalRestrictedTabooConfidentialityKind.class, CODE_VALUE);
		assertSame(CODE, result);
	}
	
	@Test
	public void testShouldHandleLookupByCodeSystem() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(codeSetDao).findValueByCodeSystem(with(any(Class.class)), with(any(String.class)), with(any(String.class)));
				will(returnValue(createValueSet(CODE_VALUE)));
			one(codeFactory).create(
					with(same(x_NormalRestrictedTabooConfidentialityKind.class)), 
					with(hasSameContents(Arrays.asList(x_NormalRestrictedTabooConfidentialityKind.class))), 
					with(equal(CODE_VALUE)), 
					with(equal(CODE_SYSTEM_OID)), 
					with(any(Map.class)),
					with(any(Integer.class)), 
					with(any(Boolean.class)), 
					with(any(Boolean.class)));
				will(returnValue(CODE));
		}});
		
		Code result = resolver.lookup(x_NormalRestrictedTabooConfidentialityKind.class, CODE_VALUE, CODE_SYSTEM_OID);
		assertSame(CODE, result);
	}
	
	@Test
	public void testShouldFindAllTypesForCode() {
		final List<Class<?>> list = new ArrayList<Class<?>>();
		list.add(x_NormalRestrictedTabooConfidentialityKind.class);
		list.add(x_VeryBasicConfidentialityKind.class);
		this.jmock.checking(new Expectations() {{
			allowing(codeSetDao).findValueByCodeSystem(with(any(Class.class)), with(any(String.class)), with(any(String.class)));
				will(returnValue(createValueSet(CODE_VALUE, list)));
			one(codeFactory).create(
					with(same(Confidentiality.class)), 
					with(hasSameContents(list)), 
					with(equal(CODE_VALUE)), 
					with(equal(CODE_SYSTEM_OID)), 
					with(any(Map.class)),
					with(any(Integer.class)), 
					with(any(Boolean.class)), 
					with(any(Boolean.class)));
				will(returnValue(CODE));
		}});		
		
		Code result = resolver.lookup(Confidentiality.class, CODE_VALUE, CODE_SYSTEM_OID);
		assertSame(CODE, result);		
	}

	private Object createValueSet(String code, List<Class<?>> list) {
		ValueSetEntry valueSetEntry = new ValueSetEntry();
		ValueSet valueSet = new ValueSet();
		valueSetEntry.setValueSet(valueSet);
		for (Class<?> type : list) {
			valueSet.getVocabularyDomains().add(new VocabularyDomain(ClassUtils.getShortClassName(type)));
		}
		valueSetEntry.setCodedValue(createCodedValue(code));
		return valueSetEntry;
	}

	private ValueSetEntry createValueSet(String code) {
		ValueSet valueSet = new ValueSet();
		valueSet.getVocabularyDomains().add(new VocabularyDomain("x_NormalRestrictedTabooConfidentialityKind"));
		ValueSetEntry valueSetEntry = new ValueSetEntry();
		valueSetEntry.setValueSet(valueSet);
		valueSetEntry.setCodedValue(createCodedValue(code));
		return valueSetEntry;
	}

	private ValueSetEntry createValueSetWithDisplayText(String code) {
		ValueSet valueSet = new ValueSet();
		valueSet.getVocabularyDomains().add(new VocabularyDomain("x_NormalRestrictedTabooConfidentialityKind"));
		ValueSetEntry valueSetEntry = new ValueSetEntry();
		valueSetEntry.setValueSet(valueSet);
		valueSetEntry.setCodedValue(createCodedValueWithDisplayText(code));
		return valueSetEntry;
	}
	
	@Test
	public void testShouldNotDieWhenLookupByCodeSystemFindsNoMatch() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(codeSetDao).findValueByCodeSystem(with(any(Class.class)), with(any(String.class)), with(any(String.class)));
				will(returnValue(null));
		}});		
		
		Code result = resolver.lookup(x_NormalRestrictedTabooConfidentialityKind.class, CODE_VALUE, CODE_SYSTEM_OID);
		assertNull(result);
	}
	
	@Test
	public void testShouldGenerateDisplayTextMapCorrectly() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(codeSetDao).findValueByCodeSystem(with(any(Class.class)), with(any(String.class)), with(any(String.class)));
				will(returnValue(createValueSetWithDisplayText(CODE_VALUE)));
			one(codeFactory).create(
					with(same(x_NormalRestrictedTabooConfidentialityKind.class)), 
					with(hasSameContents(Arrays.asList(x_NormalRestrictedTabooConfidentialityKind.class))), 
					with(equal(CODE_VALUE)), 
					with(equal(CODE_SYSTEM_OID)), 
					with(isValidDisplayTextMap()),
					with(any(Integer.class)), 
					with(any(Boolean.class)), 
					with(any(Boolean.class)));
				will(returnValue(CODE));
		}});
		
		Code result = resolver.lookup(x_NormalRestrictedTabooConfidentialityKind.class, CODE_VALUE, CODE_SYSTEM_OID);
		assertSame(CODE, result);
	}
	
	private Matcher<Map> isValidDisplayTextMap() {
		return new TypeSafeMatcher<Map>() {
			@Override
			public boolean matchesSafely(Map o) {
				if (!Map.class.isAssignableFrom(o.getClass())) {
					return false;
				}
				Map<String, String> map = (Map<String, String>) o;
				if (!(map.size() == 2)) {
					return false;
				}
				if (!map.containsKey("en")) {
					return false;
				}
				if (!"english".equals(map.get("en"))) {
					return false;
				}
				if (!map.containsKey("fr")) {
					return false;
				}
				if (!"french".equals(map.get("fr"))) {
					return false;
				}
				return true;
			}
			public void describeTo(Description description) {
				description.appendText("map with expected values");
			}
		};
	}
	
	private <T> List<T> createEmptyCollection() {
		return Collections.emptyList();
	}
	
	private List<ValueSetEntry> createValueSetsCollection(String[] codes) {
		List<ValueSetEntry> result = new ArrayList<ValueSetEntry>();
		for (String code : codes) {
			result.add(createValueSet(code));
		}
		return result;
	}
	
	private CodedValue createCodedValue(String code) {
		CodedValue result = new CodedValue();
		result.setCode(code);
		result.setCodeSystem(createCodeSystem());
		return result;
	}
	
	private CodedValue createCodedValueWithDisplayText(String code) {
		CodedValue result = createCodedValue(code);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", "english");
		map.put("fr", "french");
		result.setDescriptions(map);
		
		return result;
	}

	private CodeSystem createCodeSystem() {
		CodeSystem result = new CodeSystem();
		result.setOid(CODE_SYSTEM_OID);
		return result;
	}

	private static Code createDummyCode() {
		return new x_NormalRestrictedTabooConfidentialityKind() {
			public String getCodeValue() {return null;}
			public String getCodeSystem() {return null;}
		};
	}
}
