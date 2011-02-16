package ca.infoway.messagebuilder.xml.validator;

import static ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper.getReturnType;
import static ca.infoway.messagebuilder.marshalling.hl7.Hl7Error.createInvalidFixedValueAttributeError;
import static ca.infoway.messagebuilder.marshalling.hl7.Hl7Error.createMissingMandatoryAttributeError;
import static ca.infoway.messagebuilder.marshalling.hl7.Hl7Error.createMissingNamespace;
import static ca.infoway.messagebuilder.marshalling.hl7.Hl7Error.createUnknownInteractionError;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.Typed;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.BlElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.CsElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.NullFlavorHelper;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserRegistry;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.visitor.MessageVisitor;

public class ValidatingVisitor implements MessageVisitor {

	private static final String ITS_VERSION_VALUE = "XML_1.0";
	private static final String ITS_VERSION = "ITSVersion";
	private static final String HL7_NAMESPACE = "urn:hl7-org:v3";
	private final XmlToModelResult result = new XmlToModelResult();
	private final String version;
	
	public ValidatingVisitor(String version) {
		this.version = version;
	}
	
	public MessageValidatorResult getResult() {
		MessageValidatorResult validatorResult = new MessageValidatorResult();
		validatorResult.getHl7Errors().addAll(this.result.getHl7Errors());
		return validatorResult;
	}

	public void visitAssociation(Element base, String xmlName, List<Element> elements, Relationship relationship) {
		if (relationship == null) {
			// shouldn't happen
		} else if (CollectionUtils.isEmpty(elements) && relationship.isMandatory()) {
			this.result.addHl7Error(Hl7Error.createMissingMandatoryAssociationError(xmlName, base));
		} else if (CollectionUtils.isEmpty(elements) && relationship.getConformance() == ConformanceLevel.POPULATED) {
			this.result.addHl7Error(Hl7Error.createMissingPopulatedAssociationError(xmlName, base));
		} else if (!relationship.getCardinality().contains(elements.size())) {
			this.result.addHl7Error(Hl7Error.createWrongNumberOfAssociationsError(xmlName, base, elements.size(), relationship.getCardinality()));
		}
		if (relationship.getCardinality().isSingle() && elements.size() == 1) {
			checkForInvalidNullFlavor(elements.get(0), relationship);
		}
	}

	private void checkForInvalidNullFlavor(Element element, Relationship relationship) {
		NullFlavorHelper nullFlavorHelper = new NullFlavorHelper(relationship.getConformance(), element, this.result, true);
		if (nullFlavorHelper.hasValidNullFlavorAttribute()) {
			nullFlavorHelper.parseNullNode();
		}
	}

	public void visitRoot(Element documentElement, Interaction interaction) {
		if (interaction == null) {
			this.result.addHl7Error(createUnknownInteractionError(
					documentElement == null 
						? "unknown" 
						: NodeUtil.getLocalOrTagName(documentElement)));
		} else {
			if (!documentElement.hasAttribute(ITS_VERSION)) {
				this.result.addHl7Error(createMissingMandatoryAttributeError(ITS_VERSION, documentElement));
			} else if (!StringUtils.equals(ITS_VERSION_VALUE, documentElement.getAttribute(ITS_VERSION))) {
				this.result.addHl7Error(createInvalidFixedValueAttributeError(documentElement.getAttributeNode(ITS_VERSION), ITS_VERSION_VALUE));
			}
			
			if (StringUtils.isBlank(documentElement.getNamespaceURI())
					|| !HL7_NAMESPACE.equals(documentElement.getNamespaceURI())) {
				this.result.addHl7Error(createMissingNamespace(HL7_NAMESPACE, documentElement));
			}
		}
	}
	
	private boolean isHl7Attribute(Attr attr) {
		 return HL7_NAMESPACE.equals(attr.getNamespaceURI()) ||
				StringUtils.isBlank(attr.getNamespaceURI());
	}

