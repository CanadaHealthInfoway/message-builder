package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.BareRatio;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

public abstract class AbstractRtoPropertyFormatter<T, U> extends AbstractNullFlavorPropertyFormatter<BareRatio> {

	@SuppressWarnings("unchecked")
	@Override
    String formatNonNullValue(FormatContext context, BareRatio value, int indentLevel) throws ModelToXmlTransformationException {
        
        StringBuffer buffer = new StringBuffer();
        buffer.append(createElement(context.getElementName(), null, indentLevel, false, true));
        
        buffer.append(createElement("numerator", getNumeratorAttributeMap((T) value.getBareNumerator()), indentLevel + 1, true, true));
        buffer.append(createElement("denominator", getDenominatorAttributeMap((U) value.getBareDenominator()), indentLevel + 1, true, true));
        
        buffer.append(XmlRenderingUtils.createEndElement(context.getElementName(), indentLevel, true));
        return buffer.toString();
    }

    protected abstract Map<String, String> getNumeratorAttributeMap(T value);
    protected abstract Map<String, String> getDenominatorAttributeMap(U value);
}
