package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.TypeName;


public class NameMatcherTest {
	
	class NamedTypeImpl implements NamedType {

		private final String businessName;
		private final TypeName name;

		public NamedTypeImpl(String name, String businessName) {
			this.businessName = businessName;
			this.name = new TypeName(name);
		}
		public String getBusinessName() {
			return this.businessName;
		}
		public TypeName getTypeName() {
			return this.name;
		}
	}
	
	@Test
	public void shouldMatchBusinessNames() throws Exception {
		assertEquals("matches", MatchType.EXACT, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", "Fred Flintstone"), 
				new NamedTypeImpl("ABCD_MT987654CA.Fred", "Fred Flintstone")));
		
		assertEquals("matches with type names are different", MatchType.EXACT, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", "Fred Flintstone"), 
						new NamedTypeImpl("ABCD_MT987654CA.StoneAgeCharacter", "Fred Flintstone")));
	}
	
	@Test
	public void shouldNotMatchIfTypeNamesDontMatch() throws Exception {
		assertEquals("matches", MatchType.MAJOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", null), 
						new NamedTypeImpl("ABCD_MT987654CA.Wilma", null)));
	}
	
	@Test
	public void shouldAlmostMatchIfNamesDifferOnlyBySuffix() throws Exception {
		assertEquals("matches", MatchType.MINOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", null), 
						new NamedTypeImpl("ABCD_MT987654CA.Fred2", null)));
		
		assertEquals("matches", MatchType.MINOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", "Fred Flintstone"), 
						new NamedTypeImpl("ABCD_MT987654CA.Fred2", null)));
	}
	
	@Test
	public void shouldNotMatchIfBusinessNamesAndTypeNamesDontMatch() throws Exception {
		assertEquals("matches", MatchType.MAJOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", "Fred Flintstone"), 
						new NamedTypeImpl("ABCD_MT987654CA.Wilma", "Wilma Flintstone")));
	}
	
	@Test
	public void shouldMatchIfBusinessNamesDontMatchButTypeNamesDoMatch() throws Exception {
		assertEquals("matches", MatchType.MINOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Wilma", "Flintstone"), 
						new NamedTypeImpl("ABCD_MT987654CA.Wilma", "Wilma Flintstone")));
	}
}
