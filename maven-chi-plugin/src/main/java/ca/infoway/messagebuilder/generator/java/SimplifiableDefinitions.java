package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.codehaus.plexus.util.StringUtils;

import ca.infoway.messagebuilder.xml.TypeName;

public class SimplifiableDefinitions implements SimplifiableTypeProvider {
	
	private Map<String,SimplifiableType> types = Collections.synchronizedMap(new TreeMap<String,SimplifiableType>());
	private Map<String,SimplifiablePackage> packages = Collections.synchronizedMap(new TreeMap<String,SimplifiablePackage>());
	private Map<String,SimplifiableInteraction> interactions = Collections.synchronizedMap(new TreeMap<String,SimplifiableInteraction>());

	public void addType(SimplifiableType type) {
		String name = type.getMessagePart().getName();
		this.types.put(name, type);
		String packageName = new TypeName(name).getParent().getName();
		
		if (!this.packages.containsKey(packageName)) {
			this.packages.put(packageName, new SimplifiablePackage(packageName));
		}
		this.packages.get(packageName).getTypes().add(type);
	}

	public SimplifiableType getType(String name) {
		return this.types.get(name);
	}

	public void addInteraction(SimplifiableInteraction interaction) {
		this.interactions.put(interaction.getInteraction().getName(), interaction);
	}

	public Collection<SimplifiablePackage> getAllPackages() {
		return this.packages.values();
	}

	public Collection<SimplifiableType> getAllTypes() {
		return this.types.values();
	}
	
	public Collection<SimplifiableInteraction> getAllInteractions() {
		return this.interactions.values();
	}

	public NamedType getNamedType(TypeName name) {
		return getType(name.getName());
	}
	
	void removeType(String name) {
		this.types.remove(name);
		String packageName = new TypeName(name).getParent().getName();
		if (!this.packages.containsKey(packageName)) {
			for (SimplifiableType type : new ArrayList<SimplifiableType>(this.packages.get(packageName).getTypes())) {
				if (StringUtils.equals(name, type.getName())) {
					this.packages.get(packageName).getTypes().add(type);
				}
			}
		}
	}
	void removeInteraction(String name) {
		this.interactions.remove(name);
	}
}
