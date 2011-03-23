package ca.infoway.messagebuilder.simple.xml.parser;

import ca.infoway.messagebuilder.datatype.Hl7TypeName;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Representation;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class PhysicalQuantityUncertainRangeXmlParser extends AbstractSimpleXmlParser<URG<PQ, PhysicalQuantity>, UncertainRange<PhysicalQuantity>> implements SimpleXmlParser<URG<PQ, PhysicalQuantity>> {
	
	private final PhysicalQuantityXmlParser physicalQuantityParser = new PhysicalQuantityXmlParser();
	
	PhysicalQuantityUncertainRangeXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, UncertainRange<PhysicalQuantity> value) throws ParserException {
		renderLowIfNecessary(builder, dataType, value);
		renderHighIfNecessary(builder, dataType, value);
    }

	private void renderHighIfNecessary(StringBuilder builder, StandardDataType dataType, UncertainRange<PhysicalQuantity> value) throws ParserException {
		if (Representation.HIGH.equals(value.getRepresentation())
		 || Representation.LOW_HIGH.equals(value.getRepresentation())
		 || Representation.WIDTH_HIGH.equals(value.getRepresentation())
		 || Representation.CENTRE_HIGH.equals(value.getRepresentation())) {
			renderPartIfNecessary(builder, "to", dataType, value.getHigh());
		}
	}

	private void renderLowIfNecessary(StringBuilder builder, StandardDataType dataType, UncertainRange<PhysicalQuantity> value) throws ParserException {
		if (Representation.LOW_WIDTH.equals(value.getRepresentation())
		 || Representation.LOW.equals(value.getRepresentation())
		 || Representation.LOW_CENTER.equals(value.getRepresentation())
		 || Representation.LOW_HIGH.equals(value.getRepresentation())) {
			renderPartIfNecessary(builder, "from", dataType, value.getLow());
		}
	}

	private void renderPartIfNecessary(StringBuilder builder, String elementName, StandardDataType dataType, PhysicalQuantity pq) throws ParserException {
		if (pq!=null) {
			renderPart(builder, elementName, dataType, pq);
		}
	}

	private void renderPart(StringBuilder builder, String elementName, StandardDataType dataType, PhysicalQuantity pq) throws ParserException {
		builder.append(renderPq(elementName, extractTsDataType(dataType), pq));
	}

	private String renderPq(String elementName, StandardDataType tsDateType, PhysicalQuantity pq) throws ParserException {
		return this.physicalQuantityParser.parse(new SimpleXmlParseContextImpl(elementName), new PQImpl(pq));
	}

	private StandardDataType extractTsDataType(StandardDataType dataType) {
		Hl7TypeName typeName = dataType.getTypeName();
		if (typeName.getParameters().isEmpty()) {
			return StandardDataType.TS;
		} else {
			return StandardDataType.getByTypeName(typeName.getParameters().get(0).getUnparameterizedName());
		}
	}

	@Override
	protected boolean closeStartElement(URG<PQ, PhysicalQuantity> dataTypeInstance) {
		return false;
	}

}
