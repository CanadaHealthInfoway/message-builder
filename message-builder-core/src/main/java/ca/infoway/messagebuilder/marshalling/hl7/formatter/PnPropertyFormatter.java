package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * PN - PersonalName
 *
 * Represents a PN object as an element:
 *
 * &lt;element-name&gt;
 *  &lt;given&gt;Adam&lt;/given&gt;
 *  &lt;given&gt;A.&lt;/given&gt;
 *  &lt;family&gt;Everyman&lt;/family&gt;
 * &lt;/element-name&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PN
 */
@DataTypeHandler({"PN", "PN.FULL", "PN.BASIC", "PN.SEARCH"})
class PnPropertyFormatter extends AbstractEntityNamePropertyFormatter<PersonName> {
}
