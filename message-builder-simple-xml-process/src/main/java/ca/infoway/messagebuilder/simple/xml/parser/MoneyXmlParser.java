package ca.infoway.messagebuilder.simple.xml.parser;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class MoneyXmlParser extends AbstractSimpleXmlParser<MO, Money> implements SimpleXmlParser<MO> {
	
	MoneyXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Money value) {
    }

	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, Money money) {
		Map<String, String> result = new LinkedHashMap<String, String>();
        if (money != null) {
            BigDecimal value = money.getAmount();
            if (value != null) {
                result.put("value", value.toString());
            }

            Currency currency = money.getCurrency();
            if (currency != null) {
                result.put("currency", currency.getCodeValue());
            }
        }
        return result;
	}

	@Override
	protected boolean closeStartElement(MO dataTypeInstance) {
		return true;
	}

}
