package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.text.ParseException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.BareDiff;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * IVL - Interval
 * 
 * Parses an IVL element into a Interval. The element looks like this:
 * 
 * <value>
 *   <low value='2'/>
 *   <high value='4'/>
 * </value>
 *
 * or:
 * 
 * <value>
 *   <width unit="d" value="15"/>
 * </value>
 * 
 * or (confusingly):
 *
 * <value value='2' />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-IVL
 */
abstract class AbstractIvlElementParser<T> extends AbstractSingleElementParser<Interval<T>> {
	
	@Override
	@SuppressWarnings("unchecked")
	protected Interval<T> parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {

		Interval<T> result = null;
		
		try {
			Element low = (Element) getNamedChildNode(node, "low");
			Element high = (Element) getNamedChildNode(node, "high");
			Element center = (Element) getNamedChildNode(node, "center");
			Element width = (Element) getNamedChildNode(node, "width");
			
			Object lowType = low==null ? null : createType(context, low, xmlToJavaResult).getBareValue();
			Object highType = high==null ? null : createType(context, high, xmlToJavaResult).getBareValue();
			Object centerType = center==null ? null : createType(context, center, xmlToJavaResult).getBareValue();
			Object widthType = width==null ? null : createDiffType(context, width, xmlToJavaResult);
			
			if (lowType != null && highType != null) {
				result = IntervalFactory.<T>createLowHigh((T) lowType, (T)highType);
			} else if (lowType != null && widthType != null) {
				result = IntervalFactory.<T>createLowWidth((T)lowType, (Diff<T>) widthType);
			} else if (highType != null && widthType != null) {
				result = IntervalFactory.<T>createWidthHigh((Diff<T>) widthType, (T) highType);
			} else if (centerType != null && widthType != null) {
				result = IntervalFactory.<T>createCentreWidth((T) centerType, (Diff<T>) widthType);
			} else if (lowType != null) {
				result = IntervalFactory.<T>createLow((T) lowType);
			} else if (highType != null) {
				result = IntervalFactory.<T>createHigh((T) highType);
			} else if (centerType != null) {
				result = IntervalFactory.<T>createCentre((T) centerType);
			} else if (widthType != null) {
				result = IntervalFactory.<T>createWidth((Diff<T>)widthType);
			} else {
				Object type = createType(context, (Element) node, xmlToJavaResult).getBareValue();
				if (type==null) {
		        	xmlToJavaResult.addHl7Error(new Hl7Error(
		        			Hl7ErrorCode.SYNTAX_ERROR, "\"Simple interval node: " + XmlDescriber.describePath(node) + " does not allow a null value\""));
				} else {
					result = IntervalFactory.<T>createSimple((T) type);
				}
			}
		} catch (ParseException e) {
        	xmlToJavaResult.addHl7Error(new Hl7Error(
        			Hl7ErrorCode.DATA_TYPE_ERROR, "Unable to parse the interval date for element \"" + node.getNodeName() + "\""));
		}
		
		return result;
	}
	
	BareDiff createDiffType(ParseContext context, Element width, XmlToModelResult xmlToJavaResult) throws ParseException, XmlToModelTransformationException {
		return new Diff<T>((T) createType(context, width, xmlToJavaResult).getBareValue());
	}

	protected abstract BareANY createType(ParseContext context, Element high, XmlToModelResult xmlToJavaResult) throws ParseException, XmlToModelTransformationException;
}
