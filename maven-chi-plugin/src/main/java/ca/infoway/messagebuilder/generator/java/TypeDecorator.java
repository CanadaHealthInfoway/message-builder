package ca.infoway.messagebuilder.generator.java;

import static java.lang.String.format;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

enum TypeDecorator {
	NULL() {
		@Override
		public String decorateType(String type, ProgrammingLanguage language) {
			return type;
		}
		@Override
		public String decorateImplType(String type, String implType, ProgrammingLanguage language) {
			return implType;
		}
	}, 
	LIST() {
		@Override
		public String decorateType(String type, ProgrammingLanguage language) {
			return language == ProgrammingLanguage.C_SHARP ? format("IList<%s>", type) : format("List<%s>", type);
		}
		@Override
		public String decorateImplType(String type, String implType, ProgrammingLanguage language) {
			return language == ProgrammingLanguage.C_SHARP ? format("List<%s>", type) : format("ArrayList<%s>", type);
		}
	};
	public abstract String decorateType(String type, ProgrammingLanguage language);
	public abstract String decorateImplType(String type, String implType, ProgrammingLanguage language);
}