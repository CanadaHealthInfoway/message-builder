package ca.infoway.messagebuilder.tools;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

public class OrphanedMessagePartFinder {
	
	public static void main(String[] args) {
		// For the following to work you need to ensure your project references both this project/jar (maven-chi-plugin) and the project/jar API
		// to be searched.
		LogManager.getRootLogger().setLevel(Level.INFO);
		new OrphanedMessagePartFinder().findAndDisplayAllOrphanedMessageParts(SpecificationVersion.R02_04_03);
	}

	private final Log log = LogFactory.getLog(OrphanedMessagePartFinder.class);

	private final MessageDefinitionService msgService = new MessageDefinitionServiceFactory().create();

	public Map<String, MessagePart> findAndDisplayAllOrphanedMessageParts(VersionNumber version) {

		Set<String> uniquePackages = new TreeSet<String>();
		Map<String, MessagePart> allOrphanedMessageParts = findAllOrphanedMessageParts(version, true);
		log.info("All orphaned message parts for " + version.getVersionLiteral() + ":\n");
		for (String messagePartName : allOrphanedMessageParts.keySet()) {
			log.info(messagePartName);
			uniquePackages.add(messagePartName.substring(0, messagePartName.indexOf('.')));
		}
		log.info("\n");
		log.info(">>>>>>>>>>>>>>>>>>>>>>\n");
		log.info("Orphaned packages for " + version.getVersionLiteral() + ":\n");
		for (String packageLocation : uniquePackages) {
			log.info(packageLocation);
		}
		return allOrphanedMessageParts;
	}
	
	public Map<String, MessagePart> findAllOrphanedMessageParts(VersionNumber version) {
		return findAllOrphanedMessageParts(version, false);
	}
	
	private Map<String, MessagePart> findAllOrphanedMessageParts(VersionNumber version, boolean logMessages) {
		Map<String, MessagePart> orphanedMessageParts = new TreeMap<String, MessagePart>();
		Collection<MessagePart> _allMessageParts = msgService.getAllMessageParts(version);
		if (logMessages) log.info("Number of parts found for " + version.getVersionLiteral() + ": " + _allMessageParts.size());
		for (MessagePart messagePart : _allMessageParts) {
			log.debug("Checking part: " + messagePart.getName());
			if (!messagePart.isTemplateParameter()) {
				orphanedMessageParts.put(messagePart.getName(), messagePart);
			} else {
				log.debug(">>>> template: " + messagePart.getName());
			}
		}
		
		Map<String, MessagePart> allReferencedMessageParts = new HashMap<String, MessagePart>();
		List<Interaction> allInteractions = msgService.getAllInteractions(version);
		if (logMessages) log.info("Number of interactions found for " + version.getVersionLiteral() + ": " + allInteractions.size());
		for (Interaction interaction : allInteractions) {
			log.debug(interaction.getName() + " " + interaction.getBusinessName());
			Map<String, MessagePart> allMessagePartsReferencedByInteraction = msgService.getAllMessageParts(interaction, version);
			allReferencedMessageParts.putAll(allMessagePartsReferencedByInteraction);
		}
		
		for (String messagePartName : allReferencedMessageParts.keySet()) {
			orphanedMessageParts.remove(messagePartName);
		}
		
		if (logMessages) log.info("Number of parts orphaned for version: " + orphanedMessageParts.size() + "\n");
		
		return orphanedMessageParts;
	}
		

}

