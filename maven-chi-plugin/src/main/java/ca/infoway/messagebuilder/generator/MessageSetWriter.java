package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.LogLevel.INFO;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

public class MessageSetWriter {

	private final MessageSet messageSet;
	private final OutputUI outputUI;

	public MessageSetWriter(MessageSet messageSet, OutputUI outputUI) {
		this.messageSet = messageSet;
		this.outputUI = outputUI;
	}
	
	public void writeToMessageSet(File outputFile) throws GeneratorException, IOException {
		if (outputFile == null) {
			throw new IllegalArgumentException("output file must not be null");
		} else if (outputFile.exists() && outputFile.isDirectory()) {
			throw new IllegalArgumentException("The output location cannot be a directory");
		} else {
			try {
				
				for (Interaction interaction : this.messageSet.getInteractions().values()) {
					for (Argument argument : interaction.getArguments()) {
						if (StringUtils.isBlank(argument.getName())) {
							System.out.println(interaction.getName() + " has blank argument name1");
						}
						for (Argument argument2 : argument.getArguments()) {
							if (StringUtils.isBlank(argument2.getName())) {
								System.out.println(interaction.getName() + " has blank argument name2");
							}
							for (Argument argument3 : argument2.getArguments()) {
								if (StringUtils.isBlank(argument3.getName())) {
									System.out.println(interaction.getName() + " has blank argument name3");
								}
							}
						}
					}
				}
				
				for (PackageLocation packageLocation : this.messageSet.getPackageLocations().values()) {
					for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
						for (Relationship relationship : messagePart.getRelationships()) {
							if (StringUtils.isBlank(relationship.getName())) {
								System.out.println(packageLocation.getName());
								System.out.println(messagePart.getName());
								System.out.println("empty name for relationship");
							}
							
						}
					}
				}
				new MessageSetMarshaller().marshall(this.messageSet, outputFile);
				
				this.outputUI.log(INFO, "The message set has been written to \"" + outputFile + "\"");
			} catch (IOException e) {
				throw e;
			} catch (Exception e) {
				throw new GeneratorException(e);
			}
		}
	}
	
}
