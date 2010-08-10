package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * PIVL - Periodic Interval of Time
 * 
 * An interval of time that recurs periodically. Periodic intervals have two
 * properties, phase and period. The phase specifies the "interval prototype"
 * that is repeated every period.
 * 
 *   
 * <effectiveTime xsi:type='PIVL_TS'>
 *   <phase>
 *      <low value='198709'/>
 *      <high value='198710'/>
 *   </phase>
 *   <period value='1' unit='a'/>
 * </effectiveTime>
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PIVL
 */
public abstract class AbstractPivlElementParser extends AbstractSingleElementParser<PeriodicIntervalTime> {

	@Override
	protected PeriodicIntervalTime parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {

		try {
			Element period = (Element) getNamedChildNode(node, "period");
			Element phase = (Element) getNamedChildNode(node, "phase");

			if (period != null && phase != null) {
				return PeriodicIntervalTime.createPeriodPhase(createPeriodType(period, xmlToJavaResult), createPhaseType(phase, xmlToJavaResult));
			} else if (period != null) {
				return PeriodicIntervalTime.createPeriod(createPeriodType(period, xmlToJavaResult));
			} else if (phase != null) {
				return PeriodicIntervalTime.createPhase(createPhaseType(phase, xmlToJavaResult));
			} else {
				return null;
			}
		} catch (ParseException e) {
			throw new XmlToModelTransformationException(e.toString());
		}
	}

	protected abstract DateDiff createPeriodType(Element element, XmlToModelResult xmlToJavaResult) throws ParseException, XmlToModelTransformationException;

	protected abstract Interval<Date> createPhaseType(Element element, XmlToModelResult xmlToJavaResult) throws ParseException, XmlToModelTransformationException;
}
