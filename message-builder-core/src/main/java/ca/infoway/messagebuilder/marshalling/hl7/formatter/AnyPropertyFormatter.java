package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.AnyHelper;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.xml.util.XmlWarningRenderer;
/**
 * ANY, ANY.LAB, ANY.CA.IZ, ANY.PATH
 * 
 * Each value sent over the wire must correspond to one of the
 * following non-abstract data type flavor specifications defined below:
 * 
 * ANY:       all types allowed
 * ANY.LAB:   CD.LAB, ST, PQ.LAB, IVL<PQ.x>, INT.NONNEG, INT.POS, TS.FULLDATETIME, URG<PQ,x>
 * ANY.CA.IZ: ST, PN.BASIC, INT.POS, BL
 * ANY.PATH:  ST, PQ, ED.DOCORREF or CD.LAB
 * 
 */
@DataTypeHandler({"ANY", "ANY.LAB", "ANY.CA.IZ", "ANY.PATH"})
public class AnyPropertyFormatter extends AbstractPropertyFormatter {

	@Override
	public String format(FormatContext formatContext, BareANY hl7Value, int indentLevel) throws ModelToXmlTransformationException {
		String type = hl7Value.getDataType().getType();
		PropertyFormatter formatter = FormatterRegistry.getInstance().get(type);
		String parentType = formatContext.getType();
		if (formatter == null || !AnyHelper.isValidTypeForAny(parentType, type)) {
			String errorText = "Cannot support properties of type " + type + " for " + parentType + ". Please specify a specializationType applicable for " + parentType + " in the appropriate message bean.";
			throw new ModelToXmlTransformationException(errorText);
		} else {
			return formatter.format(
					new FormatContextImpl(formatContext.getElementName(), type, formatContext.getConformanceLevel(), true, null), 
					hl7Value, indentLevel);
		}
	}
	
}
