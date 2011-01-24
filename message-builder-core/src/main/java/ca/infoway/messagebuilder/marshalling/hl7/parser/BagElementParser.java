package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.marshalling.MarshallingException;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

@DataTypeHandler({"BAG"})
class BagElementParser extends SetOrListElementParser {

	@Override
	public BareANY parse(ParseContext context, List<Node> nodes,
			XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
				"Data type \"" + context.getType() 
				+ "\" is not part of the pan-Canadian standard"));
		return super.parse(context, nodes, xmlToJavaResult);
	}
	
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