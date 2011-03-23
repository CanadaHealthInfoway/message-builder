package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;


@DataTypeHandler({"TEL.PHONEMAIL", "TEL"})
class LenientTelPhonemailPropertyFormatter extends TelPhonemailPropertyFormatter {

    @Override
    protected void validateTelecommunicationAddressUse(TelecommunicationAddressUse telcomAddressUse) throws ModelToXmlTransformationException {
        // no-op: be lenient
    }

    @Override
    protected void validateUrlScheme(TelecommunicationAddress telcomAddress) throws ModelToXmlTransformationException {
        // no-op: be lenient
    }

}
