package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.lang.ClassUtils.getShortClassName;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.util.iterator.EmptyIterable;
import ca.infoway.messagebuilder.xml.TypeName;

public class ImportDeclarationGenerator extends Hl7TypeCodeGenerator implements ClassNameManager {

	private final Map<String,String> shortNameToFullNameMap = Collections.synchronizedMap(new HashMap<String,String>());
	
	private final Set<String> classes = Collections.synchronizedSet(new TreeSet<String>());
	private final TypeName typeName;
	private final NameTranslator nameTranslator;
	private final Map<TypeName, TypeName> removedTypesTranslation;

	/**
	 *
	 * @param typeName -
	 *      the fully-qualified class name of the class for which this generator is generating imports
	 * @param classes
	 * @param map 
	 */
	public ImportDeclarationGenerator(TypeName typeName, Collection<Object> classes, NameTranslator nameTranslator, Map<TypeName, TypeName> removedTypesTranslation) {
		this.typeName = typeName;
		this.nameTranslator = nameTranslator;
		this.removedTypesTranslation = removedTypesTranslation;
		
		this.shortNameToFullNameMap.put(this.nameTranslator.getClassNameWithoutPackage(typeName), this.nameTranslator.getFullyQualifiedClassName(typeName));
		
		for (Object o : EmptyIterable.nullSafeIterable(classes)) {
			if (o instanceof String) {
				addClass((String) o);
			} else if (o instanceof TypeName) {
				addClass(nameTranslator.getFullyQualifiedClassName((TypeName) o));
			}
		}
	}

	protected void addClass(String string) {
		String[] parts = StringUtils.split(string, "<,>");
		for (int i = 0, length = parts == null ? 0 : parts.length; i < length; i++) {
			String fullClassName = parts[i].indexOf('$') >= 0 ? StringUtils.substringBefore(parts[i], "$") : parts[i];
			this.classes.add(fullClassName);
			
			if (!this.shortNameToFullNameMap.containsKey(getShortClassName(fullClassName))) {
				this.shortNameToFullNameMap.put(getShortClassName(fullClassName), fullClassName);
			}
		}
	}

	public void generate(Writer writer, int indentLevel) throws IOException {
		writer.write(LINE_SEPARATOR);
		for (String string : this.classes) {
			if (isImported(string)) {
				indent(indentLevel, writer);
				writer.write(getDependencyKeyword());
				writer.write(string);
				writer.write(";");
				writer.write(LINE_SEPARATOR);
			}
		}
	}

	protected String getDependencyKeyword() {
		return "import ";
	}

	boolean isImported(String className) {
		if (StringUtils.isBlank(className)) {
			return false;
		} else if ("java.lang".equals(ClassUtils.getPackageName(className))) {
			return false;
		} else if (StringUtils.isBlank(ClassUtils.getPackageName(className))) {
			return false;
		} else if (isInSamePackage(className)) {
			return false;
		} else if (shouldBeFullyQualified(className)) {
			return false;
		} else if (!StringUtils.equals(className, this.shortNameToFullNameMap.get(getShortClassName(className)))) {
			return false;
		} else {
			return true;
		}
	}

	public String getPackageName() {
		return this.nameTranslator.getPackageName(this.typeName);
	}

	@Override
	protected boolean conflictsWithTypeName(String className) {
		return StringUtils.equals(
				this.nameTranslator.getClassNameWithoutPackage(this.typeName), 
				ClassUtils.getShortClassName(className));
	}

	public String getRepresentationOfClassName(String className) {
		if (isImported(className)) {
			return ClassUtils.getShortClassName(className);
		} else if (isInSamePackage(className) && 
				!hasNameCollision(className)) {
			return ClassUtils.getShortClassName(className);
		} else {
			return className;
		}
	}

	private boolean hasNameCollision(String className) {
		String shortName = ClassUtils.getShortClassName(className);
		return this.shortNameToFullNameMap.containsKey(shortName)
			&& !StringUtils.equals(this.shortNameToFullNameMap.get(shortName), className);
	}

	public String getRepresentationOfTypeName(TypeName typeName) {
		if (this.removedTypesTranslation.containsKey(typeName)) {
			typeName = this.removedTypesTranslation.get(typeName);
		}
		String className = this.nameTranslator.getFullyQualifiedClassName(typeName);
		return getRepresentationOfClassName(className);
	}
}
