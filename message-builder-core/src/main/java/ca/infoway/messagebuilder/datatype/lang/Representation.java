package ca.infoway.messagebuilder.datatype.lang;

/**
 * <p>An enum for interval representations. Some apply only to periodic intervals.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public enum Representation {

	// if adding interfaces or behaviour to this enum, please consider using enum pattern for translation purposes

	HIGH, 
	LOW, 
	CENTRE, 
	WIDTH, 
	LOW_HIGH, 
	LOW_WIDTH, 
	LOW_CENTER, 
	WIDTH_HIGH, 
	CENTRE_WIDTH, 
	CENTRE_HIGH,
	SIMPLE,
	
	// These representations are used in Periodic Interval
	
	// TOOD: BCH: seperate these into another enum
	PERIOD, 
	PHASE, 
	FREQUENCY,
	PERIOD_PHASE
}
