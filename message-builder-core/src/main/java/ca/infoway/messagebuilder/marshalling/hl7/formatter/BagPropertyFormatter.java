package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Collection;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler({"BAG"})
class BagPropertyFormatter extends BaseCollectionPropertyFormatter {

    @Override
    String formatNonNullValue(FormatContext context, Collection<BareANY> list, int indentLevel) throws ModelToXmlTransformationException {
    	return formatAllElements(createSubContext(context), list, indentLevel);
    }

}
