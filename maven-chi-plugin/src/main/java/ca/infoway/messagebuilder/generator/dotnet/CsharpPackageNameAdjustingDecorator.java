package ca.infoway.messagebuilder.generator.dotnet;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>A decorator that adjusts the package names to the C# format of 
 * first-letter-capitalization.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
class CsharpPackageNameAdjustingDecorator implements NameTranslator {

	private final NameTranslator nameTranslator;

	CsharpPackageNameAdjustingDecorator(NameTranslator nameTranslator) {
		this.nameTranslator = nameTranslator;
	}

	public String getClassNameWithoutPackage(TypeName name) {
		return this.nameTranslator.getClassNameWithoutPackage(name);
	}

	public String getFullyQualifiedClassName(TypeName name) {
		String fullyQualifiedName = getPackageName(name) + "." + getClassNameWithoutPackage(name);
		return fullyQualifiedName; 
	}

	public String getPackageName(TypeName name) {
		String packageName = this.nameTranslator.getPackageName(name);
		String[] words = StringUtils.split(packageName, ".");
		for (int i = 0; i < words.length; i++) {
			words[i] = WordUtils.capitalize(words[i]);
		}
		return StringUtils.join(words, ".");
	}
}
