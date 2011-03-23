package ca.infoway.messagebuilder.generator.regen;

import org.apache.commons.lang.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class BaseRelationshipMatchers {

	public static Matcher<BaseRelationship> matchingDocumentation(final String documentation) {
		return new TypeSafeMatcher<BaseRelationship>() {
			@Override
			public boolean matchesSafely(BaseRelationship relationship) {
				return relationship.getDocumentation()!=null && relationship.getDocumentation().getParagraphs().contains(documentation);
			}
			public void describeTo(Description description) {
				description.appendText("documentation: " + documentation);
			}
		};
	}
	
	public static Matcher<BaseRelationship> matchingName(final String name) {
		return new TypeSafeMatcher<BaseRelationship>() {
			@Override
			public boolean matchesSafely(BaseRelationship relationship) {
				return StringUtils.equals(relationship.getName(), name);
			}
			public void describeTo(Description description) {
				description.appendText("name: " + name);
			}
		};
	}
	
	public static Matcher<BaseRelationship> matchingFixedValue(final String fixedValue) {
		return new TypeSafeMatcher<BaseRelationship>() {
			@Override
			public boolean matchesSafely(BaseRelationship relationship) {
				return StringUtils.equals(relationship.getFixedValue(), fixedValue);
			}
			public void describeTo(Description description) {
				description.appendText("fixed value: " + fixedValue);
			}
		};
	}

	public static Matcher<BaseRelationship> matchingConformanceLevel(final ConformanceLevel conformanceLevel) {
		return new TypeSafeMatcher<BaseRelationship>() {
			@Override
			public boolean matchesSafely(BaseRelationship relationship) {
				return relationship.getConformanceLevel()==conformanceLevel;
			}
			public void describeTo(Description description) {
				description.appendText("conformance: " + conformanceLevel);
			}
		};
	}
	
}
