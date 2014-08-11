/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-05-24 17:39:39 -0400 (Fri, 24 May 2013) $
 * Revision:      $LastChangedRevision: 6901 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.GenericDataTypeFactory;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;

@DataTypeHandler({"SET"})
class SetR2ElementParser extends SetOrListR2ElementParser {

	@Override
	protected BareANY wrapWithHl7DataType(String type, String subType, Collection<BareANY> collection) {
		try {
			CollectionHelper result = (CollectionHelper) GenericDataTypeFactory.create(type);
			for (BareANY bareANY : collection) {
				result.add(bareANY);
			}
			return (BareANY) result;
		} catch (MarshallingException e) {
			return null;
		}
	}

	protected void resultAlreadyExistsInCollection(BareANY result, Element node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(new Hl7Error(
				Hl7ErrorCode.DATA_TYPE_ERROR, "Duplicate value not allowed for SET", (Element) node));
	}
	
	@Override
	protected Collection<BareANY> getCollectionType(ParseContext context) {
		return new LinkedHashSet<BareANY>();
	}
	
}