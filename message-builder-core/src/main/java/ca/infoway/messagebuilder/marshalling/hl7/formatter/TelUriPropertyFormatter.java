package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * Represents a TEL.URI String as an element:
 *
 * &lt;element-name value="mailto://me@me.com"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TEL
 *
 * The TEL.URI variant defined by CeRx is for computer system addreses only. The only valid
 * URLSchemes are FILE, FTP, HTTP, HTTPS, MAILTO and NFS.
 */
@DataTypeHandler("TEL.URI")
public class TelUriPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<TelecommunicationAddress> {

    private final static List<String> ALLOWABLE_URL_SCHEMES = new ArrayList<String>();

    static {
        ALLOWABLE_URL_SCHEMES.add("file");
        ALLOWABLE_URL_SCHEMES.add("ftp");
        ALLOWABLE_URL_SCHEMES.add("http");
        ALLOWABLE_URL_SCHEMES.add("https");
        ALLOWABLE_URL_SCHEMES.add("mailto");
        ALLOWABLE_URL_SCHEMES.add("nfs");
    }

    @Override
    protected final String getValue(TelecommunicationAddress uri, VersionNumber version) throws ModelToXmlTransformationException {
        validateUrlScheme(uri);
        return uri.toString();
    }

    protected void validateUrlScheme(TelecommunicationAddress uri) throws ModelToXmlTransformationException {
        if (!ALLOWABLE_URL_SCHEMES.contains(uri.getUrlScheme().getCodeValue())) {
            throw new ModelToXmlTransformationException("URLScheme " + uri.getUrlScheme().getCodeValue() + " is not supported for TEL.URI data");
        }
    }
}
