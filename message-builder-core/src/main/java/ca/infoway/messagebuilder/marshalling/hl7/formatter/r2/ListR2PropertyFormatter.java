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

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.util.Collection;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.BaseCollectionPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

@DataTypeHandler({"LIST"})
class ListR2PropertyFormatter extends BaseCollectionPropertyFormatter {

    public ListR2PropertyFormatter(FormatterR2Registry formatterR2Registry) {
		super(formatterR2Registry, true);
	}

	@Override
	protected
    String formatNonNullValue(FormatContext context, Collection<BareANY> list, int indentLevel) {
    	return formatAllElements(context, createSubContext(context), list, indentLevel);
    }

}
