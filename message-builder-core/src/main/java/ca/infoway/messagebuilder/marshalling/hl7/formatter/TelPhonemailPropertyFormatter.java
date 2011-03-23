package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

/**
 * Represents a TEL.PHONEMAIL String as an element:
 *
 * &lt;element-name use="H WP" value="mailto://me@me.com"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TEL
 *
 * The TEL.PHONEMAIL variant defined by CeRx is for personal contact addresses only.
 * The only valid URLSchemes are FAX, MAILTO and TELEPHONE.
 */
@DataTypeHandler({"TEL.PHONEMAIL", "TEL"})
public class TelPhonemailPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<TelecommunicationAddress> {

    private final static List<String> ALLOWABLE_URL_SCHEMES;
    private final static List<String> ALLOWABLE_TELECOMMUNICATION_USES;
    static {
    	ALLOWABLE_URL_SCHEMES = new ArrayList<String>();
        ALLOWABLE_URL_SCHEMES.add("fax");
        ALLOWABLE_URL_SCHEMES.add("mailto");
        ALLOWABLE_URL_SCHEMES.add("tel");
        
        ALLOWABLE_TELECOMMUNICATION_USES = new ArrayList<String>();
        ALLOWABLE_TELECOMMUNICATION_USES.add("EC");
        ALLOWABLE_TELECOMMUNICATION_USES.add("H");
        ALLOWABLE_TELECOMMUNICATION_USES.add("MC");
        ALLOWABLE_TELECOMMUNICATION_USES.add("PG");
        ALLOWABLE_TELECOMMUNICATION_USES.add("TMP");
        ALLOWABLE_TELECOMMUNICATION_USES.add("WP");
    }

    @Override
    protected final String getValue(TelecommunicationAddress phonemail, VersionNumber version) throws ModelToXmlTransformationException {
        validateUrlScheme(phonemail);
        return phonemail.toString();
    }

    @Override
    protected final void addOtherAttributesIfNecessary(TelecommunicationAddress phonemail, Map<String, String> attributes) throws ModelToXmlTransformationException {
        if (!phonemail.getAddressUses().isEmpty()) {
            StringBuffer useValue = new StringBuffer();
            boolean isFirst = true;
            for (TelecommunicationAddressUse addressUse : phonemail.getAddressUses()) {
                validateTelecommunicationAddressUse(addressUse);

                if (!isFirst) {
                    useValue.append(XmlRenderingUtils.SPACE);
                }
                useValue.append(addressUse.getCodeValue());
                isFirst = false;
            }
            attributes.put("use", useValue.toString());
        }
    }

    protected void validateUrlScheme(TelecommunicationAddress telcomAddress) throws ModelToXmlTransformationException {
        if (!ALLOWABLE_URL_SCHEMES.contains(telcomAddress.getUrlScheme().getCodeValue())) {
            throw new ModelToXmlTransformationException("URLScheme " + telcomAddress.getUrlScheme().getCodeValue() + " is not supported for TEL.PHONEMAIL data");
        }
    }

    protected void validateTelecommunicationAddressUse(TelecommunicationAddressUse telcomAddressUse) throws ModelToXmlTransformationException {
        if (!ALLOWABLE_TELECOMMUNICATION_USES.contains(telcomAddressUse.getCodeValue())) {
            throw new ModelToXmlTransformationException("Telecommunication address use " + telcomAddressUse.getCodeValue() + " is not supported for TEL.PHONEMAIL data");
        }
    }
}
