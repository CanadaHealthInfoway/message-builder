package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Collection;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler({"SET"})
public class SetPropertyFormatter extends BaseCollectionPropertyFormatter {

    @Override
    String formatNonNullValue(FormatContext context, Collection<BareANY> set, int indentLevel) throws ModelToXmlTransformationException {
    	return formatAllElements(createSubContext(context), set, indentLevel);
    }

}
