package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;

public class IvlToTsAdapter implements DataTypeAdapter {

	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType) {
		if ((StandardDataType.IVL_FULL_DATE.getType().equals(fromDataTypeName)
		 || StandardDataType.IVL_FULL_DATE_WITH_TIME.getType().equals(fromDataTypeName))
		 && TS.class.isAssignableFrom(toDateType)) {
			return true;
		}
		return false;

	}
	
	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		return false;
	}

	@SuppressWarnings("unchecked")
	public BareANY adapt(BareANY any) {
		IVL<TS,Interval<Date>> ivl = (IVL<TS,Interval<Date>>) any;
		return (BareANY) new DataTypeAdapterHelper().copyAndReturnAdapted(
				any, 
				(BareANY) new TSImpl(), 
				((Interval<Date>) ivl.getValue()).getLow());
	}
}
