package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import java.lang.reflect.Type;
import java.util.Arrays;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

@DataTypeHandler("PIVL<TS.DATETIME>")
class PivlTsDateTimeElementParser extends AbstractSingleElementParser<PeriodicIntervalTime> {

	@Override
	protected PeriodicIntervalTime parseNonNullNode(
			ParseContext context, Node node, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		return parseNonNullNode(context, (Element) node, expectedReturnType, xmlToJavaResult);
	}
	
	protected PeriodicIntervalTime parseNonNullNode(ParseContext context, Element element,
			Type expectedReturnType, XmlToModelResult xmlToJavaResult)
			throws XmlToModelTransformationException {

		validateNonAllowedChildNode(element, xmlToJavaResult, "period");
		validateNonAllowedChildNode(element, xmlToJavaResult, "phase");
		
		Element frequency = (Element) getNamedChildNode(element, "frequency");
		
		if (frequency != null) {
			return parseFrequency(context, frequency, expectedReturnType, xmlToJavaResult);
		} else {
			createManatoryChildElementHl7Error(element, "frequency", xmlToJavaResult);
			return null;
		}
	}

	private void createManatoryChildElementHl7Error(Element element, String name, 
			XmlToModelResult xmlToJavaResult) {
		xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
				"Missing mandatory element <" +
				name +
				">",
				element));
	}
	
	protected PeriodicIntervalTime parseFrequency(ParseContext context, Element element,
			Type expectedReturnType, XmlToModelResult xmlToJavaResult)
			throws XmlToModelTransformationException {

		Element numerator = (Element) getNamedChildNode(element, "numerator");
		Element denominator = (Element) getNamedChildNode(element, "denominator");
		
		if (numerator != null && denominator != null) {
			Integer repetitions = parseNumerator(context, numerator, xmlToJavaResult);
			PhysicalQuantity quantity = parseDenominator(context, denominator, xmlToJavaResult);
			
			return PeriodicIntervalTime.createFrequency(repetitions, quantity);
		} else {
			if (numerator == null) {
				createManatoryChildElementHl7Error(element, "numerator", xmlToJavaResult);
			}
			if (denominator == null) {
				createManatoryChildElementHl7Error(element, "denominator", xmlToJavaResult);
			}
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private Integer parseNumerator(ParseContext context, Element numerator,
			XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		ElementParser parser = ParserRegistry.getInstance().get("INT.NONNEG");
		ParseContext subContext = ParserContextImpl.create("INT.NONNEG", Integer.class, context.getVersion(), MANDATORY);
		return (Integer) parser.parse(subContext, Arrays.asList((Node) numerator), xmlToJavaResult).getBareValue();
	}

	@SuppressWarnings("unchecked")
	private PhysicalQuantity parseDenominator(ParseContext context, Element numerator,
			XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		ElementParser parser = ParserRegistry.getInstance().get("PQ.TIME");
		ParseContext subContext = ParserContextImpl.create("PQ.TIME", PhysicalQuantity.class, context.getVersion(), MANDATORY);
		return (PhysicalQuantity) parser.parse(subContext, Arrays.asList((Node) numerator), xmlToJavaResult).getBareValue();
	}
	
	private void validateNonAllowedChildNode(Element element,
			XmlToModelResult xmlToJavaResult, String elementName) {
		if (getNamedChildNode(element, elementName) != null) {
			xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
					"Periodic Interval (PIVL<TS.DATETIME>) does not allow the <" +
					elementName + "> element",
					element));
		}
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PIVLImpl();
	}
}
