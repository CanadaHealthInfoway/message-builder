package ca.infoway.messagebuilder.generator.java;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.CompareToBuilder;

import ca.infoway.messagebuilder.xml.TypeName;

@Deprecated
class SortedTypeProvider implements TypeProvider {

	public class ComparatorImpl implements Comparator<Type> {
		public int compare(Type o1, Type o2) {
			return new CompareToBuilder().append(o1.getTypeName().getName(), o2.getTypeName().getName()).toComparison();
		}
	}

	private Collection<Type> types;
	private Map<TypeName, Type> nameMap = new HashMap<TypeName, Type>();

	public SortedTypeProvider(TypeProvider typeProvider) {
		Collection<Type> types = typeProvider.getAllMessageTypes();
		this.types = initialize(types);
		for (Type type : types) {
			this.nameMap.put(type.getTypeName(), type);
		}
	}
	
	private Collection<Type> initialize(Collection<Type> types) {
		Set<Type> result = new TreeSet<Type>(new ComparatorImpl());
		result.addAll(types);
		return result;
	}

	public Collection<Type> getAllMessageTypes() {
		return this.types;
	}

	public Type getTypeByName(TypeName name) {
		return this.nameMap.get(name);
	}
}
