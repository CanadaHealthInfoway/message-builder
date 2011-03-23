package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler({"URG<PQ>", "URG<PQ.BASIC>", "URG<PQ.TIME>", "URG<PQ.WIDTH>"})
class UrgPqPropertyFormatter extends AbstractNullFlavorPropertyFormatter<UncertainRange<PhysicalQuantity>> {

	private static final String UNIT = "unit";
    private static final String WIDTH = "width";
    private static final String CENTRE = "center";
    private static final String HIGH = "high";
    private static final String LOW = "low";
    private static final String VALUE = "value";

    @Override
	String formatNonNullValue(FormatContext context, UncertainRange<PhysicalQuantity> value, int indentLevel) throws ModelToXmlTransformationException {

        StringBuffer buffer = new StringBuffer();
        buffer.append(createElement(context, null, indentLevel, false, true));
        appendIntervalBounds(value, buffer);
        buffer.append(createElementClosure(context, 0, true));
        return buffer.toString();
    }

    private void appendIntervalBounds(UncertainRange<PhysicalQuantity> value, StringBuffer buffer) {
        switch (value.getRepresentation()) {
        case LOW_HIGH:
            buffer.append(createElement(LOW, toStringMap(value.getLow()), 1, true, true));
            buffer.append(createElement(HIGH, toStringMap(value.getHigh()), 1, true, true));
            break;
        case CENTRE:
            buffer.append(createElement(CENTRE, toStringMap(value.getCentre()), 1, true, true));
            break;
        case HIGH:
            buffer.append(createElement(HIGH, toStringMap(value.getHigh()), 1, true, true));
            break;
        case LOW:
            buffer.append(createElement(LOW, toStringMap(value.getLow()), 1, true, true));
            break;
        case WIDTH:
            buffer.append(createElement(WIDTH, toStringMap(value.getWidth()), 1, true, true));
            break;
        case LOW_WIDTH:
            buffer.append(createElement(LOW, toStringMap(value.getLow()), 1, true, true));
            buffer.append(createElement(WIDTH, toStringMap(value.getWidth()), 1, true, true));
            break;
        case WIDTH_HIGH:
            buffer.append(createElement(WIDTH, toStringMap(value.getWidth()), 1, true, true));
            buffer.append(createElement(HIGH, toStringMap(value.getCentre()), 1, true, true));
            break;
        case CENTRE_WIDTH:
            buffer.append(createElement(CENTRE, toStringMap(value.getCentre()), 1, true, true));
            buffer.append(createElement(WIDTH, toStringMap(value.getWidth()), 1, true, true));
            break;
        default:
        }
    }

    private Map<String, String> toStringMap(Diff<PhysicalQuantity> diff) {
        return toStringMap(diff.getValue());
    }

    private Map<String, String> toStringMap(Object quantity) {
        return toStringMap((PhysicalQuantity) quantity);
    }
    
    private Map<String, String> toStringMap(PhysicalQuantity quantity) {
        Map<String,String> map = new HashMap<String,String>();
        map.put(VALUE, quantity.getQuantity().toString());
        map.put(UNIT, quantity.getUnit().getCodeValue());
        return map;
    }
}
