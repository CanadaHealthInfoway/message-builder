package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

class MessageSetMerger {

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

	void merge(MessageSet primaryMessageSet, MessageSet secondaryMessageSet) {
		primaryMessageSet = (MessageSet) ObjectUtils.defaultIfNull(primaryMessageSet, new MessageSet());
		secondaryMessageSet = (MessageSet) ObjectUtils.defaultIfNull(secondaryMessageSet, new MessageSet());
		
		// leave "version" as is on result messageset
		mergeComponent(primaryMessageSet.getComponent(), secondaryMessageSet.getComponent());
		mergeInteractions(primaryMessageSet.getInteractions(), secondaryMessageSet.getInteractions());
		mergePackageLocations(primaryMessageSet.getPackageLocations(), secondaryMessageSet.getPackageLocations());
	}

	private void mergePackageLocations(Map<String, PackageLocation> packageLocations, Map<String, PackageLocation> packageLocations2) {
		Map<String, PackageLocation> packageLocations2copy = new HashMap<String, PackageLocation>(packageLocations2);
		
		for (String packageLocationName : packageLocations.keySet()) {
			PackageLocation primaryPackageLocation = packageLocations.get(packageLocationName);
			PackageLocation secondaryPackageLocation = packageLocations2copy.remove(packageLocationName);
			PackageLocation mergedPackageLocation = this.packageLocationMerger.merge(primaryPackageLocation, secondaryPackageLocation);
			this.resultMessageSet.getPackageLocations().put(packageLocationName, mergedPackageLocation);
		}

		for (String packageLocationName : packageLocations2copy.keySet()) {
			PackageLocation mergedPackageLocation = this.packageLocationMerger.merge(null, packageLocations2copy.get(packageLocationName));
			this.resultMessageSet.getPackageLocations().put(packageLocationName, mergedPackageLocation);
		}
	}

	private void mergeInteractions(Map<String, Interaction> interactions, Map<String, Interaction> interactions2) {
		Map<String, Interaction> interactions2copy = new HashMap<String, Interaction>(interactions2);
		
		for (String interactionName : interactions.keySet()) {
			Interaction primaryInteraction = interactions.get(interactionName);
			Interaction secondaryInteraction = interactions2copy.remove(interactionName);
			Interaction mergedInteraction = this.interactionMerger.merge(primaryInteraction, secondaryInteraction);
			this.resultMessageSet.getInteractions().put(interactionName, mergedInteraction);
		}

		for (String interactionName : interactions2copy.keySet()) {
			Interaction mergedInteraction = this.interactionMerger.merge(null, interactions2copy.get(interactionName));
			this.resultMessageSet.getInteractions().put(interactionName, mergedInteraction);
		}
	}

	private void mergeComponent(String component, String component2) {
		String mergedComponent = this.mergeHelper.standardMerge(component, component2);
		this.resultMessageSet.setComponent(mergedComponent);
	}

}
