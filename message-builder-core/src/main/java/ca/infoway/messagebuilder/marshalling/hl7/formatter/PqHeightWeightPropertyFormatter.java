package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;


/**
 * PQ.HEIGHTWEIGHT- Physical Quantity (height or weight)
 *
 * Represents a Physical Quantity object as an element:
 *
 * &lt;element-name value="123.33" unit="validHeightWeightUnit"/&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PQ
 */
@DataTypeHandler("PQ.HEIGHTWEIGHT")
public class PqHeightWeightPropertyFormatter extends AbstractCerxPqPropertyFormatter {

}
