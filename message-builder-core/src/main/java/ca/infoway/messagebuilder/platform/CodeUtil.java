package ca.infoway.messagebuilder.platform;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

/**
 * 
 * @sharpen.ignore
 *
 */
public class CodeUtil {

	public static Code convertToCode(String codeAsString) {
		Code result = null; 
		if (StringUtils.isNotBlank(codeAsString)) {
			result = new TrivialCodeResolver().lookup(Code.class, codeAsString);
		}
		return result;
	}

}
