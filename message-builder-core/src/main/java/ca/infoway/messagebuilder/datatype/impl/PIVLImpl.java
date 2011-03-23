package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Periodic Interval of Time (PIVL) specializes SXCM. Back by java datatype PeriodicIntervalTime.
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PIVL
 * 
 * <p>Definition: An interval of time that recurs periodically. Periodic intervals
 * have two properties, phase and period. The phase specifies the "interval
 * prototype" that is repeated every period.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class PIVLImpl extends ANYImpl<PeriodicIntervalTime> implements PIVL {

	private static final long serialVersionUID = 159190145107996467L;

	/**
	 * <p>Constructs an empty PIVL.
	 */
	public PIVLImpl() {
		this((PeriodicIntervalTime) null);
	}

	/**
	 * <p>Constructs a PIVL with the supplied value.
	 * 
	 * @param defaultValue initial value
	 */
	public PIVLImpl(PeriodicIntervalTime defaultValue) {
		super(PeriodicIntervalTime.class, defaultValue, null, StandardDataType.PIVL_TS_DATETIME);
	}

	/**
	 * <p>Constructs a PIVL with the supplied null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public PIVLImpl(NullFlavor nullFlavor) {
		super(PeriodicIntervalTime.class, null, nullFlavor, StandardDataType.PIVL_TS_DATETIME);
	}
	
}
