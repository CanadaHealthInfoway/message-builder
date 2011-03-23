package ca.infoway.messagebuilder.acceptance.runner.datatype;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestResultCallback;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestRunner;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterRegistry;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserRegistry;

public class DataTypeAcceptanceTestRunner implements AcceptanceTestRunner {
	
	private final String name;
	
	private final ParserRegistry parserRegistry = ParserRegistry.getInstance();
	private final FormatterRegistry formatterRegistry = FormatterRegistry.getInstance();

	private final List<String> chiDataTypes;
	
	public DataTypeAcceptanceTestRunner(String name, List<String> chiDataTypes) {
		this.name = name;
		this.chiDataTypes = chiDataTypes;
	}

	public void run(AcceptanceTestResultCallback resultCallback) {
		List<String> messages = new ArrayList<String>();
		int supportedCount = 0;
		for (String dataType : this.chiDataTypes) {
			if (dataTypeFullySupported(dataType)) {
				supportedCount++;
			} else {
				messages.add("Data type " + dataType + " not supported.");
			}
		}
		
		resultCallback.done(
				this.name, 
				supportedCount,
				chiDataTypes.size(),
				messages);
	}

	private boolean dataTypeFullySupported(String dataType) {
		return parserRegistry.get(dataType) != null && formatterRegistry.get(dataType) != null;
	}

}
