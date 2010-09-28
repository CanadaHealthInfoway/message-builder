package ca.infoway.messagebuilder.generator.multiplemessageset;

interface Merger<T> {

	T merge(T primary, String primaryVersion, T secondary, String secondaryVersion);
	
}
