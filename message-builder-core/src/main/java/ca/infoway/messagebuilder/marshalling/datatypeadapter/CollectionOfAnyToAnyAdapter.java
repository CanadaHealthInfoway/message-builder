package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import java.util.Collection;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.COLLECTION;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;

@SuppressWarnings("unchecked")
public class CollectionOfAnyToAnyAdapter implements DataTypeAdapter {

	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		if (COLLECTION.class.isAssignableFrom(fromDataType) 
		  && !StandardDataType.isSetOrList(toDataTypeName)) {
			return true;
		}
		return false;
	}
	
	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType) {
		return false;
	}
	
	public BareANY adapt(BareANY any) {
		Collection collection = ((COLLECTION<Collection>) any).getValue();
		
		BareANY element = null;
		if (collection!=null && !collection.isEmpty()) {
			element = (BareANY) collection.iterator().next();
		} else {
			element = new ANYImpl();
		}
		
		return (BareANY) element; 
	}


}
