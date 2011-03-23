package ca.infoway.messagebuilder.generator;

import ca.infoway.messagebuilder.generator.util.Namespace;

public class XsdDataType {
	
	private final String name;
	private final String prefix;
	private final String namespace;

	XsdDataType(String name, Namespace namespace) {
		this(name, namespace.getPrefix(), namespace.getNamespace());
	}
	XsdDataType(String name, String prefix, String namespace) {
		this.name = name;
		this.prefix = prefix;
		this.namespace = namespace;
	}

	public String getName() {
		return this.name;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public String getNamespace() {
		return this.namespace;
	}
	public String getQualifiedName() {
		return this.prefix + ":" + this.name;
	}
}
