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
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.BareCollection;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Registry;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IiCollectionConstraintHandler;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IiCollectionConstraintHandler.ConstraintResult;
import ca.infoway.messagebuilder.marshalling.polymorphism.PolymorphismHandler;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

public abstract class BaseCollectionPropertyFormatter extends AbstractNullFlavorPropertyFormatter<Collection<BareANY>> {

	private final Registry<PropertyFormatter> formatterRegistry;

	private final boolean isR2;

	public BaseCollectionPropertyFormatter(Registry<PropertyFormatter> formatterRegistry, boolean isR2) {
		this.formatterRegistry = formatterRegistry;
		this.isR2 = isR2;
	}
	
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
				null, // constraints are not passed down from collection attributes
				context.isCda());
	}
	
	@Override
	public String format(FormatContext context, BareANY hl7Value, int indentLevel) {
		if (hl7Value == null) {
			return "";
		}
		handleConstraints(getSubType(context), context.getConstraints(), convertToCollection(hl7Value), context);
		return super.format(context, hl7Value, indentLevel);
	}

	@SuppressWarnings("unchecked")
	private Collection<BareANY> convertToCollection(BareANY hl7Value) {
		Object bareValue = (hl7Value == null ? null : hl7Value.getBareValue());
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
    	
    	PropertyFormatter formatter = this.formatterRegistry.get(subContext.getType());
    	if (collection.isEmpty()) {
    		builder.append(formatter.format(subContext, null, indentLevel));
    	} else {
	        for (BareANY hl7Value : EmptyIterable.<BareANY>nullSafeIterable(collection)) {
	    		String type = determineActualType(subContext.getType(), hl7Value, originalContext.getModelToXmlResult(), originalContext.getPropertyPath(), originalContext.isCda());
	    		
	    		if (!StringUtils.equals(type, subContext.getType())) {
	    			subContext = new FormatContextImpl(type, true, subContext);
	    			formatter = this.formatterRegistry.get(type);
	    		}
	        	
				builder.append(formatter.format(subContext, hl7Value, indentLevel));
	        }
    	}
        return builder.toString();
	}

	private String determineActualType(String type, BareANY hl7Value, Hl7Errors errors, String propertyPath, boolean isCda) {
		StandardDataType newTypeEnum = (hl7Value == null ? null : hl7Value.getDataType());
		return this.polymorphismHandler.determineActualDataType(type, newTypeEnum, isCda, !this.isR2, createErrorLogger(propertyPath, errors));
	}

	private ErrorLogger createErrorLogger(final String propertyPath, final Hl7Errors errors) {
		return new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};
	}

	private void handleConstraints(String type, ConstrainedDatatype constraints, Collection<BareANY> collection, FormatContext context) {
		ConstraintResult constraintResult = this.constraintHandler.checkConstraints(type, constraints, collection);
		if (constraintResult != null && !constraintResult.isFoundMatch()) {
			// there should be a match, but if not we need to create an II with the appropriate values and add to collection
			Identifier identifier = constraintResult.getIdentifer();
			collection.add(new IIImpl(identifier));
			context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_PROVIDED, ErrorLevel.INFO, "A fixed constraint was added for compliance: " + identifier, context.getPropertyPath()));
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
