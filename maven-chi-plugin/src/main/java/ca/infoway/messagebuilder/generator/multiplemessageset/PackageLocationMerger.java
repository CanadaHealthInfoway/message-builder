package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;

class PackageLocationMerger implements Merger<PackageLocation> {

	private MessageSetMergeHelper mergeHelper;
	private MessagePartMerger messagePartMerger;
	private PackageLocation result;
	private final MergeContext context;

	PackageLocationMerger(MergeContext context) {
		this(context, new MessagePartMerger(context));
	}

	PackageLocationMerger(MergeContext context, MessagePartMerger messagePartMerger) {
		this.context = context;
		this.messagePartMerger = messagePartMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public PackageLocation merge(PackageLocation primaryPackageLocation, PackageLocation secondaryPackageLocation) {
		primaryPackageLocation = (PackageLocation) ObjectUtils.defaultIfNull(primaryPackageLocation, new PackageLocation());
		secondaryPackageLocation = (PackageLocation) ObjectUtils.defaultIfNull(secondaryPackageLocation, new PackageLocation());

		this.result = new PackageLocation();
		
		mergeCategory(primaryPackageLocation.getCategory(), secondaryPackageLocation.getCategory());
		mergeDescriptiveName(primaryPackageLocation.getDescriptiveName(), secondaryPackageLocation.getDescriptiveName());
		mergeName(primaryPackageLocation.getName(), secondaryPackageLocation.getName());
		mergeRootType(primaryPackageLocation.getRootType(), secondaryPackageLocation.getRootType());
		mergeMessageParts(primaryPackageLocation.getMessageParts(), secondaryPackageLocation.getMessageParts());
		
		return this.result;
	}

	private void mergeMessageParts(Map<String, MessagePart> messageParts, Map<String, MessagePart> messageParts2) {
		Map<String, MessagePart> messageParts2copy = new HashMap<String, MessagePart>(messageParts2);
		
		for (String messagePartName : messageParts.keySet()) {
			MessagePart primaryMessagePart = messageParts.get(messagePartName);
			MessagePart secondaryMessagePart = messageParts2copy.remove(messagePartName);
			MessagePart mergedMessagePart = this.messagePartMerger.merge(primaryMessagePart, secondaryMessagePart);
			this.result.getMessageParts().put(messagePartName, mergedMessagePart);
		}

		for (String messagePartName : messageParts2copy.keySet()) {
			MessagePart mergedMessagePart = this.messagePartMerger.merge(null, messageParts2copy.get(messagePartName));
			this.result.getMessageParts().put(messagePartName, mergedMessagePart);
		}
	}

	private void mergeRootType(String rootType, String rootType2) {
		// FIXME - TM - what to do if root types are different?? is this an ok state?
		//            - have detected that this *does* happen in some cases
		if (rootType != null && rootType2 != null && !StringUtils.equals(rootType, rootType2)) {
			this.context.logError("Merging two package locations with different root types: " + rootType + " / " + rootType2);
			this.mergeHelper.addDifference(this.context, this.result, "rootType", rootType, rootType2);
		}
		String mergedRootType = this.mergeHelper.standardMerge(rootType, rootType2);
		this.result.setRootType(mergedRootType);
	}

	private void mergeName(String name, String name2) {
		// should not normally be merging package locations with different names
		if (name != null && name2 != null && !StringUtils.equals(name, name2)) {
			this.context.logError("Merging two package locations with different names: " + name + " / " + name2);
		}
		String mergedName = this.mergeHelper.standardMerge(name, name2);
		this.result.setName(mergedName);
	}

	private void mergeDescriptiveName(String descriptiveName, String descriptiveName2) {
		String mergedDescriptiveName = this.mergeHelper.standardMerge(descriptiveName, descriptiveName2);
		this.result.setDescriptiveName(mergedDescriptiveName);
	}

	private void mergeCategory(String category, String category2) {
		String mergedCategory = this.mergeHelper.standardMerge(category, category2);
		this.result.setCategory(mergedCategory);
	}

}
