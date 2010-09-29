package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;

class MergeContextImpl implements MergeContext {

	private OutputUI outputUI;
	private String currentInteraction;
	private String currentPackageLocation;
	private String primaryVersion;
	private String secondaryVersion;

	MergeContextImpl(OutputUI outputUI, String primaryVersion, String secondaryVersion) {
		this.outputUI = outputUI;
		this.primaryVersion = primaryVersion;
		this.secondaryVersion = secondaryVersion;
	}
	
	public String getCurrentInteraction() {
		return this.currentInteraction;
	}

	public String getCurrentPackageLocation() {
		return this.currentPackageLocation;
	}

	public String getPrimaryVersion() {
		return this.primaryVersion;
	}

	public String getSecondaryVersion() {
		return this.secondaryVersion;
	}

	public void logError(String error) {
		this.outputUI.log(LogLevel.ERROR, error);
	}

	public void setCurrentInteraction(String interaction) {
		this.currentInteraction = interaction;
	}

	public void setCurrentPackageLocation(String packageLocation) {
		this.currentPackageLocation = packageLocation;
	}

}
