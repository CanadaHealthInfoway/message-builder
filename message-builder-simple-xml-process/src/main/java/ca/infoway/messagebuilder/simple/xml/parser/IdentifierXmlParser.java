package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class IdentifierXmlParser extends AbstractSimpleXmlParser<II, Identifier> implements SimpleXmlParser<II> {
	
	IdentifierXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Identifier value) {
    }
	
	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, Identifier ii) {
		Map<String, String> attributes = new LinkedHashMap<String, String>();
        attributes.put("root", ii.getRoot() == null ? StringUtils.EMPTY : ii.getRoot());
        
        if (StringUtils.isNotBlank(ii.getExtension())) {
            attributes.put("extension", ii.getExtension());
        }
        
        if (StandardDataType.II_BUS.equals(dataType)) {
            attributes.put("use", "BUS");
        } else if (StandardDataType.II_PUBLIC.equals(dataType)) {
            attributes.put("displayable", "true");
        } 
        return attributes;
	}

	@Override
	protected boolean closeStartElement(II dataTypeInstance) {
		return true;
	}
	
}
