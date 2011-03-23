package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class EncapsulatedDataDocumentXmlParser extends AbstractSimpleXmlParser<ED<EncapsulatedData>, EncapsulatedData> implements SimpleXmlParser<ED<EncapsulatedData>> {
	
	EncapsulatedDataDocumentXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, EncapsulatedData value) {
		if (StandardDataType.ED_DOC.equals(dataType)) {
			builder.append("<document>");
			byte[] content = value.getContent();
			if (content != null) {
				builder.append(new String(Base64.encodeBase64(content)));
			}
			builder.append("</document>");
		}
	}

	@Override
	protected boolean closeStartElement(ED<EncapsulatedData> dataTypeInstance) {
		return false;
	}
	
	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, EncapsulatedData value) {
		Map<String,String> attributes = new LinkedHashMap<String, String>();
		if (value.getMediaType() != null) {
			attributes.put("mediaType", value.getMediaType().getCodeValue());
		}
		if (StringUtils.isNotBlank(value.getReference())) {
			attributes.put("uri", value.getReference());
		}
		if (value instanceof CompressedData) {
			CompressedData compressedData = (CompressedData) value;
			String compressionType = compressedData.getCompression() == null ? null : compressedData.getCompression().getCompressionType();
			if (StringUtils.isNotBlank(compressionType)) {
				attributes.put("compression", compressionType);
			}
			String language = compressedData.getLanguage();
			if (StringUtils.isNotBlank(language)) {
				if (CompressedData.LANGUAGE_ENGLISH.equals(language)) {
					attributes.put("language", "en");
				} else if (CompressedData.LANGUAGE_FRENCH.equals(language)) {
					attributes.put("language", "fr");
				}
			}
		}
		return attributes;
	}

}

