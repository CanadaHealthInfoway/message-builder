package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * MO - Money
 *
 * Represents an MO object as an element:
 *
 * &lt;amt value="10" currency="CAD"/&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-MO
 */
@DataTypeHandler("MO")
class MoPropertyFormatter extends AbstractAttributePropertyFormatter<Money> {
	
    @Override
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Money money) throws ModelToXmlTransformationException {
        Map<String, String> result = new HashMap<String, String>();
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
}
