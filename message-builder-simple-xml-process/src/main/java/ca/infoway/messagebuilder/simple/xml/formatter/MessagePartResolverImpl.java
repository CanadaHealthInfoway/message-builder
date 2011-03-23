package ca.infoway.messagebuilder.simple.xml.formatter;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.Instantiator;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.xml.Interaction;

public class MessagePartResolverImpl implements MessagePartResolver {

	public MessagePartWrapper resolve(VersionNumber versionNumber, String partType, Object fieldValue) {
		if (StringUtils.countMatches(partType, ".") > 1) {
			partType = StringUtils.substringAfter(partType, ".");
		}
		if (fieldValue != null && MessagePartBean.class.isAssignableFrom(fieldValue.getClass())) {
			return new MessagePartWrapper((MessagePartBean) fieldValue);
		} else {
			MessagePartBean part = (MessagePartBean) Instantiator.getInstance().instantiateMessagePartBean(versionNumber.getVersionLiteral(), partType, new Interaction());
			return new MessagePartWrapper(part);
		}
	}
}