	public void visitStructuralAttribute(Element base, Attr attr, Relationship relationship) {
		if (relationship == null && !isHl7Attribute(attr)) {
			// ignore
		} else if (attr != null && "nullFlavor".equals(attr.getName())) {
			// ignore
		} else if (relationship ==  null) {
			this.result.addHl7Error(Hl7Error.createUnknownStructuralAttributeError(base, attr));
		} else if (attr != null && relationship.isFixed()) {
			validateFixedValue(attr, relationship.getFixedValue());
		} else if (attr != null) {
			validateStructuralAttributeValue(base, attr, relationship);
		} else if (relationship.isMandatory() && relationship.isFixed()) {
			// various people suggest that fixed values can be left out
		} else if (relationship.isMandatory()) {
			this.result.addHl7Error(Hl7Error.createMissingMandatoryAttributeError(relationship.getName(), base));
		}
	}

	private void validateStructuralAttributeValue(Element base, Attr attr, Relationship relationship) {
		if (StandardDataType.BL == StandardDataType.getByTypeName((Typed) relationship)) {
			new BlElementParser().parseBooleanValue(this.result, attr.getValue(), base, attr);
		} else if (StandardDataType.CS == StandardDataType.getByTypeName((Typed) relationship)) {
			new CsElementParser().parseCodedSimpleValue(attr.getValue(), (Class<? extends Code>) getReturnType(relationship), base, this.result, attr);
		} else {
			this.result.addHl7Error(Hl7Error.createUnknownStructuralTypeError(relationship.getType(), relationship.getName(), base, attr));
		}
	}

	private void validateFixedValue(Attr attr, String fixedValue) {
		if (!StringUtils.equals(fixedValue, attr.getValue())) {
			this.result.addHl7Error(Hl7Error.createInvalidFixedValueAttributeError(attr, fixedValue));
		}
	}

	public void visitNonStructuralAttribute(Element base, List<Element> elements, Relationship relationship) {
		if (relationship == null && !elements.isEmpty()) {
			this.result.addHl7Error(Hl7Error.createUnknownChildElementError(elements.get(0)));
		} else if (relationship != null) {
			if (CollectionUtils.isEmpty(elements) && relationship.isMandatory()) {
				this.result.addHl7Error(Hl7Error.createMissingMandatoryAttributeError(relationship.getName(), base));
			} else if (CollectionUtils.isEmpty(elements) && relationship.isPopulated()) {
				this.result.addHl7Error(Hl7Error.createMissingPopulatedAttributeError(relationship.getName(), base));
			} else {
				try {
					ElementParser parser = ParserRegistry.getInstance().get((Typed) relationship);
					if (parser != null) {
						BareANY value = parser.parse(ParseContextImpl.create(relationship, this.version), toNodeList(elements), this.result);
						validateNonstructuralFixedValue(relationship, value);
					} else {
						this.result.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, "Cannot find a parser for type " + relationship.getType()));
					}
				} catch (XmlToModelTransformationException e) {
					this.result.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, e.getMessage()));
				}
			}
		}
	}

	private void validateNonstructuralFixedValue(Relationship relationship,	BareANY value) {
		if (relationship.isFixed()) {
			if (value instanceof CD) {
				Code code = ((CD) value).getValue();
				if (code == null || code.getCodeValue() == null || !StringUtils.equals(relationship.getFixedValue(), code.getCodeValue())) {
					this.result.addHl7Error(new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, "Fixed-value attribute '" + relationship.getName() +"' must have value '" + relationship.getFixedValue() + "'"));
				}
			} else {
				this.result.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, "Non-structural fixed-value attribute '" + relationship.getName() +"' was not a 'code' datatype as expected but was of type '" + relationship.getType() + "'"));
			}
		}
	}

	private List<Node> toNodeList(List<Element> elementList) {
		List<Node> result =  new ArrayList<Node>();
		for (Node node : elementList) {
			result.add(node);
		}
		return result;
	}
}
