package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.PackageLocation;

class PackageLocationMerger {

	private final OutputUI outputUI;

	PackageLocationMerger(OutputUI outputUI) {
		this.outputUI = outputUI;
	}

	PackageLocation merge(PackageLocation primaryPackageLocation, PackageLocation secondaryPackageLocation) {
		return primaryPackageLocation;
	}

}
