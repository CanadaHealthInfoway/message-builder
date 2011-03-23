package ca.infoway.messagebuilder.datatype;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;


/**
 * <p>A parser used to separate the component parts of an HL7 type.  For
 * example, the HL7 type <code>SET&lt;RTO&lt;PQ.DRUG,PQ.QUANTITY&gt;&gt;</code> 
 * can be separated into these "parts":
 * 
 * <ul>
 * <li>PQ.DRUG
 * <li>PQ.QUANTITY
 * <li>RTO&lt;PQ.DRUG,PQ.QUANTITY&gt;
 * <li>SET&lt;RTO&lt;PQ.DRUG,PQ.QUANTITY&gt;&gt;
 * </ul>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually
 */
class Hl7TypeParser {
	
	Hl7TypeName parse(String hl7Type) {
		Hl7TypeName name = null;
		if (hl7Type!=null) {
			List<Hl7TypeName> nameParts = processParts(hl7Type);
			if (nameParts.size() == 1) {
				name = nameParts.get(0);
			} else if (nameParts.size() > 1) {
				throw new IllegalArgumentException("Cannot parse the following type: " + hl7Type);
			}
		}
		return name;
	}

	private List<Hl7TypeName> processParts(String hl7Type) {
		List<String> parts = split(hl7Type);
		List<Hl7TypeName> nameParts = new ArrayList<Hl7TypeName>();
		for (String part : parts) {
			nameParts.add(convertPart(part));
		}
		return nameParts;
	}

	private Hl7TypeName convertPart(String hl7Type) {
		Hl7TypeName result = null;
		if (hl7Type.contains("<")){
			String parameters = StringUtils.substringBeforeLast(StringUtils.substringAfter(hl7Type, "<"), ">");
			String baseName = StringUtils.substringBefore(hl7Type, "<");
			result = new Hl7TypeName(StringUtils.trim(baseName), processParts(parameters));
		} else {
			result = new Hl7TypeName(StringUtils.trim(hl7Type));
		}
		return result;
	}
	
	List<String> split(String name) {
		List<String> parts = new ArrayList<String>();
		int depth = 0;
		StringBuilder builder = new StringBuilder();
		for (StringTokenizer tokenizer = new StringTokenizer(name, "<,>", true); tokenizer.hasMoreTokens(); ) {
			String token = tokenizer.nextToken();
			if ("<".equals(token)) {
				depth++;
				builder.append(token);
			} else if (",".equals(token) && depth == 0) {
				parts.add(builder.toString());
				builder.setLength(0);
			} else if ("<".equals(token)) {
				depth--;
				builder.append(token);
			} else {
				builder.append(token);
			}
		}
		if (builder.length() > 0) {
			parts.add(builder.toString());
		}
		return parts;
	}
}
