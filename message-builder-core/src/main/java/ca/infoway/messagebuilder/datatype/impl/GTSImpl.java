package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>The Hl7 Datatype for GTS (GTS.BOUNDEDPIVL). Backed by the javav datatype GeneralTimingSpecification.
 * 
 * <p>This data type is used to convey two pieces of information: The overall time-period 
 * when something occurred (or is to occur), as well as how often it should/did occur 
 * within that time-period
 *   
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class GTSImpl extends ANYImpl<GeneralTimingSpecification> implements GTS {

	private static final long serialVersionUID = 7489472889923569303L;

	/**
	 * <p>Constructs an empty GTS.
	 */
	public GTSImpl() {
		this((GeneralTimingSpecification) null);
	}

	/**
	 * <p>Constructs a GTS with the supplied value.
	 * 
	 * @param defaultValue the initial value
	 */
	public GTSImpl(GeneralTimingSpecification defaultValue) {
		super(GeneralTimingSpecification.class, defaultValue, null, StandardDataType.GTS);
	}

	/**
	 * <p>Constructs a GTS with a given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public GTSImpl(NullFlavor nullFlavor) {
		super(GeneralTimingSpecification.class, null, nullFlavor, StandardDataType.GTS);
	}
	
}
