package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

class MessageSetMerger implements Merger<MessageSet> {

	private final OutputUI outputUI;
	private final MessageSet resultMessageSet;
	private MessageSetMergeHelper mergeHelper = new MessageSetMergeHelper();
	private PackageLocationMerger packageLocationMerger;
	private InteractionMerger interactionMerger;

	MessageSetMerger(OutputUI outputUI, MessageSet resultMessageSet) {
		this(outputUI, resultMessageSet, new PackageLocationMerger(outputUI), new InteractionMerger(outputUI));
	}

	MessageSetMerger(OutputUI outputUI, MessageSet resultMessageSet, PackageLocationMerger packageLocationMerger, InteractionMerger interactionMerger) {
		this.outputUI = outputUI;
		this.packageLocationMerger = packageLocationMerger;
		this.interactionMerger = interactionMerger;
		this.resultMessageSet = resultMessageSet;
	}

	public MessageSet merge(MessageSet primaryMessageSet, String primaryVersion, MessageSet secondaryMessageSet, String secondaryVersion) {
		primaryMessageSet = (MessageSet) ObjectUtils.defaultIfNull(primaryMessageSet, new MessageSet());
		secondaryMessageSet = (MessageSet) ObjectUtils.defaultIfNull(secondaryMessageSet, new MessageSet());
		
		// leave "version" as is on result messageset
		mergeComponent(primaryMessageSet.getComponent(), secondaryMessageSet.getComponent());
		mergeInteractions(primaryMessageSet, secondaryMessageSet);
		mergePackageLocations(primaryMessageSet.getPackageLocations(), primaryVersion, secondaryMessageSet.getPackageLocations(), secondaryVersion);
		
		return this.resultMessageSet;
	}

	private void mergePackageLocations(Map<String, PackageLocation> packageLocations, String primaryVersion, Map<String, PackageLocation> packageLocations2, String secondaryVersion) {
		Map<String, PackageLocation> packageLocations2copy = new HashMap<String, PackageLocation>(packageLocations2);
		
		for (String packageLocationName : packageLocations.keySet()) {
			PackageLocation primaryPackageLocation = packageLocations.get(packageLocationName);
			PackageLocation secondaryPackageLocation = packageLocations2copy.remove(packageLocationName);
			PackageLocation mergedPackageLocation = this.packageLocationMerger.merge(primaryPackageLocation, primaryVersion, secondaryPackageLocation, secondaryVersion);
			this.resultMessageSet.getPackageLocations().put(packageLocationName, mergedPackageLocation);
		}

		for (String packageLocationName : packageLocations2copy.keySet()) {
			PackageLocation mergedPackageLocation = this.packageLocationMerger.merge(null, primaryVersion, packageLocations2copy.get(packageLocationName), secondaryVersion);
			this.resultMessageSet.getPackageLocations().put(packageLocationName, mergedPackageLocation);
		}
	}

	private void mergeInteractions(MessageSet primaryMessageSet, MessageSet secondaryMessageSet) {

		String primaryVersion = primaryMessageSet.getVersion();
		String secondaryVersion = secondaryMessageSet.getVersion();
		
		Map<String, Interaction> interactions2copy = new HashMap<String, Interaction>(secondaryMessageSet.getInteractions());
		
		for (String interactionName : primaryMessageSet.getInteractions().keySet()) {
			Interaction primaryInteraction = primaryMessageSet.getInteractions().get(interactionName);
			Interaction secondaryInteraction = interactions2copy.remove(interactionName);
			Interaction mergedInteraction = this.interactionMerger.merge(primaryInteraction, primaryVersion, secondaryInteraction, secondaryVersion);
			this.resultMessageSet.getInteractions().put(interactionName, mergedInteraction);
		}

		for (String interactionName : interactions2copy.keySet()) {
			Interaction mergedInteraction = this.interactionMerger.merge(null, primaryVersion, interactions2copy.get(interactionName), secondaryVersion);
			this.resultMessageSet.getInteractions().put(interactionName, mergedInteraction);
		}
	}

	private void mergeComponent(String component, String component2) {
		String mergedComponent = this.mergeHelper.standardMerge(component, component2);
		this.resultMessageSet.setComponent(mergedComponent);
	}

}
