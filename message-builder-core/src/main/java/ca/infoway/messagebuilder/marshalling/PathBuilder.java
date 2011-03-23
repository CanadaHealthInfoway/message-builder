package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

class PathBuilder {

	private final Log log = LogFactory.getLog(PathBuilder.class);

	private final MessageDefinitionService service;
	private final String version;

	PathBuilder(MessageDefinitionService service, String version) {
		this.service = service;
		this.version = version;
	}
	
	List<TypeName> findPathTo(TypeName start, TypeName end) {
		validateHasType(end, "end");
		validateHasType(start, "start");
		List<TypeName> results = new ArrayList<TypeName>();
		if (ObjectUtils.equals(start, end) || findPathTo(start, end, results)) {
			// expected
		} else {
			this.log.error("PathBuilder: Could not find a type path from start to end (" + start + ", " + end + "). Using end type only.");
		}
		results.add(end);
		return results;
	}

	private void validateHasType(TypeName typeName, String position) {
		if (typeName == null || typeName.getName() == null) {
			throw new IllegalStateException("Cannot determine a type path when type is null (for " + position + ")");
		}
	}

	private boolean findPathTo(TypeName start, TypeName end, List<TypeName> results) {
		List<String> childs = getMessagePart(start).getSpecializationChilds();
		for (String childName : childs) {
			TypeName childTypeName = new TypeName(childName); 
			if (ObjectUtils.equals(childTypeName, end)) {
				results.add(start);
				return true;
			} else {
				if (findPathTo(childTypeName, end, results)) {
					results.add(0, start);
					return true;
				}
			}
		}
		return false;
	}

	private MessagePart getMessagePart(TypeName typeName) {
		return this.service.getMessagePart(this.version, typeName.getName());
	}
	
}
