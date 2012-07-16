/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.BareCollection;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;

public abstract class BaseCollectionPropertyFormatter extends AbstractNullFlavorPropertyFormatter<Collection<BareANY>> {

	protected FormatContext createSubContext(FormatContext context)
			throws ModelToXmlTransformationException {
		return new FormatContextImpl(
				context.getModelToXmlResult(),
				context.getPropertyPath(),
				context.getElementName(), 
				getSubType(context),
				context.getConformanceLevel(),
				context.isSpecializationType(), 
				context.getVersion(),
				context.getDateTimeZone(), context.getDateTimeTimeZone());
	}
	
	@Override
	protected Collection<BareANY> extractBareValue(BareANY hl7Value) {
		BareCollection collection = (BareCollection) hl7Value;
		return collection.getBareCollectionValue();
	}

	protected String formatAllElements(FormatContext subContext,
			Collection<BareANY> collection, int indentLevel)
			throws ModelToXmlTransformationException {
    	StringBuilder builder = new StringBuilder();

    	PropertyFormatter formatter = FormatterRegistry.getInstance().get(subContext.getType());
    	if (collection.isEmpty()) {
    		builder.append(formatter.format(subContext, null, indentLevel));
    	} else {
	        for (BareANY element : EmptyIterable.<BareANY>nullSafeIterable(collection)) {
	        	// FIXME - SPECIALIZATION_TYPE - compare "element" type with subcontext datatype - if different, need to re-build a subcontext
				builder.append(formatter.format(subContext, (BareANY) element, indentLevel));
	        }
    	}
        return builder.toString();
	}

    /** 
     * <p>We expect the type to look something like this:
     * 
     * <pre>
     * SET&lt;II&gt;
     * </pre>
     * 
     * <p>and we want to return "II"
     *
     * @param context
     * @return
     * @throws ModelToXmlTransformationException 
     */
	private String getSubType(FormatContext context) throws ModelToXmlTransformationException {
		String subType = Hl7DataTypeName.getParameterizedType(context.getType());
		if (StringUtils.isNotBlank(subType)) {
			return subType;
		} else {
			throw new ModelToXmlTransformationException("Cannot find the sub type for " + context.getType());
		}
	}
}
