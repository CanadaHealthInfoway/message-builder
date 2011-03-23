package ca.infoway.messagebuilder.simple.xml.parser;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class TrivialNameXmlParser extends AbstractSimpleXmlParser<TN, TrivialName> implements SimpleXmlParser<TN> {
	
	TrivialNameXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, TrivialName value) {
		builder.append(renderTrivialName(value));
	}

	private String renderTrivialName(TrivialName value) {
		return XmlStringEscape.escape(value.getName());
	}

	@Override
	protected boolean closeStartElement(TN dataTypeInstance) {
		return false;
	}

}
