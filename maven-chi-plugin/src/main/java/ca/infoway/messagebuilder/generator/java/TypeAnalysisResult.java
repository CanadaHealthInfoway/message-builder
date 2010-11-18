package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.xml.TypeName;

import com.google.common.base.Predicate;

public class TypeAnalysisResult implements TypeProvider, TypeNameHelper {

    protected final Map<TypeName,Type> types = Collections.synchronizedMap(new LinkedHashMap<TypeName,Type>());
    protected final Map<TypeName,ComplexTypePackage> packages = Collections.synchronizedMap(new LinkedHashMap<TypeName,ComplexTypePackage>());
    protected final Map<TypeName,Type> removedTypes = Collections.synchronizedMap(new LinkedHashMap<TypeName,Type>());
    protected final Map<TypeName,TypeName> removedTypeTranslation = Collections.synchronizedMap(new LinkedHashMap<TypeName,TypeName>());
    
	public Map<TypeName, TypeName> getRemovedTypeTranslation() {
		return this.removedTypeTranslation;
	}

	public void addType(Type type) {
		TypeName rootName = type.getTypeName().getRootName();
		if (!this.packages.containsKey(rootName)) {
			this.packages.put(rootName, new ComplexTypePackage(rootName));
		}
		this.packages.get(rootName).addInnerClass(type.getTypeName().getName(), type);
		this.types.put(type.getTypeName(), type);
	}
	
	public Map<TypeName, Type> getTypes() {
		return this.types;
	}

	public Map<TypeName, Type> getRemovedTypes() {
		return this.removedTypes;
	}

	public Collection<ComplexTypePackage> getAllPackages() {
		return new ArrayList<ComplexTypePackage>(this.packages.values());
	}

	public void removeType(Type type) {
		TypeName rootName = type.getTypeName().getRootName();
		if (this.packages.containsKey(rootName)) {
			this.packages.get(rootName).removeInnerClass(type.getTypeName());
		}
		this.types.remove(type.getTypeName());
		this.removedTypes.put(type.getTypeName(), type);
	}
	
	public void removeType(Type removedType, Type newType) {
		removeType(removedType);
		this.removedTypeTranslation.put(removedType.getTypeName(), newType.getTypeName());
	}

	@SuppressWarnings("unchecked")
	public Collection<Type> getAllMessageTypes() {
		return filter(new Predicate<Type>() {
			public boolean apply(Type input) {
				return !(input instanceof InteractionType);
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public Collection<InteractionType> getAllInteractions() {
		return filter(new Predicate<Type>() {
			public boolean apply(Type input) {
				return input instanceof InteractionType;
			}
		});
	}

	@SuppressWarnings("unchecked")
	private Collection filter(Predicate<Type> predicate) {
		List<Type> result = new ArrayList<Type>();
		for (Type type : this.types.values()) {
			if (predicate.apply(type)) {
				result.add(type);
			}
		}
		return result;
	}

	/**
	 * <p>Returns information about type name, whether or not it has been removed.
	 */
	public Type getNamedType(TypeName name) {
		if (this.types.containsKey(name)) {
			return this.types.get(name);
		} else if (this.removedTypes.containsKey(name)) {
			return this.removedTypes.get(name);
		} else {
			return null;
		}
	}

	/**
	 * <p>Indicates whether or not a type is abstract.
	 */
	public boolean isAbstract(TypeName name) {
		Type type = (Type) getNamedType(name);
		return type == null ? false : type.isAbstract();
	}

	public Type getTypeByName(TypeName name) {
		return this.types.get(name);
	}

}
