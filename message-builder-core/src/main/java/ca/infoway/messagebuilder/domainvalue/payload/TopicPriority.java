package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum TopicPriority.
 */
public class TopicPriority extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.TopicPriority, Describable {

	private static final long serialVersionUID = 4476190535780761850L;
	
	public static final TopicPriority NL_MANDATORY = new TopicPriority("NL_MANDATORY", "NL_MAND"); 
	public static final TopicPriority GROUP_MANDATORY = new TopicPriority("GROUP_MANDATORY", "GROUP_MAND"); 
	public static final TopicPriority OPTIONAL = new TopicPriority("OPTIONAL", "OPTIONAL");

	private final String codeValue;

	private TopicPriority(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;

	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.TOPIC_PRIORITY.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
