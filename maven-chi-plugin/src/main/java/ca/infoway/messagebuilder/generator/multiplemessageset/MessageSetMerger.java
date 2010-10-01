package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

class MessageSetMerger implements Merger<MessageSet> {

	private MessageSet result;
	private MessageSetMergeHelper mergeHelper = new MessageSetMergeHelper();
	private PackageLocationMerger packageLocationMerger;
	private InteractionMerger interactionMerger;
	private final MergeContext context;

	MessageSetMerger(MergeContext context) {
		this(context, new PackageLocationMerger(context), new InteractionMerger(context));
	}

	MessageSetMerger(MergeContext context, PackageLocationMerger packageLocationMerger, InteractionMerger interactionMerger) {
		this.context = context;
		this.packageLocationMerger = packageLocationMerger;
		this.interactionMerger = interactionMerger;
	}

	public MessageSet merge(MessageSet primaryMessageSet, MessageSet secondaryMessageSet) {
		
		if (primaryMessageSet == null || secondaryMessageSet == null) {
			this.result = (secondaryMessageSet == null ? primaryMessageSet : secondaryMessageSet);
		} else {
			this.result = new MessageSet();
			// leave "version" as is on result messageset
			mergeComponent(primaryMessageSet.getComponent(), secondaryMessageSet.getComponent());
			mergeInteractions(primaryMessageSet, secondaryMessageSet);
			mergePackageLocations(primaryMessageSet.getPackageLocations(), secondaryMessageSet.getPackageLocations());
		}
		
		return this.result;
	}

	private void mergePackageLocations(Map<String, PackageLocation> packageLocations, Map<String, PackageLocation> packageLocations2) {
		Map<String, PackageLocation> packageLocations2copy = new HashMap<String, PackageLocation>(packageLocations2);
		
		for (String packageLocationName : packageLocations.keySet()) {
			PackageLocation primaryPackageLocation = packageLocations.get(packageLocationName);
			PackageLocation secondaryPackageLocation = packageLocations2copy.remove(packageLocationName);
			this.context.setCurrentPackageLocation(packageLocationName);
			PackageLocation mergedPackageLocation = this.packageLocationMerger.merge(primaryPackageLocation, secondaryPackageLocation);
			this.result.getPackageLocations().put(packageLocationName, mergedPackageLocation);
		}

		for (String packageLocationName : packageLocations2copy.keySet()) {
			this.context.setCurrentPackageLocation(packageLocationName);
			PackageLocation mergedPackageLocation = this.packageLocationMerger.merge(null, packageLocations2copy.get(packageLocationName));
			this.result.getPackageLocations().put(packageLocationName, mergedPackageLocation);
		}
	}

	private void mergeInteractions(MessageSet primaryMessageSet, MessageSet secondaryMessageSet) {

		Map<String, Interaction> interactions2copy = new HashMap<String, Interaction>(secondaryMessageSet.getInteractions());
		
		for (String interactionName : primaryMessageSet.getInteractions().keySet()) {
			Interaction primaryInteraction = primaryMessageSet.getInteractions().get(interactionName);
			Interaction secondaryInteraction = interactions2copy.remove(interactionName);
			this.context.setCurrentInteraction(interactionName);
			Interaction mergedInteraction = this.interactionMerger.merge(primaryInteraction, secondaryInteraction);
			this.result.getInteractions().put(interactionName, mergedInteraction);
		}

		for (String interactionName : interactions2copy.keySet()) {
			this.context.setCurrentInteraction(interactionName);
			Interaction mergedInteraction = this.interactionMerger.merge(null, interactions2copy.get(interactionName));
			this.result.getInteractions().put(interactionName, mergedInteraction);
		}
	}

	private void mergeComponent(String component, String component2) {
		String mergedComponent = this.mergeHelper.standardMerge(component, component2);
		this.result.setComponent(mergedComponent);
	}

}
