package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum Confidentiality.
 * 
 * A limited set of confidentiality codes, limited to 'normal' and 'restricted'
 * 
 */
public class Confidentiality extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind, x_BasicConfidentialityKind, x_NormalRestrictedTabooConfidentialityKind, Describable {
	
	private static final long serialVersionUID = 7559834755963615602L;
	
	public static final Confidentiality NORMAL = new Confidentiality("NORMAL", "N");
	public static final Confidentiality RESTRICTED = new Confidentiality("RESTRICTED", "R");

    private final String codeValue;

    private Confidentiality(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot();
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
