package ca.infoway.messagebuilder.generator.dotnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeProvider;

class NamespaceContentsImpl implements NamespaceContents {

	public Map<String,List<String>> types = new HashMap<String,List<String>>();
	
	NamespaceContentsImpl(NameTranslator translator, TypeProvider provider) {
		for (Type type : provider.getAllMessageTypes()) {
			String packageName = translator.getPackageName(type.getTypeName());
			String className = translator.getClassNameWithoutPackage(type.getTypeName());
			if (!this.types.containsKey(packageName)) {
				this.types.put(packageName, new ArrayList<String>());
			}
			this.types.get(packageName).add(className);
		}
	}
	
	public List<String> getAllTypes(String namespaceName) {
		return this.types.get(namespaceName);
	}
}
