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

package ca.infoway.messagebuilder.generator.dotnet;

import static ca.infoway.messagebuilder.generator.dotnet.NamespaceHelper.toNamespace;
import static ca.infoway.messagebuilder.util.iterator.EmptyIterable.nullSafeIterable;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.lang.Indenter;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;
import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>A class that manages the "using" block in a C# source file.
 * 
 * <p>This class has two main responsibilities.  First, it determines which 
 * namespaces are referenced.  Second, it determines whether or not a reference
 * needs to be fully-qualified.
 * 
 * <p>In Java, the import feature only helps to support unqualified names.  Thus, if 
 * a name is always fully qualified, it isn't imported.  This is not true of "using"
 * statements in C#.  One must always specify namespaces that are being used.
 * 
 * <p>Unlike Java, the "using" directive applies to the entire namespace, not an
 * individual class.  Thus, it's easy to get ambiguous references if the same
 * class name appears in more than one referenced namespace.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class UsingManager extends Indenter implements DependencyManager {
	
	private static final Map<String, String> csharpEquivalents;
	
	static {
		Map<String,String> map = new HashMap<String,String>();
		map.put(String.class.getName(), "System.String");
		map.put(Boolean.class.getName(), "System.bool?");
		map.put(Integer.class.getName(), "System.int?");
		map.put(Long.class.getName(), "System.long?");
		map.put(Object.class.getName(), "System.object");
		map.put(BigDecimal.class.getName(), "System.decimal?");
		map.put(Date.class.getName(), "System.DateTime?");
		map.put(List.class.getName(), "System.Collections.Generic.IList");
		map.put(Collection.class.getName(), "System.Collections.Generic.ICollection");
		map.put(Set.class.getName(), "System.Collections.Generic.ISet");
		map.put(ArrayList.class.getName(), "System.Collections.Generic.List");
		csharpEquivalents = Collections.unmodifiableMap(map);
	}

	private String currentNamespace;
	private Set<String> imports = new TreeSet<String>();
	private Map<String,List<String>> typeToNamespaceMap = new HashMap<String,List<String>>();
	private final NameTranslator nameTranslator;
	
	public UsingManager(TypeName typeName, Collection<Object> classes,
			NameTranslator nameTranslator, NamespaceContents contents) {
		this.nameTranslator = nameTranslator;
		this.currentNamespace = nameTranslator.getPackageName(typeName);
		
		addClass(nameTranslator.getFullyQualifiedClassName(typeName));

		for (Object o : nullSafeIterable(classes)) {
			if (o instanceof String && StringUtils.equals(Collections.class.getName(), (String) o)) {
				// skip it
			} else if (o instanceof String) {
				addClass((String) o);
			} else if (o instanceof TypeName) {
				addClass(nameTranslator.getFullyQualifiedClassName((TypeName) o));
			}
		}
		
		for (String namespace : this.imports) {
			List<String> types = contents.getAllTypes(namespace);
			for (String type : EmptyIterable.nullSafeIterable(types)) {
				if (!this.typeToNamespaceMap.containsKey(type)) {
					this.typeToNamespaceMap.put(type, new ArrayList<String>());
				}
				this.typeToNamespaceMap.get(type).add(namespace);
			}
		}
	}
	
	protected void addClass(String string) {
		if (string.startsWith("java.")) {
			String translation = translateToCsharp(string);
			addToNamespaceMap(translation);
		} else {
			addToNamespaceMap(string);
		}
	}

	private void addToNamespaceMap(String translation) {
		String namespace = ClassUtils.getPackageName(translation);
		this.imports.add(toNamespace(namespace));
	}

	private String translateToCsharp(String string) {
		if (csharpEquivalents.containsKey(string)) {
			return csharpEquivalents.get(string);
		} else {
			throw new IllegalArgumentException("Cannot find .Net equivalent of " + string);
		}
	}

	protected String getDependencyKeyword() {
		return "using ";
	}

	public String getRepresentationOfClassName(String className) {
		String namespace = toCSharpConvention(ClassUtils.getPackageName(className));
//		if (this.currentNamespace.equals(namespace)) {
//			return ClassUtils.getShortClassName(className);
//		} else if (this.imports.contains(NamespaceHelper.toNamespace(namespace)) && !isAmbiguous(className)) {
//			return ClassUtils.getShortClassName(className);
//		} else {
			return namespace + "." + ClassUtils.getShortClassName(className);
//		}
	}

	private String toCSharpConvention(String packageName) {
		String[] words = StringUtils.split(packageName, ".");
		for (int i = 0; i < words.length; i++) {
			words[i] = WordUtils.capitalize(words[i]);
		}
		return StringUtils.join(words, ".");
	}

	private boolean isAmbiguous(String className) {
		String shortClassName = ClassUtils.getShortClassName(className);
		if (this.typeToNamespaceMap.containsKey(shortClassName)) {
			return this.typeToNamespaceMap.get(shortClassName).size() > 1;
		} else {
			return false;
		}
	}

	public String getRepresentationOfTypeName(TypeName typeName) {
		return getRepresentationOfClassName(this.nameTranslator.getFullyQualifiedClassName(typeName));
	}

	public void generate(Writer writer, int indentLevel) throws IOException {
		for (String importNamespace : this.imports) {
			if (!StringUtils.equals(this.currentNamespace, importNamespace)) {
				indent(indentLevel, writer);
				writer.write("using ");
				writer.write(importNamespace);
				writer.write(";");
				writer.write(LINE_SEPARATOR);
			}
		}
	}

	public String getRepresentationOfType(Type type) {
		return getRepresentationOfClassName(type.getLanguageSpecificName().getFullyQualifiedName());
	}
}
