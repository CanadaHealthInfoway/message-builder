package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public enum GetterBodyStyle implements MethodBody {
	DEFAULT() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return "return this.{0};";
		}
	},
	DERIVED_CHOICE() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ?
					"return this.{0} instanceof {2} ? ({2}) this.{0} : null;"
				  : "return this.{0} is {2} ? ({2}) this.{0} : ({2}) null;";
		}
	},
	DERIVED_CHOICE_HAS() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ?
					"return (this.{0} instanceof {2});"
				  : "return (this.{0} is {2});";
		}
	},
	ATTRIBUTE() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "return this.{0}.getValue();" : "return this.{0}.Value;";
		}
	},
	CODED_ATTRIBUTE() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "return ({3}) this.{0}.getValue();" : "return ({3}) this.{0}.Value;";
		}
	},
	ATTRIBUTE_SET() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "return this.{0}.rawSet();" : "return this.{0}.RawSet();";
		}
	},
	CODED_ATTRIBUTE_SET() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "return this.{0}.rawSet({4}.class);" : "return this.{0}.RawSet<{4}>();";
		}
	},
	ATTRIBUTE_LIST() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "return this.{0}.rawList();" : "return this.{0}.RawList();";
		}
	},
	CODED_ATTRIBUTE_LIST() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "return this.{0}.rawList({4}.class);" : "return this.{0}.RawList<{4}>();";
		}
	},
	COLLECTION_ELEMENT() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return "return get{0}().isEmpty() ? null : get{0}().iterator().next();";
		}
		@Override
		public boolean useTypeDecorator() {
			return false;
		}
	},
	ASSOCIATION_COLLAPSED_TO_ATTRIBUTE() {
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() 
					? "return new RawListWrapper<{5}, {3}>({1}, {2});"
					: "return new RawListWrapper<{5}, {3}>({1}, {2});";
//					   
		}
	};

	public boolean useTypeDecorator() {
		return true;
	}
}