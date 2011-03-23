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
				context.getElementName(), 
				getSubType(context), 
				context.getConformanceLevel(),
				context.isSpecializationType(),
				context.getVersion());
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
