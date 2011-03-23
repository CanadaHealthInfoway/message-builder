package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum RoleClass.
 */
public class RoleClass extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.RoleClass, Describable {
	
	private static final long serialVersionUID = -4129204171430176848L;

	public static final RoleClass ROLE = new RoleClass("ROLE", "ROL");
	
	private final String codeValue;

	private RoleClass(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ROLE_CLASS.getRoot();
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
