package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;

class PackageLocationMerger implements Merger<PackageLocation> {

	private final OutputUI outputUI;
	private MessageSetMergeHelper mergeHelper;
	private MessagePartMerger messagePartMerger;

	PackageLocationMerger(OutputUI outputUI) {
		this(outputUI, new MessagePartMerger(outputUI));
	}

	PackageLocationMerger(OutputUI outputUI, MessagePartMerger messagePartMerger) {
		this.outputUI = outputUI;
		this.messagePartMerger = messagePartMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public PackageLocation merge(PackageLocation primaryPackageLocation, String primaryVersion, PackageLocation secondaryPackageLocation, String secondaryVersion) {
		primaryPackageLocation = (PackageLocation) ObjectUtils.defaultIfNull(primaryPackageLocation, new PackageLocation());
		secondaryPackageLocation = (PackageLocation) ObjectUtils.defaultIfNull(secondaryPackageLocation, new PackageLocation());

		PackageLocation result = new PackageLocation();
		
		mergeCategory(result, primaryPackageLocation.getCategory(), secondaryPackageLocation.getCategory());
		mergeDescriptiveName(result, primaryPackageLocation.getDescriptiveName(), secondaryPackageLocation.getDescriptiveName());
		mergeName(result, primaryPackageLocation.getName(), secondaryPackageLocation.getName());
		mergeRootType(result, primaryPackageLocation.getRootType(), primaryVersion, secondaryPackageLocation.getRootType(), secondaryVersion);
		mergeMessageParts(result, primaryPackageLocation.getMessageParts(), primaryVersion, secondaryPackageLocation.getMessageParts(), secondaryVersion);
		
		return result;
	}

	private void mergeMessageParts(PackageLocation result, Map<String, MessagePart> messageParts, String primaryVersion, Map<String, MessagePart> messageParts2, String secondaryVersion) {
		Map<String, MessagePart> messageParts2copy = new HashMap<String, MessagePart>(messageParts2);
		
		for (String messagePartName : messageParts.keySet()) {
			MessagePart primaryMessagePart = messageParts.get(messagePartName);
			MessagePart secondaryMessagePart = messageParts2copy.remove(messagePartName);
			MessagePart mergedMessagePart = this.messagePartMerger.merge(primaryMessagePart, primaryVersion, secondaryMessagePart, secondaryVersion);
			result.getMessageParts().put(messagePartName, mergedMessagePart);
		}

		for (String messagePartName : messageParts2copy.keySet()) {
			MessagePart mergedMessagePart = this.messagePartMerger.merge(null, primaryVersion, messageParts2copy.get(messagePartName), secondaryVersion);
			result.getMessageParts().put(messagePartName, mergedMessagePart);
		}
	}

	private void mergeRootType(PackageLocation result, String rootType, String version1, String rootType2, String version2) {
		// FIXME - TM - what to do if root types are different?? is this an ok state?
		//            - have detected that this *does* happen in some cases
		if (rootType != null && rootType2 != null && !StringUtils.equals(rootType, rootType2)) {
			this.outputUI.log(LogLevel.ERROR, "Merging two package locations with different root types: " + rootType + " / " + rootType2);
			this.mergeHelper.addDifference(result, "rootType", rootType, version1, rootType2, version2);
		}
		String mergedRootType = this.mergeHelper.standardMerge(rootType, rootType2);
		result.setRootType(mergedRootType);
	}

	private void mergeName(PackageLocation result, String name, String name2) {
		// should not normally be merging package locations with different names
		if (name != null && name2 != null && !StringUtils.equals(name, name2)) {
			this.outputUI.log(LogLevel.ERROR, "Merging two package locations with different names: " + name + " / " + name2);
		}
		String mergedName = this.mergeHelper.standardMerge(name, name2);
		result.setName(mergedName);
	}

	private void mergeDescriptiveName(PackageLocation result, String descriptiveName, String descriptiveName2) {
		String mergedDescriptiveName = this.mergeHelper.standardMerge(descriptiveName, descriptiveName2);
		result.setDescriptiveName(mergedDescriptiveName);
	}

	private void mergeCategory(PackageLocation result, String category, String category2) {
		String mergedCategory = this.mergeHelper.standardMerge(category, category2);
		result.setCategory(mergedCategory);
	}

}
