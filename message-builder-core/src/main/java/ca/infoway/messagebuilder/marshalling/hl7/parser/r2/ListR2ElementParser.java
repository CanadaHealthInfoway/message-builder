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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.util.ArrayList;
import java.util.Collection;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.SetOrListElementParser;

@DataTypeHandler({"LIST", "BAG"})
class ListR2ElementParser extends SetOrListElementParser {

	public ListR2ElementParser(ParserR2Registry parserRegistry) {
		super(parserRegistry, true);
	}

	@Override
	protected BareANY wrapWithHl7DataType(String type, String subType, Collection<BareANY> collection) {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		CollectionHelper result = new LISTImpl(ANYImpl.class);
		for (BareANY bareANY : collection) {
			result.add(bareANY);
		}
		return (BareANY) result;
	}

	@Override
	protected Collection<BareANY> getCollectionType(ParseContext context) {
		return new ArrayList<BareANY>();
	}

}