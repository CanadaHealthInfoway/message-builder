package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * ON - OrganizationName
 *
 * Represents an ON object as an element:
 *
 * &lt;element-name&gt;&lt;prefix&gt;prefix&lt;/prefix&gt;Intelliware Development&lt;delimiter&gt;,&lt;/delimiter&gt;&lt;suffix&gt;Inc.&lt;/suffix&gt;&lt;/element-name&gt;
 *
 * Seriously, who comes up with this stuff? It's like a brain-damaged monkey tried to have sex
 * with an international health standard.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ON
 */
@DataTypeHandler("ON")
class OnPropertyFormatter extends AbstractEntityNamePropertyFormatter<OrganizationName> {
}
