package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum IssueFilterCode. Indicates how result sets should be 
 * filtered based on whether they have associated unmanaged or persistent issues.
 */
public class IssueFilterCode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.IssueFilterCode, Describable {
	
	private static final long serialVersionUID = -4833350276910420958L;
	
	public static final IssueFilterCode ALL = new IssueFilterCode("ALL", "A");
	public static final IssueFilterCode WITH_ISSUES = new IssueFilterCode("WITH_ISSUES", "I"); 
	public static final IssueFilterCode WITH_UNMANAGED_ISSUES = new IssueFilterCode("WITH_UNMANAGED_ISSUES", "U");

	private final String codeValue;
	
	private IssueFilterCode(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_QUERY_PARAMETER_VALUE.getRoot();
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
