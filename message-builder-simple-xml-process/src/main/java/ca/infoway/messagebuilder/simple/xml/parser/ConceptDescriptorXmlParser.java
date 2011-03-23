package ca.infoway.messagebuilder.simple.xml.parser;

import static java.lang.String.format;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class ConceptDescriptorXmlParser extends AbstractSimpleXmlParser<CD, Code> implements SimpleXmlParser<CD> {
	
	ConceptDescriptorXmlParser() {
	}

	@Override
	protected Map<String, String> toNameValuePairs(CD cd) {
		Code code = cd.getValue();
		
		Map<String, String> attributes = new LinkedHashMap<String, String>();

		if (code.getCodeValue()!=null) {
			attributes.put("code", code.getCodeValue());	
		}
		
		if (code.getCodeSystem()!=null) {
			attributes.put("codeSystem", code.getCodeSystem());	
		}
		
		if (!StringUtils.isEmpty(cd.getOriginalText())) {
			attributes.put("originalText", cd.getOriginalText());	
		}
		
		if (!StringUtils.isEmpty(cd.getDisplayName())) {
			attributes.put("displayName", cd.getDisplayName());
		}
		
        return attributes;
	}

	@Override
	protected boolean closeStartElement(CD dataTypeInstance) {
		return dataTypeInstance.getTranslations().isEmpty();
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, CD dataTypeValue) throws ParserException {
		renderTranslationsIfPossible(builder, dataTypeValue.getTranslations());
	}
	
	private void renderTranslationsIfPossible(StringBuilder builder, List<CD> translations) {
		if (!translations.isEmpty()) {
			for (CD translation : translations) {
				if (translation.getValue()!=null) {
					Code code = translation.getValue();
					builder.append(format("<translation code=\"%s\" codeSystem=\"%s\">", code.getCodeValue(), code.getCodeSystem()));
					String originalText = translation.getOriginalText();
					if (!StringUtils.isEmpty(originalText)) {
						builder.append(format("<originalText>%s</originalText>", originalText));
					}
					builder.append("</translation>");
				}
			} 
		}
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Code value) throws ParserException {
	}

}
