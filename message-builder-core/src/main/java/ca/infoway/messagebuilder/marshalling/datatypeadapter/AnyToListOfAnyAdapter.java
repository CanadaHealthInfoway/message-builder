package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import java.util.List;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;

@SuppressWarnings("unchecked")
public class AnyToListOfAnyAdapter implements DataTypeAdapter {

	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType) {
		return !StandardDataType.isSetOrList(fromDataTypeName)
		    && LIST.class.isAssignableFrom(toDateType);
	}

	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		return false;
	}

	public BareANY adapt(BareANY any) {
		LISTImpl set = new LISTImpl(any.getClass());
		((List) set.getValue()).add(any);
		return (BareANY) set;
	}

}
