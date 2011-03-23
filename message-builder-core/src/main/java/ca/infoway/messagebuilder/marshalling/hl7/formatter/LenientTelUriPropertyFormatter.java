package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;


@DataTypeHandler("TEL.URI")
class LenientTelUriPropertyFormatter extends TelUriPropertyFormatter {

    @Override
    protected void validateUrlScheme(TelecommunicationAddress uri) throws ModelToXmlTransformationException {
        // no-op: be lenient
    }

}
