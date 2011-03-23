package ca.infoway.messagebuilder.generator.java;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;

import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>This class provides information about how we'd merge various types in 
 * case 3 simplification.</p>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 */
public class MergedTypeDescriptor {

	private TypeName newName;
	private final Set<TypeName> mergedTypes = Collections.synchronizedSet(new HashSet<TypeName>());
	
	public MergedTypeDescriptor() {
		this.newName = TemporaryTypeName.create("merged");
	}
	
	public Set<TypeName> getMergedTypes() {
		return this.mergedTypes;
	}

	public TypeName getNewName() {
		return this.newName;
	}
	
	@Override
	public int hashCode() {
		return this.newName.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj.getClass() != getClass()) {
			return false;
		} else {
			MergedTypeDescriptor that = (MergedTypeDescriptor) obj;
			return new EqualsBuilder().append(this.newName, that.newName).isEquals();
		}
	}
}
