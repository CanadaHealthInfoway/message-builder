package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.platform.ListElementUtil;

class EmptinessUtil {

	static boolean isEmpty(Object value) {
		if (value == null) {
			return true;
		} else if (ListElementUtil.isCollection(value)) {
			return 0 == ListElementUtil.count(value);
		} else {
			return false;
		}
	}
}
