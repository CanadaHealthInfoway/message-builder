package ca.infoway.messagebuilder.simple.xml.formatter;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

import com.google.common.base.Supplier;

public class SimpleCodedTypeXmlFormatter extends AbstractCodedTypeXmlFormatter {
	
	protected SimpleCodedTypeXmlFormatter(FormatterConfiguration configuration) {
		super(configuration, new Supplier<CD>() {
			public CD get() {
				return new CSImpl();
			}
		});
	}

	@Override
	public CS format(FormatContext formatContext, Element value) throws FormatterException {
		CS result = (CS) super.format(formatContext, value);
		return result;
	}

	@Override
	protected Code parseCode(FormatContext formatContext, Class<? extends Code> codeType, Element element) throws FormatterException {
		Code code = null;
		if (StringUtils.isBlank(getCodeValue(element))) {
			processError(formatContext, "No code provided", element);
		} else {
			code = super.parseCode(formatContext, codeType, element);
		}
		return code;
	}

	//	private Code parseCode(String code, Class<? extends Code> returnType, Element value, FormatContext formatContext) throws FormatterException {
//	}
//		Code result = null;
//		
//		if (StringUtils.isBlank(code)) {
//			processError(formatContext, "No code provided", value);
//		} else {
//			result = CodeResolverRegistry.lookup(returnType, code);
//	        if (result == null) {
//				processError(formatContext, "Code not found [" + code + "]", value);
//	        }
//		}
//		
//		return result;
//	}
}
