package ca.infoway.messagebuilder.generator.multiplemessageset;

interface MergeContext {
	
	public void logError(String error);
	public void logInfo(String info);
	public String getPrimaryVersion();
	public String getSecondaryVersion();
	public String getCurrentInteraction();
	public void setCurrentInteraction(String interaction);
	public String getCurrentPackageLocation();
	public void setCurrentPackageLocation(String packageLocation);
	public String getCurrentMessagePart();
	public void setCurrentMessagePart(String messagePart);

}
