package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

@DataTypeHandler("PIVL<TS>")
class PivlTsElementParser extends AbstractPivlElementParser {

    @Override
	protected DateDiff createPeriodType(Element element, XmlToModelResult xmlToJavaResult) throws ParseException, XmlToModelTransformationException {
    	return (DateDiff) new IvlTsElementParser().createDiffType(
    			ParserContextImpl.create("IVL<TS>", null, null, ConformanceLevel.OPTIONAL),
    			element, xmlToJavaResult);
	}

	@Override
	protected Interval<Date> createPhaseType(Element element, XmlToModelResult xmlToJavaResult) throws ParseException, XmlToModelTransformationException {
		return (Interval<Date>) new IvlTsElementParser().parse(
    			ParserContextImpl.create("IVL<TS>", null, null, ConformanceLevel.OPTIONAL),
    			Arrays.asList((Node) element), xmlToJavaResult).getBareValue();
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PIVLImpl();
	}
}
