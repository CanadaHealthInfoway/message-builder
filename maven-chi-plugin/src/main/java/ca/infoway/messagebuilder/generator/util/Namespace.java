package ca.infoway.messagebuilder.generator.util;

/**
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class Namespace {

	private final String prefix;
	private final String namespace;

	public Namespace(String prefix, String namespace) {
		this.prefix = prefix;
		this.namespace = namespace;
	}

	public String getNamespace() {
		return this.namespace;
	}

	public String getPrefix() {
		return this.prefix;
	}
}