package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

import com.google.common.base.Supplier;

public class CodedValueXmlFormatter extends AbstractCodedTypeXmlFormatter {
	
	public CodedValueXmlFormatter(FormatterConfiguration configuration) {
		super(configuration, new Supplier<CD>() {
			public CD get() {
				return new CVImpl();
			}
		});
	}
	
	@Override
	public CV format(FormatContext formatContext, Element value) throws FormatterException {
		return (CV) super.format(formatContext, value);
	}

}
