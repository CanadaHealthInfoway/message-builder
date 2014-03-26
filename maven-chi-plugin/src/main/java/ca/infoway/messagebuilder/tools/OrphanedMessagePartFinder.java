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

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.util.MessageSetUtils;

public class OrphanedMessagePartFinder {
	
	// Note: To see any logging you need to ensure an appropriate log level is set (INFO or DEBUG)
	// LogManager.getRootLogger().setLevel(Level.INFO);

	private final Log log = LogFactory.getLog(OrphanedMessagePartFinder.class);

	private final MessageSet messageSet;
	private final MessageSetUtils messageSetUtils;

	public OrphanedMessagePartFinder(MessageSet messageSet) {
		this.messageSet = messageSet;
		this.messageSetUtils = new MessageSetUtils(messageSet);
	}
	
	public Map<String, MessagePart> findAndDisplayAllOrphanedMessageParts() {

		Set<String> uniquePackages = new TreeSet<String>();
		Map<String, MessagePart> allOrphanedMessageParts = findAllOrphanedMessageParts();
		log.info("All orphaned message parts for " + getVersion() + ":\n");
		for (String messagePartName : allOrphanedMessageParts.keySet()) {
			log.info(messagePartName);
			uniquePackages.add(messagePartName.substring(0, messagePartName.indexOf('.')));
		}
		log.info("\n");
		log.info(">>>>>>>>>>>>>>>>>>>>>>\n");
		log.info("Orphaned packages for " + getVersion() + ":\n");
		for (String packageLocation : uniquePackages) {
			log.info(packageLocation);
		}
		return allOrphanedMessageParts;
	}
	
	public Map<String, MessagePart> findAllOrphanedMessageParts() {
		Map<String, MessagePart> orphanedMessageParts = new TreeMap<String, MessagePart>();
		Collection<MessagePart> _allMessageParts = this.messageSet.getAllMessageParts();
		log.info("Number of parts found for " + getVersion() + ": " + _allMessageParts.size());
		for (MessagePart messagePart : _allMessageParts) {
			log.debug("Checking part: " + messagePart.getName());
			if (!messagePart.isTemplateParameter()) {
				orphanedMessageParts.put(messagePart.getName(), messagePart);
			} else {
				log.debug(">>>> template: " + messagePart.getName());
			}
		}
		
		Map<String, MessagePart> allReferencedMessageParts = new HashMap<String, MessagePart>();
		List<Interaction> allInteractions = this.messageSetUtils.getAllInteractions();
		log.info("Number of interactions found for " + getVersion() + ": " + allInteractions.size());
		for (Interaction interaction : allInteractions) {
			log.debug(interaction.getName() + " " + interaction.getBusinessName());
			Map<String, MessagePart> allMessagePartsReferencedByInteraction = this.messageSetUtils.getAllMessageParts(interaction);
			allReferencedMessageParts.putAll(allMessagePartsReferencedByInteraction);
		}
		
		for (String messagePartName : allReferencedMessageParts.keySet()) {
			orphanedMessageParts.remove(messagePartName);
		}
		
		log.info("Number of parts orphaned for version: " + orphanedMessageParts.size() + "\n");
		
		return orphanedMessageParts;
	}

	private String getVersion() {
		return this.messageSet.getVersion();
	}
		
}
