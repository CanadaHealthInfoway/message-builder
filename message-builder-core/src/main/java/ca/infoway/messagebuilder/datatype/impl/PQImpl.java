package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * <p>A class to represent CeRx's notion of a physical quantity. Backed by the java datatype PhysicalQuantity.
 *
 * <p>There are two attributes of note: value (amount) and unit.
 * 
 * <p>The HL7 version of this class relies on the HL7 REAL, which is a
 * re-implemented BigDecimal for all intents and purposes.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @see <a href="http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PQ">The HL7 Definition</a>
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class PQImpl extends QTYImpl<PhysicalQuantity> implements PQ {

	private static final long serialVersionUID = -2930296884400958056L;

	/**
	 * <p>Constructs an empty PQ.
	 */
	public PQImpl() {
		this((PhysicalQuantity) null);
	}

	/**
	 * <p>Constructs a PQ with the given PhysicalQuantity.
	 * 
	 * @param defaultValue the initial value
	 */
	public PQImpl(PhysicalQuantity defaultValue) {
		super(PhysicalQuantity.class, defaultValue, null, StandardDataType.PQ);
	}

	/**
	 * <p>Constructs a PQ with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public PQImpl(NullFlavor nullFlavor) {
		super(PhysicalQuantity.class, null, nullFlavor, StandardDataType.PQ);
	}

}
