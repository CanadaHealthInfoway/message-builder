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
 * Last modified: $LastChangedDate: 2014-03-17 14:28:03 -0400 (Mon, 17 Mar 2014) $
 * Revision:      $LastChangedRevision: 8461 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.text.MessageFormat;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.BareCollection;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.PolymorphismHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IiCollectionConstraintHandler;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IiCollectionConstraintHandler.ConstraintResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.ModelToXmlTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.PropertyFormatter;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

public abstract class BaseCollectionR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<Collection<BareANY>> {

	// only checking II constraints for now
	private IiCollectionConstraintHandler constraintHandler = new IiCollectionConstraintHandler();
	
	private PolymorphismHandler polymorphismHandler = new PolymorphismHandler();
	
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
				context.getDateTimeZone(), 
				context.getDateTimeTimeZone(), 
				null,
				null); // constraints are not passed down from collection attributes
	}
	
	@Override
	public String format(FormatContext context, BareANY hl7Value, int indentLevel) {
    	handleConstraints(getSubType(context), context.getConstraints(), convertToCollection(hl7Value), context);
		return super.format(context, hl7Value, indentLevel);
	}

	@SuppressWarnings("unchecked")
	private Collection<BareANY> convertToCollection(BareANY hl7Value) {
		Object bareValue = hl7Value.getBareValue();
		if (bareValue instanceof Collection<?>) {
			return (Collection<BareANY>) bareValue;
		}
		return null;
	}
	
	@Override
	protected Collection<BareANY> extractBareValue(BareANY hl7Value) {
		BareCollection collection = (BareCollection) hl7Value;
		return collection.getBareCollectionValue();
	}

	protected String formatAllElements(FormatContext originalContext, FormatContext subContext, Collection<BareANY> collection, int indentLevel) {
    	StringBuilder builder = new StringBuilder();

    	validateCardinality(originalContext, collection);
    	
    	PropertyFormatter formatter = FormatterR2Registry.getInstance().get(subContext.getType());
    	if (collection.isEmpty()) {
    		builder.append(formatter.format(subContext, null, indentLevel));
    	} else {
	        for (BareANY hl7Value : EmptyIterable.<BareANY>nullSafeIterable(collection)) {
	    		String type = determineActualType(subContext.getType(), hl7Value, originalContext.getModelToXmlResult(), originalContext.getPropertyPath());
	    		
	    		if (!StringUtils.equals(type, subContext.getType())) {
	    			subContext = new FormatContextImpl(type, true, subContext);
	    			formatter = FormatterR2Registry.getInstance().get(type);
	    		}
	        	
				builder.append(formatter.format(subContext, hl7Value, indentLevel));
	        }
    	}
        return builder.toString();
	}

	private String determineActualType(String type, BareANY hl7Value, Hl7Errors errors, String propertyPath) {
		String rootType = StandardDataType.getByTypeName(type).getRootType();
		String alternateType = (hl7Value == null || hl7Value.getDataType() == null ? type : hl7Value.getDataType().getType());
		String alternateTypeRootType = StandardDataType.getByTypeName(alternateType).getRootType();
		
		if (!"ANY".equals(type) && !StandardDataType.isSetOrList(alternateType)) {
			// any better way to detect a type change? no guarantee that the standard/unchanged type in hl7Value will directly match the model type 
			if (!StringUtils.equals(rootType, alternateTypeRootType)) {
				if (this.polymorphismHandler.isValidTypeChange(type, alternateType)) {
					type = alternateType;
				} else {
					String message = MessageFormat.format("Not able to handle type change from {0} to {1}. Type has been left unchanged.", type, alternateType);
					errors.addHl7Error(new Hl7Error(Hl7ErrorCode.UNSUPPORTED_TYPE_CHANGE, message, propertyPath));
				}
			}
		}
		return type;
	}

	private void handleConstraints(String type, ConstrainedDatatype constraints, Collection<BareANY> collection, FormatContext context) {
		ConstraintResult constraintResult = this.constraintHandler.checkConstraints(type, constraints, collection);
		if (constraintResult != null && !constraintResult.isFoundMatch()) {
			// there should be a match, but if not we need to create an II with the appropriate values and add to collection
			Identifier identifier = constraintResult.getIdentifer();
			collection.add(new IIImpl(identifier));
			context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_PROVIDED, Hl7ErrorLevel.INFO, "A fixed constraint was added for compliance: " + identifier, context.getPropertyPath()));
		}
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
