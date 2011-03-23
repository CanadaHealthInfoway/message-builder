package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.j5goodies.Generics;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

abstract class SetOrListElementParser extends AbstractElementParser {

	@Override
	public BareANY parse(ParseContext context, List<Node> nodes, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
 		String subType = getSubType(context);
		Collection<BareANY> list = getCollectionType(context);
		for (Node node : nodes) {
			ElementParser parser = ParserRegistry.getInstance().get(subType);
			if (parser != null) {
				BareANY result = parser.parse(ParserContextImpl.create(
						subType, getSubTypeAsJavaType(context), context.getVersion(), context.getConformance()), 
						toList(node), xmlToJavaResult);
				if (result != null) {
					list.add(result);
				}
			} else {
				xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.INTERNAL_ERROR, 
						"No parser type found for " + subType, (Element) node));
				break;
			}
		}
		return wrapWithHl7DataType(context.getType(), subType, list);
	}

	protected abstract BareANY wrapWithHl7DataType(String type, String subType, Collection<BareANY> collection);

	protected abstract Collection<BareANY> getCollectionType(ParseContext context);
	
	private Type getSubTypeAsJavaType(ParseContext context) {
		Type returnType = getReturnType(context);
		try {
			return Generics.getParameterType(returnType);
		} catch (IllegalArgumentException e) {
			return returnType;
		}
//		if (returnType instanceof ParameterizedType) {
//			ParameterizedType parameterizedType = (ParameterizedType) returnType;
//			Type[] actualTypeArguments = parameterizedType == null 
//					? new Type[] { null } : parameterizedType.getActualTypeArguments();
//			return actualTypeArguments[0];
//		} else {
//			return returnType;
//		}
	}

	private List<Node> toList(Node node) {
		return Arrays.asList(node);
	}

	protected String getChildType() {
		return null;
	}

	private String getSubType(ParseContext context) throws XmlToModelTransformationException {
		String subType = Hl7DataTypeName.getParameterizedType(context.getType());
		if (StringUtils.isNotBlank(subType)) {
			return subType;
		} else {
			throw new XmlToModelTransformationException("Cannot find the sub type for " + context.getType());
		}
	}

}