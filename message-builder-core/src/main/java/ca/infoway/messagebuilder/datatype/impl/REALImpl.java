package ca.infoway.messagebuilder.datatype.impl;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype used for real numbers. Backed by a java BigDecimal.
 *
 * <p>Covers the following Hl7 datatypes:
 * 
 * <p>REAL.COORD: A real number intended for use in conveying geographic coordinate values
 * 
 * <p>REAL.CONF: A real number intended for use in conveying confidence level values in registries 
 *            NOTE: As of R02.04.02, this datatype flavor is also used for expressing percentages. 
 *            It is expected that the flavor name may change in a future release. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class REALImpl extends QTYImpl<BigDecimal> implements REAL {

	/**
	 * <p>Constructs an empty REAL.
	 */
	public REALImpl() {
		this((BigDecimal) null);
	}

	/**
	 * <p>Constructs a REAL using the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public REALImpl(BigDecimal defaultValue) {
		super(BigDecimal.class, defaultValue, null, StandardDataType.REAL);
	}

	/**
	 * <p>Constructs a REAL with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public REALImpl(NullFlavor nullFlavor) {
		super(BigDecimal.class, null, nullFlavor, StandardDataType.REAL);
	}
	
}
