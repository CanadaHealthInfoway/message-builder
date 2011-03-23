package ca.infoway.messagebuilder.datatype.impl;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype CD. Backed by a Code.
 * 
 * <p>A CD represents any kind of concept usually by giving a code defined in a
 * code system. A CD can contain the original text or phrase that served as the
 * basis of the coding and one or more translations into different coding
 * systems. A CD can also contain qualifiers to describe, e.g., the concept of a
 * "left foot" as a postcoordinated term built from the primary code "FOOT" and
 * the qualifier "LEFT". In cases of an exceptional value, the CD need not
 * contain a code but only the original text describing that concept.
 * 
 * <p>CD is mostly used in one of its restricted or "profiled" forms, CS, CE, CV.
 * Use of the full concept descriptor data type is not common. It requires a
 * conscious decision and documented rationale. In all other cases, one of the
 * CD restrictions shall be used.
 * 
 * <p>All CD restrictions constrain certain properties. Properties may be
 * constrained to the extent that only one value may be allowed for that
 * property, in which case mentioning the property becomes redundant.
 * Constraining a property to one value is referred to as suppressing that
 * property. Although, conceptually a suppressed property is still semantically
 * applicable, it is safe for an HL7 interface to assume the implicit default
 * value without testing.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying code type.
 * @sharpen.ignore - datatype - translated manually 
 */
public class CDImpl extends ANYImpl<Code> implements CD {
	
	private static final long serialVersionUID = 1152929036065255121L;

	private String displayName;
	private final List<CD> translations = new ArrayList<CD>();
	private String originalText;
	
	/**
	 * <p>Constructs an empty CD.
	 */
	public CDImpl() {
		this((Code) null);
	}

	/**
	 * <p>Constructs a CD with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public CDImpl(Code defaultValue) {
		this(defaultValue, null, StandardDataType.CD);
	}

	/**
	 * <p>Constructs a CD with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public CDImpl(NullFlavor nullFlavor) {
		this(null, nullFlavor, StandardDataType.CD);
	}

	/**
	 * <p>Constructs a CD using the supplied parameters.
	 * 
	 * @param value a value
	 * @param nullFlavor a  null flavor
	 * @param dataType an HL7 datatype
	 */
	public CDImpl(Code value, NullFlavor nullFlavor, StandardDataType dataType) {
		super(null, value, nullFlavor, dataType);
	}

	/**
	 * <p>Returns the display name.
	 * 
	 * @return the display name
	 */
	public String getDisplayName() {
		return this.displayName;
	}
	
	/**
	 * <p>Sets the display name.
	 * 
	 * @param displayName the display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * <p>Returns the translations for this CD.
	 * 
	 * @return the translations for this CD
	 */
	public List<CD> getTranslations() {
		return this.translations;
	}

	/**
	 * <p>Returns the original text.
	 * 
	 * @return the original text
	 */
	public String getOriginalText() {
		return originalText;
	}

	/**
	 * <p>Sets the original text.
	 * 
	 * @param originalText the original text
	 */
	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}
	
}
