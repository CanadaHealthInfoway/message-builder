package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.xml.MessagePart;

class SimplifiableType implements Named {

	private List<SimplifiableRelationship> relationships = Collections.synchronizedList(new ArrayList<SimplifiableRelationship>());
	private boolean inlined;
	private List<SimplifiableType> mergedWithTypes = Collections.synchronizedList(new ArrayList<SimplifiableType>());
	private final MessagePart messagePart;
	private final boolean rootType;

	public SimplifiableType(MessagePart messagePart, boolean rootType) {
		this.messagePart = messagePart;
		this.rootType = rootType;
	}
	
	public boolean isInlined() {
		return this.inlined;
	}

	public List<SimplifiableType> getMergedWithTypes() {
		return this.mergedWithTypes;
	}

	public List<SimplifiableRelationship> getRelationships() {
		return this.relationships;
	}

	public MessagePart getMessagePart() {
		return this.messagePart;
	}

	public boolean isRootType() {
		return this.rootType;
	}

	public boolean isMerged() {
		return !this.mergedWithTypes.isEmpty();
	}
	
	public void setInlined(boolean inlined) {
		this.inlined = inlined;
	}
	@Override
	public String toString() {
		return this.messagePart.getName();
	}

	public String getName() {
		return this.messagePart.getName();
	}
}
