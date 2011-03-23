package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import ca.infoway.messagebuilder.datatype.BareANY;

public interface DataTypeAdapter {
	
	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName);
	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType);
	public BareANY adapt(BareANY any);


}
