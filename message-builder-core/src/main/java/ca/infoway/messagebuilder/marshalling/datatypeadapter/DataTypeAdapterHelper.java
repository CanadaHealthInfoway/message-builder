package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

class DataTypeAdapterHelper {

	BareANY copyAndReturnAdapted(BareANY any, BareANY adaptedAny, Object newValue) {
		if (any.hasNullFlavor()) {
			NullFlavor nullFlavor = any.getNullFlavor();
			adaptedAny.setNullFlavor(nullFlavor);	
		} else {
			((BareANYImpl) adaptedAny).setBareValue(newValue);
		}
		
		return adaptedAny;
	}

}
