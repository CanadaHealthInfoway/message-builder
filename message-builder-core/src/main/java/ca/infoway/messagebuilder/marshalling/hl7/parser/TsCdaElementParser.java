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
 * Last modified: $LastChangedDate: 2014-01-09 11:56:23 -0500 (Thu, 09 Jan 2014) $
 * Revision:      $LastChangedRevision: 8280 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.util.Date;
import java.util.List;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.TSCDAR1;
import ca.infoway.messagebuilder.datatype.impl.TSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * TS (R2) - Timestamp
 *
 * Represents a TS object as an element:
 *
 * &lt;element-name value="yyyyMMddHHmmss"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TS
 */
@DataTypeHandler({"TSCDAR1", "SXCMTSCDAR1"})
public class TsCdaElementParser implements ElementParser {

	private final TsElementParser tsParser = new TsElementParser();
	
	public BareANY parse(ParseContext context, List<Node> nodes, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		BareANY tsResult = this.tsParser.parse(convertContext(context), nodes, xmlToModelResult);
		return convertDataType(tsResult);
	}
	
	private BareANY convertDataType(BareANY dataType) {
		Object bareValue = dataType.getBareValue();
		Date date = (bareValue instanceof Date ? (Date) bareValue : null);
		MbDate mbDate = (date == null ? null : new MbDate(date));
		
		TSCDAR1 result = new TSCDAR1Impl();
		result.setDataType(dataType.getDataType());
		result.setNullFlavor(dataType.getNullFlavor());
		result.setBareValue(mbDate);
		result.setOperator(((ANYMetaData) dataType).getOperator());
		return result;
	}

	private ParseContext convertContext(ParseContext parseContext) {
		return ParseContextImpl.create("TS", parseContext);
	}

}
