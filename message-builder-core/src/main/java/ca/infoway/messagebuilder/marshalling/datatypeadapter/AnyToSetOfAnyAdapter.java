package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import java.util.Set;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;

@SuppressWarnings("unchecked")
public class AnyToSetOfAnyAdapter implements DataTypeAdapter {

	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType) {
		return !StandardDataType.isSetOrList(fromDataTypeName)
		    && SET.class.isAssignableFrom(toDateType);
	}

	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		return false;
	}

	public BareANY adapt(BareANY any) {
		SETImpl set = new SETImpl(any.getClass());
		((Set) set.getValue()).add(any);
		return (BareANY) set;
	}

}
