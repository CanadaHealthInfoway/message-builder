package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang.Validate;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;
import ca.infoway.messagebuilder.simple.xml.formatter.AbstractSimpleXmlFormatter;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

public abstract class AbstractSimpleXmlParser<T extends ANY<V>, V> implements SimpleXmlParser<T>{

	private static final String NULL_FLAVOR_SUFFIX = "NullFlavor";
	
	protected AbstractSimpleXmlParser() {
	}

	private void validateContext(SimpleXmlParseContext context) {
		Validate.notNull(context, "The SimpleXmlParseContext cannot be null");
	}

	public String parse(SimpleXmlParseContext context, T dataTypeInstance) throws ParserException {
		validateContext(context);
		
		StringBuilder builder = new StringBuilder();
		if (dataTypeInstance!=null) {
			renderNullFlavorIfNecessary(builder, context, dataTypeInstance);
			renderValue(builder, context, dataTypeInstance);
		}
		
		return builder.toString(); 
	}

	protected abstract boolean closeStartElement(T dataTypeInstance);
	protected abstract void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, V value) throws ParserException;

	protected void renderValue(StringBuilder builder, SimpleXmlParseContext context, T dataTypeInstance) throws ParserException {
		if (dataTypeInstance.getValue()!=null) {
			builder.append(XmlRenderingUtils.createStartElement(
					context.getElementName(), 
					toNameValuePairs(dataTypeInstance), 
					0, closeStartElement(dataTypeInstance), false));
			
			if (!closeStartElement(dataTypeInstance)) {
				doRenderNonNullValue(builder, context, dataTypeInstance);
				builder.append(XmlRenderingUtils.createEndElement(context.getElementName(), 0, false));
			}
		}
	}

	protected Map<String, String> toNameValuePairs(T dataTypeValue) {
		return toNameValuePairs(dataTypeValue.getDataType(), dataTypeValue.getValue());
	}

	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, T dataTypeInstance) throws ParserException {
		doRenderNonNullValue(builder, context, dataTypeInstance.getDataType(), dataTypeInstance.getValue());
	}

	protected Map<String, String> toNameValuePairs(StandardDataType dataType, V value) {
		return Collections.emptyMap();
	}


	protected void renderNullFlavorIfNecessary(StringBuilder builder, SimpleXmlParseContext context, ANY<?> dataType) {
		if (dataType.hasNullFlavor()) {
			renderNullFlavor(builder, context, dataType.getNullFlavor());
		}
	}

	private void renderNullFlavor(StringBuilder builder, SimpleXmlParseContext context, NullFlavor nullFlavor) {
		builder.append(XmlRenderingUtils.createStartElement(getNullFlavorElementName(context), AbstractSimpleXmlFormatter.NAMESPACE, 0, false, false));
		builder.append(nullFlavor.getCodeValue());
		builder.append(XmlRenderingUtils.createEndElement(getNullFlavorElementName(context), 0, false));
	}

	private String getNullFlavorElementName(SimpleXmlParseContext context) {
		return context.getElementName()+NULL_FLAVOR_SUFFIX;
	}
	
	
	
}
