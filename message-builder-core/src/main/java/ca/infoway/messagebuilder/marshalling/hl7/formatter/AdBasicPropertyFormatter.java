package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;

/**
 * AD.BASIC - Address (Basic)
 *
 * Represents an Address object as an element:
 *
 * &lt;element-name use="PHYS"&gt;	&lt;!-- "PHYS" is visit, "PST" is postal, "TMP" is temporary, "H" is home, "WP" is workplace. --&gt;
 * 1709 Bloor St W.&lt;delimiter/&gt;
 * Suite 200&lt;delimiter/&gt;
 *   &lt;city&gt;Toronto&lt;/city&gt;
 *   &lt;state code="ON&gt;Ontario&lt;/state&gt;
 *   &lt;postalCode&gt;A1A 1A1&lt;/postalCode&gt;&lt;delimiter/&gt;
 *   &lt;country code="CA"&gt;Canada&lt;/country&gt;
 * &lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-AD
 *
 * CeRx limits the length of each part to 60 characters. This limit is not enforced by
 * this class.
 *
 * It is also quite apparent that the use of the delimiters in the address indicates a
 * certain level of dementia.
 */
@DataTypeHandler("AD.BASIC")
class AdBasicPropertyFormatter extends AbstractAdPropertyFormatter {

    private final static List<String> ALLOWABLE_ADDRESS_USES = new ArrayList<String>();

    static {
        ALLOWABLE_ADDRESS_USES.add("H");
        ALLOWABLE_ADDRESS_USES.add("PHYS");
        ALLOWABLE_ADDRESS_USES.add("PST");
        ALLOWABLE_ADDRESS_USES.add("TMP");
        ALLOWABLE_ADDRESS_USES.add("WP");
    }

    @Override
    final String formatNonNullValue(FormatContext context, PostalAddress postalAddress, int indentLevel) {
    	PostalAddress basicAddress = new PostalAddress();
    	
    	StringBuilder builder = new StringBuilder();
    	PostalAddressPartType lastPartType = null;
    	
    	for (PostalAddressPart part : EmptyIterable.nullSafeIterable(postalAddress.getParts())) {
   			if (part.getType() == PostalAddressPartType.CITY
					|| part.getType() == PostalAddressPartType.STATE
					|| part.getType() == PostalAddressPartType.COUNTRY
					|| part.getType() == PostalAddressPartType.POSTAL_CODE) {
				flush(builder, basicAddress);
				basicAddress.addPostalAddressPart(part);
			} else if (part.getType() == PostalAddressPartType.DELIMITER && StringUtils.isBlank(part.getValue())) {
				flush(builder, basicAddress);
				basicAddress.addPostalAddressPart(part);
			} else if (StringUtils.isNotBlank(part.getValue())) {
				if (builder.length() > 0 
						&& part.getType() == PostalAddressPartType.STREET_ADDRESS_LINE 
						&& lastPartType == PostalAddressPartType.STREET_ADDRESS_LINE) {
					flush(builder, basicAddress);
					basicAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.DELIMITER, (String) null));
				} else if (builder.length() > 0) {
					builder.append(" ");
				}
				builder.append(part.getValue());
			}
   			lastPartType = part.getType();
		}
    	flush(builder, basicAddress);
    	
    	for (PostalAddressUse use : postalAddress.getUses()) {
    		if (isAllowableUse(use)) {
    			basicAddress.addUse(use);
    		}
		}
    	
    	return super.formatNonNullValue(context, basicAddress, indentLevel);
    }

	private boolean isAllowableUse(PostalAddressUse use) {
		return use != null && use.getCodeValue() != null 
				&& ALLOWABLE_ADDRESS_USES.contains(use.getCodeValue());
	}

	private void flush(StringBuilder builder, PostalAddress basicAddress) {
		if (builder.length() > 0) {
			basicAddress.addPostalAddressPart(new PostalAddressPart(builder.toString()));
			builder.setLength(0);
		}
	}
}
