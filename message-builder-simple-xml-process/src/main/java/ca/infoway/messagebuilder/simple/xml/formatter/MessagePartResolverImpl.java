/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
			MessagePartBean part = (MessagePartBean) Instantiator.getInstance().instantiateMessagePartBean(versionNumber, partType, new Interaction());
			return new MessagePartWrapper(part);
		}
	}
}
