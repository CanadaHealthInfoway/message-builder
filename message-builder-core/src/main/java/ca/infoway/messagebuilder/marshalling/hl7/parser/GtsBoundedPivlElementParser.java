package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

@DataTypeHandler("GTS.BOUNDEDPIVL")
class GtsBoundedPivlElementParser extends AbstractSingleElementParser<GeneralTimingSpecification> {

	@Override
	protected GeneralTimingSpecification parseNonNullNode(ParseContext context,
			Node node, Type expectedReturnType, XmlToModelResult xmlToJavaResult)
			throws XmlToModelTransformationException {
		return parseNonNullNode(context, (Element) node, expectedReturnType, xmlToJavaResult);
	}
	protected GeneralTimingSpecification parseNonNullNode(ParseContext context,
			Element element, Type expectedReturnType, XmlToModelResult xmlToJavaResult)
			throws XmlToModelTransformationException {
		
		GeneralTimingSpecification result = null;
		List<Element> components = findComponents(element, xmlToJavaResult);
		
		if (components.size() == 2) {
			Interval<Date> duration = parseDuration(context, xmlToJavaResult, components.get(0));
			PeriodicIntervalTime frequency = parseFrequency(context, xmlToJavaResult, components.get(1));
			
			if (duration != null && frequency != null) {
				result = new GeneralTimingSpecification(duration, frequency);
			} else {
				if (duration == null) {
					xmlToJavaResult.addHl7Error(new Hl7Error(
							Hl7ErrorCode.DATA_TYPE_ERROR,
							"Could not parse the duration portion of the GTS.BOUNDEDPIVL",
							components.get(0)));
				}
				if (frequency == null) {
					xmlToJavaResult.addHl7Error(new Hl7Error(
							Hl7ErrorCode.DATA_TYPE_ERROR,
							"Could not parse the frequency portion of the GTS.BOUNDEDPIVL",
							components.get(1)));
				}
			}
		} else {
			xmlToJavaResult.addHl7Error(new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR,
					MessageFormat.format("Expected to find 2 <comp> sub-elements, but found {0}", components.size()),
					element));
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	private Interval<Date> parseDuration(ParseContext context, XmlToModelResult xmlToJavaResult,
			Element durationElement) throws XmlToModelTransformationException {
		ParseContext subContext = ParserContextImpl.create("IVL<TS.FULLDATE>", Interval.class, context.getVersion(), MANDATORY);
		return (Interval<Date>) ParserRegistry.getInstance().get("IVL<TS.FULLDATE>").parse(
				subContext, Arrays.asList((Node) durationElement), xmlToJavaResult).getBareValue();
	}
	
	private PeriodicIntervalTime parseFrequency(ParseContext context, XmlToModelResult xmlToJavaResult,
			Element durationElement) throws XmlToModelTransformationException {
		ParseContext subContext = ParserContextImpl.create("PIVL<TS.DATETIME>", PeriodicIntervalTime.class, context.getVersion(), MANDATORY);
		return (PeriodicIntervalTime) ParserRegistry.getInstance().get("PIVL<TS.DATETIME>").parse(
				subContext, Arrays.asList((Node) durationElement), xmlToJavaResult).getBareValue();
	}
	
	private List<Element> findComponents(Element element, XmlToModelResult xmlToJavaResult) {
		List<Element> result = new ArrayList<Element>();
		NodeList list = element.getChildNodes();
		int length = list == null ? 0 : list.getLength();
		for (int i = 0; i < length; i++) {
			Node node = list.item(i);
			if (node.getNodeType() != Node.ELEMENT_NODE) {
				// skip it
			} else if (StringUtils.equals("comp", NodeUtil.getLocalOrTagName((Element) node))) {
				result.add((Element) node);
			} else {
				xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format("Unexpected tag {0} in GTS.BOUNDEDPIVL", XmlDescriber.describeSingleElement((Element) node), node)));
			}
		}
		return result;
	}
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new GTSImpl();
	}
}
