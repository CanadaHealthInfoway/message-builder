package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.COLLECTION;
import ca.infoway.messagebuilder.datatype.Hl7TypeName;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

@SuppressWarnings("unchecked")
public class CollectionToSetOfTnAdapter implements DataTypeAdapter {

	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		if (COLLECTION.class.isAssignableFrom(fromDataType)
		 && StandardDataType.SET.equals(StandardDataType.getByTypeName(toDataTypeName))
		 && containerOfTn(toDataTypeName)) {
			return true;
		}
		return false;
	}
	
	private boolean containerOfTn(String fromDataTypeName) {
		boolean containerOfTn = false;
		List<Hl7TypeName> parameters = Hl7TypeName.parse(fromDataTypeName).getParameters();
		
		if (parameters!=null && !parameters.isEmpty()) {
			for (Hl7TypeName parameter : parameters) {
				if (StandardDataType.TN.getRootType().equals(parameter.getRootName()) ) {
					containerOfTn = true;
				}
			}
		}
		return containerOfTn;
	}
	
	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType) {
		return false;
	}
	
	public BareANY adapt(BareANY any) {
		Collection collection = ((COLLECTION) any).rawCollection();

		SETImpl adaptedSet = new SETImpl(TNImpl.class);
		
		if (any.hasNullFlavor()) {
			NullFlavor nullFlavor = any.getNullFlavor();
			adaptedSet.setNullFlavor(nullFlavor);	
		} else {
			adaptedSet.rawSet().addAll(toSetOfTrivialName(collection));
		}
		
		return (ANY) adaptedSet;

	}

	private Set toSetOfTrivialName(Collection collection) {
		Set set = new LinkedHashSet();
		for (Object element : collection) {
			set.add(new TrivialName(element.toString()));
		}
		return set;
	}

}
