package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.util.ArrayList;
import java.util.Collection;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.marshalling.MarshallingException;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler({"LIST"})
class ListElementParser extends SetOrListElementParser {

	@Override
	protected BareANY wrapWithHl7DataType(String type, String subType, Collection<BareANY> collection) {
		try {
			CollectionHelper result = (CollectionHelper) GenericDataTypeFactory.create(type);
			for (BareANY bareANY : collection) {
				result.add(bareANY);
			}
			return (BareANY) result;
		} catch (MarshallingException e) {
			return null;
		}
	}

	@Override
	protected Collection<BareANY> getCollectionType(ParseContext context) {
		return new ArrayList<BareANY>();
	}

}