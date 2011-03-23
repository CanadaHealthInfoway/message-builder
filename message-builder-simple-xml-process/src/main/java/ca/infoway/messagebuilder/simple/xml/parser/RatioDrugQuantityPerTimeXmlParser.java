package ca.infoway.messagebuilder.simple.xml.parser;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class RatioDrugQuantityPerTimeXmlParser 
	extends AbstractSimpleXmlParser<RTO<PhysicalQuantity, PhysicalQuantity>, Ratio<PhysicalQuantity, PhysicalQuantity>> 
	implements SimpleXmlParser<RTO<PhysicalQuantity, PhysicalQuantity>> {
	
	private final PhysicalQuantityXmlParser physicalQuantityXmlParser = new PhysicalQuantityXmlParser();

	RatioDrugQuantityPerTimeXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Ratio<PhysicalQuantity, PhysicalQuantity> value) throws ParserException {
		renderPqIfPossible(builder, "drugQuantity", value.getNumerator());
		renderPqIfPossible(builder, "time", value.getDenominator());
    }

	private void renderPqIfPossible(StringBuilder builder, String elementName, PhysicalQuantity physicalQuantity) throws ParserException {
		if (physicalQuantity!=null) {
			builder.append(this.physicalQuantityXmlParser.parse(new SimpleXmlParseContextImpl(elementName), new PQImpl(physicalQuantity)));
		}
	}

	@Override
	protected boolean closeStartElement(RTO<PhysicalQuantity, PhysicalQuantity> dataTypeInstance) {
		return false;
	}

}
