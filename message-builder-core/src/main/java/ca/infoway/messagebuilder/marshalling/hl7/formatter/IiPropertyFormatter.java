package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.datatype.StandardDataType.II_BUS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_PUBLIC;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.util.text.Indenter;

@DataTypeHandler("II")
class IiPropertyFormatter extends AbstractAttributePropertyFormatter<Identifier> {

	@Override
    String formatNonNullValue(FormatContext context, Identifier ii, int indentLevel)
			throws ModelToXmlTransformationException {
    	StringBuilder builder = new StringBuilder();
        if (StringUtils.isBlank(ii.getRoot())) {
        	Indenter.indentBuilder(builder, indentLevel);
        	builder.append("<!-- WARNING: ")
        			.append("Property root on oid property ")
        			.append(context.getElementName())
        			.append(" cannot be null: ")
        			.append(ii)
        			.append(" -->");
        	builder.append(SystemUtils.LINE_SEPARATOR);
        }
        builder.append(super.formatNonNullValue(context, ii, indentLevel));
		return builder.toString();
	}

	/**
     * II - Installer Identifier
     * 
     * II has two attributes: root, extension
     *
     * CeRx standards claim that both attributes are required, although extension 
     * is sometimes unused. 
     * 
     * The HL7 standard also defines the assigningAuthorityName attribute, but that
     * has been left out of the CeRx implementation.
     * 
     * According to CeRx: Root has a limit of 100 characters, extension of 20 
     * characters. These limits are not currently enforced by this class. 
     *
     * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-II
     */
    @Override
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Identifier ii) throws ModelToXmlTransformationException {

        Map<String, String> result = new HashMap<String, String>();
        result.put("root", ii.getRoot() == null ? StringUtils.EMPTY : ii.getRoot());
        
        if (StringUtils.isNotBlank(ii.getExtension())) {
            result.put("extension", ii.getExtension());
        }
        
        if (StringUtils.equals(II_BUS.getType(), context.getType())) {
            result.put("use", "BUS");
        } else if (StringUtils.equals(II_PUBLIC.getType(), context.getType())) {
            result.put("displayable", "true");
            VersionNumber version = context.getVersion();
            if (version != null) {
				String versionLiteral = version.getVersionLiteral();
				if (!StringUtils.equals(versionLiteral, SpecificationVersion.V01R04_3_HOTFIX3.getVersionLiteral()) &&
						!StringUtils.equals(versionLiteral, "V02R01") &&
						!StringUtils.equals(versionLiteral, SpecificationVersion.V02R02.getVersionLiteral()) &&
						!StringUtils.equals(versionLiteral, SpecificationVersion.NEWFOUNDLAND.getVersionLiteral())) {
					result.put("use", "BUS");
	            }
            }
        } 
        
        return result;
    }
}
