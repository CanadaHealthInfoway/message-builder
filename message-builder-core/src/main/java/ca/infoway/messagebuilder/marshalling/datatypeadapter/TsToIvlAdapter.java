package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;

public class TsToIvlAdapter implements DataTypeAdapter {
	
	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		if (TS.class.isAssignableFrom(fromDataType) 
		 && (StandardDataType.IVL_FULL_DATE.getType().equals(toDataTypeName)
		 || StandardDataType.IVL_FULL_DATE_WITH_TIME.getType().equals(toDataTypeName))) {
			return true;
		}
		return false;
	}

	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType) {
		return false;
	}
	
	public BareANY adapt(BareANY any) {
		return new DataTypeAdapterHelper().copyAndReturnAdapted(
				any, 
				(BareANY) new IVLImpl<TS,Interval<Date>>(), 
				any.getBareValue() !=null ? IntervalFactory.<Date>createLow((Date) any.getBareValue()) : null);
	}

}
