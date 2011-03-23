package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum AdministrativeGender. The gender of a person used for adminstrative purposes (as opposed to clinical gender).
 */
public class AdministrativeGender extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.AdministrativeGender, Describable {

	private static final long serialVersionUID = 1376436588630112644L;
	
	public static final AdministrativeGender FEMALE = new AdministrativeGender("FEMALE", "F"); 
	public static final AdministrativeGender MALE = new AdministrativeGender("MALE", "M");
	public static final AdministrativeGender UNDIFFERENTIATED = new AdministrativeGender("UNDIFFERENTIATED", "UN");

	private final String codeValue;

	private AdministrativeGender(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;

	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot();
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
