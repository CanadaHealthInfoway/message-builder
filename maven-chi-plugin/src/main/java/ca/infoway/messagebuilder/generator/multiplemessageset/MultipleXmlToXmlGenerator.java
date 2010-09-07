package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.MessageSetGenerator;
import ca.infoway.messagebuilder.generator.MessageSetWriter;
import ca.infoway.messagebuilder.generator.MifSource;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

public class MultipleXmlToXmlGenerator implements MessageSetGenerator {

	private MessageSetMarshaller messageSetMarshaller;
	private MessageSet messageSet = new MessageSet();
	private OutputUI outputUI;
	private MessageSetWriter messageSetWriter;
	
	public MultipleXmlToXmlGenerator(OutputUI outputUI, String version) {
		this.outputUI = outputUI;
		this.messageSet.setVersion(version);
		this.messageSetMarshaller = new MessageSetMarshaller();
		this.messageSetWriter = new MessageSetWriter(this.messageSet, this.outputUI);
	}
	
	protected MultipleXmlToXmlGenerator(OutputUI outputUI, String version, MessageSetMarshaller messageSetMarshaller, MessageSetWriter messageSetWriter) {
		this.outputUI = outputUI;
		this.messageSet.setVersion(version);
		this.messageSetMarshaller = messageSetMarshaller;
		this.messageSetWriter = messageSetWriter;
		
	}

	public void processAllMessageSets(List<File> inputMessageSets) throws GeneratorException {
		List<MessageSet> messageSets = convertFilesToMessageSets(inputMessageSets);
		
		// FIXME - do merge here
		
	}
	
	public void writeToMessageSet(File outputFile) throws GeneratorException, IOException {
		this.messageSetWriter.writeToMessageSet(outputFile);
	}

	public void processAllMifs(MifSource mifSource) throws GeneratorException, IOException {
		throw new UnsupportedOperationException("Must use processAllMessageSets() method instead.");
	}
	
	private List<MessageSet> convertFilesToMessageSets(List<File> inputMessageSetFiles) throws GeneratorException {
		ArrayList<MessageSet> result = new ArrayList<MessageSet>();
		for (File file : inputMessageSetFiles) {
			result.add(convertFileToMessageSet(file));
		}
		return result;
	}

	private MessageSet convertFileToMessageSet(File file) throws GeneratorException {
		try {
			return this.messageSetMarshaller.unmarshall(file);
		} catch (Exception e) {
			String filename = (file == null ? "null file" : file.getName());
			throw new GeneratorException("Exception trying to unmarshall input XML messageset:" + filename, e);
		}
	}

}
