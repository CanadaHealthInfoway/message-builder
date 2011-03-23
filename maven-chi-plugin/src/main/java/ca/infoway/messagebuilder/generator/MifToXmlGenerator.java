package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.LogLevel.INFO;
import static ca.infoway.messagebuilder.generator.LogLevel.WARN;
import static org.apache.commons.io.FilenameUtils.getExtension;
import static org.apache.commons.lang.StringUtils.equalsIgnoreCase;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

public class MifToXmlGenerator implements MessageSetGenerator {
	
	private final OutputUI outputUI;
	private MessageSet messageSet = new MessageSet();
	private MifProcessor processor;
	private MifRegistry mifRegistry;

	public MifToXmlGenerator(OutputUI outputUI, String version, File mifTransform) throws GeneratorException {
		this.outputUI = outputUI;
		this.mifRegistry = new MifRegistry(mifTransform, outputUI);
		this.messageSet.setVersion(version);
	}
	
	
	MifProcessor getMifProcessor() throws GeneratorException {
		if (this.processor != null) {
		} else if (this.mifRegistry.isMif1()) {
			this.processor = new Mif1Processor(this.mifRegistry, this.outputUI);
		} else if (this.mifRegistry.isMif2()) {
			this.processor = new Mif2Processor(this.mifRegistry, this.outputUI);
		} else {
			throw new GeneratorException("Cannot determine the MIF processor type.  Are the MIF files valid?");
		}
		return this.processor;
	}

	public void processAllMifs(MifSource mifSource) throws GeneratorException, IOException {
		initializeVersionAndProcessEachFile(mifSource.getAllMifs());
	}	


	void initializeVersionAndProcessEachFile(List<MifReference> allMifs) throws IOException, GeneratorException {
		if (!CollectionUtils.isEmpty(allMifs)) {
			initializeMifVersionInformation(allMifs);
			processAllMifs(allMifs);
		} else {
			this.outputUI.log(WARN, "No .mif files were found in the directory.");
		}
	}

	/**
	 * <p>Determine the version information of the MIFs being processed.
	 * <p>By reading in one of the MIF files, we can inspect what MIF version is being
	 * used.
	 * 
	 * @param allMifs - the list of all MIF files being processed.
	 * @throws IOException
	 * @throws GeneratorException
	 */
	void initializeMifVersionInformation(List<MifReference> allMifs) throws IOException, GeneratorException {
		this.mifRegistry.getMif(getFirstMifFile(allMifs));
		this.outputUI.log(INFO, "Processing MIF files using schema version " + this.mifRegistry.getMifVersion());
	}


	MifReference getFirstMifFile(List<MifReference> allMifs) {
		MifReference result = null;
		for (MifReference reference : allMifs) {
			if (equalsIgnoreCase("mif", getExtension(reference.asFile().getName())) 
					&& !isInteraction(reference)) {
				result = reference;
				break;
			}
		}
		return result;
	}
	
	private boolean isInteraction(MifReference reference) {
		return PackageLocationDeriver.derive(reference.asFile()).isInteraction();
	}

	public void processAllMifs(List<MifReference> mifs) throws GeneratorException, IOException {
		this.outputUI.log(INFO, "Now processing " + CollectionUtils.size(mifs) + " MIF files.");
		try {
			getMifProcessor().addMessagePartsFromMifs(this.messageSet, mifs);
		} catch (XPathExpressionException e) {
			throw new GeneratorException(e);
		}
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
