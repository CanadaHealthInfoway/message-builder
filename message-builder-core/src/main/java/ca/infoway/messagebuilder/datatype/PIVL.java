package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;

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
public interface PIVL extends ANY<PeriodicIntervalTime>  {

	 // Decided to not have interface extend SET. Now extends ANY.
	
}
