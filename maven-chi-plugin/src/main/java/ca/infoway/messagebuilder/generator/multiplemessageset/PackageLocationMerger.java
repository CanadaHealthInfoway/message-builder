package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.PackageLocation;

class PackageLocationMerger implements Merger<PackageLocation> {

	private final OutputUI outputUI;
	private MessageSetMergeHelper mergeHelper;

	PackageLocationMerger(OutputUI outputUI) {
		this.outputUI = outputUI;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public PackageLocation merge(PackageLocation primaryPackageLocation, PackageLocation secondaryPackageLocation) {
		// FIXME TM - need to implement this for a later story
		return (PackageLocation) this.mergeHelper.standardMerge(primaryPackageLocation, secondaryPackageLocation);
	}

}
