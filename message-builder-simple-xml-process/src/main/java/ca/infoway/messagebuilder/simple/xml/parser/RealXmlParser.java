package ca.infoway.messagebuilder.simple.xml.parser;

import static ca.infoway.messagebuilder.datatype.StandardDataType.REAL_CONF;
import static ca.infoway.messagebuilder.datatype.StandardDataType.REAL_COORD;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class RealXmlParser extends AbstractSimpleXmlParser<REAL, BigDecimal> implements SimpleXmlParser<REAL> {
	
	RealXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, BigDecimal value) {
		builder.append(renderReal(dataType, value));
	}

	private String renderReal(StandardDataType dataType, BigDecimal value) {
		String renderedReal;
		
		if (REAL_CONF.equals(dataType) || 
				REAL_COORD.equals(dataType)) {
			renderedReal = value.setScale(4, BigDecimal.ROUND_HALF_UP).toString();
		} else {
			renderedReal = value.toString();
		}
		
		return renderedReal;
	}

	@Override
	protected boolean closeStartElement(REAL dataTypeInstance) {
		return false;
	}

}
