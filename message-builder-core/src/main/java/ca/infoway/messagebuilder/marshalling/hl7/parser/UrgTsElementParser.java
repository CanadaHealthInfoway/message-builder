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
 * Last modified: $LastChangedDate: 2012-08-30 17:31:02 -0400 (Thu, 30 Aug 2012) $
 * Revision:      $LastChangedRevision: 6041 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler("URG<TS>")
class UrgTsElementParser extends UrgElementParser<TS, Date> {

	@Override
	protected ElementParser getIvlParser() {
		return new IvlTsElementParser(true);
	}
}
