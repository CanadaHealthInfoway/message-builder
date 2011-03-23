package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Codes representing the defined possible Normal states of an Role, as defined by the Role 
 * class state machine.
 * 
 * <p>Differentiates whether the role is active, suspended or terminated
 * 
 * @author BC Holmes
 */
public class RoleStatusNormal extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.RoleStatusNormal, Describable {
	
	private static final long serialVersionUID = -8503517204278317948L;

	/**
	 * The state representing the fact that the Entity is currently active in the Role.
	 */
	public static final RoleStatusNormal ACTIVE = new RoleStatusNormal("ACTIVE");
	
	/**
	 * The state that represents a suspension of the Entity playing the Role. 
	 * This state is arrived at from the "active" state.
	 */
	public static final RoleStatusNormal SUSPENDED = new RoleStatusNormal("SUSPENDED");
	
	/**
	 * The state representing the successful termination of the Role.
	 */
	public static final RoleStatusNormal TERMINATED = new RoleStatusNormal("TERMINATED");

	private RoleStatusNormal(String name) {
		super(name);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ROLE_STATUS.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		// another unusual case where the code value is in lower case
		return name().toLowerCase();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}

}
