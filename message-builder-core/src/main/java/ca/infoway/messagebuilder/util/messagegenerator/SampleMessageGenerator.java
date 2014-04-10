package ca.infoway.messagebuilder.util.messagegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.RenderMode;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.resolver.GenericCodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.GenericCodeResolverRegistryImpl;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.ChoiceOption;
import ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.ConformanceOption;
import ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.MultipleCardinalityOption;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

/**
 * @sharpen.ignore sample message generator is for MB Java only
 */
public class SampleMessageGenerator {
	
	private final Log log = LogFactory.getLog(SampleMessageGenerator.class);

	private class InteractionComparator implements Comparator<Interaction> {
		public int compare(Interaction o1, Interaction o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	
	private InteractionPopulatingUtility beanPopulatingUtility;
	private GenericCodeResolverRegistry tempRegistry;
	private MessageBeanTransformerImpl messageBeanTransformer;
	private MessageDefinitionService service;
	private InteractionComparator interactionComparator;
	
	public SampleMessageGenerator() {
		this(null);
	}
	
	public SampleMessageGenerator(DataTypeValueStore dataStore) {
		this.beanPopulatingUtility = new InteractionPopulatingUtility(dataStore);
		this.service = new MessageDefinitionServiceFactory().create();
		this.messageBeanTransformer = new MessageBeanTransformerImpl(RenderMode.PERMISSIVE);
		this.interactionComparator = new InteractionComparator();

		// don't want to blow away any registries already setup, so pass in a temporary registry
		this.tempRegistry = new GenericCodeResolverRegistryImpl();
		this.tempRegistry.register(new TrivialCodeResolver());
	}

	public String generateSampleMessage(String interactionId, VersionNumber version) {
		Interaction interaction = this.service.getInteraction(version, interactionId);
		return generateSampleMessage(false, interaction, version, null, null, null); 
	}
	
	public String generateSampleMessage(String interactionId, VersionNumber version, ConformanceOption conformanceOption, MultipleCardinalityOption cardinalityOption, ChoiceOption choiceOption) {
		Interaction interaction = this.service.getInteraction(version, interactionId);
		return generateSampleMessage(true, interaction, version, conformanceOption, cardinalityOption, choiceOption); 
	}

	/**
	 * Generate sample messages for all interactions for a given version. Default options will be used.
	 * 
	 * @param version
	 * @param directory
	 */
	public void generateSampleMessagesForAllInteractions(VersionNumber version, File directory) {
		generateSampleMessagesForAllInteractions(false, version, directory, null, null, null);
	}
	
	/**
	 * Generate sample messages for all interactions for a given version. Allows for specification of all options.
	 *  
	 * @param version
	 * @param directory
	 * @param conformanceOption
	 * @param cardinalityOption
	 * @param choiceOption
	 */
	public void generateSampleMessagesForAllInteractions(VersionNumber version, File directory, ConformanceOption conformanceOption, MultipleCardinalityOption cardinalityOption, ChoiceOption choiceOption) {
		generateSampleMessagesForAllInteractions(true, version, directory, conformanceOption, cardinalityOption, choiceOption);
	}

	private void generateSampleMessagesForAllInteractions(boolean includesOptions, VersionNumber version, File directory, ConformanceOption conformanceOption, MultipleCardinalityOption cardinalityOption, ChoiceOption choiceOption) {
		if (!directory.exists()) {
			if (!directory.mkdir()) {
				this.log.error("Could not create directory: " + directory.getName());
			}
		}
		if (directory.exists()) {
			if (directory.isDirectory()) {
				List<Interaction> allInteractions = this.service.getAllInteractions(version);
				Collections.sort(allInteractions, this.interactionComparator);
				for (Interaction interaction : allInteractions) {
					String interactionId = interaction.getName();
					String interactionName = interaction.getBusinessName();
					this.log.error("Generating sample message for: " + interactionId + " (" + interactionName + ")");
					String xml = generateSampleMessage(includesOptions, interaction, version, conformanceOption, cardinalityOption, choiceOption);
					if (StringUtils.isNotBlank(xml)) {
						String fileName = interactionId + "_" + interactionName.replaceAll("[^a-zA-Z]", "_") + ".xml";
						writeToFile(new File(directory, fileName), xml);
					}
				}
			} else {
				this.log.error("File parameter must be a directory: " + directory.getName());
			}
		}
	}

	private String generateSampleMessage(boolean includesOptions, Interaction interaction, VersionNumber version, ConformanceOption conformanceOption, MultipleCardinalityOption cardinalityOption, ChoiceOption choiceOption) {
		InteractionBean populatedInteractionBean = null;
		try {
			if (includesOptions) {
				populatedInteractionBean = this.beanPopulatingUtility.createAndPopulateInteraction(interaction.getName(), version, conformanceOption, cardinalityOption, choiceOption);
			} else {
				populatedInteractionBean = this.beanPopulatingUtility.createAndPopulateInteraction(interaction.getName(), version);
			}
		} catch (Exception e) {
			this.log.error("Exception encountered trying to create and populate interaction: " + interaction.getName(), e);
		}
		
		String sampleMessage = null;
		try {
			if (populatedInteractionBean != null) {
				sampleMessage = this.messageBeanTransformer.transformToHl7(version, populatedInteractionBean, this.tempRegistry).getXmlMessage();
			}
		} catch (Exception e) {
			this.log.error("Exception encountered trying to create xml message from populated interaction: " + interaction.getName(), e);
		}
		
		return sampleMessage;
	}
	
	private void writeToFile(File file, String xml) {
		FileWriter output = null;
		try {
			output = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write(xml);
		} catch (Exception e) {
			this.log.error("Unable to write xml to file", e);
		} finally {
			IOUtils.closeQuietly(output);
		}
	}
}
