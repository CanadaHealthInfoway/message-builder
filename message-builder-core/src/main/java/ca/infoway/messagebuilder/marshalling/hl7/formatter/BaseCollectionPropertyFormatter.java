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
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;

public abstract class BaseCollectionPropertyFormatter extends AbstractNullFlavorPropertyFormatter<Collection<BareANY>> {

	protected FormatContext createSubContext(FormatContext context) {
		return new FormatContextImpl(
				context.getModelToXmlResult(),
				context.getPropertyPath(),
				context.getElementName(), 
				getSubType(context),
				context.getDomainType(),
				context.getConformanceLevel(),
				context.getCardinality(), 
				context.isSpecializationType(),
				context.getVersion(), 
				context.getDateTimeZone(), context.getDateTimeTimeZone(), null);
	}
	
	@Override
	protected Collection<BareANY> extractBareValue(BareANY hl7Value) {
		BareCollection collection = (BareCollection) hl7Value;
		return collection.getBareCollectionValue();
	}

	protected String formatAllElements(FormatContext subContext, Collection<BareANY> collection, int indentLevel) {
    	StringBuilder builder = new StringBuilder();

    	validateCardinality(subContext, collection);
    	
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

	private void validateCardinality(FormatContext context, Collection<BareANY> collection) {
		int size = collection.size();
		int min = (int) context.getCardinality().getMin();
		int max = (int) context.getCardinality().getMax();
		if (size < min) {
			context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
					"Number of elements (" + size + ") is less than the specified minimum (" + min + ")", context.getPropertyPath()));
		}
		if (size > max) {
			context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
					"Number of elements (" + size + ") is more than the specified maximum (" + max + ")", context.getPropertyPath()));
		}
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
	private String getSubType(FormatContext context) {
		String subType = Hl7DataTypeName.getParameterizedType(context.getType());
		if (StringUtils.isNotBlank(subType)) {
			return subType;
		} else {
			throw new ModelToXmlTransformationException("Cannot find the sub type for " + context.getType());
		}
	}
}
