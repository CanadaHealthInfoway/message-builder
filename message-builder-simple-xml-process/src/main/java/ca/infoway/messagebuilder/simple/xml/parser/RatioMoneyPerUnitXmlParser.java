package ca.infoway.messagebuilder.simple.xml.parser;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class RatioMoneyPerUnitXmlParser 
	extends AbstractSimpleXmlParser<RTO<Money, PhysicalQuantity>, Ratio<Money, PhysicalQuantity>> 
	implements SimpleXmlParser<RTO<Money, PhysicalQuantity>> {
	
	private final PhysicalQuantityXmlParser physicalQuantityXmlParser = new PhysicalQuantityXmlParser();
	private final MoneyXmlParser moneyXmlParser = new MoneyXmlParser();

	RatioMoneyPerUnitXmlParser() {
	}
	
	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Ratio<Money, PhysicalQuantity> value) throws ParserException {
		renderMoneyIfPossible(builder, "money", value.getNumerator());
		renderPqIfPossible(builder, "unit", value.getDenominator());
    }

	private void renderMoneyIfPossible(StringBuilder builder, String elementName, Money money) throws ParserException {
		if (money!=null) {
			builder.append(this.moneyXmlParser.parse(new SimpleXmlParseContextImpl(elementName), new MOImpl(money)));
		}
	}

	private void renderPqIfPossible(StringBuilder builder, String elementName, PhysicalQuantity physicalQuantity) throws ParserException {
		if (physicalQuantity!=null) {
			builder.append(this.physicalQuantityXmlParser.parse(new SimpleXmlParseContextImpl(elementName), new PQImpl(physicalQuantity)));
		}
	}

	@Override
	protected boolean closeStartElement(RTO<Money, PhysicalQuantity> dataTypeInstance) {
		return false;
	}

}
